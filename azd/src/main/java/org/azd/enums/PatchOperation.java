package org.azd.enums;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public enum PatchOperation {
    @JsonProperty("add")
    ADD,
    @JsonProperty("copy")
    COPY,
    @JsonProperty("MOVE")
    move,
    @JsonProperty("remove")
    REMOVE,
    @JsonProperty("replace")
    REPLACE,
    @JsonProperty("test")
    TEST,
}
