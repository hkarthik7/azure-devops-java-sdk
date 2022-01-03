package org.azd.distributedtask.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.Author;
import org.azd.release.types.ProjectReference;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EnvironmentInstance {
    @JsonProperty("createdBy")
    private Author createdBy;
    @JsonProperty("createdOn")
    private String createdOn;
    @JsonProperty("description")
    private String description;
    @JsonProperty("id")
    private int id;
    @JsonProperty("lastModifiedBy")
    private Author lastModifiedBy;
    @JsonProperty("lastModifiedOn")
    private String lastModifiedOn;
    @JsonProperty("name")
    private String name;
    @JsonProperty("project")
    private ProjectReference project;
    @JsonProperty("resources")
    private List<EnvironmentResourceReference> resources;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Author getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(Author lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public String getLastModifiedOn() {
        return lastModifiedOn;
    }

    public void setLastModifiedOn(String lastModifiedOn) {
        this.lastModifiedOn = lastModifiedOn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProjectReference getProject() {
        return project;
    }

    public void setProject(ProjectReference project) {
        this.project = project;
    }

    public List<EnvironmentResourceReference> getResources() {
        return resources;
    }

    public void setResources(List<EnvironmentResourceReference> resources) {
        this.resources = resources;
    }

    @Override
    public String toString() {
        return "EnvironmentInstance{" +
                "createdBy=" + createdBy +
                ", createdOn='" + createdOn + '\'' +
                ", description='" + description + '\'' +
                ", id=" + id +
                ", lastModifiedBy=" + lastModifiedBy +
                ", lastModifiedOn='" + lastModifiedOn + '\'' +
                ", name='" + name + '\'' +
                ", project=" + project +
                ", resources=" + resources +
                '}';
    }
}
