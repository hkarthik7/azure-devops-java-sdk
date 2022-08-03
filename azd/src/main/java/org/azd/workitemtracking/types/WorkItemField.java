package org.azd.workitemtracking.types;
/**
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
**/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;
import org.azd.enums.FieldType;
import org.azd.enums.FieldUsage;

import java.util.List;

/**
 * Describes a field on a work item and it's properties specific to that work item type. 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class WorkItemField extends BaseAbstractMethod {
	/**
 	* Link references to related REST resources. 
	**/
	@JsonProperty("_links")
	private Object _links;
	/**
 	* Indicates whether the field is sortable in server queries. 
	**/
	@JsonProperty("canSortBy")
	private boolean canSortBy;
	/**
 	* The description of the field. 
	**/
	@JsonProperty("description")
	private String description;
	/**
 	* Indicates whether this field is deleted. 
	**/
	@JsonProperty("isDeleted")
	private boolean isDeleted;
	/**
 	* Indicates whether this field is an identity field. 
	**/
	@JsonProperty("isIdentity")
	private boolean isIdentity;
	/**
 	* Indicates whether this instance is picklist. 
	**/
	@JsonProperty("isPicklist")
	private boolean isPicklist;
	/**
 	* Indicates whether this instance is a suggested picklist . 
	**/
	@JsonProperty("isPicklistSuggested")
	private boolean isPicklistSuggested;
	/**
 	* Indicates whether the field can be queried in the server. 
	**/
	@JsonProperty("isQueryable")
	private boolean isQueryable;
	/**
 	* The name of the field. 
	**/
	@JsonProperty("name")
	private String name;
	/**
 	* If this field is picklist, the identifier of the picklist associated, otherwise null 
	**/
	@JsonProperty("picklistId")
	private String picklistId;
	/**
 	* Indicates whether the field is [read only]. 
	**/
	@JsonProperty("readOnly")
	private boolean readOnly;
	/**
 	* The reference name of the field. 
	**/
	@JsonProperty("referenceName")
	private String referenceName;
	/**
 	* The supported operations on this field. 
	**/
	@JsonProperty("supportedOperations")
	private List<WorkItemFieldOperation> supportedOperations;
	/**
 	* The type of the field. 
	**/
	@JsonProperty("type")
	private FieldType type;

	@JsonProperty("url")
	private String url;
	/**
 	* The usage of the field. 
	**/
	@JsonProperty("usage")
	private FieldUsage usage;

	public Object get_links() { return _links; }

	public void set_links(Object _links) { this._links = _links; }

	public boolean getCanSortBy() { return canSortBy; }

	public void setCanSortBy(boolean canSortBy) { this.canSortBy = canSortBy; }

	public String getDescription() { return description; }

	public void setDescription(String description) { this.description = description; }

	public boolean getIsDeleted() { return isDeleted; }

	public void setIsDeleted(boolean isDeleted) { this.isDeleted = isDeleted; }

	public boolean getIsIdentity() { return isIdentity; }

	public void setIsIdentity(boolean isIdentity) { this.isIdentity = isIdentity; }

	public boolean getIsPicklist() { return isPicklist; }

	public void setIsPicklist(boolean isPicklist) { this.isPicklist = isPicklist; }

	public boolean getIsPicklistSuggested() { return isPicklistSuggested; }

	public void setIsPicklistSuggested(boolean isPicklistSuggested) { this.isPicklistSuggested = isPicklistSuggested; }

	public boolean getIsQueryable() { return isQueryable; }

	public void setIsQueryable(boolean isQueryable) { this.isQueryable = isQueryable; }

	public String getName() { return name; }

	public void setName(String name) { this.name = name; }

	public String getPicklistId() { return picklistId; }

	public void setPicklistId(String picklistId) { this.picklistId = picklistId; }

	public boolean getReadOnly() { return readOnly; }

	public void setReadOnly(boolean readOnly) { this.readOnly = readOnly; }

	public String getReferenceName() { return referenceName; }

	public void setReferenceName(String referenceName) { this.referenceName = referenceName; }

	public List<WorkItemFieldOperation> getSupportedOperations() { return supportedOperations; }

	public void setSupportedOperations(List<WorkItemFieldOperation> supportedOperations) { this.supportedOperations = supportedOperations; }

	public FieldType getType() { return type; }

	public void setType(FieldType type) { this.type = type; }

	public String getUrl() { return url; }

	public void setUrl(String url) { this.url = url; }

	public FieldUsage getUsage() { return usage; }

	public void setUsage(FieldUsage usage) { this.usage = usage; }

}
