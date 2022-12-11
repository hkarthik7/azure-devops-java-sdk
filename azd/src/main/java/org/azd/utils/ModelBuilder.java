package org.azd.utils;

import org.azd.enums.ApiExceptionTypes;
import org.azd.exceptions.AzDException;
import org.azd.helpers.JsonMapper;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class to construct the request body dynamically by removing non-assigned values in a type.
 */
public class ModelBuilder {
    /**
     * Instance of mapper for unmarshalling the request body.
     */
    private static final JsonMapper MAPPER = new JsonMapper();

    /**
     * Build method to construct the request body based on given object.
     * @param model request body.
     * @param valuesToRemove Specify the values to remove from request body if it was assigned by default.
     * @return a Map.
     * @throws AzDException Default exception handler.
     */
    public static Map build(Object model, List<String> valuesToRemove) throws AzDException {

        if (model == null) throw new AzDException(ApiExceptionTypes.InvalidArgumentException.name(), "Request body cannot be null");
        Map<String, Object> definedModel = MAPPER.mapJsonResponse(MAPPER.convertToString(model), Map.class);

        var result = new LinkedHashMap<String, Object>();
        for (var key: definedModel.keySet()) {
            if (definedModel.get(key) != null ) {
                result.put(key, definedModel.get(key));
            }
        }
        return removeKeys(result, valuesToRemove);
    }

    /**
     * Internal method to remove the user specified keys and values from a map.
     * @param map Input map object.
     * @param valuesToRemove Specify the values to remove from the map.
     * @return a Map with removed default values.
     */
    private static Map removeKeys(Map<String, Object> map, List<String> valuesToRemove) {
        if (valuesToRemove == null) return map;
        valuesToRemove.forEach(key -> map.remove(key, map.get(key)));
        return map;
    }
}
