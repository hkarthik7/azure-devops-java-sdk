package org.azd.core.types;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WorkitemFields {
    @JsonProperty("System.AreaPath")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    protected String areaPath;
    @JsonProperty("System.TeamProject")
    protected String teamProject;
    @JsonProperty("System.IterationPath")
    protected String iterationPath;
    @JsonProperty("System.WorkItemType")
    protected String workItemType;
    @JsonProperty("System.State")
    protected String state;
    @JsonProperty("System.Reason")
    protected String reason;
    @JsonProperty("System.CreatedDate")
    protected String createdDate;
    @JsonProperty("System.ChangedDate")
    protected String changedDate;
    @JsonProperty("System.CommentCount")
    protected Integer commentCount;
    @JsonProperty("System.Title")
    protected String title;
    @JsonProperty("System.BoardColumn")
    protected String boardColumn;
    @JsonProperty("System.BoardColumnDone")
    protected Boolean boardColumnDone;
    @JsonProperty("Microsoft.VSTS.Common.StateChangeDate")
    protected String stateChangedDate;
    @JsonProperty("Microsoft.VSTS.Common.Priority")
    protected Integer priority;
    @JsonProperty("WEF_0075D4D8CD7D4C84BFD2B461B5268892_Kanban.Column")
    protected String kanbanColumn;
    @JsonProperty("WEF_0075D4D8CD7D4C84BFD2B461B5268892_Kanban.Column.Done")
    protected Boolean kanbanDone;

    Map<String, Object> otherFields = new HashMap<>();

    // Capture all other fields that Jackson do not match other members
    @JsonAnyGetter
    public Map<String, Object> getOtherFields() {
        return otherFields;
    }

    public void setOtherFields(Map<String, Object> otherFieldsParam) {
        otherFields = otherFieldsParam;
    }

    @JsonAnySetter
    public void setOtherField(String name, Object value) {
        otherFields.put(name, value);
    }

    public String getAreaPath() {
        return areaPath;
    }

    public void setAreaPath(String areaPath) {
        this.areaPath = areaPath;
    }

    public String getTeamProject() {
        return teamProject;
    }

    public void setTeamProject(String teamProject) {
        this.teamProject = teamProject;
    }

    public String getIterationPath() {
        return iterationPath;
    }

    public void setIterationPath(String iterationPath) {
        this.iterationPath = iterationPath;
    }

    public String getWorkItemType() {
        return workItemType;
    }

    public void setWorkItemType(String workItemType) {
        this.workItemType = workItemType;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getChangedDate() {
        return changedDate;
    }

    public void setChangedDate(String changedDate) {
        this.changedDate = changedDate;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBoardColumn() {
        return boardColumn;
    }

    public void setBoardColumn(String boardColumn) {
        this.boardColumn = boardColumn;
    }

    public Boolean getBoardColumnDone() {
        return boardColumnDone;
    }

    public void setBoardColumnDone(Boolean boardColumnDone) {
        this.boardColumnDone = boardColumnDone;
    }

    public String getStateChangedDate() {
        return stateChangedDate;
    }

    public void setStateChangedDate(String stateChangedDate) {
        this.stateChangedDate = stateChangedDate;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getKanbanColumn() {
        return kanbanColumn;
    }

    public void setKanbanColumn(String kanbanColumn) {
        this.kanbanColumn = kanbanColumn;
    }

    public Boolean getKanbanDone() {
        return kanbanDone;
    }

    public void setKanbanDone(Boolean kanbanDone) {
        this.kanbanDone = kanbanDone;
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

