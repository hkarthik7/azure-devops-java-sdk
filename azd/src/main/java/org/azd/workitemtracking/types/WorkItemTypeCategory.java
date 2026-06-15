package org.azd.workitemtracking.types;

/*
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
*/


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;

import java.util.List;


/**
 * Describes a work item type category.
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class WorkItemTypeCategory extends SerializableEntity {
	/**
 	* Link references to related REST resources. 
	**/
	@JsonProperty("links")
	private Object links;
	/**
 	* Gets or sets the default type of the work item. 
	**/
	@JsonProperty("defaultWorkItemType")
	private WorkItemTypeReference defaultWorkItemType;
	/**
 	* The name of the category. 
	**/
	@JsonProperty("name")
	private String name;
	/**
 	* The reference name of the category. 
	**/
	@JsonProperty("referenceName")
	private String referenceName;
	/**
 	* REST URL for the resource. 
	**/
	@JsonProperty("url")
	private String url;
	/**
 	* The work item types that belong to the category. 
	**/
	@JsonProperty("workItemTypes")
	private List<WorkItemTypeReference> workItemTypes;

	public Object getLinks() { return links; }

	public void setLinks(Object links) { this.links = links; }

	public WorkItemTypeReference getDefaultWorkItemType() { return defaultWorkItemType; }

	public void setDefaultWorkItemType(WorkItemTypeReference defaultWorkItemType) { this.defaultWorkItemType = defaultWorkItemType; }

	public String getName() { return name; }

	public void setName(String name) { this.name = name; }

	public String getReferenceName() { return referenceName; }

	public void setReferenceName(String referenceName) { this.referenceName = referenceName; }

	public String getUrl() { return url; }

	public void setUrl(String url) { this.url = url; }

	public List<WorkItemTypeReference> getWorkItemTypes() { return workItemTypes; }

	public void setWorkItemTypes(List<WorkItemTypeReference> workItemTypes) { this.workItemTypes = workItemTypes; }
}
