package no.webstep.fagweekend.api.model;

import java.util.Date;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Segment {
	@JsonProperty
	public String label;
	@JsonProperty
	public Date start;
	@JsonProperty
	public Date end;
	@JsonProperty
	public String image;
	@JsonProperty
	public Map<String, String> data;
}
