package org.azd.distributedtask.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;

/**
 * A wrapper class for a generic variable.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ConfigurableVariableValue extends SerializableEntity {
    /**
     * Indicates whether the variable can be changed during script's execution runtime.
     */
    @JsonProperty("isReadOnly")
    private boolean isReadOnly;
    /**
     * Indicates whether the variable should be encrypted at rest.
     */
    @JsonProperty("isSecret")
    private boolean isSecret;
    /**
     * The value of the variable.
     */
    @JsonProperty("value")
    private String value;

    public boolean isReadOnly() {
        return isReadOnly;
    }

    public void setReadOnly(boolean readOnly) {
        isReadOnly = readOnly;
    }

    public boolean isSecret() {
        return isSecret;
    }

    public void setSecret(boolean secret) {
        isSecret = secret;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
