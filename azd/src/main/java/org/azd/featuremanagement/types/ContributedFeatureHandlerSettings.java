package org.azd.featuremanagement.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;

/**
 * Represents feature handler settings. This is the base class for default value rule and
 * listeners.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ContributedFeatureHandlerSettings extends SerializableEntity {
    /**
     * Name of the handler to run
     */
    @JsonProperty("name")
    private String name;
    /**
     * Properties to feed to the handler
     */
    @JsonProperty("properties")
    private Object properties;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getProperties() {
        return properties;
    }

    public void setProperties(Object properties) {
        this.properties = properties;
    }
}
