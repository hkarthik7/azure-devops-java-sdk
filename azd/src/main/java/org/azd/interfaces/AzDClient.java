package org.azd.interfaces;

import org.azd.accounts.AccountsApi;
import org.azd.build.BuildApi;
import org.azd.core.CoreApi;
import org.azd.feedmanagement.FeedManagementApi;
import org.azd.git.GitApi;
import org.azd.graph.GraphApi;
import org.azd.memberentitlementmanagement.MemberEntitlementManagementApi;
import org.azd.oauth.OAuthApi;
import org.azd.release.ReleaseApi;
import org.azd.serviceendpoint.ServiceEndpointApi;
import org.azd.servicehooks.ServiceHooksApi;
import org.azd.wiki.WikiApi;
import org.azd.work.WorkApi;
import org.azd.workitemtracking.WorkItemTrackingApi;

public interface AzDClient {
    AccountsApi getAccountsApi();
    BuildApi getBuildApi();
    CoreApi getCoreApi();
    FeedManagementApi getFeedManagementApi();
    GitApi getGitApi();
    GraphApi getGraphApi();
    MemberEntitlementManagementApi getMemberEntitlementManagementApi();
    ReleaseApi getReleaseApi();
    ServiceHooksApi getServiceHooksApi();
    WikiApi getWikiApi();
    WorkApi getWorkApi();
    WorkItemTrackingApi getWorkItemTrackingApi();
    OAuthApi getOAuth();
    ServiceEndpointApi getServiceEndpointApi();
}
