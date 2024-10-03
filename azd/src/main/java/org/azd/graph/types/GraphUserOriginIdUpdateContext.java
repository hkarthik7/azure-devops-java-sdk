package org.azd.graph.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Use this type to update an existing user using the OriginID as a reference to an existing user from an external AD
 * or AAD backed provider. This is the subset of GraphUser fields required for creation of a GraphUser for the AD and
 * AAD use case when looking up the user by its unique ID in the backing provider.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GraphUserOriginIdUpdateContext extends GraphUserUpdateContext {
    /**
     * This should be the object id or sid of the user from the source AD or AAD provider.
     * Example: d47d025a-ce2f-4a79-8618-e8862ade30dd Azure Devops will communicate with the source provider to
     * fill all other fields on creation.
     */
    @JsonProperty("originId")
    public String originId;
}
