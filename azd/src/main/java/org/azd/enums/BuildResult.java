package org.azd.enums;
/**
 * ----------------------------------------------------------
 * GENERATED FILE, should be edited to suit the purpose.
 * ----------------------------------------------------------
 **/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents a trigger for a buld definition. 
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public enum BuildResult {
    /**
     * The build was canceled before starting.
     **/
    @JsonProperty("canceled")
    CANCELED,
    /**
     * The build completed unsuccessfully.
     **/
    @JsonProperty("failed")
    FAILED,
    /**
     * No result
     **/
    @JsonProperty("none")
    NONE,
    /**
     * The build completed compilation successfully but had other errors.
     **/
    @JsonProperty("partiallySucceeded")
    PARTIALLYSUCCEEDED,
    /**
     * The build completed successfully.
     **/
    @JsonProperty("succeeded")
    SUCCEEDED;

}