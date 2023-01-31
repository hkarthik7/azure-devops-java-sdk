package org.azd.test.types;
/*
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
*/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.Author;
import org.azd.common.types.BaseAbstractMethod;
import org.azd.enums.RunFilter;

import java.util.List;

/**
 * This class is used to provide the filters used for discovery 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class RunCreateModel extends BaseAbstractMethod {
	/**
 	* true if test run is automated, false otherwise. By default it will be false. 
	**/
	@JsonProperty("automated")
	private boolean automated;
	/**
 	* An abstracted reference to the build that it belongs. 
	**/
	@JsonProperty("build")
	private ShallowReference build;
	/**
 	* Drop location of the build used for test run. 
	**/
	@JsonProperty("buildDropLocation")
	private String buildDropLocation;
	/**
 	* Flavor of the build used for test run. (E.g: Release, Debug) 
	**/
	@JsonProperty("buildFlavor")
	private String buildFlavor;
	/**
 	* Platform of the build used for test run. (E.g.: x86, amd64) 
	**/
	@JsonProperty("buildPlatform")
	private String buildPlatform;
	/**
 	* BuildReference of the test run. 
	**/
	@JsonProperty("buildReference")
	private BuildConfiguration buildReference;
	/**
 	* Comments entered by those analyzing the run. 
	**/
	@JsonProperty("comment")
	private String comment;
	/**
 	* Completed date time of the run. 
	**/
	@JsonProperty("completeDate")
	private String completeDate;
	/**
 	* IDs of the test configurations associated with the run. 
	**/
	@JsonProperty("configurationIds")
	private List<Integer> configurationIds;
	/**
 	* Name of the test controller used for automated run. 
	**/
	@JsonProperty("controller")
	private String controller;
	/**
 	* Additional properties of test Run. 
	**/
	@JsonProperty("customTestFields")
	private List<CustomTestField> customTestFields;
	/**
 	* An abstracted reference to DtlAutEnvironment. 
	**/
	@JsonProperty("dtlAutEnvironment")
	private ShallowReference dtlAutEnvironment;
	/**
 	* An abstracted reference to DtlTestEnvironment. 
	**/
	@JsonProperty("dtlTestEnvironment")
	private ShallowReference dtlTestEnvironment;
	/**
 	* Due date and time for test run. 
	**/
	@JsonProperty("dueDate")
	private String dueDate;
	/**
 	* This is a temporary class to provide the details for the test run environment. 
	**/
	@JsonProperty("environmentDetails")
	private DtlEnvironmentDetails environmentDetails;
	/**
 	* Error message associated with the run. 
	**/
	@JsonProperty("errorMessage")
	private String errorMessage;
	/**
 	* Filter used for discovering the Run. 
	**/
	@JsonProperty("filter")
	private RunFilter filter;
	/**
 	* The iteration in which to create the run. Root iteration of the team project will be default 
	**/
	@JsonProperty("iteration")
	private String iteration;
	/**
 	* Name of the test run. 
	**/
	@JsonProperty("name")
	private String name;
	/**
 	* Display name of the owner of the run. 
	**/
	@JsonProperty("owner")
	private Author owner;
	/**
 	* Reference of the pipeline to which this test run belongs. PipelineReference.PipelineId should be equal to RunCreateModel.Build.Id 
	**/
	@JsonProperty("pipelineReference")
	private PipelineReference pipelineReference;
	/**
 	* An abstracted reference to the plan that it belongs. 
	**/
	@JsonProperty("plan")
	private ShallowReference plan;
	/**
 	* IDs of the test points to use in the run. 
	**/
	@JsonProperty("pointIds")
	private List<Integer> pointIds;
	/**
 	* URI of release environment associated with the run. 
	**/
	@JsonProperty("releaseEnvironmentUri")
	private String releaseEnvironmentUri;
	/**
 	* Reference to release associated with test run. 
	**/
	@JsonProperty("releaseReference")
	private ReleaseReference releaseReference;
	/**
 	* URI of release associated with the run. 
	**/
	@JsonProperty("releaseUri")
	private String releaseUri;
	/**
 	* Run summary for run Type = NoConfigRun. 
	**/
	@JsonProperty("runSummary")
	private List<RunSummaryModel> runSummary;
	/**
 	* Timespan till the run times out. 
	**/
	@JsonProperty("runTimeout")
	private String runTimeout;
	/**
 	* SourceWorkFlow(CI/CD) of the test run. 
	**/
	@JsonProperty("sourceWorkflow")
	private String sourceWorkflow;
	/**
 	* Start date time of the run. 
	**/
	@JsonProperty("startDate")
	private String startDate;
	/**
 	* The state of the run. Type TestRunState Valid states - NotStarted, InProgress, Waiting 
	**/
	@JsonProperty("state")
	private String state;
	/**
 	* Tags to attach with the test run, maximum of 5 tags can be added to run. 
	**/
	@JsonProperty("tags")
	private List<TestTag> tags;
	/**
 	* TestConfigurationMapping of the test run. 
	**/
	@JsonProperty("testConfigurationsMapping")
	private String testConfigurationsMapping;
	/**
 	* ID of the test environment associated with the run. 
	**/
	@JsonProperty("testEnvironmentId")
	private String testEnvironmentId;
	/**
 	* An abstracted reference to the test settings resource. 
	**/
	@JsonProperty("testSettings")
	private ShallowReference testSettings;
	/**
 	* Type of the run(RunType) Valid Values : (Unspecified, Normal, Blocking, Web, MtrRunInitiatedFromWeb, RunWithDtlEnv, NoConfigRun) 
	**/
	@JsonProperty("type")
	private String type;

	public boolean getAutomated() { return automated; }

	public void setAutomated(boolean automated) { this.automated = automated; }

	public ShallowReference getBuild() { return build; }

	public void setBuild(ShallowReference build) { this.build = build; }

	public String getBuildDropLocation() { return buildDropLocation; }

	public void setBuildDropLocation(String buildDropLocation) { this.buildDropLocation = buildDropLocation; }

	public String getBuildFlavor() { return buildFlavor; }

	public void setBuildFlavor(String buildFlavor) { this.buildFlavor = buildFlavor; }

	public String getBuildPlatform() { return buildPlatform; }

	public void setBuildPlatform(String buildPlatform) { this.buildPlatform = buildPlatform; }

	public BuildConfiguration getBuildReference() { return buildReference; }

	public void setBuildReference(BuildConfiguration buildReference) { this.buildReference = buildReference; }

	public String getComment() { return comment; }

	public void setComment(String comment) { this.comment = comment; }

	public String getCompleteDate() { return completeDate; }

	public void setCompleteDate(String completeDate) { this.completeDate = completeDate; }

	public List<Integer> getConfigurationIds() { return configurationIds; }

	public void setConfigurationIds(List<Integer> configurationIds) { this.configurationIds = configurationIds; }

	public String getController() { return controller; }

	public void setController(String controller) { this.controller = controller; }

	public List<CustomTestField> getCustomTestFields() { return customTestFields; }

	public void setCustomTestFields(List<CustomTestField> customTestFields) { this.customTestFields = customTestFields; }

	public ShallowReference getDtlAutEnvironment() { return dtlAutEnvironment; }

	public void setDtlAutEnvironment(ShallowReference dtlAutEnvironment) { this.dtlAutEnvironment = dtlAutEnvironment; }

	public ShallowReference getDtlTestEnvironment() { return dtlTestEnvironment; }

	public void setDtlTestEnvironment(ShallowReference dtlTestEnvironment) { this.dtlTestEnvironment = dtlTestEnvironment; }

	public String getDueDate() { return dueDate; }

	public void setDueDate(String dueDate) { this.dueDate = dueDate; }

	public DtlEnvironmentDetails getEnvironmentDetails() { return environmentDetails; }

	public void setEnvironmentDetails(DtlEnvironmentDetails environmentDetails) { this.environmentDetails = environmentDetails; }

	public String getErrorMessage() { return errorMessage; }

	public void setErrorMessage(String errorMessage) { this.errorMessage = errorMessage; }

	public RunFilter getFilter() { return filter; }

	public void setFilter(RunFilter filter) { this.filter = filter; }

	public String getIteration() { return iteration; }

	public void setIteration(String iteration) { this.iteration = iteration; }

	public String getName() { return name; }

	public void setName(String name) { this.name = name; }

	public Author getOwner() { return owner; }

	public void setOwner(Author owner) { this.owner = owner; }

	public PipelineReference getPipelineReference() { return pipelineReference; }

	public void setPipelineReference(PipelineReference pipelineReference) { this.pipelineReference = pipelineReference; }

	public ShallowReference getPlan() { return plan; }

	public void setPlan(ShallowReference plan) { this.plan = plan; }

	public List<Integer> getPointIds() { return pointIds; }

	public void setPointIds(List<Integer> pointIds) { this.pointIds = pointIds; }

	public String getReleaseEnvironmentUri() { return releaseEnvironmentUri; }

	public void setReleaseEnvironmentUri(String releaseEnvironmentUri) { this.releaseEnvironmentUri = releaseEnvironmentUri; }

	public ReleaseReference getReleaseReference() { return releaseReference; }

	public void setReleaseReference(ReleaseReference releaseReference) { this.releaseReference = releaseReference; }

	public String getReleaseUri() { return releaseUri; }

	public void setReleaseUri(String releaseUri) { this.releaseUri = releaseUri; }

	public List<RunSummaryModel> getRunSummary() { return runSummary; }

	public void setRunSummary(List<RunSummaryModel> runSummary) { this.runSummary = runSummary; }

	public String getRunTimeout() { return runTimeout; }

	public void setRunTimeout(String runTimeout) { this.runTimeout = runTimeout; }

	public String getSourceWorkflow() { return sourceWorkflow; }

	public void setSourceWorkflow(String sourceWorkflow) { this.sourceWorkflow = sourceWorkflow; }

	public String getStartDate() { return startDate; }

	public void setStartDate(String startDate) { this.startDate = startDate; }

	public String getState() { return state; }

	public void setState(String state) { this.state = state; }

	public List<TestTag> getTags() { return tags; }

	public void setTags(List<TestTag> tags) { this.tags = tags; }

	public String getTestConfigurationsMapping() { return testConfigurationsMapping; }

	public void setTestConfigurationsMapping(String testConfigurationsMapping) { this.testConfigurationsMapping = testConfigurationsMapping; }

	public String getTestEnvironmentId() { return testEnvironmentId; }

	public void setTestEnvironmentId(String testEnvironmentId) { this.testEnvironmentId = testEnvironmentId; }

	public ShallowReference getTestSettings() { return testSettings; }

	public void setTestSettings(ShallowReference testSettings) { this.testSettings = testSettings; }

	public String getType() { return type; }

	public void setType(String type) { this.type = type; }

}