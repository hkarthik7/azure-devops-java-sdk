package org.azd.build.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

/***
 * Represents the application of an optional behavior to a build definition.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Options extends BaseAbstractMethod {
    /***
     * Indicates whether the behavior is enabled.
     */
    @JsonProperty("enabled")
    private boolean enabled;
    /***
     * Represents a reference to a build option definition.
     */
    @JsonProperty("definition")
    private DefinitionReference definition;
    /***
     * Build definition option inputs
     */
    @JsonProperty("inputs")
    private Inputs inputs;

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public DefinitionReference getDefinition() {
        return definition;
    }

    public void setDefinition(DefinitionReference definition) {
        this.definition = definition;
    }

    public Inputs getInputs() {
        return inputs;
    }

    public void setInputs(Inputs inputs) {
        this.inputs = inputs;
    }

}
