package org.azd.accounts.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;

import java.util.List;

/**
 * List of organization
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrganizationsProvider extends SerializableEntity {
    /**
     * List of organization
     */
    @JsonProperty("organizations")
    private List<Organization> organizations;

    public List<Organization> getOrganizations() {
        return organizations;
    }

    public void setOrganizations(List<Organization> organizations) {
        this.organizations = organizations;
    }

}
