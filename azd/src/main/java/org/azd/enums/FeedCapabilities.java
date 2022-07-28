package org.azd.enums;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/***
 * Supported capabilities of a feed.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public enum FeedCapabilities {
    /***
     * The capabilities given to a newly created feed
     */
    @JsonProperty("defaultCapabilities")
    DEFAULTCAPABILITIES,
    /***
     * No flags exist for this feed
     */
    @JsonProperty("none")
    NONE,
    /***
     * This feed is currently under maintenance and may have reduced functionality
     */
    @JsonProperty("underMaintenance")
    UNDERMAINTENANCE,
    /***
     * This feed can serve packages from upstream sources Upstream packages must be manually promoted to views
     */
    @JsonProperty("upstreamV2")
    UPSTREAMV2
}
