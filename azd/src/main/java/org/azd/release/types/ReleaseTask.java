package org.azd.release.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ReleaseTask {
    @JsonProperty("agentName")
    private String agentName;
    @JsonProperty("finishTime")
    private String finishTime;
    @JsonProperty("id")
    private int id;
    @JsonProperty("issues")
    private List<Issues> issues;
    @JsonProperty("lineCount")
    private int lineCount;
    @JsonProperty("logUrl")
    private String logUrl;
    @JsonProperty("name")
    private String name;
    @JsonProperty("percentComplete")
    private String percentComplete;
    @JsonProperty("rank")
    private String rank;
    @JsonProperty("resultCode")
    private String resultCode;
    @JsonProperty("startTime")
    private String startTime;
    @JsonProperty("status")
    private String status;
    @JsonProperty("task")
    private WorkflowTaskReference task;
    @JsonProperty("timelineRecordId")
    private String timelineRecordId;

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public String getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(String finishTime) {
        this.finishTime = finishTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Issues> getIssues() {
        return issues;
    }

    public void setIssues(List<Issues> issues) {
        this.issues = issues;
    }

    public int getLineCount() {
        return lineCount;
    }

    public void setLineCount(int lineCount) {
        this.lineCount = lineCount;
    }

    public String getLogUrl() {
        return logUrl;
    }

    public void setLogUrl(String logUrl) {
        this.logUrl = logUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPercentComplete() {
        return percentComplete;
    }

    public void setPercentComplete(String percentComplete) {
        this.percentComplete = percentComplete;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public WorkflowTaskReference getTask() {
        return task;
    }

    public void setTask(WorkflowTaskReference task) {
        this.task = task;
    }

    public String getTimelineRecordId() {
        return timelineRecordId;
    }

    public void setTimelineRecordId(String timelineRecordId) {
        this.timelineRecordId = timelineRecordId;
    }

    @Override
    public String toString() {
        return "ReleaseTask{" +
                "agentName='" + agentName + '\'' +
                ", finishTime='" + finishTime + '\'' +
                ", id=" + id +
                ", issues=" + issues +
                ", lineCount=" + lineCount +
                ", logUrl='" + logUrl + '\'' +
                ", name='" + name + '\'' +
                ", percentComplete='" + percentComplete + '\'' +
                ", rank='" + rank + '\'' +
                ", resultCode='" + resultCode + '\'' +
                ", startTime='" + startTime + '\'' +
                ", status='" + status + '\'' +
                ", task=" + task +
                ", timelineRecordId='" + timelineRecordId + '\'' +
                '}';
    }
}
