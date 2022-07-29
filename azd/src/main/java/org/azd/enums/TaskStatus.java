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
public enum TaskStatus {
	/**
 	* The task execution canceled. 
	**/
	@JsonProperty("canceled")
	CANCELED,
	/**
 	* The task execution failed. 
	**/
	@JsonProperty("failed")
	FAILED,
	/**
 	* The task execution failed. 
	**/
	@JsonProperty("failure")
	FAILURE,
	/**
 	* The task is currently in progress. 
	**/
	@JsonProperty("inProgress")
	INPROGRESS,
	/**
 	* The task execution partially succeeded. 
	**/
	@JsonProperty("partiallySucceeded")
	PARTIALLYSUCCEEDED,
	/**
 	* The task is in pending status. 
	**/
	@JsonProperty("pending")
	PENDING,
	/**
 	* The task execution skipped. 
	**/
	@JsonProperty("skipped")
	SKIPPED,
	/**
 	* The task completed successfully. 
	**/
	@JsonProperty("succeeded")
	SUCCEEDED,
	/**
 	* The task completed successfully. 
	**/
	@JsonProperty("success")
	SUCCESS,
	/**
 	* The task does not have the status set. 
	**/
	@JsonProperty("unknown")
	UNKNOWN;
}