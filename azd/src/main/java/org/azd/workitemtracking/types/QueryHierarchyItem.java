package org.azd.workitemtracking.types;
/**
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
**/
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;
import org.azd.enums.LinkQueryMode;
import org.azd.enums.QueryRecursionOption;
import org.azd.enums.QueryType;

import java.util.List;

/**
 * Represents an item in the work item query hierarchy. This can be either a query or a folder. 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class QueryHierarchyItem extends BaseAbstractMethod {
	/**
 	* Link references to related REST resources. 
	**/
	@JsonProperty("_links")
	private Object _links;
	/**
 	* The child query items inside a query folder. 
	**/
	@JsonProperty("children")
	private List<QueryHierarchyItem> children;
	/**
 	* The clauses for a flat query. 
	**/
	@JsonProperty("clauses")
	private WorkItemQueryClause clauses;
	/**
 	* The columns of the query. 
	**/
	@JsonProperty("columns")
	private List<WorkItemFieldReference> columns;
	/**
 	* The identity who created the query item. 
	**/
	@JsonProperty("createdBy")
	private Object createdBy;
	/**
 	* When the query item was created. 
	**/
	@JsonProperty("createdDate")
	private String createdDate;
	/**
 	* The link query mode. 
	**/
	@JsonProperty("filterOptions")
	private LinkQueryMode filterOptions;
	/**
 	* If this is a query folder, indicates if it contains any children. 
	**/
	@JsonProperty("hasChildren")
	private boolean hasChildren;
	/**
 	* The id of the query item. 
	**/
	@JsonProperty("id")
	private String id;
	/**
 	* Indicates if this query item is deleted. Setting this to false on a deleted query item will undelete it. Undeleting a query or folder will not bring back the permission changes that were previously applied to it. 
	**/
	@JsonProperty("isDeleted")
	private boolean isDeleted;
	/**
 	* Indicates if this is a query folder or a query. 
	**/
	@JsonProperty("isFolder")
	private boolean isFolder;
	/**
 	* Indicates if the WIQL of this query is invalid. This could be due to invalid syntax or a no longer valid area/iteration path. 
	**/
	@JsonProperty("isInvalidSyntax")
	private boolean isInvalidSyntax;
	/**
 	* Indicates if this query item is public or private. 
	**/
	@JsonProperty("isPublic")
	private boolean isPublic;
	/**
 	* The identity who last ran the query. 
	**/
	@JsonProperty("lastExecutedBy")
	private Object lastExecutedBy;
	/**
 	* When the query was last run. 
	**/
	@JsonProperty("lastExecutedDate")
	private String lastExecutedDate;
	/**
 	* The identity who last modified the query item. 
	**/
	@JsonProperty("lastModifiedBy")
	private Object lastModifiedBy;
	/**
 	* When the query item was last modified. 
	**/
	@JsonProperty("lastModifiedDate")
	private String lastModifiedDate;
	/**
 	* The link query clause. 
	**/
	@JsonProperty("linkClauses")
	private WorkItemQueryClause linkClauses;
	/**
 	* The name of the query item. 
	**/
	@JsonProperty("name")
	private String name;
	/**
 	* The path of the query item. 
	**/
	@JsonProperty("path")
	private String path;
	/**
 	* The recursion option for use in a tree query. 
	**/
	@JsonProperty("queryRecursionOption")
	private QueryRecursionOption queryRecursionOption;
	/**
 	* The type of query. 
	**/
	@JsonProperty("queryType")
	private QueryType queryType;
	/**
 	* The sort columns of the query. 
	**/
	@JsonProperty("sortColumns")
	private List<WorkItemQuerySortColumn> sortColumns;
	/**
 	* The source clauses in a tree or one-hop link query. 
	**/
	@JsonProperty("sourceClauses")
	private WorkItemQueryClause sourceClauses;
	/**
 	* The target clauses in a tree or one-hop link query. 
	**/
	@JsonProperty("targetClauses")
	private WorkItemQueryClause targetClauses;

	@JsonProperty("url")
	private String url;
	/**
 	* The WIQL text of the query 
	**/
	@JsonProperty("wiql")
	private String wiql;

	public Object get_links() { return _links; }

	public void set_links(Object _links) { this._links = _links; }

	public List<QueryHierarchyItem> getChildren() { return children; }

	public void setChildren(List<QueryHierarchyItem> children) { this.children = children; }

	public WorkItemQueryClause getClauses() { return clauses; }

	public void setClauses(WorkItemQueryClause clauses) { this.clauses = clauses; }

	public List<WorkItemFieldReference> getColumns() { return columns; }

	public void setColumns(List<WorkItemFieldReference> columns) { this.columns = columns; }

	public Object getCreatedBy() { return createdBy; }

	public void setCreatedBy(Object createdBy) { this.createdBy = createdBy; }

	public String getCreatedDate() { return createdDate; }

	public void setCreatedDate(String createdDate) { this.createdDate = createdDate; }

	public LinkQueryMode getFilterOptions() { return filterOptions; }

	public void setFilterOptions(LinkQueryMode filterOptions) { this.filterOptions = filterOptions; }

	public boolean getHasChildren() { return hasChildren; }

	public void setHasChildren(boolean hasChildren) { this.hasChildren = hasChildren; }

	public String getId() { return id; }

	public void setId(String id) { this.id = id; }

	public boolean getIsDeleted() { return isDeleted; }

	public void setIsDeleted(boolean isDeleted) { this.isDeleted = isDeleted; }

	public boolean getIsFolder() { return isFolder; }

	public void setIsFolder(boolean isFolder) { this.isFolder = isFolder; }

	public boolean getIsInvalidSyntax() { return isInvalidSyntax; }

	public void setIsInvalidSyntax(boolean isInvalidSyntax) { this.isInvalidSyntax = isInvalidSyntax; }

	public boolean getIsPublic() { return isPublic; }

	public void setIsPublic(boolean isPublic) { this.isPublic = isPublic; }

	public Object getLastExecutedBy() { return lastExecutedBy; }

	public void setLastExecutedBy(Object lastExecutedBy) { this.lastExecutedBy = lastExecutedBy; }

	public String getLastExecutedDate() { return lastExecutedDate; }

	public void setLastExecutedDate(String lastExecutedDate) { this.lastExecutedDate = lastExecutedDate; }

	public Object getLastModifiedBy() { return lastModifiedBy; }

	public void setLastModifiedBy(Object lastModifiedBy) { this.lastModifiedBy = lastModifiedBy; }

	public String getLastModifiedDate() { return lastModifiedDate; }

	public void setLastModifiedDate(String lastModifiedDate) { this.lastModifiedDate = lastModifiedDate; }

	public WorkItemQueryClause getLinkClauses() { return linkClauses; }

	public void setLinkClauses(WorkItemQueryClause linkClauses) { this.linkClauses = linkClauses; }

	public String getName() { return name; }

	public void setName(String name) { this.name = name; }

	public String getPath() { return path; }

	public void setPath(String path) { this.path = path; }

	public QueryRecursionOption getQueryRecursionOption() { return queryRecursionOption; }

	public void setQueryRecursionOption(QueryRecursionOption queryRecursionOption) { this.queryRecursionOption = queryRecursionOption; }

	public QueryType getQueryType() { return queryType; }

	public void setQueryType(QueryType queryType) { this.queryType = queryType; }

	public List<WorkItemQuerySortColumn> getSortColumns() { return sortColumns; }

	public void setSortColumns(List<WorkItemQuerySortColumn> sortColumns) { this.sortColumns = sortColumns; }

	public WorkItemQueryClause getSourceClauses() { return sourceClauses; }

	public void setSourceClauses(WorkItemQueryClause sourceClauses) { this.sourceClauses = sourceClauses; }

	public WorkItemQueryClause getTargetClauses() { return targetClauses; }

	public void setTargetClauses(WorkItemQueryClause targetClauses) { this.targetClauses = targetClauses; }

	public String getUrl() { return url; }

	public void setUrl(String url) { this.url = url; }

	public String getWiql() { return wiql; }

	public void setWiql(String wiql) { this.wiql = wiql; }
}
