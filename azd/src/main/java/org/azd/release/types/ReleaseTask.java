package org.azd.release.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/***
 * Parent task of all executed tasks.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReleaseTask {
    /***
     * Agent name on which task executed.
     */
    @JsonProperty("agentName")
    private String agentName;
    /***
     * Finish time of the release task.
     */
    @JsonProperty("finishTime")
    private String finishTime;
    /***
     * ID of the release task.
     */
    @JsonProperty("id")
    private int id;
    /***
     * List of issues occurred while execution of task.
     */
    @JsonProperty("issues")
    private List<Issues> issues;
    /***
     * Number of lines log release task has.
     */
    @JsonProperty("lineCount")
    private int lineCount;
    /***
     * Log URL of the task.
     */
    @JsonProperty("logUrl")
    private String logUrl;
    /***
     * Name of the task.
     */
    @JsonProperty("name")
    private String name;
    /***
     * Task execution complete percent.
     */
    @JsonProperty("percentComplete")
    private String percentComplete;
    /***
     * Rank of the release task.
     */
    @JsonProperty("rank")
    private String rank;
    /***
     * Result code of the task.
     */
    @JsonProperty("resultCode")
    private String resultCode;
    /***
     * ID of the release task.
     */
    @JsonProperty("startTime")
    private String startTime;
    /***
     * Status of release task.
     */
    @JsonProperty("status")
    private String status;
    /***
     * Workflow task reference.
     */
    @JsonProperty("task")
    private WorkflowTaskReference task;
    /***
     * Timeline record ID of the release task.
     */
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
