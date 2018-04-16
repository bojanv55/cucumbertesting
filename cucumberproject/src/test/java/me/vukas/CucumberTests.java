package me.vukas;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "json:target/cucumber.json", "pretty" }, features = "src/test/resources/features")
public class CucumberTests {
}

@TestConfiguration
class cc{
	@Bean
	@Scope("cucumber-glue")	//this bean will be injected once per step execution (eg in Scenario outline as many times as there are examples)
	public Configuration configuration(){
		return new Configuration();
	}
}

@TestConfiguration
class mm{
	@Bean
	@Scope("cucumber-glue")
	public Match match(){
		return new Match();
	}
}
