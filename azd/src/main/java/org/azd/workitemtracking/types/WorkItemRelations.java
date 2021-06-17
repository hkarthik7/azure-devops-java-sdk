package org.azd.workitemtracking.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public final class WorkItemRelations {
    @JsonProperty("rel")
    private String rel;
    @JsonProperty("url")
    private String url;
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

    @Override
    public String toString() {
        return "Relations{" +
                "rel='" + rel + '\'' +
                ", url='" + url + '\'' +
                ", attributes=" + attributes +
                '}';
    }
}
