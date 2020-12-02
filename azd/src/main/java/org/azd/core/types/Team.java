package org.azd.core.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Team {
    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("url")
    private String url;
    @JsonProperty("description")
    private String description;
    @JsonProperty("identityUrl")
    private String identityUrl;
    @JsonProperty("projectName")
    private String projectName;
    @JsonProperty("projectId")
    private String projectId;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIdentityUrl() {
        return identityUrl;
    }

    public void setIdentityUrl(String identityUrl) {
        this.identityUrl = identityUrl;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    @Override
    public String toString() {
        return "Team{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", description='" + description + '\'' +
                ", identityUrl='" + identityUrl + '\'' +
                ", projectName='" + projectName + '\'' +
                ", projectId='" + projectId + '\'' +
                '}';
    }
}
