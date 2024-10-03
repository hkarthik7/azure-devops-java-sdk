package org.azd.graph.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Do not attempt to use this type to create a new group. This type does not contain sufficient fields to create a new group.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GraphGroupCreationContext {
    /**
     * Optional: If provided, this identifier will be used for the storage key of the created group
     */
    @JsonProperty("storageKey")
    public String storageKey;
}
