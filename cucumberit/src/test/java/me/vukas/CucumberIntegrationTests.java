package me.vukas;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "json:target/cucumber.json", "pretty" }, features = "src/test/resources/features")
public class CucumberIntegrationTests {}
