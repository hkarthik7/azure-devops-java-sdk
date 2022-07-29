package org.azd.enums;
/**
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
**/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The class to represent a collection of REST reference links. 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public enum DeploymentStatus {
	/**
 	* The deployment status is all. 
	**/
	@JsonProperty("all")
	ALL,
	/**
 	* The deployment status is failed. 
	**/
	@JsonProperty("failed")
	FAILED,
	/**
 	* The deployment status is in progress. 
	**/
	@JsonProperty("inProgress")
	INPROGRESS,
	/**
 	* The deployment status is not deployed. 
	**/
	@JsonProperty("notDeployed")
	NOTDEPLOYED,
	/**
 	* The deployment status is partiallysucceeded. 
	**/
	@JsonProperty("partiallySucceeded")
	PARTIALLYSUCCEEDED,
	/**
 	* The deployment status is succeeded. 
	**/
	@JsonProperty("succeeded")
	SUCCEEDED,
	/**
 	* The deployment status is undefined. 
	**/
	@JsonProperty("undefined")
	UNDEFINED;
}