package org.azd.enums;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public enum UserEntitlementProperty {
    @JsonProperty("all")
    ALL,
    @JsonProperty("extensions")
    EXTENSIONS,
    @JsonProperty("groupRules")
    GROUP_RULES,
    @JsonProperty("license")
    LICENSE,
    @JsonProperty("projects")
    PROJECTS
}
