package me.vukas;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import cucumber.api.Transform;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import me.vukas.domain.Key;
import me.vukas.domain.Market;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

/**
 * Name steps per domain concept in order to share steps in different scenarios.
 * Cucumber should probably have only rest-integration tests, and private Market below should
 * be left for unit testing
 */

/**
 * @Transform repetition could be replaced with Cucumber Expressions
 * parameterTypeRegistry.defineParameterType(new ParameterType<>(...
 */
@ContextConfiguration(classes = { ProgramConfig.class, TestProgramConfig.class })
@WebMvcTest(MarketController.class)
public class MarketSteps {

	@Autowired
	private MockMvc mockMvc;

	private Market market;

	@Given("^I have market with (\\d+)$")
	public void iHaveMarketWithCurrentKey(int currentKey) throws Throwable {
		this.mockMvc
				.perform(post("/market/createMarket/{0}", currentKey))
				.andExpect(status().isCreated());
	}

	@When("^it is increased using some (\\d+)$")
	public void itIsIncreasedToIncrement(int keyIncrement) throws Throwable {
		this.mockMvc
				.perform(post("/market/incrementKey/{0}", keyIncrement))
				.andExpect(status().isOk());
	}

	@Then("^market should have (\\d+)$")
	public void changeShouldBeMadeToNewKey(int newKey) throws Throwable {
		this.mockMvc
				.perform(get("/market/1"))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(jsonPath("$.key.value").value(newKey));
	}

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
