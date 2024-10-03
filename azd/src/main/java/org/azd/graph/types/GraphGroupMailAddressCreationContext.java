package org.azd.graph.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Use this type to create a new group using the mail address as a reference to an existing group from an external AD
 * or AAD backed provider. This is the subset of GraphGroup fields required for creation of a
 * group for the AAD and AD use case.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GraphGroupMailAddressCreationContext extends GraphGroupCreationContext {
    /**
     * This should be the mail address or the group in the source AD or AAD provider.
     * Example: test@contoso.com Team Services will communicate with the source provider to fill all other fields on creation.
     */
    @JsonProperty("mailAddress")
    public String mailAddress;
}
