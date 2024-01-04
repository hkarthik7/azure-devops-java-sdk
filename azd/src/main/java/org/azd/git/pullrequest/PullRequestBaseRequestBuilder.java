package org.azd.git.pullrequest;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.authentication.AccessTokenCredential;

/**
 * Request builder to manage Apis associated with pull request.
 */
public class PullRequestBaseRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public PullRequestBaseRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential);

    }

    /**
     * Provides functionality to manage Pull request work items Api.
     *
     * @return PullRequestWorkItemsRequestBuilder {@link PullRequestWorkItemsRequestBuilder}
     */
    public PullRequestWorkItemsRequestBuilder workItems() {
        return new PullRequestWorkItemsRequestBuilder(organizationUrl, accessTokenCredential);
    }

    /**
     * Provides functionality to manage Pull request labels Api.
     *
     * @return PullRequestLabelsRequestBuilder {@link PullRequestLabelsRequestBuilder}
     */
    public PullRequestLabelsRequestBuilder labels() {
        return new PullRequestLabelsRequestBuilder(organizationUrl, accessTokenCredential);
    }

    /**
     * Provides functionality to manage Pull request reviewers Api.
     *
     * @return PullRequestReviewerRequestBuilder {@link PullRequestReviewersRequestBuilder}
     */
    public PullRequestReviewersRequestBuilder reviewers() {
        return new PullRequestReviewersRequestBuilder(organizationUrl, accessTokenCredential);
    }
}

