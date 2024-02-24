package org.azd.enums;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * A property that should be expanded in the environment.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public enum ReleaseEnvironmentExpands {
    /**
     *
     * Return top level properties of object.
     */
    @JsonProperty("none")
    NONE,
    /**
     * Expand environment with tasks.
     */
    @JsonProperty("tasks")
    TASKS,
}
