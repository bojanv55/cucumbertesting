package me.vukas;

import static org.assertj.core.api.Assertions.assertThat;

import cucumber.api.Transform;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import me.vukas.domain.Key;
import me.vukas.domain.Market;

/**
 * @Transform repetition could be replaced with Cucumber Expressions
 * parameterTypeRegistry.defineParameterType(new ParameterType<>(...
 */
public class KeyChangeSteps {

	private Market market;

	@Given("^the key of market is (\\d+)$")
	public void theKeyOfMarketIs(@Transform(KeyTransformer.class) Key currentKey) {
		this.market = new Market(currentKey);
	}

	@When("^I increase market key for (\\d+)$")
	public void iIncreaseMarketKeyFor(int keyIncrement) {
		this.market.incrementKey(keyIncrement);
	}

	@Then("^new market key should be (\\d+)$")
	public void newMarketKeyShouldBe(@Transform(KeyTransformer.class) Key newKey) {
		assertThat(this.market.getKey()).isEqualTo(newKey);
	}
}
