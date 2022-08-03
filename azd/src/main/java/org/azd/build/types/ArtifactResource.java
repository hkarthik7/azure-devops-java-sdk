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
 * Represents an artifact produced by a build. 
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class ArtifactResource extends BaseAbstractMethod {
    /**
     * The class to represent a collection of REST reference links.
     **/
    @JsonProperty("_links")
    private Object _links;
    /**
     * Type-specific data about the artifact.
     **/
    @JsonProperty("data")
    private String data;
    /**
     * A link to download the resource.
     **/
    @JsonProperty("downloadUrl")
    private String downloadUrl;
    /**
     * Type-specific properties of the artifact.
     **/
    @JsonProperty("properties")
    private Object properties;
    /**
     * The type of the resource: File container, version control folder, UNC path, etc.
     **/
    @JsonProperty("type")
    private String type;
    /**
     * The full http link to the resource.
     **/
    @JsonProperty("url")
    private String url;

    public Object get_links() {
        return _links;
    }

    public void set_links(Object _links) {
        this._links = _links;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public Object getProperties() {
        return properties;
    }

    public void setProperties(Object properties) {
        this.properties = properties;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
