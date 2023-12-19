package org.azd.git.pullrequest;

import org.azd.interfaces.AccessTokenCredential;
import org.azd.interfaces.RequestAdapter;
import org.azd.utils.BaseRequestBuilder;

/**
 * Request builder to manage Apis associated with pull request.
 */
public class PullRequestBaseRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new request builder instance and sets the default values.
     * @param accessTokenCredential Authentication provider {@link AccessTokenCredential}.
     * @param requestAdapter The request adapter to execute the requests.
     */
    public PullRequestBaseRequestBuilder(AccessTokenCredential accessTokenCredential, RequestAdapter requestAdapter) {
        super(accessTokenCredential, requestAdapter);
    }

    /**
     * Provides functionality to manage Pull request work items Api.
     * @return PullRequestWorkItemsRequestBuilder {@link PullRequestWorkItemsRequestBuilder}
     */
    public PullRequestWorkItemsRequestBuilder workItems() {
        return new PullRequestWorkItemsRequestBuilder(accessTokenCredential, requestAdapter);
    }

    /**
     * Provides functionality to manage Pull request labels Api.
     * @return PullRequestLabelsRequestBuilder {@link PullRequestLabelsRequestBuilder}
     */
    public PullRequestLabelsRequestBuilder labels() {
        return new PullRequestLabelsRequestBuilder(accessTokenCredential, requestAdapter);
    }

    /**
     * Provides functionality to manage Pull request reviewers Api.
     * @return PullRequestReviewerRequestBuilder {@link PullRequestReviewerRequestBuilder}
     */
    public PullRequestReviewerRequestBuilder reviewers() {
        return new PullRequestReviewerRequestBuilder(accessTokenCredential, requestAdapter);
    }
}
