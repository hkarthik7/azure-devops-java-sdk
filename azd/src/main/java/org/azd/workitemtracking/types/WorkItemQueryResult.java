package org.azd.workitemtracking.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WorkItemQueryResult {
    @JsonProperty("asOf")
    private String asOf;
    @JsonProperty("columns")
    private List<WorkItemFieldReference> columns;
    @JsonProperty("queryResultType")
    private String queryResultType;
    @JsonProperty("queryType")
    private String queryType;
    @JsonProperty("sortColumns")
    private List<WorkItemQuerySortColumn> sortColumns;
    @JsonProperty("workItemRelations")
    private List<WorkItemLink> workItemRelations;
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

    @Override
    public String toString() {
        return "WorkItemQueryResult{" +
                "asOf='" + asOf + '\'' +
                ", columns=" + columns +
                ", queryResultType='" + queryResultType + '\'' +
                ", queryType='" + queryType + '\'' +
                ", sortColumns=" + sortColumns +
                ", workItemRelations=" + workItemRelations +
                ", workItems=" + workItems +
                '}';
    }
}
