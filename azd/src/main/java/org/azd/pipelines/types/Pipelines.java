package org.azd.pipelines.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

import java.util.List;

/***
 * Defines a list of Pipeline object
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Pipelines extends BaseAbstractMethod {
    /***
     * Defines a list of Pipeline object
     */
    @JsonProperty("value")
    private List<Pipeline> pipelines;


    public List<Pipeline> getPipelines() {
        return pipelines;
    }

    public void setPipelines(List<Pipeline> pipelines) {
        this.pipelines = pipelines;
    }
}
