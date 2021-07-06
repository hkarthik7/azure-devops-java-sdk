package org.azd.wiki.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WikiV2 {
    @JsonProperty("id")
    private String id;
    @JsonProperty("mappedPath")
    private String mappedPath;
    @JsonProperty("name")
    private String name;
    @JsonProperty("projectId")
    private String projectId;
    @JsonProperty("properties")
    private JsonNode properties;
    @JsonProperty("remoteUrl")
    private String remoteUrl;
    @JsonProperty("repositoryId")
    private String repositoryId;
    @JsonProperty("type")
    private String type;
    @JsonProperty("url")
    private String url;
    @JsonProperty("versions")
    private List<GitVersionDescriptor> versions;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMappedPath() {
        return mappedPath;
    }

    public void setMappedPath(String mappedPath) {
        this.mappedPath = mappedPath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public JsonNode getProperties() {
        return properties;
    }

    public void setProperties(JsonNode properties) {
        this.properties = properties;
    }

    public String getRemoteUrl() {
        return remoteUrl;
    }

    public void setRemoteUrl(String remoteUrl) {
        this.remoteUrl = remoteUrl;
    }

    public String getRepositoryId() {
        return repositoryId;
    }

    public void setRepositoryId(String repositoryId) {
        this.repositoryId = repositoryId;
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

    public List<GitVersionDescriptor> getVersions() {
        return versions;
    }

    public void setVersions(List<GitVersionDescriptor> versions) {
        this.versions = versions;
    }

    @Override
    public String toString() {
        return "WikiV2{" +
                "id='" + id + '\'' +
                ", mappedPath='" + mappedPath + '\'' +
                ", name='" + name + '\'' +
                ", projectId='" + projectId + '\'' +
                ", properties=" + properties +
                ", remoteUrl='" + remoteUrl + '\'' +
                ", repositoryId='" + repositoryId + '\'' +
                ", type='" + type + '\'' +
                ", url='" + url + '\'' +
                ", versions=" + versions +
                '}';
    }
}
