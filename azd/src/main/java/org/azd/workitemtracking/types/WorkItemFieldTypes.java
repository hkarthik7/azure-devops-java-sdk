package org.azd.workitemtracking.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WorkItemFieldTypes extends BaseAbstractMethod {
    @JsonProperty("value")
    private List<WorkItemField> workItemFields;

    public List<WorkItemField> getWorkItemFields() {
        return workItemFields;
    }

    public void setWorkItemFields(List<WorkItemField> workItemFields) {
        this.workItemFields = workItemFields;
    }

}
