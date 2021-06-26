package org.azd.release.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import org.azd.common.Author;

import java.util.Arrays;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ReleaseDefinition {
    @JsonProperty("_links")
    private ReleaseReferenceLinks _links;
    @JsonProperty("artifacts")
    private List<ReleaseArtifacts> artifacts;
    @JsonProperty("comment")
    private String comment;
    @JsonProperty("createdBy")
    private Author createdBy;
    @JsonProperty("createdOn")
    private String createdOn;
    @JsonProperty("description")
    private String description;
    @JsonProperty("environments")
    private List<ReleaseDefinitionEnvironment> environments;
    @JsonProperty("id")
    private int id;
    @JsonProperty("isDeleted")
    private boolean isDeleted;
    @JsonProperty("lastRelease")
    private Release lastRelease;
    @JsonProperty("modifiedBy")
    private Author modifiedBy;
    @JsonProperty("modifiedOn")
    private String modifiedOn;
    @JsonProperty("name")
    private String name;
    @JsonProperty("path")
    private String path;
    @JsonProperty("projectReference")
    private ProjectReference projectReference;
    @JsonProperty("properties")
    private JsonNode properties;
    @JsonProperty("releaseNameFormat")
    private String releaseNameFormat;
    @JsonProperty("revision")
    private int revision;
    @JsonProperty("source")
    private String source;
    @JsonProperty("tags")
    private String[] tags;
    @JsonProperty("triggers")
    private List<ReleaseTriggerBase> triggers;
    @JsonProperty("url")
    private String url;
    @JsonProperty("variableGroups")
    private int[] variableGroups;
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

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<ReleaseDefinitionEnvironment> getEnvironments() {
        return environments;
    }

    public void setEnvironments(List<ReleaseDefinitionEnvironment> environments) {
        this.environments = environments;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public Release getLastRelease() {
        return lastRelease;
    }

    public void setLastRelease(Release lastRelease) {
        this.lastRelease = lastRelease;
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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public ProjectReference getProjectReference() {
        return projectReference;
    }

    public void setProjectReference(ProjectReference projectReference) {
        this.projectReference = projectReference;
    }

    public JsonNode getProperties() {
        return properties;
    }

    public void setProperties(JsonNode properties) {
        this.properties = properties;
    }

    public String getReleaseNameFormat() {
        return releaseNameFormat;
    }

    public void setReleaseNameFormat(String releaseNameFormat) {
        this.releaseNameFormat = releaseNameFormat;
    }

    public int getRevision() {
        return revision;
    }

    public void setRevision(int revision) {
        this.revision = revision;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public List<ReleaseTriggerBase> getTriggers() {
        return triggers;
    }

    public void setTriggers(List<ReleaseTriggerBase> triggers) {
        this.triggers = triggers;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int[] getVariableGroups() {
        return variableGroups;
    }

    public void setVariableGroups(int[] variableGroups) {
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
        return "ReleaseDefinition{" +
                "_links=" + _links +
                ", artifacts=" + artifacts +
                ", comment='" + comment + '\'' +
                ", createdBy=" + createdBy +
                ", createdOn='" + createdOn + '\'' +
                ", description='" + description + '\'' +
                ", environments=" + environments +
                ", id=" + id +
                ", isDeleted=" + isDeleted +
                ", lastRelease=" + lastRelease +
                ", modifiedBy=" + modifiedBy +
                ", modifiedOn='" + modifiedOn + '\'' +
                ", name='" + name + '\'' +
                ", path='" + path + '\'' +
                ", projectReference=" + projectReference +
                ", properties=" + properties +
                ", releaseNameFormat='" + releaseNameFormat + '\'' +
                ", revision=" + revision +
                ", source='" + source + '\'' +
                ", tags=" + Arrays.toString(tags) +
                ", triggers=" + triggers +
                ", url='" + url + '\'' +
                ", variableGroups=" + Arrays.toString(variableGroups) +
                ", variables=" + variables +
                '}';
    }
}
