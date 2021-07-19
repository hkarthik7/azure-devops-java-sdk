package org.azd.build.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/***
 * Represents the result of validating a build request.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class BuildRequestValidationResult {
    /***
     * The message associated with the result.
     */
    @JsonProperty("message")
    private String message;
    /***
     * The result
     */
    @JsonProperty("result")
    private String result;

    @Override
    public String toString() {
        return "BuildRequestValidationResult{" +
                "message='" + message + '\'' +
                ", result='" + result + '\'' +
                '}';
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
