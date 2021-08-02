package org.azd.release.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/***
 * List of release definition
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReleaseDefinitions {
    /***
     * List of release definition
     */
    @JsonProperty("value")
    private List<ReleaseDefinition> ReleaseDefinitions;

    public List<ReleaseDefinition> getReleaseDefinitions() {
        return ReleaseDefinitions;
    }

    public void setReleaseDefinitions(List<ReleaseDefinition> releaseDefinitions) {
        ReleaseDefinitions = releaseDefinitions;
    }

    @Override
    public String toString() {
        return "ReleaseDefinitions{" +
                "ReleaseDefinitions=" + ReleaseDefinitions +
                '}';
    }
}
