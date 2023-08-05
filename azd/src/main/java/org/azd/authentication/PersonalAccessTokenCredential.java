package org.azd.authentication;

import org.azd.interfaces.AccessTokenCredential;

import java.util.Base64;
import java.util.Objects;

public class PersonalAccessTokenCredential implements AccessTokenCredential {
    public PersonalAccessTokenCredential(String organization, String projectName, String personalAccessToken) {
        Objects.requireNonNull(organization, "Organization cannot be null.");
        Objects.requireNonNull(personalAccessToken, "Access token cannot be null.");

        this.organization = organization;
        this.projectName = projectName;
        this.personalAccessToken = encodePersonalAccessToken(personalAccessToken);
    }

    public PersonalAccessTokenCredential(String organization, String personalAccessToken) {
        this(organization, null, personalAccessToken);
    }

    @Override
    public String getAccessToken() {
        return personalAccessToken;
    }

    @Override
    public void setAccessToken(String accessToken) {
        this.personalAccessToken = accessToken;
    }

    @Override
    public String getOrganization() {
        return organization;
    }

    @Override
    public void setOrganization(String organization) {
        this.organization = organization;
    }

    @Override
    public String getProjectName() {
        return projectName;
    }

    @Override
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    private static String encodePersonalAccessToken(String token) {
        return "Basic " +
                Base64.getEncoder().encodeToString(("" + ":" + token).getBytes());
    }

    private String organization;
    private String projectName;
    private String personalAccessToken;
}
