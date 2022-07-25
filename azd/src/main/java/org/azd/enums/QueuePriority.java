package org.azd.enums;
/**
 * ----------------------------------------------------------
 * GENERATED FILE, should be edited to suit the purpose.
 * ----------------------------------------------------------
 **/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents a reference to an orchestration plan. 
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public enum QueuePriority {
    /**
     * Above normal priority.
     **/
    @JsonProperty("aboveNormal")
    ABOVENORMAL,
    /**
     * Below normal priority.
     **/
    @JsonProperty("belowNormal")
    BELOWNORMAL,
    /**
     * High priority.
     **/
    @JsonProperty("high")
    HIGH,
    /**
     * Low priority.
     **/
    @JsonProperty("low")
    LOW,
    /**
     * Normal priority.
     **/
    @JsonProperty("normal")
    NORMAL;
}