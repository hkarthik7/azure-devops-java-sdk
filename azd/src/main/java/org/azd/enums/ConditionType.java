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
public enum ConditionType {
	/**
 	* The condition type is event.
	**/
	@JsonProperty("event")
	EVENT,
	/**
 	* The condition type is environment state.
	**/
	@JsonProperty("environmentState")
	ENVIRONMENTSTATE,
	/**
	 * The condition type is environment artifact.
	 **/
	@JsonProperty("artifact")
	Artifact,
	/**
 	* Environment trigger type undefined. 
	**/
	@JsonProperty("undefined")
	UNDEFINED;
}