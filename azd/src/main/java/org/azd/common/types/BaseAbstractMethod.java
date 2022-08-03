package org.azd.common.types;

import com.fasterxml.jackson.databind.JsonNode;
import org.azd.exceptions.AzDException;
import org.azd.helpers.JsonMapper;

public abstract class BaseAbstractMethod {
    private final JsonMapper MAPPER = new JsonMapper();

    public String toString() {
        String res = null;

        try {
            res = this.MAPPER.convertToString(this);
        } catch (AzDException ignored) { }

        return res;
    }

    public JsonNode toJsonTree() {
        JsonNode res = null;
        try {
            res = this.MAPPER.convertToJson(this.toString());
        } catch (AzDException e) { }

        return res;
    }
}
