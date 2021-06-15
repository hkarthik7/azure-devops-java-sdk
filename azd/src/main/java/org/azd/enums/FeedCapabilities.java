package org.azd.enums;

/***
 * Supported capabilities of a feed.
 */
public enum FeedCapabilities {
    /***
     * The capabilities given to a newly created feed
     */
    DEFAULTCAPABILITIES,
    /***
     * No flags exist for this feed
     */
    NONE,
    /***
     * This feed is currently under maintenance and may have reduced functionality
     */
    UNDERMAINTENANCE,
    /***
     * This feed can serve packages from upstream sources Upstream packages must be manually promoted to views
     */
    UPSTREAMV2
}
