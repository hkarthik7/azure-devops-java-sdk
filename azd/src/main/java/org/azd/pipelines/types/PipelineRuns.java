package org.azd.pipelines.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/***
 * List of Run object
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PipelineRuns {
    /***
     * List of Run object
     */
    @JsonProperty("value")
    private List<PipelineRun> pipelineRuns;

    public List<PipelineRun> getPipelineRuns() {
        return pipelineRuns;
    }

    public void setPipelineRuns(List<PipelineRun> pipelineRuns) {
        this.pipelineRuns = pipelineRuns;
    }

    @Override
    public String toString() {
        return "PipelineRuns{" +
                "pipelineRuns='" + pipelineRuns + '\'' +
                '}';
    }
}
