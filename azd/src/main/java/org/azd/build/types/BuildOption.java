package org.azd.build.types;
/**
 * ----------------------------------------------------------
 * GENERATED FILE, should be edited to suit the purpose.
 * ----------------------------------------------------------
 **/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

/**
 * Represents a build process. 
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class BuildOption extends BaseAbstractMethod {
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

}
