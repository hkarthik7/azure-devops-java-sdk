package org.azd.enums;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Defines provider data of the variable group.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public enum VariableValue {
    @JsonProperty("isReadOnly")
    IS_READONLY,
    @JsonProperty("isSecret")
    IS_SECRET,
    @JsonProperty("value")
    VALUE
}
