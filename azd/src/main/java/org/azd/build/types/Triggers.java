package org.azd.build.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

import java.util.List;

/***
 * Represents a trigger for a build definition.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Triggers extends BaseAbstractMethod {
    /***
     * Branch filters
     */
    @JsonProperty("branchFilters")
    private List<String> branchFilters;
    /***
     * Batch changes
     */
    @JsonProperty("batchChanges")
    private boolean batchChanges;
    /***
     * Maximum concurrent builds per branch
     */
    @JsonProperty("maxConcurrentBuildsPerBranch")
    private int maxConcurrentBuildsPerBranch;
    /***
     * Polling interval
     */
    @JsonProperty("pollingInterval")
    private int pollingInterval;
    /***
     * The type of the trigger.
     */
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

}
