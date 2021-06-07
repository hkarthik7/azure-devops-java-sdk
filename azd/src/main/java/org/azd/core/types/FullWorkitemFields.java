package org.azd.core.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FullWorkitemFields extends WorkitemFields{
    @JsonProperty("System.CreatedBy")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private UserRef createdBy;
    @JsonProperty("System.ChangedBy")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private UserRef changedBy;

    public UserRef getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(UserRef createdBy) {
        this.createdBy = createdBy;
    }

    public UserRef getChangedBy() {
        return changedBy;
    }

    public void setChangedBy(UserRef changedBy) {
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

