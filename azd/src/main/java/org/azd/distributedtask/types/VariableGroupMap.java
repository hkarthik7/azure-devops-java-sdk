package org.azd.distributedtask.types;

import org.azd.common.types.BaseAbstractMethod;
import org.azd.enums.VariableValue;

import java.util.HashMap;
import java.util.Map;

/**
 * Variable group map to create variable groups easily.
 * This helper class comes handy when creating variable groups and updating it.
 */
public class VariableGroupMap extends BaseAbstractMethod {
    private Map<String, Object> map = new HashMap<>();

    public VariableGroupMap() {
    }

    public void put(String name, String value) {
        map.put(name, new HashMap<String, String>(){{ put("value", value); }});
    }

    public void put(String name, String value, VariableValue valueType) {
        var newMap = new HashMap<String, Object>(){{ put("value", value); }};
        if (valueType == VariableValue.IS_SECRET)
            newMap.put("isSecret", true);
        if (valueType == VariableValue.IS_READONLY)
            newMap.put("isReadOnly", true);
        map.put(name, newMap);
    }

    public Map get() {
        return this.map;
    }
}
