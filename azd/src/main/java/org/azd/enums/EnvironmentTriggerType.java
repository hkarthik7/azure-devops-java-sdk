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
public enum EnvironmentTriggerType {
	/**
 	* Environment trigger type is deployment group redeploy. 
	**/
	@JsonProperty("deploymentGroupRedeploy")
	DEPLOYMENTGROUPREDEPLOY,
	/**
 	* Environment trigger type is Rollback. 
	**/
	@JsonProperty("rollbackRedeploy")
	ROLLBACKREDEPLOY,
	/**
 	* Environment trigger type undefined. 
	**/
	@JsonProperty("undefined")
	UNDEFINED;
}