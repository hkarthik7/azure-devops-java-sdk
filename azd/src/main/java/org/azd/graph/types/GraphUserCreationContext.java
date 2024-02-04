package org.azd.graph.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Do not attempt to use this type to create a new user. Use one of the subclasses instead.
 * This type does not contain sufficient fields to create a new user.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GraphUserCreationContext {
    /**
     * Optional: If provided, we will use this identifier for the storage key of the created user
     */
    @JsonProperty("storageKey")
    public String storageKey;
}
