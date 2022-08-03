package org.azd.workitemtracking.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/***
 * Relations of the work item.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public final class WorkItemRelations {
    /***
     * Relation type.
     */
    @JsonProperty("rel")
    private String rel;
    /***
     * Link url.
     */
    @JsonProperty("url")
    private String url;
    /***
     * Collection of link attributes.
     */
    @JsonProperty("attributes")
    private WorkItemAttributes attributes;

    public String getRel() {
        return rel;
    }

    public void setRel(String rel) {
        this.rel = rel;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public WorkItemAttributes getAttributes() {
        return attributes;
    }

    public void setAttributes(WorkItemAttributes attributes) {
        this.attributes = attributes;
    }

}
