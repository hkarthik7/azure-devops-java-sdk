package org.azd;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Properties {
    @JsonProperty("builds")
    public BuildParams builds;
    @JsonProperty("core")
    public CoreParams core;
    @JsonProperty("distributedTask")
    public DistributedTaskParams distributedTask;
    @JsonProperty("git")
    public GitParams git;
    @JsonProperty("pipelines")
    public PipelinesParams pipelines;
    @JsonProperty("release")
    public ReleaseParams release;
}
