package org.azd.release.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;

/***
 * Gets releaseReference which specifies the reference of the release to which this approval is associated.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReleaseShallowReference {
    /***
     * Gets the links to related resources, APIs, and views for the release.
     */
    @JsonProperty("_link")
    private JsonNode _link;
    /***
     * Gets the unique identifier of release.
     */
    @JsonProperty("id")
    private int id;
    /***
     * Gets or sets the name of the release.
     */
    @JsonProperty("name")
    private String name;
    /***
     * Gets the REST API url to access the release.
     */
    @JsonProperty("url")
    private String url;

    public JsonNode get_link() {
        return _link;
    }

    public void set_link(JsonNode _link) {
        this._link = _link;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    @Override
    public String toString() {
        return "ReleaseShallowReference{" +
                "_link=" + _link +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
