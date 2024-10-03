package org.azd.enums;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Group Type
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public enum GroupType {
    /**
     * Custom
     */
    @JsonProperty("custom")
    CUSTOM,
    /**
     * Project administrator
     */
    @JsonProperty("projectAdministrator")
    PROJECT_ADMINISTRATOR,
    /**
     * Project contributor
     */
    @JsonProperty("projectContributor")
    PROJECT_CONTRIBUTOR,
    /**
     * Project reader
     */
    @JsonProperty("projectReader")
    PROJECT_READER,
    /**
     * Project stake holder
     */
    @JsonProperty("projectStakeHolder")
    PROJECT_STAKE_HOLDER
}
