package org.azd.serviceendpoint.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

import java.util.List;

/***
 * A list of service endpoints
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ServiceEndpoints extends BaseAbstractMethod {
    /***
     * A list of service endpoints
     */
    @JsonProperty("value")
    private List<ServiceEndpoint> serviceEndpoints;

    public List<ServiceEndpoint> getServiceEndpoints() {
        return serviceEndpoints;
    }

    public void setServiceEndpoints(List<ServiceEndpoint> serviceEndpoints) {
        this.serviceEndpoints = serviceEndpoints;
    }

}
