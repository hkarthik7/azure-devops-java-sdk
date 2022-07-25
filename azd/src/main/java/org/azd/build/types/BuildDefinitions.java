package org.azd.build.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/***
 * List of build definition
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class BuildDefinitions {
    /***
     * List of build definition
     */
    @JsonProperty("value")
    private List<BuildDefinition> buildDefinitions;

    public List<BuildDefinition> getBuildDefinitions() {
        return buildDefinitions;
    }

    public void setBuildDefinitions(List<BuildDefinition> value) {
        this.buildDefinitions = value;
    }

    @Override
    public String toString() {
        return "BuildDefinitions{" +
                "value=" + buildDefinitions +
                '}';
    }
}
