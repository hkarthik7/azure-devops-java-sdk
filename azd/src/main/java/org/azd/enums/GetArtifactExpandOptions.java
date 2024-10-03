package org.azd.enums;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Expand options. Default is None.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public enum GetArtifactExpandOptions {
    /**
     * No expansion.
     */
    @JsonProperty("none")
    NONE,
    /**
     * Include signed content.
     */
    @JsonProperty("signedContent")
    SIGNED_CONTENT
;
    @Override
    public String toString() {
        return this.name().toLowerCase().replaceAll("_", "");
    }
}
