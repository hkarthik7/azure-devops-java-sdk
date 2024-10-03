package org.azd.enums;
/**
 * ----------------------------------------------------------
 * GENERATED FILE, should be edited to suit the purpose.
 * ----------------------------------------------------------
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
    @JsonProperty("All")
    ALL,
    /**
     * The deployment operation status is approved.
     **/
    @JsonProperty("Approved")
    APPROVED,
    /**
     * The deployment operation status is canceled.
     **/
    @JsonProperty("Canceled")
    CANCELED,
    /**
     * The deployment operation status is cancelling.
     **/
    @JsonProperty("Cancelling")
    CANCELLING,
    /**
     * The deployment operation status is deferred.
     **/
    @JsonProperty("Deferred")
    DEFERRED,
    /**
     * The deployment operation status is EvaluatingGates.
     **/
    @JsonProperty("EvaluatingGates")
    EVALUATING_GATES,
    /**
     * The deployment operation status is GateFailed.
     **/
    @JsonProperty("GateFailed")
    GATE_FAILED,
    /**
     * The deployment operation status is manualintervention pending.
     **/
    @JsonProperty("ManualInterventionPending")
    MANUAL_INTERVENTION_PENDING,
    /**
     * The deployment operation status is pending.
     **/
    @JsonProperty("Pending")
    PENDING,
    /**
     * The deployment operation status is phase canceled.
     **/
    @JsonProperty("PhaseCanceled")
    PHASE_CANCELED,
    /**
     * The deployment operation status is phase failed.
     **/
    @JsonProperty("PhaseFailed")
    PHASE_FAILED,
    /**
     * The deployment operation status is phase in progress.
     **/
    @JsonProperty("PhaseInProgress")
    PHASE_IN_PROGRESS,
    /**
     * The deployment operation status is phase partially succeeded.
     **/
    @JsonProperty("PhasePartiallySucceeded")
    PHASE_PARTIALLY_SUCCEEDED,
    /**
     * The deployment operation status is phase succeeded.
     **/
    @JsonProperty("PhaseSucceeded")
    PHASE_SUCCEEDED,
    /**
     * The deployment operation status is queued.
     **/
    @JsonProperty("Queued")
    QUEUED,
    /**
     * The deployment operation status is queued for agent.
     **/
    @JsonProperty("QueuedForAgent")
    QUEUED_FOR_AGENT,
    /**
     * The deployment operation status is queued for pipeline.
     **/
    @JsonProperty("QueuedForPipeline")
    QUEUED_FOR_PIPELINE,
    /**
     * The deployment operation status is rejected.
     **/
    @JsonProperty("Rejected")
    REJECTED,
    /**
     * The deployment operation status is scheduled.
     **/
    @JsonProperty("Scheduled")
    SCHEDULED,
    /**
     * The deployment operation status is undefined.
     **/
    @JsonProperty("Undefined")
    UNDEFINED;
}