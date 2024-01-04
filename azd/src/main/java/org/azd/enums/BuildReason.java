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
    BATCHED_CI,
    /**
     * The build was started when another build completed.
     **/
    @JsonProperty("buildCompletion")
    BUILD_COMPLETION,
    /**
     * The build was started for the trigger ContinuousIntegrationType.Gated.
     **/
    @JsonProperty("checkInShelveset")
    CHECK_IN_SHELVE_SET,
    /**
     * The build was started for the trigger TriggerType.ContinuousIntegration.
     **/
    @JsonProperty("individualCI")
    INDIVIDUAL_CI,
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
    PULL_REQUEST,
    /**
     * The build was started when resources in pipeline triggered it
     **/
    @JsonProperty("resourceTrigger")
    RESOURCE_TRIGGER,
    /**
     * The build was started for the trigger TriggerType.Schedule.
     **/
    @JsonProperty("schedule")
    SCHEDULE,
    /**
     * The build was started for the trigger TriggerType.ScheduleForced.
     **/
    @JsonProperty("scheduleForced")
    SCHEDULE_FORCED,
    /**
     * The build was triggered for retention policy purposes.
     **/
    @JsonProperty("triggered")
    TRIGGERED,
    /**
     * The build was created by a user.
     **/
    @JsonProperty("userCreated")
    USER_CREATED,
    /**
     * was started manually for private validation,
     **/
    @JsonProperty("validateShelveset")
    VALIDATE_SHELVE_SET;


}