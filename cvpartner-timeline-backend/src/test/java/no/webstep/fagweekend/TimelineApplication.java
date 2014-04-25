package no.webstep.fagweekend;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

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
		// nothing to do yet
	}

}
