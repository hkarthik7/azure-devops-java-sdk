package org.azd.pipelines.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;
import org.azd.enums.ConfigurationType;

/**
 * Pipeline configuration object
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PipelineConfiguration extends SerializableEntity {
    /**
     * Configuration type
     */
    @JsonProperty("type")
    private ConfigurationType type;

    public ConfigurationType getType() {
        return type;
    }

    public void setType(ConfigurationType type) {
        this.type = type;
    }

}
