package org.azd.enums;
/**
 * ----------------------------------------------------------
 * GENERATED FILE, should be edited to suit the purpose.
 * ----------------------------------------------------------
 **/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents a demand used by a definition or build. 
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public enum DefinitionTriggerType {
    /**
     * All types.
     **/
    @JsonProperty("all")
    ALL,
    /**
     * A build should be started for multiple changesets at a time at a specified interval.
     **/
    @JsonProperty("batchedContinuousIntegration")
    BATCHEDCONTINUOUSINTEGRATION,
    /**
     * A validation build should be started for each batch of check-ins.
     **/
    @JsonProperty("batchedGatedCheckIn")
    BATCHEDGATEDCHECKIN,
    /**
     * A build should be triggered when another build completes.
     **/
    @JsonProperty("buildCompletion")
    BUILDCOMPLETION,
    /**
     * A build should be started for each changeset.
     **/
    @JsonProperty("continuousIntegration")
    CONTINUOUSINTEGRATION,
    /**
     * A validation build should be started for each check-in.
     **/
    @JsonProperty("gatedCheckIn")
    GATEDCHECKIN,
    /**
     * Manual builds only.
     **/
    @JsonProperty("none")
    NONE,
    /**
     * A build should be triggered when a GitHub pull request is created or updated. Added in resource version 3
     **/
    @JsonProperty("pullRequest")
    PULLREQUEST,
    /**
     * A build should be started on a specified schedule whether or not changesets exist.
     **/
    @JsonProperty("schedule")
    SCHEDULE;


}