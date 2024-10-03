package org.azd.enums;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public enum GraphTraversalDirection {
    @JsonProperty("down")
    DOWN,
    @JsonProperty("up")
    UP,
    @JsonProperty("unknown")
    UNKNOWN
}
