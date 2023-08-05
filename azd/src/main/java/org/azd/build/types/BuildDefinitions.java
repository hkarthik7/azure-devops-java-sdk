package org.azd.build.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.serializer.SerializableEntity;

import java.util.List;

/***
 * List of build definition
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class BuildDefinitions extends SerializableEntity {
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

}
