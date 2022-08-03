package org.azd.workitemtracking.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

/***
 * The sort columns of the query.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WorkItemQuerySortColumn extends BaseAbstractMethod {
    /***
     * The direction to sort by.
     */
    @JsonProperty("descending")
    private boolean descending;
    /***
     * A work item field.
     */
    @JsonProperty("field")
    private WorkItemFieldReference field;

    public boolean isDescending() {
        return descending;
    }

    public void setDescending(boolean descending) {
        this.descending = descending;
    }

    public WorkItemFieldReference getField() {
        return field;
    }

    public void setField(WorkItemFieldReference field) {
        this.field = field;
    }

}
