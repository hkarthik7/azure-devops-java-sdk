package org.azd.release.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/***
 * Release trigger base
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReleaseTriggerBase {
    /***
     * Trigger type
     */
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
