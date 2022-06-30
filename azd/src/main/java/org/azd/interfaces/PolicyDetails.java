package org.azd.interfaces;

import org.azd.exceptions.AzDException;
import org.azd.policy.types.PolicyConfiguration;
import org.azd.policy.types.PolicyConfigurations;
import org.azd.policy.types.PolicyType;
import org.azd.policy.types.PolicyTypes;

import java.util.Map;

public interface PolicyDetails {
    PolicyConfiguration createPolicyConfiguration(String typeId, boolean isEnabled, boolean isBlocking, Map settings) throws AzDException;

    Void deletePolicyConfiguration(int configurationId) throws AzDException;

    PolicyConfiguration getPolicyConfiguration(int configurationId) throws AzDException;

    PolicyConfigurations getPolicyConfigurations() throws AzDException;

    PolicyConfigurations getPolicyConfigurations(int top, String continuationToken, String policyType) throws AzDException;

    PolicyConfiguration updatePolicyConfiguration(int configurationId, String typeId, boolean isEnabled, boolean isBlocking, Map settings)
            throws AzDException;

    PolicyType getPolicyType(String typeId) throws AzDException;

    PolicyTypes getPolicyTypes() throws AzDException;
}
