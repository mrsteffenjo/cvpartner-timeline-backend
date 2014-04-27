package no.webstep.fagweekend.cvpartner.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProjectExperience {
	@JsonProperty
	public String customer;
	
	@JsonProperty
	public String customer_description;
	
	@JsonProperty
	public String description;
	
	@JsonProperty
	public String industry;
	
	@JsonProperty
	public String month_from;
	
	@JsonProperty
	public String month_to;
	
	@JsonProperty
	public String year_from;
	
	@JsonProperty
	public String year_to;
	
	/**
	"_id": "530f2db12f274fed840004e7",
    "customer": "Telenor",
    "customer_description": "Telenor Norge er landets st�rste leverand�r av tele- og datatjenester. \nVia sitt mobilnett og fastnett leverer de tjenester innen telefoni, bredb�nd og kabel-tv til privat- og bedriftskunder over hele landet. \nDe selger ogs� tjenester til andre telekom-operat�rer.",
    "customer_value_proposition": null,
    "description": "Order Management System",
    "disabled": false,
    "exclude_tags": null,
    "expected_roll_off_date": null,
    "industry": "Telecom",
    "int_customer": null,
    "int_customer_description": null,
    "int_customer_value_proposition": null,
    "int_description": null,
    "int_industry": null,
    "int_long_description": null,
    "int_month_from": null,
    "int_month_to": null,
    "int_related_work_experience_id": null,
    "int_tags": null,
    "int_year_from": null,
    "int_year_to": null,
    "local_customer": "Telenor",
    "local_customer_description": "Telenor Norge er landets st�rste leverand�r av tele- og datatjenester. \nVia sitt mobilnett og fastnett leverer de tjenester innen telefoni, bredb�nd og kabel-tv til privat- og bedriftskunder over hele landet. \nDe selger ogs� tjenester til andre telekom-operat�rer.",
    "local_customer_value_proposition": null,
    "local_description": "Order Management System",
    "local_industry": "Telecom",
    "local_long_description": "Telenor OMS (Order Management System) er et stort Java Enterprise prosjekt som inkluderer integrasjoner mot 52 unike systemer som skal styres og oppdateres i l�p av en ordrebestillings livssyklus.",
    "local_month_from": null,
    "local_month_to": null,
    "local_related_work_experience_id": "530f2d3b2f274fc3cb0004bf",
    "local_tags": [
        "Java EE",
        "IMB WebSphere MQ",
        "CruiseControl",
        "Subversion",
        "LoadRunner",
        "HP TestDirector",
        "Maven",
        "UML"
    ],
    "local_year_from": "2007",
    "local_year_to": "2008",
    "long_description": "Telenor OMS (Order Management System) er et stort Java Enterprise prosjekt som inkluderer integrasjoner mot 52 unike systemer som skal styres og oppdateres i l�p av en ordrebestillings livssyklus.",
    "modifier_id": null,
    "month_from": null,
    "month_to": null,
    "order": 9,
    "related_work_experience_id": "530f2d3b2f274fc3cb0004bf",
    "roles": [
        {
            "_id": "530f2db22f274f1dc20004d0",
            "disabled": false,
            "int_long_description": null,
            "int_name": null,
            "local_long_description": null,
            "local_name": "Systemutvikler",
            "long_description": null,
            "modifier_id": null,
            "name": "Systemutvikler",
            "order": 1,
            "starred": false,
            "version": 2
        },
        {
            "_id": "530f2e422f274fbe910004a9",
            "disabled": false,
            "int_long_description": null,
            "int_name": null,
            "local_long_description": null,
            "local_name": "Analytiker",
            "long_description": null,
            "modifier_id": null,
            "name": "Analytiker",
            "order": 0,
            "starred": false,
            "version": 2
        }
    ],
    "starred": false,
    "tags": [
        "Java EE",
        "IMB WebSphere MQ",
        "CruiseControl",
        "Subversion",
        "LoadRunner",
        "HP TestDirector",
        "Maven",
        "UML"
    ],
    "version": 17,
    "year_from": "2007",
    "year_to": "2008"
    **/
}
