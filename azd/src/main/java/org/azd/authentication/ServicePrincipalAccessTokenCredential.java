package org.azd.authentication;

import org.azd.abstractions.RequestInformation;
import org.azd.common.types.AccessToken;
import org.azd.enums.CustomHeader;
import org.azd.enums.RequestMethod;
import org.azd.exceptions.AzDException;
import org.azd.http.ClientRequest;

import java.net.http.HttpRequest;
import java.nio.charset.StandardCharsets;

/**
 * Represents service principal access token modal.
 *
 * @see <a href="https://learn.microsoft.com/en-us/azure/devops/integrate/get-started/authentication/service-principal-managed-identity?view=azure-devops">SPN authentication</a>
 */
public class ServicePrincipalAccessTokenCredential implements AccessTokenCredential{
    /**
     * Access token request base URL
     */
    private static final String BASEURL = "https://login.microsoftonline.com/";
    /**
     * Access token request endpoint v2.0
     */
    private static final String TOKEN_ENDPOINT = "/oauth2/v2.0/token";
    /**
     * Default resource for requesting access token
     */
    private static final String SCOPES = "499b84ac-1321-427f-aa17-267ca6975798/.default";
    /**
     * Authentication grant type when using service principal.
     */
    private static final String GRANT_TYPE = "&grant_type=client_credentials";

    /**
     * Azure DevOps organization or TFS collection url.
     */
    private String organizationUrl;
    /**
     * Project name
     */
    private String projectName;
    /**
     * Client Id.
     */
    private final String clientId;
    /**
     * Client Secret.
     */
    private final String clientSecret;
    /**
     * Tenant Id.
     */
    private final String tenantId;
    /**
     * Represents the bearer access token
     */
    private String accessToken;

    /**
     * Creates a new Service Principal token credential provider object.
     *
     * @param organizationUrl     Azure DevOps organization url.
     * @param clientId Client id of registered app in Entra Id.
     * @param clientSecret Client secret of registered app in Entra Id.
     * @param tenantId Tenant id of the registered app in Entra Id.
     */
    public ServicePrincipalAccessTokenCredential(String organizationUrl, String tenantId,
                                                 String clientId, String clientSecret) {
        this(organizationUrl, null, tenantId, clientId, clientSecret);
    }

    /**
     * Creates a new Service Principal token credential provider object.
     *
     * @param organizationUrl     Azure DevOps organization url.
     * @param clientId Client id of registered app in Entra Id.
     * @param clientSecret Client secret of registered app in Entra Id.
     * @param tenantId Tenant id of the registered app in Entra Id.
     */
    public ServicePrincipalAccessTokenCredential(String organizationUrl, String projectName, String tenantId,
                                                 String clientId, String clientSecret) {
        this.organizationUrl = organizationUrl;
        this.projectName = projectName;
        this.tenantId = tenantId;
        this.clientId = clientId;
        this.clientSecret = clientSecret;
    }

    @Override
    public String getOrganizationUrl() {
        return organizationUrl;
    }

    @Override
    public void setOrganizationUrl(String organizationUrl) {
        this.organizationUrl = organizationUrl;
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
        return accessToken;
    }

    @Override
    public void setAccessToken(String accessToken) {
        this.accessToken = "Bearer " + accessToken;
    }

    /**
     * Authenticate with given client id, tenant id & client secret and generates the access token.
     */
    private void authenticate() {
        var body = "client_id=" + this.clientId +
                "&scope=" + SCOPES +
                "&client_secret=" + this.clientSecret +
                GRANT_TYPE;

        try {
            var reqInfo = new RequestInformation();
            reqInfo.requestMethod = RequestMethod.POST;
            reqInfo.setRequestUrl(BASEURL + this.tenantId + TOKEN_ENDPOINT);
            reqInfo.requestHeaders.add(CustomHeader.URL_ENCODED);
            reqInfo.body = HttpRequest.BodyPublishers.ofString(body, StandardCharsets.UTF_8);

            var res = ClientRequest.builder()
                    .request(reqInfo)
                    .build()
                    .execute(AccessToken.class);

            setAccessToken(res.Token);
        } catch (AzDException e) {
            throw new RuntimeException(e);
        }
    }
}
