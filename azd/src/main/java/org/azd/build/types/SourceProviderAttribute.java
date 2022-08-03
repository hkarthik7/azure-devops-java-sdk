package org.azd.build.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import org.azd.common.types.BaseAbstractMethod;

import java.util.List;

/**
 * Represents a SourceProviderAttribute
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SourceProviderAttribute extends BaseAbstractMethod {
    /**
     * The name of the source provider.
     */
    @JsonProperty("name")
    private String name;
    /**
     * The capabilities supported by this source provider.
     */
    @JsonProperty("supportedCapabilities")
    private JsonNode supportedCapabilities;
    /**
     * The types of triggers supported by this source provider.
     */
    @JsonProperty("supportedTriggers")
    private List<SupportedTrigger> supportedTriggers;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public JsonNode getSupportedCapabilities() {
        return supportedCapabilities;
    }

    public void setSupportedCapabilities(JsonNode supportedCapabilities) {
        this.supportedCapabilities = supportedCapabilities;
    }

    public List<SupportedTrigger> getSupportedTriggers() {
        return supportedTriggers;
    }

    public void setSupportedTriggers(List<SupportedTrigger> supportedTriggers) {
        this.supportedTriggers = supportedTriggers;
    }

}
