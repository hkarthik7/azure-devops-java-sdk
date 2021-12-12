package org.azd.pipelines.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/***
 * Pipeline configuration object
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PipelineConfiguration {
    /***
     * Configuration type
     */
    @JsonProperty("type")
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "PipelineConfiguration{" +
                "type='" + type + '\'' +
                '}';
    }
}
