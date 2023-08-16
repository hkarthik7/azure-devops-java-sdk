package org.azd.authentication;

import org.azd.exceptions.AzDException;
import org.azd.interfaces.AccessTokenCredential;
import org.azd.oauth.types.AuthorizedToken;
import org.azd.utils.InstanceFactory;

import java.util.Objects;

public class OAuthAccessTokenCredential implements AccessTokenCredential {
    public OAuthAccessTokenCredential(String organization, String projectName,
                                      String appSecret, String authCode, String callbackUrl, AuthorizedToken authorizedToken) {
        Objects.requireNonNull(organization, "Organization cannot be null.");
        Objects.requireNonNull(appSecret, "App secret cannot be null.");
        Objects.requireNonNull(callbackUrl, "Callback url cannot be null.");
        Objects.requireNonNull(authCode, "Auth code cannot be null.");

        this.organization = organization;
        this.projectName = projectName;
        this.appSecret = appSecret;
        this.authCode = authCode;
        this.callbackUrl = callbackUrl;
        this.authorizedToken = authorizedToken;
    }

    public OAuthAccessTokenCredential(String organization, String projectName,
                                      String appSecret, String authCode, String callbackUrl) {
        this(organization, projectName, appSecret, authCode, callbackUrl, null);

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

    @Override
    public String getAccessToken() {
        authenticate();
        return oauthAccessToken;
    }

    @Override
    public void setAccessToken(String accessToken) {
        this.oauthAccessToken = "Bearer " + accessToken;
    }

    private void authenticate() {
        var oauthBuilder = InstanceFactory.createOAuthAccessTokenBuilder();
        try {
            if (authorizedToken != null) {
                if (oauthBuilder.hasTokenExpired(authorizedToken)) {
                    authorizedToken = oauthBuilder.getRefreshToken(appSecret, authorizedToken.getRefreshToken(), callbackUrl);
                }
            } else {
                authorizedToken = oauthBuilder.getAccessToken(appSecret, authCode, callbackUrl);
            }
            setAccessToken(authorizedToken.getAccessToken());
        } catch (AzDException e) {
            throw new RuntimeException(e);
        }
    }

    private String organization;
    private String projectName;
    private String oauthAccessToken;
    private String appSecret;
    private String authCode;
    private String callbackUrl;
    private AuthorizedToken authorizedToken;
}
