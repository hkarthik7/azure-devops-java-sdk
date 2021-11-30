package org.azd.interfaces;

import org.azd.exceptions.AzDException;
import org.azd.exceptions.ConnectionException;
import org.azd.policy.types.PolicyConfiguration;
import org.azd.policy.types.PolicyConfigurations;
import org.azd.policy.types.PolicyType;
import org.azd.policy.types.PolicyTypes;

import java.util.Map;

public interface PolicyDetails {
    PolicyConfiguration createPolicyConfiguration(String typeId, boolean isEnabled, boolean isBlocking, Map settings) throws ConnectionException, AzDException;
    void deletePolicyConfiguration(int configurationId) throws ConnectionException, AzDException;
    PolicyConfiguration getPolicyConfiguration(int configurationId) throws ConnectionException, AzDException;
    PolicyConfigurations getPolicyConfigurations() throws ConnectionException, AzDException;
    PolicyConfigurations getPolicyConfigurations(int top, String continuationToken, String policyType) throws ConnectionException, AzDException;
    PolicyConfiguration updatePolicyConfiguration(int configurationId, String typeId, boolean isEnabled, boolean isBlocking, Map settings)
            throws ConnectionException, AzDException;
    PolicyType getPolicyType(String typeId) throws ConnectionException, AzDException;
    PolicyTypes getPolicyTypes() throws ConnectionException, AzDException;
}
