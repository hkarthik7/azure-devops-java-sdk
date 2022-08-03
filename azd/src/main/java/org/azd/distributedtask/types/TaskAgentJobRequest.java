package org.azd.distributedtask.types;
/**
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
**/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;
import org.azd.enums.TaskResult;

import java.util.List;

/**
 * A reference to an agent. 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class TaskAgentJobRequest extends BaseAbstractMethod {
	/**
 	* Represents a JSON object. 
	**/
	@JsonProperty("agentSpecification")
	private Object agentSpecification;
	/**
 	* The date/time this request was assigned. 
	**/
	@JsonProperty("assignTime")
	private String assignTime;
	/**
 	* Additional data about the request. 
	**/
	@JsonProperty("data")
	private Object data;
	/**
 	* The pipeline definition associated with this request 
	**/
	@JsonProperty("definition")
	private TaskOrchestrationOwner definition;
	/**
 	* A list of demands required to fulfill this request. 
	**/
	@JsonProperty("demands")
	private List<Demand> demands;
	/**
 	* The date/time this request was finished. 
	**/
	@JsonProperty("finishTime")
	private String finishTime;
	/**
 	* The host which triggered this request. 
	**/
	@JsonProperty("hostId")
	private String hostId;
	/**
 	* ID of the job resulting from this request. 
	**/
	@JsonProperty("jobId")
	private String jobId;
	/**
 	* Name of the job resulting from this request. 
	**/
	@JsonProperty("jobName")
	private String jobName;
	/**
 	* The deadline for the agent to renew the lock. 
	**/
	@JsonProperty("lockedUntil")
	private String lockedUntil;
	/**
 	* A reference to an agent. 
	**/
	@JsonProperty("matchedAgents")
	private List<TaskAgentReference> matchedAgents;

	@JsonProperty("matchesAllAgentsInPool")
	private boolean matchesAllAgentsInPool;

	@JsonProperty("orchestrationId")
	private String orchestrationId;
	/**
 	* The pipeline associated with this request 
	**/
	@JsonProperty("owner")
	private TaskOrchestrationOwner owner;

	@JsonProperty("planGroup")
	private String planGroup;
	/**
 	* Internal ID for the orchestration plan connected with this request. 
	**/
	@JsonProperty("planId")
	private String planId;
	/**
 	* Internal detail representing the type of orchestration plan. 
	**/
	@JsonProperty("planType")
	private String planType;
	/**
 	* The ID of the pool this request targets 
	**/
	@JsonProperty("poolId")
	private Integer poolId;

	@JsonProperty("priority")
	private Integer priority;
	/**
 	* The ID of the queue this request targets 
	**/
	@JsonProperty("queueId")
	private Integer queueId;
	/**
 	* The date/time this request was queued. 
	**/
	@JsonProperty("queueTime")
	private String queueTime;
	/**
 	* The date/time this request was receieved by an agent. 
	**/
	@JsonProperty("receiveTime")
	private String receiveTime;
	/**
 	* ID of the request. 
	**/
	@JsonProperty("requestId")
	private Integer requestId;
	/**
 	* The agent allocated for this request. 
	**/
	@JsonProperty("reservedAgent")
	private TaskAgentReference reservedAgent;
	/**
 	* The result of this request. 
	**/
	@JsonProperty("result")
	private TaskResult result;
	/**
 	* Scope of the pipeline; matches the project ID. 
	**/
	@JsonProperty("scopeId")
	private String scopeId;
	/**
 	* The service which owns this request. 
	**/
	@JsonProperty("serviceOwner")
	private String serviceOwner;

	@JsonProperty("statusMessage")
	private String statusMessage;

	@JsonProperty("userDelayed")
	private boolean userDelayed;

	public Object getAgentSpecification() { return agentSpecification; }

	public void setAgentSpecification(Object agentSpecification) { this.agentSpecification = agentSpecification; }

	public String getAssignTime() { return assignTime; }

	public void setAssignTime(String assignTime) { this.assignTime = assignTime; }

	public Object getData() { return data; }

	public void setData(Object data) { this.data = data; }

	public TaskOrchestrationOwner getDefinition() { return definition; }

	public void setDefinition(TaskOrchestrationOwner definition) { this.definition = definition; }

	public List<Demand> getDemands() { return demands; }

	public void setDemands(List<Demand> demands) { this.demands = demands; }

	public String getFinishTime() { return finishTime; }

	public void setFinishTime(String finishTime) { this.finishTime = finishTime; }

	public String getHostId() { return hostId; }

	public void setHostId(String hostId) { this.hostId = hostId; }

	public String getJobId() { return jobId; }

	public void setJobId(String jobId) { this.jobId = jobId; }

	public String getJobName() { return jobName; }

	public void setJobName(String jobName) { this.jobName = jobName; }

	public String getLockedUntil() { return lockedUntil; }

	public void setLockedUntil(String lockedUntil) { this.lockedUntil = lockedUntil; }

	public List<TaskAgentReference> getMatchedAgents() { return matchedAgents; }

	public void setMatchedAgents(List<TaskAgentReference> matchedAgents) { this.matchedAgents = matchedAgents; }

	public boolean getMatchesAllAgentsInPool() { return matchesAllAgentsInPool; }

	public void setMatchesAllAgentsInPool(boolean matchesAllAgentsInPool) { this.matchesAllAgentsInPool = matchesAllAgentsInPool; }

	public String getOrchestrationId() { return orchestrationId; }

	public void setOrchestrationId(String orchestrationId) { this.orchestrationId = orchestrationId; }

	public TaskOrchestrationOwner getOwner() { return owner; }

	public void setOwner(TaskOrchestrationOwner owner) { this.owner = owner; }

	public String getPlanGroup() { return planGroup; }

	public void setPlanGroup(String planGroup) { this.planGroup = planGroup; }

	public String getPlanId() { return planId; }

	public void setPlanId(String planId) { this.planId = planId; }

	public String getPlanType() { return planType; }

	public void setPlanType(String planType) { this.planType = planType; }

	public Integer getPoolId() { return poolId; }

	public void setPoolId(Integer poolId) { this.poolId = poolId; }

	public Integer getPriority() { return priority; }

	public void setPriority(Integer priority) { this.priority = priority; }

	public Integer getQueueId() { return queueId; }

	public void setQueueId(Integer queueId) { this.queueId = queueId; }

	public String getQueueTime() { return queueTime; }

	public void setQueueTime(String queueTime) { this.queueTime = queueTime; }

	public String getReceiveTime() { return receiveTime; }

	public void setReceiveTime(String receiveTime) { this.receiveTime = receiveTime; }

	public Integer getRequestId() { return requestId; }

	public void setRequestId(Integer requestId) { this.requestId = requestId; }

	public TaskAgentReference getReservedAgent() { return reservedAgent; }

	public void setReservedAgent(TaskAgentReference reservedAgent) { this.reservedAgent = reservedAgent; }

	public TaskResult getResult() { return result; }

	public void setResult(TaskResult result) { this.result = result; }

	public String getScopeId() { return scopeId; }

	public void setScopeId(String scopeId) { this.scopeId = scopeId; }

	public String getServiceOwner() { return serviceOwner; }

	public void setServiceOwner(String serviceOwner) { this.serviceOwner = serviceOwner; }

	public String getStatusMessage() { return statusMessage; }

	public void setStatusMessage(String statusMessage) { this.statusMessage = statusMessage; }

	public boolean getUserDelayed() { return userDelayed; }

	public void setUserDelayed(boolean userDelayed) { this.userDelayed = userDelayed; }

}
