package org.azd.distributedtask.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;

/***
 * A task agent.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TaskAgent {
    /***
     * This agent's access point.
     */
    @JsonProperty("accessPoint")
    private String accessPoint;
    /***
     * The agent cloud request that's currently associated with this agent.
     */
    @JsonProperty("assignedAgentCloudRequest")
    private TaskAgentCloudRequest assignedAgentCloudRequest;
    /***
     * The request which is currently assigned to this agent.
     */
    @JsonProperty("assignedRequest")
    private TaskAgentJobRequest assignedRequest;
    /***
     * Authorization information for this agent.
     */
    @JsonProperty("authorization")
    private TaskAgentAuthorization authorization;
    /***
     * Date on which this agent was created.
     */
    @JsonProperty("createdOn")
    private String createdOn;
    /***
     * Whether or not this agent should run jobs.
     */
    @JsonProperty("enabled")
    private boolean enabled;
    /***
     * Identifier of the agent.
     */
    @JsonProperty("id")
    private int id;
    /***
     * The last request which was completed by this agent.
     */
    @JsonProperty("lastCompletedRequest")
    private TaskAgentJobRequest lastCompletedRequest;
    /***
     * Maximum job parallelism allowed for this agent.
     */
    @JsonProperty("maxParallelism")
    private int maxParallelism;
    /***
     * Name of the agent.
     */
    @JsonProperty("name")
    private String name;
    /***
     * Agent OS.
     */
    @JsonProperty("osDescription")
    private String osDescription;
    /***
     * Pending update for this agent.
     */
    @JsonProperty("pendingUpdate")
    private TaskAgentUpdate pendingUpdate;
    /***
     * The class represents a property bag as a collection of key-value pairs.
     */
    @JsonProperty("properties")
    private JsonNode properties;
    /***
     * Provisioning state of this agent.
     */
    @JsonProperty("provisioningState")
    private String provisioningState;
    /***
     * Whether or not the agent is online.
     */
    @JsonProperty("status")
    private String status;
    /***
     * Date on which the last connectivity status change occurred.
     */
    @JsonProperty("statusChangedOn")
    private String statusChangedOn;
    /***
     * System-defined capabilities supported by this agent's host.
     * Warning: To set capabilities use the PUT method, PUT will completely overwrite existing capabilities.
     */
    @JsonProperty("systemCapabilities")
    private JsonNode systemCapabilities;
    /***
     * User-defined capabilities supported by this agent's host.
     * Warning: To set capabilities use the PUT method, PUT will completely overwrite existing capabilities.
     */
    @JsonProperty("userCapabilities")
    private JsonNode userCapabilities;
    /***
     * Agent version.
     */
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
