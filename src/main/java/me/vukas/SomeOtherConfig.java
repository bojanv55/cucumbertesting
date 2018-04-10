package me.vukas;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SomeOtherConfig {
	@Bean
	public MarketService marketService(){
		return new FakeMarketServiceImpl();
	}

	@Bean
	public MarketController marketController(){
		return new MarketController(marketService());
	}
}
