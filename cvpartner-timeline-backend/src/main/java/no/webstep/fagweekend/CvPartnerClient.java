package no.webstep.fagweekend;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource.Builder;

public class CvPartnerClient {
    
    private final Client client;
    private final TimelineConfiguration config;
    
    public CvPartnerClient(Client client, TimelineConfiguration config) {
        super();
        this.client = client;
        this.config = config;
    }

    Object userTimeline(String emailAddress) throws URISyntaxException {
        Object user = findUser(emailAddress);
        return null;
    }
    
    Map<String, Object> findUser(String emailAddress) throws URISyntaxException {
        URI baseUri = config.apiUrl.toURI();
        URI usersUri = baseUri.resolve("users");
        Builder get = client.resource(usersUri)
              .accept(MediaType.APPLICATION_JSON)
              .header("Authorization", String.format("Token token=\"%s\"", config.token));
        List<Map<String, Object>> users = get
              .get(new GenericType(List.class));
        
        for (Map<String, Object> user : users) {
            String userEmail = (String) user.get("emailAddress");
            if (emailAddress.equals(userEmail)) {
                return user;
            }
        }
        
        return null;
    }

}
