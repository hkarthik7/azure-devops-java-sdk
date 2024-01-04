package org.azd.enums;
/*
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
*/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Tag attached to a run or result.
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public enum TestRunSubstate {
    /**
     * Run state when it is Aborted By the System.
     **/
    @JsonProperty("abortedBySystem")
    ABORTEDBYSYSTEM,
    /**
     * Run state after being Analysed.
     **/
    @JsonProperty("analyzed")
    ANALYZED,
    /**
     * Run state while Creating Environment.
     **/
    @JsonProperty("canceledByUser")
    CANCELEDBYUSER,
    /**
     * Run state when cancellation is in Progress.
     **/
    @JsonProperty("cancellationInProgress")
    CANCELLATIONINPROGRESS,
    /**
     * Run state while Creating Environment.
     **/
    @JsonProperty("creatingEnvironment")
    CREATINGENVIRONMENT,
    /**
     * Run with noState.
     **/
    @JsonProperty("none")
    NONE,
    /**
     * Run state while Pending Analysis.
     **/
    @JsonProperty("pendingAnalysis")
    PENDINGANALYSIS,
    /**
     * Run state while Running Tests.
     **/
    @JsonProperty("runningTests")
    RUNNINGTESTS,
    /**
     * Run state when run has timedOut.
     **/
    @JsonProperty("timedOut")
    TIMEDOUT
}