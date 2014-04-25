package no.webstep.fagweekend;

import com.google.common.base.Optional;
import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import java.net.URI;
import java.util.concurrent.atomic.AtomicLong;

@Path("/timeline")
@Produces(MediaType.APPLICATION_JSON)
public class TimelineResource {
    private final URI apiUrl;
    private final String token;
    private final AtomicLong counter;

    public TimelineResource(URI apiUrl, String token) {
        this.apiUrl = apiUrl;
        this.token = token;
        this.counter = new AtomicLong();
    }

    @GET
    @Timed
    public String sayHello(@QueryParam("user") Optional<String> user) {
        counter.incrementAndGet();
        return "{}";
    }
}