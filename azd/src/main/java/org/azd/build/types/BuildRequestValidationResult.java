package org.azd.build.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;
import org.azd.enums.ValidationResult;

/**
 * The build status. 
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class BuildRequestValidationResult extends BaseAbstractMethod {
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

}
