package no.webstep.fagweekend.model.client;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Timeline {
	@JsonProperty
	public String userId;

	@JsonProperty
	public String fullName;

	@JsonProperty
	public List<Segment> segments;

}