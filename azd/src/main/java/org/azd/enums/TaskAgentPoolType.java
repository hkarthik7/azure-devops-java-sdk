package org.azd.enums;
/**
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
**/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The result of this request. 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public enum TaskAgentPoolType {
	/**
 	* A typical pool of task agents 
	**/
	@JsonProperty("automation")
	AUTOMATION,
	/**
 	* A deployment pool 
	**/
	@JsonProperty("deployment")
	DEPLOYMENT;
}