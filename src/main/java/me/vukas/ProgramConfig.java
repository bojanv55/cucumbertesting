package me.vukas;

import java.util.Arrays;

import me.vukas.domain.Key;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paranamer.ParanamerModule;

@Configuration
public class ProgramConfig {
	@Bean
	public MarketService marketService(){
		return new MarketServiceImpl();
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
