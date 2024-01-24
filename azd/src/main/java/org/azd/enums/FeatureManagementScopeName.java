package org.azd.enums;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public enum FeatureManagementScopeName {
    @JsonProperty("project")
    PROJECT,
    @JsonProperty("team")
    TEAM;
}
