package org.azd.feedmanagement.types;
/**
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
**/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

/**
 * The class to represent a collection of REST reference links. 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProjectReference extends BaseAbstractMethod {
	/**
 	* Gets or sets id of the project. 
	**/
	@JsonProperty("id")
	private String id;
	/**
 	* Gets or sets name of the project. 
	**/
	@JsonProperty("name")
	private String name;
	/**
 	* Gets or sets visibility of the project. 
	**/
	@JsonProperty("visibility")
	private String visibility;

	public String getId() { return id; }

	public void setId(String id) { this.id = id; }

	public String getName() { return name; }

	public void setName(String name) { this.name = name; }

	public String getVisibility() { return visibility; }

	public void setVisibility(String visibility) { this.visibility = visibility; }

}
