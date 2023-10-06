package org.azd.authentication;

import org.azd.enums.Instance;
import org.azd.interfaces.AccessTokenCredential;
import org.azd.utils.InstanceFactory;

import java.util.Base64;
import java.util.Objects;

/**
 * Represents personal access token authentication model.
 * @see <a href="https://learn.microsoft.com/en-us/azure/devops/organizations/accounts/use-personal-access-tokens-to-authenticate?view=azure-devops&tabs=Windows">Personal access token</a>
 */
public class PersonalAccessTokenCredential implements AccessTokenCredential {

    /**
     * Creates a new Personal access token credential provider object.
     * @param organization Azure DevOps organization.
     * @param personalAccessToken Personal access token.
     */
    public PersonalAccessTokenCredential(String organization, String personalAccessToken) {
        this(organization, null, personalAccessToken);
    }

    /**
     * Creates a new Personal access token credential provider object.
     * @param organization Azure DevOps organization.
     * @param projectName Pass the project name
     * @param personalAccessToken Personal access token.
     */
    public PersonalAccessTokenCredential(String organization, String projectName, String personalAccessToken) {
        this(null, organization, projectName, personalAccessToken);
    }

    /**
     * Creates a new Personal access token credential provider object.
     * @param server Pass the tfs server with port number. server:port
     * @param organization Azure DevOps organization or TFS collection name.
     * @param projectName Pass the project name
     * @param personalAccessToken Personal access token.
     */
    public PersonalAccessTokenCredential(String server, String organization, String projectName, String personalAccessToken) {
        Objects.requireNonNull(organization, "Organization cannot be null.");
        Objects.requireNonNull(personalAccessToken, "Access token cannot be null.");

        this.server = server;
        this.organization = organization;
        this.projectName = projectName;
        this.personalAccessToken = personalAccessToken;

        if (server != null) Instance.BASE_INSTANCE.setInstance("https://" + server + "/tfs/");
    }


    /**
     * Gets the personal access token.
     * @return Personal access token.
     */
    @Override
    public String getAccessToken() {
        return personalAccessToken;
    }

    /**
     * Sets the personal access token.
     * @param accessToken Personal access token.
     */
    @Override
    public void setAccessToken(String accessToken) {
        this.personalAccessToken = accessToken;
    }

    /**
     * Gets the organization or tfs collection name.
     * @return Organization name.
     */
    @Override
    public String getOrganization() {
        return organization;
    }

    /**
     * Sets the organization or tfs collection name.
     * @param organization Azure DevOps organization or TFS collection name.
     */
    @Override
    public void setOrganization(String organization) {
        this.organization = organization;
    }

    /**
     * Gets the project name.
     * @return Project name.
     */
    @Override
    public String getProjectName() {
        return projectName;
    }

    /**
     * Sets the project name.
     * @param projectName Pass the project name.
     */
    @Override
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    /**
     * Encodes personal access token.
     * @param token personal access token.
     * @return Encoded personal access token.
     */
    private static String encodePersonalAccessToken(String token) {
        return "Basic " +
                Base64.getEncoder().encodeToString(("" + ":" + token).getBytes());
    }

    /**
     * TFS server
     */
    private String server;
    /**
     * Azure DevOps organization or TFS collection.
     */
    private String organization;
    /**
     * Project name
     */
    private String projectName;
    /**
     * Personal access token.
     */
    private String personalAccessToken;
}
