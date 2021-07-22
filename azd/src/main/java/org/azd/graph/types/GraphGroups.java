package org.azd.graph.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/***
 * List of Graph group
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GraphGroups {
    /***
     * List of Graph group
     */
    @JsonProperty("value")
    private List<GraphGroup> GraphGroups;

    public List<GraphGroup> getGraphGroups() {
        return GraphGroups;
    }

    public void setGraphGroups(List<GraphGroup> graphGroups) {
        GraphGroups = graphGroups;
    }

    @Override
    public String toString() {
        return "GraphGroups{" +
                "GraphGroups=" + GraphGroups +
                '}';
    }
}
