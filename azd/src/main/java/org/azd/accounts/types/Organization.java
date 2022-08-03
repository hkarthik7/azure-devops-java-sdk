package org.azd.accounts.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

/***
 * Represents an organization
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Organization extends BaseAbstractMethod {
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

}
