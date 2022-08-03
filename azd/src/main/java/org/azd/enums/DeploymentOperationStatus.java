package org.azd.enums;
/**
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
**/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Gets or sets the status of the manual intervention. 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public enum DeploymentOperationStatus {
	/**
 	* The deployment operation status is all. 
	**/
	@JsonProperty("all")
	ALL,
	/**
 	* The deployment operation status is approved. 
	**/
	@JsonProperty("approved")
	APPROVED,
	/**
 	* The deployment operation status is canceled. 
	**/
	@JsonProperty("canceled")
	CANCELED,
	/**
 	* The deployment operation status is cancelling. 
	**/
	@JsonProperty("cancelling")
	CANCELLING,
	/**
 	* The deployment operation status is deferred. 
	**/
	@JsonProperty("deferred")
	DEFERRED,
	/**
 	* The deployment operation status is EvaluatingGates. 
	**/
	@JsonProperty("evaluatingGates")
	EVALUATINGGATES,
	/**
 	* The deployment operation status is GateFailed. 
	**/
	@JsonProperty("gateFailed")
	GATEFAILED,
	/**
 	* The deployment operation status is manualintervention pending. 
	**/
	@JsonProperty("manualInterventionPending")
	MANUALINTERVENTIONPENDING,
	/**
 	* The deployment operation status is pending. 
	**/
	@JsonProperty("pending")
	PENDING,
	/**
 	* The deployment operation status is phase canceled. 
	**/
	@JsonProperty("phaseCanceled")
	PHASECANCELED,
	/**
 	* The deployment operation status is phase failed. 
	**/
	@JsonProperty("phaseFailed")
	PHASEFAILED,
	/**
 	* The deployment operation status is phase in progress. 
	**/
	@JsonProperty("phaseInProgress")
	PHASEINPROGRESS,
	/**
 	* The deployment operation status is phase partially succeeded. 
	**/
	@JsonProperty("phasePartiallySucceeded")
	PHASEPARTIALLYSUCCEEDED,
	/**
 	* The deployment operation status is phase succeeded. 
	**/
	@JsonProperty("phaseSucceeded")
	PHASESUCCEEDED,
	/**
 	* The deployment operation status is queued. 
	**/
	@JsonProperty("queued")
	QUEUED,
	/**
 	* The deployment operation status is queued for agent. 
	**/
	@JsonProperty("queuedForAgent")
	QUEUEDFORAGENT,
	/**
 	* The deployment operation status is queued for pipeline. 
	**/
	@JsonProperty("queuedForPipeline")
	QUEUEDFORPIPELINE,
	/**
 	* The deployment operation status is rejected. 
	**/
	@JsonProperty("rejected")
	REJECTED,
	/**
 	* The deployment operation status is scheduled. 
	**/
	@JsonProperty("scheduled")
	SCHEDULED,
	/**
 	* The deployment operation status is undefined. 
	**/
	@JsonProperty("undefined")
	UNDEFINED;
}