package org.azd.build.types;
/**
 * ----------------------------------------------------------
 * GENERATED FILE, should be edited to suit the purpose.
 * ----------------------------------------------------------
 **/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

/**
 * Represents a variable used by a build definition. 
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class BuildController extends BaseAbstractMethod {
    /**
     * The class to represent a collection of REST reference links.
     **/
    @JsonProperty("_links")
    private Object _links;
    /**
     * The date the controller was created.
     **/
    @JsonProperty("createdDate")
    private String createdDate;
    /**
     * The description of the controller.
     **/
    @JsonProperty("description")
    private String description;
    /**
     * Indicates whether the controller is enabled.
     **/
    @JsonProperty("enabled")
    private Boolean enabled;
    /**
     * Id of the resource
     **/
    @JsonProperty("id")
    private Integer id;
    /**
     * Name of the linked resource (definition name, controller name, etc.)
     **/
    @JsonProperty("name")
    private String name;
    /**
     * The status of the controller.
     **/
    @JsonProperty("status")
    private ControllerStatus status;
    /**
     * The date the controller was last updated.
     **/
    @JsonProperty("updatedDate")
    private String updatedDate;
    /**
     * The controller's URI.
     **/
    @JsonProperty("uri")
    private String uri;
    /**
     * Full http link to the resource
     **/
    @JsonProperty("url")
    private String url;

    public Object get_links() {
        return _links;
    }

    public void set_links(Object _links) {
        this._links = _links;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
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

    public ControllerStatus getStatus() {
        return status;
    }

    public void setStatus(ControllerStatus status) {
        this.status = status;
    }

    public String getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(String updatedDate) {
        this.updatedDate = updatedDate;
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
