package org.azd.helpers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.azd.enums.ApiExceptionTypes;
import org.azd.exceptions.AzDException;

import java.io.File;
import java.io.InputStream;

/***
 * Helper class to transform json string to POJO and vice versa
 */
public class JsonMapper extends ObjectMapper {

    /***
     * Converts the object to string
     * @param value any non null json object
     * @return a String
     * @throws AzDException Api exception handler
     */
    public String convertToString(Object value) throws AzDException {
        try {
            return this.writeValueAsString(value);
        } catch (JsonProcessingException e) {
            throw new AzDException(ApiExceptionTypes.StringValueParsingException.toString(), e.getMessage());
        }
    }

    /***
     * Handles the deserialization of json string to object of given type.
     * @param content json response from API
     * @param valueType class name to convert to POJO
     * @param <T> Type name
     * @return the given type
     * @throws AzDException Api exception handler
     */
    public <T> T mapJsonResponse(String content, Class<T> valueType) throws AzDException {
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
     * Handles the deserialization of json string to object of given type.
     * @param content input stream response from API
     * @param valueType class name to convert to POJO
     * @param <T> Type name
     * @return the given type
     * @throws AzDException Api exception handler
     */
    public <T> T mapJsonResponse(InputStream content, Class<T> valueType) throws AzDException {
        try {
            return mapJsonResponse(StreamHelper.convertToString(content), valueType);
        } catch (AzDException e) {
            throw new AzDException(ApiExceptionTypes.ApiResponseParsingException.toString(), e.getMessage());
        }
    }

    /***
     * Handles the deserialization of json string to given object from a file.
     * @param src file name
     * @param valueType class name to convert to POJO
     * @param <T> Type name
     * @return the given type
     * @throws AzDException Api exception handler
     */
    public <T> T mapJsonFromFile(File src, Class<T> valueType) throws AzDException {
        try {
            return this.readValue(src, valueType);
        } catch (Exception e) {
            throw new AzDException(ApiExceptionTypes.FileContentParsingException.toString(), e.getMessage());
        }
    }

    /**
     * Converts a string response to Json string.
     *
     * @param jsonString string response from Api.
     * @return JsonNode {@link JsonNode}
     * @throws AzDException Api exception handler.
     */
    public JsonNode convertToJson(String jsonString) throws AzDException {
        try {
            return this.readTree(jsonString);
        } catch (JsonProcessingException e) {
            throw new AzDException(ApiExceptionTypes.StringValueParsingException.name(), e.getMessage());
        }
    }
}
