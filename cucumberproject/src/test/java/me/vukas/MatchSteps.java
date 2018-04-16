package me.vukas;

import static org.assertj.core.api.Assertions.assertThat;

import cucumber.api.Transform;
import cucumber.api.java.en.Then;
import me.vukas.domain.Key;

import org.springframework.beans.factory.annotation.Autowired;


public class MatchSteps extends SpringSteps {

	@Autowired
	private Configuration configuration;

	@Autowired
	private Match match;

	@Then("^Match updated key to (\\d+)$")
	public void matchIsUpdatedTo(@Transform(KeyTransformer.class) Key key) {
		//lets see if we have here params set in ConfigurationSteps class shared?
		assertThat(this.configuration.getKey()).isEqualTo(key);
		assertThat(this.match.getId()).isEqualTo(0);
	}



}
