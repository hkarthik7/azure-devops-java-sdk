package org.azd.enums;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/***
 * Type of view.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public enum FeedViewType {
    /***
     * Internal view type that is automatically created and managed by the system.
     */
    @JsonProperty("implicit")
    IMPLICIT,
    /***
     * View used as a promotion destination to classify released artifacts.
     */
    @JsonProperty("release")
    RELEASE
}
