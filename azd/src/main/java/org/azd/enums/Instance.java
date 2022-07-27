package org.azd.enums;

/**
 * Base Api instance
 */
public enum Instance {
    /**
     * Azure DevOps Api base instance
     */
    BASE_INSTANCE("https://dev.azure.com/"),
    /**
     * Accounts Api instance
     */
    ACCOUNT_INSTANCE("https://app.vssps.visualstudio.com");

    private String instance;

    Instance(String instance) {
        this.instance = instance;
    }

    public String getInstance() {
        return instance;
    }
}
