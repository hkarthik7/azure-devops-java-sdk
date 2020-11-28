package org.azd.build.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BuildT {
    @JsonProperty("_links")
    private Links _links;
    @JsonProperty("tags")
    private List<String> tags;
    @JsonProperty("validationResults")
    private List<String> validationResults;
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
    private BQueue queue;
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
                ", validationResults=" + validationResults +
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

    public Links get_links() {
        return _links;
    }

    public void set_links(Links _links) {
        this._links = _links;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public List<String> getValidationResults() {
        return validationResults;
    }

    public void setValidationResults(List<String> validationResults) {
        this.validationResults = validationResults;
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

    public BQueue getQueue() {
        return queue;
    }

    public void setQueue(BQueue queue) {
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


    private static class Links {
        @JsonProperty("self")
        private Href self;
        @JsonProperty("web")
        private Href web;
        @JsonProperty("sourceVersionDisplayUri")
        private Href sourceVersionDisplayUri;
        @JsonProperty("timeline")
        private Href timeline;

        @JsonProperty("badge")
        private Href badge;

        public Href getSelf() {
            return self;
        }

        public void setSelf(Href self) {
            this.self = self;
        }

        public Href getWeb() {
            return web;
        }

        public void setWeb(Href web) {
            this.web = web;
        }

        public Href getSourceVersionDisplayUri() {
            return sourceVersionDisplayUri;
        }

        public void setSourceVersionDisplayUri(Href sourceVersionDisplayUri) {
            this.sourceVersionDisplayUri = sourceVersionDisplayUri;
        }

        public Href getTimeline() {
            return timeline;
        }

        public void setTimeline(Href timeline) {
            this.timeline = timeline;
        }

        public Href getBadge() {
            return badge;
        }

        public void setBadge(Href badge) {
            this.badge = badge;
        }

        @Override
        public String toString() {
            return "Links{" +
                    "self=" + self +
                    ", web=" + web +
                    ", sourceVersionDisplayUri=" + sourceVersionDisplayUri +
                    ", timeline=" + timeline +
                    ", badge=" + badge +
                    '}';
        }
    }

    private static class Href {
        @JsonProperty("href")
        private String href;

        public String getHref() {
            return href;
        }

        public void setHref(String href) {
            this.href = href;
        }

        @Override
        public String toString() {
            return "Href{" +
                    "href='" + href + '\'' +
                    '}';
        }
    }

    private static class Plans {
        @JsonProperty("planId")
        private String planId;

        public String getPlanId() {
            return planId;
        }

        public void setPlanId(String planId) {
            this.planId = planId;
        }

        @Override
        public String toString() {
            return "Plans{" +
                    "planId='" + planId + '\'' +
                    '}';
        }
    }

    private static class TriggerInfo {
        @JsonProperty("ci.sourceSha")
        private String sourceSha;
        @JsonProperty("ci.message")
        private String message;
        @JsonProperty("ci.triggerRepository")
        private String triggerRepository;

        public String getSourceSha() {
            return sourceSha;
        }

        public void setSourceSha(String sourceSha) {
            this.sourceSha = sourceSha;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getTriggerRepository() {
            return triggerRepository;
        }

        public void setTriggerRepository(String triggerRepository) {
            this.triggerRepository = triggerRepository;
        }

        @Override
        public String toString() {
            return "TriggerInfo{" +
                    "sourceSha='" + sourceSha + '\'' +
                    ", message='" + message + '\'' +
                    ", triggerRepository='" + triggerRepository + '\'' +
                    '}';
        }
    }

    private static class Definition {
        @JsonProperty("drafts")
        private List<String> drafts;
        @JsonProperty("id")
        private String id;
        @JsonProperty("name")
        private String name;
        @JsonProperty("url")
        private String url;
        @JsonProperty("uri")
        private String uri;
        @JsonProperty("path")
        private String path;
        @JsonProperty("type")
        private String type;
        @JsonProperty("queueStatus")
        private String queueStatus;
        @JsonProperty("revision")
        private int revision;
        @JsonProperty("project")
        private Project project;

        public List<String> getDrafts() {
            return drafts;
        }

        public void setDrafts(List<String> drafts) {
            this.drafts = drafts;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getUri() {
            return uri;
        }

        public void setUri(String uri) {
            this.uri = uri;
        }

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getQueueStatus() {
            return queueStatus;
        }

        public void setQueueStatus(String queueStatus) {
            this.queueStatus = queueStatus;
        }

        public int getRevision() {
            return revision;
        }

        public void setRevision(int revision) {
            this.revision = revision;
        }

        public Project getProject() {
            return project;
        }

        public void setProject(Project project) {
            this.project = project;
        }

        @Override
        public String toString() {
            return "Definition{" +
                    "drafts='" + drafts + '\'' +
                    ", id='" + id + '\'' +
                    ", name='" + name + '\'' +
                    ", url='" + url + '\'' +
                    ", uri='" + uri + '\'' +
                    ", path='" + path + '\'' +
                    ", type='" + type + '\'' +
                    ", queueStatus='" + queueStatus + '\'' +
                    ", revision=" + revision +
                    ", project=" + project +
                    '}';
        }
    }

    private static class Project {
        @JsonProperty("id")
        private String id;
        @JsonProperty("name")
        private String name;
        @JsonProperty("description")
        private String description;
        @JsonProperty("url")
        private String url;
        @JsonProperty("state")
        private String state;
        @JsonProperty("revision")
        private int revision;
        @JsonProperty("visibility")
        private String visibility;
        @JsonProperty("lastUpdateTime")
        private String lastUpdateTime;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public int getRevision() {
            return revision;
        }

        public void setRevision(int revision) {
            this.revision = revision;
        }

        public String getVisibility() {
            return visibility;
        }

        public void setVisibility(String visibility) {
            this.visibility = visibility;
        }

        public String getLastUpdateTime() {
            return lastUpdateTime;
        }

        public void setLastUpdateTime(String lastUpdateTime) {
            this.lastUpdateTime = lastUpdateTime;
        }

        @Override
        public String toString() {
            return "Project{" +
                    "id='" + id + '\'' +
                    ", name='" + name + '\'' +
                    ", description='" + description + '\'' +
                    ", url='" + url + '\'' +
                    ", state='" + state + '\'' +
                    ", revision=" + revision +
                    ", visibility='" + visibility + '\'' +
                    ", lastUpdateTime='" + lastUpdateTime + '\'' +
                    '}';
        }

    }

    private static class BQueue {
        @JsonProperty("id")
        private String id;
        @JsonProperty("name")
        private String name;
        @JsonProperty("pool")
        private Pool pool;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Pool getPool() {
            return pool;
        }

        public void setPool(Pool pool) {
            this.pool = pool;
        }

        @Override
        public String toString() {
            return "BQueue{" +
                    "id='" + id + '\'' +
                    ", name='" + name + '\'' +
                    ", pool=" + pool +
                    '}';
        }
    }


    private static class Pool {
        @JsonProperty("id")
        private String id;
        @JsonProperty("name")
        private String name;
        @JsonProperty("isHosted")
        private boolean isHosted;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public boolean isHosted() {
            return isHosted;
        }

        public void setHosted(boolean hosted) {
            isHosted = hosted;
        }

        @Override
        public String toString() {
            return "Pool{" +
                    "id='" + id + '\'' +
                    ", name='" + name + '\'' +
                    ", isHosted=" + isHosted +
                    '}';
        }
    }


    @JsonIgnoreProperties(ignoreUnknown = true)
    private static class RequestedFor {
        @JsonProperty("displayName")
        private String displayName;
        @JsonProperty("url")
        private String url;
        @JsonProperty("id")
        private String id;
        @JsonProperty("uniqueName")
        private String uniqueName;
        @JsonProperty("descriptor")
        private String descriptor;

        public String getDisplayName() {
            return displayName;
        }

        public void setDisplayName(String displayName) {
            this.displayName = displayName;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUniqueName() {
            return uniqueName;
        }

        public void setUniqueName(String uniqueName) {
            this.uniqueName = uniqueName;
        }

        public String getDescriptor() {
            return descriptor;
        }

        public void setDescriptor(String descriptor) {
            this.descriptor = descriptor;
        }

        @Override
        public String toString() {
            return "RequestedFor{" +
                    "displayName='" + displayName + '\'' +
                    ", url='" + url + '\'' +
                    ", id='" + id + '\'' +
                    ", uniqueName='" + uniqueName + '\'' +
                    ", descriptor='" + descriptor + '\'' +
                    '}';
        }
    }

    private static class OrchestrationPlan {
        @JsonProperty("planId")
        private String planId;

        public String getPlanId() {
            return planId;
        }

        public void setPlanId(String planId) {
            this.planId = planId;
        }

        @Override
        public String toString() {
            return "OrchestrationPlan{" +
                    "planId='" + planId + '\'' +
                    '}';
        }
    }

    private static class Logs {
        @JsonProperty("id")
        private String id;
        @JsonProperty("type")
        private String type;
        @JsonProperty("url")
        private String url;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        @Override
        public String toString() {
            return "Logs{" +
                    "id='" + id + '\'' +
                    ", type='" + type + '\'' +
                    ", url='" + url + '\'' +
                    '}';
        }
    }

    private static class Repository {
        @JsonProperty("id")
        private String id;
        @JsonProperty("type")
        private String type;
        @JsonProperty("name")
        private String name;
        @JsonProperty("url")
        private String url;
        @JsonProperty("clean")
        private String clean;
        @JsonProperty("checkoutSubmodules")
        private boolean checkoutSubmodules;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getClean() {
            return clean;
        }

        public void setClean(String clean) {
            this.clean = clean;
        }

        public boolean isCheckoutSubmodules() {
            return checkoutSubmodules;
        }

        public void setCheckoutSubmodules(boolean checkoutSubmodules) {
            this.checkoutSubmodules = checkoutSubmodules;
        }

        @Override
        public String toString() {
            return "Repository{" +
                    "id='" + id + '\'' +
                    ", type='" + type + '\'' +
                    ", name='" + name + '\'' +
                    ", url='" + url + '\'' +
                    ", clean='" + clean + '\'' +
                    ", checkoutSubmodules=" + checkoutSubmodules +
                    '}';
        }
    }
}