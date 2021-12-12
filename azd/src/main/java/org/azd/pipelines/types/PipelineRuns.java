package org.azd.pipelines.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/***
 * List of Run object
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PipelineRuns {
    /***
     * List of Run object
     */
    @JsonProperty("value")
    private String pipelineRuns;

    public String getPipelineRuns() {
        return pipelineRuns;
    }

    public void setPipelineRuns(String pipelineRuns) {
        this.pipelineRuns = pipelineRuns;
    }

    @Override
    public String toString() {
        return "PipelineRuns{" +
                "pipelineRuns='" + pipelineRuns + '\'' +
                '}';
    }
}
