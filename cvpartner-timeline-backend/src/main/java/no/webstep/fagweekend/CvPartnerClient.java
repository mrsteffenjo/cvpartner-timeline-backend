package no.webstep.fagweekend;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.core.MediaType;

import no.webstep.fagweekend.cvpartner.model.Cv;
import no.webstep.fagweekend.cvpartner.model.User;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource.Builder;

public class CvPartnerClient {

	private final Client client;
	private final TimelineConfiguration config;
	private Map<String, User> cachedUsers;
	private Map<String, Cv> cachedCvs;

	public CvPartnerClient(Client client, TimelineConfiguration config) {
		super();
		this.client = client;
		this.config = config;
		this.cachedUsers = new HashMap<>();
		this.cachedCvs = new HashMap<>();
	}

	User userTimeline(String emailAddress, Boolean reload) {
		User user = findUser(emailAddress, reload);
		return user;
	}

	User findUser(String emailAddress, Boolean reload) {
		User user = cachedUsers.get(emailAddress);
		if (user == null || (reload != null && reload)) {
			try {
				URI baseUri = config.apiUrl.toURI();
				URI usersUri = baseUri.resolve("users");
				Builder req = createBuilder(usersUri);

				User[] usersList = req.get(User[].class);
				for (User newUser : usersList) {
					cachedUsers.put(newUser.email, newUser);
				}
				user = cachedUsers.get(emailAddress);
			} catch (URISyntaxException e) {
				return null;
			}
		}
		return user;
	}

	Cv findUserCv(String userId, String cvId, Boolean reload){
		String key = userId+":"+cvId;
		Cv cv = cachedCvs.get(key);
		if (cv == null || (reload != null && reload)) {
			try {
				URI baseUri = config.apiUrl.toURI();
				URI usersUri = baseUri.resolve("cvs/" + userId + "/" + cvId);
				Builder req = createBuilder(usersUri);
				cachedCvs.put(key, req.get(Cv.class));
				cv = cachedCvs.get(key);
			} catch (URISyntaxException e) {
				return null;
			}
		}
		
		return cv;
	}

	private Builder createBuilder(URI actionUri) {
		return client
				.resource(actionUri)
				.accept(MediaType.APPLICATION_JSON)
				.header("Authorization",
						String.format("Token token=\"%s\"", config.token));
	}
}
