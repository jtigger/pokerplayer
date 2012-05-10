package specs.steps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

import java.net.URI;


import org.springframework.web.client.RestTemplate;

import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.runtime.PendingException;

public class StepDefinitions {
	String _nick;
	
	@Given("^my nick is \"([^\"]*)\"$")
	public void my_nick_is(String nick) {
		this._nick = nick;
	}

	@When("^I join the poker house$")
	public void I_join_the_poker_house() {
		Dsl.registerNick(_nick);
	}

	@Then("^I am known as \"([^\"]*)\"$")
	public void I_am_known_as(String expectedNick) {
		RestTemplate template = new RestTemplate();
		String uriBase = "http://dojo.v.wc1.atti.com/";
		String fetchPlayer = "players/{nick}" ;
		String uri = uriBase + fetchPlayer;

		String result = template.getForObject(uri, String.class, expectedNick);
		
		assertThat(result, containsString(expectedNick));
	}
	
	@Given("^I have registered as \"([^\"]*)\"$")
	public void I_have_registered_as(String nick) {
		_nick = nick;
		Dsl.registerNick(nick);
	}

	@When("^I sit down at a table$")
	public void I_sit_down_at_a_table() {
		RestTemplate template = new RestTemplate();
		String uriBase = "http://dojo.v.wc1.atti.com/";
		String sitAtTable = "/tables?nick={nick}";
		String uri = uriBase + sitAtTable;
	
		URI location = template.postForLocation(uri, null, _nick);
		
	}

	@Then("^I am sitting at that table$")
	public void I_am_sitting_at_that_table() {
		String expectedNick = _nick;
		RestTemplate template = new RestTemplate();
		String uriBase = "http://dojo.v.wc1.atti.com/";
		String fetchPlayer = "players/{nick}" ;
		String uri = uriBase + fetchPlayer;

		String result = template.getForObject(uri, String.class, expectedNick);
		
		assertThat(result, containsString(expectedNick));
	}
}
