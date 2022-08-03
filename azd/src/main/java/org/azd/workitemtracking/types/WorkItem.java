package org.azd.workitemtracking.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

import java.util.List;

/***
 * Describes a work item.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WorkItem extends BaseAbstractMethod {
    /***
     * The work item ID.
     */
    @JsonProperty("id")
    private int id;
    /***
     * Revision number of the work item.
     */
    @JsonProperty("rev")
    private int rev;
    /***
     * Map of field and values for the work item.
     */
    @JsonProperty("fields")
    private WorkItemFields fields;
    /***
     * Relations of the work item.
     */
    @JsonProperty("relations")
    private List<WorkItemRelations> relations;
    /***
     * Link references to related REST resources.
     */
    @JsonProperty("_links")
    private Object _links;
    /***
     * Url of the work item.
     */
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

    public Object get_links() {
        return _links;
    }

    public void set_links(Object _links) {
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

}
