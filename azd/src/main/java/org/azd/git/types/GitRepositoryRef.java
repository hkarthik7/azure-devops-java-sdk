package org.azd.git.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.core.types.Project;
import org.azd.core.types.TeamProjectCollectionReference;

/***
 * Represents the parent repository class if a repo is forked
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GitRepositoryRef {
    /***
     * Team Project Collection where this Fork resides
     */
    @JsonProperty("collection")
    private TeamProjectCollectionReference collection;
    /***
     * Repository id
     */
    @JsonProperty("id")
    private String id;
    /***
     * True if the repository was created as a fork
     */
    @JsonProperty("isFork")
    private boolean isFork;
    /***
     * Repository name
     */
    @JsonProperty("name")
    private String name;
    /***
     * Represents a reference to a TeamProject.
     */
    @JsonProperty("project")
    private Project project;
    /***
     * Repo remote url
     */
    @JsonProperty("remoteUrl")
    private String remoteUrl;
    /***
     * Repo ssh url
     */
    @JsonProperty("sshUrl")
    private String sshUrl;
    /***
     * Repository url
     */
    @JsonProperty("url")
    private String url;

    public TeamProjectCollectionReference getCollection() {
        return collection;
    }

    public void setCollection(TeamProjectCollectionReference collection) {
        this.collection = collection;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isFork() {
        return isFork;
    }

    public void setFork(boolean fork) {
        isFork = fork;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public String getRemoteUrl() {
        return remoteUrl;
    }

    public void setRemoteUrl(String remoteUrl) {
        this.remoteUrl = remoteUrl;
    }

    public String getSshUrl() {
        return sshUrl;
    }

    public void setSshUrl(String sshUrl) {
        this.sshUrl = sshUrl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "GitRepositoryRef{" +
                "collection=" + collection +
                ", id='" + id + '\'' +
                ", isFork=" + isFork +
                ", name='" + name + '\'' +
                ", project=" + project +
                ", remoteUrl='" + remoteUrl + '\'' +
                ", sshUrl='" + sshUrl + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
