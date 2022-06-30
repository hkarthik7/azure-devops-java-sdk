package org.azd.git.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.core.types.Project;

import java.util.Arrays;

/***
 * Represents a Git repository
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Repository {
    /***
     * The class to represent a collection of REST reference links.
     */
    @JsonProperty("_links")
    private RepositoryReferenceLinks _links;
    /***
     * Reference of a default branch
     */
    @JsonProperty("defaultBranch")
    private String defaultBranch;
    /***
     * Repository unique id
     */
    @JsonProperty("id")
    private String id;
    /***
     * True if the repository is disabled. False otherwise.
     */
    @JsonProperty("isDisabled")
    private boolean isDisabled;
    /***
     * True if the repository was created as a fork.
     */
    @JsonProperty("isFork")
    private boolean isFork;
    /***
     * Name of the repository
     */
    @JsonProperty("name")
    private String name;
    /***
     * Name of the parent repository
     */
    @JsonProperty("parentRepository")
    private GitRepositoryRef parentRepository;
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
     * Compressed size (bytes) of the repository.
     */
    @JsonProperty("size")
    private long size;
    /***
     * SSH url
     */
    @JsonProperty("sshUrl")
    private String sshUrl;
    /***
     * Repo url
     */
    @JsonProperty("url")
    private String url;
    /***
     * Valid remote urls
     */
    @JsonProperty("validRemoteUrls")
    private String[] validRemoteUrls;
    /***
     * Repo web url
     */
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

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
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
