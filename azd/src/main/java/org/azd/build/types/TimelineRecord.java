package org.azd.build.types;
/*
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
*/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import org.azd.abstractions.serializer.SerializableEntity;
import org.azd.enums.TaskResult;
import org.azd.enums.TimelineRecordState;

import java.util.List;

/**
 * The state of the record.
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class TimelineRecord extends SerializableEntity {
    /**
     * The class to represent a collection of REST reference links.
     **/
    @JsonProperty("_links")
    private JsonNode _links;
    /**
     * Attempt number of record.
     **/
    @JsonProperty("attempt")
    private Integer attempt;
    /**
     * The change ID.
     **/
    @JsonProperty("changeId")
    private Integer changeId;
    /**
     * A string that indicates the current operation.
     **/
    @JsonProperty("currentOperation")
    private String currentOperation;
    /**
     * A reference to a sub-timeline.
     **/
    @JsonProperty("details")
    private TimelineReference details;
    /**
     * The number of errors produced by this operation.
     **/
    @JsonProperty("errorCount")
    private Integer errorCount;
    /**
     * The finish time.
     **/
    @JsonProperty("finishTime")
    private String finishTime;
    /**
     * The ID of the record.
     **/
    @JsonProperty("id")
    private String id;
    /**
     * String identifier that is consistent across attempts.
     **/
    @JsonProperty("identifier")
    private String identifier;
    /**
     * Represents an issue (error, warning) associated with a build.
     **/
    @JsonProperty("issues")
    private List<Issue> issues;
    /**
     * The time the record was last modified.
     **/
    @JsonProperty("lastModified")
    private String lastModified;
    /**
     * A reference to the log produced by this operation.
     **/
    @JsonProperty("log")
    private BuildLogReference log;
    /**
     * The name.
     **/
    @JsonProperty("name")
    private String name;
    /**
     * An ordinal value relative to other records.
     **/
    @JsonProperty("order")
    private Integer order;
    /**
     * The ID of the record's parent.
     **/
    @JsonProperty("parentId")
    private String parentId;
    /**
     * The current completion percentage.
     **/
    @JsonProperty("percentComplete")
    private Integer percentComplete;

    @JsonProperty("previousAttempts")
    private List<TimelineAttempt> previousAttempts;
    /**
     * The queue ID of the queue that the operation ran on.
     **/
    @JsonProperty("queueId")
    private Integer queueId;
    /**
     * The result.
     **/
    @JsonProperty("result")
    private TaskResult result;
    /**
     * The result code.
     **/
    @JsonProperty("resultCode")
    private String resultCode;
    /**
     * The start time.
     **/
    @JsonProperty("startTime")
    private String startTime;
    /**
     * The state of the record.
     **/
    @JsonProperty("state")
    private TimelineRecordState state;
    /**
     * A reference to the task represented by this timeline record.
     **/
    @JsonProperty("task")
    private TaskReference task;
    /**
     * The type of the record.
     **/
    @JsonProperty("type")
    private String type;
    /**
     * The REST URL of the timeline record.
     **/
    @JsonProperty("url")
    private String url;
    /**
     * The number of warnings produced by this operation.
     **/
    @JsonProperty("warningCount")
    private Integer warningCount;
    /**
     * The name of the agent running the operation.
     **/
    @JsonProperty("workerName")
    private String workerName;

    public JsonNode get_links() {
        return _links;
    }

    public void set_links(JsonNode _links) {
        this._links = _links;
    }

    public Integer getAttempt() {
        return attempt;
    }

    public void setAttempt(Integer attempt) {
        this.attempt = attempt;
    }

    public Integer getChangeId() {
        return changeId;
    }

    public void setChangeId(Integer changeId) {
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

    public Integer getErrorCount() {
        return errorCount;
    }

    public void setErrorCount(Integer errorCount) {
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

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public Integer getPercentComplete() {
        return percentComplete;
    }

    public void setPercentComplete(Integer percentComplete) {
        this.percentComplete = percentComplete;
    }

    public List<TimelineAttempt> getPreviousAttempts() {
        return previousAttempts;
    }

    public void setPreviousAttempts(List<TimelineAttempt> previousAttempts) {
        this.previousAttempts = previousAttempts;
    }

    public Integer getQueueId() {
        return queueId;
    }

    public void setQueueId(Integer queueId) {
        this.queueId = queueId;
    }

    public TaskResult getResult() {
        return result;
    }

    public void setResult(TaskResult result) {
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

    public TimelineRecordState getState() {
        return state;
    }

    public void setState(TimelineRecordState state) {
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

    public Integer getWarningCount() {
        return warningCount;
    }

    public void setWarningCount(Integer warningCount) {
        this.warningCount = warningCount;
    }

    public String getWorkerName() {
        return workerName;
    }

    public void setWorkerName(String workerName) {
        this.workerName = workerName;
    }

}