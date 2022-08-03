package org.azd.release.types;
/**
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
**/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.Author;
import org.azd.common.types.BaseAbstractMethod;
import org.azd.distributedtask.types.VariableGroupProviderData;

import java.util.List;
import java.util.Map;

/**
 * None 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class VariableGroup extends BaseAbstractMethod {
	/**
 	* Gets or sets the identity who created. 
	**/
	@JsonProperty("createdBy")
	private Author createdBy;
	/**
 	* Gets date on which it got created. 
	**/
	@JsonProperty("createdOn")
	private String createdOn;
	/**
 	* Gets or sets description. 
	**/
	@JsonProperty("description")
	private String description;
	/**
 	* Gets the unique identifier of this field. 
	**/
	@JsonProperty("id")
	private int id;
	/**
 	* Denotes if a variable group is shared with other project or not. 
	**/
	@JsonProperty("isShared")
	private boolean isShared;
	/**
 	* Gets or sets the identity who modified. 
	**/
	@JsonProperty("modifiedBy")
	private Author modifiedBy;
	/**
 	* Gets date on which it got modified. 
	**/
	@JsonProperty("modifiedOn")
	private String modifiedOn;
	/**
 	* Gets or sets name. 
	**/
	@JsonProperty("name")
	private String name;
	/**
 	* Gets or sets provider data. 
	**/
	@JsonProperty("providerData")
	private VariableGroupProviderData providerData;
	/**
 	* Gets or sets type. 
	**/
	@JsonProperty("type")
	private String type;
	/**
 	* all project references where the variable group is shared with other projects. 
	**/
	@JsonProperty("variableGroupProjectReferences")
	private List<VariableGroupProjectReference> variableGroupProjectReferences;
	/**
 	* Gets and sets the dictionary of variables. 
	**/
	@JsonProperty("variables")
	private Map<String, VariableValue> variables;

	public Author getCreatedBy() { return createdBy; }

	public void setCreatedBy(Author createdBy) { this.createdBy = createdBy; }

	public String getCreatedOn() { return createdOn; }

	public void setCreatedOn(String createdOn) { this.createdOn = createdOn; }

	public String getDescription() { return description; }

	public void setDescription(String description) { this.description = description; }

	public int getId() { return id; }

	public void setId(int id) { this.id = id; }

	public boolean getIsShared() { return isShared; }

	public void setIsShared(boolean isShared) { this.isShared = isShared; }

	public Author getModifiedBy() { return modifiedBy; }

	public void setModifiedBy(Author modifiedBy) { this.modifiedBy = modifiedBy; }

	public String getModifiedOn() { return modifiedOn; }

	public void setModifiedOn(String modifiedOn) { this.modifiedOn = modifiedOn; }

	public String getName() { return name; }

	public void setName(String name) { this.name = name; }

	public VariableGroupProviderData getProviderData() { return providerData; }

	public void setProviderData(VariableGroupProviderData providerData) { this.providerData = providerData; }

	public String getType() { return type; }

	public void setType(String type) { this.type = type; }

	public List<VariableGroupProjectReference> getVariableGroupProjectReferences() { return variableGroupProjectReferences; }

	public void setVariableGroupProjectReferences(List<VariableGroupProjectReference> variableGroupProjectReferences) { this.variableGroupProjectReferences = variableGroupProjectReferences; }

	public Map<String, VariableValue> getVariables() { return variables; }

	public void setVariables(Map<String, VariableValue> variables) { this.variables = variables; }

}
