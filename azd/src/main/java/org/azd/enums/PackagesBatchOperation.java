package org.azd.enums;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Type of operation that needs to be performed on packages.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public enum PackagesBatchOperation {
    /**
     * Promote package versions to a release view. If constructing a MavenPackagesBatchRequest object with this type.
     */
    @JsonProperty("promote")
    PROMOTE,
    /**
     * Delete package versions. Not supported in the Recycle Bin.
     */
    @JsonProperty("delete")
    DELETE,
    /**
     * Permanently delete package versions. Only supported in the Recycle Bin.
     */
    @JsonProperty("permanentDelete")
    PERMANENTDELETE,
    /**
     * Restore unpublished package versions to the feed. Only supported in the Recycle Bin.
     */
    @JsonProperty("restoreToFeed")
    RESTORETOFEED
}