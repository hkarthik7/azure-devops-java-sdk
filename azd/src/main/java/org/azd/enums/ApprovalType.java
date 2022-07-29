package org.azd.enums;
/**
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
**/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Gets or sets the condition type. 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public enum ApprovalType {
	/**
 	* Indicates all approvals. 
	**/
	@JsonProperty("all")
	ALL,
	/**
 	* Indicates the approvals which executed after deployment. 
	**/
	@JsonProperty("postDeploy")
	POSTDEPLOY,
	/**
 	* Indicates the approvals which executed before deployment. 
	**/
	@JsonProperty("preDeploy")
	PREDEPLOY,
	/**
 	* Indicates the approval type does not set. 
	**/
	@JsonProperty("undefined")
	UNDEFINED;
}