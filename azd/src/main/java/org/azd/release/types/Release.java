package org.azd.release.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import org.azd.common.Author;

import java.util.Arrays;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Release {
    @JsonProperty("_links")
    private ReleaseReferenceLinks _links;
    @JsonProperty("artifacts")
    private List<ReleaseArtifacts> artifacts;
    @JsonProperty("comment")
    private String comment;
    @JsonProperty("createdBy")
    private Author createdBy;
    @JsonProperty("createdFor")
    private Author createdFor;
    @JsonProperty("createdOn")
    private String createdOn;
    @JsonProperty("definitionSnapshotRevision")
    private int definitionSnapshotRevision;
    @JsonProperty("description")
    private String description;
    @JsonProperty("environments")
    private List<ReleaseEnvironment> environments;
    @JsonProperty("id")
    private int id;
    @JsonProperty("keepForever")
    private boolean keepForever;
    @JsonProperty("logsContainerUrl")
    private String logsContainerUrl;
    @JsonProperty("modifiedBy")
    private Author modifiedBy;
    @JsonProperty("modifiedOn")
    private String modifiedOn;
    @JsonProperty("name")
    private String name;
    @JsonProperty("poolName")
    private String poolName;
    @JsonProperty("projectReference")
    private ProjectReference projectReference;
    @JsonProperty("reason")
    private String reason;
    @JsonProperty("releaseDefinition")
    private ReleaseShallowReference releaseDefinition;
    @JsonProperty("releaseDefinitionRevision")
    private int releaseDefinitionRevision;
    @JsonProperty("releaseNameFormat")
    private String releaseNameFormat;
    @JsonProperty("status")
    private String status;
    @JsonProperty("tags")
    private String[] tags;
    @JsonProperty("triggeringArtifactAlias")
    private String triggeringArtifactAlias;
    @JsonProperty("variableGroups")
    private JsonNode variableGroups;
    @JsonProperty("variables")
    private JsonNode variables;

    public ReleaseReferenceLinks get_links() {
        return _links;
    }

    public void set_links(ReleaseReferenceLinks _links) {
        this._links = _links;
    }

    public List<ReleaseArtifacts> getArtifacts() {
        return artifacts;
    }

    public void setArtifacts(List<ReleaseArtifacts> artifacts) {
        this.artifacts = artifacts;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Author getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Author createdBy) {
        this.createdBy = createdBy;
    }

    public Author getCreatedFor() {
        return createdFor;
    }

    public void setCreatedFor(Author createdFor) {
        this.createdFor = createdFor;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public int getDefinitionSnapshotRevision() {
        return definitionSnapshotRevision;
    }

    public void setDefinitionSnapshotRevision(int definitionSnapshotRevision) {
        this.definitionSnapshotRevision = definitionSnapshotRevision;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<ReleaseEnvironment> getEnvironments() {
        return environments;
    }

    public void setEnvironments(List<ReleaseEnvironment> environments) {
        this.environments = environments;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isKeepForever() {
        return keepForever;
    }

    public void setKeepForever(boolean keepForever) {
        this.keepForever = keepForever;
    }

    public String getLogsContainerUrl() {
        return logsContainerUrl;
    }

    public void setLogsContainerUrl(String logsContainerUrl) {
        this.logsContainerUrl = logsContainerUrl;
    }

    public Author getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(Author modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public String getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(String modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPoolName() {
        return poolName;
    }

    public void setPoolName(String poolName) {
        this.poolName = poolName;
    }

    public ProjectReference getProjectReference() {
        return projectReference;
    }

    public void setProjectReference(ProjectReference projectReference) {
        this.projectReference = projectReference;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public ReleaseShallowReference getReleaseDefinition() {
        return releaseDefinition;
    }

    public void setReleaseDefinition(ReleaseShallowReference releaseDefinition) {
        this.releaseDefinition = releaseDefinition;
    }

    public int getReleaseDefinitionRevision() {
        return releaseDefinitionRevision;
    }

    public void setReleaseDefinitionRevision(int releaseDefinitionRevision) {
        this.releaseDefinitionRevision = releaseDefinitionRevision;
    }

    public String getReleaseNameFormat() {
        return releaseNameFormat;
    }

    public void setReleaseNameFormat(String releaseNameFormat) {
        this.releaseNameFormat = releaseNameFormat;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public String getTriggeringArtifactAlias() {
        return triggeringArtifactAlias;
    }

    public void setTriggeringArtifactAlias(String triggeringArtifactAlias) {
        this.triggeringArtifactAlias = triggeringArtifactAlias;
    }

    public JsonNode getVariableGroups() {
        return variableGroups;
    }

    public void setVariableGroups(JsonNode variableGroups) {
        this.variableGroups = variableGroups;
    }

    public JsonNode getVariables() {
        return variables;
    }

    public void setVariables(JsonNode variables) {
        this.variables = variables;
    }

    @Override
    public String toString() {
        return "Release{" +
                "_links=" + _links +
                ", artifacts=" + artifacts +
                ", comment='" + comment + '\'' +
                ", createdBy=" + createdBy +
                ", createdFor=" + createdFor +
                ", createdOn='" + createdOn + '\'' +
                ", definitionSnapshotRevision=" + definitionSnapshotRevision +
                ", description='" + description + '\'' +
                ", environments=" + environments +
                ", id=" + id +
                ", keepForever=" + keepForever +
                ", logsContainerUrl='" + logsContainerUrl + '\'' +
                ", modifiedBy=" + modifiedBy +
                ", modifiedOn='" + modifiedOn + '\'' +
                ", name='" + name + '\'' +
                ", poolName='" + poolName + '\'' +
                ", projectReference=" + projectReference +
                ", reason='" + reason + '\'' +
                ", releaseDefinition=" + releaseDefinition +
                ", releaseDefinitionRevision=" + releaseDefinitionRevision +
                ", releaseNameFormat='" + releaseNameFormat + '\'' +
                ", status='" + status + '\'' +
                ", tags=" + Arrays.toString(tags) +
                ", triggeringArtifactAlias='" + triggeringArtifactAlias + '\'' +
                ", variableGroups=" + variableGroups +
                ", variables=" + variables +
                '}';
    }
}
