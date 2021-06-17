package org.azd.workitemtracking.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WorkItemLink {
    @JsonProperty("rel")
    private String rel;
    @JsonProperty("source")
    private WorkItemReference source;
    @JsonProperty("target")
    private WorkItemReference target;

    public String getRel() {
        return rel;
    }

    public void setRel(String rel) {
        this.rel = rel;
    }

    public WorkItemReference getSource() {
        return source;
    }

    public void setSource(WorkItemReference source) {
        this.source = source;
    }

    public WorkItemReference getTarget() {
        return target;
    }

    public void setTarget(WorkItemReference target) {
        this.target = target;
    }

    @Override
    public String toString() {
        return "WorkItemLink{" +
                "rel='" + rel + '\'' +
                ", source=" + source +
                ", target=" + target +
                '}';
    }
}
