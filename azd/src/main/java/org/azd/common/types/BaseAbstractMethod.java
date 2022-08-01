package org.azd.common.types;

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
}
