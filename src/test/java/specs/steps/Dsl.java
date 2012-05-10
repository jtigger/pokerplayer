package specs.steps;

import java.net.URI;

import org.springframework.web.client.RestTemplate;

import com.infosysengr.pokerplayer.Player;

public class Dsl {

	public static void registerNick(String nick) {
		RestTemplate template = new RestTemplate();
		String uriBase = "http://dojo.v.wc1.atti.com/";
		String createPlayer = "players?nick={nick}";
		String uri = uriBase + createPlayer;
	
		URI location = template.postForLocation(uri, null, nick);
	}

	public static Player fetchPlayer(String expectedNick) {
		Player result;
		RestTemplate template = new RestTemplate();
		String uriBase = "http://dojo.v.wc1.atti.com/";
		String fetchPlayer = "players/{nick}" ;
		String uri = uriBase + fetchPlayer;
	
		result = template.getForObject(uri, Player.class, expectedNick);
		return result;
	}

}
