package org.azd.core.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WorkitemFields {
    @JsonProperty("System.AreaPath")
    private String areaPath;
    @JsonProperty("System.TeamProject")
    private String teamProject;
    @JsonProperty("System.IterationPath")
    private String iterationPath;
    @JsonProperty("System.WorkItemType")
    private String workItemType;
    @JsonProperty("System.State")
    private String state;
    @JsonProperty("System.Reason")
    private String reason;
    @JsonProperty("System.CreatedDate")
    private String createdDate;
    @JsonProperty("System.ChangedDate")
    private String changedDate;
    @JsonProperty("System.CreatedBy")
    private UserRef createdBy;
    @JsonProperty("System.ChangedBy")
    private UserRef changedBy;
    @JsonProperty("System.CommentCount")
    private Integer commentCount;
    @JsonProperty("System.Title")
    private String title;
    @JsonProperty("System.BoardColumn")
    private String boardColumn;
    @JsonProperty("System.BoardColumnDone")
    private Boolean boardColumnDone;
    @JsonProperty("Microsoft.VSTS.Common.StateChangeDate")
    private String stateChangedDate;
    @JsonProperty("Microsoft.VSTS.Common.Priority")
    private Integer priority;
    @JsonProperty("WEF_0075D4D8CD7D4C84BFD2B461B5268892_Kanban.Column")
    private String kanbanColumn;
    @JsonProperty("WEF_0075D4D8CD7D4C84BFD2B461B5268892_Kanban.Column.Done")
    private Boolean kanbanDone;

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

