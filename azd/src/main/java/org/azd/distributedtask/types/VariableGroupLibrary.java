package org.azd.distributedtask.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.enums.VariableValue;
import org.azd.serializer.SerializableEntity;

import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class VariableGroupLibrary extends SerializableEntity {
    /**
     * Sets description of the variable group.
     */
    @JsonProperty("description")
    public String description;
    /**
     * Sets name of the variable group.
     */
    @JsonProperty("name")
    public String name;
    /**
     * Sets provider data.
     */
    @JsonProperty("providerData")
    public VariableGroupProviderData providerData;
    /**
     * Sets type of the variable group.
     */
    @JsonProperty("type")
    public String type;
    /**
     * A variable group reference is a shallow reference to variable group.
     */
    @JsonProperty("variableGroupProjectReferences")
    public List<VariableGroupProjectReference> variableGroupProjectReferences;
    /**
     * Sets variables contained in the variable group.
     */
    @JsonProperty("variables")
    public Map<String, VariableValue> variables;
}
