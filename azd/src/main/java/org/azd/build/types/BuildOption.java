package org.azd.build.types;
/**
 * ----------------------------------------------------------
 * GENERATED FILE, should be edited to suit the purpose.
 * ----------------------------------------------------------
 **/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents a build process. 
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class BuildOption {
    /**
     * A reference to the build option.
     **/
    @JsonProperty("definition")
    private BuildOptionDefinitionReference definition;
    /**
     * Indicates whether the behavior is enabled.
     **/
    @JsonProperty("enabled")
    private Boolean enabled;

    @JsonProperty("inputs")
    private Object inputs;

    public BuildOptionDefinitionReference getDefinition() {
        return definition;
    }

    public void setDefinition(BuildOptionDefinitionReference definition) {
        this.definition = definition;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Object getInputs() {
        return inputs;
    }

    public void setInputs(Object inputs) {
        this.inputs = inputs;
    }

    @Override
    public String toString() {
        return "BuildOption{" +
                "definition=" + definition +
                ", enabled=" + enabled +
                ", inputs=" + inputs +
                '}';
    }
}