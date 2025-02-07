package org.azd.test.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Model to update test point.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PointUpdateModel {
    /**
     * Outcome to update.
     */
    @JsonProperty("outcome")
    public String outcome;
    /**
     * Reset test point to active.
     */
    @JsonProperty("resetToActive")
    public Boolean resetToActive;
    /**
     * Outcome to update.
     */
    @JsonProperty("tester")
    public IdentityRef tester;
}
