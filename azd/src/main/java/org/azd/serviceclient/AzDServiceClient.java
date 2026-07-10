package org.azd.serviceclient;

import org.azd.accounts.AccountsRequestBuilder;
import org.azd.artifacts.ArtifactsRequestBuilder;
import org.azd.artifactspackagetypes.ArtifactsPackageTypesRequestBuilder;
import org.azd.authentication.AccessTokenCredential;
import org.azd.build.BuildBaseRequestBuilder;
import org.azd.configurations.ClientConfigurationRequestBuilder;
import org.azd.core.CoreRequestBuilder;
import org.azd.dashboard.DashboardRequestBuilder;
import org.azd.distributedtask.DistributedTaskRequestBuilder;
import org.azd.exceptions.AzDException;
import org.azd.extensionmanagement.ExtensionManagementRequestBuilder;
import org.azd.featuremanagement.FeatureManagementRequestBuilder;
import org.azd.git.GitBaseRequestBuilder;
import org.azd.graph.GraphRequestBuilder;
import org.azd.helpers.HelpersRequestBuilder;
import org.azd.locations.LocationsBaseRequestBuilder;
import org.azd.memberentitlementmanagement.MemberEntitlementManagementRequestBuilder;
import org.azd.oauth.OAuthAccessTokenBuilder;
import org.azd.pipelines.PipelinesBaseRequestBuilder;
import org.azd.policy.PolicyRequestBuilder;
import org.azd.release.ReleaseBaseRequestBuilder;
import org.azd.security.SecurityRequestBuilder;
import org.azd.serviceendpoint.ServiceEndpointRequestBuilder;
import org.azd.servicehooks.ServiceHooksRequestBuilder;
import org.azd.test.TestRequestBuilder;
import org.azd.wiki.WikiRequestBuilder;
import org.azd.work.WorkRequestBuilder;
import org.azd.workitemtracking.WorkItemTrackingRequestBuilder;

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
     * @return Accounts base request builder. {@link AccountsRequestBuilder}
     * @see <a href="https://learn.microsoft.com/en-us/rest/api/azure/devops/account/accounts?view=azure-devops-rest-7.1">Accounts</a>
     * @throws AzDException Default Api exception handler
     */
    AccountsRequestBuilder accounts() throws AzDException;

    /**
     * Request builder for artifacts Api.
     *
     * @return Artifacts base request builder. {@link ArtifactsRequestBuilder}
     * @see <a href="https://learn.microsoft.com/en-us/rest/api/azure/devops/artifacts/feed-management?view=azure-devops-rest-7.1">Artifacts</a>
     * @throws AzDException Default Api exception handler
     */

    ArtifactsRequestBuilder artifacts() throws AzDException;

    /**
     * Request builder for artifacts package types Api.
     *
     * @return Artifacts Package Types base request builder. {@link ArtifactsPackageTypesRequestBuilder}
     * @see <a href="https://learn.microsoft.com/en-us/rest/api/azure/devops/artifactspackagetypes/maven?view=azure-devops-rest-7.1">Artifacts Package Types</a>
     * @throws AzDException Default Api exception handler
     */
    ArtifactsPackageTypesRequestBuilder artifactsPackageTypes() throws AzDException;

    /**
     * Request builder for build Api.
     *
     * @return Builds base request builder. {@link BuildBaseRequestBuilder}
     * @see <a href="https://learn.microsoft.com/en-us/rest/api/azure/devops/build/?view=azure-devops-rest-7.1">Build</a>
     * @throws AzDException Default Api exception handler
     */
    BuildBaseRequestBuilder build() throws AzDException;

    /**
     * Request builder for configuring the AzD service client.
     *
     * @return Configuration request builder. {@link ClientConfigurationRequestBuilder}
     * @throws AzDException Default Api exception handler
     */
    ClientConfigurationRequestBuilder configuration() throws AzDException;

    /**
     * Request builder for core Api.
     *
     * @return Core request builder. {@link CoreRequestBuilder}
     * @see <a href="https://learn.microsoft.com/en-us/rest/api/azure/devops/core/?view=azure-devops-rest-7.1">Core</a>
     * @throws AzDException Default Api exception handler
     */
    CoreRequestBuilder core() throws AzDException;

    /**
     * Request builder for Dashboard Api.
     *
     * @return Dashboard request builder. {@link DashboardRequestBuilder}
     * @see <a href="https://learn.microsoft.com/en-us/rest/api/azure/devops/dashboard/?view=azure-devops-rest-7.2">Dashboard</a>
     * @throws AzDException Default Api exception handler
     */
    DashboardRequestBuilder dashboard() throws AzDException;

    /**
     * Request builder for distributed task Api.
     *
     * @return Distributed task request builder. {@link DistributedTaskRequestBuilder}
     * @see <a href="https://learn.microsoft.com/en-us/rest/api/azure/devops/distributedtask/?view=azure-devops-rest-7.1">Distributed Task</a>
     * @throws AzDException Default Api exception handler
     */
    DistributedTaskRequestBuilder distributedTask() throws AzDException;

    /**
     * Request builder for extension management Api.
     *
     * @return Extension management request builder. {@link ExtensionManagementRequestBuilder}
     * @see <a href="https://learn.microsoft.com/en-us/rest/api/azure/devops/extensionmanagement/installed-extensions?view=azure-devops-rest-7.1">Extension Management</a>
     * @throws AzDException Default Api exception handler
     */
    ExtensionManagementRequestBuilder extensionManagement() throws AzDException;

    /**
     * Request builder for feature management Api.
     * NOTE: This is an unpublished Api.
     *
     * @return Feature management request builder. {@link FeatureManagementRequestBuilder}
     * @throws AzDException Default Api exception handler
     */
    FeatureManagementRequestBuilder featureManagement() throws AzDException;

    /**
     * Organization url.
     *
     * @return Returns the organization url.
     */
    String getOrganizationUrl() throws AzDException;

    /**
     * Request builder for Git Api.
     *
     * @return Git base request builder. {@link GitBaseRequestBuilder}
     * @see <a href="https://learn.microsoft.com/en-us/rest/api/azure/devops/git/?view=azure-devops-rest-7.1">Git</a>
     * @throws AzDException Default Api exception handler
     */
    GitBaseRequestBuilder git() throws AzDException;

    /**
     * Request builder for Graph Api.
     *
     * @return Graph request builder. {@link GraphRequestBuilder}
     * @see <a href="https://learn.microsoft.com/en-us/rest/api/azure/devops/graph/?view=azure-devops-rest-7.1">Graph</a>
     * @throws AzDException Default Api exception handler
     */
    GraphRequestBuilder graph() throws AzDException;

    /**
     * Helper class request builder.
     *
     * @return HelpersRequestBuilder {@link HelpersRequestBuilder}
     */
    HelpersRequestBuilder helpers() throws AzDException;

    /**
     * Request builder for locations Api.
     *
     * @return Location base request builder. {@link LocationsBaseRequestBuilder}
     * @throws AzDException Default Api exception handler
     */
    LocationsBaseRequestBuilder locations() throws AzDException;

    /**
     * Request builder for Member entitlement management Api.
     *
     * @return Member entitlement management request builder. {@link MemberEntitlementManagementRequestBuilder}
     * @see <a href="https://learn.microsoft.com/en-us/rest/api/azure/devops/memberentitlementmanagement/?view=azure-devops-rest-7.1">Member Entitlement Management</a>
     * @throws AzDException Default Api exception handler
     */
    MemberEntitlementManagementRequestBuilder memberEntitlementManagement() throws AzDException;

    /**
     * Request builder for OAuth access token creation.
     *
     * @return OAuth access token builder.  {@link OAuthAccessTokenBuilder}
     * @see <a href="https://learn.microsoft.com/en-us/azure/devops/integrate/get-started/authentication/oauth?toc=%2Fazure%2Fdevops%2Fmarketplace-extensibility%2Ftoc.json&view=azure-devops">OAuth2.0</a>
     */
    OAuthAccessTokenBuilder oauth();

    /**
     * Request builder for Pipelines Api.
     *
     * @return Pipelines request builder. {@link PipelinesBaseRequestBuilder}
     * @see <a href="https://learn.microsoft.com/en-us/rest/api/azure/devops/pipelines/?view=azure-devops-rest-7.1">Pipelines</a>
     * @throws AzDException Default Api exception handler
     */
    PipelinesBaseRequestBuilder pipelines() throws AzDException;

    /**
     * Request builder for Policy Api.
     *
     * @return Policy request builder {@link PolicyRequestBuilder}
     * @see <a href="https://learn.microsoft.com/en-us/rest/api/azure/devops/policy/?view=azure-devops-rest-7.1">Policy</a>
     * @throws AzDException Default Api exception handler
     */
    PolicyRequestBuilder policy() throws AzDException;

    /**
     * Request builder for Release Api.
     *
     * @return Release Request builder {@link ReleaseBaseRequestBuilder}
     * @throws AzDException Default Api exception handler
     */
    ReleaseBaseRequestBuilder release() throws AzDException;

    /**
     * Request builder for Security Api.
     *
     * @return Security Request builder {@link SecurityRequestBuilder}
     * @throws AzDException Default Api exception handler
     */
    SecurityRequestBuilder security() throws AzDException;

    /**
     * Request builder for Service endpoint Api.
     *
     * @return Service endpoint Request builder {@link ServiceEndpointRequestBuilder}
     * @throws AzDException Default Api exception handler
     */
    ServiceEndpointRequestBuilder serviceEndpoint() throws AzDException;

    /**
     * Request builder for Service hooks Api.
     *
     * @return Service hooks Request builder {@link ServiceHooksRequestBuilder}
     * @throws AzDException Default Api exception handler
     */
    ServiceHooksRequestBuilder serviceHooks() throws AzDException;

    /**
     * Request builder for Test Api.
     *
     * @return Test Request builder {@link TestRequestBuilder}
     * @throws AzDException Default Api exception handler
     */
    TestRequestBuilder test() throws AzDException;

    /**
     * Request builder for Wiki Api.
     *
     * @return Wiki Request builder {@link WikiRequestBuilder}
     * @throws AzDException Default Api exception handler
     */
    WikiRequestBuilder wiki() throws AzDException;

    /**
     * Request builder for Work Api.
     *
     * @return Work Request builder {@link WorkRequestBuilder}
     * @throws AzDException Default Api exception handler
     */
    WorkRequestBuilder work() throws AzDException;

    /**
     * Request builder for Work item tracking Api.
     *
     * @return Work item tracking Request builder {@link WorkItemTrackingRequestBuilder}
     * @throws AzDException Default Api exception handler
     */
    WorkItemTrackingRequestBuilder workItemTracking() throws AzDException;
}
