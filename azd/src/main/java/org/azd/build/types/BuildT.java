package org.azd.build.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.definitions.ReferenceLinks;
import org.azd.core.types.Project;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BuildT {
    @JsonProperty("_links")
    private ReferenceLinks _links;
    @JsonProperty("tags")
    private List<String> tags;
    @JsonProperty("plans")
    private List<Plans> plans;
    @JsonProperty("triggerInfo")
    private TriggerInfo triggerInfo;
    @JsonProperty("id")
    private int id;
    @JsonProperty("buildNumber")
    private String buildNumber;
    @JsonProperty("buildNumberRevision")
    private int buildNumberRevision;
    @JsonProperty("status")
    private String status;
    @JsonProperty("result")
    private String result;
    @JsonProperty("queueTime")
    private String queueTime;
    @JsonProperty("startTime")
    private String startTime;
    @JsonProperty("finishTime")
    private String finishTime;
    @JsonProperty("url")
    private String url;
    @JsonProperty("definition")
    private Definition definition;
    @JsonProperty("project")
    private Project project;
    @JsonProperty("uri")
    private String uri;
    @JsonProperty("sourceBranch")
    private String sourceBranch;
    @JsonProperty("sourceVersion")
    private String sourceVersion;
    @JsonProperty("queue")
    private BuildQueue queue;
    @JsonProperty("priority")
    private String priority;
    @JsonProperty("reason")
    private String reason;
    @JsonProperty("requestedFor")
    private RequestedFor requestedFor;
    @JsonProperty("lastChangedDate")
    private String lastChangedDate;
    @JsonProperty("orchestrationPlan")
    private OrchestrationPlan orchestrationPlan;
    @JsonProperty("logs")
    private Logs logs;
    @JsonProperty("repository")
    private Repository repository;
    @JsonProperty("keepForever")
    private boolean keepForever;
    @JsonProperty("retainedByRelease")
    private boolean retainedByRelease;
    @JsonProperty("triggeredByBuild")
    private String triggeredByBuild;

    @Override
    public String toString() {
        return "BuildT{" +
                "_links=" + _links +
                ", tags=" + tags +
                ", plans=" + plans +
                ", triggerInfo=" + triggerInfo +
                ", id=" + id +
                ", buildNumber='" + buildNumber + '\'' +
                ", buildNumberRevision=" + buildNumberRevision +
                ", status='" + status + '\'' +
                ", result='" + result + '\'' +
                ", queueTime='" + queueTime + '\'' +
                ", startTime='" + startTime + '\'' +
                ", finishTime='" + finishTime + '\'' +
                ", url='" + url + '\'' +
                ", definition=" + definition +
                ", project=" + project +
                ", uri='" + uri + '\'' +
                ", sourceBranch='" + sourceBranch + '\'' +
                ", sourceVersion='" + sourceVersion + '\'' +
                ", queue=" + queue +
                ", priority='" + priority + '\'' +
                ", reason='" + reason + '\'' +
                ", requestedFor=" + requestedFor +
                ", lastChangedDate='" + lastChangedDate + '\'' +
                ", orchestrationPlan=" + orchestrationPlan +
                ", logs=" + logs +
                ", repository=" + repository +
                ", keepForever=" + keepForever +
                ", retainedByRelease=" + retainedByRelease +
                ", triggeredByBuild='" + triggeredByBuild + '\'' +
                '}';
    }

    public ReferenceLinks get_links() {
        return _links;
    }

    public void set_links(ReferenceLinks _links) {
        this._links = _links;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public List<Plans> getPlans() {
        return plans;
    }

    public void setPlans(List<Plans> plans) {
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

    public Definition getDefinition() {
        return definition;
    }

    public void setDefinition(Definition definition) {
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

    public String getTriggeredByBuild() {
        return triggeredByBuild;
    }

    public void setTriggeredByBuild(String triggeredByBuild) {
        this.triggeredByBuild = triggeredByBuild;
    }
}