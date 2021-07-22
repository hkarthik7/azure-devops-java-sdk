package org.azd.git.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.Author;
import org.azd.core.types.TeamProjectReference;

/***
 * Represents deleted repository
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GitDeletedRepository {
    /***
     * Repo creation date
     */
    @JsonProperty("createdDate")
    private String createdDate;
    /***
     * Repo delete by (user reference)
     */
    @JsonProperty("deletedBy")
    private Author deletedBy;
    /***
     * Repo deleted date
     */
    @JsonProperty("deletedDate")
    private String deletedDate;
    /***
     * Repo id
     */
    @JsonProperty("id")
    private String id;
    /***
     * Repo name
     */
    @JsonProperty("name")
    private String name;
    /***
     * Represents a shallow reference to a TeamProject.
     */
    @JsonProperty("project")
    private TeamProjectReference project;

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public Author getDeletedBy() {
        return deletedBy;
    }

    public void setDeletedBy(Author deletedBy) {
        this.deletedBy = deletedBy;
    }

    public String getDeletedDate() {
        return deletedDate;
    }

    public void setDeletedDate(String deletedDate) {
        this.deletedDate = deletedDate;
    }

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

    public TeamProjectReference getProject() {
        return project;
    }

    public void setProject(TeamProjectReference project) {
        this.project = project;
    }

    @Override
    public String toString() {
        return "GitDeletedRepository{" +
                "createdDate='" + createdDate + '\'' +
                ", deletedBy=" + deletedBy +
                ", deletedDate='" + deletedDate + '\'' +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", project=" + project +
                '}';
    }
}
