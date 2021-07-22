package org.azd.git.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/***
 * Represents the workitem associated with the pull request
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResourceRef {
    /***
     * Id of the workitem
     */
    @JsonProperty("id")
    private String id;
    /***
     * Url of the workitem
     */
    @JsonProperty("url")
    private String url;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "ResourceRef{" +
                "id='" + id + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
