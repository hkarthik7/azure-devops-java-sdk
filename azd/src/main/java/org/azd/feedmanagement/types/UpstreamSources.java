package org.azd.feedmanagement.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UpstreamSources {
    @JsonProperty("deletedDate")
    private String deletedDate;
    @JsonProperty("displayLocation")
    private String displayLocation;
    @JsonProperty("id")
    private String id;
    @JsonProperty("internalUpstreamCollectionId")
    private String internalUpstreamCollectionId;
    @JsonProperty("internalUpstreamFeedId")
    private String internalUpstreamFeedId;
    @JsonProperty("internalUpstreamProjectId")
    private String internalUpstreamProjectId;
    @JsonProperty("internalUpstreamViewId")
    private String internalUpstreamViewId;
    @JsonProperty("location")
    private String location;
    @JsonProperty("name")
    private String name;
    @JsonProperty("protocol")
    private String protocol;
    @JsonProperty("serviceEndpointId")
    private String serviceEndpointId;
    @JsonProperty("serviceEndpointProjectId")
    private String serviceEndpointProjectId;
    @JsonProperty("status")
    private String status;
    @JsonProperty("statusDetails")
    private List<UpstreamStatusDetail> statusDetails;
    @JsonProperty("upstreamSourceType")
    private String upstreamSourceType;

    public String getDeletedDate() {
        return deletedDate;
    }

    public void setDeletedDate(String deletedDate) {
        this.deletedDate = deletedDate;
    }

    public String getInternalUpstreamCollectionId() {
        return internalUpstreamCollectionId;
    }

    public void setInternalUpstreamCollectionId(String internalUpstreamCollectionId) {
        this.internalUpstreamCollectionId = internalUpstreamCollectionId;
    }

    public String getInternalUpstreamFeedId() {
        return internalUpstreamFeedId;
    }

    public void setInternalUpstreamFeedId(String internalUpstreamFeedId) {
        this.internalUpstreamFeedId = internalUpstreamFeedId;
    }

    public String getInternalUpstreamProjectId() {
        return internalUpstreamProjectId;
    }

    public void setInternalUpstreamProjectId(String internalUpstreamProjectId) {
        this.internalUpstreamProjectId = internalUpstreamProjectId;
    }

    public String getInternalUpstreamViewId() {
        return internalUpstreamViewId;
    }

    public void setInternalUpstreamViewId(String internalUpstreamViewId) {
        this.internalUpstreamViewId = internalUpstreamViewId;
    }

    public String getServiceEndpointId() {
        return serviceEndpointId;
    }

    public void setServiceEndpointId(String serviceEndpointId) {
        this.serviceEndpointId = serviceEndpointId;
    }

    public String getServiceEndpointProjectId() {
        return serviceEndpointProjectId;
    }

    public void setServiceEndpointProjectId(String serviceEndpointProjectId) {
        this.serviceEndpointProjectId = serviceEndpointProjectId;
    }

    public List<UpstreamStatusDetail> getStatusDetails() {
        return statusDetails;
    }

    public void setStatusDetails(List<UpstreamStatusDetail> statusDetails) {
        this.statusDetails = statusDetails;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDisplayLocation() {
        return displayLocation;
    }

    public void setDisplayLocation(String displayLocation) {
        this.displayLocation = displayLocation;
    }

    public String getUpstreamSourceType() {
        return upstreamSourceType;
    }

    public void setUpstreamSourceType(String upstreamSourceType) {
        this.upstreamSourceType = upstreamSourceType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "UpstreamSources{" +
                "deletedDate='" + deletedDate + '\'' +
                ", displayLocation='" + displayLocation + '\'' +
                ", id='" + id + '\'' +
                ", internalUpstreamCollectionId='" + internalUpstreamCollectionId + '\'' +
                ", internalUpstreamFeedId='" + internalUpstreamFeedId + '\'' +
                ", internalUpstreamProjectId='" + internalUpstreamProjectId + '\'' +
                ", internalUpstreamViewId='" + internalUpstreamViewId + '\'' +
                ", location='" + location + '\'' +
                ", name='" + name + '\'' +
                ", protocol='" + protocol + '\'' +
                ", serviceEndpointId='" + serviceEndpointId + '\'' +
                ", serviceEndpointProjectId='" + serviceEndpointProjectId + '\'' +
                ", status='" + status + '\'' +
                ", statusDetails=" + statusDetails +
                ", upstreamSourceType='" + upstreamSourceType + '\'' +
                '}';
    }
}
