package no.webstep.fagweekend.cvpartner.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
	@JsonProperty
	public String name;
	@JsonProperty("user_id")
	public String userId;
	@JsonProperty("_id")
	public String constructId;
	@JsonProperty
	public String id;
	@JsonProperty
	public String email;
	@JsonProperty
	public String role;
	@JsonProperty
	public String office_id;
	@JsonProperty
	public String office_name;
	@JsonProperty
	public String country_id;
	@JsonProperty
	public String country_code;
	@JsonProperty
	public String international_toggle;
	@JsonProperty
	public String preferred_download_format;
	@JsonProperty
	public String[] masterdata_languages;
	@JsonProperty("expand_proposals_toggle")
	public Boolean expandProposalsToggle;
	@JsonProperty("default_cv_id")
	public String defaultCvId;
}
