package org.azd.git.pullrequest;

import org.azd.common.ApiVersion;
import org.azd.common.types.Author;
import org.azd.exceptions.AzDException;
import org.azd.git.types.IdentityRefWithVote;
import org.azd.git.types.PullRequestReviewers;
import org.azd.interfaces.AccessTokenCredential;
import org.azd.interfaces.RequestAdapter;
import org.azd.utils.BaseRequestBuilder;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Request builder to manage pull request reviewers Api.
 */
public class PullRequestReviewerRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new request builder instance and sets the default values.
     * @param accessTokenCredential Authentication provider {@link AccessTokenCredential}.
     * @param requestAdapter The request adapter to execute the requests.
     */
    public PullRequestReviewerRequestBuilder(AccessTokenCredential accessTokenCredential, RequestAdapter requestAdapter) {
        super(accessTokenCredential, requestAdapter, "git/repositories", ApiVersion.GIT);
    }

    /***
     * Add a reviewer to a pull request or cast a vote.
     * @param pullRequestId ID of the pull request.
     * @param repositoryId The repository id of the pull request's target branch.
     * @param reviewerId ID of the reviewer.
     * @param identityRefWithVote Identity reference object to add a reviewer or cast a vote to the pull request.
     * @return PullRequestReviewer {@link IdentityRefWithVote}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<IdentityRefWithVote> createAsync(int pullRequestId, String repositoryId, String reviewerId,
                                                              IdentityRefWithVote identityRefWithVote) throws AzDException {
        var reqInfo = toPutRequestInformation(identityRefWithVote);
        reqInfo.serviceEndpoint = getServiceEndpoint(repositoryId, pullRequestId, reviewerId);

        return requestAdapter.sendAsync(reqInfo, IdentityRefWithVote.class);
    }

    /**
     * Add reviewers to a pull request.
     * @param pullRequestId ID of the pull request.
     * @param repositoryId The repository id of the pull request's target branch.
     * @param reviewers Reviewers to add to the pull request.
     * @return PullRequestReviewers {@link PullRequestReviewers}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<PullRequestReviewers> createAsync(int pullRequestId, String repositoryId, List<Author> reviewers) throws AzDException {
        var reqInfo = toPostRequestInformation(reviewers);
        reqInfo.serviceEndpoint = getServiceEndpoint(repositoryId, pullRequestId, null);

        return requestAdapter.sendAsync(reqInfo, PullRequestReviewers.class);
    }

    /***
     * Add an un-materialized identity to the reviewers of a pull request.
     * @param pullRequestId ID of the pull request.
     * @param repositoryId The repository id of the pull request's target branch.
     * @param identityRefWithVote Identity reference object to add a reviewer or cast a vote to the pull request.
     * @return PullRequestReviewer {@link IdentityRefWithVote}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<IdentityRefWithVote> createAsync(int pullRequestId, String repositoryId,
                                                              IdentityRefWithVote identityRefWithVote) throws AzDException {
        var reqInfo = toPutRequestInformation(identityRefWithVote);
        reqInfo.serviceEndpoint = getServiceEndpoint(repositoryId, pullRequestId, null);

        return requestAdapter.sendAsync(reqInfo, IdentityRefWithVote.class);
    }

    /**
     * Remove a reviewer from a pull request.
     * @param pullRequestId ID of the pull request.
     * @param repositoryId The repository id of the pull request's target branch.
     * @param reviewerId ID of the reviewer.
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<Void> deleteAsync(int pullRequestId, String repositoryId, String reviewerId) throws AzDException {
        var reqInfo = toDeleteRequestInformation();
        reqInfo.serviceEndpoint = getServiceEndpoint(repositoryId, pullRequestId, reviewerId);

        return requestAdapter.sendPrimitiveAsync(reqInfo);
    }

    /***
     * Retrieve information about a particular reviewer on a pull request
     * @param pullRequestId ID of the pull request.
     * @param repositoryId The repository id of the pull request's target branch.
     * @param reviewerId ID of the reviewer.
     * @return PullRequestReviewer {@link IdentityRefWithVote}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<IdentityRefWithVote> getAsync(int pullRequestId, String repositoryId, String reviewerId) throws AzDException {
        var reqInfo = toGetRequestInformation();
        reqInfo.serviceEndpoint = getServiceEndpoint(repositoryId, pullRequestId, reviewerId);

        return requestAdapter.sendAsync(reqInfo, IdentityRefWithVote.class);
    }

    /***
     * Retrieve the reviewers for a pull request
     * @param pullRequestId ID of the pull request.
     * @param repositoryId The repository id of the pull request's target branch.
     * @return List of PullRequestReviewer {@link PullRequestReviewers}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<PullRequestReviewers> listAsync(int pullRequestId, String repositoryId) throws AzDException {
        var reqInfo = toGetRequestInformation();
        reqInfo.serviceEndpoint = getServiceEndpoint(repositoryId, pullRequestId, null);

        return requestAdapter.sendAsync(reqInfo, PullRequestReviewers.class);
    }

    /***
     * Edit a reviewer entry. These fields are patchable: isFlagged, hasDeclined
     * @param pullRequestId ID of the pull request.
     * @param repositoryId The repository id of the pull request's target branch.
     * @param reviewerId ID of the reviewer.
     * @param identityRefWithVote Identity reference object to update.
     * @return PullRequestReviewer {@link IdentityRefWithVote}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<IdentityRefWithVote> updateAsync(int pullRequestId, String repositoryId, String reviewerId,
                                                              IdentityRefWithVote identityRefWithVote) throws AzDException {
        var reqInfo = toPatchRequestInformation(identityRefWithVote);
        reqInfo.serviceEndpoint = getServiceEndpoint(repositoryId, pullRequestId, reviewerId);

        return requestAdapter.sendAsync(reqInfo, IdentityRefWithVote.class);
    }

    /***
     * Reset the votes of multiple reviewers on a pull request.
     * NOTE: This endpoint only supports updating votes, but does not support updating required reviewers (use policy) or display names.
     * @param pullRequestId ID of the pull request.
     * @param repositoryId The repository id of the pull request's target branch.
     * @param identityRefWithVotes Identity reference collection to update.
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<Void> updateAsync(int pullRequestId, String repositoryId,
                                                              List<IdentityRefWithVote> identityRefWithVotes) throws AzDException {
        var reqInfo = toPatchRequestInformation(identityRefWithVotes);
        reqInfo.serviceEndpoint = getServiceEndpoint(repositoryId, pullRequestId, null);

        return requestAdapter.sendPrimitiveAsync(reqInfo);
    }

    /**
     * Helper to generate service endpoint based on the resource, id and area passed.
     * @param pullRequestId ID of the pull request.
     * @param repositoryId The repository id of the pull request's target branch.
     * @param reviewerId ID of the reviewer.
     * @return Service endpoint.
     */
    private String getServiceEndpoint(String repositoryId, int pullRequestId, String reviewerId) {
        var endPoint = service + "/" + repositoryId + "/pullRequests/" + pullRequestId + "/reviewers";
        endPoint = reviewerId != null ? endPoint + "/" + reviewerId : endPoint;
        return endPoint;

    }

}
