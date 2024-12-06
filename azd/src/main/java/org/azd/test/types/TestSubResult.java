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
 * Represents a sub result of a test result.
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class TestSubResult extends SerializableEntity {

    /**
     * Comment in sub result.
     **/
    @JsonProperty("comment")
    private String comment;

    /**
     * Time when test execution completed (UTC).
     **/
    @JsonProperty("completedDate")
    private String completedDate;

    /**
     * Machine where the test was executed.
     **/
    @JsonProperty("computerName")
    private String computerName;

    /**
     * Reference to the test configuration.
     **/
    @JsonProperty("configuration")
    private ShallowReference configuration;

    /**
     * Additional properties of the sub result.
     **/
    @JsonProperty("customFields")
    private List<CustomTestField> customFields;

    /**
     * Name of the sub result.
     **/
    @JsonProperty("displayName")
    private String displayName;

    /**
     * Duration of the test execution in milliseconds.
     **/
    @JsonProperty("durationInMs")
    private Integer durationInMs;

    /**
     * Error message in the sub result.
     **/
    @JsonProperty("errorMessage")
    private String errorMessage;

    /**
     * ID of the sub result.
     **/
    @JsonProperty("id")
    private Integer id;

    /**
     * Time when the result was last updated (UTC).
     **/
    @JsonProperty("lastUpdatedDate")
    private String lastUpdatedDate;

    /**
     * Outcome of the sub result.
     **/
    @JsonProperty("outcome")
    private String outcome;

    /**
     * Immediate parent ID of the sub result.
     **/
    @JsonProperty("parentId")
    private Integer parentId;

    /**
     * Hierarchy type of the result; default value of None means it is a leaf node.
     **/
    @JsonProperty("resultGroupType")
    private String resultGroupType;

    /**
     * Index number of the sub result.
     **/
    @JsonProperty("sequenceId")
    private Integer sequenceId;

    /**
     * Stack trace of the sub result.
     **/
    @JsonProperty("stackTrace")
    private String stackTrace;

    /**
     * Time when test execution started (UTC).
     **/
    @JsonProperty("startedDate")
    private String startedDate;

    /**
     * List of sub results inside this sub result; if ResultGroupType is not None, it holds corresponding type sub results.
     **/
    @JsonProperty("subResults")
    private List<TestSubResult> subResults;

    /**
     * Reference to the associated test result.
     **/
    @JsonProperty("testResult")
    private TestCaseResultIdentifier testResult;

    /**
     * URL of the sub result.
     **/
    @JsonProperty("url")
    private String url;

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

    public String getComputerName() {
        return computerName;
    }

    public void setComputerName(String computerName) {
        this.computerName = computerName;
    }

    public ShallowReference getConfiguration() {
        return configuration;
    }

    public void setConfiguration(ShallowReference configuration) {
        this.configuration = configuration;
    }

    public List<CustomTestField> getCustomFields() {
        return customFields;
    }

    public void setCustomFields(List<CustomTestField> customFields) {
        this.customFields = customFields;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public Integer getDurationInMs() {
        return durationInMs;
    }

    public void setDurationInMs(Integer durationInMs) {
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

    public String getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(String lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public String getOutcome() {
        return outcome;
    }

    public void setOutcome(String outcome) {
        this.outcome = outcome;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getResultGroupType() {
        return resultGroupType;
    }

    public void setResultGroupType(String resultGroupType) {
        this.resultGroupType = resultGroupType;
    }

    public Integer getSequenceId() {
        return sequenceId;
    }

    public void setSequenceId(Integer sequenceId) {
        this.sequenceId = sequenceId;
    }

    public String getStackTrace() {
        return stackTrace;
    }

    public void setStackTrace(String stackTrace) {
        this.stackTrace = stackTrace;
    }

    public String getStartedDate() {
        return startedDate;
    }

    public void setStartedDate(String startedDate) {
        this.startedDate = startedDate;
    }

    public List<TestSubResult> getSubResults() {
        return subResults;
    }

    public void setSubResults(List<TestSubResult> subResults) {
        this.subResults = subResults;
    }

    public TestCaseResultIdentifier getTestResult() {
        return testResult;
    }

    public void setTestResult(TestCaseResultIdentifier testResult) {
        this.testResult = testResult;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
