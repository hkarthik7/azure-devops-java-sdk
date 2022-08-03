package org.azd.distributedtask.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.Author;
import org.azd.common.types.BaseAbstractMethod;
import org.azd.release.types.ProjectReference;

import java.util.List;

/***
 * Represents an environment
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class EnvironmentInstance extends BaseAbstractMethod {
    /***
     * Identity reference of the user who created the Environment.
     */
    @JsonProperty("createdBy")
    private Author createdBy;
    /***
     *
     * Creation time of the Environment
     */
    @JsonProperty("createdOn")
    private String createdOn;
    /***
     * Description of the Environment.
     */
    @JsonProperty("description")
    private String description;
    /***
     *
     * Id of the Environment
     */
    @JsonProperty("id")
    private int id;
    /***
     * Identity reference of the user who last modified the Environment.
     */
    @JsonProperty("lastModifiedBy")
    private Author lastModifiedBy;
    /***
     *
     * Last modified time of the Environment
     */
    @JsonProperty("lastModifiedOn")
    private String lastModifiedOn;
    /***
     * Name of the Environment.
     */
    @JsonProperty("name")
    private String name;
    /***
     * Project information for environment.
     */
    @JsonProperty("project")
    private ProjectReference project;
    /***
     * EnvironmentResourceReference.
     */
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

}
