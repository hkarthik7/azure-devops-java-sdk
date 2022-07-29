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
public enum ReleaseReason {
	/**
 	* Indicates the release triggered by continuous integration. 
	**/
	@JsonProperty("continuousIntegration")
	CONTINUOUSINTEGRATION,
	/**
 	* Indicates the release triggered manually. 
	**/
	@JsonProperty("manual")
	MANUAL,
	/**
 	* Indicates the release triggered reason not set. 
	**/
	@JsonProperty("none")
	NONE,
	/**
 	* Indicates the release triggered by PullRequest. 
	**/
	@JsonProperty("pullRequest")
	PULLREQUEST,
	/**
 	* Indicates the release triggered by schedule. 
	**/
	@JsonProperty("schedule")
	SCHEDULE;
}