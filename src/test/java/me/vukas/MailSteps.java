package me.vukas;

import static org.assertj.core.api.Assertions.assertThat;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MailSteps {
	@When("^I login to the system$")
	public void iLoginToTheSystem() throws Throwable {

	}

	@Then("^I should receive mail containing:$")
	public void iShouldReceiveMailContaining(String mailContent) throws Throwable {
		assertThat(mailContent).containsIgnoringCase("thanks");
	}

	@And("^I should be logged out automatically$")
	public void iShouldBeLoggedOutAutomatically() throws Throwable {

	}
}
