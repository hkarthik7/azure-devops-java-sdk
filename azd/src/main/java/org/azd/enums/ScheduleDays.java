package org.azd.enums;
/**
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
**/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * None 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public enum ScheduleDays {
	/**
 	* Scheduled on all the days in week. 
	**/
	@JsonProperty("all")
	ALL,
	/**
 	* Scheduled on Friday. 
	**/
	@JsonProperty("friday")
	FRIDAY,
	/**
 	* Scheduled on Monday. 
	**/
	@JsonProperty("monday")
	MONDAY,
	/**
 	* Scheduled day not set. 
	**/
	@JsonProperty("none")
	NONE,
	/**
 	* Scheduled on Saturday. 
	**/
	@JsonProperty("saturday")
	SATURDAY,
	/**
 	* Scheduled on Sunday. 
	**/
	@JsonProperty("sunday")
	SUNDAY,
	/**
 	* Scheduled on Thursday. 
	**/
	@JsonProperty("thursday")
	THURSDAY,
	/**
 	* Scheduled on Tuesday. 
	**/
	@JsonProperty("tuesday")
	TUESDAY,
	/**
 	* Scheduled on Wednesday. 
	**/
	@JsonProperty("wednesday")
	WEDNESDAY;
}