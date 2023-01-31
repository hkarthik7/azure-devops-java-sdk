package org.azd.test.types;
/*
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
*/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

/**
 * Test run details. 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class TestResolutionState extends BaseAbstractMethod {
	/**
 	* Test Resolution state Id. 
	**/
	@JsonProperty("id")
	private Integer id;
	/**
 	* Test Resolution State Name. 
	**/
	@JsonProperty("name")
	private String name;
	/**
 	* An abstracted reference to some other resource. This class is used to provide the build data contracts with a uniform way to reference other resources in a way that provides easy traversal through links. 
	**/
	@JsonProperty("project")
	private ShallowReference project;

	public Integer getId() { return id; }

	public void setId(Integer id) { this.id = id; }

	public String getName() { return name; }

	public void setName(String name) { this.name = name; }

	public ShallowReference getProject() { return project; }

	public void setProject(ShallowReference project) { this.project = project; }

}