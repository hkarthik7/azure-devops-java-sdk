package org.azd.utils;

import org.azd.accounts.AccountsApi;
import org.azd.authentication.OAuthAccessTokenCredential;
import org.azd.authentication.PersonalAccessTokenCredential;
import org.azd.build.BuildApi;
import org.azd.connection.Connection;
import org.azd.core.CoreApi;
import org.azd.distributedtask.DistributedTaskApi;
import org.azd.extensionmanagement.ExtensionManagementApi;
import org.azd.feedmanagement.FeedManagementApi;
import org.azd.git.GitApi;
import org.azd.graph.GraphApi;
import org.azd.interfaces.AccessTokenCredential;
import org.azd.interfaces.AzDClient;
import org.azd.maven.MavenApi;
import org.azd.memberentitlementmanagement.MemberEntitlementManagementApi;
import org.azd.oauth.OAuthApi;
import org.azd.oauth.types.AuthorizedToken;
import org.azd.pipelines.PipelinesApi;
import org.azd.policy.PolicyApi;
import org.azd.release.ReleaseApi;
import org.azd.security.SecurityApi;
import org.azd.serviceclient.AzDServiceClient;
import org.azd.serviceendpoint.ServiceEndpointApi;
import org.azd.servicehooks.ServiceHooksApi;
import org.azd.test.TestApi;
import org.azd.upack.UPackApi;
import org.azd.wiki.WikiApi;
import org.azd.work.WorkApi;
import org.azd.workitemtracking.WorkItemTrackingApi;

/***
 * AzDClientApi class to easily call VSTS REST Api with the connection parameters
 */
public class AzDClientApi implements AzDClient {

    /***
     * Instance of connection object
     */
    private Connection CONNECTION;

    private AccessTokenCredential accessTokenCredential;
    private AzDServiceClient client;

    /***
     * Pass the VSTS organization name and personal access token to create a connection object
     * @param connection Connection object {@link Connection}
     */
    public AzDClientApi(Connection connection) {
        this.CONNECTION = connection;
    }
    public AzDClientApi(final AccessTokenCredential accessTokenCredential) {
        this.accessTokenCredential = accessTokenCredential;
        this.client = new AzDServiceClient(accessTokenCredential);
    }

    /***
     * Pass the VSTS organization name and personal access token to create a connection object
     * @param organizationName VSTS/Azure DevOps services organization name
     * @param personalAccessToken Personal access token
     */
    public AzDClientApi(final String organizationName, final String personalAccessToken) {
        this(new PersonalAccessTokenCredential(organizationName, null, personalAccessToken));
        this.CONNECTION = new Connection(organizationName, personalAccessToken);
    }

    /***
     * Pass the VSTS organization name, project name and personal access token to create a connection object
     * @param organizationName VSTS/Azure DevOps services organization name
     * @param projectName project name
     * @param personalAccessToken Personal access token
     */
    public AzDClientApi(final String organizationName, final String projectName, final String personalAccessToken) {
        this(new PersonalAccessTokenCredential(organizationName, projectName, personalAccessToken));
        this.CONNECTION = new Connection(organizationName, projectName, personalAccessToken);
    }

    /***
     * Pass the VSTS organization name, project name and personal access token to create a connection object
     * @param server TFS server with port number. server:port.
     * @param organizationName VSTS/Azure DevOps services organization name
     * @param projectName project name
     * @param personalAccessToken Personal access token
     */
    public AzDClientApi(final String server, final String organizationName, final String projectName, final String personalAccessToken) {
        this(new PersonalAccessTokenCredential(server, organizationName, projectName, personalAccessToken));
        this.CONNECTION = new Connection(organizationName, projectName, personalAccessToken);
    }

    public AzDClientApi(final String server, final String organization, final String projectName,
                        final String appSecret, final String authCode, final String callbackUrl, final AuthorizedToken authorizedToken) {
        this(new OAuthAccessTokenCredential(server, organization, projectName, appSecret, authCode, callbackUrl, authorizedToken));
    }

    public AzDClientApi(final String organization, final String projectName,
                        final String appSecret, final String authCode, final String callbackUrl) {
        this(new OAuthAccessTokenCredential(null, organization, projectName, appSecret, authCode, callbackUrl, null));
    }

    public void setProject(String project) {
        if (this.accessTokenCredential != null) {
            this.accessTokenCredential.setProjectName(project);
        }
    }

    public String getOrganization() {
        if (this.accessTokenCredential != null) {
            return this.accessTokenCredential.getOrganization();
        }
        return null;
    }

    public void setOrganization(String org) {
        if (this.accessTokenCredential != null) {
            this.accessTokenCredential.setOrganization(org);
        }
    }

    public void setOauthToken(AuthorizedToken token) {
        if (this.CONNECTION != null) {
            this.CONNECTION.setOauthToken(token);
        }
    }

    public void setAccessToken(String accessToken) {
        if (this.accessTokenCredential != null) {
            this.accessTokenCredential.setAccessToken(accessToken);
        }
    }

    public Connection getConnection() {
        return this.CONNECTION;
    }
    public AccessTokenCredential getAccessTokenCredential() {
        return this.accessTokenCredential;
    }

