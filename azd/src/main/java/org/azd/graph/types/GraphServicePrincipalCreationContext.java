package org.azd.graph.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Do not attempt to use this type to create a new service principal. Use one of the subclasses instead.
 * This type does not contain sufficient fields to create a new service principal.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GraphServicePrincipalCreationContext {
    /**
     * Optional: If provided, we will use this identifier for the storage key of the created service principal
     */
    @JsonProperty("storageKey")
    public String storageKey;
}
