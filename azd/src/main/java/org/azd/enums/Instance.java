package org.azd.enums;

public enum Instance {
    BASE_INSTANCE("https://dev.azure.com/"),
    ACCOUNT_INSTANCE("https://app.vssps.visualstudio.com");

    private String instance;

    Instance(String instance) {
        this.instance = instance;
    }

    public String getInstance() {
        return instance;
    }
}
