package org.azd.git.pullrequests;

import org.azd.common.ApiVersion;
import org.azd.common.types.QueryParameter;
import org.azd.enums.PullRequestStatus;
import org.azd.enums.PullRequestTimeRange;
import org.azd.exceptions.AzDException;
import org.azd.git.types.GitPullRequest;
import org.azd.git.types.PullRequests;
import org.azd.interfaces.AccessTokenCredential;
import org.azd.interfaces.RequestAdapter;
import org.azd.utils.BaseRequestBuilder;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

/**
 * Pull requests request builder for managing Git PullRequests API.
 */
public class PullRequestsRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new request builder instance and sets the default values.
     * @param accessTokenCredential Authentication provider {@link AccessTokenCredential}.
     * @param requestAdapter The request adapter to execute the requests.
     */
    public PullRequestsRequestBuilder(AccessTokenCredential accessTokenCredential, RequestAdapter requestAdapter) {
        super(accessTokenCredential, requestAdapter, "git/repositories", ApiVersion.GIT);
    }

    /**
     * Create a pull request.
     * @param repositoryId id of the repository.
     * @param gitPullRequest a {@link GitPullRequest} object.
     * @return Git pull request object {@link GitPullRequest}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<GitPullRequest> createAsync(String repositoryId, GitPullRequest gitPullRequest, Boolean supportsIterations) throws AzDException {
        var reqInfo = toPostRequestInformation(gitPullRequest);
        reqInfo.serviceEndpoint = service + "/" + repositoryId + "/pullrequests";
        reqInfo.setQueryParameter("supportsIterations", supportsIterations);
        return requestAdapter.sendAsync(reqInfo, GitPullRequest.class);
    }

    /***
     * Retrieve a pull request.
     * @param repositoryName The repository name of the pull request's target branch.
     * @param pullRequestId The ID of the pull request to retrieve.
     * @throws AzDException Default Api Exception handler.
     * @return {@link GitPullRequest} object
     */
    public CompletableFuture<GitPullRequest> getAsync(String repositoryName, int pullRequestId) throws AzDException {
        var reqInfo = toGetRequestInformation();
        reqInfo.serviceEndpoint = service + "/" + repositoryName + "/pullrequests/" + pullRequestId;
        return requestAdapter.sendAsync(reqInfo, GitPullRequest.class);
    }

    /***
     * Retrieve a pull request.
     * @param repositoryName The repository name of the pull request's target branch.
     * @param pullRequestId The ID of the pull request to retrieve.
     * @param requestConfiguration Consumer of request configuration. This represents the query parameter for the request.
     * @throws AzDException Default Api Exception handler.
     * @return {@link GitPullRequest} object
     */
    public CompletableFuture<GitPullRequest> getAsync(String repositoryName, int pullRequestId,
                                                      Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        var reqInfo = toGetRequestInformation();
        reqInfo.serviceEndpoint = service + "/" + repositoryName + "/pullrequests/" + pullRequestId;

        if (requestConfiguration != null) {
            final var config = new RequestConfiguration();
            requestConfiguration.accept(config);
            reqInfo.setQueryParameters(config.queryParameters);
        }

        return requestAdapter.sendAsync(reqInfo, GitPullRequest.class);
    }

    /***
     * Retrieve a pull request.
     * @param pullRequestId The ID of the pull request to retrieve.
     * @throws AzDException Default Api Exception handler.
     * @return {@link GitPullRequest} object
     */
    public CompletableFuture<GitPullRequest> getByIdAsync(int pullRequestId) throws AzDException {
        var reqInfo = toGetRequestInformation();
        reqInfo.serviceEndpoint = service.replace("repositories", "pullrequests") + "/" + pullRequestId;
        return requestAdapter.sendAsync(reqInfo, GitPullRequest.class);
    }

    /***
     * Retrieve all pull requests from a repository
     * @param repositoryName specify the repository name
     * @throws AzDException Default Api Exception handler.
     * @return {@link PullRequests} object
     */
    public CompletableFuture<PullRequests> listAsync(String repositoryName) throws AzDException {
        var reqInfo = toGetRequestInformation();
        reqInfo.serviceEndpoint = service + "/" + repositoryName + "/pullrequests";
        return requestAdapter.sendAsync(reqInfo, PullRequests.class);
    }

    /***
     * Retrieve all pull requests from a repository
     * @param repositoryName specify the repository name
     * @param requestConfiguration Consumer of request configuration. This represents the query parameter for the request.
     * @throws AzDException Default Api Exception handler.
     * @return {@link PullRequests} object
     */
    public CompletableFuture<PullRequests> listAsync(String repositoryName, Consumer<ListRequestConfiguration> requestConfiguration) throws AzDException {
        var reqInfo = toGetRequestInformation();
        reqInfo.serviceEndpoint = service + "/" + repositoryName + "/pullrequests";

        if (requestConfiguration != null) {
            final var config = new ListRequestConfiguration();
            requestConfiguration.accept(config);
            reqInfo.setQueryParameters(config.queryParameters);
        }

        return requestAdapter.sendAsync(reqInfo, PullRequests.class);
    }

    /***
     * Gets all pull requests from a project.
     * @throws AzDException Default Api Exception handler.
     * @return {@link PullRequests} object
     */
    public CompletableFuture<PullRequests> listAsync() throws AzDException {
        var reqInfo = toGetRequestInformation();
        reqInfo.serviceEndpoint = service.replace("repositories", "pullrequests");
        return requestAdapter.sendAsync(reqInfo, PullRequests.class);
    }

    /***
     * Gets all pull requests from a project.
     * @throws AzDException Default Api Exception handler.
     * @param requestConfiguration Consumer of request configuration. This represents the query parameter for the request.
     * @return {@link PullRequests} object
     */
    public CompletableFuture<PullRequests> listAsync(Consumer<ListRequestConfiguration> requestConfiguration) throws AzDException {
        var reqInfo = toGetRequestInformation();
        reqInfo.serviceEndpoint = service.replace("repositories", "pullrequests");

        if (requestConfiguration != null) {
            final var config = new ListRequestConfiguration();
            requestConfiguration.accept(config);
            reqInfo.setQueryParameters(config.queryParameters);
        }

        return requestAdapter.sendAsync(reqInfo, PullRequests.class);
    }

    /**
     * Update a pull request
     * <p>
     *      These are the properties that can be updated with the API:
     *      Status
     *      Title
     *      Description (up to 4000 characters)
     *      CompletionOptions
     *      MergeOptions
     *      AutoCompleteSetBy.Id
     *      TargetRefName (when the PR retargeting feature is enabled)
     *      Attempting to update other properties outside of this list will either cause the server
     *      to throw an InvalidArgumentValueException, or to silently ignore the update.
     * </p>
     * @param pullRequestId ID of the pull request to update.
     * @param repositoryId The repository ID of the pull request's target branch.
     * @param gitPullRequest Git pull request object to update.
     * @return GitPullRequest Object {@link GitPullRequest}
     * @throws AzDException Default Api Exception handler.
     **/
    public CompletableFuture<GitPullRequest> updateAsync(String repositoryId, int pullRequestId, GitPullRequest gitPullRequest) throws AzDException {
        var reqInfo = toPatchRequestInformation(gitPullRequest);
        reqInfo.serviceEndpoint = service + "/" + repositoryId + "/pullrequests/" + pullRequestId;
        return requestAdapter.sendAsync(reqInfo, GitPullRequest.class);
    }

    /**
     * Create a pull request.
     * @param repositoryId id of the repository.
     * @param gitPullRequest a {@link GitPullRequest} object.
     * @return Git pull request object {@link GitPullRequest}
     * @throws AzDException Default Api Exception handler.
     */
    public GitPullRequest create(String repositoryId, GitPullRequest gitPullRequest, Boolean supportsIterations) throws AzDException {
        var reqInfo = toPostRequestInformation(gitPullRequest);
        reqInfo.serviceEndpoint = service + "/" + repositoryId + "/pullrequests";
        reqInfo.setQueryParameter("supportsIterations", supportsIterations);
        return requestAdapter.send(reqInfo, GitPullRequest.class);
    }

    /***
     * Retrieve a pull request.
     * @param repositoryName The repository name of the pull request's target branch.
     * @param pullRequestId The ID of the pull request to retrieve.
     * @throws AzDException Default Api Exception handler.
     * @return {@link GitPullRequest} object
     */
    public GitPullRequest get(String repositoryName, int pullRequestId) throws AzDException {
        var reqInfo = toGetRequestInformation();
        reqInfo.serviceEndpoint = service + "/" + repositoryName + "/pullrequests/" + pullRequestId;
        return requestAdapter.send(reqInfo, GitPullRequest.class);
    }

    /***
     * Retrieve a pull request.
     * @param repositoryName The repository name of the pull request's target branch.
     * @param pullRequestId The ID of the pull request to retrieve.
     * @param requestConfiguration Consumer of request configuration. This represents the query parameter for the request.
     * @throws AzDException Default Api Exception handler.
     * @return {@link GitPullRequest} object
     */
    public GitPullRequest get(String repositoryName, int pullRequestId,
                              Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        var reqInfo = toGetRequestInformation();
        reqInfo.serviceEndpoint = service + "/" + repositoryName + "/pullrequests/" + pullRequestId;

        if (requestConfiguration != null) {
            final var config = new RequestConfiguration();
            requestConfiguration.accept(config);
            reqInfo.setQueryParameters(config.queryParameters);
        }

        return requestAdapter.send(reqInfo, GitPullRequest.class);
    }

    /***
     * Retrieve a pull request.
     * @param pullRequestId The ID of the pull request to retrieve.
     * @throws AzDException Default Api Exception handler.
     * @return {@link GitPullRequest} object
     */
    public GitPullRequest getById(int pullRequestId) throws AzDException {
        var reqInfo = toGetRequestInformation();
        reqInfo.serviceEndpoint = service.replace("repositories", "pullrequests") + "/" + pullRequestId;
        return requestAdapter.send(reqInfo, GitPullRequest.class);
    }

    /***
     * Retrieve all pull requests from a repository
     * @param repositoryName specify the repository name
     * @throws AzDException Default Api Exception handler.
     * @return {@link PullRequests} object
     */
    public PullRequests list(String repositoryName) throws AzDException {
        var reqInfo = toGetRequestInformation();
        reqInfo.serviceEndpoint = service + "/" + repositoryName + "/pullrequests";
        return requestAdapter.send(reqInfo, PullRequests.class);
    }

    /***
     * Retrieve all pull requests from a repository
     * @param repositoryName specify the repository name
     * @param requestConfiguration Consumer of request configuration. This represents the query parameter for the request.
     * @throws AzDException Default Api Exception handler.
     * @return {@link PullRequests} object
     */
    public PullRequests list(String repositoryName, Consumer<ListRequestConfiguration> requestConfiguration) throws AzDException {
        var reqInfo = toGetRequestInformation();
        reqInfo.serviceEndpoint = service + "/" + repositoryName + "/pullrequests";

        if (requestConfiguration != null) {
            final var config = new ListRequestConfiguration();
            requestConfiguration.accept(config);
            reqInfo.setQueryParameters(config.queryParameters);
        }

        return requestAdapter.send(reqInfo, PullRequests.class);
    }

    /***
     * Gets all pull requests from a project.
     * @throws AzDException Default Api Exception handler.
     * @return {@link PullRequests} object
     */
    public PullRequests list() throws AzDException {
        var reqInfo = toGetRequestInformation();
        reqInfo.serviceEndpoint = service.replace("repositories", "pullrequests");
        return requestAdapter.send(reqInfo, PullRequests.class);
    }

    /***
     * Gets all pull requests from a project.
     * @throws AzDException Default Api Exception handler.
     * @param requestConfiguration Consumer of request configuration. This represents the query parameter for the request.
     * @return {@link PullRequests} object
     */
    public PullRequests list(Consumer<ListRequestConfiguration> requestConfiguration) throws AzDException {
        var reqInfo = toGetRequestInformation();
        reqInfo.serviceEndpoint = service.replace("repositories", "pullrequests");

        if (requestConfiguration != null) {
            final var config = new ListRequestConfiguration();
            requestConfiguration.accept(config);
            reqInfo.setQueryParameters(config.queryParameters);
        }

        return requestAdapter.send(reqInfo, PullRequests.class);
    }

    /**
     * Update a pull request
     * <p>
     *      These are the properties that can be updated with the API:
     *      Status
     *      Title
     *      Description (up to 4000 characters)
     *      CompletionOptions
     *      MergeOptions
     *      AutoCompleteSetBy.Id
     *      TargetRefName (when the PR retargeting feature is enabled)
     *      Attempting to update other properties outside of this list will either cause the server
     *      to throw an InvalidArgumentValueException, or to silently ignore the update.
     * </p>
     * @param pullRequestId ID of the pull request to update.
     * @param repositoryId The repository ID of the pull request's target branch.
     * @param gitPullRequest Git pull request object to update.
     * @return GitPullRequest Object {@link GitPullRequest}
     * @throws AzDException Default Api Exception handler.
     **/
    public GitPullRequest update(String repositoryId, int pullRequestId, GitPullRequest gitPullRequest) throws AzDException {
        var reqInfo = toPatchRequestInformation(gitPullRequest);
        reqInfo.serviceEndpoint = service + "/" + repositoryId + "/pullrequests/" + pullRequestId;
        return requestAdapter.send(reqInfo, GitPullRequest.class);
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
        public Number skip;
        /**
         * The number of pull requests to retrieve.
         */
        @QueryParameter(name = "$top")
        public Number top;
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
