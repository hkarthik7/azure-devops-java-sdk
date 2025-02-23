package org.azd.test.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;

/**
 * Test points
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TestPoint extends SerializableEntity {
    /**
     * AssignedTo. Type IdentityRef.
     */
    @JsonProperty("assignedTo")
    private IdentityRef assignedTo;
    /**
     * Automated.
     */
    @JsonProperty("automated")
    private boolean automated;
    /**
     * Comment associated with test point.
     */
    @JsonProperty("comment")
    private String comment;
    /**
     * Configuration. Type ShallowReference.
     */
    @JsonProperty("configuration")
    private ShallowReference configuration;
    /**
     * Failure type of test point.
     */
    @JsonProperty("failureType")
    private String failureType;
    /**
     * ID of the test point.
     */
    @JsonProperty("id")
    private Integer id;
    /**
     * Last date when test point was reset to Active.
     */
    @JsonProperty("lastResetToActive")
    private String lastResetToActive;
    /**
     * Last resolution state id of test point.
     */
    @JsonProperty("lastResolutionStateId")
    private Integer lastResolutionStateId;
    /**
     * Last result of test point. Type ShallowReference.
     */
    @JsonProperty("lastResult")
    private ShallowReference lastResult;
    /**
     * Last result details of test point. Type LastResultDetails.
     */
    @JsonProperty("lastResultDetails")
    private LastResultDetails lastResultDetails;
    /**
     * Last result state of test point.
     */
    @JsonProperty("lastResultState")
    private String lastResultState;
    /**
     * LastRun build Integer of test point.
     */
    @JsonProperty("lastRunBuildInteger")
    private String lastRunBuildInteger;
    /**
     * Last testRun of test point. Type ShallowReference.
     */
    @JsonProperty("lastTestRun")
    private ShallowReference lastTestRun;
    /**
     * Test point last updated by. Type IdentityRef.
     */
    @JsonProperty("lastUpdatedBy")
    private IdentityRef lastUpdatedBy;
    /**
     * Last updated date of test point.
     */
    @JsonProperty("lastUpdatedDate")
    private String lastUpdatedDate;
    /**
     * Outcome of test point.
     */
    @JsonProperty("outcome")
    private String outcome;
    /**
     * Revision Integer.
     */
    @JsonProperty("revision")
    private Integer revision;
    /**
     * State of test point.
     */
    @JsonProperty("state")
    private String state;
    /**
     * Suite of test point. Type ShallowReference.
     */
    @JsonProperty("suite")
    private ShallowReference suite;
    /**
     * TestCase associated to test point. Type WorkItemReference.
     */
    @JsonProperty("testCase")
    private WorkItemReference testCase;
    /**
     * TestPlan of test point. Type ShallowReference.
     */
    @JsonProperty("testPlan")
    private ShallowReference testPlan;
    /**
     * Test point Url.
     */
    @JsonProperty("url")
    private String url;
    /**
     * Work item properties of test point.
     */
    @JsonProperty("workItemProperties")
    private Object[] workItemProperties;

    public IdentityRef getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(IdentityRef assignedTo) {
        this.assignedTo = assignedTo;
    }

    public boolean isAutomated() {
        return automated;
    }

    public void setAutomated(boolean automated) {
        this.automated = automated;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public ShallowReference getConfiguration() {
        return configuration;
    }

    public void setConfiguration(ShallowReference configuration) {
        this.configuration = configuration;
    }

    public String getFailureType() {
        return failureType;
    }

    public void setFailureType(String failureType) {
        this.failureType = failureType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastResetToActive() {
        return lastResetToActive;
    }

    public void setLastResetToActive(String lastResetToActive) {
        this.lastResetToActive = lastResetToActive;
    }

    public Integer getLastResolutionStateId() {
        return lastResolutionStateId;
    }

    public void setLastResolutionStateId(Integer lastResolutionStateId) {
        this.lastResolutionStateId = lastResolutionStateId;
    }

    public ShallowReference getLastResult() {
        return lastResult;
    }

    public void setLastResult(ShallowReference lastResult) {
        this.lastResult = lastResult;
    }

    public LastResultDetails getLastResultDetails() {
        return lastResultDetails;
    }

    public void setLastResultDetails(LastResultDetails lastResultDetails) {
        this.lastResultDetails = lastResultDetails;
    }

    public String getLastResultState() {
        return lastResultState;
    }

    public void setLastResultState(String lastResultState) {
        this.lastResultState = lastResultState;
    }

    public String getLastRunBuildInteger() {
        return lastRunBuildInteger;
    }

    public void setLastRunBuildInteger(String lastRunBuildInteger) {
        this.lastRunBuildInteger = lastRunBuildInteger;
    }

    public ShallowReference getLastTestRun() {
        return lastTestRun;
    }

    public void setLastTestRun(ShallowReference lastTestRun) {
        this.lastTestRun = lastTestRun;
    }

    public IdentityRef getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(IdentityRef lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
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

    public Integer getRevision() {
        return revision;
    }

    public void setRevision(Integer revision) {
        this.revision = revision;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public ShallowReference getSuite() {
        return suite;
    }

    public void setSuite(ShallowReference suite) {
        this.suite = suite;
    }

    public WorkItemReference getTestCase() {
        return testCase;
    }

    public void setTestCase(WorkItemReference testCase) {
        this.testCase = testCase;
    }

    public ShallowReference getTestPlan() {
        return testPlan;
    }

    public void setTestPlan(ShallowReference testPlan) {
        this.testPlan = testPlan;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Object[] getWorkItemProperties() {
        return workItemProperties;
    }

    public void setWorkItemProperties(Object[] workItemProperties) {
        this.workItemProperties = workItemProperties;
    }
}
