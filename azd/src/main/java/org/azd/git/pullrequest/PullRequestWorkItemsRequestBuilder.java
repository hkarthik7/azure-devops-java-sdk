package org.azd.git.pullrequest;

import org.azd.common.ApiVersion;
import org.azd.exceptions.AzDException;
import org.azd.git.types.ResourceRefs;
import org.azd.interfaces.AccessTokenCredential;
import org.azd.interfaces.RequestAdapter;
import org.azd.utils.BaseRequestBuilder;

import java.util.concurrent.CompletableFuture;

/**
 * Request builder to manage the work items associated with a pull request.
 */
public class PullRequestWorkItemsRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new request builder instance and sets the default values.
     * @param accessTokenCredential Authentication provider {@link AccessTokenCredential}.
     * @param requestAdapter The request adapter to execute the requests.
     */
    public PullRequestWorkItemsRequestBuilder(AccessTokenCredential accessTokenCredential, RequestAdapter requestAdapter) {
        super(accessTokenCredential, requestAdapter, "git/repositories", ApiVersion.GIT);
    }

    /***
     * Retrieve a list of work items associated with a pull request.
     * @param pullRequestId ID of the pull request.
     * @param repositoryName ID or name of the repository.
     * @return ResourceRefs {@link ResourceRefs}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<ResourceRefs> list(int pullRequestId, String repositoryName) throws AzDException {
        var reqInfo = toGetRequestInformation();
        reqInfo.serviceEndpoint = service + "/" + repositoryName + "/pullRequests/" + pullRequestId + "/workitems";

        return requestAdapter.sendAsync(reqInfo, ResourceRefs.class);
    }

}
