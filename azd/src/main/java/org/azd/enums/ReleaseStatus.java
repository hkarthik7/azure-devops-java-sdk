package org.azd.enums;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public enum ReleaseStatus {
    /***
     * Release status is in abandoned.
     */
    @JsonProperty("abandoned")
    ABANDONED,
    /***
     * Release status is in active.
     */
    @JsonProperty("active")
    ACTIVE,
    /***
     * Release is in draft state.
     */
    @JsonProperty("draft")
    DRAFT,
    /***
     * Release status not set.
     */
    @JsonProperty("undefined")
    UNDEFINED
}
