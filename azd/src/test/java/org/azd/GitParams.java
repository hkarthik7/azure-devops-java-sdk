package org.azd;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GitParams {
    @JsonProperty("repositoryName")
    public String repositoryName;
    @JsonProperty("branchName")
    public String branchName;
}
