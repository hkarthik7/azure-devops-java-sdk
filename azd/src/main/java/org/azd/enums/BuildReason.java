package org.azd.enums;
/**
 * ----------------------------------------------------------
 * GENERATED FILE, should be edited to suit the purpose.
 * ----------------------------------------------------------
 **/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents the result of validating a build request. 
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public enum BuildReason {
    /**
     * All reasons.
     **/
    @JsonProperty("all")
    ALL,
    /**
     * The build was started for the trigger TriggerType.BatchedContinuousIntegration.
     **/
    @JsonProperty("batchedCI")
    BATCHEDCI,
    /**
     * The build was started when another build completed.
     **/
    @JsonProperty("buildCompletion")
    BUILDCOMPLETION,
    /**
     * The build was started for the trigger ContinuousIntegrationType.Gated.
     **/
    @JsonProperty("checkInShelveset")
    CHECKINSHELVESET,
    /**
     * The build was started for the trigger TriggerType.ContinuousIntegration.
     **/
    @JsonProperty("individualCI")
    INDIVIDUALCI,
    /**
     * The build was started manually.
     **/
    @JsonProperty("manual")
    MANUAL,
    /**
     * No reason. This value should not be used.
     **/
    @JsonProperty("none")
    NONE,
    /**
     * The build was started by a pull request. Added in resource version 3.
     **/
    @JsonProperty("pullRequest")
    PULLREQUEST,
    /**
     * The build was started when resources in pipeline triggered it
     **/
    @JsonProperty("resourceTrigger")
    RESOURCETRIGGER,
    /**
     * The build was started for the trigger TriggerType.Schedule.
     **/
    @JsonProperty("schedule")
    SCHEDULE,
    /**
     * The build was started for the trigger TriggerType.ScheduleForced.
     **/
    @JsonProperty("scheduleForced")
    SCHEDULEFORCED,
    /**
     * The build was triggered for retention policy purposes.
     **/
    @JsonProperty("triggered")
    TRIGGERED,
    /**
     * The build was created by a user.
     **/
    @JsonProperty("userCreated")
    USERCREATED,
    /**
     * was started manually for private validation,
     **/
    @JsonProperty("validateShelveset")
    VALIDATESHELVESET;


}