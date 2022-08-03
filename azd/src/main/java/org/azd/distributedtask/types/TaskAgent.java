package org.azd.distributedtask.types;
/**
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
**/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;
import org.azd.enums.TaskAgentStatus;

/**
 * Additional pool settings and details 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class TaskAgent extends BaseAbstractMethod {
	/**
 	* The class to represent a collection of REST reference links. 
	**/
	@JsonProperty("_links")
	private Object _links;
	/**
 	* This agent's access point. 
	**/
	@JsonProperty("accessPoint")
	private String accessPoint;
	/**
 	* The agent cloud request that's currently associated with this agent. 
	**/
	@JsonProperty("assignedAgentCloudRequest")
	private TaskAgentCloudRequest assignedAgentCloudRequest;
	/**
 	* The request which is currently assigned to this agent. 
	**/
	@JsonProperty("assignedRequest")
	private TaskAgentJobRequest assignedRequest;
	/**
 	* Authorization information for this agent. 
	**/
	@JsonProperty("authorization")
	private TaskAgentAuthorization authorization;
	/**
 	* Date on which this agent was created. 
	**/
	@JsonProperty("createdOn")
	private String createdOn;
	/**
 	* Whether or not this agent should run jobs. 
	**/
	@JsonProperty("enabled")
	private boolean enabled;
	/**
 	* Identifier of the agent. 
	**/
	@JsonProperty("id")
	private int id;
	/**
 	* The last request which was completed by this agent. 
	**/
	@JsonProperty("lastCompletedRequest")
	private TaskAgentJobRequest lastCompletedRequest;
	/**
 	* Maximum job parallelism allowed for this agent. 
	**/
	@JsonProperty("maxParallelism")
	private int maxParallelism;
	/**
 	* Name of the agent. 
	**/
	@JsonProperty("name")
	private String name;
	/**
 	* Agent OS. 
	**/
	@JsonProperty("osDescription")
	private String osDescription;
	/**
 	* Pending update for this agent. 
	**/
	@JsonProperty("pendingUpdate")
	private TaskAgentUpdate pendingUpdate;
	/**
 	* The class represents a property bag as a collection of key-value pairs. Values of all primitive types (any type with a TypeCode != TypeCode.Object) except for DBNull are accepted. Values of type Byte[], Int32, Double, DateType and String preserve their type, other primitives are retuned as a String. Byte[] expected as base64 encoded string. 
	**/
	@JsonProperty("properties")
	private PropertiesCollection properties;
	/**
 	* Provisioning state of this agent. 
	**/
	@JsonProperty("provisioningState")
	private String provisioningState;
	/**
 	* Whether or not the agent is online. 
	**/
	@JsonProperty("status")
	private TaskAgentStatus status;
	/**
 	* Date on which the last connectivity status change occurred. 
	**/
	@JsonProperty("statusChangedOn")
	private String statusChangedOn;
	/**
 	* System-defined capabilities supported by this agent's host. Warning: To set capabilities use the PUT method, PUT will completely overwrite existing capabilities. 
	**/
	@JsonProperty("systemCapabilities")
	private Object systemCapabilities;
	/**
 	* User-defined capabilities supported by this agent's host. Warning: To set capabilities use the PUT method, PUT will completely overwrite existing capabilities. 
	**/
	@JsonProperty("userCapabilities")
	private Object userCapabilities;
	/**
 	* Agent version. 
	**/
	@JsonProperty("version")
	private String version;

	public Object get_links() { return _links; }

	public void set_links(Object _links) { this._links = _links; }

	public String getAccessPoint() { return accessPoint; }

	public void setAccessPoint(String accessPoint) { this.accessPoint = accessPoint; }

	public TaskAgentCloudRequest getAssignedAgentCloudRequest() { return assignedAgentCloudRequest; }

	public void setAssignedAgentCloudRequest(TaskAgentCloudRequest assignedAgentCloudRequest) { this.assignedAgentCloudRequest = assignedAgentCloudRequest; }

	public TaskAgentJobRequest getAssignedRequest() { return assignedRequest; }

	public void setAssignedRequest(TaskAgentJobRequest assignedRequest) { this.assignedRequest = assignedRequest; }

	public TaskAgentAuthorization getAuthorization() { return authorization; }

	public void setAuthorization(TaskAgentAuthorization authorization) { this.authorization = authorization; }

	public String getCreatedOn() { return createdOn; }

	public void setCreatedOn(String createdOn) { this.createdOn = createdOn; }

	public boolean getEnabled() { return enabled; }

	public void setEnabled(boolean enabled) { this.enabled = enabled; }

	public int getId() { return id; }

	public void setId(int id) { this.id = id; }

	public TaskAgentJobRequest getLastCompletedRequest() { return lastCompletedRequest; }

	public void setLastCompletedRequest(TaskAgentJobRequest lastCompletedRequest) { this.lastCompletedRequest = lastCompletedRequest; }

	public int getMaxParallelism() { return maxParallelism; }

	public void setMaxParallelism(int maxParallelism) { this.maxParallelism = maxParallelism; }

	public String getName() { return name; }

	public void setName(String name) { this.name = name; }

	public String getOsDescription() { return osDescription; }

	public void setOsDescription(String osDescription) { this.osDescription = osDescription; }

	public TaskAgentUpdate getPendingUpdate() { return pendingUpdate; }

	public void setPendingUpdate(TaskAgentUpdate pendingUpdate) { this.pendingUpdate = pendingUpdate; }

	public PropertiesCollection getProperties() { return properties; }

	public void setProperties(PropertiesCollection properties) { this.properties = properties; }

	public String getProvisioningState() { return provisioningState; }

	public void setProvisioningState(String provisioningState) { this.provisioningState = provisioningState; }

	public TaskAgentStatus getStatus() { return status; }

	public void setStatus(TaskAgentStatus status) { this.status = status; }

	public String getStatusChangedOn() { return statusChangedOn; }

	public void setStatusChangedOn(String statusChangedOn) { this.statusChangedOn = statusChangedOn; }

	public Object getSystemCapabilities() { return systemCapabilities; }

	public void setSystemCapabilities(Object systemCapabilities) { this.systemCapabilities = systemCapabilities; }

	public Object getUserCapabilities() { return userCapabilities; }

	public void setUserCapabilities(Object userCapabilities) { this.userCapabilities = userCapabilities; }

	public String getVersion() { return version; }

	public void setVersion(String version) { this.version = version; }

}
