package org.azd.authentication;

public interface AccessTokenCredential {
    String getOrganizationUrl();

    void setOrganizationUrl(String organizationUrl);

    String getProjectName();

    void setProjectName(String projectName);

    String getAccessToken();

    void setAccessToken(String accessToken);
}
