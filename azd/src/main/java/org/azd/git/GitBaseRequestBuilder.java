package org.azd.git;

import org.azd.git.pullrequests.PullRequestsRequestBuilder;
import org.azd.git.repositories.RepositoriesRequestBuilder;
import org.azd.interfaces.AccessTokenCredential;
import org.azd.interfaces.RequestAdapter;
import org.azd.utils.BaseRequestBuilder;

/**
 * Provides functionality to build requests for managing Git Api.
 */
public class GitBaseRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new request builder instance and sets the default values.
     * @param accessTokenCredential Authentication provider {@link AccessTokenCredential}.
     * @param requestAdapter The request adapter to execute the requests.
     */
    public GitBaseRequestBuilder(AccessTokenCredential accessTokenCredential, RequestAdapter requestAdapter) {
        super(accessTokenCredential, requestAdapter);
    }

    /**
     * Provides functionality to manage Repositories Api.
     * @return RepositoriesRequestBuilder {@link RepositoriesRequestBuilder}
     */
    public RepositoriesRequestBuilder repositories() {
        return new RepositoriesRequestBuilder(accessTokenCredential, requestAdapter);
    }

    /**
     * Provides functionality to manage Repositories Api.
     * @return RepositoriesRequestBuilder {@link RepositoriesRequestBuilder}
     */
    public PullRequestsRequestBuilder pullRequests() {
        return new PullRequestsRequestBuilder(accessTokenCredential, requestAdapter);
    }
}
