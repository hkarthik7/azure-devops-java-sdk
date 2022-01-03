package org.azd.distributedtask.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.Author;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TaskAgentUpdate {
    @JsonProperty("currentState")
    private String currentState;
    @JsonProperty("reason")
    private TaskAgentUpdateReason reason;
    @JsonProperty("requestTime")
    private String requestTime;
    @JsonProperty("requestedBy")
    private Author requestedBy;
    @JsonProperty("sourceVersion")
    private int sourceVersion;
    @JsonProperty("targetVersion")
    private int targetVersion;

    public String getCurrentState() {
        return currentState;
    }

    public void setCurrentState(String currentState) {
        this.currentState = currentState;
    }

    public TaskAgentUpdateReason getReason() {
        return reason;
    }

    public void setReason(TaskAgentUpdateReason reason) {
        this.reason = reason;
    }

    public String getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(String requestTime) {
        this.requestTime = requestTime;
    }

    public Author getRequestedBy() {
        return requestedBy;
    }

    public void setRequestedBy(Author requestedBy) {
        this.requestedBy = requestedBy;
    }

    public int getSourceVersion() {
        return sourceVersion;
    }

    public void setSourceVersion(int sourceVersion) {
        this.sourceVersion = sourceVersion;
    }

    public int getTargetVersion() {
        return targetVersion;
    }

    public void setTargetVersion(int targetVersion) {
        this.targetVersion = targetVersion;
    }

    @Override
    public String toString() {
        return "TaskAgentUpdate{" +
                "currentState='" + currentState + '\'' +
                ", reason=" + reason +
                ", requestTime='" + requestTime + '\'' +
                ", requestedBy=" + requestedBy +
                ", sourceVersion=" + sourceVersion +
                ", targetVersion=" + targetVersion +
                '}';
    }
}
