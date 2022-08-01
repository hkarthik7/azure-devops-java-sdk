package org.azd.enums;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public enum QueryExpand {
    @JsonProperty("all")
    ALL,
    @JsonProperty("clauses")
    CLAUSES,
    @JsonProperty("minimal")
    MINIMAL,
    @JsonProperty("none")
    NONE,
    @JsonProperty("wiql")
    WIQL;
}
