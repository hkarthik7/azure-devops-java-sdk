package org.azd.workitemtracking.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import org.azd.common.types.BaseAbstractMethod;
import org.azd.common.types.ReferenceLinks;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WorkItemRecycleBinReference extends BaseAbstractMethod {
    @JsonProperty("_links")
    private ReferenceLinks _links;
    @JsonProperty("commentVersionRef")
    private WorkItemCommentVersionRef commentVersionRef;
    @JsonProperty("fields")
    private JsonNode fields;
    @JsonProperty("id")
    private int id;
    @JsonProperty("relations")
    private WorkItemRelations relations;
    @JsonProperty("rev")
    private int rev;
    @JsonProperty("url")
    private String url;

    public ReferenceLinks get_links() {
        return _links;
    }

    public void set_links(ReferenceLinks _links) {
        this._links = _links;
    }

    public WorkItemCommentVersionRef getCommentVersionRef() {
        return commentVersionRef;
    }

    public void setCommentVersionRef(WorkItemCommentVersionRef commentVersionRef) {
        this.commentVersionRef = commentVersionRef;
    }

    public JsonNode getFields() {
        return fields;
    }

    public void setFields(JsonNode fields) {
        this.fields = fields;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public WorkItemRelations getRelations() {
        return relations;
    }

    public void setRelations(WorkItemRelations relations) {
        this.relations = relations;
    }

    public int getRev() {
        return rev;
    }

    public void setRev(int rev) {
        this.rev = rev;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
