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
 * Represents a test result with detailed information about its execution,
 * outcome, and associated entities such as builds, releases, and test plans.
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class TestCaseResult extends SerializableEntity {

    /**
     * Test attachment ID of action recording.
     **/
    @JsonProperty("afnStripId")
    private Integer afnStripId;

    /**
     * Reference to the area path of the test.
     **/
    @JsonProperty("area")
    private ShallowReference area;

    /**
     * References to bugs linked to the test result.
     **/
    @JsonProperty("associatedBugs")
    private List<ShallowReference> associatedBugs;

    /**
     * ID representing the test method in a DLL.
     **/
    @JsonProperty("automatedTestId")
    private String automatedTestId;

    /**
     * Fully qualified name of the executed test.
     **/
    @JsonProperty("automatedTestName")
    private String automatedTestName;

    /**
     * Container to which the test belongs.
     **/
    @JsonProperty("automatedTestStorage")
    private String automatedTestStorage;

    /**
     * Type of the automated test.
     **/
    @JsonProperty("automatedTestType")
    private String automatedTestType;

    /**
     * Type ID of the automated test.
     **/
    @JsonProperty("automatedTestTypeId")
    private String automatedTestTypeId;

    /**
     * Shallow reference to the build associated with the test result.
     **/
    @JsonProperty("build")
    private ShallowReference build;

    /**
     * Detailed reference to the build associated with the test result.
     **/
    @JsonProperty("buildReference")
    private BuildReference buildReference;

    /**
     * Comment associated with the test result (max 1000 characters).
     **/
    @JsonProperty("comment")
    private String comment;

    /**
     * Time when the test execution was completed (UTC).
     **/
    @JsonProperty("completedDate")
    private String completedDate;

    /**
     * Machine name where the test was executed.
     **/
    @JsonProperty("computerName")
    private String computerName;

    /**
     * Reference to the test configuration.
     **/
    @JsonProperty("configuration")
    private ShallowReference configuration;

    /**
     * Timestamp when the test result was created (UTC).
     **/
    @JsonProperty("createdDate")
    private String createdDate;

    /**
     * Array of custom fields for additional categorization of the test result.
     **/
    @JsonProperty("customFields")
    private List<CustomTestField> customFields;

    /**
     * Duration of the test execution in milliseconds.
     **/
    @JsonProperty("durationInMs")
    private Long durationInMs;

    /**
     * Error message from the test execution, if any.
     **/
    @JsonProperty("errorMessage")
    private String errorMessage;

    /**
     * Information about when the test result started failing.
     **/
    @JsonProperty("failingSince")
    private FailingSince failingSince;

    /**
     * Failure type of the test result (e.g., Known Issue, New Issue, Regression).
     **/
    @JsonProperty("failureType")
    private String failureType;

    /**
     * ID of the test result.
     **/
    @JsonProperty("id")
    private Integer id;

    /**
     * Details of test iterations (used for manual testing).
     **/
    @JsonProperty("iterationDetails")
    private List<TestIterationDetailsModel> iterationDetails;

    /**
     * Reference to the identity that last updated the test result.
     **/
    @JsonProperty("lastUpdatedBy")
    private IdentityRef lastUpdatedBy;

    /**
     * Timestamp of the last update to the test result (UTC).
     **/
    @JsonProperty("lastUpdatedDate")
    private String lastUpdatedDate;

    /**
     * Outcome of the test result (e.g., Passed, Failed, Inconclusive).
     **/
    @JsonProperty("outcome")
    private String outcome;

    /**
     * Reference to the owner of the test.
     **/
    @JsonProperty("owner")
    private IdentityRef owner;

    /**
     * Priority of the test execution.
     **/
    @JsonProperty("priority")
    private Integer priority;

    /**
     * Reference to the team project.
     **/
    @JsonProperty("project")
    private ShallowReference project;

    /**
     * Shallow reference to the release associated with the test result.
     **/
    @JsonProperty("release")
    private ShallowReference release;

    /**
     * Detailed reference to the release associated with the test result.
     **/
    @JsonProperty("releaseReference")
    private ReleaseReference releaseReference;

    /**
     * Number of times the test has been reset.
     **/
    @JsonProperty("resetCount")
    private Integer resetCount;

    /**
     * Resolution state of the test result.
     **/
    @JsonProperty("resolutionState")
    private String resolutionState;

    /**
     * ID of the resolution state.
     **/
    @JsonProperty("resolutionStateId")
    private Integer resolutionStateId;

    /**
     * Hierarchy type of the result.
     **/
    @JsonProperty("resultGroupType")
    private String resultGroupType;

    /**
     * Revision number of the test result.
     **/
    @JsonProperty("revision")
    private Integer revision;

    /**
     * Reference to the identity that executed the test.
     **/
    @JsonProperty("runBy")
    private IdentityRef runBy;

    /**
     * Stack trace (max 1000 characters) from the test execution, if any.
     **/
    @JsonProperty("stackTrace")
    private String stackTrace;

    /**
     * Time when the test execution started (UTC).
     **/
    @JsonProperty("startedDate")
    private String startedDate;

    /**
     * State of the test result.
     **/
    @JsonProperty("state")
    private String state;

    /**
     * List of sub-results inside a test result.
     **/
    @JsonProperty("subResults")
    private List<TestSubResult> subResults;

    /**
     * Reference to the test executed.
     **/
    @JsonProperty("testCase")
    private ShallowReference testCase;

    /**
     * Reference ID of the test case used by the test result.
     **/
    @JsonProperty("testCaseReferenceId")
    private Integer testCaseReferenceId;

    /**
     * Revision number of the test case.
     **/
    @JsonProperty("testCaseRevision")
    private Integer testCaseRevision;

    /**
     * Title of the test case.
     **/
    @JsonProperty("testCaseTitle")
    private String testCaseTitle;

    /**
     * Reference to the test plan.
     **/
    @JsonProperty("testPlan")
    private ShallowReference testPlan;

    /**
     * Reference to the test point executed.
     **/
    @JsonProperty("testPoint")
    private ShallowReference testPoint;

    /**
     * Reference to the test run.
     **/
    @JsonProperty("testRun")
    private ShallowReference testRun;

    /**
     * Reference to the test suite.
     **/
    @JsonProperty("testSuite")
    private ShallowReference testSuite;

    /**
     * URL of the test result.
     **/
    @JsonProperty("url")
    private String url;

    public Integer getAfnStripId() {
        return afnStripId;
    }

    public void setAfnStripId(Integer afnStripId) {
        this.afnStripId = afnStripId;
    }

    public ShallowReference getArea() {
        return area;
    }

    public void setArea(ShallowReference area) {
        this.area = area;
    }

    public List<ShallowReference> getAssociatedBugs() {
        return associatedBugs;
    }

    public void setAssociatedBugs(List<ShallowReference> associatedBugs) {
        this.associatedBugs = associatedBugs;
    }

    public String getAutomatedTestId() {
        return automatedTestId;
    }

    public void setAutomatedTestId(String automatedTestId) {
        this.automatedTestId = automatedTestId;
    }

    public String getAutomatedTestName() {
        return automatedTestName;
    }

    public void setAutomatedTestName(String automatedTestName) {
        this.automatedTestName = automatedTestName;
    }

    public String getAutomatedTestStorage() {
        return automatedTestStorage;
    }

    public void setAutomatedTestStorage(String automatedTestStorage) {
        this.automatedTestStorage = automatedTestStorage;
    }

    public String getAutomatedTestType() {
        return automatedTestType;
    }

    public void setAutomatedTestType(String automatedTestType) {
        this.automatedTestType = automatedTestType;
    }

    public String getAutomatedTestTypeId() {
        return automatedTestTypeId;
    }

    public void setAutomatedTestTypeId(String automatedTestTypeId) {
        this.automatedTestTypeId = automatedTestTypeId;
    }

    public ShallowReference getBuild() {
        return build;
    }

    public void setBuild(ShallowReference build) {
        this.build = build;
    }

    public BuildReference getBuildReference() {
        return buildReference;
    }

    public void setBuildReference(BuildReference buildReference) {
        this.buildReference = buildReference;
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

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public List<CustomTestField> getCustomFields() {
        return customFields;
    }

    public void setCustomFields(List<CustomTestField> customFields) {
        this.customFields = customFields;
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

    public FailingSince getFailingSince() {
        return failingSince;
    }

    public void setFailingSince(FailingSince failingSince) {
        this.failingSince = failingSince;
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

    public List<TestIterationDetailsModel> getIterationDetails() {
        return iterationDetails;
    }

    public void setIterationDetails(List<TestIterationDetailsModel> iterationDetails) {
        this.iterationDetails = iterationDetails;
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

    public IdentityRef getOwner() {
        return owner;
    }

    public void setOwner(IdentityRef owner) {
        this.owner = owner;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public ShallowReference getProject() {
        return project;
    }

    public void setProject(ShallowReference project) {
        this.project = project;
    }

    public ShallowReference getRelease() {
        return release;
    }

    public void setRelease(ShallowReference release) {
        this.release = release;
    }

    public ReleaseReference getReleaseReference() {
        return releaseReference;
    }

    public void setReleaseReference(ReleaseReference releaseReference) {
        this.releaseReference = releaseReference;
    }

    public Integer getResetCount() {
        return resetCount;
    }

    public void setResetCount(Integer resetCount) {
        this.resetCount = resetCount;
    }

    public String getResolutionState() {
        return resolutionState;
    }

    public void setResolutionState(String resolutionState) {
        this.resolutionState = resolutionState;
    }

    public Integer getResolutionStateId() {
        return resolutionStateId;
    }

    public void setResolutionStateId(Integer resolutionStateId) {
        this.resolutionStateId = resolutionStateId;
    }

    public String getResultGroupType() {
        return resultGroupType;
    }

    public void setResultGroupType(String resultGroupType) {
        this.resultGroupType = resultGroupType;
    }

    public Integer getRevision() {
        return revision;
    }

    public void setRevision(Integer revision) {
        this.revision = revision;
    }

    public IdentityRef getRunBy() {
        return runBy;
    }

    public void setRunBy(IdentityRef runBy) {
        this.runBy = runBy;
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<TestSubResult> getSubResults() {
        return subResults;
    }

    public void setSubResults(List<TestSubResult> subResults) {
        this.subResults = subResults;
    }

    public ShallowReference getTestCase() {
        return testCase;
    }

    public void setTestCase(ShallowReference testCase) {
        this.testCase = testCase;
    }

    public Integer getTestCaseReferenceId() {
        return testCaseReferenceId;
    }

    public void setTestCaseReferenceId(Integer testCaseReferenceId) {
        this.testCaseReferenceId = testCaseReferenceId;
    }

    public Integer getTestCaseRevision() {
        return testCaseRevision;
    }

    public void setTestCaseRevision(Integer testCaseRevision) {
        this.testCaseRevision = testCaseRevision;
    }

    public String getTestCaseTitle() {
        return testCaseTitle;
    }

    public void setTestCaseTitle(String testCaseTitle) {
        this.testCaseTitle = testCaseTitle;
    }

    public ShallowReference getTestPlan() {
        return testPlan;
    }

    public void setTestPlan(ShallowReference testPlan) {
        this.testPlan = testPlan;
    }

    public ShallowReference getTestPoint() {
        return testPoint;
    }

    public void setTestPoint(ShallowReference testPoint) {
        this.testPoint = testPoint;
    }

    public ShallowReference getTestRun() {
        return testRun;
    }

    public void setTestRun(ShallowReference testRun) {
        this.testRun = testRun;
    }

    public ShallowReference getTestSuite() {
        return testSuite;
    }

    public void setTestSuite(ShallowReference testSuite) {
        this.testSuite = testSuite;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
