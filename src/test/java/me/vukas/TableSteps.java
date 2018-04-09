package me.vukas;

import java.util.ArrayList;
import java.util.List;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TableSteps {

	List<List<String>> board = new ArrayList<>();

	@Given("^table like this$")
	public void tableLikeThis(DataTable table) throws Throwable {
		table.raw().forEach(r -> board.add(new ArrayList<>(r)));
	}

	@When("^player x plays in row (\\d+) column (\\d+)$")
	public void playerXPlaysInRowColumn(int x, int y) throws Throwable {
		board.get(x).set(y, "x");
	}

	@Then("^the board should look like$")
	public void theBoardShouldLookLike(DataTable table) throws Throwable {
		table.diff(board);
	}
}
