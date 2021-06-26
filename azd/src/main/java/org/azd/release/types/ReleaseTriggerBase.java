package org.azd.release.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ReleaseTriggerBase {
    @JsonProperty("triggerType")
    private String triggerType;

    public String getTriggerType() {
        return triggerType;
    }

    public void setTriggerType(String triggerType) {
        this.triggerType = triggerType;
    }

    @Override
    public String toString() {
        return "ReleaseTriggerBase{" +
                "triggerType='" + triggerType + '\'' +
                '}';
    }
}
