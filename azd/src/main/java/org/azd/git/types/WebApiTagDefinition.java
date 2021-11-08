package org.azd.git.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/***
 * The representation of a tag definition which is sent across the wire.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WebApiTagDefinition {
    /***
     * Whether or not the tag definition is active.
     */
    @JsonProperty("active")
    private boolean active;
    /***
     * ID of the tag definition.
     */
    @JsonProperty("id")
    private String id;
    /***
     * The name of the tag definition.
     */
    @JsonProperty("name")
    private String name;
    /***
     * Resource URL for the Tag Definition.
     */
    @JsonProperty("url")
    private String url;

    @Override
    public String toString() {
        return "WebApiTagDefinition{" +
                "active=" + active +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
