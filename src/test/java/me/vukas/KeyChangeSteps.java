package me.vukas;

import static org.assertj.core.api.Assertions.assertThat;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class KeyChangeSteps {

	private Market market;

	@Given("^the key of market is (\\d+)$")
	public void theKeyOfMarketIs(int currentKey) throws Throwable {
		this.market = new Market(currentKey);
	}

	@When("^I increase market key for (\\d+)$")
	public void iIncreaseMarketKeyFor(int keyIncrement) throws Throwable {
		this.market.incrementKey(keyIncrement);
	}

	@Then("^new market key should be (\\d+)$")
	public void newMarketKeyShouldBe(int newKey) throws Throwable {
		assertThat(this.market.getKey()).isEqualTo(newKey);
	}
}
