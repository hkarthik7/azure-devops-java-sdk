package org.azd.workitemtracking.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

import java.util.List;

/***
 * The result of a work item query.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WorkItemQueryResult extends BaseAbstractMethod {
    /***
     * The date the query was run in the context of.
     */
    @JsonProperty("asOf")
    private String asOf;
    /***
     * The columns of the query.
     */
    @JsonProperty("columns")
    private List<WorkItemFieldReference> columns;
    /***
     * The result type
     */
    @JsonProperty("queryResultType")
    private String queryResultType;
    /***
     * The type of the query
     */
    @JsonProperty("queryType")
    private String queryType;
    /***
     * The sort columns of the query.
     */
    @JsonProperty("sortColumns")
    private List<WorkItemQuerySortColumn> sortColumns;
    /***
     * The work item links returned by the query.
     */
    @JsonProperty("workItemRelations")
    private List<WorkItemLink> workItemRelations;
    /***
     * The work items returned by the query.
     */
    @JsonProperty("workItems")
    private List<WorkItemReference> workItems;

    public String getAsOf() {
        return asOf;
    }

    public void setAsOf(String asOf) {
        this.asOf = asOf;
    }

    public List<WorkItemFieldReference> getColumns() {
        return columns;
    }

    public void setColumns(List<WorkItemFieldReference> columns) {
        this.columns = columns;
    }

    public String getQueryResultType() {
        return queryResultType;
    }

    public void setQueryResultType(String queryResultType) {
        this.queryResultType = queryResultType;
    }

    public String getQueryType() {
        return queryType;
    }

    public void setQueryType(String queryType) {
        this.queryType = queryType;
    }

    public List<WorkItemQuerySortColumn> getSortColumns() {
        return sortColumns;
    }

    public void setSortColumns(List<WorkItemQuerySortColumn> sortColumns) {
        this.sortColumns = sortColumns;
    }

    public List<WorkItemLink> getWorkItemRelations() {
        return workItemRelations;
    }

    public void setWorkItemRelations(List<WorkItemLink> workItemRelations) {
        this.workItemRelations = workItemRelations;
    }

    public List<WorkItemReference> getWorkItems() {
        return workItems;
    }

    public void setWorkItems(List<WorkItemReference> workItems) {
        this.workItems = workItems;
    }

}
