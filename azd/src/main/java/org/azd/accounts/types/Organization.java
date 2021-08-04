package org.azd.accounts.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/***
 * Represents an organization
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Organization {
    /***
     * Id of the organization
     */
    @JsonProperty("id")
    private String id;
    /***
     * Name of the organization
     */
    @JsonProperty("name")
    private String name;
    /***
     * url of the organization
     */
    @JsonProperty("url")
    private String url;

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

    @Override
    public String toString() {
        return "Organization{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
