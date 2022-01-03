package org.azd.distributedtask.types;

public class VariableGroupProviderData {
    private String serviceEndpointId;
    private String vault;

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

    @Override
    public String toString() {
        return "VariableGroupProviderData{" +
                "serviceEndpointId='" + serviceEndpointId + '\'' +
                ", vault='" + vault + '\'' +
                '}';
    }
}
