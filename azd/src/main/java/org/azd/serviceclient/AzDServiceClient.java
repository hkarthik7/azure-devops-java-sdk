package org.azd.serviceclient;

import org.azd.accounts.AccountsBaseRequestBuilder;
import org.azd.artifacts.ArtifactsRequestBuilder;
import org.azd.authentication.AccessTokenCredential;
import org.azd.build.BuildBaseRequestBuilder;
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

/**
 * Client builder for constructing Api specific requests for Azure DevOps services.
 */
public interface AzDServiceClient {
    /**
     * Access token credential object.
     *
     * @return Access token credential object. {@link AccessTokenCredential}
     */
    AccessTokenCredential accessTokenCredential();

    /**
     * Request builder for accounts Api.
     *
     * @return Accounts base request builder. {@link AccountsBaseRequestBuilder}
     * @see <a href="https://learn.microsoft.com/en-us/rest/api/azure/devops/account/accounts?view=azure-devops-rest-7.1">Accounts</a>
     */
    AccountsBaseRequestBuilder accounts();

    /**
     * Request builder for artifacts Api.
     *
     * @return Artifacts base request builder. {@link ArtifactsRequestBuilder}
     * @see <a href="https://learn.microsoft.com/en-us/rest/api/azure/devops/artifacts/feed-management?view=azure-devops-rest-7.1">Artifacts</a>
     */

    ArtifactsRequestBuilder artifacts();

    /**
     * Request builder for build Api.
     *
     * @return Builds base request builder. {@link BuildBaseRequestBuilder}
     * @see <a href="https://learn.microsoft.com/en-us/rest/api/azure/devops/build/?view=azure-devops-rest-7.1">Build</a>
     */
    BuildBaseRequestBuilder build();

    /**
     * Request builder for configuring the AzD service client.
     *
     * @return Configuration request builder. {@link ConfigurationRequestBuilder}
     */
    ConfigurationRequestBuilder configuration();

    /**
     * Request builder for core Api.
     *
     * @return Core request builder. {@link CoreRequestBuilder}
     * @see <a href="https://learn.microsoft.com/en-us/rest/api/azure/devops/core/?view=azure-devops-rest-7.1">Core</a>
     */
    CoreRequestBuilder core();

    /**
     * Request builder for distributed task Api.
     *
     * @return Distributed task request builder. {@link DistributedTaskRequestBuilder}
     * @see <a href="https://learn.microsoft.com/en-us/rest/api/azure/devops/distributedtask/?view=azure-devops-rest-7.1">Distributed Task</a>
     */
    DistributedTaskRequestBuilder distributedTask();

    /**
     * Request builder for extension management Api.
     *
     * @return Extension management request builder. {@link ExtensionManagementRequestBuilder}
     * @see <a href="https://learn.microsoft.com/en-us/rest/api/azure/devops/extensionmanagement/installed-extensions?view=azure-devops-rest-7.1">Extension Management</a>
     */
    ExtensionManagementRequestBuilder extensionManagement();

    /**
     * Request builder for feature management Api.
     * NOTE: This is an unpublished Api.
     *
     * @return Feature management request builder. {@link FeatureManagementRequestBuilder}
     */
    FeatureManagementRequestBuilder featureManagement();

    /**
     * Organization url.
     *
     * @return Returns the organization url.
     */
    String getOrganizationUrl();

    /**
     * Request builder for Git Api.
     *
     * @return Git base request builder. {@link GitBaseRequestBuilder}
     * @see <a href="https://learn.microsoft.com/en-us/rest/api/azure/devops/git/?view=azure-devops-rest-7.1">Git</a>
     */
    GitBaseRequestBuilder git();

    /**
     * Request builder for Graph Api.
     *
     * @return Graph request builder. {@link GraphRequestBuilder}
     * @see <a href="https://learn.microsoft.com/en-us/rest/api/azure/devops/graph/?view=azure-devops-rest-7.1">Graph</a>
     */
    GraphRequestBuilder graph();

    /**
     * Helper class request builder.
     *
     * @return HelpersRequestBuilder {@link HelpersRequestBuilder}
     */
    HelpersRequestBuilder helpers();

    /**
     * Request builder for locations Api.
     *
     * @return Location base request builder. {@link LocationsBaseRequestBuilder}
     */
    LocationsBaseRequestBuilder locations();

    /**
     * Request builder for OAuth access token creation.
     *
     * @return OAuth access token builder.  {@link OAuthAccessTokenBuilder}
     * @see <a href="https://learn.microsoft.com/en-us/azure/devops/integrate/get-started/authentication/oauth?toc=%2Fazure%2Fdevops%2Fmarketplace-extensibility%2Ftoc.json&view=azure-devops">OAuth2.0</a>
     */
    OAuthAccessTokenBuilder oauth();
}
