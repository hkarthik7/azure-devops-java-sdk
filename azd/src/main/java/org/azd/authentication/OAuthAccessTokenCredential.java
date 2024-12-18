package org.azd.authentication;

import org.azd.exceptions.AzDException;
import org.azd.helpers.URLHelper;
import org.azd.oauth.OAuthAccessTokenBuilder;
import org.azd.oauth.types.AuthorizedToken;

import java.util.Objects;

/**
 * Represents OAuth authentication provider model.
 *
 * @see <a href="https://learn.microsoft.com/en-us/azure/devops/integrate/get-started/authentication/oauth?toc=%2Fazure%2Fdevops%2Fmarketplace-extensibility%2Ftoc.json&view=azure-devops">OAuth2.0</a>
 */
public class OAuthAccessTokenCredential implements AccessTokenCredential {

    /**
     * App secret value.
     */
    private final String appSecret;
    /**
     * Auth code
     */
    private final String authCode;
    /**
     * Pass the call back URL.
     */
    private final String callbackUrl;
    /**
     * Azure DevOps organization or TFS collection url.
     */
    private String organizationUrl;
    /**
     * Project name
     */
    private String projectName;
    /**
     * OAuth access token
     */
    private String oauthAccessToken;
    /**
     * Pass the authorized token.
     */
    private AuthorizedToken authorizedToken;

    /**
     * Creates a new OAuth access token credential provider object.
     *
     * @param organizationUrl Azure DevOps services organization or TFS server collection url.
     * @param projectName     Pass the project name.
     * @param appSecret       URL encoded client secret acquired when the app was registered.
     * @param authCode        URL encoded "code" provided via the code query parameter to your callback URL.
     * @param callbackUrl     callback URL registered with the app.
     */
    public OAuthAccessTokenCredential(String organizationUrl, String projectName,
                                      String appSecret, String authCode, String callbackUrl) {
        this(organizationUrl, projectName, appSecret, authCode, callbackUrl, null);
    }

    /**
     * Creates a new OAuth access token credential provider object.
     *
     * @param organizationUrl Azure DevOps services organization or TFS server collection url.
     * @param projectName     Pass the project name.
     * @param appSecret       URL encoded client secret acquired when the app was registered.
     * @param authCode        URL encoded "code" provided via the code query parameter to your callback URL.
     * @param callbackUrl     callback URL registered with the app.
     * @param authorizedToken Authorized token object if OAuth token is already generated. This is for validating the
     *                        and auto refreshing the token. {@link AuthorizedToken}
     */
    public OAuthAccessTokenCredential(String organizationUrl, String projectName,
                                      String appSecret, String authCode, String callbackUrl, AuthorizedToken authorizedToken) {
        Objects.requireNonNull(organizationUrl, "Organization url cannot be null.");
        Objects.requireNonNull(appSecret, "App secret cannot be null.");
        Objects.requireNonNull(callbackUrl, "Callback url cannot be null.");
        Objects.requireNonNull(authCode, "Auth code cannot be null.");

        this.organizationUrl = organizationUrl;
        this.projectName = URLHelper.encodeSpace(projectName);
        this.appSecret = appSecret;
        this.authCode = authCode;
        this.callbackUrl = callbackUrl;
        this.authorizedToken = authorizedToken;
    }

    /**
     * Gets the organization or tfs collection name.
     *
     * @return Organization name.
     */
    @Override
    public String getOrganizationUrl() {
        return organizationUrl;
    }

    /**
     * Sets the organization or tfs collection name.
     *
     * @param organizationUrl Azure DevOps services or TFS collection url.
     */
    @Override
    public void setOrganizationUrl(String organizationUrl) {
        this.organizationUrl = organizationUrl;
    }

    /**
     * Gets the project name.
     *
     * @return Project name.
     */
    @Override
    public String getProjectName() {
        return projectName;
    }

    /**
     * Sets the project name.
     *
     * @param projectName Pass the project name.
     */
    @Override
    public void setProjectName(String projectName) {
        this.projectName = URLHelper.encodeSpace(projectName);
    }

    /**
     * If not already authenticated, automatically authenticates, acquires the access token and returns it.
     * Token refresh is automatically handled.
     *
     * @return OAuth access token.
     */
    @Override
    public String getAccessToken() {
        authenticate();
        return oauthAccessToken;
    }

    /**
     * Sets the oauth token.
     *
     * @param accessToken OAuth access token.
     */
    @Override
    public void setAccessToken(String accessToken) {
        this.oauthAccessToken = "Bearer " + accessToken;
    }

    /**
     * Authenticate with given app secret, code and generates the access token.
     */
    private void authenticate() {
        var oauthBuilder = new OAuthAccessTokenBuilder();
        try {
            if (authorizedToken != null) {
                authorizedToken = oauthBuilder.hasTokenExpired(authorizedToken) ?
                        oauthBuilder.getRefreshToken(appSecret, authorizedToken.getRefreshToken(), callbackUrl) :
                        oauthBuilder.getAccessToken(appSecret, authCode, callbackUrl);
                setAccessToken(authorizedToken.getAccessToken());
            }
        } catch (AzDException e) {
            throw new RuntimeException(e);
        }
    }
}
