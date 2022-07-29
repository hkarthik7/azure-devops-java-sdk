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
public enum GitStatusState {
	/**
 	* Status with an error. 
	**/
	@JsonProperty("error")
	ERROR,
	/**
 	* Status failed. 
	**/
	@JsonProperty("failed")
	FAILED,
	/**
 	* Status is not applicable to the target object. 
	**/
	@JsonProperty("notApplicable")
	NOTAPPLICABLE,
	/**
 	* Status state not set. Default state. 
	**/
	@JsonProperty("notSet")
	NOTSET,
	/**
 	* Status pending. 
	**/
	@JsonProperty("pending")
	PENDING,
	/**
 	* Status succeeded. 
	**/
	@JsonProperty("succeeded")
	SUCCEEDED;
}