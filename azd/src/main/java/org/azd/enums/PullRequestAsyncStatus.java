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
public enum PullRequestAsyncStatus {
	/**
 	* Pull request merge failed due to conflicts. 
	**/
	@JsonProperty("conflicts")
	CONFLICTS,
	/**
 	* Pull request merge failed. 
	**/
	@JsonProperty("failure")
	FAILURE,
	/**
 	* Status is not set. Default state. 
	**/
	@JsonProperty("notSet")
	NOTSET,
	/**
 	* Pull request merge is queued. 
	**/
	@JsonProperty("queued")
	QUEUED,
	/**
 	* Pull request merge rejected by policy. 
	**/
	@JsonProperty("rejectedByPolicy")
	REJECTEDBYPOLICY,
	/**
 	* Pull request merge succeeded. 
	**/
	@JsonProperty("succeeded")
	SUCCEEDED;
}