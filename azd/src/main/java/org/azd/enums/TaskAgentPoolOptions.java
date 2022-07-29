package org.azd.enums;
/**
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
**/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Whether or not the agent is online. 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public enum TaskAgentPoolOptions {
	/**
 	* TaskAgentPool backed by the Elastic pool service 
	**/
	@JsonProperty("elasticPool")
	ELASTICPOOL,
	/**
 	* Set to true if agents are held for investigation after a TaskAgentJobRequest failure 
	**/
	@JsonProperty("preserveAgentOnJobFailure")
	PRESERVEAGENTONJOBFAILURE,
	/**
 	* Set to true if agents are re-imaged after each TaskAgentJobRequest 
	**/
	@JsonProperty("singleUseAgents")
	SINGLEUSEAGENTS;
}