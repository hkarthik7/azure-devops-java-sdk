package org.azd.build.sourceproviders;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.abstractions.QueryParameter;
import org.azd.authentication.AccessTokenCredential;
import org.azd.build.types.*;
import org.azd.enums.SourceProviderResultSet;
import org.azd.exceptions.AzDException;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

/**
 * Provides functionality to work with Build Definitions Api.
 */
public class SourceProvidersRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public SourceProvidersRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential, "build");
    }

    /**
     * Gets the contents of a file in the given source code repository.
     *
     * @param providerName         The name of the source provider. E.g., Github
     * @param requestConfiguration Consumer of request parameters configuration.
     * @return Contents of the file given String. {@link String}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<String> getFileContentsAsync(String providerName,
                                                          Consumer<GetRequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .location("29d12225-b1d9-425f-b668-6c594a981313")
                .serviceEndpoint("providerName", providerName)
                .query(GetRequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .executeStringAsync();
    }

    /**
     * Gets the contents of a directory in the given source code repository.
     *
     * @param providerName         The name of the source provider. E.g., Github
     * @param requestConfiguration Consumer of request parameters configuration.
     * @return SourceRepositoryItems {@link SourceRepositoryItems}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<SourceRepositoryItems> getPathContentsAsync(String providerName,
                                                                         Consumer<GetRequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .location("7944d6fb-df01-4709-920a-7a189aa34037")
                .serviceEndpoint("providerName", providerName)
                .query(GetRequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .executeAsync(SourceRepositoryItems.class);
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
        return builder()
                .location("d8763ec7-9ff0-4fb4-b2b2-9d757906ff14")
                .serviceEndpoint("providerName", providerName)
                .serviceEndpoint("pullRequestId", pullRequestId)
                .query("repositoryName", repositoryName)
                .query("serviceEndpointId", serviceEndpointId)
                .build()
                .executeAsync(SourceProviderPullRequest.class);
    }

    /**
     * Get a list of source providers and their capabilities.
     *
     * @return SourceProviderAttributes {@link SourceProviderAttributes}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<SourceProviderAttributes> listAsync() throws AzDException {
        return builder()
                .location("3ce81729-954f-423d-a581-9fea01d25186")
                .build()
                .executeAsync(SourceProviderAttributes.class);
    }


    /**
     * Gets a list of branches for the given source code repository.
     *
     * @param providerName         The name of the source provider.
     * @param requestConfiguration Consumer of query parameters to filter.
     * @return SourceProviderBranches {@link SourceProviderBranches}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<SourceProviderBranches> listBranchesAsync(String providerName,
                                                                       Consumer<GetBranchesRequestConfiguration> requestConfiguration)
            throws AzDException {
        return builder()
                .location("e05d4403-9b81-4244-8763-20fde28d1976")
                .serviceEndpoint("providerName", providerName)
                .query(GetBranchesRequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .executeAsync(SourceProviderBranches.class);
    }

    /**
     * Gets a list of source code repositories.
     *
     * @param providerName         The name of the source provider.
     * @param requestConfiguration Consumer of query parameters to filter.
     * @return SourceRepositories {@link SourceRepositories}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<SourceRepositories> listRepositoriesAsync(String providerName,
                                                                       Consumer<GetRepositoriesRequestConfiguration> requestConfiguration)
            throws AzDException {
        return builder()
                .location("d44d1680-f978-4834-9b93-8c6e132329c9")
                .serviceEndpoint("providerName", providerName)
                .query(GetRepositoriesRequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .executeAsync(SourceRepositories.class);
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
    public CompletableFuture<RepositoryWebhooks> listWebhooksAsync(String providerName, String serviceEndpointId,
                                                                   String repositoryName) throws AzDException {
        return builder()
                .location("8f20ff82-9498-4812-9f6e-9c01bdc50e99")
                .serviceEndpoint("providerName", providerName)
                .query("repositoryName", repositoryName)
                .query("serviceEndpointId", serviceEndpointId)
                .build()
                .executeAsync(RepositoryWebhooks.class);
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
        return builder()
                .POST(triggerTypes)
                .location("8f20ff82-9498-4812-9f6e-9c01bdc50e99")
                .serviceEndpoint("providerName", providerName)
                .query("repositoryName", repositoryName)
                .query("serviceEndpointId", serviceEndpointId)
                .build()
                .executePrimitiveAsync();

    }

    /**
     * Gets the contents of a file in the given source code repository.
     *
     * @param providerName         The name of the source provider. E.g., Github
     * @param requestConfiguration Consumer of request parameters configuration.
     * @return Contents of the file given String. {@link String}
     * @throws AzDException Default Api Exception handler.
     */
    public String getFileContents(String providerName,
                                  Consumer<GetRequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .location("29d12225-b1d9-425f-b668-6c594a981313")
                .serviceEndpoint("providerName", providerName)
                .query(GetRequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .executeString();
    }

    /**
     * Gets the contents of a directory in the given source code repository.
     *
     * @param providerName         The name of the source provider. E.g., Github
     * @param requestConfiguration Consumer of request parameters configuration.
     * @return SourceRepositoryItems {@link SourceRepositoryItems}
     * @throws AzDException Default Api Exception handler.
     */
    public SourceRepositoryItems getPathContents(String providerName,
                                                 Consumer<GetRequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .location("7944d6fb-df01-4709-920a-7a189aa34037")
                .serviceEndpoint("providerName", providerName)
                .query(GetRequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .execute(SourceRepositoryItems.class);
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
        return builder()
                .location("d8763ec7-9ff0-4fb4-b2b2-9d757906ff14")
                .serviceEndpoint("providerName", providerName)
                .serviceEndpoint("pullRequestId", pullRequestId)
                .query("repositoryName", repositoryName)
                .query("serviceEndpointId", serviceEndpointId)
                .build()
                .execute(SourceProviderPullRequest.class);
    }

    /**
     * Get a list of source providers and their capabilities.
     *
     * @return SourceProviderAttributes {@link SourceProviderAttributes}
     * @throws AzDException Default Api Exception handler.
     */
    public SourceProviderAttributes list() throws AzDException {
        return builder()
                .location("3ce81729-954f-423d-a581-9fea01d25186")
                .build()
                .execute(SourceProviderAttributes.class);
    }


    /**
     * Gets a list of branches for the given source code repository.
     *
     * @param providerName         The name of the source provider.
     * @param requestConfiguration Consumer of query parameters to filter.
     * @return SourceProviderBranches {@link SourceProviderBranches}
     * @throws AzDException Default Api Exception handler.
     */
    public SourceProviderBranches listBranches(String providerName,
                                               Consumer<GetBranchesRequestConfiguration> requestConfiguration)
            throws AzDException {
        return builder()
                .location("e05d4403-9b81-4244-8763-20fde28d1976")
                .serviceEndpoint("providerName", providerName)
                .query(GetBranchesRequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .execute(SourceProviderBranches.class);
    }

    /**
     * Gets a list of source code repositories.
     *
     * @param providerName         The name of the source provider.
     * @param requestConfiguration Consumer of query parameters to filter.
     * @return SourceRepositories {@link SourceRepositories}
     * @throws AzDException Default Api Exception handler.
     */
    public SourceRepositories listRepositories(String providerName,
                                               Consumer<GetRepositoriesRequestConfiguration> requestConfiguration)
            throws AzDException {
        return builder()
                .location("d44d1680-f978-4834-9b93-8c6e132329c9")
                .serviceEndpoint("providerName", providerName)
                .query(GetRepositoriesRequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .execute(SourceRepositories.class);
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
    public RepositoryWebhooks listWebhooks(String providerName, String serviceEndpointId,
                                           String repositoryName) throws AzDException {
        return builder()
                .location("8f20ff82-9498-4812-9f6e-9c01bdc50e99")
                .serviceEndpoint("providerName", providerName)
                .query("repositoryName", repositoryName)
                .query("serviceEndpointId", serviceEndpointId)
                .build()
                .execute(RepositoryWebhooks.class);
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
        return builder()
                .POST(triggerTypes)
                .location("8f20ff82-9498-4812-9f6e-9c01bdc50e99")
                .serviceEndpoint("providerName", providerName)
                .query("repositoryName", repositoryName)
                .query("serviceEndpointId", serviceEndpointId)
                .build()
                .executePrimitive();

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
