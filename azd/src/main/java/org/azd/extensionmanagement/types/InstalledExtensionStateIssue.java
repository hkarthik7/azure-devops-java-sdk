package org.azd.extensionmanagement.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class InstalledExtensionStateIssue {
    @JsonProperty("message")
    private String message;
    @JsonProperty("source")
    private String source;
    @JsonProperty("type")
    private String type;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "InstalledExtensionStateIssue{" +
                "message='" + message + '\'' +
                ", source='" + source + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
