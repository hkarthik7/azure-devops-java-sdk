package org.azd.core.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WorkitemFieldsSummary extends WorkitemFields{
    @JsonProperty("System.CreatedBy")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String createdBy;
    @JsonProperty("System.ChangedBy")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String changedBy;

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getChangedBy() {
        return changedBy;
    }

    public void setChangedBy(String changedBy) {
        this.changedBy = changedBy;
    }

    @Override
    public String toString() {
        return "WorkitemFields{" +
                "areaPath='" + areaPath + '\'' +
                ", teamProject='" + teamProject + '\'' +
                ", iterationPath='" + iterationPath + '\'' +
                ", workItemType='" + workItemType + '\'' +
                ", state='" + state + '\'' +
                ", reason='" + reason + '\'' +
                ", createdDate='" + createdDate + '\'' +
                ", changedDate='" + changedDate + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", changedBy='" + changedBy + '\'' +
                ", commentCount='" + commentCount + '\'' +
                ", title='" + title + '\'' +
                ", boardColumn='" + boardColumn + '\'' +
                ", stateChangedDate='" + stateChangedDate + '\'' +
                ", priority='" + priority + '\'' +
                ", kanbanColumn='" + kanbanColumn + '\'' +
                ", kanbanDone='" + kanbanDone + '\'' +
                '}';
    }
}

