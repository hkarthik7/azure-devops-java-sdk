package org.azd.build.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import org.azd.common.types.BaseAbstractMethod;

import java.util.List;

/**
 * Represents an entry in a build's timeline.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TimelineRecord extends BaseAbstractMethod {
    /**
     * The class to represent a collection of REST reference links.
     */
    @JsonProperty("_links")
    private JsonNode _links;
    /**
     * Attempt number of record.
     */
    @JsonProperty("attempt")
    private int attempt;
    /**
     * The change ID.
     */
    @JsonProperty("changeId")
    private int changeId;
    /**
     * A string that indicates the current operation.
     */
    @JsonProperty("currentOperation")
    private String currentOperation;
    /**
     * A reference to a sub-timeline.
     */
    @JsonProperty("details")
    private TimelineReference details;
    /**
     * The number of errors produced by this operation.
     */
    @JsonProperty("errorCount")
    private int errorCount;
    /**
     * The finish time.
     */
    @JsonProperty("finishTime")
    private String finishTime;
    /**
     * The ID of the record.
     */
    @JsonProperty("id")
    private String id;
    /**
     * String identifier that is consistent across attempts.
     */
    @JsonProperty("identifier")
    private String identifier;
    /**
     * Represents an issue (error, warning) associated with a build.
     */
    @JsonProperty("issues")
    private List<Issue> issues;
    /**
     * The time the record was last modified.
     */
    @JsonProperty("lastModified")
    private String lastModified;
    /**
     * A reference to the log produced by this operation.
     */
    @JsonProperty("log")
    private BuildLogReference log;
    /**
     * The name
     */
    @JsonProperty("name")
    private String name;
    /**
     * An ordinal value relative to other records.
     */
    @JsonProperty("order")
    private int order;
    /**
     * The ID of the record's parent.
     */
    @JsonProperty("parentId")
    private String parentId;
    /**
     * The current completion percentage.
     */
    @JsonProperty("percentComplete")
    private int percentComplete;
    /**
     * Collection of attempt tried
     */
    @JsonProperty("previousAttempts")
    private List<TimelineAttempt> previousAttempts;
    /**
     * The queue ID of the queue that the operation ran on.
     */
    @JsonProperty("queueId")
    private int queueId;
    /**
     * Result
     */
    @JsonProperty("result")
    private String result;
    /**
     * The result code.
     */
    @JsonProperty("resultCode")
    private String resultCode;
    /**
     * The start time.
     */
    @JsonProperty("startTime")
    private String startTime;
    /**
     * state of the record
     */
    @JsonProperty("state")
    private String state;
    /**
     * A reference to the task represented by this timeline record.
     */
    @JsonProperty("task")
    private TaskReference task;
    /**
     * The type of the record.
     */
    @JsonProperty("type")
    private String type;
    /**
     * The REST URL of the timeline record.
     */
    @JsonProperty("url")
    private String url;
    /**
     * The number of warnings produced by this operation.
     */
    @JsonProperty("warningCount")
    private int warningCount;
    /**
     * The name of the agent running the operation.
     */
    @JsonProperty("workerName")
    private String workerName;

    public JsonNode get_links() {
        return _links;
    }

    public void set_links(JsonNode _links) {
        this._links = _links;
    }

    public int getAttempt() {
        return attempt;
    }

    public void setAttempt(int attempt) {
        this.attempt = attempt;
    }

    public int getChangeId() {
        return changeId;
    }

    public void setChangeId(int changeId) {
        this.changeId = changeId;
    }

    public String getCurrentOperation() {
        return currentOperation;
    }

    public void setCurrentOperation(String currentOperation) {
        this.currentOperation = currentOperation;
    }

    public TimelineReference getDetails() {
        return details;
    }

    public void setDetails(TimelineReference details) {
        this.details = details;
    }

    public int getErrorCount() {
        return errorCount;
    }

    public void setErrorCount(int errorCount) {
        this.errorCount = errorCount;
    }

    public String getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(String finishTime) {
        this.finishTime = finishTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public List<Issue> getIssues() {
        return issues;
    }

    public void setIssues(List<Issue> issues) {
        this.issues = issues;
    }

    public String getLastModified() {
        return lastModified;
    }

    public void setLastModified(String lastModified) {
        this.lastModified = lastModified;
    }

    public BuildLogReference getLog() {
        return log;
    }

    public void setLog(BuildLogReference log) {
        this.log = log;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public int getPercentComplete() {
        return percentComplete;
    }

    public void setPercentComplete(int percentComplete) {
        this.percentComplete = percentComplete;
    }

    public List<TimelineAttempt> getPreviousAttempts() {
        return previousAttempts;
    }

    public void setPreviousAttempts(List<TimelineAttempt> previousAttempts) {
        this.previousAttempts = previousAttempts;
    }

    public int getQueueId() {
        return queueId;
    }

    public void setQueueId(int queueId) {
        this.queueId = queueId;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public TaskReference getTask() {
        return task;
    }

    public void setTask(TaskReference task) {
        this.task = task;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getWarningCount() {
        return warningCount;
    }

    public void setWarningCount(int warningCount) {
        this.warningCount = warningCount;
    }

    public String getWorkerName() {
        return workerName;
    }

    public void setWorkerName(String workerName) {
        this.workerName = workerName;
    }

}
