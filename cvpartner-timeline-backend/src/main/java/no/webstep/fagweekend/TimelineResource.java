package no.webstep.fagweekend;

import java.net.URISyntaxException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import no.webstep.fagweekend.api.model.Segment;
import no.webstep.fagweekend.api.model.Timeline;
import no.webstep.fagweekend.cvpartner.model.Cv;
import no.webstep.fagweekend.cvpartner.model.User;

import com.codahale.metrics.annotation.Timed;
import com.google.common.base.Optional;

@Path("/timeline")
@Produces(MediaType.APPLICATION_JSON)
public class TimelineResource {

    private final CvPartnerClient cvPartnerClient;
    
    private Map<String,User> cachedUsers;

    public TimelineResource(CvPartnerClient cvPartnerClient) {
        this.cvPartnerClient = cvPartnerClient;
        this.cachedUsers = new HashMap<>();
    }

    @GET
    @Timed
    public Timeline getUserTimeline(@QueryParam("user") Optional<String> id, @QueryParam("reload") Optional<Boolean> reload) throws URISyntaxException {
    	User user = cachedUsers.get(id.get());
    	if (user == null || (reload.isPresent() && reload.get())){
    		user = cvPartnerClient.findUser(id.get(), reload.get());
    		cachedUsers.put(id.get(), user);
    	}
        Cv userCv = cvPartnerClient.findUserCv(user.constructId, user.defaultCvId);
        
        
        SimpleDateFormat df = new SimpleDateFormat("YYYY-mm-dd");
        Segment s1 = new Segment();
        s1.label = "Project X";
        try {
			s1.start = df.parse("2013-02-01");
			s1.end = df.parse("2013-09-01");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        s1.image = userCv.image.url;
        Map<String,String> s1Data = new HashMap<>();
        s1Data.put("Foo","Bar");
        s1.data = s1Data;
        
        Timeline t = new Timeline();
        t.userId = user.email;
        t.fullName = user.name;
        List<Segment> segments = new ArrayList<>();
        segments.add(s1);
        t.segments = segments;
        
        return t;
    }
}