package org.azd.build.types;
/**
 * ----------------------------------------------------------
 * GENERATED FILE, should be edited to suit the purpose.
 * ----------------------------------------------------------
 **/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;
import org.azd.enums.DefinitionQueueStatus;
import org.azd.enums.DefinitionType;

/**
 * The type of the definition. 
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class DefinitionReference extends BaseAbstractMethod {
    /**
     * The date this version of the definition was created.
     **/
    @JsonProperty("createdDate")
    private String createdDate;
    /**
     * The ID of the referenced definition.
     **/
    @JsonProperty("id")
    private Integer id;
    /**
     * The name of the referenced definition.
     **/
    @JsonProperty("name")
    private String name;
    /**
     * The folder path of the definition.
     **/
    @JsonProperty("path")
    private String path;
    /**
     * A reference to the project.
     **/
    @JsonProperty("project")
    private TeamProjectReference project;
    /**
     * A value that indicates whether builds can be queued against this definition.
     **/
    @JsonProperty("queueStatus")
    private DefinitionQueueStatus queueStatus;
    /**
     * The definition revision number.
     **/
    @JsonProperty("revision")
    private Integer revision;
    /**
     * The type of the definition.
     **/
    @JsonProperty("type")
    private DefinitionType type;
    /**
     * The definition's URI.
     **/
    @JsonProperty("uri")
    private String uri;
    /**
     * The REST URL of the definition.
     **/
    @JsonProperty("url")
    private String url;

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public TeamProjectReference getProject() {
        return project;
    }

    public void setProject(TeamProjectReference project) {
        this.project = project;
    }

    public DefinitionQueueStatus getQueueStatus() {
        return queueStatus;
    }

    public void setQueueStatus(DefinitionQueueStatus queueStatus) {
        this.queueStatus = queueStatus;
    }

    public Integer getRevision() {
        return revision;
    }

    public void setRevision(Integer revision) {
        this.revision = revision;
    }

    public DefinitionType getType() {
        return type;
    }

    public void setType(DefinitionType type) {
        this.type = type;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
