package org.azd.enums;
/**
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
**/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Gets status. 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public enum DeployPhaseStatus {
	/**
 	* Phase execution canceled. 
	**/
	@JsonProperty("canceled")
	CANCELED,
	/**
 	* Phase is in cancelling state. 
	**/
	@JsonProperty("cancelling")
	CANCELLING,
	/**
 	* Phase execution failed. 
	**/
	@JsonProperty("failed")
	FAILED,
	/**
 	* Phase execution in progress. 
	**/
	@JsonProperty("inProgress")
	INPROGRESS,
	/**
 	* Phase execution not started. 
	**/
	@JsonProperty("notStarted")
	NOTSTARTED,
	/**
 	* Phase execution partially succeeded. 
	**/
	@JsonProperty("partiallySucceeded")
	PARTIALLYSUCCEEDED,
	/**
 	* Phase execution skipped. 
	**/
	@JsonProperty("skipped")
	SKIPPED,
	/**
 	* Phase execution succeeded. 
	**/
	@JsonProperty("succeeded")
	SUCCEEDED,
	/**
 	* Phase status not set. 
	**/
	@JsonProperty("undefined")
	UNDEFINED;
}