package no.webstep.fagweekend.cvpartner.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Cv {
	@JsonProperty("_id")
	public String constructId;
	@JsonProperty("born_day")
	public Integer bornDay;
	@JsonProperty("born_month")
	public String bornMonth;
	@JsonProperty("born_year")
	public String bornYear;
	@JsonProperty("bruker_id")
	public String userId;
	@JsonProperty("courses")
	public Course[] courses;
	@JsonProperty("created_at")
	public String createdAt;
	@JsonProperty("default")
	public Boolean defaultCv;
	@JsonProperty("default_international")
	public Boolean defaultInternationalCv;
	@JsonProperty("educations")
	public Education[] educations;
	@JsonProperty("int_nationality")
	public String internationalNationality;
	@JsonProperty("int_place_of_residence")
	public String internationalPlaceOfResidence;
	@JsonProperty("int_title")
	public String internationalTitle;
	@JsonProperty("key_qualifications")
	public Qualification[] keyQualifications;
	@JsonProperty("language_code")
	public String languageCode;
	@JsonProperty("local_nationality")
	public String localNationality;
	@JsonProperty("local_place_of_residence")
	public String localPlaceOfResidence;
	@JsonProperty("local_title")
	public String localTitle;
	@JsonProperty("modifier_id")
	public String modifierId;
	@JsonProperty("nationality")
	public String nationality;
	@JsonProperty("navn")
	public String name;
	@JsonProperty("place_of_residence")
	public String placeOfResidence;
	@JsonIgnoreProperties
	@JsonProperty("project_experiences")
	public ProjectExperience[] projectExperiences;
	@JsonIgnore
	@JsonProperty("technologies")
	public Technology[] technologies;
	@JsonProperty("telefon")
	public String telephone;
	@JsonProperty("tilbud_id")
	public String offerId;
	@JsonProperty("title")
	public String title;
	@JsonProperty("twitter")
	public String twitter;
	@JsonProperty("updated_at")
	public String updatedAt;
	@JsonProperty("version")
	public String version;
	@JsonProperty("work_experiences")
	public WorkExperience[] workExperiences;
	@JsonProperty("email")
	public String email;
	@JsonProperty("country_code")
	public String countryCode;
	@JsonProperty("image")
	public Image image;
	@JsonProperty("can_write")
	public Boolean can_write;
}
