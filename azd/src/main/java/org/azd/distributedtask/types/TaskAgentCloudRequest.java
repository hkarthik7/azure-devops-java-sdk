package org.azd.distributedtask.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;

/***
 * The agent cloud request that's currently associated with this agent.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TaskAgentCloudRequest {
    /***
     * A reference to an agent.
     */
    @JsonProperty("agent")
    private TaskAgentReference agent;
    /***
     * Agent cloud id
     */
    @JsonProperty("agentCloudId")
    private int agentCloudId;
    /***
     * Agent connected time
     */
    @JsonProperty("agentConnectedTime")
    private String agentConnectedTime;
    /***
     * Represents a JSON object.
     */
    @JsonProperty("agentData")
    private JsonNode agentData;
    /***
     * Represents a JSON object.
     */
    @JsonProperty("agentSpecification")
    private JsonNode agentSpecification;
    /***
     * Task Pool reference
     */
    @JsonProperty("pool")
    private TaskAgentPoolReference pool;
    /***
     * Provision request time
     */
    @JsonProperty("provisionRequestTime")
    private String provisionRequestTime;
    /***
     * Provisioned time
     */
    @JsonProperty("provisionedTime")
    private String provisionedTime;
    /***
     * Release request time
     */
    @JsonProperty("releaseRequestTime")
    private String releaseRequestTime;
    /***
     * Request id
     */
    @JsonProperty("requestId")
    private String requestId;

    public TaskAgentReference getAgent() {
        return agent;
    }

    public void setAgent(TaskAgentReference agent) {
        this.agent = agent;
    }

    public int getAgentCloudId() {
        return agentCloudId;
    }

    public void setAgentCloudId(int agentCloudId) {
        this.agentCloudId = agentCloudId;
    }

    public String getAgentConnectedTime() {
        return agentConnectedTime;
    }

    public void setAgentConnectedTime(String agentConnectedTime) {
        this.agentConnectedTime = agentConnectedTime;
    }

    public JsonNode getAgentData() {
        return agentData;
    }

    public void setAgentData(JsonNode agentData) {
        this.agentData = agentData;
    }

    public JsonNode getAgentSpecification() {
        return agentSpecification;
    }

    public void setAgentSpecification(JsonNode agentSpecification) {
        this.agentSpecification = agentSpecification;
    }

    public TaskAgentPoolReference getPool() {
        return pool;
    }

    public void setPool(TaskAgentPoolReference pool) {
        this.pool = pool;
    }

    public String getProvisionRequestTime() {
        return provisionRequestTime;
    }

    public void setProvisionRequestTime(String provisionRequestTime) {
        this.provisionRequestTime = provisionRequestTime;
    }

    public String getProvisionedTime() {
        return provisionedTime;
    }

    public void setProvisionedTime(String provisionedTime) {
        this.provisionedTime = provisionedTime;
    }

    public String getReleaseRequestTime() {
        return releaseRequestTime;
    }

    public void setReleaseRequestTime(String releaseRequestTime) {
        this.releaseRequestTime = releaseRequestTime;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    @Override
    public String toString() {
        return "TaskAgentCloudRequest{" +
                "agent=" + agent +
                ", agentCloudId=" + agentCloudId +
                ", agentConnectedTime='" + agentConnectedTime + '\'' +
                ", agentData=" + agentData +
                ", agentSpecification=" + agentSpecification +
                ", pool=" + pool +
                ", provisionRequestTime='" + provisionRequestTime + '\'' +
                ", provisionedTime='" + provisionedTime + '\'' +
                ", releaseRequestTime='" + releaseRequestTime + '\'' +
                ", requestId='" + requestId + '\'' +
                '}';
    }
}
