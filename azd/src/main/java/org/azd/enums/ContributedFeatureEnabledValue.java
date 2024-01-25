package org.azd.enums;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The current state of a feature within a given scope
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public enum ContributedFeatureEnabledValue {
    /**
     * The state of the feature is not set for the specified scope
     */
    @JsonProperty("undefined")
    UNDEFINED("undefined"),
    /**
     * The feature is disabled at the specified scope
     */
    @JsonProperty("disabled")
    DISABLED("disabled"),
    /**
     * The feature is enabled at the specified scope
     */
    @JsonProperty("enabled")
    ENABLED("enabled");

    private final String featureValue;

    ContributedFeatureEnabledValue(String value) {
        featureValue = value;
    }

    public String getFeatureValue() {
        return featureValue;
    }
}
