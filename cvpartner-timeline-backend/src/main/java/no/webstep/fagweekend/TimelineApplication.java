package no.webstep.fagweekend;

import io.dropwizard.Application;
import io.dropwizard.client.JerseyClientBuilder;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import com.sun.jersey.api.client.Client;

public class TimelineApplication extends Application<TimelineConfiguration> {
	public static void main(String[] args) throws Exception {
		new TimelineApplication().run(args);
	}

	@Override
	public String getName() {
		return "timeline";
	}

	@Override
	public void initialize(Bootstrap<TimelineConfiguration> bootstrap) {
		// nothing to do yet
	}

	@Override
	public void run(TimelineConfiguration configuration, Environment environment) {
	    final Client client = new JerseyClientBuilder(environment)
            .using(configuration.jerseyClient)
            .using(environment)
            .build("cv-partner");
	    CvPartnerClient cvPartnerClient = new CvPartnerClient(client, configuration);
	    final TimelineResource resource = new TimelineResource(cvPartnerClient);
		    environment.jersey().register(resource);

		
	}

}
