package org.azd.pipelines.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CreatePipelineRepositoryReference {
    @JsonProperty("name")
    public String repositoryName;
    @JsonProperty("id")
    public String repositoryId;
    @JsonProperty("type")
    public String repositoryType;
}
