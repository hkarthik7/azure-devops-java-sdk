package org.azd.release.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Issues {
    @JsonProperty("data")
    private Object data;
    @JsonProperty("issueType")
    private String issueType;
    @JsonProperty("message")
    private String message;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getIssueType() {
        return issueType;
    }

    public void setIssueType(String issueType) {
        this.issueType = issueType;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Issues{" +
                "data=" + data +
                ", issueType='" + issueType + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
