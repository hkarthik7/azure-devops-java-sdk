package org.azd.build.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

/***
 * Represents a yaml build.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class YamlBuild extends BaseAbstractMethod {
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

}
