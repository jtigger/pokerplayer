package specs.steps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.springframework.web.client.RestTemplate;

import com.infosysengr.pokerplayer.Player;
import com.infosysengr.pokerplayer.Table;

import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;

public class StepDefinitions {
	Player currentPlayer;
	String _nick;
	Table table;
	
	@Given("^my nick is \"([^\"]*)\"$")
	public void my_nick_is(String nick) {
		currentPlayer = new Player(nick);
	}

	@When("^I join the poker house$")
	public void I_join_the_poker_house() {
		Dsl.registerNick(currentPlayer.getNick());
	}

	@Then("^I am known as \"([^\"]*)\"$")
	public void I_am_known_as(String expectedNick) {
		Player player;

		player = Dsl.fetchPlayer(expectedNick);
		
		assertThat(player.getNick(), is(expectedNick));
	}

	@Given("^I have registered as \"([^\"]*)\"$")
	public void I_have_registered_as(String nick) {
		currentPlayer = new Player(nick);
		Dsl.registerNick(nick);
	}

	@When("^I sit down at a table$")
	public void I_sit_down_at_a_table() {
		RestTemplate template = new RestTemplate();
				
		String uriBase = "http://dojo.v.wc1.atti.com/";
		String sitAtTable = "/tables?nick={nick}";
		String uri = uriBase + sitAtTable;
	
		table = template.postForObject(uri, null, Table.class, currentPlayer.getNick());
	}
	
	@Then("^I am sitting at that table$")
	public void I_am_sitting_at_that_table() {
		String expectedNick = currentPlayer.getNick();
		
		RestTemplate template = new RestTemplate();
		String uriBase = "http://dojo.v.wc1.atti.com/";
		String fetchTable = "tables/{table_id}" ;
		String uri = uriBase + fetchTable;

		String result = template.getForObject(uri, String.class, table.getTableId());
		
		assertThat(result, is("\"NoGame\""));
	}
}
