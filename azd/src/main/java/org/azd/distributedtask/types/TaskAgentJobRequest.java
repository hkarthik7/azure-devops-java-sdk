package org.azd.distributedtask.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import org.azd.build.types.Demand;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TaskAgentJobRequest {
    @JsonProperty("agentSpecification")
    private JsonNode agentSpecification;
    @JsonProperty("assignTime")
    private String assignTime;
    @JsonProperty("data")
    private JsonNode data;
    @JsonProperty("definition")
    private TaskOrchestrationOwner definition;
    @JsonProperty("demands")
    private List<Demand> demands;
    @JsonProperty("finishTime")
    private String finishTime;
    @JsonProperty("hostId")
    private String hostId;
    @JsonProperty("jobId")
    private String jobId;
    @JsonProperty("jobName")
    private String jobName;
    @JsonProperty("lockedUntil")
    private String lockedUntil;
    @JsonProperty("matchedAgents")
    private TaskAgentReference matchedAgents;
    @JsonProperty("matchesAllAgentsInPool")
    private boolean matchesAllAgentsInPool;
    @JsonProperty("orchestrationId")
    private String orchestrationId;
    @JsonProperty("owner")
    private TaskOrchestrationOwner owner;
    @JsonProperty("planGroup")
    private String planGroup;
    @JsonProperty("planId")
    private String planId;
    @JsonProperty("planType")
    private String planType;
    @JsonProperty("poolId")
    private int poolId;
    @JsonProperty("priority")
    private int priority;
    @JsonProperty("queueId")
    private int queueId;
    @JsonProperty("queueTime")
    private String queueTime;
    @JsonProperty("receiveTime")
    private String receiveTime;
    @JsonProperty("requestId")
    private int requestId;
    @JsonProperty("reservedAgent")
    private TaskAgentReference reservedAgent;
    @JsonProperty("result")
    private String result;
    @JsonProperty("scopeId")
    private String scopeId;
    @JsonProperty("serviceOwner")
    private String serviceOwner;
    @JsonProperty("statusMessage")
    private String statusMessage;
    @JsonProperty("userDelayed")
    private boolean userDelayed;

    public JsonNode getAgentSpecification() {
        return agentSpecification;
    }

    public void setAgentSpecification(JsonNode agentSpecification) {
        this.agentSpecification = agentSpecification;
    }

    public String getAssignTime() {
        return assignTime;
    }

    public void setAssignTime(String assignTime) {
        this.assignTime = assignTime;
    }

    public JsonNode getData() {
        return data;
    }

    public void setData(JsonNode data) {
        this.data = data;
    }

    public TaskOrchestrationOwner getDefinition() {
        return definition;
    }

    public void setDefinition(TaskOrchestrationOwner definition) {
        this.definition = definition;
    }

    public List<Demand> getDemands() {
        return demands;
    }

    public void setDemands(List<Demand> demands) {
        this.demands = demands;
    }

    public String getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(String finishTime) {
        this.finishTime = finishTime;
    }

    public String getHostId() {
        return hostId;
    }

    public void setHostId(String hostId) {
        this.hostId = hostId;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getLockedUntil() {
        return lockedUntil;
    }

    public void setLockedUntil(String lockedUntil) {
        this.lockedUntil = lockedUntil;
    }

    public TaskAgentReference getMatchedAgents() {
        return matchedAgents;
    }

    public void setMatchedAgents(TaskAgentReference matchedAgents) {
        this.matchedAgents = matchedAgents;
    }

    public boolean isMatchesAllAgentsInPool() {
        return matchesAllAgentsInPool;
    }

    public void setMatchesAllAgentsInPool(boolean matchesAllAgentsInPool) {
        this.matchesAllAgentsInPool = matchesAllAgentsInPool;
    }

    public String getOrchestrationId() {
        return orchestrationId;
    }

    public void setOrchestrationId(String orchestrationId) {
        this.orchestrationId = orchestrationId;
    }

    public TaskOrchestrationOwner getOwner() {
        return owner;
    }

    public void setOwner(TaskOrchestrationOwner owner) {
        this.owner = owner;
    }

    public String getPlanGroup() {
        return planGroup;
    }

    public void setPlanGroup(String planGroup) {
        this.planGroup = planGroup;
    }

    public String getPlanId() {
        return planId;
    }

    public void setPlanId(String planId) {
        this.planId = planId;
    }

    public String getPlanType() {
        return planType;
    }

    public void setPlanType(String planType) {
        this.planType = planType;
    }

    public int getPoolId() {
        return poolId;
    }

    public void setPoolId(int poolId) {
        this.poolId = poolId;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getQueueId() {
        return queueId;
    }

    public void setQueueId(int queueId) {
        this.queueId = queueId;
    }

    public String getQueueTime() {
        return queueTime;
    }

    public void setQueueTime(String queueTime) {
        this.queueTime = queueTime;
    }

    public String getReceiveTime() {
        return receiveTime;
    }

    public void setReceiveTime(String receiveTime) {
        this.receiveTime = receiveTime;
    }

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public TaskAgentReference getReservedAgent() {
        return reservedAgent;
    }

    public void setReservedAgent(TaskAgentReference reservedAgent) {
        this.reservedAgent = reservedAgent;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getScopeId() {
        return scopeId;
    }

    public void setScopeId(String scopeId) {
        this.scopeId = scopeId;
    }

    public String getServiceOwner() {
        return serviceOwner;
    }

    public void setServiceOwner(String serviceOwner) {
        this.serviceOwner = serviceOwner;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public boolean isUserDelayed() {
        return userDelayed;
    }

    public void setUserDelayed(boolean userDelayed) {
        this.userDelayed = userDelayed;
    }

    @Override
    public String toString() {
        return "TaskAgentJobRequest{" +
                "agentSpecification=" + agentSpecification +
                ", assignTime='" + assignTime + '\'' +
                ", data=" + data +
                ", definition=" + definition +
                ", demands=" + demands +
                ", finishTime='" + finishTime + '\'' +
                ", hostId='" + hostId + '\'' +
                ", jobId='" + jobId + '\'' +
                ", jobName='" + jobName + '\'' +
                ", lockedUntil='" + lockedUntil + '\'' +
                ", matchedAgents=" + matchedAgents +
                ", matchesAllAgentsInPool=" + matchesAllAgentsInPool +
                ", orchestrationId='" + orchestrationId + '\'' +
                ", owner=" + owner +
                ", planGroup='" + planGroup + '\'' +
                ", planId='" + planId + '\'' +
                ", planType='" + planType + '\'' +
                ", poolId=" + poolId +
                ", priority=" + priority +
                ", queueId=" + queueId +
                ", queueTime='" + queueTime + '\'' +
                ", receiveTime='" + receiveTime + '\'' +
                ", requestId=" + requestId +
                ", reservedAgent=" + reservedAgent +
                ", result='" + result + '\'' +
                ", scopeId='" + scopeId + '\'' +
                ", serviceOwner='" + serviceOwner + '\'' +
                ", statusMessage='" + statusMessage + '\'' +
                ", userDelayed=" + userDelayed +
                '}';
    }
}
