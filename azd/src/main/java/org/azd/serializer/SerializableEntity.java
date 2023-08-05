package org.azd.serializer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.JsonNode;
import org.azd.exceptions.AzDException;
import org.azd.interfaces.SerializerContext;
import org.azd.utils.AzDDefaultRegisterFactory;

@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class SerializableEntity {
    /**
     * toString() method to convert the POJO to string.
     * @return String result.
     */
    public String toString() {
        String res = null;

        try {
            res = SERIALIZER.serialize(this);
        } catch (AzDException ignored) { }

        return res;
    }

    /**
     * Helper method to convert the string to Json node.
     * @return JsonNode object.
     */
    public JsonNode toJsonTree() {
        JsonNode res = null;
        try {
            res = SERIALIZER.serialize(this.toString());
        } catch (AzDException e) { }

        return res;
    }

    @JsonIgnore
    private final SerializerContext SERIALIZER = AzDDefaultRegisterFactory.createSerializerContext();
}
