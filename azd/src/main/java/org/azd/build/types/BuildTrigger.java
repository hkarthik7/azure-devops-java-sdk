package org.azd.build.types;
/**
 * ----------------------------------------------------------
 * GENERATED FILE, should be edited to suit the purpose.
 * ----------------------------------------------------------
 **/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.enums.DefinitionTriggerType;

/**
 * Represents binding of data source for the service endpoint request. 
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class BuildTrigger {
    /**
     * The type of the trigger.
     **/
    @JsonProperty("triggerType")
    private DefinitionTriggerType triggerType;

    public DefinitionTriggerType getTriggerType() {
        return triggerType;
    }

    public void setTriggerType(DefinitionTriggerType triggerType) {
        this.triggerType = triggerType;
    }

    @Override
    public String toString() {
        return "BuildTrigger{" +
                "triggerType=" + triggerType +
                '}';
    }
}