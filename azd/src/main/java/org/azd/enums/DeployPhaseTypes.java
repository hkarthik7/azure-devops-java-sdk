package org.azd.enums;
/**
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
**/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Days of the week to release. 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public enum DeployPhaseTypes {
	/**
 	* Phase type which contains tasks executed on agent. 
	**/
	@JsonProperty("agentBasedDeployment")
	AGENTBASEDDEPLOYMENT,
	/**
 	* Phase type which contains tasks which acts as Gates for the deployment to go forward. 
	**/
	@JsonProperty("deploymentGates")
	DEPLOYMENTGATES,
	/**
 	* Phase type which contains tasks executed on deployment group machines. 
	**/
	@JsonProperty("machineGroupBasedDeployment")
	MACHINEGROUPBASEDDEPLOYMENT,
	/**
 	* Phase type which contains tasks executed by server. 
	**/
	@JsonProperty("runOnServer")
	RUNONSERVER,
	/**
 	* Phase type not defined. Don't use this. 
	**/
	@JsonProperty("undefined")
	UNDEFINED;
}