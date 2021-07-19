package org.azd.build.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.Author;
import org.azd.core.types.Project;

import java.util.Arrays;
import java.util.List;

/***
 * Data representation of a build.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Build {
    /***
     * The class to represent a collection of REST reference links.
     */
    @JsonProperty("_links")
    private BuildReferenceLinks _links;
    /***
     * The agent specification for the build.
     */
    @JsonProperty("agentSpecification")
    private AgentSpecification agentSpecification;
    /***
     * The build number/name of the build.
     */
    @JsonProperty("buildNumber")
    private String buildNumber;
    /***
     * The build number revision.
     */
    @JsonProperty("buildNumberRevision")
    private int buildNumberRevision;
    /***
     * The build controller. This is only set if the definition type is Xaml.
     */
    @JsonProperty("controller")
    private BuildController controller;
    /***
     * The definition associated with the build.
     */
    @JsonProperty("definition")
    private DefinitionReference definition;
    /***
     * Indicates whether the build has been deleted.
     */
    @JsonProperty("deleted")
    private boolean deleted;
    /***
     * The identity of the process or person that deleted the build.
     */
    @JsonProperty("deletedBy")
    private Author deletedBy;
    /***
     * The date the build was deleted.
     */
    @JsonProperty("deletedDate")
    private String deletedDate;
    /***
     * The description of how the build was deleted.
     */
    @JsonProperty("deletedReason")
    private String deletedReason;
    /***
     * A list of demands that represents the agent capabilities required by this build.
     */
    @JsonProperty("demands")
    private List<Demand> demands;
    /***
     * The time that the build was completed.
     */
    @JsonProperty("finishTime")
    private String finishTime;
    /***
     * The ID of the build.
     */
    @JsonProperty("id")
    private int id;
    /***
     * Indicates whether the build should be skipped by retention policies.
     */
    @JsonProperty("keepForever")
    private boolean keepForever;
    /***
     * The identity representing the process or person that last changed the build.
     */
    @JsonProperty("lastChangedBy")
    private Author lastChangedBy;
    /***
     * The date the build was last changed.
     */
    @JsonProperty("lastChangedDate")
    private String lastChangedDate;
    /***
     * Information about the build logs.
     */
    @JsonProperty("logs")
    private Logs logs;
    /***
     * The orchestration plan for the build.
     */
    @JsonProperty("orchestrationPlan")
    private OrchestrationPlan orchestrationPlan;
    /***
     * The parameters for the build.
     */
    @JsonProperty("parameters")
    private String parameters;
    /***
     * Orchestration plans associated with the build (build, cleanup)
     */
    @JsonProperty("plans")
    private List<OrchestrationPlan> plans;
    /***
     * The build's priority.
     */
    @JsonProperty("priority")
    private String priority;
    /***
     * The team project.
     */
    @JsonProperty("project")
    private Project project;
    /***
     * The quality of the xaml build (good, bad, etc.)
     */
    @JsonProperty("quality")
    private String quality;
    /***
     * The queue. This is only set if the definition type is Build. WARNING: this field is deprecated and does not corresponds to the jobs queues.
     */
    @JsonProperty("queue")
    private BuildQueue queue;
    /***
     * Additional options for queueing the build.
     */
    @JsonProperty("queueOptions")
    private String queueOptions;
    /***
     * The current position of the build in the queue.
     */
    @JsonProperty("queuePosition")
    private int queuePosition;
    /***
     * The time that the build was queued.
     */
    @JsonProperty("queueTime")
    private String queueTime;
    /***
     * The reason that the build was created.
     */
    @JsonProperty("reason")
    private String reason;
    /***
     * The repository.
     */
    @JsonProperty("repository")
    private Repository repository;
    /***
     * The identity that queued the build.
     */
    @JsonProperty("requestedBy")
    private Author requestedBy;
    /***
     * The identity on whose behalf the build was queued.
     */
    @JsonProperty("requestedFor")
    private RequestedFor requestedFor;
    /***
     * The build result.
     */
    @JsonProperty("result")
    private String result;
    /***
     * Indicates whether the build is retained by a release.
     */
    @JsonProperty("retainedByRelease")
    private boolean retainedByRelease;
    /***
     * The source branch.
     */
    @JsonProperty("sourceBranch")
    private String sourceBranch;
    /***
     * The source version.
     */
    @JsonProperty("sourceVersion")
    private String sourceVersion;
    /***
     * The time that the build was started.
     */
    @JsonProperty("startTime")
    private String startTime;
    /***
     * The status of the build.
     */
    @JsonProperty("status")
    private String status;
    /***
     * Tags
     */
    @JsonProperty("tags")
    private String[] tags;
    /***
     * Sourceprovider-specific information about what triggered the build
     */
    @JsonProperty("triggerInfo")
    private TriggerInfo triggerInfo;
    /***
     * The build that triggered this build via a Build completion trigger.
     */
    @JsonProperty("triggeredByBuild")
    private Build triggeredByBuild;
    /***
     * The URI of the build.
     */
    @JsonProperty("url")
    private String url;
    /***
     * The REST URL of the build.
     */
    @JsonProperty("uri")
    private String uri;
    /***
     * Represents the result of validating a build request.
     */
    @JsonProperty("validationResults")
    private List<BuildRequestValidationResult> validationResults;

    @Override
    public String toString() {
        return "Build{" +
                "_links=" + _links +
                ", agentSpecification=" + agentSpecification +
                ", buildNumber='" + buildNumber + '\'' +
                ", buildNumberRevision=" + buildNumberRevision +
                ", controller=" + controller +
                ", definition=" + definition +
                ", deleted=" + deleted +
                ", deletedBy=" + deletedBy +
                ", deletedDate='" + deletedDate + '\'' +
                ", deletedReason='" + deletedReason + '\'' +
                ", demands=" + demands +
                ", finishTime='" + finishTime + '\'' +
                ", id=" + id +
                ", keepForever=" + keepForever +
                ", lastChangedBy=" + lastChangedBy +
                ", lastChangedDate='" + lastChangedDate + '\'' +
                ", logs=" + logs +
                ", orchestrationPlan=" + orchestrationPlan +
                ", parameters='" + parameters + '\'' +
                ", plans=" + plans +
                ", priority='" + priority + '\'' +
                ", project=" + project +
                ", quality='" + quality + '\'' +
                ", queue=" + queue +
                ", queueOptions='" + queueOptions + '\'' +
                ", queuePosition=" + queuePosition +
                ", queueTime='" + queueTime + '\'' +
                ", reason='" + reason + '\'' +
                ", repository=" + repository +
                ", requestedBy=" + requestedBy +
                ", requestedFor=" + requestedFor +
                ", result='" + result + '\'' +
                ", retainedByRelease=" + retainedByRelease +
                ", sourceBranch='" + sourceBranch + '\'' +
                ", sourceVersion='" + sourceVersion + '\'' +
                ", startTime='" + startTime + '\'' +
                ", status='" + status + '\'' +
                ", tags=" + Arrays.toString(tags) +
                ", triggerInfo=" + triggerInfo +
                ", triggeredByBuild='" + triggeredByBuild + '\'' +
                ", url='" + url + '\'' +
                ", uri='" + uri + '\'' +
                ", validationResults=" + validationResults +
                '}';
    }

    public BuildReferenceLinks get_links() {
        return _links;
    }

    public void set_links(BuildReferenceLinks _links) {
        this._links = _links;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public List<OrchestrationPlan> getPlans() {
        return plans;
    }

    public void setPlans(List<OrchestrationPlan> plans) {
        this.plans = plans;
    }

    public TriggerInfo getTriggerInfo() {
        return triggerInfo;
    }

    public void setTriggerInfo(TriggerInfo triggerInfo) {
        this.triggerInfo = triggerInfo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBuildNumber() {
        return buildNumber;
    }

    public void setBuildNumber(String buildNumber) {
        this.buildNumber = buildNumber;
    }

    public int getBuildNumberRevision() {
        return buildNumberRevision;
    }

    public void setBuildNumberRevision(int buildNumberRevision) {
        this.buildNumberRevision = buildNumberRevision;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getQueueTime() {
        return queueTime;
    }

    public void setQueueTime(String queueTime) {
        this.queueTime = queueTime;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(String finishTime) {
        this.finishTime = finishTime;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public DefinitionReference getDefinition() {
        return definition;
    }

    public void setDefinition(DefinitionReference definition) {
        this.definition = definition;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
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

    public BuildQueue getQueue() {
        return queue;
    }

    public void setQueue(BuildQueue queue) {
        this.queue = queue;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public RequestedFor getRequestedFor() {
        return requestedFor;
    }

    public void setRequestedFor(RequestedFor requestedFor) {
        this.requestedFor = requestedFor;
    }

    public String getLastChangedDate() {
        return lastChangedDate;
    }

    public void setLastChangedDate(String lastChangedDate) {
        this.lastChangedDate = lastChangedDate;
    }

    public OrchestrationPlan getOrchestrationPlan() {
        return orchestrationPlan;
    }

    public void setOrchestrationPlan(OrchestrationPlan orchestrationPlan) {
        this.orchestrationPlan = orchestrationPlan;
    }

    public Logs getLogs() {
        return logs;
    }

    public void setLogs(Logs logs) {
        this.logs = logs;
    }

    public Repository getRepository() {
        return repository;
    }

    public void setRepository(Repository repository) {
        this.repository = repository;
    }

    public boolean isKeepForever() {
        return keepForever;
    }

    public void setKeepForever(boolean keepForever) {
        this.keepForever = keepForever;
    }

    public boolean isRetainedByRelease() {
        return retainedByRelease;
    }

    public void setRetainedByRelease(boolean retainedByRelease) {
        this.retainedByRelease = retainedByRelease;
    }

    public Build getTriggeredByBuild() {
        return triggeredByBuild;
    }

    public void setTriggeredByBuild(Build triggeredByBuild) {
        this.triggeredByBuild = triggeredByBuild;
    }

    public AgentSpecification getAgentSpecification() {
        return agentSpecification;
    }

    public void setAgentSpecification(AgentSpecification agentSpecification) {
        this.agentSpecification = agentSpecification;
    }

    public BuildController getController() {
        return controller;
    }

    public void setController(BuildController controller) {
        this.controller = controller;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
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

    public Author getLastChangedBy() {
        return lastChangedBy;
    }

    public void setLastChangedBy(Author lastChangedBy) {
        this.lastChangedBy = lastChangedBy;
    }

    public String getParameters() {
        return parameters;
    }

    public void setParameters(String parameters) {
        this.parameters = parameters;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public String getQueueOptions() {
        return queueOptions;
    }

    public void setQueueOptions(String queueOptions) {
        this.queueOptions = queueOptions;
    }

    public int getQueuePosition() {
        return queuePosition;
    }

    public void setQueuePosition(int queuePosition) {
        this.queuePosition = queuePosition;
    }

    public Author getRequestedBy() {
        return requestedBy;
    }

    public void setRequestedBy(Author requestedBy) {
        this.requestedBy = requestedBy;
    }

    public List<BuildRequestValidationResult> getValidationResults() {
        return validationResults;
    }

    public void setValidationResults(List<BuildRequestValidationResult> validationResults) {
        this.validationResults = validationResults;
    }
}