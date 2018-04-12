package me.vukas;

import java.util.Arrays;

import me.vukas.domain.Key;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paranamer.ParanamerModule;

@Configuration
@EnableJpaRepositories(basePackages = "me.vukas")	//already enabled by spring boot (but not with this package)
public class ProgramConfig {

	private DataSource dataSource;
	private MarketJpaRepo marketJpaRepo;

	public ProgramConfig(DataSource dataSource, MarketJpaRepo marketJpaRepo){
		this.dataSource = dataSource;
		this.marketJpaRepo = marketJpaRepo;
	}

//	@ConfigurationProperties(prefix = "spring.datasource")
//	@Primary
//	@Bean
//	public DataSource dataSource(){
//		return DataSourceBuilder.create().build();
//	}

	@Bean
	public MarketService marketService(){
		return new MarketServiceImpl(marketJdbcRepo(), this.marketJpaRepo);
	}

	@Bean
	public MarketJdbcRepo marketJdbcRepo(){
		return new MarketJdbcRepo(this.dataSource);
	}

	@Bean
	public MarketController marketController(){
		return new MarketController(marketService());
	}

	@Bean
	public StringToKeyConverter stringToKeyConverter(){
		return new StringToKeyConverter();
	}

	@Bean
	public ObjectMapper objectMapper() {
		return Jackson2ObjectMapperBuilder
				.json()
				.mixIn(Key.class, KeyMixin.class)
				.modules(Arrays.asList(new JavaTimeModule(), new ParanamerModule()))
				.build();
	}
}
