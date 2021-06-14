package org.azd.build.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import org.azd.common.definitions.Author;
import org.azd.common.definitions.ReferenceLinks;
import org.azd.core.types.Project;

import java.util.Arrays;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BuildDefinition {
    @JsonProperty("options")
    private List<Options> options;
    @JsonProperty("triggers")
    private List<Triggers> triggers;
    @JsonProperty("properties")
    private JsonNode properties;
    @JsonProperty("tags")
    private String[] tags;
    @JsonProperty("_links")
    private ReferenceLinks _links;
    @JsonProperty("jobAuthorizationScope")
    private String jobAuthorizationScope;
    @JsonProperty("jobTimeoutInMinutes")
    private int jobTimeoutInMinutes;
    @JsonProperty("jobCancelTimeoutInMinutes")
    private int jobCancelTimeoutInMinutes;
    @JsonProperty("badgeEnabled")
    private boolean badgeEnabled;
    @JsonProperty("process")
    private Process process;
    @JsonProperty("repository")
    private BuildRepository repository;
    @JsonProperty("quality")
    private String quality;
    @JsonProperty("authoredBy")
    private Author authoredBy;
    @JsonProperty("drafts")
    private String[] drafts;
    @JsonProperty("queue")
    private Queue queue;
    @JsonProperty("id")
    private int id;
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
    @JsonProperty("createdDate")
    private String createdDate;
    @JsonProperty("project")
    private Project project;

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

    public ReferenceLinks get_links() {
        return _links;
    }

    public void set_links(ReferenceLinks _links) {
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

    public String[] getDrafts() {
        return drafts;
    }

    public void setDrafts(String[] drafts) {
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
                "options=" + options +
                ", triggers=" + triggers +
                ", properties=" + properties +
                ", tags=" + Arrays.toString(tags) +
                ", _links=" + _links +
                ", jobAuthorizationScope='" + jobAuthorizationScope + '\'' +
                ", jobTimeoutInMinutes=" + jobTimeoutInMinutes +
                ", jobCancelTimeoutInMinutes=" + jobCancelTimeoutInMinutes +
                ", badgeEnabled=" + badgeEnabled +
                ", process=" + process +
                ", repository=" + repository +
                ", quality='" + quality + '\'' +
                ", authoredBy=" + authoredBy +
                ", drafts=" + Arrays.toString(drafts) +
                ", queue=" + queue +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", uri='" + uri + '\'' +
                ", path='" + path + '\'' +
                ", type='" + type + '\'' +
                ", queueStatus='" + queueStatus + '\'' +
                ", revision=" + revision +
                ", createdDate='" + createdDate + '\'' +
                ", project=" + project +
                '}';
    }
}
