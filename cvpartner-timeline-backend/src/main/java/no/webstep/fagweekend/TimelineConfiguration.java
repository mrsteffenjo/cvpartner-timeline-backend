package no.webstep.fagweekend;

import java.net.URL;

import javax.validation.constraints.NotNull;

import io.dropwizard.Configuration;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.hibernate.validator.constraints.NotEmpty;

public class TimelineConfiguration extends Configuration {

	@JsonProperty
	@NotNull
	URL apiUrl;
	
	@JsonProperty
	@NotEmpty
	String token;
	
}
