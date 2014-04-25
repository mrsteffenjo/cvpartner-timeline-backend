package no.webstep.fagweekend;

import io.dropwizard.Configuration;
import io.dropwizard.client.JerseyClientConfiguration;

import java.net.URL;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TimelineConfiguration extends Configuration {

	@JsonProperty
	@NotNull
	URL apiUrl;

	@JsonProperty
	@NotEmpty
	String token;

	@Valid
	@NotNull
	@JsonProperty
	JerseyClientConfiguration jerseyClient = new JerseyClientConfiguration();

}
