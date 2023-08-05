package org.azd.interfaces;

public interface AccessTokenCredential {
    String getOrganization();
    void setOrganization(String organization);
    String getProjectName();
    void setProjectName(String projectName);
    String getAccessToken();
    void setAccessToken(String accessToken);
}
