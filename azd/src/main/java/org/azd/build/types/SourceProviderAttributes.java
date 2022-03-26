package org.azd.build.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Represents an array of SourceProviderAttribute
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SourceProviderAttributes {
    /**
     * Represents an array of SourceProviderAttribute
     */
    @JsonProperty("value")
    private List<SourceProviderAttribute> sourceProviderAttributes;

    public List<SourceProviderAttribute> getSourceProviderAttributes() {
        return sourceProviderAttributes;
    }

    public void setSourceProviderAttributes(List<SourceProviderAttribute> sourceProviderAttributes) {
        this.sourceProviderAttributes = sourceProviderAttributes;
    }

    @Override
    public String toString() {
        return "SourceProviderAttributes{" +
                "sourceProviderAttributes=" + sourceProviderAttributes +
                '}';
    }
}
