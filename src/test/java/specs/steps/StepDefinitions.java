package specs.steps;

import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.runtime.PendingException;

public class StepDefinitions {
	@Given("^my name is \"([^\"]*)\"$")
	public void my_name_is(String arg1) {
	    // Express the Regexp above with the code you wish you had
	    throw new PendingException();
	}

	@When("^I join the poker house$")
	public void I_join_the_poker_house() {
	    // Express the Regexp above with the code you wish you had
	    throw new PendingException();
	}

	@Then("^I am known as \"([^\"]*)\"$")
	public void I_am_known_as(String arg1) {
	    // Express the Regexp above with the code you wish you had
	    throw new PendingException();
	}
}
