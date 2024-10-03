package org.azd.enums;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * None
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public enum ValidationResult {
    @JsonProperty("error")
    ERROR,
    @JsonProperty("ok")
    OK,
    @JsonProperty("warning")
    WARNING
}
