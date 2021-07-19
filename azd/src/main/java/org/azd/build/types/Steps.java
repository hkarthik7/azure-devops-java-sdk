package org.azd.build.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/***
 * Represents a definition steps
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Steps {
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
    /***
     * Name of the task
     */
    @JsonProperty("name")
    private String name;
    /***
     * Task reference name
     */
    @JsonProperty("refName")
    private String refName;
    /***
     * Job authorization scope
     */
    @JsonProperty("jobAuthorizationScope")
    private String jobAuthorizationScope;


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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRefName() {
        return refName;
    }

    public void setRefName(String refName) {
        this.refName = refName;
    }

    public String getJobAuthorizationScope() {
        return jobAuthorizationScope;
    }

    public void setJobAuthorizationScope(String jobAuthorizationScope) {
        this.jobAuthorizationScope = jobAuthorizationScope;
    }

    @Override
    public String toString() {
        return "Steps{" +
                ", enabled=" + enabled +
                ", continueOnError=" + continueOnError +
                ", alwaysRun=" + alwaysRun +
                ", displayName='" + displayName + '\'' +
                ", timeoutInMinutes=" + timeoutInMinutes +
                ", condition='" + condition + '\'' +
                ", task=" + task +
                ", name='" + name + '\'' +
                ", refName='" + refName + '\'' +
                ", jobAuthorizationScope='" + jobAuthorizationScope + '\'' +
                '}';
    }
}
