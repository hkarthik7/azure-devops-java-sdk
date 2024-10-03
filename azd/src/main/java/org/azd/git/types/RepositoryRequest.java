package org.azd.git.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RepositoryRequest {
    @JsonProperty("name")
    public String name;
    @JsonProperty("parentRepository")
    public GitRepositoryRef parentRepository;
    @JsonProperty("project")
    public TeamProjectReference project;
}
