package org.azd;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PipelinesParams {
    @JsonProperty("id")
    public int id;
    @JsonProperty("runId")
    public int runId;
    @JsonProperty("artifactName")
    public String artifactName;
    @JsonProperty("previewPipelineId")
    public int previewPipelineId;
}
