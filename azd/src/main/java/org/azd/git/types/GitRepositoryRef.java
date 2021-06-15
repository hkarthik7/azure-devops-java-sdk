package org.azd.git.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.core.types.Project;
import org.azd.core.types.TeamProjectCollectionReference;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GitRepositoryRef {
    @JsonProperty("collection")
    private TeamProjectCollectionReference collection;
    @JsonProperty("id")
    private String id;
    @JsonProperty("isFork")
    private boolean isFork;
    @JsonProperty("name")
    private String name;
    @JsonProperty("project")
    private Project project;
    @JsonProperty("remoteUrl")
    private String remoteUrl;
    @JsonProperty("sshUrl")
    private String sshUrl;
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
