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
import org.azd.enums.BuildAuthorizationScope;
import org.azd.enums.DefinitionQuality;
import org.azd.enums.DefinitionQueueStatus;
import org.azd.enums.DefinitionType;

import java.util.List;
import java.util.Map;

/**
 * Represents a reference to a build log. 
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class BuildDefinition extends BaseAbstractMethod {
    /**
     * The class to represent a collection of REST reference links.
     **/
    @JsonProperty("_links")
    private Object _links;
    /**
     * The author of the definition.
     **/
    @JsonProperty("authoredBy")
    private Author authoredBy;
    /**
     * Indicates whether badges are enabled for this definition.
     **/
    @JsonProperty("badgeEnabled")
    private Boolean badgeEnabled;
    /**
     * The build number format.
     **/
    @JsonProperty("buildNumberFormat")
    private String buildNumberFormat;
    /**
     * A save-time comment for the definition.
     **/
    @JsonProperty("comment")
    private String comment;
    /**
     * The date this version of the definition was created.
     **/
    @JsonProperty("createdDate")
    private String createdDate;
    /**
     * Represents a demand used by a definition or build.
     **/
    @JsonProperty("demands")
    private List<Demand> demands;
    /**
     * The description.
     **/
    @JsonProperty("description")
    private String description;
    /**
     * A reference to the definition that this definition is a draft of, if this is a draft definition.
     **/
    @JsonProperty("draftOf")
    private DefinitionReference draftOf;
    /**
     * The list of drafts associated with this definition, if this is not a draft definition.
     **/
    @JsonProperty("drafts")
    private List<DefinitionReference> drafts;
    /**
     * The drop location for the definition.
     **/
    @JsonProperty("dropLocation")
    private String dropLocation;
    /**
     * The ID of the referenced definition.
     **/
    @JsonProperty("id")
    private Integer id;
    /**
     * The job authorization scope for builds queued against this definition.
     **/
    @JsonProperty("jobAuthorizationScope")
    private BuildAuthorizationScope jobAuthorizationScope;
    /**
     * The job cancel timeout (in minutes) for builds cancelled by user for this definition.
     **/
    @JsonProperty("jobCancelTimeoutInMinutes")
    private Integer jobCancelTimeoutInMinutes;
    /**
     * The job execution timeout (in minutes) for builds queued against this definition.
     **/
    @JsonProperty("jobTimeoutInMinutes")
    private Integer jobTimeoutInMinutes;
    /**
     * Data representation of a build.
     **/
    @JsonProperty("latestBuild")
    private Build latestBuild;
    /**
     * Data representation of a build.
     **/
    @JsonProperty("latestCompletedBuild")
    private Build latestCompletedBuild;
    /**
     * Represents metadata about builds in the system.
     **/
    @JsonProperty("metrics")
    private List<BuildMetric> metrics;
    /**
     * The name of the referenced definition.
     **/
    @JsonProperty("name")
    private String name;
    /**
     * Represents the application of an optional behavior to a build definition.
     **/
    @JsonProperty("options")
    private List<BuildOption> options;
    /**
     * The folder path of the definition.
     **/
    @JsonProperty("path")
    private String path;
    /**
     * The build process.
     **/
    @JsonProperty("process")
    private BuildProcess process;
    /**
     * The process parameters for this definition.
     **/
    @JsonProperty("processParameters")
    private ProcessParameters processParameters;
    /**
     * A reference to the project.
     **/
    @JsonProperty("project")
    private TeamProjectReference project;
    /**
     * The class represents a property bag as a collection of key-value pairs. Values of all primitive types (any type with a TypeCode != TypeCode.Object) except for DBNull are accepted. Values of type Byte[], Int32, Double, DateType and String preserve their type, other primitives are retuned as a String. Byte[] expected as base64 encoded string.
     **/
    @JsonProperty("properties")
    private PropertiesCollection properties;
    /**
     * The quality of the definition document (draft, etc.)
     **/
    @JsonProperty("quality")
    private DefinitionQuality quality;
    /**
     * The default queue for builds run against this definition.
     **/
    @JsonProperty("queue")
    private AgentPoolQueue queue;
    /**
     * A value that indicates whether builds can be queued against this definition.
     **/
    @JsonProperty("queueStatus")
    private DefinitionQueueStatus queueStatus;
    /**
     * The repository.
     **/
    @JsonProperty("repository")
    private BuildRepository repository;
    /**
     * Represents a retention policy for a build definition.
     **/
    @JsonProperty("retentionRules")
    private List<RetentionPolicy> retentionRules;
    /**
     * The definition revision number.
     **/
    @JsonProperty("revision")
    private Integer revision;

    @JsonProperty("tags")
    private String[] tags;
    /**
     * Represents a trigger for a buld definition.
     **/
    @JsonProperty("triggers")
    private Object triggers;
    /**
     * The type of the definition.
     **/
    @JsonProperty("type")
    private DefinitionType type;
    /**
     * The definition's URI.
     **/
    @JsonProperty("uri")
    private String uri;
    /**
     * The REST URL of the definition.
     **/
    @JsonProperty("url")
    private String url;
    /**
     * Represents a variable group.
     **/
    @JsonProperty("variableGroups")
    private List<VariableGroup> variableGroups;

    @JsonProperty("variables")
    private Map<String, BuildDefinitionVariable> variables;

    public Object get_links() {
        return _links;
    }

    public void set_links(Object _links) {
        this._links = _links;
    }

    public Author getAuthoredBy() {
        return authoredBy;
    }

    public void setAuthoredBy(Author authoredBy) {
        this.authoredBy = authoredBy;
    }

    public Boolean getBadgeEnabled() {
        return badgeEnabled;
    }

    public void setBadgeEnabled(Boolean badgeEnabled) {
        this.badgeEnabled = badgeEnabled;
    }

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

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
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

    public List<DefinitionReference> getDrafts() {
        return drafts;
    }

    public void setDrafts(List<DefinitionReference> drafts) {
        this.drafts = drafts;
    }

    public String getDropLocation() {
        return dropLocation;
    }

    public void setDropLocation(String dropLocation) {
        this.dropLocation = dropLocation;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BuildAuthorizationScope getJobAuthorizationScope() {
        return jobAuthorizationScope;
    }

    public void setJobAuthorizationScope(BuildAuthorizationScope jobAuthorizationScope) {
        this.jobAuthorizationScope = jobAuthorizationScope;
    }

    public Integer getJobCancelTimeoutInMinutes() {
        return jobCancelTimeoutInMinutes;
    }

    public void setJobCancelTimeoutInMinutes(Integer jobCancelTimeoutInMinutes) {
        this.jobCancelTimeoutInMinutes = jobCancelTimeoutInMinutes;
    }

    public Integer getJobTimeoutInMinutes() {
        return jobTimeoutInMinutes;
    }

    public void setJobTimeoutInMinutes(Integer jobTimeoutInMinutes) {
        this.jobTimeoutInMinutes = jobTimeoutInMinutes;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<BuildOption> getOptions() {
        return options;
    }

    public void setOptions(List<BuildOption> options) {
        this.options = options;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public BuildProcess getProcess() {
        return process;
    }

    public void setProcess(BuildProcess process) {
        this.process = process;
    }

    public ProcessParameters getProcessParameters() {
        return processParameters;
    }

    public void setProcessParameters(ProcessParameters processParameters) {
        this.processParameters = processParameters;
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

    public DefinitionQuality getQuality() {
        return quality;
    }

    public void setQuality(DefinitionQuality quality) {
        this.quality = quality;
    }

    public AgentPoolQueue getQueue() {
        return queue;
    }

    public void setQueue(AgentPoolQueue queue) {
        this.queue = queue;
    }

    public DefinitionQueueStatus getQueueStatus() {
        return queueStatus;
    }

    public void setQueueStatus(DefinitionQueueStatus queueStatus) {
        this.queueStatus = queueStatus;
    }

    public BuildRepository getRepository() {
        return repository;
    }

    public void setRepository(BuildRepository repository) {
        this.repository = repository;
    }

    public List<RetentionPolicy> getRetentionRules() {
        return retentionRules;
    }

    public void setRetentionRules(List<RetentionPolicy> retentionRules) {
        this.retentionRules = retentionRules;
    }

    public Integer getRevision() {
        return revision;
    }

    public void setRevision(Integer revision) {
        this.revision = revision;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public Object getTriggers() {
        return triggers;
    }

    public void setTriggers(Object triggers) {
        this.triggers = triggers;
    }

    public DefinitionType getType() {
        return type;
    }

    public void setType(DefinitionType type) {
        this.type = type;
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

    public List<VariableGroup> getVariableGroups() {
        return variableGroups;
    }

    public void setVariableGroups(List<VariableGroup> variableGroups) {
        this.variableGroups = variableGroups;
    }

    public Map<String, BuildDefinitionVariable> getVariables() {
        return variables;
    }

    public void setVariables(Map<String, BuildDefinitionVariable> variables) {
        this.variables = variables;
    }

}
