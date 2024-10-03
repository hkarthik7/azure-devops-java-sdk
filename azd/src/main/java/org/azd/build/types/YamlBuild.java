package org.azd.build.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;

/**
 * Represents a yaml build.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class YamlBuild extends SerializableEntity {
    /**
     * Represents a yaml build.
     */
    @JsonProperty("yaml")
    private String yaml;

    public String getYaml() {
        return yaml;
    }

    public void setYaml(String yaml) {
        this.yaml = yaml;
    }

}
