package org.azd.accounts.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;

/**
 * Data provider
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DataProvider extends SerializableEntity {
    /**
     * Organization provider
     */
    @JsonProperty("ms.vss-features.my-organizations-data-provider")
    private OrganizationsProvider organizationsProvider;

    public OrganizationsProvider getOrganizationsProvider() {
        return organizationsProvider;
    }

    public void setOrganizationsProvider(OrganizationsProvider organizationsProvider) {
        this.organizationsProvider = organizationsProvider;
    }

}
