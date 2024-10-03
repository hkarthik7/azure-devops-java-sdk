package org.azd.locations.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ConnectionData extends SerializableEntity {
    @JsonProperty("authenticatedUser")
    private AuthenticatedUser authenticatedUser;
    @JsonProperty("authorizedUser")
    private AuthorizedUser authorizedUser;
    @JsonProperty("instanceId")
    private String instanceId;
    @JsonProperty("deploymentId")
    private String deploymentId;
    @JsonProperty("deploymentType")
    private String deploymentType;
    @JsonProperty("locationServiceData")
    private LocationServiceData locationServiceData;

    public AuthenticatedUser getAuthenticatedUser() {
        return authenticatedUser;
    }

    public void setAuthenticatedUser(AuthenticatedUser authenticatedUser) {
        this.authenticatedUser = authenticatedUser;
    }

    public AuthorizedUser getAuthorizedUser() {
        return authorizedUser;
    }

    public void setAuthorizedUser(AuthorizedUser authorizedUser) {
        this.authorizedUser = authorizedUser;
    }

    public String getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId;
    }

    public String getDeploymentId() {
        return deploymentId;
    }

    public void setDeploymentId(String deploymentId) {
        this.deploymentId = deploymentId;
    }

    public String getDeploymentType() {
        return deploymentType;
    }

    public void setDeploymentType(String deploymentType) {
        this.deploymentType = deploymentType;
    }

    public LocationServiceData getLocationServiceData() {
        return locationServiceData;
    }

    public void setLocationServiceData(LocationServiceData locationServiceData) {
        this.locationServiceData = locationServiceData;
    }
}
