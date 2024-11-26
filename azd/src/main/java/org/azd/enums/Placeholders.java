package org.azd.enums;

/**
 * Contains the temporary placeholder value.
 */
public enum Placeholders {
    /**
     * Represents the placeholder for organization.
     */
    ORGANIZATION("{organization}");

    private String organization;

    Placeholders(String organization) {
        this.organization = organization;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }
}
