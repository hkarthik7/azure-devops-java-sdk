package org.azd.enums;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Version options - Specify additional modifiers to version (e.g Previous)
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public enum GitVersionOptions {
    /**
     * First parent of commit (HEAD^)
     **/
    @JsonProperty("firstParent")
    FIRST_PARENT,
    /**
     * Not specified
     **/
    @JsonProperty("none")
    NONE,
    /**
     * Commit that changed item prior to the current version
     **/
    @JsonProperty("previousChange")
    PREVIOUS_CHANGE,
}
