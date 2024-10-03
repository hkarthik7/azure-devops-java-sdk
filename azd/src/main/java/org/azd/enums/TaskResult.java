package org.azd.enums;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public enum TaskResult {
    @JsonProperty("abandoned")
    ABANDONED,
    @JsonProperty("canceled")
    CANCELED,
    @JsonProperty("failed")
    FAILED,
    @JsonProperty("skipped")
    SKIPPED,
    @JsonProperty("succeeded")
    SUCCEEDED,
    @JsonProperty("succeededWithIssues")
    SUCCEEDEDWITHISSUES
}