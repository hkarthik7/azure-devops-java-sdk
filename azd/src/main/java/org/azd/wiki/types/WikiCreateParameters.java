package org.azd.wiki.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;
import org.azd.enums.WikiType;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WikiCreateParameters extends BaseAbstractMethod {
    @JsonProperty("mappedPath")
    private String mappedPath;
    @JsonProperty("name")
    private String name;
    @JsonProperty("projectId")
    private String projectId;
    @JsonProperty("repositoryId")
    private String repositoryId;
    @JsonProperty("type")
    private WikiType type;
    @JsonProperty("version")
    private GitVersionDescriptor version;

    public WikiCreateParameters(String name, String projectId, WikiType type) {
        this(null, name, projectId, null, type, null);
    }

    public WikiCreateParameters(String mappedPath, String name, String projectId, String repositoryId, WikiType type, GitVersionDescriptor version) {
        this.mappedPath = mappedPath;
        this.name = name;
        this.projectId = projectId;
        this.repositoryId = repositoryId;
        this.type = type;
        this.version = version;
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

    public String getRepositoryId() {
        return repositoryId;
    }

    public void setRepositoryId(String repositoryId) {
        this.repositoryId = repositoryId;
    }

    public WikiType getType() {
        return type;
    }

    public void setType(WikiType type) {
        this.type = type;
    }

    public GitVersionDescriptor getVersion() {
        return version;
    }

    public void setVersion(GitVersionDescriptor version) {
        this.version = version;
    }
}
