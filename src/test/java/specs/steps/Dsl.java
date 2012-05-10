package specs.steps;

import java.net.URI;

import org.springframework.web.client.RestTemplate;

public class Dsl {

	public static void registerNick(String nick) {
		RestTemplate template = new RestTemplate();
		String uriBase = "http://dojo.v.wc1.atti.com/";
		String createPlayer = "players?nick={nick}";
		String uri = uriBase + createPlayer;
	
		URI location = template.postForLocation(uri, null, nick);
	}

}
