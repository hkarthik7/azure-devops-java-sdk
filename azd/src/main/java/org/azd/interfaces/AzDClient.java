package org.azd.interfaces;

import org.azd.accounts.AccountsApi;
import org.azd.build.BuildApi;
import org.azd.core.CoreApi;
import org.azd.distributedtask.DistributedTaskApi;
import org.azd.extensionmanagement.ExtensionManagementApi;
import org.azd.feedmanagement.FeedManagementApi;
import org.azd.git.GitApi;
import org.azd.graph.GraphApi;
import org.azd.maven.MavenApi;
import org.azd.memberentitlementmanagement.MemberEntitlementManagementApi;
import org.azd.oauth.OAuthApi;
import org.azd.pipelines.PipelinesApi;
import org.azd.policy.PolicyApi;
import org.azd.release.ReleaseApi;
import org.azd.security.SecurityApi;
import org.azd.serviceendpoint.ServiceEndpointApi;
import org.azd.servicehooks.ServiceHooksApi;
import org.azd.upack.UPackApi;
import org.azd.wiki.WikiApi;
import org.azd.work.WorkApi;
import org.azd.workitemtracking.WorkItemTrackingApi;

public interface AzDClient {
    AccountsApi getAccountsApi();

    BuildApi getBuildApi();

    CoreApi getCoreApi();

    DistributedTaskApi getDistributedTaskApi();

    FeedManagementApi getFeedManagementApi();

    GitApi getGitApi();

    GraphApi getGraphApi();

    MavenApi getMavenApi();

    MemberEntitlementManagementApi getMemberEntitlementManagementApi();

    ReleaseApi getReleaseApi();

    ServiceHooksApi getServiceHooksApi();

    WikiApi getWikiApi();

    WorkApi getWorkApi();

    WorkItemTrackingApi getWorkItemTrackingApi();

    OAuthApi getOAuth();

    ServiceEndpointApi getServiceEndpointApi();

    ExtensionManagementApi getExtensionManagementApi();

    PolicyApi getPolicyApi();

    PipelinesApi getPipelinesApi();

    UPackApi getUPackApi();

    SecurityApi getSecurityApi();
}
