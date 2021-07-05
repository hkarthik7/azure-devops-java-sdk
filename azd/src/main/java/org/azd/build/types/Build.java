package org.azd.build.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.Author;
import org.azd.core.types.Project;

import java.util.Arrays;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Build {
    @JsonProperty("_links")
    private BuildReferenceLinks _links;
    @JsonProperty("agentSpecification")
    private AgentSpecification agentSpecification;
    @JsonProperty("buildNumber")
    private String buildNumber;
    @JsonProperty("buildNumberRevision")
    private int buildNumberRevision;
    @JsonProperty("controller")
    private BuildController controller;
    @JsonProperty("definition")
    private DefinitionReference definition;
    @JsonProperty("deleted")
    private boolean deleted;
    @JsonProperty("deletedBy")
    private Author deletedBy;
    @JsonProperty("deletedDate")
    private String deletedDate;
    @JsonProperty("deletedReason")
    private String deletedReason;
    @JsonProperty("demands")
    private List<Demand> demands;
    @JsonProperty("finishTime")
    private String finishTime;
    @JsonProperty("id")
    private int id;
    @JsonProperty("keepForever")
    private boolean keepForever;
    @JsonProperty("lastChangedBy")
    private Author lastChangedBy;
    @JsonProperty("lastChangedDate")
    private String lastChangedDate;
    @JsonProperty("logs")
    private Logs logs;
    @JsonProperty("orchestrationPlan")
    private OrchestrationPlan orchestrationPlan;
    @JsonProperty("parameters")
    private String parameters;
    @JsonProperty("plans")
    private List<OrchestrationPlan> plans;
    @JsonProperty("priority")
    private String priority;
    @JsonProperty("project")
    private Project project;
    @JsonProperty("quality")
    private String quality;
    @JsonProperty("queue")
    private BuildQueue queue;
    @JsonProperty("queueOptions")
    private String queueOptions;
    @JsonProperty("queuePosition")
    private int queuePosition;
    @JsonProperty("queueTime")
    private String queueTime;
    @JsonProperty("reason")
    private String reason;
    @JsonProperty("repository")
    private Repository repository;
    @JsonProperty("requestedBy")
    private Author requestedBy;
    @JsonProperty("requestedFor")
    private RequestedFor requestedFor;
    @JsonProperty("result")
    private String result;
    @JsonProperty("retainedByRelease")
    private boolean retainedByRelease;
    @JsonProperty("sourceBranch")
    private String sourceBranch;
    @JsonProperty("sourceVersion")
    private String sourceVersion;
    @JsonProperty("startTime")
    private String startTime;
    @JsonProperty("status")
    private String status;
    @JsonProperty("tags")
    private String[] tags;
    @JsonProperty("triggerInfo")
    private TriggerInfo triggerInfo;
    @JsonProperty("triggeredByBuild")
    private Build triggeredByBuild;
    @JsonProperty("url")
    private String url;
    @JsonProperty("uri")
    private String uri;
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