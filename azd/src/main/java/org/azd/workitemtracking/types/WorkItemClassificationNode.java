package org.azd.workitemtracking.types;
/*
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
*/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;
import org.azd.enums.TreeNodeStructureType;

import java.util.List;

/**
 * Defines a classification node for work item tracking. 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class WorkItemClassificationNode extends SerializableEntity {
	/**
 	* Link references to related REST resources. 
	**/
	@JsonProperty("_links")
	private Object _links;
	/**
 	* Dictionary that has node attributes like start/finish date for iteration nodes. 
	**/
	@JsonProperty("attributes")
	private Object attributes;
	/**
 	* List of child nodes fetched. 
	**/
	@JsonProperty("children")
	private List<WorkItemClassificationNode> children;
	/**
 	* Flag that indicates if the classification node has any child nodes. 
	**/
	@JsonProperty("hasChildren")
	private Boolean hasChildren;
	/**
 	* Integer ID of the classification node.
	**/
	@JsonProperty("id")
	private Integer id;
	/**
 	* GUID ID of the classification node. 
	**/
	@JsonProperty("identifier")
	private String identifier;
	/**
 	* Name of the classification node. 
	**/
	@JsonProperty("name")
	private String name;
	/**
 	* Path of the classification node. 
	**/
	@JsonProperty("path")
	private String path;
	/**
 	* Node structure type. 
	**/
	@JsonProperty("structureType")
	private TreeNodeStructureType structureType;

	@JsonProperty("url")
	private String url;

	public Object get_links() { return _links; }

	public void set_links(Object _links) { this._links = _links; }

	public Object getAttributes() { return attributes; }

	public void setAttributes(Object attributes) { this.attributes = attributes; }

	public List<WorkItemClassificationNode> getChildren() { return children; }

	public void setChildren(List<WorkItemClassificationNode> children) { this.children = children; }

	public Boolean getHasChildren() { return hasChildren; }

	public void setHasChildren(Boolean hasChildren) { this.hasChildren = hasChildren; }

	public Integer getId() { return id; }

	public void setId(Integer id) { this.id = id; }

	public String getIdentifier() { return identifier; }

	public void setIdentifier(String identifier) { this.identifier = identifier; }

	public String getName() { return name; }

	public void setName(String name) { this.name = name; }

	public String getPath() { return path; }

	public void setPath(String path) { this.path = path; }

	public TreeNodeStructureType getStructureType() { return structureType; }

	public void setStructureType(TreeNodeStructureType structureType) { this.structureType = structureType; }

	public String getUrl() { return url; }

	public void setUrl(String url) { this.url = url; }

}