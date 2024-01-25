package org.azd.serviceclient;

import org.azd.accounts.AccountsBaseRequestBuilder;
import org.azd.artifacts.ArtifactsRequestBuilder;
import org.azd.authentication.AccessTokenCredential;
import org.azd.build.BuildBaseRequestBuilder;
import org.azd.common.ResourceId;
import org.azd.configurations.ConfigurationRequestBuilder;
import org.azd.core.CoreRequestBuilder;
import org.azd.distributedtask.DistributedTaskRequestBuilder;
import org.azd.extensionmanagement.ExtensionManagementRequestBuilder;
import org.azd.featuremanagement.FeatureManagementRequestBuilder;
import org.azd.git.GitBaseRequestBuilder;
import org.azd.graph.GraphRequestBuilder;
import org.azd.helpers.HelpersRequestBuilder;
import org.azd.locations.LocationsBaseRequestBuilder;
import org.azd.oauth.OAuthAccessTokenBuilder;

import java.net.URI;
import java.util.Objects;

/**
 * Concrete implementation of AzD service client. Responsible for creating the respective location url based on
 * organization url given and return the corresponding request builders.
 */
public class BaseServiceClient implements AzDServiceClient {
    /**
     * Access token credential.
     */
    private final AccessTokenCredential accessTokenCredential;
    /**
     * Organization url.
     */
    private final String organizationUrl;

    /**
     * Default constructor.
     *
     * @param accessTokenCredential Access token credential. {@link AccessTokenCredential}
     */
    public BaseServiceClient(AccessTokenCredential accessTokenCredential) {
        this.accessTokenCredential = Objects.requireNonNull(accessTokenCredential, "Access token credential cannot be null.");
        this.organizationUrl = Objects.requireNonNull(accessTokenCredential.getOrganizationUrl(), "Organization url cannot be null.");
    }

    /**
     * Request builder for accounts Api.
     *
     * @return Accounts base request builder. {@link AccountsBaseRequestBuilder}
     * @see <a href="https://learn.microsoft.com/en-us/rest/api/azure/devops/account/accounts?view=azure-devops-rest-7.1">Accounts</a>
     */
    @Override
    public AccountsBaseRequestBuilder accounts() {
        var locationUrl = getLocationUrl(ResourceId.ACCOUNT);
        // Remove the organization name from the request url.
        var pathToRemove = URI.create(locationUrl).getPath();
        // Accounts url doesn't return the correct url if send with organization name.
        locationUrl = locationUrl.replace(pathToRemove, "");
        return new AccountsBaseRequestBuilder(locationUrl, accessTokenCredential);
    }

    /**
     * Request builder for artifacts Api.
     *
     * @return Artifacts base request builder. {@link ArtifactsRequestBuilder}
     * @see <a href="https://learn.microsoft.com/en-us/rest/api/azure/devops/artifacts/feed-management?view=azure-devops-rest-7.1">Artifacts</a>
     */
    @Override
    public ArtifactsRequestBuilder artifacts() {
        var locationUrl = getLocationUrl(ResourceId.PACKAGING);
        return new ArtifactsRequestBuilder(locationUrl, accessTokenCredential);
    }

    /**
     * Request builder for build Api.
     *
     * @return Builds base request builder. {@link BuildBaseRequestBuilder}
     * @see <a href="https://learn.microsoft.com/en-us/rest/api/azure/devops/build/?view=azure-devops-rest-7.1">Build</a>
     */
    @Override
    public BuildBaseRequestBuilder build() {
        var locationUrl = getLocationUrl(ResourceId.BUILD);
        return new BuildBaseRequestBuilder(locationUrl, accessTokenCredential);
    }

    /**
     * Request builder for configuring the AzD service client.
     *
     * @return Configuration request builder. {@link ConfigurationRequestBuilder}
     */
    @Override
    public ConfigurationRequestBuilder configuration() {
        return new ConfigurationRequestBuilder();
    }

    /**
     * Request builder for core Api.
     *
     * @return Core request builder. {@link CoreRequestBuilder}
     * @see <a href="https://learn.microsoft.com/en-us/rest/api/azure/devops/core/?view=azure-devops-rest-7.1">Core</a>
     */
    @Override
    public CoreRequestBuilder core() {
        var locationUrl = getLocationUrl(ResourceId.CORE);
        return new CoreRequestBuilder(locationUrl, accessTokenCredential);
    }

