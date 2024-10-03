package org.azd.enums;
/*
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
*/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * None 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public enum SubscriptionStatus {
	/**
 	* The subscription is disabled because the owner is inactive or is missing permissions. 
	**/
	@JsonProperty("disabledByInactiveIdentity")
	DISABLED_BY_INACTIVE_IDENTITY,
	/**
 	* The subscription is disabled by the system. 
	**/
	@JsonProperty("disabledBySystem")
	DISABLED_BY_SYSTEM,
	/**
 	* The subscription is disabled by a user. 
	**/
	@JsonProperty("disabledByUser")
	DISABLED_BY_USER,
	/**
 	* The subscription is enabled. 
	**/
	@JsonProperty("enabled")
	ENABLED,
	/**
 	* The subscription is temporarily on probation by the system. 
	**/
	@JsonProperty("onProbation")
	ON_PROBATION
}