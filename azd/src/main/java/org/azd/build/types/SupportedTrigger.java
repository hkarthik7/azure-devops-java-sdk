package org.azd.build.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import org.azd.common.types.BaseAbstractMethod;

/**
 * The types of triggers supported by this source provider.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SupportedTrigger extends BaseAbstractMethod {
    /**
     * The default interval to wait between polls (only relevant when NotificationType is Polling).
     */
    @JsonProperty("defaultPollingInterval")
    private int defaultPollingInterval;
    /**
     * How the trigger is notified of changes.
     */
    @JsonProperty("notificationType")
    private String notificationType;
    /**
     * The capabilities supported by this trigger.
     */
    @JsonProperty("supportedCapabilities")
    private JsonNode supportedCapabilities;
    /**
     * The type of trigger.
     */
    @JsonProperty("type")
    private String type;

    public int getDefaultPollingInterval() {
        return defaultPollingInterval;
    }

    public void setDefaultPollingInterval(int defaultPollingInterval) {
        this.defaultPollingInterval = defaultPollingInterval;
    }

    public String getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(String notificationType) {
        this.notificationType = notificationType;
    }

    public JsonNode getSupportedCapabilities() {
        return supportedCapabilities;
    }

    public void setSupportedCapabilities(JsonNode supportedCapabilities) {
        this.supportedCapabilities = supportedCapabilities;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
