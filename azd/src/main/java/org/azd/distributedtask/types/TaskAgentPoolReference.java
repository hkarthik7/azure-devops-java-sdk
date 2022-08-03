package org.azd.distributedtask.types;
/**
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
**/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;
import org.azd.enums.TaskAgentPoolOptions;
import org.azd.enums.TaskAgentPoolType;

/**
 * Details about an agent update.
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class TaskAgentPoolReference extends BaseAbstractMethod {
	@JsonProperty("id")
	private int id;
	/**
 	* Gets or sets a value indicating whether or not this pool is managed by the service.
	**/
	@JsonProperty("isHosted")
	private boolean isHosted;
	/**
 	* Determines whether the pool is legacy.
	**/
	@JsonProperty("isLegacy")
	private boolean isLegacy;

	@JsonProperty("name")
	private String name;
	/**
 	* Additional pool settings and details
	**/
	@JsonProperty("options")
	private TaskAgentPoolOptions options;
	/**
 	* Gets or sets the type of the pool
	**/
	@JsonProperty("poolType")
	private TaskAgentPoolType poolType;

	@JsonProperty("scope")
	private String scope;
	/**
 	* Gets the current size of the pool.
	**/
	@JsonProperty("size")
	private int size;

	public int getId() { return id; }

	public void setId(int id) { this.id = id; }

	public boolean getIsHosted() { return isHosted; }

	public void setIsHosted(boolean isHosted) { this.isHosted = isHosted; }

	public boolean getIsLegacy() { return isLegacy; }

	public void setIsLegacy(boolean isLegacy) { this.isLegacy = isLegacy; }

	public String getName() { return name; }

	public void setName(String name) { this.name = name; }

	public TaskAgentPoolOptions getOptions() { return options; }

	public void setOptions(TaskAgentPoolOptions options) { this.options = options; }

	public TaskAgentPoolType getPoolType() { return poolType; }

	public void setPoolType(TaskAgentPoolType poolType) { this.poolType = poolType; }

	public String getScope() { return scope; }

	public void setScope(String scope) { this.scope = scope; }

	public int getSize() { return size; }

	public void setSize(int size) { this.size = size; }

}
