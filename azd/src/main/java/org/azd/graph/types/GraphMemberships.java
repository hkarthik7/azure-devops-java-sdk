package org.azd.graph.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

import java.util.List;

/***
 * list of graph membership
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GraphMemberships extends BaseAbstractMethod {
    /***
     * list of graph membership
     */
    @JsonProperty("value")
    private List<GraphMembership> GraphMemberships;

    public List<GraphMembership> getGraphMemberships() {
        return GraphMemberships;
    }

    public void setGraphMemberships(List<GraphMembership> graphMemberships) {
        GraphMemberships = graphMemberships;
    }

}
