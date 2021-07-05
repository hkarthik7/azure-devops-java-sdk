package org.azd.build.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import org.azd.common.types.Author;
import org.azd.core.types.Project;

import java.util.Arrays;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BuildDefinition {
    @JsonProperty("_links")
    private BuildDefinitionReferenceLinks _links;
    @JsonProperty("authoredBy")
    private Author authoredBy;
    @JsonProperty("badgeEnabled")
    private boolean badgeEnabled;
    @JsonProperty("buildNumberFormat")
    private String buildNumberFormat;
    @JsonProperty("comment")
    private String comment;
    @JsonProperty("createdDate")
    private String createdDate;
    @JsonProperty("demands")
    private List<Demand> demands;
    @JsonProperty("description")
    private String description;
    @JsonProperty("draftOf")
    private DefinitionReference draftOf;
    @JsonProperty("drafts")
    private List<DefinitionReference> drafts;
    @JsonProperty("dropLocation")
    private String dropLocation;
    @JsonProperty("id")
    private int id;
    @JsonProperty("jobAuthorizationScope")
    private String jobAuthorizationScope;
    @JsonProperty("jobCancelTimeoutInMinutes")
    private int jobCancelTimeoutInMinutes;
    @JsonProperty("jobTimeoutInMinutes")
    private int jobTimeoutInMinutes;
    @JsonProperty("latestBuild")
    private Build latestBuild;
    @JsonProperty("latestCompletedBuild")
    private Build latestCompletedBuild;
    @JsonProperty("metrics")
    private List<BuildMetric> metrics;
    @JsonProperty("name")
    private String name;
    @JsonProperty("options")
    private List<Options> options;
    @JsonProperty("path")
    private String path;
    @JsonProperty("process")
    private Process process;
    @JsonProperty("project")
    private Project project;
    @JsonProperty("properties")
    private JsonNode properties;
    @JsonProperty("quality")
    private String quality;
    @JsonProperty("queue")
    private Queue queue;
    @JsonProperty("queueStatus")
    private String queueStatus;
    @JsonProperty("repository")
    private BuildRepository repository;
    @JsonProperty("retentionRules")
    private List<RetentionPolicy> retentionRules;
    @JsonProperty("revision")
    private int revision;
    @JsonProperty("tags")
    private String[] tags;
    @JsonProperty("triggers")
    private List<Triggers> triggers;
    @JsonProperty("type")
    private String type;
    @JsonProperty("url")
    private String url;
    @JsonProperty("uri")
    private String uri;
    @JsonProperty("variableGroups")
    private List<VariableGroup> variableGroups;
    @JsonProperty("variables")
    private JsonNode variables;

    public String getBuildNumberFormat() {
        return buildNumberFormat;
    }

    public void setBuildNumberFormat(String buildNumberFormat) {
        this.buildNumberFormat = buildNumberFormat;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public List<Demand> getDemands() {
        return demands;
    }

    public void setDemands(List<Demand> demands) {
        this.demands = demands;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public DefinitionReference getDraftOf() {
        return draftOf;
    }

    public void setDraftOf(DefinitionReference draftOf) {
        this.draftOf = draftOf;
    }

    public String getDropLocation() {
        return dropLocation;
    }

    public void setDropLocation(String dropLocation) {
        this.dropLocation = dropLocation;
    }

    public Build getLatestBuild() {
        return latestBuild;
    }

    public void setLatestBuild(Build latestBuild) {
        this.latestBuild = latestBuild;
    }

    public Build getLatestCompletedBuild() {
        return latestCompletedBuild;
    }

    public void setLatestCompletedBuild(Build latestCompletedBuild) {
        this.latestCompletedBuild = latestCompletedBuild;
    }

    public List<BuildMetric> getMetrics() {
        return metrics;
    }

    public void setMetrics(List<BuildMetric> metrics) {
        this.metrics = metrics;
    }

    public List<RetentionPolicy> getRetentionRules() {
        return retentionRules;
    }

    public void setRetentionRules(List<RetentionPolicy> retentionRules) {
        this.retentionRules = retentionRules;
    }

    public List<VariableGroup> getVariableGroups() {
        return variableGroups;
    }

    public void setVariableGroups(List<VariableGroup> variableGroups) {
        this.variableGroups = variableGroups;
    }

    public JsonNode getVariables() {
        return variables;
    }

    public void setVariables(JsonNode variables) {
        this.variables = variables;
    }

    public JsonNode getProperties() {
        return properties;
    }

    public void setProperties(JsonNode properties) {
        this.properties = properties;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public BuildDefinitionReferenceLinks get_links() {
        return _links;
    }

    public void set_links(BuildDefinitionReferenceLinks _links) {
        this._links = _links;
    }

    public BuildRepository getRepository() {
        return repository;
    }

    public void setRepository(BuildRepository repository) {
        this.repository = repository;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public Author getAuthoredBy() {
        return authoredBy;
    }

    public void setAuthoredBy(Author authoredBy) {
        this.authoredBy = authoredBy;
    }

    public List<DefinitionReference> getDrafts() {
        return drafts;
    }

    public void setDrafts(List<DefinitionReference> drafts) {
        this.drafts = drafts;
    }

    public Queue getQueue() {
        return queue;
    }

    public void setQueue(Queue queue) {
        this.queue = queue;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public List<Options> getOptions() {
        return options;
    }

    public void setOptions(List<Options> options) {
        this.options = options;
    }

    public List<Triggers> getTriggers() {
        return triggers;
    }

    public void setTriggers(List<Triggers> triggers) {
        this.triggers = triggers;
    }

    public String getJobAuthorizationScope() {
        return jobAuthorizationScope;
    }

    public void setJobAuthorizationScope(String jobAuthorizationScope) {
        this.jobAuthorizationScope = jobAuthorizationScope;
    }

    public int getJobTimeoutInMinutes() {
        return jobTimeoutInMinutes;
    }

    public void setJobTimeoutInMinutes(int jobTimeoutInMinutes) {
        this.jobTimeoutInMinutes = jobTimeoutInMinutes;
    }

    public int getJobCancelTimeoutInMinutes() {
        return jobCancelTimeoutInMinutes;
    }

    public void setJobCancelTimeoutInMinutes(int jobCancelTimeoutInMinutes) {
        this.jobCancelTimeoutInMinutes = jobCancelTimeoutInMinutes;
    }

    public boolean isBadgeEnabled() {
        return badgeEnabled;
    }

    public void setBadgeEnabled(boolean badgeEnabled) {
        this.badgeEnabled = badgeEnabled;
    }

    public Process getProcess() {
        return process;
    }

    public void setProcess(Process process) {
        this.process = process;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "BuildDefinition{" +
                "_links=" + _links +
                ", authoredBy=" + authoredBy +
                ", badgeEnabled=" + badgeEnabled +
                ", buildNumberFormat='" + buildNumberFormat + '\'' +
                ", comment='" + comment + '\'' +
                ", createdDate='" + createdDate + '\'' +
                ", demands=" + demands +
                ", description='" + description + '\'' +
                ", draftOf=" + draftOf +
                ", drafts=" + drafts +
                ", dropLocation='" + dropLocation + '\'' +
                ", id=" + id +
                ", jobAuthorizationScope='" + jobAuthorizationScope + '\'' +
                ", jobCancelTimeoutInMinutes=" + jobCancelTimeoutInMinutes +
                ", jobTimeoutInMinutes=" + jobTimeoutInMinutes +
                ", latestBuild=" + latestBuild +
                ", latestCompletedBuild=" + latestCompletedBuild +
                ", metrics=" + metrics +
                ", name='" + name + '\'' +
                ", options=" + options +
                ", path='" + path + '\'' +
                ", process=" + process +
                ", project=" + project +
                ", properties=" + properties +
                ", quality='" + quality + '\'' +
                ", queue=" + queue +
                ", queueStatus='" + queueStatus + '\'' +
                ", repository=" + repository +
                ", retentionRules=" + retentionRules +
                ", revision=" + revision +
                ", tags=" + Arrays.toString(tags) +
                ", triggers=" + triggers +
                ", type='" + type + '\'' +
                ", url='" + url + '\'' +
                ", uri='" + uri + '\'' +
                ", variableGroups=" + variableGroups +
                ", variables=" + variables +
                '}';
    }
}
