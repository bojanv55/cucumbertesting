package me.vukas;

import static org.assertj.core.api.Assertions.assertThat;

import cucumber.api.Transform;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import me.vukas.domain.Key;

import org.springframework.beans.factory.annotation.Autowired;


public class ConfigurationSteps extends SpringSteps {

	@Autowired
	private Configuration configuration;

	@Given("^Configuration is empty$")
	public void configurationIsEmpty() throws Throwable {
		//init configuration
		assertThat(this.configuration.getKey()).isEqualTo(Key.of(0));
		assertThat(this.configuration.getMatchId()).isEqualTo(0);
	}


	@When("^Configuration changed key for match (\\d+) to (\\d+)$")
	public void configChangeKey(Integer matchId, @Transform(KeyTransformer.class) Key key) {
		this.configuration.setKey(key);
		this.configuration.setMatchId(matchId);
	}

}
