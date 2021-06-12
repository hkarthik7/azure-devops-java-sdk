package org.azd.helpers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.azd.exceptions.AzDException;

import java.io.File;

public class JsonMapper extends ObjectMapper {

    public String convertToString(Object value) throws AzDException {
        try {
            return this.writeValueAsString(value);
        } catch (JsonProcessingException e) {
            throw new AzDException("Couldn't parse the request content, validate the arguments passed. \n" + value);
        }
    }

    public <T> T mapJsonResponse(String content, Class<T> valueType) throws AzDException {
        try {
            if (content.contains("innerException"))
                throw new AzDException(this.readValue(content, ApiException.class).getTypeKey(), this.readValue(content, ApiException.class).getMessage());
            if (content.contains("The request is invalid."))
                throw new AzDException();
            return this.readValue(content, valueType);
        } catch (JsonProcessingException e) {
            throw new AzDException("Couldn't parse the response content, validate the arguments passed. \n" + content);
        }
    }

    public <T> T mapJsonFromFile(File src, Class<T> valueType) throws AzDException {
        try {
            return this.readValue(src, valueType);
        } catch (Exception e) {
            throw new AzDException("Couldn't parse the content from file, validate the file & path and try again. \n" + src);
        }
    }
}
