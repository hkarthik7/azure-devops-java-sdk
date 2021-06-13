package org.azd.build.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

    @JsonIgnoreProperties(ignoreUnknown = true)
public class TriggerInfo {
    @JsonProperty("ci.sourceSha")
    private String sourceSha;
    @JsonProperty("ci.message")
    private String message;
    @JsonProperty("ci.triggerRepository")
    private String triggerRepository;

    public String getSourceSha() {
        return sourceSha;
    }

    public void setSourceSha(String sourceSha) {
        this.sourceSha = sourceSha;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTriggerRepository() {
        return triggerRepository;
    }

    public void setTriggerRepository(String triggerRepository) {
        this.triggerRepository = triggerRepository;
    }

    @Override
    public String toString() {
        return "TriggerInfo{" +
                "sourceSha='" + sourceSha + '\'' +
                ", message='" + message + '\'' +
                ", triggerRepository='" + triggerRepository + '\'' +
                '}';
    }
}
