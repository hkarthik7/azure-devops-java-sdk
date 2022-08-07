package org.azd.enums;
/**
 * ----------------------------------------------------------
 * GENERATED FILE, should be edited to suit the purpose.
 * ----------------------------------------------------------
 **/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The class to represent a collection of REST reference links. 
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public enum ProjectVisibility {
    /**
     * The project is only visible to users with explicit access.
     **/
    @JsonProperty("private")
    PRIVATE,
    /**
     * The project is visible to all.
     **/
    @JsonProperty("public")
    PUBLIC,
    /**
     * Enterprise level project visibility
     */
    @JsonProperty("organization")
    ORGANIZATION,
    @JsonProperty("systemPrivate")
    SYSTEM_PRIVATE,
    @JsonProperty("unchanged")
    UNCHANGED;
}