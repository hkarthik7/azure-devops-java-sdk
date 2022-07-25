package org.azd.enums;
/**
 * ----------------------------------------------------------
 * GENERATED FILE, should be edited to suit the purpose.
 * ----------------------------------------------------------
 **/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The status of the controller. 
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public enum BuildStatus {
    /**
     * All status.
     **/
    @JsonProperty("all")
    ALL,
    /**
     * The build is cancelling
     **/
    @JsonProperty("cancelling")
    CANCELLING,
    /**
     * The build has completed.
     **/
    @JsonProperty("completed")
    COMPLETED,
    /**
     * The build is currently in progress.
     **/
    @JsonProperty("inProgress")
    INPROGRESS,
    /**
     * No status.
     **/
    @JsonProperty("none")
    NONE,
    /**
     * The build has not yet started.
     **/
    @JsonProperty("notStarted")
    NOTSTARTED,
    /**
     * The build is inactive in the queue.
     **/
    @JsonProperty("postponed")
    POSTPONED;


}