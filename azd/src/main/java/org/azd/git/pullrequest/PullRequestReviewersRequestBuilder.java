package org.azd.git.pullrequest;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.authentication.AccessTokenCredential;
import org.azd.common.types.Author;
import org.azd.exceptions.AzDException;
import org.azd.git.types.IdentityRefWithVote;
import org.azd.git.types.PullRequestReviewers;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Request builder to manage pull request reviewers Api.
 */
public class PullRequestReviewersRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public PullRequestReviewersRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential, "git", "4b6702c7-aa35-4b89-9c96-b9abf6d3e540");
    }

    /**
     * Add a reviewer to a pull request or cast a vote.
     *
     * @param pullRequestId       ID of the pull request.
     * @param repositoryId        The repository id of the pull request's target branch.
     * @param reviewerId          ID of the reviewer.
     * @param identityRefWithVote Identity reference object to add a reviewer or cast a vote to the pull request.
     * @return PullRequestReviewer {@link IdentityRefWithVote}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<IdentityRefWithVote> createAsync(int pullRequestId, String repositoryId, String reviewerId,
                                                              IdentityRefWithVote identityRefWithVote) throws AzDException {
        return builder()
                .POST(identityRefWithVote)
                .serviceEndpoint("repositoryId", repositoryId)
                .serviceEndpoint("pullRequestId", pullRequestId)
                .serviceEndpoint("reviewerId", reviewerId)
                .build()
                .executeAsync(IdentityRefWithVote.class);
    }

    /**
     * Add reviewers to a pull request.
     *
     * @param pullRequestId ID of the pull request.
     * @param repositoryId  The repository id of the pull request's target branch.
     * @param reviewers     Reviewers to add to the pull request.
     * @return PullRequestReviewers {@link PullRequestReviewers}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<PullRequestReviewers> createAsync(int pullRequestId, String repositoryId, List<Author> reviewers) throws AzDException {
        return builder()
                .POST(reviewers)
                .serviceEndpoint("repositoryId", repositoryId)
                .serviceEndpoint("pullRequestId", pullRequestId)
                .build()
                .executeAsync(PullRequestReviewers.class);
    }

    /**
     * Add an un-materialized identity to the reviewers of a pull request.
     *
     * @param pullRequestId       ID of the pull request.
     * @param repositoryId        The repository id of the pull request's target branch.
     * @param identityRefWithVote Identity reference object to add a reviewer or cast a vote to the pull request.
     * @return PullRequestReviewer {@link IdentityRefWithVote}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<IdentityRefWithVote> createAsync(int pullRequestId, String repositoryId,
                                                              IdentityRefWithVote identityRefWithVote) throws AzDException {
        return builder()
                .PUT(identityRefWithVote)
                .serviceEndpoint("repositoryId", repositoryId)
                .serviceEndpoint("pullRequestId", pullRequestId)
                .build()
                .executeAsync(IdentityRefWithVote.class);
    }

    /**
     * Remove a reviewer from a pull request.
     *
     * @param pullRequestId ID of the pull request.
     * @param repositoryId  The repository id of the pull request's target branch.
     * @param reviewerId    ID of the reviewer.
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<Void> deleteAsync(int pullRequestId, String repositoryId, String reviewerId) throws AzDException {
        return builder()
                .DELETE()
                .serviceEndpoint("repositoryId", repositoryId)
                .serviceEndpoint("pullRequestId", pullRequestId)
                .serviceEndpoint("reviewerId", reviewerId)
                .build()
                .executePrimitiveAsync();
    }

    /**
     * Retrieve information about a particular reviewer on a pull request
     *
     * @param pullRequestId ID of the pull request.
     * @param repositoryId  The repository id of the pull request's target branch.
     * @param reviewerId    ID of the reviewer.
     * @return PullRequestReviewer {@link IdentityRefWithVote}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<IdentityRefWithVote> getAsync(int pullRequestId, String repositoryId, String reviewerId) throws AzDException {
        return builder()
                .serviceEndpoint("repositoryId", repositoryId)
                .serviceEndpoint("pullRequestId", pullRequestId)
                .serviceEndpoint("reviewerId", reviewerId)
                .build()
                .executeAsync(IdentityRefWithVote.class);
    }

    /**
     * Retrieve the reviewers for a pull request
     *
     * @param pullRequestId ID of the pull request.
     * @param repositoryId  The repository id of the pull request's target branch.
     * @return List of PullRequestReviewer {@link PullRequestReviewers}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<PullRequestReviewers> listAsync(int pullRequestId, String repositoryId) throws AzDException {
        return builder()
                .serviceEndpoint("repositoryId", repositoryId)
                .serviceEndpoint("pullRequestId", pullRequestId)
                .build()
                .executeAsync(PullRequestReviewers.class);
    }

    /**
     * Edit a reviewer entry. These fields are patchable: isFlagged, hasDeclined
     *
     * @param pullRequestId       ID of the pull request.
     * @param repositoryId        The repository id of the pull request's target branch.
     * @param reviewerId          ID of the reviewer.
     * @param identityRefWithVote Identity reference object to update.
     * @return PullRequestReviewer {@link IdentityRefWithVote}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<IdentityRefWithVote> updateAsync(int pullRequestId, String repositoryId, String reviewerId,
                                                              IdentityRefWithVote identityRefWithVote) throws AzDException {
        return builder()
                .PATCH(identityRefWithVote)
                .serviceEndpoint("repositoryId", repositoryId)
                .serviceEndpoint("pullRequestId", pullRequestId)
                .serviceEndpoint("reviewerId", reviewerId)
                .build()
                .executeAsync(IdentityRefWithVote.class);
    }

    /**
     * Reset the votes of multiple reviewers on a pull request.
     * NOTE: This endpoint only supports updating votes, but does not support updating required reviewers (use policy) or display names.
     *
     * @param pullRequestId        ID of the pull request.
     * @param repositoryId         The repository id of the pull request's target branch.
     * @param identityRefWithVotes Identity reference collection to update.
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<Void> updateAsync(int pullRequestId, String repositoryId,
                                               List<IdentityRefWithVote> identityRefWithVotes) throws AzDException {
        return builder()
                .PATCH(identityRefWithVotes)
                .serviceEndpoint("repositoryId", repositoryId)
                .serviceEndpoint("pullRequestId", pullRequestId)
                .build()
                .executePrimitiveAsync();
    }

    /**
     * Add a reviewer to a pull request or cast a vote.
     *
     * @param pullRequestId       ID of the pull request.
     * @param repositoryId        The repository id of the pull request's target branch.
     * @param reviewerId          ID of the reviewer.
     * @param identityRefWithVote Identity reference object to add a reviewer or cast a vote to the pull request.
     * @return PullRequestReviewer {@link IdentityRefWithVote}
     * @throws AzDException Default Api Exception handler.
     */
    public IdentityRefWithVote create(int pullRequestId, String repositoryId, String reviewerId,
                                      IdentityRefWithVote identityRefWithVote) throws AzDException {
        return builder()
                .POST(identityRefWithVote)
                .serviceEndpoint("repositoryId", repositoryId)
                .serviceEndpoint("pullRequestId", pullRequestId)
                .serviceEndpoint("reviewerId", reviewerId)
                .build()
                .execute(IdentityRefWithVote.class);
    }

    /**
     * Add reviewers to a pull request.
     *
     * @param pullRequestId ID of the pull request.
     * @param repositoryId  The repository id of the pull request's target branch.
     * @param reviewers     Reviewers to add to the pull request.
     * @return PullRequestReviewers {@link PullRequestReviewers}
     * @throws AzDException Default Api Exception handler.
     */
    public PullRequestReviewers create(int pullRequestId, String repositoryId, List<Author> reviewers) throws AzDException {
        return builder()
                .POST(reviewers)
                .serviceEndpoint("repositoryId", repositoryId)
                .serviceEndpoint("pullRequestId", pullRequestId)
                .build()
                .execute(PullRequestReviewers.class);
    }

    /**
     * Add an un-materialized identity to the reviewers of a pull request.
     *
     * @param pullRequestId       ID of the pull request.
     * @param repositoryId        The repository id of the pull request's target branch.
     * @param identityRefWithVote Identity reference object to add a reviewer or cast a vote to the pull request.
     * @return PullRequestReviewer {@link IdentityRefWithVote}
     * @throws AzDException Default Api Exception handler.
     */
    public IdentityRefWithVote create(int pullRequestId, String repositoryId,
                                      IdentityRefWithVote identityRefWithVote) throws AzDException {
        return builder()
                .PUT(identityRefWithVote)
                .serviceEndpoint("repositoryId", repositoryId)
                .serviceEndpoint("pullRequestId", pullRequestId)
                .build()
                .execute(IdentityRefWithVote.class);
    }

    /**
     * Remove a reviewer from a pull request.
     *
     * @param pullRequestId ID of the pull request.
     * @param repositoryId  The repository id of the pull request's target branch.
     * @param reviewerId    ID of the reviewer.
     * @throws AzDException Default Api Exception handler.
     */
    public Void delete(int pullRequestId, String repositoryId, String reviewerId) throws AzDException {
        return builder()
                .DELETE()
                .serviceEndpoint("repositoryId", repositoryId)
                .serviceEndpoint("pullRequestId", pullRequestId)
                .serviceEndpoint("reviewerId", reviewerId)
                .build()
                .executePrimitive();
    }

    /**
     * Retrieve information about a particular reviewer on a pull request
     *
     * @param pullRequestId ID of the pull request.
     * @param repositoryId  The repository id of the pull request's target branch.
     * @param reviewerId    ID of the reviewer.
     * @return PullRequestReviewer {@link IdentityRefWithVote}
     * @throws AzDException Default Api Exception handler.
     */
    public IdentityRefWithVote get(int pullRequestId, String repositoryId, String reviewerId) throws AzDException {
        return builder()
                .serviceEndpoint("repositoryId", repositoryId)
                .serviceEndpoint("pullRequestId", pullRequestId)
                .serviceEndpoint("reviewerId", reviewerId)
                .build()
                .execute(IdentityRefWithVote.class);
    }

    /**
     * Retrieve the reviewers for a pull request
     *
     * @param pullRequestId ID of the pull request.
     * @param repositoryId  The repository id of the pull request's target branch.
     * @return List of PullRequestReviewer {@link PullRequestReviewers}
     * @throws AzDException Default Api Exception handler.
     */
    public PullRequestReviewers list(int pullRequestId, String repositoryId) throws AzDException {
        return builder()
                .serviceEndpoint("repositoryId", repositoryId)
                .serviceEndpoint("pullRequestId", pullRequestId)
                .build()
                .execute(PullRequestReviewers.class);
    }

    /**
     * Edit a reviewer entry. These fields are patchable: isFlagged, hasDeclined
     *
     * @param pullRequestId       ID of the pull request.
     * @param repositoryId        The repository id of the pull request's target branch.
     * @param reviewerId          ID of the reviewer.
     * @param identityRefWithVote Identity reference object to update.
     * @return PullRequestReviewer {@link IdentityRefWithVote}
     * @throws AzDException Default Api Exception handler.
     */
    public IdentityRefWithVote update(int pullRequestId, String repositoryId, String reviewerId,
                                      IdentityRefWithVote identityRefWithVote) throws AzDException {
        return builder()
                .PATCH(identityRefWithVote)
                .serviceEndpoint("repositoryId", repositoryId)
                .serviceEndpoint("pullRequestId", pullRequestId)
                .serviceEndpoint("reviewerId", reviewerId)
                .build()
                .execute(IdentityRefWithVote.class);
    }

    /**
     * Reset the votes of multiple reviewers on a pull request.
     * NOTE: This endpoint only supports updating votes, but does not support updating required reviewers (use policy) or display names.
     *
     * @param pullRequestId        ID of the pull request.
     * @param repositoryId         The repository id of the pull request's target branch.
     * @param identityRefWithVotes Identity reference collection to update.
     * @throws AzDException Default Api Exception handler.
     */
    public Void update(int pullRequestId, String repositoryId,
                       List<IdentityRefWithVote> identityRefWithVotes) throws AzDException {
        return builder()
                .PATCH(identityRefWithVotes)
                .serviceEndpoint("repositoryId", repositoryId)
                .serviceEndpoint("pullRequestId", pullRequestId)
                .build()
                .executePrimitive();
    }

}
