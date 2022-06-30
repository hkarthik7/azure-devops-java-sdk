package org.azd.build.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * A reference to the log produced by this operation.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class BuildLogReference {
    /**
     * The ID of the log.
     */
    @JsonProperty("id")
    private int id;
    /**
     * The type of the log location.
     */
    @JsonProperty("type")
    private String type;
    /**
     * A full link to the log resource.
     */
    @JsonProperty("url")
    private String url;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    @Override
    public String toString() {
        return "BuildLogReference{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
