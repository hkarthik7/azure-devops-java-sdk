package org.azd.Work.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.ReferenceLinks;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class IterationWorkItems {
    @JsonProperty("workItemRelations")
    private List<WorkItemLink> workItemRelations;
    @JsonProperty("url")
    private String url;
    @JsonProperty("_links")
    private ReferenceLinks _links;

    public List<WorkItemLink> getWorkItemRelations() {
        return workItemRelations;
    }

    public void setWorkItemRelations(List<WorkItemLink> workItemRelations) {
        this.workItemRelations = workItemRelations;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public ReferenceLinks get_links() {
        return _links;
    }

    public void set_links(ReferenceLinks _links) {
        this._links = _links;
    }

    @Override
    public String toString() {
        return "IterationWorkItems{" +
                "workItemRelations=" + workItemRelations +
                ", url='" + url + '\'' +
                ", _links=" + _links +
                '}';
    }
}
