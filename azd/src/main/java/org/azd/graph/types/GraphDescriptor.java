package org.azd.graph.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

/***
 * Graph descriptor type
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GraphDescriptor extends BaseAbstractMethod {
    /***
     * This field contains zero or more interesting links about the graph subject.
     * These links may be invoked to obtain additional relationships or more detailed information about this graph subject.
     */
    @JsonProperty("_links")
    private GraphDescriptorReferenceLinks _links;

    /***
     * descriptor value
     */
    @JsonProperty("value")
    private String value;

    public GraphDescriptorReferenceLinks get_links() {
        return _links;
    }

    public void set_links(GraphDescriptorReferenceLinks _links) {
        this._links = _links;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
