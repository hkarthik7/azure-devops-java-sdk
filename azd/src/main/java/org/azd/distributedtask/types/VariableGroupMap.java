package org.azd.distributedtask.types;

import org.azd.abstractions.serializer.SerializableEntity;
import org.azd.enums.VariableValue;
import org.azd.release.types.ConfigurationVariableValue;

import java.util.HashMap;
import java.util.Map;

/**
 * Variable group map to create variable groups easily.
 * This helper class comes handy when creating variable groups and updating it.
 */
public class VariableGroupMap extends SerializableEntity {
    private final Map<String, ConfigurationVariableValue> map = new HashMap<>();

    public VariableGroupMap() {
    }

    public void put(String name, String value) {
        ConfigurationVariableValue variableValue = new ConfigurationVariableValue();
        variableValue.setValue(value);
        map.put(name, variableValue);
    }

    public void put(String name, String value, VariableValue valueType) {
        ConfigurationVariableValue variableValue = new ConfigurationVariableValue();
        if (valueType == VariableValue.IS_SECRET)
            variableValue.setIsSecret(true);
        if (valueType == VariableValue.IS_READONLY)
            variableValue.setAllowOverride(true);
        variableValue.setValue(value);
        map.put(name, variableValue);
    }

    public Map get() {
        return this.map;
    }
}
