package org.azd.enums;
/*
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
*/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Policy type reference. 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public enum PolicyEvaluationStatus {
	/**
 	* The policy has been fulfilled for this pull request. 
	**/
	@JsonProperty("approved")
	APPROVED,
	/**
 	* The policy has encountered an unexpected error. 
	**/
	@JsonProperty("broken")
	BROKEN,
	/**
 	* The policy does not apply to this pull request. 
	**/
	@JsonProperty("notApplicable")
	NOTAPPLICABLE,
	/**
 	* The policy is either queued to run, or is waiting for some event before progressing. 
	**/
	@JsonProperty("queued")
	QUEUED,
	/**
 	* The policy has rejected this pull request. 
	**/
	@JsonProperty("rejected")
	REJECTED,
	/**
 	* The policy is currently running. 
	**/
	@JsonProperty("running")
	RUNNING
}