    /***
     * Returns an instance of AccountsApi
     * @return an instance of AccountsApi {@link AccountsApi}
     */
    @Override
    public AccountsApi getAccountsApi() {
        return new AccountsApi(client);
    }

    /***
     * Returns an instance of Build Api
     * @return instance of BuildApi {@link BuildApi}
     */
    @Override
    public BuildApi getBuildApi() {
        return new BuildApi(client);
    }

    /***
     * Returns an instance of Core Api
     * @return instance of CoreApi {@link CoreApi}
     */
    @Override
    public CoreApi getCoreApi() {
        return new CoreApi(client);
    }

    /***
     * Returns an instance of DistributedTask Api
     * @return instance of DistributedTaskApi {@link DistributedTaskApi}
     */

    @Override
    public DistributedTaskApi getDistributedTaskApi() {
        return new DistributedTaskApi(client);
    }

    /***
     * Returns an instance of FeedManagement Api
     * @return instance of Feed management Api {@link FeedManagementApi}
     */
    @Override
    public FeedManagementApi getFeedManagementApi() {
        return new FeedManagementApi(client);
    }

    /***
     * Returns an instance of Git Api
     * @return instance of Git Api {@link GitApi}
     */
    @Override
    public GitApi getGitApi() {
        return new GitApi(CONNECTION);
    }

    /***
     * Returns an instance of GraphApi
     * @return instance of Graph Api {@link GraphApi}
     */
    @Override
    public GraphApi getGraphApi() {
        return new GraphApi(CONNECTION);
    }

    /***
     * Returns an instance of Maven Api
     * @return instance of Maven Api {@link MavenApi}
     */
    @Override
    public MavenApi getMavenApi() {
        return new MavenApi(CONNECTION);
    }

    /***
     * Returns an instance of Member Entitlement management Api
     * @return instance of Member Entitle management Api {@link MemberEntitlementManagementApi}
     */
    @Override
    public MemberEntitlementManagementApi getMemberEntitlementManagementApi() {
        return new MemberEntitlementManagementApi(CONNECTION);
    }

    /***
     * Returns an instance of Release Api
     * @return instance of Release Api {@link ReleaseApi}
     */
    @Override
    public ReleaseApi getReleaseApi() {
        return new ReleaseApi(CONNECTION);
    }

    /***
     * Returns an instance of Service Hooks Api
     * @return instance of Service Hooks Api {@link ServiceHooksApi}
     */
    @Override
    public ServiceHooksApi getServiceHooksApi() {
        return new ServiceHooksApi(CONNECTION);
    }

    /***
     * Returns an instance of WikiApi
     * @return instance of Wiki Api {@link WikiApi}
     */
    @Override
    public WikiApi getWikiApi() {
        return new WikiApi(CONNECTION);
    }

    /***
     * Returns an instance of Work Api
     * @return instance of Work Api {@link WorkApi}
     */
    @Override
    public WorkApi getWorkApi() {
        return new WorkApi(CONNECTION);
    }

    /***
     * Returns an instance of Work item tracking Api
     * @return instance of work item tracking Api {@link WorkItemTrackingApi}
     */
    @Override
    public WorkItemTrackingApi getWorkItemTrackingApi() {
        return new WorkItemTrackingApi(CONNECTION);
    }

    /***
     * Returns an instance of OAuth Api
     * @return instance of OAuth Api {@link OAuthApi}
     */
    @Override
    public OAuthApi getOAuth() {
        return new OAuthApi();
    }

    /***
     * Returns an instance of Service endpoint Api
     * @return instance of ServiceEndpointApi {@link ServiceEndpointApi}
     */
    @Override
    public ServiceEndpointApi getServiceEndpointApi() {
        return new ServiceEndpointApi(CONNECTION);
    }

    /***
     * Returns an instance of Extension management Api
     * @return instance of ExtensionManagementApi {@link ExtensionManagementApi}
     */
    @Override
    public ExtensionManagementApi getExtensionManagementApi() {
        return new ExtensionManagementApi(client);
    }

    /***
     * Returns an instance of Policy Api
     * @return instance of PolicyApi {@link PolicyApi}
     */
    @Override
    public PolicyApi getPolicyApi() {
        return new PolicyApi(CONNECTION);
    }

    /***
     * Returns an instance of Pipelines Api
     * @return instance of PipelinesApi {@link PipelinesApi}
     */
    @Override
    public PipelinesApi getPipelinesApi() {
        return new PipelinesApi(CONNECTION);
    }

    /***
     * Returns an instance of Universal Package Api
     * @return instance of UPackApi {@link UPackApi}
     */
    @Override
    public UPackApi getUPackApi() {
        return new UPackApi(CONNECTION);
    }

    /***
     * Returns an instance of security api
     * @return instance of securityApi {@link SecurityApi}
     */
    @Override
    public SecurityApi getSecurityApi() {
        return new SecurityApi(CONNECTION);
    }

    /**
     * Returns an instance of Test api
     * @return instance of TestApi {@link TestApi}
     */
    @Override
    public TestApi getTestApi() {
        return new TestApi(CONNECTION);
    }
}
