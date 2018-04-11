package me.vukas;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

@ContextConfiguration(classes = { ProgramConfig.class })
@WebMvcTest(MarketController.class)
public class KeyChange2Steps {

	@Autowired
	private MockMvc mockMvc;

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
}
