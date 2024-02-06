package org.azd.git.pullrequests;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.abstractions.QueryParameter;
import org.azd.authentication.AccessTokenCredential;
import org.azd.common.ApiVersion;
import org.azd.enums.PullRequestStatus;
import org.azd.enums.PullRequestTimeRange;
import org.azd.exceptions.AzDException;
import org.azd.git.types.GitPullRequest;
import org.azd.git.types.PullRequests;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

/**
 * Pull requests request builder for managing Git PullRequests API.
 */
public class PullRequestsRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public PullRequestsRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential, "git", "9946fd70-0d40-406e-b686-b4744cbbcc37", ApiVersion.GIT);
    }

    /**
     * Create a pull request.
     *
     * @param repositoryId   id of the repository.
     * @param gitPullRequest a {@link GitPullRequest} object.
     * @return Git pull request object {@link GitPullRequest}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<GitPullRequest> createAsync(String repositoryId, GitPullRequest gitPullRequest,
                                                         Boolean supportsIterations) throws AzDException {
        return builder()
                .POST(gitPullRequest)
                .serviceEndpoint("repositoryId", repositoryId)
                .query("supportsIterations", supportsIterations)
                .build()
                .executeAsync(GitPullRequest.class);
    }

    /**
     * Retrieve a pull request.
     *
     * @param repositoryName The repository name of the pull request's target branch.
     * @param pullRequestId  The ID of the pull request to retrieve.
     * @return {@link GitPullRequest} object
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<GitPullRequest> getAsync(String repositoryName, int pullRequestId) throws AzDException {
        return builder()
                .serviceEndpoint("repositoryId", repositoryName)
                .serviceEndpoint("pullRequestId", pullRequestId)
                .build()
                .executeAsync(GitPullRequest.class);
    }

    /**
     * Retrieve a pull request.
     *
     * @param repositoryName       The repository name of the pull request's target branch.
     * @param pullRequestId        The ID of the pull request to retrieve.
     * @param requestConfiguration Consumer of request configuration. This represents the query parameter for the request.
     * @return {@link GitPullRequest} object
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<GitPullRequest> getAsync(String repositoryName, int pullRequestId,
                                                      Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .serviceEndpoint("repositoryId", repositoryName)
                .serviceEndpoint("pullRequestId", pullRequestId)
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .executeAsync(GitPullRequest.class);
    }

    /**
     * Retrieve a pull request.
     *
     * @param pullRequestId The ID of the pull request to retrieve.
     * @return {@link GitPullRequest} object
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<GitPullRequest> getByIdAsync(int pullRequestId) throws AzDException {
        return builder()
                .location("01a46dea-7d46-4d40-bc84-319e7c260d99")
                .serviceEndpoint("pullRequestId", pullRequestId)
                .build()
                .executeAsync(GitPullRequest.class);
    }

    /**
     * Retrieve all pull requests from a repository
     *
     * @param repositoryName specify the repository name
     * @return {@link PullRequests} object
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<PullRequests> listAsync(String repositoryName) throws AzDException {
        return builder()
                .serviceEndpoint("repositoryId", repositoryName)
                .build()
                .executeAsync(PullRequests.class);
    }

    /**
     * Retrieve all pull requests from a repository
     *
     * @param repositoryName       specify the repository name
     * @param requestConfiguration Consumer of request configuration. This represents the query parameter for the request.
     * @return {@link PullRequests} object
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<PullRequests> listAsync(String repositoryName,
                                                     Consumer<ListRequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .serviceEndpoint("repositoryId", repositoryName)
                .query(ListRequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .executeAsync(PullRequests.class);
    }

    /**
     * Gets all pull requests from a project.
     *
     * @return {@link PullRequests} object
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<PullRequests> listAsync() throws AzDException {
        return builder()
                .location("a5d28130-9cd2-40fa-9f08-902e7daa9efb")
                .build()
                .executeAsync(PullRequests.class);
    }

    /**
     * Gets all pull requests from a project.
     *
     * @param requestConfiguration Consumer of request configuration. This represents the query parameter for the request.
     * @return {@link PullRequests} object
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<PullRequests> listAsync(Consumer<ListRequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .location("a5d28130-9cd2-40fa-9f08-902e7daa9efb")
                .query(ListRequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .executeAsync(PullRequests.class);
    }

    /**
     * Update a pull request
     * <p>
     * These are the properties that can be updated with the API:
     * Status
     * Title
     * Description (up to 4000 characters)
     * CompletionOptions
     * MergeOptions
     * AutoCompleteSetBy.Id
     * TargetRefName (when the PR retargeting feature is enabled)
     * Attempting to update other properties outside of this list will either cause the server
     * to throw an InvalidArgumentValueException, or to silently ignore the update.
     * </p>
     *
     * @param pullRequestId  ID of the pull request to update.
     * @param repositoryId   The repository ID of the pull request's target branch.
     * @param gitPullRequest Git pull request object to update.
     * @return GitPullRequest Object {@link GitPullRequest}
     * @throws AzDException Default Api Exception handler.
     **/
    public CompletableFuture<GitPullRequest> updateAsync(String repositoryId, int pullRequestId, GitPullRequest gitPullRequest)
            throws AzDException {
        return builder()
                .PATCH(gitPullRequest)
                .serviceEndpoint("repositoryId", repositoryId)
                .serviceEndpoint("pullRequestId", pullRequestId)
                .build()
                .executeAsync(GitPullRequest.class);
    }

    /**
     * Create a pull request.
     *
     * @param repositoryId   id of the repository.
     * @param gitPullRequest a {@link GitPullRequest} object.
     * @return Git pull request object {@link GitPullRequest}
     * @throws AzDException Default Api Exception handler.
     */
    public GitPullRequest create(String repositoryId, GitPullRequest gitPullRequest,
                                 Boolean supportsIterations) throws AzDException {
        return builder()
                .POST(gitPullRequest)
                .serviceEndpoint("repositoryId", repositoryId)
                .query("supportsIterations", supportsIterations)
                .build()
                .execute(GitPullRequest.class);
    }

    /**
     * Retrieve a pull request.
     *
     * @param repositoryName The repository name of the pull request's target branch.
     * @param pullRequestId  The ID of the pull request to retrieve.
     * @return {@link GitPullRequest} object
     * @throws AzDException Default Api Exception handler.
     */
    public GitPullRequest get(String repositoryName, int pullRequestId) throws AzDException {
        return builder()
                .serviceEndpoint("repositoryId", repositoryName)
                .serviceEndpoint("pullRequestId", pullRequestId)
                .build()
                .execute(GitPullRequest.class);
    }

    /**
     * Retrieve a pull request.
     *
     * @param repositoryName       The repository name of the pull request's target branch.
     * @param pullRequestId        The ID of the pull request to retrieve.
     * @param requestConfiguration Consumer of request configuration. This represents the query parameter for the request.
     * @return {@link GitPullRequest} object
     * @throws AzDException Default Api Exception handler.
     */
    public GitPullRequest get(String repositoryName, int pullRequestId,
                              Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .serviceEndpoint("repositoryId", repositoryName)
                .serviceEndpoint("pullRequestId", pullRequestId)
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .execute(GitPullRequest.class);
    }

    /**
     * Retrieve a pull request.
     *
     * @param pullRequestId The ID of the pull request to retrieve.
     * @return {@link GitPullRequest} object
     * @throws AzDException Default Api Exception handler.
     */
    public GitPullRequest getById(int pullRequestId) throws AzDException {
        return builder()
                .location("01a46dea-7d46-4d40-bc84-319e7c260d99")
                .serviceEndpoint("pullRequestId", pullRequestId)
                .build()
                .execute(GitPullRequest.class);
    }

    /**
     * Retrieve all pull requests from a repository
     *
     * @param repositoryName specify the repository name
     * @return {@link PullRequests} object
     * @throws AzDException Default Api Exception handler.
     */
    public PullRequests list(String repositoryName) throws AzDException {
        return builder()
                .serviceEndpoint("repositoryId", repositoryName)
                .build()
                .execute(PullRequests.class);
    }

    /**
     * Retrieve all pull requests from a repository
     *
     * @param repositoryName       specify the repository name
     * @param requestConfiguration Consumer of request configuration. This represents the query parameter for the request.
     * @return {@link PullRequests} object
     * @throws AzDException Default Api Exception handler.
     */
    public PullRequests list(String repositoryName,
                             Consumer<ListRequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .serviceEndpoint("repositoryId", repositoryName)
                .query(ListRequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .execute(PullRequests.class);
    }

    /**
     * Gets all pull requests from a project.
     *
     * @return {@link PullRequests} object
     * @throws AzDException Default Api Exception handler.
     */
    public PullRequests list() throws AzDException {
        return builder()
                .location("a5d28130-9cd2-40fa-9f08-902e7daa9efb")
                .build()
                .execute(PullRequests.class);
    }

    /**
     * Gets all pull requests from a project.
     *
     * @param requestConfiguration Consumer of request configuration. This represents the query parameter for the request.
     * @return {@link PullRequests} object
     * @throws AzDException Default Api Exception handler.
     */
    public PullRequests list(Consumer<ListRequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .location("a5d28130-9cd2-40fa-9f08-902e7daa9efb")
                .query(ListRequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .execute(PullRequests.class);
    }

    /**
     * Update a pull request
     * <p>
     * These are the properties that can be updated with the API:
     * Status
     * Title
     * Description (up to 4000 characters)
     * CompletionOptions
     * MergeOptions
     * AutoCompleteSetBy.Id
     * TargetRefName (when the PR retargeting feature is enabled)
     * Attempting to update other properties outside of this list will either cause the server
     * to throw an InvalidArgumentValueException, or to silently ignore the update.
     * </p>
     *
     * @param pullRequestId  ID of the pull request to update.
     * @param repositoryId   The repository ID of the pull request's target branch.
     * @param gitPullRequest Git pull request object to update.
     * @return GitPullRequest Object {@link GitPullRequest}
     * @throws AzDException Default Api Exception handler.
     **/
    public GitPullRequest update(String repositoryId, int pullRequestId, GitPullRequest gitPullRequest)
            throws AzDException {
        return builder()
                .PATCH(gitPullRequest)
                .serviceEndpoint("repositoryId", repositoryId)
                .serviceEndpoint("pullRequestId", pullRequestId)
                .build()
                .execute(GitPullRequest.class);
    }

    /**
     * Represents the query parameters.
     */
    public static class GetQueryParameters {
        /**
         * If true, the pull request will be returned with the associated commits.
         */
        @QueryParameter(name = "includeCommits")
        public Boolean includeCommits;
        /**
         * If true, the pull request will be returned with the associated work item references.
         */
        @QueryParameter(name = "includeWorkItemRefs")
        public Boolean includeWorkItemRefs;
    }

    /**
     * Request configuration object for the query parameters.
     */
    public static class RequestConfiguration {
        public GetQueryParameters queryParameters = new GetQueryParameters();
    }

    /**
     * Represents the query parameters.
     */
    public static class ListQueryParameters {
        /**
         * The number of pull requests to ignore. For example, to retrieve results 101-150, set top to 50 and skip to 100.
         */
        @QueryParameter(name = "$skip")
        public Integer skip;
        /**
         * The number of pull requests to retrieve.
         */
        @QueryParameter(name = "$top")
        public Integer top;
        /**
         * If set, search for pull requests that were created by this identity.
         */
        @QueryParameter(name = "searchCriteria.creatorId")
        public String creatorId;
        /**
         * Whether to include the _links field on the shallow references
         */
        @QueryParameter(name = "searchCriteria.includeLinks")
        public Boolean includeLinks;
        /**
         * If specified, filters pull requests that created/closed before this date based on the queryTimeRangeType specified.
         */
        @QueryParameter(name = "searchCriteria.maxTime")
        public String maxTime;
        /**
         * If specified, filters pull requests that created/closed after this date based on the queryTimeRangeType specified.
         */
        @QueryParameter(name = "searchCriteria.minTime")
        public String minTime;
        /**
         * The type of time range which should be used for minTime and maxTime. Defaults to Created if unset.
         */
        @QueryParameter(name = "searchCriteria.queryTimeRangeType")
        public PullRequestTimeRange queryTimeRangeType;
        /**
         * If set, search for pull requests whose target branch is in this repository.
         */
        @QueryParameter(name = "searchCriteria.repositoryId")
        public String repositoryId;
        /**
         * If set, search for pull requests that have this identity as a reviewer.
         */
        @QueryParameter(name = "searchCriteria.reviewerId")
        public String reviewerId;
        /**
         * If set, search for pull requests from this branch.
         */
        @QueryParameter(name = "searchCriteria.sourceRefName")
        public String sourceRefName;
        /**
         * If set, search for pull requests whose source branch is in this repository.
         */
        @QueryParameter(name = "searchCriteria.sourceRepositoryId")
        public String sourceRepositoryId;
        /**
         * If set, search for pull requests that are in this state. Defaults to Active if unset.
         */
        @QueryParameter(name = "searchCriteria.status")
        public PullRequestStatus status;
        /**
         * If set, search for pull requests into this branch.
         */
        @QueryParameter(name = "searchCriteria.targetRefName")
        public String targetRefName;
    }

    /**
     * Request configuration object for the query parameters.
     */
    public static class ListRequestConfiguration {
        public ListQueryParameters queryParameters = new ListQueryParameters();
    }
}
