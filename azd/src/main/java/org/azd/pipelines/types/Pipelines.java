package org.azd.pipelines.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/***
 * Defines a list of Pipeline object
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Pipelines {
    /***
     * Defines a list of Pipeline object
     */
    @JsonProperty("value")
    private List<Pipeline> pipelines;

    @Override
    public String toString() {
        return "Pipelines{" +
                "pipelines=" + pipelines +
                '}';
    }

    public List<Pipeline> getPipelines() {
        return pipelines;
    }

    public void setPipelines(List<Pipeline> pipelines) {
        this.pipelines = pipelines;
    }
}
