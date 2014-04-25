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

import no.webstep.fagweekend.model.client.Segment;
import no.webstep.fagweekend.model.client.Timeline;

import com.codahale.metrics.annotation.Timed;
import com.google.common.base.Optional;

@Path("/timeline")
@Produces(MediaType.APPLICATION_JSON)
public class TimelineResource {

    private final CvPartnerClient cvPartnerClient;

    public TimelineResource(CvPartnerClient cvPartnerClient) {
        this.cvPartnerClient = cvPartnerClient;
    }

    @GET
    @Timed
    public Timeline sayHello(@QueryParam("user") Optional<String> user) throws URISyntaxException {
        Object user2 = cvPartnerClient.findUser(user.get());
        SimpleDateFormat df = new SimpleDateFormat("YYYY-mm-ddS");
        
        Segment s1 = new Segment();
        s1.label = "Project X";
        try {
			s1.start = df.parse("2013-02-01");
			s1.end = df.parse("2013-09-01");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        s1.image = "http://www.gameclassification.com/files/games/Project-X.png";
        Map<String,String> s1Data = new HashMap<>();
        s1Data.put("Foo","Bar");
        s1.data = s1Data;
        
        Timeline t = new Timeline();
        t.userId = "jdoe@webstep.no";
        t.fullName = "J. Doe";
        List<Segment> segments = new ArrayList<>();
        segments.add(s1);
        t.segments = segments;
        
        return t;
    }
}