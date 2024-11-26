package org.azd.interfaces;

import org.azd.accounts.AccountsApi;
import org.azd.build.BuildApi;
import org.azd.connection.Connection;
import org.azd.core.CoreApi;
import org.azd.distributedtask.DistributedTaskApi;
import org.azd.extensionmanagement.ExtensionManagementApi;
import org.azd.feedmanagement.FeedManagementApi;
import org.azd.git.GitApi;
import org.azd.graph.GraphApi;
import org.azd.maven.MavenApi;
import org.azd.memberentitlementmanagement.MemberEntitlementManagementApi;
import org.azd.oauth.OAuthApi;
import org.azd.oauth.types.AuthorizedToken;
import org.azd.pipelines.PipelinesApi;
import org.azd.policy.PolicyApi;
import org.azd.release.ReleaseApi;
import org.azd.security.SecurityApi;
import org.azd.serviceendpoint.ServiceEndpointApi;
import org.azd.servicehooks.ServiceHooksApi;
import org.azd.test.TestApi;
import org.azd.upack.UPackApi;
import org.azd.wiki.WikiApi;
import org.azd.work.WorkApi;
import org.azd.workitemtracking.WorkItemTrackingApi;

public interface AzDClient {
    AccountsDetails getAccountsApi();

    BuildDetails getBuildApi();

    CoreDetails getCoreApi();

    DistributedTaskDetails getDistributedTaskApi();

    FeedManagementDetails getFeedManagementApi();

    GitDetails getGitApi();

    GraphDetails getGraphApi();

    MavenDetails getMavenApi();

    MemberEntitlementManagementDetails getMemberEntitlementManagementApi();

    ReleaseDetails getReleaseApi();

    ServiceHooksDetails getServiceHooksApi();

    WikiDetails getWikiApi();

    WorkDetails getWorkApi();

    WorkItemTrackingDetails getWorkItemTrackingApi();

    OAuthApi getOAuth();

    ServiceEndpointDetails getServiceEndpointApi();

    ExtensionManagementDetails getExtensionManagementApi();

    PolicyDetails getPolicyApi();

    PipelinesDetails getPipelinesApi();

    UpackDetails getUPackApi();

    SecurityDetails getSecurityApi();

    TestDetails getTestApi();

    void setProject(String project);

    String getOrganization();

    void setOrganization(String org);

    void setOauthToken(AuthorizedToken token);

    Connection getConnection();
}
