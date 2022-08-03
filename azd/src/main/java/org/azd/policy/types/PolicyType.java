package org.azd.policy.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

/***
 * User-friendly policy type with description (used for querying policy types).
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PolicyType extends BaseAbstractMethod {
    /***
     * Detailed description of the policy type.
     */
    @JsonProperty("description")
    private String description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

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

}
