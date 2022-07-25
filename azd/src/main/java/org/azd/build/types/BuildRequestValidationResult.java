package org.azd.build.types;
/**
 * ----------------------------------------------------------
 * GENERATED FILE, should be edited to suit the purpose.
 * ----------------------------------------------------------
 **/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The build status. 
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class BuildRequestValidationResult {
    /**
     * The message associated with the result.
     **/
    @JsonProperty("message")
    private String message;
    /**
     * The result.
     **/
    @JsonProperty("result")
    private ValidationResult result;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ValidationResult getResult() {
        return result;
    }

    public void setResult(ValidationResult result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "BuildRequestValidationResult{" +
                "message='" + message + '\'' +
                ", result=" + result +
                '}';
    }
}