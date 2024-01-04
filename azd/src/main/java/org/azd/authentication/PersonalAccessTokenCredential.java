package org.azd.authentication;

import java.util.Base64;
import java.util.Objects;

/**
 * Represents personal access token authentication model.
 *
 * @see <a href="https://learn.microsoft.com/en-us/azure/devops/organizations/accounts/use-personal-access-tokens-to-authenticate?view=azure-devops&tabs=Windows">Personal access token</a>
 */
public class PersonalAccessTokenCredential implements AccessTokenCredential {

    /**
     * Azure DevOps organization or TFS collection url.
     */
    private String organizationUrl;
    /**
     * Project name
     */
    private String projectName;
    /**
     * Personal access token.
     */
    private String personalAccessToken;

    /**
     * Creates a new Personal access token credential provider object.
     *
     * @param organizationUrl     Azure DevOps organization url.
     * @param personalAccessToken Personal access token.
     */
    public PersonalAccessTokenCredential(String organizationUrl, String personalAccessToken) {
        this(organizationUrl, null, personalAccessToken);
    }

    /**
     * Creates a new Personal access token credential provider object.
     *
     * @param organizationUrl     Azure DevOps organization url.
     * @param projectName         Pass the project name
     * @param personalAccessToken Personal access token.
     */
    public PersonalAccessTokenCredential(String organizationUrl, String projectName, String personalAccessToken) {
        Objects.requireNonNull(organizationUrl, "Organization url cannot be null.");
        Objects.requireNonNull(personalAccessToken, "Access token cannot be null.");

        this.organizationUrl = organizationUrl;
        this.projectName = projectName;
        setAccessToken(personalAccessToken);
    }

    /**
     * Encodes personal access token.
     *
     * @param token personal access token.
     * @return Encoded personal access token.
     */
    private static String encodePersonalAccessToken(String token) {
        return "Basic " +
                Base64.getEncoder().encodeToString(("" + ":" + token).getBytes());
    }

    /**
     * Gets the personal access token.
     *
     * @return Personal access token.
     */
    @Override
    public String getAccessToken() {
        return personalAccessToken;
    }

    /**
     * Sets the personal access token.
     *
     * @param accessToken Personal access token.
     */
    @Override
    public void setAccessToken(String accessToken) {
        this.personalAccessToken = encodePersonalAccessToken(accessToken);
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
     * @param organizationUrl Azure DevOps organization or TFS collection url.
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
        this.projectName = projectName;
    }
}
