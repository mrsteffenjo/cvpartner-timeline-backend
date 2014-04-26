package no.webstep.fagweekend.cvpartner.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Image {
	@JsonProperty
	public String url;
	@JsonProperty
	public Thumb thumb;
	@JsonProperty("fit_thumb")
	public FitThumb fitThumb;
	@JsonProperty("small_thumb")
	public SmallThumb smallThumb;
}
