package org.azd.distributedtask.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TaskAgent {
    @JsonProperty("accessPoint")
    private String accessPoint;
    @JsonProperty("assignedAgentCloudRequest")
    private TaskAgentCloudRequest assignedAgentCloudRequest;
    @JsonProperty("assignedRequest")
    private TaskAgentJobRequest assignedRequest;
    @JsonProperty("authorization")
    private TaskAgentAuthorization authorization;
    @JsonProperty("createdOn")
    private String createdOn;
    @JsonProperty("enabled")
    private boolean enabled;
    @JsonProperty("id")
    private int id;
    @JsonProperty("lastCompletedRequest")
    private TaskAgentJobRequest lastCompletedRequest;
    @JsonProperty("maxParallelism")
    private int maxParallelism;
    @JsonProperty("name")
    private String name;
    @JsonProperty("osDescription")
    private String osDescription;
    @JsonProperty("pendingUpdate")
    private TaskAgentUpdate pendingUpdate;
    @JsonProperty("properties")
    private JsonNode properties;
    @JsonProperty("provisioningState")
    private String provisioningState;
    @JsonProperty("status")
    private String status;
    @JsonProperty("statusChangedOn")
    private String statusChangedOn;
    @JsonProperty("systemCapabilities")
    private JsonNode systemCapabilities;
    @JsonProperty("userCapabilities")
    private JsonNode userCapabilities;
    @JsonProperty("version")
    private String version;

    public String getAccessPoint() {
        return accessPoint;
    }

    public void setAccessPoint(String accessPoint) {
        this.accessPoint = accessPoint;
    }

    public TaskAgentCloudRequest getAssignedAgentCloudRequest() {
        return assignedAgentCloudRequest;
    }

    public void setAssignedAgentCloudRequest(TaskAgentCloudRequest assignedAgentCloudRequest) {
        this.assignedAgentCloudRequest = assignedAgentCloudRequest;
    }

    public TaskAgentJobRequest getAssignedRequest() {
        return assignedRequest;
    }

    public void setAssignedRequest(TaskAgentJobRequest assignedRequest) {
        this.assignedRequest = assignedRequest;
    }

    public TaskAgentAuthorization getAuthorization() {
        return authorization;
    }

    public void setAuthorization(TaskAgentAuthorization authorization) {
        this.authorization = authorization;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TaskAgentJobRequest getLastCompletedRequest() {
        return lastCompletedRequest;
    }

    public void setLastCompletedRequest(TaskAgentJobRequest lastCompletedRequest) {
        this.lastCompletedRequest = lastCompletedRequest;
    }

    public int getMaxParallelism() {
        return maxParallelism;
    }

    public void setMaxParallelism(int maxParallelism) {
        this.maxParallelism = maxParallelism;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOsDescription() {
        return osDescription;
    }

    public void setOsDescription(String osDescription) {
        this.osDescription = osDescription;
    }

    public TaskAgentUpdate getPendingUpdate() {
        return pendingUpdate;
    }

    public void setPendingUpdate(TaskAgentUpdate pendingUpdate) {
        this.pendingUpdate = pendingUpdate;
    }

    public JsonNode getProperties() {
        return properties;
    }

    public void setProperties(JsonNode properties) {
        this.properties = properties;
    }

    public String getProvisioningState() {
        return provisioningState;
    }

    public void setProvisioningState(String provisioningState) {
        this.provisioningState = provisioningState;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusChangedOn() {
        return statusChangedOn;
    }

    public void setStatusChangedOn(String statusChangedOn) {
        this.statusChangedOn = statusChangedOn;
    }

    public JsonNode getSystemCapabilities() {
        return systemCapabilities;
    }

    public void setSystemCapabilities(JsonNode systemCapabilities) {
        this.systemCapabilities = systemCapabilities;
    }

    public JsonNode getUserCapabilities() {
        return userCapabilities;
    }

    public void setUserCapabilities(JsonNode userCapabilities) {
        this.userCapabilities = userCapabilities;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "TaskAgent{" +
                "accessPoint='" + accessPoint + '\'' +
                ", assignedAgentCloudRequest=" + assignedAgentCloudRequest +
                ", assignedRequest=" + assignedRequest +
                ", authorization=" + authorization +
                ", createdOn='" + createdOn + '\'' +
                ", enabled=" + enabled +
                ", id=" + id +
                ", lastCompletedRequest=" + lastCompletedRequest +
                ", maxParallelism=" + maxParallelism +
                ", name='" + name + '\'' +
                ", osDescription='" + osDescription + '\'' +
                ", pendingUpdate=" + pendingUpdate +
                ", properties=" + properties +
                ", provisioningState='" + provisioningState + '\'' +
                ", status='" + status + '\'' +
                ", statusChangedOn='" + statusChangedOn + '\'' +
                ", systemCapabilities=" + systemCapabilities +
                ", userCapabilities=" + userCapabilities +
                ", version='" + version + '\'' +
                '}';
    }
}
