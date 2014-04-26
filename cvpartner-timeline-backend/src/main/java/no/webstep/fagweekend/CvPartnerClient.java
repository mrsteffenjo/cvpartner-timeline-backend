package no.webstep.fagweekend;

import java.net.URI;
import java.net.URISyntaxException;

import javax.ws.rs.core.MediaType;

import no.webstep.fagweekend.cvpartner.model.Cv;
import no.webstep.fagweekend.cvpartner.model.User;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource.Builder;

public class CvPartnerClient {
    
    private final Client client;
    private final TimelineConfiguration config;
    
    public CvPartnerClient(Client client, TimelineConfiguration config) {
        super();
        this.client = client;
        this.config = config;
    }

    User userTimeline(String emailAddress) throws URISyntaxException {
        User user = findUser(emailAddress);
        return user;
    }
    
    User findUser(String emailAddress) throws URISyntaxException {
        URI baseUri = config.apiUrl.toURI();
        URI usersUri = baseUri.resolve("users");
        Builder req = createBuilder(usersUri);
        
        User[] usersList = req.get(User[].class);
        for (User user : usersList) {
            String userEmail = user.email;
            if (emailAddress.equals(userEmail)) {
                return user;
            }
        }
        
        return null;
    }
    
    Cv findUserCv(String userId, String cvId) throws URISyntaxException{
    	URI baseUri = config.apiUrl.toURI();
        URI usersUri = baseUri.resolve("cvs/"+userId+"/"+cvId);
        Builder req = createBuilder(usersUri);
        
        return req.get(Cv.class);
    }
    
    private Builder createBuilder(URI actionUri){
    	return client.resource(actionUri)
        .accept(MediaType.APPLICATION_JSON)
        .header("Authorization", String.format("Token token=\"%s\"", config.token));
    }
}
