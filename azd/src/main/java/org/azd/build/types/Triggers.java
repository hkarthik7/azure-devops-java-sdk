package org.azd.build.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Triggers {
    @JsonProperty("branchFilters")
    private List<String> branchFilters;
    @JsonProperty("batchChanges")
    private boolean batchChanges;
    @JsonProperty("maxConcurrentBuildsPerBranch")
    private int maxConcurrentBuildsPerBranch;
    @JsonProperty("pollingInterval")
    private int pollingInterval;
    @JsonProperty("triggerType")
    private String triggerType;

    public List<String> getBranchFilters() {
        return branchFilters;
    }

    public void setBranchFilters(List<String> branchFilters) {
        this.branchFilters = branchFilters;
    }

    public boolean isBatchChanges() {
        return batchChanges;
    }

    public void setBatchChanges(boolean batchChanges) {
        this.batchChanges = batchChanges;
    }

    public int getMaxConcurrentBuildsPerBranch() {
        return maxConcurrentBuildsPerBranch;
    }

    public void setMaxConcurrentBuildsPerBranch(int maxConcurrentBuildsPerBranch) {
        this.maxConcurrentBuildsPerBranch = maxConcurrentBuildsPerBranch;
    }

    public int getPollingInterval() {
        return pollingInterval;
    }

    public void setPollingInterval(int pollingInterval) {
        this.pollingInterval = pollingInterval;
    }

    public String getTriggerType() {
        return triggerType;
    }

    public void setTriggerType(String triggerType) {
        this.triggerType = triggerType;
    }

    @Override
    public String toString() {
        return "Triggers{" +
                "branchFilters=" + branchFilters +
                ", batchChanges=" + batchChanges +
                ", maxConcurrentBuildsPerBranch=" + maxConcurrentBuildsPerBranch +
                ", pollingInterval=" + pollingInterval +
                ", triggerType='" + triggerType + '\'' +
                '}';
    }
}
