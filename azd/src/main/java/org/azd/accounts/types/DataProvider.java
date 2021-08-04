package org.azd.accounts.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/***
 * Data provider
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DataProvider {
    /***
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

    @Override
    public String toString() {
        return "DataProvider{" +
                "organizationsProvider=" + organizationsProvider +
                '}';
    }
}
