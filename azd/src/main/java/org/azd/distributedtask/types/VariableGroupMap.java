package org.azd.distributedtask.types;

import org.azd.common.types.BaseAbstractMethod;
import org.azd.enums.VariableValue;
import org.azd.release.types.ConfigurationVariableValue;

import java.util.HashMap;
import java.util.Map;

/**
 * Variable group map to create variable groups easily.
 * This helper class comes handy when creating variable groups and updating it.
 */
public class VariableGroupMap extends BaseAbstractMethod {
    private final Map<String, ConfigurationVariableValue> map = new HashMap<>();
    private final ConfigurationVariableValue variableValue = new ConfigurationVariableValue();

    public VariableGroupMap() {
    }

    public void put(String name, String value) {
        variableValue.setValue(value);
        map.put(name, variableValue);
    }

    public void put(String name, String value, VariableValue valueType) {
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
