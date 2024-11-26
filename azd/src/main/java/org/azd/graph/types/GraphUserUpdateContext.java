package org.azd.graph.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Do not attempt to use this type to update user. Use one of the subclasses instead.
 * This type does not contain sufficient fields to create a new user.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GraphUserUpdateContext {
    /**
     * Storage key should not be specified in case of updating user
     */
    @JsonProperty("storageKey")
    public String storageKey;
}
