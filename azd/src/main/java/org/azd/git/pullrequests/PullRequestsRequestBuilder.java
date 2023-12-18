package org.azd.git.pullrequests;

import org.azd.common.ApiVersion;
import org.azd.common.types.QueryParameter;
import org.azd.exceptions.AzDException;
import org.azd.extensionmanagement.ExtensionManagementRequestBuilder;
import org.azd.git.types.GitPullRequest;
import org.azd.git.types.PullRequests;
import org.azd.interfaces.AccessTokenCredential;
import org.azd.interfaces.RequestAdapter;
import org.azd.utils.BaseRequestBuilder;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class PullRequestsRequestBuilder extends BaseRequestBuilder {
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
    }

    /**
     * Request configuration object for the query parameters.
     */
    public static class ListRequestConfiguration {
        public ListQueryParameters queryParameters = new ListQueryParameters();
    }
 }
