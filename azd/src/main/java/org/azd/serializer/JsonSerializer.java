package org.azd.serializer;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.azd.enums.ApiExceptionTypes;
import org.azd.exceptions.ApiException;
import org.azd.exceptions.AzDException;
import org.azd.helpers.StreamHelper;
import org.azd.interfaces.SerializerContext;

import java.io.File;
import java.io.InputStream;

/**
 * JsonSerializer class to serialize and deserialize json -> object and vice versa.
 */
public final class JsonSerializer extends ObjectMapper implements SerializerContext {
    public JsonSerializer() {
        super();
        this.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

    /***
     * Serializes the object to string
     *
     * @param value any nonnull json object.
     * @return a String
     * @throws AzDException Api exception handler
     */
    public String serialize(Object value) throws AzDException {
        try {
            return this.writeValueAsString(value);
        } catch (JsonProcessingException e) {
            throw new AzDException(ApiExceptionTypes.StringValueParsingException.toString(), e.getMessage());
        }
    }

    /**
     * Serializes a string response to JsonNode object.
     *
     * @param jsonString string response from Api.
     * @return JsonNode {@link JsonNode}
     * @throws AzDException Api exception handler.
     */
    public JsonNode serialize(String jsonString) throws AzDException {
        try {
            return this.readTree(jsonString);
        } catch (JsonProcessingException e) {
            throw new AzDException(ApiExceptionTypes.StringValueParsingException.name(), e.getMessage());
        }
    }

    /***
     * Deserializes the json string to object of given type.
     *
     * @param content json response from API
     * @param valueType class name to convert to POJO
     * @param <T> Type name
     * @return the given type
     * @throws AzDException Api exception handler
     */
    public <T> T deserialize(final String content, Class<T> valueType) throws AzDException {
        try {
            if (content.contains("innerException"))
                throw new AzDException(this.readValue(content, ApiException.class).getTypeKey(), this.readValue(content, ApiException.class).getMessage());
            if (content.contains("The request is invalid."))
                throw new AzDException();
            if (content.contains("Object moved"))
                throw new AzDException(ApiExceptionTypes.InvalidPersonalAccessTokenException.toString(), "Personal access token passed is invalid; Pass the valid token and try again.");
            return this.readValue(content, valueType);
        } catch (JsonProcessingException e) {
            throw new AzDException(ApiExceptionTypes.ApiResponseParsingException.toString(), e.getMessage());
        }
    }

    /***
     * Deserializes the json string to object of given type.
     *
     * @param content json response from API
     * @param valueType class name to convert to POJO
     * @param <T> Type name
     * @return the given type
     * @throws AzDException Api exception handler
     */
    public <T> T deserialize(final String content, TypeReference<T> valueType) throws AzDException {
        try {
            if (content.contains("innerException"))
                throw new AzDException(this.readValue(content, ApiException.class).getTypeKey(), this.readValue(content, ApiException.class).getMessage());
            if (content.contains("The request is invalid."))
                throw new AzDException();
            if (content.contains("Object moved"))
                throw new AzDException(ApiExceptionTypes.InvalidPersonalAccessTokenException.toString(), "Personal access token passed is invalid; Pass the valid token and try again.");
            return this.readValue(content, valueType);
        } catch (JsonProcessingException e) {
            throw new AzDException(ApiExceptionTypes.ApiResponseParsingException.toString(), e.getMessage());
        }
    }

    /***
     * Deserializes the stream of json string to object of given type.
     *
     * @param content input stream response from API
     * @param valueType class name to convert to POJO
     * @param <T> Type name
     * @return the given type
     * @throws AzDException Api exception handler
     */
    public <T> T deserialize(InputStream content, Class<T> valueType) throws AzDException {
        try {
            return deserialize(StreamHelper.convertToString(content), valueType);
        } catch (AzDException e) {
            throw new AzDException(ApiExceptionTypes.ApiResponseParsingException.toString(), e.getMessage());
        }
    }

    /***
     * Deserializes the json string to given object from a file.
     *
     * @param src file name
     * @param valueType class name to convert to POJO
     * @param <T> Type name
     * @return the given type
     * @throws AzDException Api exception handler
     */
    public <T> T deserialize(File src, Class<T> valueType) throws AzDException {
        try {
            return this.readValue(src, valueType);
        } catch (Exception e) {
            throw new AzDException(ApiExceptionTypes.FileContentParsingException.toString(), e.getMessage());
        }
    }
}