    /**
     * Request builder for distributed task Api.
     *
     * @return Distributed task request builder. {@link DistributedTaskRequestBuilder}
     * @see <a href="https://learn.microsoft.com/en-us/rest/api/azure/devops/distributedtask/?view=azure-devops-rest-7.1">Distributed Task</a>
     */
    @Override
    public DistributedTaskRequestBuilder distributedTask() {
        var locationUrl = getLocationUrl(ResourceId.DISTRIBUTED_TASK);
        return new DistributedTaskRequestBuilder(locationUrl, accessTokenCredential);
    }

    /**
     * Request builder for extension management Api.
     *
     * @return Extension management request builder. {@link ExtensionManagementRequestBuilder}
     * @see <a href="https://learn.microsoft.com/en-us/rest/api/azure/devops/extensionmanagement/installed-extensions?view=azure-devops-rest-7.1">Extension Management</a>
     */
    @Override
    public ExtensionManagementRequestBuilder extensionManagement() {
        var locationUrl = getLocationUrl(ResourceId.EXTENSION_MANAGEMENT);
        return new ExtensionManagementRequestBuilder(locationUrl, accessTokenCredential);
    }

    /**
     * Request builder for feature management Api.
     * NOTE: This is an unpublished Api.
     *
     * @return Feature management request builder. {@link FeatureManagementRequestBuilder}
     */
    @Override
    public FeatureManagementRequestBuilder featureManagement() {
        return new FeatureManagementRequestBuilder(organizationUrl, accessTokenCredential);
    }

    /**
     * Organization url.
     *
     * @return Returns the organization url.
     */
    @Override
    public String getOrganizationUrl() {
        return organizationUrl;
    }

    /**
     * Request builder for Git Api.
     *
     * @return Git base request builder. {@link GitBaseRequestBuilder}
     * @see <a href="https://learn.microsoft.com/en-us/rest/api/azure/devops/git/?view=azure-devops-rest-7.1">Git</a>
     */
    @Override
    public GitBaseRequestBuilder git() {
        var locationUrl = getLocationUrl(ResourceId.GIT);
        return new GitBaseRequestBuilder(locationUrl, accessTokenCredential);
    }

    /**
     * Request builder for Graph Api.
     *
     * @return Graph request builder. {@link GraphRequestBuilder}
     * @see <a href="https://learn.microsoft.com/en-us/rest/api/azure/devops/graph/?view=azure-devops-rest-7.1">Graph</a>
     */
    @Override
    public GraphRequestBuilder graph() {
        var locationUrl = getLocationUrl(ResourceId.GRAPH);
        return new GraphRequestBuilder(locationUrl, accessTokenCredential);
    }

    /**
     * Helper class request builder.
     *
     * @return HelpersRequestBuilder {@link HelpersRequestBuilder}
     */
    @Override
    public HelpersRequestBuilder helpers() {
        return new HelpersRequestBuilder(organizationUrl, accessTokenCredential);
    }

    /**
     * Request builder for locations Api.
     *
     * @return Location base request builder. {@link LocationsBaseRequestBuilder}
     */
    @Override
    public LocationsBaseRequestBuilder locations() {
        return new LocationsBaseRequestBuilder(organizationUrl, accessTokenCredential);
    }

    /**
     * Request builder for OAuth access token creation.
     *
     * @return OAuth access token builder.  {@link OAuthAccessTokenBuilder}
     * @see <a href="https://learn.microsoft.com/en-us/azure/devops/integrate/get-started/authentication/oauth?toc=%2Fazure%2Fdevops%2Fmarketplace-extensibility%2Ftoc.json&view=azure-devops">OAuth2.0</a>
     */
    @Override
    public OAuthAccessTokenBuilder oauth() {
        return new OAuthAccessTokenBuilder();
    }

    /**
     * Access token credential object.
     *
     * @return Access token credential object. {@link AccessTokenCredential}
     */
    @Override
    public AccessTokenCredential accessTokenCredential() {
        return accessTokenCredential;
    }

    /**
     * Helper method to create the location url based on resource id.
     *
     * @param resourceId Pass the resource id. {@link ResourceId}
     * @return Location url.
     */
    private String getLocationUrl(String resourceId) {
        return locations().getUrl(resourceId);
    }
}
