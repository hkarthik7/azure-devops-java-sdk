package org.azd.enums;
/**
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
**/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Gets or sets the type of approval. 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public enum ApprovalStatus {
	/**
 	* Indicates the approval is approved. 
	**/
	@JsonProperty("approved")
	APPROVED,
	/**
 	* Indicates the approval is canceled. 
	**/
	@JsonProperty("canceled")
	CANCELED,
	/**
 	* Indicates the approval is pending. 
	**/
	@JsonProperty("pending")
	PENDING,
	/**
 	* Indicates the approval is reassigned. 
	**/
	@JsonProperty("reassigned")
	REASSIGNED,
	/**
 	* Indicates the approval is rejected. 
	**/
	@JsonProperty("rejected")
	REJECTED,
	/**
 	* Indicates the approval is skipped. 
	**/
	@JsonProperty("skipped")
	SKIPPED,
	/**
 	* Indicates the approval does not have the status set. 
	**/
	@JsonProperty("undefined")
	UNDEFINED;
}