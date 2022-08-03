package org.azd.build.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

/***
 * Represents a definition steps
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Steps extends BaseAbstractMethod {
    /**
     * Represents an environment
     */
    @JsonProperty("environment")
    private Object environment;
    /**
     * Represents the inputs in task(s)
     */
    @JsonProperty("inputs")
    private Object inputs;
    /***
     * If enabled or not
     */
    @JsonProperty("enabled")
    private boolean enabled;
    /***
     * Continue on error or not
     */
    @JsonProperty("continueOnError")
    private boolean continueOnError;
    /***
     * Always run
     */
    @JsonProperty("alwaysRun")
    private boolean alwaysRun;
    /***
     * Step display name
     */
    @JsonProperty("displayName")
    private String displayName;
    /***
     * Timeout in minutes
     */
    @JsonProperty("timeoutInMinutes")
    private int timeoutInMinutes;
    /**
     * Retry count
     */
    @JsonProperty("retryCountOnTaskFailure")
    private int retryCountOnTaskFailure;
    /***
     * Steps condition
     */
    @JsonProperty("condition")
    private String condition;
    /***
     * task in a step
     */
    @JsonProperty("task")
    private Task task;


    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isContinueOnError() {
        return continueOnError;
    }

    public void setContinueOnError(boolean continueOnError) {
        this.continueOnError = continueOnError;
    }

    public boolean isAlwaysRun() {
        return alwaysRun;
    }

    public void setAlwaysRun(boolean alwaysRun) {
        this.alwaysRun = alwaysRun;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public int getTimeoutInMinutes() {
        return timeoutInMinutes;
    }

    public void setTimeoutInMinutes(int timeoutInMinutes) {
        this.timeoutInMinutes = timeoutInMinutes;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public Object getEnvironment() {
        return environment;
    }

    public void setEnvironment(Object environment) {
        this.environment = environment;
    }

    public Object getInputs() {
        return inputs;
    }

    public void setInputs(Object inputs) {
        this.inputs = inputs;
    }

}
