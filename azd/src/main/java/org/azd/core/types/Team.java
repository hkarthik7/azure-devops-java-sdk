package org.azd.core.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

/***
 * Represents a project team
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Team extends BaseAbstractMethod {
    /***
     * Team (Identity) Guid. A Team Foundation ID.
     */
    @JsonProperty("id")
    private String id;
    /***
     * Team name
     */
    @JsonProperty("name")
    private String name;
    /***
     * Team REST API Url
     */
    @JsonProperty("url")
    private String url;
    /***
     * Team description
     */
    @JsonProperty("description")
    private String description;
    /***
     * Identity REST API Url to this team
     */
    @JsonProperty("identityUrl")
    private String identityUrl;
    /***
     * Name of the project
     */
    @JsonProperty("projectName")
    private String projectName;
    /***
     * Project identifier
     */
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

}
