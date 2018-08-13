package me.vukas;

import java.util.List;

import ctrl.lcoo.market.Line;
import ctrl.lcoo.market.MarketId;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SingleLineMarketSteps {

	private List<String> marketIds;

	private Line<MarketId> market;

	@Given("^market description that we receive from external source with following details:$")
	public void specifyMarket(List<String> marketIds) {
		this.marketIds = marketIds;
	}

	@And("^following probabilities$")
	public void specifyProbabilities(DataTable table) {

	}

	@When("^we import that market description into this bounded context$")
	public void importMarket() {
		//init it here in 1 step from some data structure

	}

	@Then("^imported market should have all properties set correctly$")
	public void checkIfSetCorrectly() {

	}
}
