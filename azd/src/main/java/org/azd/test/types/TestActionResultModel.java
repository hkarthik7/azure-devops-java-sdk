package org.azd.test.types;

/*
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
*/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;

/**
 * Represents a test step result.
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class TestActionResultModel extends SerializableEntity {

    /**
     * Path identifier for test step in test case workitem.
     * Represented in Hexadecimal format with 8 digits for a step.
     * - The step ID value for the first step starts with 2.
     * - For shared steps, it concatenates with the parent step of the test case.
     **/
    @JsonProperty("actionPath")
    private String actionPath;

    /**
     * Comment in the test result.
     **/
    @JsonProperty("comment")
    private String comment;

    /**
     * Time when execution was completed (UTC).
     **/
    @JsonProperty("completedDate")
    private String completedDate;

    /**
     * Duration of execution in milliseconds.
     **/
    @JsonProperty("durationInMs")
    private Long durationInMs;

    /**
     * Error message in the test result.
     **/
    @JsonProperty("errorMessage")
    private String errorMessage;

    /**
     * Iteration ID of the test action result.
     **/
    @JsonProperty("iterationId")
    private Integer iterationId;

    /**
     * Test outcome of the result.
     **/
    @JsonProperty("outcome")
    private String outcome;

    /**
     * Reference to the shared step workitem.
     **/
    @JsonProperty("sharedStepModel")
    private SharedStepModel sharedStepModel;

    /**
     * Time when execution started (UTC).
     **/
    @JsonProperty("startedDate")
    private String startedDate;

    /**
     * Step ID of the test case.
     * For shared steps, it represents the shared step ID in the test case workitem.
     **/
    @JsonProperty("stepIdentifier")
    private String stepIdentifier;

    /**
     * URL of the test action result.
     * Deprecated in hosted environment.
     **/
    @JsonProperty("url")
    private String url;

    public String getActionPath() {
        return actionPath;
    }

    public void setActionPath(String actionPath) {
        this.actionPath = actionPath;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCompletedDate() {
        return completedDate;
    }

    public void setCompletedDate(String completedDate) {
        this.completedDate = completedDate;
    }

    public Long getDurationInMs() {
        return durationInMs;
    }

    public void setDurationInMs(Long durationInMs) {
        this.durationInMs = durationInMs;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Integer getIterationId() {
        return iterationId;
    }

    public void setIterationId(Integer iterationId) {
        this.iterationId = iterationId;
    }

    public String getOutcome() {
        return outcome;
    }

    public void setOutcome(String outcome) {
        this.outcome = outcome;
    }

    public SharedStepModel getSharedStepModel() {
        return sharedStepModel;
    }

    public void setSharedStepModel(SharedStepModel sharedStepModel) {
        this.sharedStepModel = sharedStepModel;
    }

    public String getStartedDate() {
        return startedDate;
    }

    public void setStartedDate(String startedDate) {
        this.startedDate = startedDate;
    }

    public String getStepIdentifier() {
        return stepIdentifier;
    }

    public void setStepIdentifier(String stepIdentifier) {
        this.stepIdentifier = stepIdentifier;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
