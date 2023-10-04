package org.azd.build.sourceproviders;

import org.azd.build.types.*;
import org.azd.common.ApiVersion;
import org.azd.common.types.QueryParameter;
import org.azd.enums.SourceProviderResultSet;
import org.azd.exceptions.AzDException;
import org.azd.interfaces.AccessTokenCredential;
import org.azd.interfaces.RequestAdapter;
import org.azd.utils.BaseRequestBuilder;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

/**
 * Provides functionality to work with Build Definitions Api.
 */
public class SourceProvidersRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new request builder instance and sets the default values.
     * @param accessTokenCredential Authentication provider {@link AccessTokenCredential}.
     * @param requestAdapter The request adapter to execute the requests.
     */
    public SourceProvidersRequestBuilder(AccessTokenCredential accessTokenCredential, RequestAdapter requestAdapter) {
        super(accessTokenCredential, requestAdapter, "sourceProviders", ApiVersion.BUILD_SOURCE_PROVIDERS);
    }

    /**
     * Gets the contents of a file in the given source code repository.
     *
     * @param providerName      The name of the source provider. E.g., Github
     * @param requestConfiguration Consumer of request parameters configuration.
     * @return Contents of the file given String. {@link String}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<String> getFileContentsAsync(String providerName, Consumer<GetRequestConfiguration> requestConfiguration) throws AzDException {
        var reqInfo = toGetRequestInformation();
        reqInfo.serviceEndpoint = reqInfo.serviceEndpoint + "/" + providerName + "/filecontents";

        if (requestConfiguration != null) {
            final var config = new GetRequestConfiguration();
            requestConfiguration.accept(config);
            reqInfo.setQueryParameters(config.queryParameters);
        }

        return requestAdapter.sendStringAsync(reqInfo);
    }

    /**
     * Gets the contents of a directory in the given source code repository.
     *
     * @param providerName      The name of the source provider. E.g., Github
     * @param requestConfiguration Consumer of request parameters configuration.
     * @return SourceRepositoryItems {@link SourceRepositoryItems}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<SourceRepositoryItems> getPathContentsAsync(String providerName,
                                                                         Consumer<GetRequestConfiguration> requestConfiguration) throws AzDException {
        var reqInfo = toGetRequestInformation();
        reqInfo.serviceEndpoint = reqInfo.serviceEndpoint + "/" + providerName + "/pathcontents";

        if (requestConfiguration != null) {
            final var config = new GetRequestConfiguration();
            requestConfiguration.accept(config);
            reqInfo.setQueryParameters(config.queryParameters);
        }

        return requestAdapter.sendAsync(reqInfo, SourceRepositoryItems.class);
    }

    /**
     * Gets a pull request object from source provider.
     *
     * @param providerName      The name of the source provider
     * @param pullRequestId     Vendor-specific id of the pull request.
     * @param repositoryName    Vendor-specific identifier or the name of the repository that contains the pull request.
     * @param serviceEndpointId If specified, the ID of the service endpoint to query.
     *                          Can only be omitted for providers that do not use service endpoints, e.g. TFVC or TFGit.
     * @return SourceProviderPullRequest {@link SourceProviderPullRequest}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<SourceProviderPullRequest> getPullRequestAsync(String providerName, String pullRequestId,
                                                                            String repositoryName, String serviceEndpointId) throws AzDException {
        var reqInfo = toGetRequestInformation();
        reqInfo.serviceEndpoint = reqInfo.serviceEndpoint + "/" + providerName + "/pullrequests/" + pullRequestId;
        reqInfo.setQueryParameter("repositoryName", repositoryName);
        reqInfo.setQueryParameter("serviceEndpointId", serviceEndpointId);

        return requestAdapter.sendAsync(reqInfo, SourceProviderPullRequest.class);
    }

    /**
     * Get a list of source providers and their capabilities.
     *
     * @return SourceProviderAttributes {@link SourceProviderAttributes}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<SourceProviderAttributes> listAsync() throws AzDException {
        return requestAdapter.sendAsync(toGetRequestInformation(), SourceProviderAttributes.class);
    }


    /**
     * Gets a list of branches for the given source code repository.
     *
     * @param providerName      The name of the source provider.
     * @param requestConfiguration Consumer of query parameters to filter.
     * @return SourceProvideBranches {@link SourceProvideBranches}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<SourceProvideBranches> listBranchesAsync(String providerName,
                                                                      Consumer<GetBranchesRequestConfiguration> requestConfiguration) throws AzDException {
        var reqInfo = toGetRequestInformation();
        reqInfo.serviceEndpoint = reqInfo.serviceEndpoint + "/" + providerName + "/branches";

        if (requestConfiguration != null) {
            final var config = new GetBranchesRequestConfiguration();
            requestConfiguration.accept(config);
            reqInfo.setQueryParameters(config.queryParameters);
        }

        return requestAdapter.sendAsync(reqInfo, SourceProvideBranches.class);
    }

    /**
     * Gets a list of source code repositories.
     *
     * @param providerName      The name of the source provider.
     * @param requestConfiguration Consumer of query parameters to filter.
     * @return SourceRepositories {@link SourceRepositories}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<SourceRepositories> listRepositoriesAsync(String providerName,
                                                                       Consumer<GetRepositoriesRequestConfiguration> requestConfiguration) throws AzDException {
        var reqInfo = toGetRequestInformation();
        reqInfo.serviceEndpoint = reqInfo.serviceEndpoint + "/" + providerName + "/repositories";

        if (requestConfiguration != null) {
            final var config = new GetRepositoriesRequestConfiguration();
            requestConfiguration.accept(config);
            reqInfo.setQueryParameters(config.queryParameters);
        }

        return requestAdapter.sendAsync(reqInfo, SourceRepositories.class);
    }

    /**
     * Gets a list of webhooks installed in the given source code repository.
     *
     * @param providerName      The name of the source provider.
     * @param serviceEndpointId If specified, the ID of the service endpoint to query.
     *                          Can only be omitted for providers that do not use service endpoints, e.g. TFVC or TFGit.
     * @param repositoryName    If specified, the vendor-specific identifier or the name of the repository to get webhooks.
     *                          Can only be omitted for providers that do not support multiple repositories.
     * @return RepositoryWebhooks {@link RepositoryWebhooks}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<RepositoryWebhooks> listWebhooksAsync(String providerName, String serviceEndpointId, String repositoryName) throws AzDException {
        var reqInfo = toGetRequestInformation();
        reqInfo.serviceEndpoint = reqInfo.serviceEndpoint + "/" + providerName + "/webhooks";
        reqInfo.setQueryParameter("repositoryName", repositoryName);
        reqInfo.setQueryParameter("serviceEndpointId", serviceEndpointId);

        return requestAdapter.sendAsync(reqInfo, RepositoryWebhooks.class);
    }

    /**
     * Recreates the webhooks for the specified triggers in the given source code repository.
     *
     * @param providerName      The name of the source provider.
     * @param serviceEndpointId If specified, the ID of the service endpoint to query.
     *                          Can only be omitted for providers that do not use service endpoints, e.g. TFVC or TFGit.
     * @param repositoryName    If specified, the vendor-specific identifier or the name of the repository to get webhooks.
     *                          Can only be omitted for providers that do not support multiple repositories.
     * @param triggerTypes      The types of triggers to restore webhooks for.
     * @return Void; successful operation
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<Void> restoreAsync(String providerName, String serviceEndpointId,
                                                String repositoryName, List<String> triggerTypes) throws AzDException {
        var reqInfo = toPostRequestInformation(triggerTypes);
        reqInfo.serviceEndpoint = reqInfo.serviceEndpoint + "/" + providerName + "/webhooks";
        reqInfo.setQueryParameter("repositoryName", repositoryName);
        reqInfo.setQueryParameter("serviceEndpointId", serviceEndpointId);

        return requestAdapter.sendPrimitiveAsync(reqInfo);

    }

    /**
     * Gets the contents of a file in the given source code repository.
     *
     * @param providerName      The name of the source provider. E.g., Github
     * @param requestConfiguration Consumer of request parameters configuration.
     * @return Contents of the file given String. {@link String}
     * @throws AzDException Default Api Exception handler.
     */
    public String getFileContents(String providerName, Consumer<GetRequestConfiguration> requestConfiguration) throws AzDException {
        var reqInfo = toGetRequestInformation();
        reqInfo.serviceEndpoint = reqInfo.serviceEndpoint + "/" + providerName + "/filecontents";

        if (requestConfiguration != null) {
            final var config = new GetRequestConfiguration();
            requestConfiguration.accept(config);
            reqInfo.setQueryParameters(config.queryParameters);
        }

        return requestAdapter.sendString(reqInfo);
    }

    /**
     * Gets the contents of a directory in the given source code repository.
     *
     * @param providerName      The name of the source provider. E.g., Github
     * @param requestConfiguration Consumer of request parameters configuration.
     * @return SourceRepositoryItems {@link SourceRepositoryItems}
     * @throws AzDException Default Api Exception handler.
     */
    public SourceRepositoryItems getPathContents(String providerName,
                                                 Consumer<GetRequestConfiguration> requestConfiguration) throws AzDException {
        var reqInfo = toGetRequestInformation();
        reqInfo.serviceEndpoint = reqInfo.serviceEndpoint + "/" + providerName + "/pathcontents";

        if (requestConfiguration != null) {
            final var config = new GetRequestConfiguration();
            requestConfiguration.accept(config);
            reqInfo.setQueryParameters(config.queryParameters);
        }

        return requestAdapter.send(reqInfo, SourceRepositoryItems.class);
    }

    /**
     * Gets a pull request object from source provider.
     *
     * @param providerName      The name of the source provider
     * @param pullRequestId     Vendor-specific id of the pull request.
     * @param repositoryName    Vendor-specific identifier or the name of the repository that contains the pull request.
     * @param serviceEndpointId If specified, the ID of the service endpoint to query.
     *                          Can only be omitted for providers that do not use service endpoints, e.g. TFVC or TFGit.
     * @return SourceProviderPullRequest {@link SourceProviderPullRequest}
     * @throws AzDException Default Api Exception handler.
     */
    public SourceProviderPullRequest getPullRequest(String providerName, String pullRequestId,
                                                    String repositoryName, String serviceEndpointId) throws AzDException {
        var reqInfo = toGetRequestInformation();
        reqInfo.serviceEndpoint = reqInfo.serviceEndpoint + "/" + providerName + "/pullrequests/" + pullRequestId;
        reqInfo.setQueryParameter("repositoryName", repositoryName);
        reqInfo.setQueryParameter("serviceEndpointId", serviceEndpointId);

        return requestAdapter.send(reqInfo, SourceProviderPullRequest.class);
    }

    /**
     * Get a list of source providers and their capabilities.
     *
     * @return SourceProviderAttributes {@link SourceProviderAttributes}
     * @throws AzDException Default Api Exception handler.
     */
    public SourceProviderAttributes list() throws AzDException {
        return requestAdapter.send(toGetRequestInformation(), SourceProviderAttributes.class);
    }


    /**
     * Gets a list of branches for the given source code repository.
     *
     * @param providerName      The name of the source provider.
     * @param requestConfiguration Consumer of query parameters to filter.
     * @return SourceProvideBranches {@link SourceProvideBranches}
     * @throws AzDException Default Api Exception handler.
     */
    public SourceProvideBranches listBranches(String providerName,
                                              Consumer<GetBranchesRequestConfiguration> requestConfiguration) throws AzDException {
        var reqInfo = toGetRequestInformation();
        reqInfo.serviceEndpoint = reqInfo.serviceEndpoint + "/" + providerName + "/branches";

        if (requestConfiguration != null) {
            final var config = new GetBranchesRequestConfiguration();
            requestConfiguration.accept(config);
            reqInfo.setQueryParameters(config.queryParameters);
        }

        return requestAdapter.send(reqInfo, SourceProvideBranches.class);
    }

    /**
     * Gets a list of source code repositories.
     *
     * @param providerName      The name of the source provider.
     * @param requestConfiguration Consumer of query parameters to filter.
     * @return SourceRepositories {@link SourceRepositories}
     * @throws AzDException Default Api Exception handler.
     */
    public SourceRepositories listRepositories(String providerName,
                                               Consumer<GetRepositoriesRequestConfiguration> requestConfiguration) throws AzDException {
        var reqInfo = toGetRequestInformation();
        reqInfo.serviceEndpoint = reqInfo.serviceEndpoint + "/" + providerName + "/repositories";

        if (requestConfiguration != null) {
            final var config = new GetRepositoriesRequestConfiguration();
            requestConfiguration.accept(config);
            reqInfo.setQueryParameters(config.queryParameters);
        }

        return requestAdapter.send(reqInfo, SourceRepositories.class);
    }

    /**
     * Gets a list of webhooks installed in the given source code repository.
     *
     * @param providerName      The name of the source provider.
     * @param serviceEndpointId If specified, the ID of the service endpoint to query.
     *                          Can only be omitted for providers that do not use service endpoints, e.g. TFVC or TFGit.
     * @param repositoryName    If specified, the vendor-specific identifier or the name of the repository to get webhooks.
     *                          Can only be omitted for providers that do not support multiple repositories.
     * @return RepositoryWebhooks {@link RepositoryWebhooks}
     * @throws AzDException Default Api Exception handler.
     */
    public RepositoryWebhooks listWebhooks(String providerName, String serviceEndpointId, String repositoryName) throws AzDException {
        var reqInfo = toGetRequestInformation();
        reqInfo.serviceEndpoint = reqInfo.serviceEndpoint + "/" + providerName + "/webhooks";
        reqInfo.setQueryParameter("repositoryName", repositoryName);
        reqInfo.setQueryParameter("serviceEndpointId", serviceEndpointId);

        return requestAdapter.send(reqInfo, RepositoryWebhooks.class);
    }

    /**
     * Recreates the webhooks for the specified triggers in the given source code repository.
     *
     * @param providerName      The name of the source provider.
     * @param serviceEndpointId If specified, the ID of the service endpoint to query.
     *                          Can only be omitted for providers that do not use service endpoints, e.g. TFVC or TFGit.
     * @param repositoryName    If specified, the vendor-specific identifier or the name of the repository to get webhooks.
     *                          Can only be omitted for providers that do not support multiple repositories.
     * @param triggerTypes      The types of triggers to restore webhooks for.
     * @return Void; successful operation
     * @throws AzDException Default Api Exception handler.
     */
    public Void restore(String providerName, String serviceEndpointId,
                        String repositoryName, List<String> triggerTypes) throws AzDException {
        var reqInfo = toPostRequestInformation(triggerTypes);
        reqInfo.serviceEndpoint = reqInfo.serviceEndpoint + "/" + providerName + "/webhooks";
        reqInfo.setQueryParameter("repositoryName", repositoryName);
        reqInfo.setQueryParameter("serviceEndpointId", serviceEndpointId);

        return requestAdapter.sendPrimitive(reqInfo);

    }

    public static class GetQueryParameters {
        /**
         * The identifier of the commit or branch from which a file's contents are retrieved.
         */
        @QueryParameter(name = "commitOrBranch")
        public String commitOrBranch;
        /**
         * The path to the file to retrieve, relative to the root of the repository.
         */
        @QueryParameter(name = "path")
        public String path;
        /**
         * If specified, the vendor-specific identifier or the name of the repository to get branches.
         * Can only be omitted for providers that do not support multiple repositories.
         */
        @QueryParameter(name = "repository")
        public String repository;
        /**
         * If specified, the ID of the service endpoint to query.
         * Can only be omitted for providers that do not use service endpoints, e.g. TFVC or TFGit.
         */
        @QueryParameter(name = "serviceEndpointId")
        public String serviceEndpointId;
    }

    public static class GetRequestConfiguration {
        public GetQueryParameters queryParameters = new GetQueryParameters();
    }

    public static class GetBranchesQueryParameters {
        /**
         * If supplied, the name of the branch to check for specifically.
         */
        @QueryParameter(name = "branchName")
        public String branchName;
        /**
         * The vendor-specific identifier or the name of the repository to get branches.
         * Can only be omitted for providers that do not support multiple repositories.
         */
        @QueryParameter(name = "repository")
        public String repository;
        /**
         * If specified, the ID of the service endpoint to query.
         * Can only be omitted for providers that do not use service endpoints, e.g. TFVC or TFGit.
         */
        @QueryParameter(name = "serviceEndpointId")
        public String serviceEndpointId;
    }

    public static class GetBranchesRequestConfiguration {
        public GetBranchesQueryParameters queryParameters = new GetBranchesQueryParameters();
    }

    public static class GetRepositoriesQueryParameters {
        /**
         * When paging results, this is a continuation token, returned by a previous call to this method,
         * that can be used to return the next set of repositories.
         */
        @QueryParameter(name = "continuationToken")
        public String continuationToken;
        /**
         * If set to true, this will limit the set of results and will return a continuation token to continue the query.
         */
        @QueryParameter(name = "pageResults")
        public Boolean pageResults;
        /**
         * If specified, the vendor-specific identifier or the name of a single repository to get.
         */
        @QueryParameter(name = "repository")
        public String repository;
        /**
         * 'top' for the repositories most relevant for the endpoint. If not set, all repositories are returned. Ignored if 'repository' is set.
         */
        @QueryParameter(name = "resultSet")
        public SourceProviderResultSet resultSet;
        /**
         * If specified, the ID of the service endpoint to query.
         * Can only be omitted for providers that do not use service endpoints, e.g. TFVC or TFGit.
         */
        @QueryParameter(name = "serviceEndpointId")
        public String serviceEndpointId;
    }

    public static class GetRepositoriesRequestConfiguration {
        public GetRepositoriesQueryParameters queryParameters = new GetRepositoriesQueryParameters();
    }
}
