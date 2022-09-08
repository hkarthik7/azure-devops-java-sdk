package org.azd.distributedtask.types;

import org.azd.common.types.BaseAbstractMethod;

/***
 * Sets provider data.
 */
public class VariableGroupProviderData extends BaseAbstractMethod {
    /***
     * Azure resource manager service endpoint id.
     */
    private String serviceEndpointId;
    /***
     * Azure key vault reference
     */
    private String vault;

    private String lastRefreshedOn;

    public String getServiceEndpointId() {
        return serviceEndpointId;
    }

    public void setServiceEndpointId(String serviceEndpointId) {
        this.serviceEndpointId = serviceEndpointId;
    }

    public String getVault() {
        return vault;
    }

    public void setVault(String vault) {
        this.vault = vault;
    }

    public String getLastRefreshedOn() {
        return lastRefreshedOn;
    }

    public void setLastRefreshedOn(String lastRefreshedOn) {
        this.lastRefreshedOn = lastRefreshedOn;
    }
}
