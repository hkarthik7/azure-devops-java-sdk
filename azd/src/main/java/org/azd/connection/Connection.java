package org.azd.connection;

import org.azd.exceptions.AzDException;
import org.azd.oauth.OAuthApi;
import org.azd.oauth.types.AuthorizedToken;

/**
 * The factory class which sets the default parameters to use this library.
 * <p>
 * To call the Azure DevOps services REST API organization name and personal access token are
 * mandatory. Setting these parameters as default helps to work with this library on ease.
 * </p>
 */
public class Connection {
    private String organization;
    private String project;
    private String personalAccessToken;
    private String appSecret;
    private String appCallBackURL;
    private AuthorizedToken oauthToken = null;
    private TokenRefreshedHandler tokenRefreshedHandler = defaultTokenRefreshedHandler;
    private static TokenRefreshedHandler defaultTokenRefreshedHandler = new TokenRefreshedHandler() {

        @Override
        public void tokenRefreshed(AuthorizedToken newToken) {
            // nothing is done
        }
    };

    /***
     * default with no parameters
     */
    public Connection() {
    }

    /**
     * Instantiates the class with organization name, project name and personal access token
     *
     * @param organization        pass the organization name
     * @param project             provide the project name
     * @param personalAccessToken pass the personal access token
     */
    private Connection(String organization, String project, String personalAccessToken, AuthorizedToken oauthToken, String appSecret, String appCallBackURL, TokenRefreshedHandler tokenRefreshedHandler) {
        this.organization = organization;
        this.project = project;
        this.personalAccessToken = personalAccessToken;
        this.oauthToken = oauthToken;
        this.appSecret = appSecret;
        this.appCallBackURL = appCallBackURL;
        this.tokenRefreshedHandler = tokenRefreshedHandler != null ? tokenRefreshedHandler : defaultTokenRefreshedHandler;
    }

    /**
     * Instantiates the class with organization name and personal access token.
     * Use this method if you don't want to specify the devops project
     *
     * @param organization        pass the organization name
     * @param personalAccessToken pass the personal access token
     */
    public Connection(String organization, String personalAccessToken) {
        this(organization, null, personalAccessToken, null, null, null, null);
    }

    /**
     * Instantiates the class with organization name, project name and personal access token.
     * Use this method if you want to specify the devops project
     *
     * @param organization        pass the organization name
     * @param project             provide the project name
     * @param personalAccessToken pass the personal access token
     */
    public Connection(String organization, String project, String personalAccessToken) {
        this(organization, project, personalAccessToken, null, null, null, null);
    }

    /**
     * Instantiates the class with organization name and oauth access token.
     * Use this method if you don't want to specify the devops project and you don't want to be notified on oauth token refreshing
     *
     * @param organization   pass the organization name
     * @param oauthToken     pass the oauth access token
     * @param appSecret      pass the app/client secret. It is used to refresh the oauth access token
     * @param appCallBackURL pass the app/client callBackURL (declared in the app). It is used to refresh the oauth access token
     */
    public Connection(String organization, AuthorizedToken oauthToken, String appSecret, String appCallBackURL) {
        this(organization, null, null, oauthToken, appSecret, appCallBackURL, null);
    }

    /**
     * Instantiates the class with organization name, project name and oauth access token.
     * Use this method if you want to specify the devops project and you want to be notified on oauth token refreshing
     *
     * @param organization          pass the organization name
     * @param project               provide the project name
     * @param oauthToken            pass the oauth access token
     * @param appSecret             pass the app/client secret. It is used to refresh the oauth access token
     * @param appCallBackURL        pass the app/client callBackURL (declared in the app). It is used to refresh the oauth access token
     * @param tokenRefreshedHandler pass the handler to be called on oauth token refresh
     */
    public Connection(String organization, String project, AuthorizedToken oauthToken, String appSecret, String appCallBackURL, TokenRefreshedHandler tokenRefreshedHandler) {
        this(organization, project, null, oauthToken, appSecret, appCallBackURL, tokenRefreshedHandler);
    }

    /**
     * Instantiates the class with organization name and oauth access token.
     * Use this method if you don't want to specify the devops project but you want to be notified on oauth token refreshing
     *
     * @param organization          pass the organization name
     * @param oauthToken            pass the oauth access token
     * @param appSecret             pass the app/client secret. It is used to refresh the oauth access token
     * @param appCallBackURL        pass the app/client callBackURL (declared in the app). It is used to refresh the oauth access token
     * @param tokenRefreshedHandler pass the handler to be called on oauth token refresh
     */
    public Connection(String organization, AuthorizedToken oauthToken, String appSecret, String appCallBackURL, TokenRefreshedHandler tokenRefreshedHandler) {
        this(organization, null, null, oauthToken, appSecret, appCallBackURL, tokenRefreshedHandler);
    }

    /**
     * Instantiates the class with organization name, project name and oauth access token.
     * Use this method if you want to specify the devops project and you don't want to be notified on oauth token refreshing
     *
     * @param organization   pass the organization name
     * @param project        provide the project name
     * @param oauthToken     pass the oauth access token
     * @param appSecret      pass the app/client secret. It is used to refresh the oauth access token
     * @param appCallBackURL pass the app/client callBackURL (declared in the app). It is used to refresh the oauth access token
     */
    public Connection(String organization, String project, AuthorizedToken oauthToken, String appSecret, String appCallBackURL) {
        this(organization, project, null, oauthToken, appSecret, appCallBackURL, null);
    }

    /**
     * Get the default organization name
     *
     * @return organization name
     */
    public String getOrganization() {
        return this.organization;
    }

    /**
     * Set the organization name to default
     *
     * @param organization pass the organization name
     */
    public void setOrganization(String organization) {
        this.organization = organization;
    }

    /**
     * Get the default Project name
     *
     * @return project name
     */
    public String getProject() {
        return this.project;
    }

    /**
     * Set the project name to default
     *
     * @param project pass the project name
     */
    public void setProject(String project) {
        this.project = project;
    }

    /***
     * Get the personal access token
     * @return the personal access token
     * @throws AzDException Default Api Exception handler.
     */
    public String getPersonalAccessToken() throws AzDException {
        if (oauthToken != null) {
            if (OAuthApi.hasTokenExpired(oauthToken)) {
                setOauthToken(OAuthApi.getRefreshToken(appSecret, oauthToken.getRefreshToken(), appCallBackURL));
            }
            return oauthToken.getAccessToken();
        }
        return this.personalAccessToken;
    }

    /**
     * Set the personal access token
     *
     * @param personalAccessToken pass the personal access token
     */
    public void setPersonalAccessToken(String personalAccessToken) {
        this.oauthToken = null;
        this.personalAccessToken = personalAccessToken;
    }

    /**
     * Set the oauth access token
     *
     * @param oauthToken pass the oauth access token
     */
    public void setOauthToken(AuthorizedToken oauthToken) {
        this.oauthToken = oauthToken;
        tokenRefreshedHandler.tokenRefreshed(oauthToken);
    }

    public interface TokenRefreshedHandler {
        void tokenRefreshed(AuthorizedToken newToken);
    }

}
