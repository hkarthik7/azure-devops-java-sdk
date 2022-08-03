package org.azd.work.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

/***
 * A link between two work items.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WorkItemLink extends BaseAbstractMethod {
    /***
     * The type of link.
     */
    @JsonProperty("rel")
    private String rel;
    /***
     * The source work item.
     */
    @JsonProperty("source")
    private WorkItemReference source;
    /***
     * The target work item.
     */
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
}
