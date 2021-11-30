package org.azd.policy.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/***
 * List of User-friendly policy type with description (used for querying policy types).
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PolicyTypes {
    /***
     * List of User-friendly policy type with description (used for querying policy types).
     */
    @JsonProperty("value")
    private List<PolicyType> policyTypes;

    public List<PolicyType> getPolicyTypes() {
        return policyTypes;
    }

    public void setPolicyTypes(List<PolicyType> policyTypes) {
        this.policyTypes = policyTypes;
    }

    @Override
    public String toString() {
        return "PolicyTypes{" +
                "policyTypes=" + policyTypes +
                '}';
    }
}
