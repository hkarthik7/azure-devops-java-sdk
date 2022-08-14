package org.azd.wiki.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import org.azd.common.types.BaseAbstractMethod;
import org.azd.enums.WikiType;

import java.util.List;

/***
 * Defines a wiki resource.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WikiV2 extends BaseAbstractMethod {
    /***
     * ID of the wiki.
     */
    @JsonProperty("id")
    private String id;
    /***
     * Folder path inside repository which is shown as Wiki. Not required for ProjectWiki type.
     */
    @JsonProperty("mappedPath")
    private String mappedPath;
    /***
     * Wiki name.
     */
    @JsonProperty("name")
    private String name;
    /***
     * ID of the project in which the wiki is to be created.
     */
    @JsonProperty("projectId")
    private String projectId;
    /***
     * Properties of the wiki.
     */
    @JsonProperty("properties")
    private JsonNode properties;
    /***
     * Remote web url to the wiki.
     */
    @JsonProperty("remoteUrl")
    private String remoteUrl;
    /***
     * ID of the git repository that backs up the wiki. Not required for ProjectWiki type.
     */
    @JsonProperty("repositoryId")
    private String repositoryId;
    /***
     * Type of the wiki.
     */
    @JsonProperty("type")
    private WikiType type;
    /***
     * REST url for this wiki.
     */
    @JsonProperty("url")
    private String url;
    /***
     * Versions of the wiki.
     */
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

    public WikiType getType() {
        return type;
    }

    public void setType(WikiType type) {
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

}
