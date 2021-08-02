package org.azd.release.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/***
 * Environment trigger
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class EnvironmentTrigger {
    /***
     * Definition environment ID on which this trigger applicable.
     */
    @JsonProperty("definitionEnvironmentId")
    private int definitionEnvironmentId;
    /***
     * ReleaseDefinition ID on which this trigger applicable.
     */
    @JsonProperty("releaseDefinitionId")
    private int releaseDefinitionId;
    /***
     * Gets or sets the trigger content.
     */
    @JsonProperty("triggerContent")
    private String triggerContent;
    /***
     * Gets or sets the trigger type.
     */
    @JsonProperty("triggerType")
    private String triggerType;

    public int getDefinitionEnvironmentId() {
        return definitionEnvironmentId;
    }

    public void setDefinitionEnvironmentId(int definitionEnvironmentId) {
        this.definitionEnvironmentId = definitionEnvironmentId;
    }

    public int getReleaseDefinitionId() {
        return releaseDefinitionId;
    }

    public void setReleaseDefinitionId(int releaseDefinitionId) {
        this.releaseDefinitionId = releaseDefinitionId;
    }

    public String getTriggerContent() {
        return triggerContent;
    }

    public void setTriggerContent(String triggerContent) {
        this.triggerContent = triggerContent;
    }

    public String getTriggerType() {
        return triggerType;
    }

    public void setTriggerType(String triggerType) {
        this.triggerType = triggerType;
    }

    @Override
    public String toString() {
        return "EnvironmentTrigger{" +
                "definitionEnvironmentId=" + definitionEnvironmentId +
                ", releaseDefinitionId=" + releaseDefinitionId +
                ", triggerContent='" + triggerContent + '\'' +
                ", triggerType='" + triggerType + '\'' +
                '}';
    }
}
