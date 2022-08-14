package org.azd.enums;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public enum WikiType {
    @JsonProperty("codeWiki")
    CODEWIKI,
    @JsonProperty("projectWiki")
    PROJECTWIKI;
}
