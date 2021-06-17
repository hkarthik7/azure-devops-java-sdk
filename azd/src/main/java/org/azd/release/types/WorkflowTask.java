package org.azd.release.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WorkflowTask {
    @JsonProperty("alwaysRun")
    private boolean alwaysRun;
    @JsonProperty("condition")
    private String condition;
    @JsonProperty("continueOnError")
    private boolean continueOnError;
    @JsonProperty("definitionType")
    private String definitionType;
    @JsonProperty("enabled")
    private boolean enabled;
    @JsonProperty("environment")
    private Object environment;
    @JsonProperty("inputs")
    private Object inputs;
    @JsonProperty("name")
    private String name;
    @JsonProperty("overrideInputs")
    private Object overrideInputs;
    @JsonProperty("refName")
    private String refName;
    @JsonProperty("taskId")
    private String taskId;
    @JsonProperty("timeoutInMinutes")
    private int timeoutInMinutes;
    @JsonProperty("version")
    private String version;

    public boolean isAlwaysRun() {
        return alwaysRun;
    }

    public void setAlwaysRun(boolean alwaysRun) {
        this.alwaysRun = alwaysRun;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public boolean isContinueOnError() {
        return continueOnError;
    }

    public void setContinueOnError(boolean continueOnError) {
        this.continueOnError = continueOnError;
    }

    public String getDefinitionType() {
        return definitionType;
    }

    public void setDefinitionType(String definitionType) {
        this.definitionType = definitionType;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getOverrideInputs() {
        return overrideInputs;
    }

    public void setOverrideInputs(Object overrideInputs) {
        this.overrideInputs = overrideInputs;
    }

    public String getRefName() {
        return refName;
    }

    public void setRefName(String refName) {
        this.refName = refName;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public int getTimeoutInMinutes() {
        return timeoutInMinutes;
    }

    public void setTimeoutInMinutes(int timeoutInMinutes) {
        this.timeoutInMinutes = timeoutInMinutes;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "WorkflowTask{" +
                "alwaysRun=" + alwaysRun +
                ", condition='" + condition + '\'' +
                ", continueOnError=" + continueOnError +
                ", definitionType='" + definitionType + '\'' +
                ", enabled=" + enabled +
                ", environment=" + environment +
                ", inputs=" + inputs +
                ", name='" + name + '\'' +
                ", overrideInputs=" + overrideInputs +
                ", refName='" + refName + '\'' +
                ", taskId='" + taskId + '\'' +
                ", timeoutInMinutes=" + timeoutInMinutes +
                ", version='" + version + '\'' +
                '}';
    }
}
