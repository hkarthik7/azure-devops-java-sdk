package org.azd.git.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.core.types.Project;

import java.util.Arrays;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Repository {
    @JsonProperty("_links")
    private RepositoryReferenceLinks _links;
    @JsonProperty("defaultBranch")
    private String defaultBranch;
    @JsonProperty("id")
    private String id;
    @JsonProperty("isDisabled")
    private boolean isDisabled;
    @JsonProperty("isFork")
    private boolean isFork;
    @JsonProperty("name")
    private String name;
    @JsonProperty("parentRepository")
    private GitRepositoryRef parentRepository;
    @JsonProperty("project")
    private Project project;
    @JsonProperty("remoteUrl")
    private String remoteUrl;
    @JsonProperty("size")
    private int size;
    @JsonProperty("sshUrl")
    private String sshUrl;
    @JsonProperty("url")
    private String url;
    @JsonProperty("validRemoteUrls")
    private String[] validRemoteUrls;
    @JsonProperty("webUrl")
    private String webUrl;

    public RepositoryReferenceLinks get_links() {
        return _links;
    }

    public void set_links(RepositoryReferenceLinks _links) {
        this._links = _links;
    }

    public boolean isDisabled() {
        return isDisabled;
    }

    public void setDisabled(boolean disabled) {
        isDisabled = disabled;
    }

    public boolean isFork() {
        return isFork;
    }

    public void setFork(boolean fork) {
        isFork = fork;
    }

    public GitRepositoryRef getParentRepository() {
        return parentRepository;
    }

    public void setParentRepository(GitRepositoryRef parentRepository) {
        this.parentRepository = parentRepository;
    }

    public String[] getValidRemoteUrls() {
        return validRemoteUrls;
    }

    public void setValidRemoteUrls(String[] validRemoteUrls) {
        this.validRemoteUrls = validRemoteUrls;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public String getDefaultBranch() {
        return defaultBranch;
    }

    public void setDefaultBranch(String defaultBranch) {
        this.defaultBranch = defaultBranch;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
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

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

    @Override
    public String toString() {
        return "Repository{" +
                "_links=" + _links +
                ", defaultBranch='" + defaultBranch + '\'' +
                ", id='" + id + '\'' +
                ", isDisabled=" + isDisabled +
                ", isFork=" + isFork +
                ", name='" + name + '\'' +
                ", parentRepository=" + parentRepository +
                ", project=" + project +
                ", remoteUrl='" + remoteUrl + '\'' +
                ", size=" + size +
                ", sshUrl='" + sshUrl + '\'' +
                ", url='" + url + '\'' +
                ", validRemoteUrls=" + Arrays.toString(validRemoteUrls) +
                ", webUrl='" + webUrl + '\'' +
                '}';
    }
}
