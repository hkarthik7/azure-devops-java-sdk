package org.azd.enums;
/**
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
**/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Approvals execution order. 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public enum ApprovalExecutionOrder {
	/**
 	* Approvals shown always after execution of gates. 
	**/
	@JsonProperty("afterGatesAlways")
	AFTERGATESALWAYS,
	/**
 	* Approvals shown after successful execution of gates. 
	**/
	@JsonProperty("afterSuccessfulGates")
	AFTERSUCCESSFULGATES,
	/**
 	* Approvals shown before gates. 
	**/
	@JsonProperty("beforeGates")
	BEFOREGATES;
}