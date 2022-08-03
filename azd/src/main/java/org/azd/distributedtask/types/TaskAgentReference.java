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
 * None 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class TaskAgentReference extends BaseAbstractMethod {
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
 	* Whether or not this agent should run jobs. 
	**/
	@JsonProperty("enabled")
	private Boolean enabled;
	/**
 	* Identifier of the agent. 
	**/
	@JsonProperty("id")
	private Integer id;
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
 	* Agent version. 
	**/
	@JsonProperty("version")
	private String version;

	public Object get_links() { return _links; }

	public void set_links(Object _links) { this._links = _links; }

	public String getAccessPoint() { return accessPoint; }

	public void setAccessPoint(String accessPoint) { this.accessPoint = accessPoint; }

	public Boolean getEnabled() { return enabled; }

	public void setEnabled(Boolean enabled) { this.enabled = enabled; }

	public Integer getId() { return id; }

	public void setId(Integer id) { this.id = id; }

	public String getName() { return name; }

	public void setName(String name) { this.name = name; }

	public String getOsDescription() { return osDescription; }

	public void setOsDescription(String osDescription) { this.osDescription = osDescription; }

	public String getProvisioningState() { return provisioningState; }

	public void setProvisioningState(String provisioningState) { this.provisioningState = provisioningState; }

	public TaskAgentStatus getStatus() { return status; }

	public void setStatus(TaskAgentStatus status) { this.status = status; }

	public String getVersion() { return version; }

	public void setVersion(String version) { this.version = version; }

}
