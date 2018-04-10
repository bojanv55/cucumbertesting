package me.vukas;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
}
