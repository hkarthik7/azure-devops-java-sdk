package org.azd;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BuildParams {
    @JsonProperty("definitionId")
    public int definitionId;
    @JsonProperty("definitionName")
    public String definitionName;
}
