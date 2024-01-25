package org.azd.git.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Represents the request body for Git items batch Api.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GitItemRequestData {
    /**
     * Whether to include metadata for all items
     */
    @JsonProperty("includeContentMetadata")
    public boolean includeContentMetadata;
    /**
     * Whether to include the _links field on the shallow references
     */
    @JsonProperty("includeLinks")
    public boolean includeLinks;
    /**
     * Collection of items to fetch, including path, version, and recursion level
     */
    @JsonProperty("itemDescriptors")
    public List<GitItemDescriptor> itemDescriptors;
    /**
     * Whether to include shallow ref to commit that last changed each item
     */
    @JsonProperty("latestProcessedChange")
    public boolean latestProcessedChange;
}
