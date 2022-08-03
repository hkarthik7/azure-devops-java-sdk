package org.azd.work.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;
import org.azd.common.types.ReferenceLinks;

import java.util.List;

/***
 * Represents work items in an iteration backlog
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class IterationWorkItems extends BaseAbstractMethod {
    /***
     * Work item relations
     */
    @JsonProperty("workItemRelations")
    private List<WorkItemLink> workItemRelations;
    /***
     * Full http link to the resource
     */
    @JsonProperty("url")
    private String url;
    /***
     * Collection of links relevant to resource
     */
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

}
