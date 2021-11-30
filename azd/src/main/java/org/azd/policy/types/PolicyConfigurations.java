package org.azd.policy.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/***
 * List of full policy configuration with settings.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PolicyConfigurations {
    /***
     * List of full policy configuration with settings.
     */
    @JsonProperty("value")
    private List<PolicyConfiguration> policyConfigurations;

    public List<PolicyConfiguration> getPolicyConfigurations() {
        return policyConfigurations;
    }

    public void setPolicyConfigurations(List<PolicyConfiguration> policyConfigurations) {
        this.policyConfigurations = policyConfigurations;
    }

    @Override
    public String toString() {
        return "PolicyConfigurations{" +
                "policyConfigurations=" + policyConfigurations +
                '}';
    }
}
