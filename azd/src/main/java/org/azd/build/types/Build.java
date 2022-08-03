package org.azd.build.types;
/**
 * ----------------------------------------------------------
 * GENERATED FILE, should be edited to suit the purpose.
 * ----------------------------------------------------------
 **/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.Author;
import org.azd.common.types.BaseAbstractMethod;
import org.azd.enums.BuildReason;
import org.azd.enums.BuildResult;
import org.azd.enums.BuildStatus;
import org.azd.enums.QueuePriority;

import java.util.List;

/**
 * The job authorization scope for builds queued against this definition. 
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class Build extends BaseAbstractMethod {
    /**
     * The class to represent a collection of REST reference links.
     **/
    @JsonProperty("_links")
    private Object _links;
    /**
     * The agent specification for the build.
     **/
    @JsonProperty("agentSpecification")
    private AgentSpecification agentSpecification;
    /**
     * The build number/name of the build.
     **/
    @JsonProperty("buildNumber")
    private String buildNumber;
    /**
     * The build number revision.
     **/
    @JsonProperty("buildNumberRevision")
    private Integer buildNumberRevision;
    /**
     * The build controller. This is only set if the definition type is Xaml.
     **/
    @JsonProperty("controller")
    private BuildController controller;
    /**
     * The definition associated with the build.
     **/
    @JsonProperty("definition")
    private DefinitionReference definition;
    /**
     * Indicates whether the build has been deleted.
     **/
    @JsonProperty("deleted")
    private Boolean deleted;
    /**
     * The identity of the process or person that deleted the build.
     **/
    @JsonProperty("deletedBy")
    private Author deletedBy;
    /**
     * The date the build was deleted.
     **/
    @JsonProperty("deletedDate")
    private String deletedDate;
    /**
     * The description of how the build was deleted.
     **/
    @JsonProperty("deletedReason")
    private String deletedReason;
    /**
     * A list of demands that represents the agent capabilities required by this build.
     **/
    @JsonProperty("demands")
    private List<Demand> demands;
    /**
     * The time that the build was completed.
     **/
    @JsonProperty("finishTime")
    private String finishTime;
    /**
     * The ID of the build.
     **/
    @JsonProperty("id")
    private Integer id;
    /**
     * The identity representing the process or person that last changed the build.
     **/
    @JsonProperty("lastChangedBy")
    private Author lastChangedBy;
    /**
     * The date the build was last changed.
     **/
    @JsonProperty("lastChangedDate")
    private String lastChangedDate;
    /**
     * Information about the build logs.
     **/
    @JsonProperty("logs")
    private BuildLogReference logs;
    /**
     * The orchestration plan for the build.
     **/
    @JsonProperty("orchestrationPlan")
    private TaskOrchestrationPlanReference orchestrationPlan;
    /**
     * The parameters for the build.
     **/
    @JsonProperty("parameters")
    private String parameters;
    /**
     * Orchestration plans associated with the build (build, cleanup)
     **/
    @JsonProperty("plans")
    private List<TaskOrchestrationPlanReference> plans;
    /**
     * The build's priority.
     **/
    @JsonProperty("priority")
    private QueuePriority priority;
    /**
     * The team project.
     **/
    @JsonProperty("project")
    private TeamProjectReference project;
    /**
     * The class represents a property bag as a collection of key-value pairs. Values of all primitive types (any type with a TypeCode != TypeCode.Object) except for DBNull are accepted. Values of type Byte[], Int32, Double, DateType and String preserve their type, other primitives are retuned as a String. Byte[] expected as base64 encoded string.
     **/
    @JsonProperty("properties")
    private PropertiesCollection properties;
    /**
     * The quality of the xaml build (good, bad, etc.)
     **/
    @JsonProperty("quality")
    private String quality;
    /**
     * The queue. This is only set if the definition type is Build. WARNING: this field is deprecated and does not corresponds to the jobs queues.
     **/
    @JsonProperty("queue")
    private AgentPoolQueue queue;
    /**
     * Additional options for queueing the build.
     **/
    @JsonProperty("queueOptions")
    private QueueOptions queueOptions;
    /**
     * The current position of the build in the queue.
     **/
    @JsonProperty("queuePosition")
    private Integer queuePosition;
    /**
     * The time that the build was queued.
     **/
    @JsonProperty("queueTime")
    private String queueTime;
    /**
     * The reason that the build was created.
     **/
    @JsonProperty("reason")
    private BuildReason reason;
    /**
     * The repository.
     **/
    @JsonProperty("repository")
    private BuildRepository repository;
    /**
     * The identity that queued the build.
     **/
    @JsonProperty("requestedBy")
    private Author requestedBy;
    /**
     * The identity on whose behalf the build was queued.
     **/
    @JsonProperty("requestedFor")
    private Author requestedFor;
    /**
     * The build result.
     **/
    @JsonProperty("result")
    private BuildResult result;
    /**
     * Indicates whether the build is retained by a release.
     **/
    @JsonProperty("retainedByRelease")
    private Boolean retainedByRelease;
    /**
     * The source branch.
     **/
    @JsonProperty("sourceBranch")
    private String sourceBranch;
    /**
     * The source version.
     **/
    @JsonProperty("sourceVersion")
    private String sourceVersion;
    /**
     * The time that the build was started.
     **/
    @JsonProperty("startTime")
    private String startTime;
    /**
     * The status of the build.
     **/
    @JsonProperty("status")
    private BuildStatus status;

    @JsonProperty("tags")
    private String[] tags;
    /**
     * Parameters to template expression evaluation
     **/
    @JsonProperty("templateParameters")
    private Object templateParameters;
    /**
     * Sourceprovider-specific information about what triggered the build
     **/
    @JsonProperty("triggerInfo")
    private Object triggerInfo;
    /**
     * The build that triggered this build via a Build completion trigger.
     **/
    @JsonProperty("triggeredByBuild")
    private Build triggeredByBuild;
    /**
     * The URI of the build.
     **/
    @JsonProperty("uri")
    private String uri;
    /**
     * The REST URL of the build.
     **/
    @JsonProperty("url")
    private String url;
    /**
     * Represents the result of validating a build request.
     **/
    @JsonProperty("validationResults")
    private List<BuildRequestValidationResult> validationResults;

    public Object get_links() {
        return _links;
    }

    public void set_links(Object _links) {
        this._links = _links;
    }

    public AgentSpecification getAgentSpecification() {
        return agentSpecification;
    }

    public void setAgentSpecification(AgentSpecification agentSpecification) {
        this.agentSpecification = agentSpecification;
    }

    public String getBuildNumber() {
        return buildNumber;
    }

    public void setBuildNumber(String buildNumber) {
        this.buildNumber = buildNumber;
    }

    public Integer getBuildNumberRevision() {
        return buildNumberRevision;
    }

    public void setBuildNumberRevision(Integer buildNumberRevision) {
        this.buildNumberRevision = buildNumberRevision;
    }

    public BuildController getController() {
        return controller;
    }

    public void setController(BuildController controller) {
        this.controller = controller;
    }

    public DefinitionReference getDefinition() {
        return definition;
    }

    public void setDefinition(DefinitionReference definition) {
        this.definition = definition;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Author getDeletedBy() {
        return deletedBy;
    }

    public void setDeletedBy(Author deletedBy) {
        this.deletedBy = deletedBy;
    }

    public String getDeletedDate() {
        return deletedDate;
    }

    public void setDeletedDate(String deletedDate) {
        this.deletedDate = deletedDate;
    }

    public String getDeletedReason() {
        return deletedReason;
    }

    public void setDeletedReason(String deletedReason) {
        this.deletedReason = deletedReason;
    }

    public List<Demand> getDemands() {
        return demands;
    }

    public void setDemands(List<Demand> demands) {
        this.demands = demands;
    }

    public String getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(String finishTime) {
        this.finishTime = finishTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Author getLastChangedBy() {
        return lastChangedBy;
    }

    public void setLastChangedBy(Author lastChangedBy) {
        this.lastChangedBy = lastChangedBy;
    }

    public String getLastChangedDate() {
        return lastChangedDate;
    }

    public void setLastChangedDate(String lastChangedDate) {
        this.lastChangedDate = lastChangedDate;
    }

    public BuildLogReference getLogs() {
        return logs;
    }

    public void setLogs(BuildLogReference logs) {
        this.logs = logs;
    }

    public TaskOrchestrationPlanReference getOrchestrationPlan() {
        return orchestrationPlan;
    }

    public void setOrchestrationPlan(TaskOrchestrationPlanReference orchestrationPlan) {
        this.orchestrationPlan = orchestrationPlan;
    }

    public String getParameters() {
        return parameters;
    }

    public void setParameters(String parameters) {
        this.parameters = parameters;
    }

    public List<TaskOrchestrationPlanReference> getPlans() {
        return plans;
    }

    public void setPlans(List<TaskOrchestrationPlanReference> plans) {
        this.plans = plans;
    }

    public QueuePriority getPriority() {
        return priority;
    }

    public void setPriority(QueuePriority priority) {
        this.priority = priority;
    }

    public TeamProjectReference getProject() {
        return project;
    }

    public void setProject(TeamProjectReference project) {
        this.project = project;
    }

    public PropertiesCollection getProperties() {
        return properties;
    }

    public void setProperties(PropertiesCollection properties) {
        this.properties = properties;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public AgentPoolQueue getQueue() {
        return queue;
    }

    public void setQueue(AgentPoolQueue queue) {
        this.queue = queue;
    }

    public QueueOptions getQueueOptions() {
        return queueOptions;
    }

    public void setQueueOptions(QueueOptions queueOptions) {
        this.queueOptions = queueOptions;
    }

    public Integer getQueuePosition() {
        return queuePosition;
    }

    public void setQueuePosition(Integer queuePosition) {
        this.queuePosition = queuePosition;
    }

    public String getQueueTime() {
        return queueTime;
    }

    public void setQueueTime(String queueTime) {
        this.queueTime = queueTime;
    }

    public BuildReason getReason() {
        return reason;
    }

    public void setReason(BuildReason reason) {
        this.reason = reason;
    }

    public BuildRepository getRepository() {
        return repository;
    }

    public void setRepository(BuildRepository repository) {
        this.repository = repository;
    }

    public Author getRequestedBy() {
        return requestedBy;
    }

    public void setRequestedBy(Author requestedBy) {
        this.requestedBy = requestedBy;
    }

    public Author getRequestedFor() {
        return requestedFor;
    }

    public void setRequestedFor(Author requestedFor) {
        this.requestedFor = requestedFor;
    }

    public BuildResult getResult() {
        return result;
    }

    public void setResult(BuildResult result) {
        this.result = result;
    }

    public Boolean getRetainedByRelease() {
        return retainedByRelease;
    }

    public void setRetainedByRelease(Boolean retainedByRelease) {
        this.retainedByRelease = retainedByRelease;
    }

    public String getSourceBranch() {
        return sourceBranch;
    }

    public void setSourceBranch(String sourceBranch) {
        this.sourceBranch = sourceBranch;
    }

    public String getSourceVersion() {
        return sourceVersion;
    }

    public void setSourceVersion(String sourceVersion) {
        this.sourceVersion = sourceVersion;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public BuildStatus getStatus() {
        return status;
    }

    public void setStatus(BuildStatus status) {
        this.status = status;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public java.lang.Object getTemplateParameters() {
        return templateParameters;
    }

    public void setTemplateParameters(Object templateParameters) {
        this.templateParameters = templateParameters;
    }

    public java.lang.Object getTriggerInfo() {
        return triggerInfo;
    }

    public void setTriggerInfo(Object triggerInfo) {
        this.triggerInfo = triggerInfo;
    }

    public Build getTriggeredByBuild() {
        return triggeredByBuild;
    }

    public void setTriggeredByBuild(Build triggeredByBuild) {
        this.triggeredByBuild = triggeredByBuild;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<BuildRequestValidationResult> getValidationResults() {
        return validationResults;
    }

    public void setValidationResults(List<BuildRequestValidationResult> validationResults) {
        this.validationResults = validationResults;
    }

}
