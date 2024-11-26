package org.azd.enums;
/*
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
*/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;

/**
 * Licensing Source (e.g. Account. MSDN etc.) 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public enum GroupLicensingRuleStatus {
	/**
 	* Rule is applied 
	**/
	@JsonProperty("applied")
	APPLIED,
	/**
 	* Rule is created or updated, but apply is pending 
	**/
	@JsonProperty("applyPending")
	APPLY_PENDING,
	/**
 	* The group rule was incompatible 
	**/
	@JsonProperty("incompatible")
	INCOMPATIBLE,
	/**
 	* Rule failed to apply unexpectedly and should be retried 
	**/
	@JsonProperty("unableToApply")
	UNABLE_TO_APPLY;
}