package org.azd.build.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/***
 * Represents a yaml build.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class YamlBuild {
    /***
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

    @Override
    public String toString() {
        return "YamlBuild{" +
                "yaml='" + yaml + '\'' +
                '}';
    }
}
