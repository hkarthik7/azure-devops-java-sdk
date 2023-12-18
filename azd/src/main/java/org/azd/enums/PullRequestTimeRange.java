package org.azd.enums;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public enum PullRequestTimeRange {
    /**
     * The date when the pull request was closed (completed, abandoned, or merged externally).
     */
    @JsonProperty("closed")
    CLOSED,
    /**
     *
     * The date when the pull request was created.
     */
    @JsonProperty("created")
    CREATED,
}
