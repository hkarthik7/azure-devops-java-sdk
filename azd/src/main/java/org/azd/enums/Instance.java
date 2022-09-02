package org.azd.enums;

/**
 * Base Api instance
 */
public enum Instance {
    /**
     * Azure DevOps Api base instance
     * "https://dev.azure.com/"
     */
    BASE_INSTANCE("https://dev.azure.com/"),
    /**
     * Accounts Api instance
     * "https://app.vssps.visualstudio.com"
     */
    ACCOUNT_INSTANCE("https://app.vssps.visualstudio.com");

    private String instance;

    Instance(String instance) {
        this.instance = instance;
    }

    public String getInstance() {
        return instance;
    }

    public String setSubdomain(String subdomainName) {
        return instance.replaceFirst("https://", "https://" + subdomainName + ".");
    }
}
