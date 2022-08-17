package org.azd.enums;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public enum GitBlobRefFormat {
    @JsonProperty("json")
    JSON,
    @JsonProperty("zip")
    ZIP,
    @JsonProperty("text")
    TEXT,
    @JsonProperty("octetstream")
    OCTETSTREAM;
}
