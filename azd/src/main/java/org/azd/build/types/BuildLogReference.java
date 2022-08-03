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
 * Represents the application of an optional behavior to a build definition. 
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class BuildLogReference extends BaseAbstractMethod {
    /**
     * The ID of the log.
     **/
    @JsonProperty("id")
    private Integer id;
    /**
     * The type of the log location.
     **/
    @JsonProperty("type")
    private String type;
    /**
     * A full link to the log resource.
     **/
    @JsonProperty("url")
    private String url;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
