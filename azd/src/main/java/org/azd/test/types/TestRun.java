package org.azd.test.types;
/*
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
*/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;
import org.azd.common.types.Author;
import org.azd.enums.RunFilter;
import org.azd.enums.TestRunSubstate;

import java.util.List;

/**
 * The types of sub states for test run.
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class TestRun extends SerializableEntity {
    /**
     * Build associated with this test run.
     **/
    @JsonProperty("build")
    private ShallowReference build;
    /**
     * Build configuration details associated with this test run.
     **/
    @JsonProperty("buildConfiguration")
    private BuildConfiguration buildConfiguration;
    /**
     * Comments entered by those analyzing the run.
     **/
    @JsonProperty("comment")
    private String comment;
    /**
     * Completed date time of the run.
     **/
    @JsonProperty("completedDate")
    private String completedDate;
    /**
     * Test Run Controller.
     **/
    @JsonProperty("controller")
    private String controller;
    /**
     * Test Run CreatedDate.
     **/
    @JsonProperty("createdDate")
    private String createdDate;
    /**
     * List of Custom Fields for TestRun.
     **/
    @JsonProperty("customFields")
    private List<CustomTestField> customFields;
    /**
     * Drop Location for the test Run.
     **/
    @JsonProperty("dropLocation")
    private String dropLocation;
    /**
     * An abstracted reference to some other resource. This class is used to provide the build data contracts with a uniform way to reference other resources in a way that provides easy traversal through links.
     **/
    @JsonProperty("dtlAutEnvironment")
    private ShallowReference dtlAutEnvironment;
    /**
     * An abstracted reference to some other resource. This class is used to provide the build data contracts with a uniform way to reference other resources in a way that provides easy traversal through links.
     **/
    @JsonProperty("dtlEnvironment")
    private ShallowReference dtlEnvironment;
    /**
     * This is a temporary class to provide the details for the test run environment.
     **/
    @JsonProperty("dtlEnvironmentCreationDetails")
    private DtlEnvironmentDetails dtlEnvironmentCreationDetails;
    /**
     * Due date and time for test run.
     **/
    @JsonProperty("dueDate")
    private String dueDate;
    /**
     * Error message associated with the run.
     **/
    @JsonProperty("errorMessage")
    private String errorMessage;
    /**
     * This class is used to provide the filters used for discovery
     **/
    @JsonProperty("filter")
    private RunFilter filter;
    /**
     * ID of the test run.
     **/
    @JsonProperty("id")
    private Integer id;
    /**
     * Number of Incomplete Tests.
     **/
    @JsonProperty("incompleteTests")
    private Integer incompleteTests;
    /**
     * true if test run is automated, false otherwise.
     **/
    @JsonProperty("isAutomated")
    private boolean isAutomated;
    /**
     * The iteration to which the run belongs.
     **/
    @JsonProperty("iteration")
    private String iteration;
    /**
     * Team foundation ID of the last updated the test run.
     **/
    @JsonProperty("lastUpdatedBy")
    private Author lastUpdatedBy;
    /**
     * Last updated date and time
     **/
    @JsonProperty("lastUpdatedDate")
    private String lastUpdatedDate;
    /**
     * Name of the test run.
     **/
    @JsonProperty("name")
    private String name;
    /**
     * Number of Not Applicable Tests.
     **/
    @JsonProperty("notApplicableTests")
    private Integer notApplicableTests;
    /**
     * Team Foundation ID of the owner of the runs.
     **/
    @JsonProperty("owner")
    private Author owner;
    /**
     * Number of passed tests in the run
     **/
    @JsonProperty("passedTests")
    private Integer passedTests;
    /**
     * Phase/State for the testRun.
     **/
    @JsonProperty("phase")
    private String phase;
    /**
     * Reference of the pipeline to which this test run belongs.
     **/
    @JsonProperty("pipelineReference")
    private PipelineReference pipelineReference;
    /**
     * Test plan associated with this test run.
     **/
    @JsonProperty("plan")
    private ShallowReference plan;
    /**
     * Post Process State.
     **/
    @JsonProperty("postProcessState")
    private String postProcessState;
    /**
     * Project associated with this run.
     **/
    @JsonProperty("project")
    private ShallowReference project;
    /**
     * Release Reference for the Test Run.
     **/
    @JsonProperty("release")
    private ReleaseReference release;
    /**
     * Release Environment Uri for TestRun.
     **/
    @JsonProperty("releaseEnvironmentUri")
    private String releaseEnvironmentUri;
    /**
     * Release Uri for TestRun.
     **/
    @JsonProperty("releaseUri")
    private String releaseUri;

    @JsonProperty("revision")
    private Integer revision;
    /**
     * RunSummary by outcome.
     **/
    @JsonProperty("runStatistics")
    private List<RunStatistic> runStatistics;
    /**
     * Start date time of the run.
     **/
    @JsonProperty("startedDate")
    private String startedDate;
    /**
     * The state of the run. Type TestRunState Valid states - Unspecified ,NotStarted, InProgress, Completed, Waiting, Aborted, NeedsInvestigation
     **/
    @JsonProperty("state")
    private String state;
    /**
     * TestRun Substate.
     **/
    @JsonProperty("substate")
    private TestRunSubstate substate;
    /**
     * Tags attached with this test run.
     **/
    @JsonProperty("tags")
    private List<TestTag> tags;
    /**
     * Test environment associated with the run.
     **/
    @JsonProperty("testEnvironment")
    private TestEnvironment testEnvironment;

    @JsonProperty("testMessageLogId")
    private Integer testMessageLogId;
    /**
     * An abstracted reference to some other resource. This class is used to provide the build data contracts with a uniform way to reference other resources in a way that provides easy traversal through links.
     **/
    @JsonProperty("testSettings")
    private ShallowReference testSettings;
    /**
     * Total tests in the run
     **/
    @JsonProperty("totalTests")
    private Integer totalTests;
    /**
     * Number of failed tests in the run.
     **/
    @JsonProperty("unanalyzedTests")
    private Integer unanalyzedTests;
    /**
     * Url of the test run
     **/
    @JsonProperty("url")
    private String url;
    /**
     * Web Access Url for TestRun.
     **/
    @JsonProperty("webAccessUrl")
    private String webAccessUrl;

    public ShallowReference getBuild() {
        return build;
    }

    public void setBuild(ShallowReference build) {
        this.build = build;
    }

    public BuildConfiguration getBuildConfiguration() {
        return buildConfiguration;
    }

    public void setBuildConfiguration(BuildConfiguration buildConfiguration) {
        this.buildConfiguration = buildConfiguration;
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

    public String getController() {
        return controller;
    }

    public void setController(String controller) {
        this.controller = controller;
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

    public String getDropLocation() {
        return dropLocation;
    }

    public void setDropLocation(String dropLocation) {
        this.dropLocation = dropLocation;
    }

    public ShallowReference getDtlAutEnvironment() {
        return dtlAutEnvironment;
    }

    public void setDtlAutEnvironment(ShallowReference dtlAutEnvironment) {
        this.dtlAutEnvironment = dtlAutEnvironment;
    }

    public ShallowReference getDtlEnvironment() {
        return dtlEnvironment;
    }

    public void setDtlEnvironment(ShallowReference dtlEnvironment) {
        this.dtlEnvironment = dtlEnvironment;
    }

    public DtlEnvironmentDetails getDtlEnvironmentCreationDetails() {
        return dtlEnvironmentCreationDetails;
    }

    public void setDtlEnvironmentCreationDetails(DtlEnvironmentDetails dtlEnvironmentCreationDetails) {
        this.dtlEnvironmentCreationDetails = dtlEnvironmentCreationDetails;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public RunFilter getFilter() {
        return filter;
    }

    public void setFilter(RunFilter filter) {
        this.filter = filter;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIncompleteTests() {
        return incompleteTests;
    }

    public void setIncompleteTests(Integer incompleteTests) {
        this.incompleteTests = incompleteTests;
    }

    public boolean getIsAutomated() {
        return isAutomated;
    }

    public void setIsAutomated(boolean isAutomated) {
        this.isAutomated = isAutomated;
    }

    public String getIteration() {
        return iteration;
    }

    public void setIteration(String iteration) {
        this.iteration = iteration;
    }

    public Author getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(Author lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public String getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(String lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNotApplicableTests() {
        return notApplicableTests;
    }

    public void setNotApplicableTests(Integer notApplicableTests) {
        this.notApplicableTests = notApplicableTests;
    }

    public Author getOwner() {
        return owner;
    }

    public void setOwner(Author owner) {
        this.owner = owner;
    }

    public Integer getPassedTests() {
        return passedTests;
    }

    public void setPassedTests(Integer passedTests) {
        this.passedTests = passedTests;
    }

    public String getPhase() {
        return phase;
    }

    public void setPhase(String phase) {
        this.phase = phase;
    }

    public PipelineReference getPipelineReference() {
        return pipelineReference;
    }

    public void setPipelineReference(PipelineReference pipelineReference) {
        this.pipelineReference = pipelineReference;
    }

    public ShallowReference getPlan() {
        return plan;
    }

    public void setPlan(ShallowReference plan) {
        this.plan = plan;
    }

    public String getPostProcessState() {
        return postProcessState;
    }

    public void setPostProcessState(String postProcessState) {
        this.postProcessState = postProcessState;
    }

    public ShallowReference getProject() {
        return project;
    }

    public void setProject(ShallowReference project) {
        this.project = project;
    }

    public ReleaseReference getRelease() {
        return release;
    }

    public void setRelease(ReleaseReference release) {
        this.release = release;
    }

    public String getReleaseEnvironmentUri() {
        return releaseEnvironmentUri;
    }

    public void setReleaseEnvironmentUri(String releaseEnvironmentUri) {
        this.releaseEnvironmentUri = releaseEnvironmentUri;
    }

    public String getReleaseUri() {
        return releaseUri;
    }

    public void setReleaseUri(String releaseUri) {
        this.releaseUri = releaseUri;
    }

    public Integer getRevision() {
        return revision;
    }

    public void setRevision(Integer revision) {
        this.revision = revision;
    }

    public List<RunStatistic> getRunStatistics() {
        return runStatistics;
    }

    public void setRunStatistics(List<RunStatistic> runStatistics) {
        this.runStatistics = runStatistics;
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

    public TestRunSubstate getSubstate() {
        return substate;
    }

    public void setSubstate(TestRunSubstate substate) {
        this.substate = substate;
    }

    public List<TestTag> getTags() {
        return tags;
    }

    public void setTags(List<TestTag> tags) {
        this.tags = tags;
    }

    public TestEnvironment getTestEnvironment() {
        return testEnvironment;
    }

    public void setTestEnvironment(TestEnvironment testEnvironment) {
        this.testEnvironment = testEnvironment;
    }

    public Integer getTestMessageLogId() {
        return testMessageLogId;
    }

    public void setTestMessageLogId(Integer testMessageLogId) {
        this.testMessageLogId = testMessageLogId;
    }

    public ShallowReference getTestSettings() {
        return testSettings;
    }

    public void setTestSettings(ShallowReference testSettings) {
        this.testSettings = testSettings;
    }

    public Integer getTotalTests() {
        return totalTests;
    }

    public void setTotalTests(Integer totalTests) {
        this.totalTests = totalTests;
    }

    public Integer getUnanalyzedTests() {
        return unanalyzedTests;
    }

    public void setUnanalyzedTests(Integer unanalyzedTests) {
        this.unanalyzedTests = unanalyzedTests;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getWebAccessUrl() {
        return webAccessUrl;
    }

    public void setWebAccessUrl(String webAccessUrl) {
        this.webAccessUrl = webAccessUrl;
    }

}