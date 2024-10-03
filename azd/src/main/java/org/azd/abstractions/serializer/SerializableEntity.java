package org.azd.abstractions.serializer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.JsonNode;
import org.azd.abstractions.ApiResponse;
import org.azd.abstractions.InstanceFactory;
import org.azd.abstractions.ResponseHandler;
import org.azd.exceptions.AzDException;

@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class SerializableEntity {
    @JsonIgnore
    private final SerializerContext SERIALIZER = InstanceFactory.createSerializerContext();

    /**
     * toString() method to convert the POJO to string.
     *
     * @return String result.
     */
    public String toString() {
        String res = null;

        try {
            res = SERIALIZER.serialize(this);
        } catch (AzDException ignored) {
        }

        return res;
    }

    /**
     * Helper method to convert the string to Json node.
     *
     * @return JsonNode object.
     */
    public JsonNode toJsonTree() {
        JsonNode res = null;
        try {
            res = SERIALIZER.serialize(this.toString());
        } catch (AzDException ignored) {
        }

        return res;
    }

    @JsonIgnore
    public ApiResponse getResponse() {
        return ResponseHandler.getResponse();
    }
}
