package org.azd.serializer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.JsonNode;
import org.azd.exceptions.AzDException;
import org.azd.handlers.DefaultResponseHandler;
import org.azd.http.ApiResponse;
import org.azd.interfaces.SerializerContext;
import org.azd.utils.InstanceFactory;

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
        } catch (AzDException ignored) { }

        return res;
    }

    /**
     * Retrieves the continuation token from response header. This can then be used for getting the paginated response.
     * Note that not all the Apis return continuation token in the headers. If the header value "x-ms-continuationtoken"
     * is present then it will be returned or an empty string will be returned.
     * @return String value.
     */
    @JsonIgnore
    public String getContinuationToken() {
        return DefaultResponseHandler.getResponse().getContinuationToken();
    }

    @JsonIgnore
    private final SerializerContext SERIALIZER = InstanceFactory.createSerializerContext();
}
