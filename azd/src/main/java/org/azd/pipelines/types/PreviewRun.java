package org.azd.pipelines.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;

/**
 * Preview run result. Final YAML result
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PreviewRun extends SerializableEntity {
    /**
     * Final YAML string
     */
    @JsonProperty("finalYaml")
    private String finalYaml;

    public String getFinalYaml() {
        return finalYaml;
    }

    public void setFinalYaml(String finalYaml) {
        this.finalYaml = finalYaml;
    }

}
