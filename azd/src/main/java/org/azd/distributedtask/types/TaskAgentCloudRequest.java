package org.azd.distributedtask.types;
/**
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
**/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

/**
 * Represents the public key portion of an RSA asymmetric key. 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class TaskAgentCloudRequest extends BaseAbstractMethod {
	/**
 	* A reference to an agent. 
	**/
	@JsonProperty("agent")
	private TaskAgentReference agent;

	@JsonProperty("agentCloudId")
	private Integer agentCloudId;

	@JsonProperty("agentConnectedTime")
	private String agentConnectedTime;
	/**
 	* Represents a JSON object. 
	**/
	@JsonProperty("agentData")
	private Object agentData;
	/**
 	* Represents a JSON object. 
	**/
	@JsonProperty("agentSpecification")
	private Object agentSpecification;

	@JsonProperty("pool")
	private TaskAgentPoolReference pool;

	@JsonProperty("provisionRequestTime")
	private String provisionRequestTime;

	@JsonProperty("provisionedTime")
	private String provisionedTime;

	@JsonProperty("releaseRequestTime")
	private String releaseRequestTime;

	@JsonProperty("requestId")
	private String requestId;

	public TaskAgentReference getAgent() { return agent; }

	public void setAgent(TaskAgentReference agent) { this.agent = agent; }

	public Integer getAgentCloudId() { return agentCloudId; }

	public void setAgentCloudId(Integer agentCloudId) { this.agentCloudId = agentCloudId; }

	public String getAgentConnectedTime() { return agentConnectedTime; }

	public void setAgentConnectedTime(String agentConnectedTime) { this.agentConnectedTime = agentConnectedTime; }

	public Object getAgentData() { return agentData; }

	public void setAgentData(Object agentData) { this.agentData = agentData; }

	public Object getAgentSpecification() { return agentSpecification; }

	public void setAgentSpecification(Object agentSpecification) { this.agentSpecification = agentSpecification; }

	public TaskAgentPoolReference getPool() { return pool; }

	public void setPool(TaskAgentPoolReference pool) { this.pool = pool; }

	public String getProvisionRequestTime() { return provisionRequestTime; }

	public void setProvisionRequestTime(String provisionRequestTime) { this.provisionRequestTime = provisionRequestTime; }

	public String getProvisionedTime() { return provisionedTime; }

	public void setProvisionedTime(String provisionedTime) { this.provisionedTime = provisionedTime; }

	public String getReleaseRequestTime() { return releaseRequestTime; }

	public void setReleaseRequestTime(String releaseRequestTime) { this.releaseRequestTime = releaseRequestTime; }

	public String getRequestId() { return requestId; }

	public void setRequestId(String requestId) { this.requestId = requestId; }

}
