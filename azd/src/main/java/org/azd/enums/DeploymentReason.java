package org.azd.enums;
/**
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
**/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The class represents a property bag as a collection of key-value pairs. Values of all primitive types (any type with a TypeCode != TypeCode.Object) except for DBNull are accepted. Values of type Byte[], Int32, Double, DateType and String preserve their type, other primitives are retuned as a String. Byte[] expected as base64 encoded string. 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public enum DeploymentReason {
	/**
 	* The deployment reason is automated. 
	**/
	@JsonProperty("automated")
	AUTOMATED,
	/**
 	* The deployment reason is manual. 
	**/
	@JsonProperty("manual")
	MANUAL,
	/**
 	* The deployment reason is none. 
	**/
	@JsonProperty("none")
	NONE,
	/**
 	* The deployment reason is RedeployTrigger. 
	**/
	@JsonProperty("redeployTrigger")
	REDEPLOYTRIGGER,
	/**
 	* The deployment reason is scheduled. 
	**/
	@JsonProperty("scheduled")
	SCHEDULED;
}