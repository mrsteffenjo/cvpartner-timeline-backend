package no.webstep.fagweekend;

import java.net.URI;

import io.dropwizard.Configuration;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.hibernate.validator.constraints.NotEmpty;

public class TimelineConfiguration extends Configuration {

	@JsonProperty
	@NotEmpty
	URI apiUrl;
	
	@JsonProperty
	@NotEmpty
	String token;
	
}
