package org.azd.graph.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/***
 * list of graph membership
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GraphMemberships {
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

    @Override
    public String toString() {
        return "GraphMemberships{" +
                "GraphMemberships=" + GraphMemberships +
                '}';
    }
}
