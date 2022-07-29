package org.azd.enums;
/**
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
**/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * A variable group reference is a shallow reference to variable group. 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public enum GateStatus {
	/**
 	* The gate execution cancelled. 
	**/
	@JsonProperty("canceled")
	CANCELED,
	/**
 	* The gate execution failed. 
	**/
	@JsonProperty("failed")
	FAILED,
	/**
 	* The gate is currently in progress. 
	**/
	@JsonProperty("inProgress")
	INPROGRESS,
	/**
 	* The gate does not have the status set. 
	**/
	@JsonProperty("none")
	NONE,
	/**
 	* The gate is in pending state. 
	**/
	@JsonProperty("pending")
	PENDING,
	/**
 	* The gate completed successfully. 
	**/
	@JsonProperty("succeeded")
	SUCCEEDED;
}