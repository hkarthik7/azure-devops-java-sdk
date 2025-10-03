package org.azd.git.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableCollectionEntity;

import java.util.List;

/**
 * Collection of Git policy Configurations
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PolicyConfigurations extends SerializableCollectionEntity {
    /**
     * Collection of Git policy Configurations
     */
    @JsonProperty("value")
    private List<PolicyConfiguration> policyConfigurations;

    public List<PolicyConfiguration> getPolicyConfigurations() {
        return policyConfigurations;
    }

    public void setPolicyConfigurations(List<PolicyConfiguration> policyConfigurations) {
        this.policyConfigurations = policyConfigurations;
    }
}
