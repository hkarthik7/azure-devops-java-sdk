package org.azd.release.types;
/**
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
**/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

/**
 * None 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class VariableGroupProjectReference extends BaseAbstractMethod {
	/**
 	* Gets or sets description of the variable group. 
	**/
	@JsonProperty("description")
	private String description;
	/**
 	* Gets or sets name of the variable group. 
	**/
	@JsonProperty("name")
	private String name;
	/**
 	* Gets or sets project reference of the variable group. 
	**/
	@JsonProperty("projectReference")
	private ProjectReference projectReference;

	public String getDescription() { return description; }

	public void setDescription(String description) { this.description = description; }

	public String getName() { return name; }

	public void setName(String name) { this.name = name; }

	public ProjectReference getProjectReference() { return projectReference; }

	public void setProjectReference(ProjectReference projectReference) { this.projectReference = projectReference; }

}
