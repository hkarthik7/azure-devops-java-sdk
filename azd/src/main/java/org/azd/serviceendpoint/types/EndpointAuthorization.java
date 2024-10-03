package org.azd.serviceendpoint.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;

/**
 * Represents the authorization used for service endpoint.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class EndpointAuthorization extends SerializableEntity {
    /**
     * Gets or sets the parameters for the selected authorization scheme.
     */
    @JsonProperty("parameters")
    private Object parameters;
    /**
     * Gets or sets the scheme used for service endpoint authentication.
     */
    @JsonProperty("scheme")
    private String scheme;

    public Object getParameters() {
        return parameters;
    }

    public void setParameters(Object parameters) {
        this.parameters = parameters;
    }

    public String getScheme() {
        return scheme;
    }

    public void setScheme(String scheme) {
        this.scheme = scheme;
    }
}
