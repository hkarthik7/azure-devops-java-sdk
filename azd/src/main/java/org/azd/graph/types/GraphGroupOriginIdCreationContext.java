package org.azd.graph.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Use this type to create a new group using the OriginID as a reference to an existing group from an external AD or
 * AAD backed provider. This is the subset of GraphGroup fields required for creation of a group for the AD and AAD use case.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GraphGroupOriginIdCreationContext extends GraphGroupCreationContext {
    /**
     * This should be the object id or sid of the group from the source AD or AAD provider.
     * Example: d47d025a-ce2f-4a79-8618-e8862ade30dd Team Services will communicate with the source
     * provider to fill all other fields on creation.
     */
    @JsonProperty("originId")
    public String originId;
}
