package org.azd;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CoreParams {
    @JsonProperty("projectName")
    public String projectName;
    @JsonProperty("teamName")
    public String teamName;
}
