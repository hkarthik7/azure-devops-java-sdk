package org.azd.policy.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/***
 * Policy type reference.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PolicyTypeRef {
    /***
     * Display name of the policy type.
     */
    @JsonProperty("displayName")
    private String displayName;
    /***
     * The policy type ID.
     */
    @JsonProperty("id")
    private String id;
    /***
     * The URL where the policy type can be retrieved.
     */
    @JsonProperty("url")
    private String url;

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

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
        return "PolicyTypeRef{" +
                "displayName='" + displayName + '\'' +
                ", id='" + id + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
