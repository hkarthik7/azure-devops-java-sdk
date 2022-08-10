package org.azd.enums;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Version type (branch, tag, or commit). Determines how Id is interpreted
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public enum GitVersionType {
    /**
     * Interpret the version as a branch name
     **/
    @JsonProperty("branch")
    BRANCH,
    /**
     * Interpret the version as a commit ID (SHA1)
     **/
    @JsonProperty("commit")
    COMMIT,
    /**
     * Interpret the version as a tag name
     **/
    @JsonProperty("tag")
    TAG;
}
