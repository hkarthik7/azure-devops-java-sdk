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
public class ReleaseDefinitionShallowReference extends BaseAbstractMethod {
	/**
 	* Gets the links to related resources, APIs, and views for the release definition. 
	**/
	@JsonProperty("_links")
	private Object _links;
	/**
 	* Gets the unique identifier of release definition. 
	**/
	@JsonProperty("id")
	private Integer id;
	/**
 	* Gets or sets the name of the release definition. 
	**/
	@JsonProperty("name")
	private String name;
	/**
 	* Gets or sets the path of the release definition. 
	**/
	@JsonProperty("path")
	private String path;
	/**
 	* Gets or sets project reference. 
	**/
	@JsonProperty("projectReference")
	private ProjectReference projectReference;
	/**
 	* Gets the REST API url to access the release definition. 
	**/
	@JsonProperty("url")
	private String url;

	public Object get_links() { return _links; }

	public void set_links(Object _links) { this._links = _links; }

	public Integer getId() { return id; }

	public void setId(Integer id) { this.id = id; }

	public String getName() { return name; }

	public void setName(String name) { this.name = name; }

	public String getPath() { return path; }

	public void setPath(String path) { this.path = path; }

	public ProjectReference getProjectReference() { return projectReference; }

	public void setProjectReference(ProjectReference projectReference) { this.projectReference = projectReference; }

	public String getUrl() { return url; }

	public void setUrl(String url) { this.url = url; }

}
