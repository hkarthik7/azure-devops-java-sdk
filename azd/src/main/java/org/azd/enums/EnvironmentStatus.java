package org.azd.enums;
/**
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
**/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Status of release task. 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public enum EnvironmentStatus {
	/**
 	* Environment is in canceled state. 
	**/
	@JsonProperty("canceled")
	CANCELED,
	/**
 	* Environment is in progress state. 
	**/
	@JsonProperty("inProgress")
	INPROGRESS,
	/**
 	* Environment is in not started state. 
	**/
	@JsonProperty("notStarted")
	NOTSTARTED,
	/**
 	* Environment is in partially succeeded state. 
	**/
	@JsonProperty("partiallySucceeded")
	PARTIALLYSUCCEEDED,
	/**
 	* Environment is in queued state. 
	**/
	@JsonProperty("queued")
	QUEUED,
	/**
 	* Environment is in rejected state. 
	**/
	@JsonProperty("rejected")
	REJECTED,
	/**
 	* Environment is in scheduled state. 
	**/
	@JsonProperty("scheduled")
	SCHEDULED,
	/**
 	* Environment is in succeeded state. 
	**/
	@JsonProperty("succeeded")
	SUCCEEDED,
	/**
 	* Environment status not set. 
	**/
	@JsonProperty("undefined")
	UNDEFINED;
}