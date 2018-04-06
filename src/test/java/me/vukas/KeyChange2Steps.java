package me.vukas;

import static org.assertj.core.api.Assertions.assertThat;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class KeyChange2Steps {

	private Market market;

	@Given("^I have market with key (\\d+)$")
	public void iHaveMarketWithCurrentKey(int currentKey) throws Throwable {
		this.market = new Market(currentKey);
	}

	@When("^it is increased to (\\d+)$")
	public void itIsIncreasedToIncrement(int keyIncrement) throws Throwable {
		this.market.incrementKey(keyIncrement);
	}

	@Then("^change should be made to (\\d+)$")
	public void changeShouldBeMadeToNewKey(int newKey) throws Throwable {
		assertThat(this.market.getKey()).isEqualTo(newKey);
	}
}
