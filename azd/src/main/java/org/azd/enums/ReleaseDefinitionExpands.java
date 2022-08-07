package org.azd.enums;
/**
 ----------------------------------------------------------
 GENERATED FILE, should be edited to suit the purpose.
 ----------------------------------------------------------
 **/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

/**
 * None
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public enum ReleaseDefinitionExpands {
    /**
     * Include artifacts in return object.
     **/
    @JsonProperty("artifacts")
    ARTIFACTS,
    /**
     * Include environments in return object.
     **/
    @JsonProperty("environments")
    ENVIRONMENTS,
    /**
     * Include last release in return object.
     **/
    @JsonProperty("lastRelease")
    LAST_RELEASE,
    /**
     * Returns top level properties of object.
     **/
    @JsonProperty("none")
    NONE,
    /**
     * Include tags in return object.
     **/
    @JsonProperty("tags")
    TAGS,
    /**
     * Include triggers in return object.
     **/
    @JsonProperty("triggers")
    TRIGGERS,
    /**
     * Include variables in return object.
     **/
    @JsonProperty("variables")
    VARIABLES;
}