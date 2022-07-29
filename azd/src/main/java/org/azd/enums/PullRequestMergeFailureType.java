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
public enum PullRequestMergeFailureType {
	/**
 	* Pull request merge failed due to case mismatch. 
	**/
	@JsonProperty("caseSensitive")
	CASESENSITIVE,
	/**
 	* Type is not set. Default type. 
	**/
	@JsonProperty("none")
	NONE,
	/**
 	* Pull request merge failed due to an object being too large. 
	**/
	@JsonProperty("objectTooLarge")
	OBJECTTOOLARGE,
	/**
 	* Pull request merge failure type unknown. 
	**/
	@JsonProperty("unknown")
	UNKNOWN;
}