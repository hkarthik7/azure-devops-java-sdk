package org.azd.build.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BuildRequestValidationResult {
    @JsonProperty("message")
    private String message;
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
