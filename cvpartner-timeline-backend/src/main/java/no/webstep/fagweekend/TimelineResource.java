package no.webstep.fagweekend;

import java.net.URISyntaxException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
import no.webstep.fagweekend.cvpartner.model.ProjectExperience;
import no.webstep.fagweekend.cvpartner.model.User;

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
    public Timeline getUserTimeline(@QueryParam("user") Optional<String> id, @QueryParam("reload") Optional<Boolean> reload) {
    	User user = cvPartnerClient.findUser(id.get(), reload.or(false));
        Cv userCv = cvPartnerClient.findUserCv(user.constructId, user.defaultCvId, reload.or(false));
        
        List<Segment> segments = new ArrayList<>();
        for(ProjectExperience pe : userCv.projectExperiences){
        	Segment segment = new Segment();
        	segment.label = pe.customer;
        	
        	
        	// TODO FIX times
        	try{
        		
	        	int fromYear = Integer.parseInt(pe.year_from);
	        	int toYear = Integer.parseInt(pe.year_to);
	        	int fromMonth = Integer.parseInt(pe.month_from);
	        	int toMonth = Integer.parseInt(pe.month_to);
	        	Calendar from = Calendar.getInstance();
	        	from.set(fromYear, fromMonth, 1);
	        	Calendar to = Calendar.getInstance();
	        	to.set(toYear, toMonth, 1);
	        	
	        	segment.start = from.getTime();
	        	segment.end = to.getTime();
        	}catch(NumberFormatException nfe){
        		continue;
        	}
        	
        	segment.image = userCv.image.url;
        	
        	Map<String,String> segmentData = new HashMap<>();
        	segmentData.put("Foo", "Bar");
        	segments.add(segment);
        }
        
        
        Timeline t = new Timeline();
        t.userId = user.email;
        t.fullName = user.name;
        t.segments = segments;
        
        return t;
    }
}