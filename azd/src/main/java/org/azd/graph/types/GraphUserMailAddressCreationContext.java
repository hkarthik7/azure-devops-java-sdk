package org.azd.graph.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Use this type to create a new user using the mail address as a reference to an existing user from an external AD or
 * AAD backed provider. This is the subset of GraphUser fields required for creation of a GraphUser for the AD and AAD
 * use case when looking up the user by its mail address in the backing provider.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GraphUserMailAddressCreationContext extends GraphUserCreationContext {
    /**
     * This should be the mail address of the user in the source AD or AAD provider.
     * Example: foo.bar@contoso.com Team Services will communicate with the source provider to fill all other fields on creation.
     */
    @JsonProperty("mailAddress")
    public String mailAddress;
}
