package org.azd.graph.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableCollectionEntity;

import java.util.List;

/**
 * Represents the collection of service principals.
 * <p>
 * Returns continuation token in the headers.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GraphServicePrincipals extends SerializableCollectionEntity {
    /**
     * List of graph service principals.
     */
    @JsonProperty("value")
    private List<GraphServicePrincipal> servicePrincipals;

    public List<GraphServicePrincipal> getServicePrincipals() {
        return servicePrincipals;
    }

    public void setServicePrincipals(List<GraphServicePrincipal> servicePrincipals) {
        this.servicePrincipals = servicePrincipals;
    }
}
