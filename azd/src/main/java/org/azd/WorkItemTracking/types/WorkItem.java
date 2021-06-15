package org.azd.WorkItemTracking.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.ReferenceLinks;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WorkItem {
    @JsonProperty("id")
    private int id;
    @JsonProperty("rev")
    private int rev;
    @JsonProperty("fields")
    private WorkItemFields fields;
    @JsonProperty("relations")
    private List<WorkItemRelations> relations;
    @JsonProperty("_links")
    private ReferenceLinks _links;
    @JsonProperty("url")
    private String url;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRev() {
        return rev;
    }

    public void setRev(int rev) {
        this.rev = rev;
    }

    public WorkItemFields getFields() {
        return fields;
    }

    public void setFields(WorkItemFields fields) {
        this.fields = fields;
    }

    public ReferenceLinks get_links() {
        return _links;
    }

    public void set_links(ReferenceLinks _links) {
        this._links = _links;
    }

    public List<WorkItemRelations> getRelations() {
        return relations;
    }

    public void setRelations(List<WorkItemRelations> relations) {
        this.relations = relations;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "WorkItem{" +
                "id=" + id +
                ", rev=" + rev +
                ", fields=" + fields +
                ", _links=" + _links +
                ", relations=" + relations +
                ", url='" + url + '\'' +
                '}';
    }
}
