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
    private List<BuildDefinition> value;

    public List<BuildDefinition> getBuildDefinition() {
        return value;
    }

    public void setBuildDefinition(List<BuildDefinition> value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "BuildDefinitions{" +
                "value=" + value +
                '}';
    }
}
