package no.webstep.fagweekend.cvpartner.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Qualification {
	public String _id;
	public Boolean disabled;
	public String int_long_description;
	public String int_tag_line;
	public String local_long_description;
	public String local_tag_line;
	public String long_description;
	public String modifier_id;
	public Integer order;
	public Boolean starred;
	public String tag_line;
	public Integer version;
}
