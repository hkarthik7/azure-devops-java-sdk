package org.azd.test.types;

/*
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
*/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;

import java.util.List;

/**
 * Represents a test iteration result.
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class TestIterationDetailsModel extends SerializableEntity {

    /**
     * Test step results in an iteration.
     **/
    @JsonProperty("actionResults")
    private List<TestActionResultModel> actionResults;

    /**
     * Reference to attachments in the test iteration result.
     **/
    @JsonProperty("attachments")
    private List<TestCaseResultAttachmentModel> attachments;

    /**
     * Comment in the test iteration result.
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
     * Error message in the test iteration result execution.
     **/
    @JsonProperty("errorMessage")
    private String errorMessage;

    /**
     * ID of the test iteration result.
     **/
    @JsonProperty("id")
    private Integer id;

    /**
     * Test outcome of the test iteration result.
     **/
    @JsonProperty("outcome")
    private String outcome;

    /**
     * Test parameters in an iteration.
     **/
    @JsonProperty("parameters")
    private List<TestResultParameterModel> parameters;

    /**
     * Time when execution started (UTC).
     **/
    @JsonProperty("startedDate")
    private String startedDate;

    /**
     * URL to the test iteration result.
     **/
    @JsonProperty("url")
    private String url;

    public List<TestActionResultModel> getActionResults() {
        return actionResults;
    }

    public void setActionResults(List<TestActionResultModel> actionResults) {
        this.actionResults = actionResults;
    }

    public List<TestCaseResultAttachmentModel> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<TestCaseResultAttachmentModel> attachments) {
        this.attachments = attachments;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOutcome() {
        return outcome;
    }

    public void setOutcome(String outcome) {
        this.outcome = outcome;
    }

    public List<TestResultParameterModel> getParameters() {
        return parameters;
    }

    public void setParameters(List<TestResultParameterModel> parameters) {
        this.parameters = parameters;
    }

    public String getStartedDate() {
        return startedDate;
    }

    public void setStartedDate(String startedDate) {
        this.startedDate = startedDate;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
