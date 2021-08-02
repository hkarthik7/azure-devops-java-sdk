package org.azd.utils;

import org.azd.accounts.AccountsApi;
import org.azd.build.BuildApi;
import org.azd.connection.Connection;
import org.azd.core.CoreApi;
import org.azd.feedmanagement.FeedManagementApi;
import org.azd.git.GitApi;
import org.azd.graph.GraphApi;
import org.azd.interfaces.AzDClient;
import org.azd.memberentitlementmanagement.MemberEntitlementManagementApi;
import org.azd.release.ReleaseApi;
import org.azd.servicehooks.ServiceHooksApi;
import org.azd.wiki.WikiApi;
import org.azd.work.WorkApi;
import org.azd.workitemtracking.WorkItemTrackingApi;

public class AzDClientApi implements AzDClient {

    private final Connection CONNECTION;

    public AzDClientApi(String organizationName, String personalAccessToken) {
        var connection = new Connection(organizationName, personalAccessToken);
        this.CONNECTION = connection;
    }

    public AzDClientApi(String organizationName, String projectName, String personalAccessToken) {
        var connection = new Connection(organizationName, projectName, personalAccessToken);
        this.CONNECTION = connection;
    }

    @Override
    public AccountsApi getAccountsApi() { return new AccountsApi(CONNECTION); }

    @Override
    public BuildApi getBuildApi() {
        return new BuildApi(CONNECTION);
    }

    @Override
    public CoreApi getCoreApi() {
        return new CoreApi(CONNECTION);
    }

    @Override
    public FeedManagementApi getFeedManagementApi() {
        return new FeedManagementApi(CONNECTION);
    }

    @Override
    public GitApi getGitApi() { return new GitApi(CONNECTION); }

    @Override
    public GraphApi getGraphApi() { return new GraphApi(CONNECTION); }

    @Override
    public MemberEntitlementManagementApi getMemberEntitlementManagementApi() { return new MemberEntitlementManagementApi(CONNECTION); }

    @Override
    public ReleaseApi getReleaseApi() { return new ReleaseApi(CONNECTION); }

    @Override
    public ServiceHooksApi getServiceHooksApi() { return new ServiceHooksApi(CONNECTION); }

    @Override
    public WikiApi getWikiApi() { return new WikiApi(CONNECTION); }

    @Override
    public WorkApi getWorkApi() { return new WorkApi(CONNECTION); }

    @Override
    public WorkItemTrackingApi getWorkItemTrackingApi() { return new WorkItemTrackingApi(CONNECTION); }
}
