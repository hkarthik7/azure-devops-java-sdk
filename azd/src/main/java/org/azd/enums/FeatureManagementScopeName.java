package org.azd.enums;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public enum FeatureManagementScopeName {
    @JsonProperty("project")
    PROJECT("project"),
    @JsonProperty("team")
    TEAM("team");

    private final String userScopeName;

    FeatureManagementScopeName(String scopeName) {
        userScopeName = scopeName;
    }

    public String getScopeName() {
        return userScopeName;
    }
}
