package org.azd.enums;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents the user scope for a feature.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public enum FeatureManagementUserScope {
    /**
     * Current logged in user.
     */
    @JsonProperty("me")
    ME,
    /**
     * Represents all users.
     */
    @JsonProperty("host")
    HOST,
}
