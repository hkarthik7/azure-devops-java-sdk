package org.azd.git.forks;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.abstractions.QueryParameter;
import org.azd.authentication.AccessTokenCredential;
import org.azd.common.ApiVersion;
import org.azd.exceptions.AzDException;
import org.azd.git.types.GitForkSyncRequest;
import org.azd.git.types.GitForkSyncRequestParameters;
import org.azd.git.types.GitForkSyncRequests;
import org.azd.git.types.GitRepositoryRefs;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

/**
 * Provides functionality to build requests for managing Git Forks Api.
 */
public class ForksRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public ForksRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential, "git", "1703f858-b9d1-46af-ab62-483e9e1055b5", ApiVersion.GIT_FORK);
    }

    /**
     * Request that another repository's refs be fetched into this one. It syncs two existing forks.
     * To create a fork, please see the <a href="https://learn.microsoft.com/en-us/rest/api/azure/devops/git/Repositories/Create?view=azure-devops-rest-7.1&tabs=HTTP">repositories endpoint</a>.
     *
     * @param forkSyncRequestParameters Represents the request body to create fork sync.
     * @param repositoryNameOrId        Name of Id of the repository.
     * @return Git fork sync request object. {@link GitForkSyncRequest}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<GitForkSyncRequest> createAsync(GitForkSyncRequestParameters forkSyncRequestParameters,
                                                             String repositoryNameOrId) throws AzDException {
        return builder()
                .POST(forkSyncRequestParameters)
                .serviceEndpoint("repositoryNameOrId", repositoryNameOrId)
                .build()
                .executeAsync(GitForkSyncRequest.class);
    }

    /**
     * Request that another repository's refs be fetched into this one. It syncs two existing forks.
     * To create a fork, please see the <a href="https://learn.microsoft.com/en-us/rest/api/azure/devops/git/Repositories/Create?view=azure-devops-rest-7.1&tabs=HTTP">repositories endpoint</a>.
     *
     * @param forkSyncRequestParameters Represents the request body to create fork sync.
     * @param repositoryNameOrId        Name of Id of the repository.
     * @param requestConfiguration      Request configuration that represents the query parameters.
     * @return Git fork sync request object. {@link GitForkSyncRequest}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<GitForkSyncRequest> createAsync(GitForkSyncRequestParameters forkSyncRequestParameters,
                                                             String repositoryNameOrId,
                                                             Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .POST(forkSyncRequestParameters)
                .serviceEndpoint("repositoryNameOrId", repositoryNameOrId)
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .executeAsync(GitForkSyncRequest.class);
    }

    /**
     * Retrieve all requested fork sync operations on this repository.
     *
     * @param repositoryNameOrId Name of Id of the repository.
     * @return Git fork sync requests object. {@link GitForkSyncRequests}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<GitForkSyncRequests> getAsync(String repositoryNameOrId) throws AzDException {
        return builder()
                .serviceEndpoint("repositoryNameOrId", repositoryNameOrId)
                .build()
                .executeAsync(GitForkSyncRequests.class);
    }

    /**
     * Retrieve all requested fork sync operations on this repository.
     *
     * @param repositoryNameOrId   Name of Id of the repository.
     * @param requestConfiguration Request configuration that represents the query parameters.
     * @return Git fork sync requests object. {@link GitForkSyncRequests}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<GitForkSyncRequests> getAsync(String repositoryNameOrId,
                                                           Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .serviceEndpoint("repositoryNameOrId", repositoryNameOrId)
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .executeAsync(GitForkSyncRequests.class);
    }

    /**
     * Retrieve all requested fork sync operations on this repository.
     *
     * @param repositoryNameOrId  Name of Id of the repository.
     * @param forkSyncOperationId OperationId of the sync request.
     * @return Git fork sync request object. {@link GitForkSyncRequest}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<GitForkSyncRequest> getAsync(String repositoryNameOrId, int forkSyncOperationId) throws AzDException {
        return builder()
                .serviceEndpoint("repositoryNameOrId", repositoryNameOrId)
                .serviceEndpoint("forkSyncOperationId", forkSyncOperationId)
                .build()
                .executeAsync(GitForkSyncRequest.class);
    }

    /**
     * Retrieve all requested fork sync operations on this repository.
     *
     * @param repositoryNameOrId   Name of Id of the repository.
     * @param forkSyncOperationId  OperationId of the sync request.
     * @param requestConfiguration Request configuration that represents the query parameters.
     * @return Git fork sync request object. {@link GitForkSyncRequest}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<GitForkSyncRequest> getAsync(String repositoryNameOrId, int forkSyncOperationId,
                                                          Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .serviceEndpoint("repositoryNameOrId", repositoryNameOrId)
                .serviceEndpoint("forkSyncOperationId", forkSyncOperationId)
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .executeAsync(GitForkSyncRequest.class);
    }

    /**
     * Retrieve all requested fork sync operations on this repository.
     *
     * @param repositoryNameOrId Name of Id of the repository.
     * @param collectionId       Team project collection ID.
     * @return Git repository reference object. {@link GitRepositoryRefs}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<GitRepositoryRefs> listAsync(String repositoryNameOrId, String collectionId) throws AzDException {
        return builder()
                .location("158c0340-bf6f-489c-9625-d572a1480d57")
                .serviceEndpoint("repositoryNameOrId", repositoryNameOrId)
                .serviceEndpoint("collectionId", collectionId)
                .build()
                .executeAsync(GitRepositoryRefs.class);
    }

    /**
     * Retrieve all requested fork sync operations on this repository.
     *
     * @param repositoryNameOrId   Name of Id of the repository.
     * @param collectionId         Team project collection ID.
     * @param requestConfiguration Request configuration that represents the query parameters.
     * @return Git repository reference object. {@link GitRepositoryRefs}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<GitRepositoryRefs> listAsync(String repositoryNameOrId, String collectionId,
                                                          Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .location("158c0340-bf6f-489c-9625-d572a1480d57")
                .serviceEndpoint("repositoryNameOrId", repositoryNameOrId)
                .serviceEndpoint("collectionId", collectionId)
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .executeAsync(GitRepositoryRefs.class);
    }

    /**
     * Request that another repository's refs be fetched into this one. It syncs two existing forks.
     * To create a fork, please see the <a href="https://learn.microsoft.com/en-us/rest/api/azure/devops/git/Repositories/Create?view=azure-devops-rest-7.1&tabs=HTTP">repositories endpoint</a>.
     *
     * @param forkSyncRequestParameters Represents the request body to create fork sync.
     * @param repositoryNameOrId        Name of Id of the repository.
     * @return Git fork sync request object. {@link GitForkSyncRequest}
     * @throws AzDException Default Api exception handler.
     */
    public GitForkSyncRequest create(GitForkSyncRequestParameters forkSyncRequestParameters,
                                     String repositoryNameOrId) throws AzDException {
        return builder()
                .POST(forkSyncRequestParameters)
                .serviceEndpoint("repositoryNameOrId", repositoryNameOrId)
                .build()
                .execute(GitForkSyncRequest.class);
    }

    /**
     * Request that another repository's refs be fetched into this one. It syncs two existing forks.
     * To create a fork, please see the <a href="https://learn.microsoft.com/en-us/rest/api/azure/devops/git/Repositories/Create?view=azure-devops-rest-7.1&tabs=HTTP">repositories endpoint</a>.
     *
     * @param forkSyncRequestParameters Represents the request body to create fork sync.
     * @param repositoryNameOrId        Name of Id of the repository.
     * @param requestConfiguration      Request configuration that represents the query parameters.
     * @return Git fork sync request object. {@link GitForkSyncRequest}
     * @throws AzDException Default Api exception handler.
     */
    public GitForkSyncRequest create(GitForkSyncRequestParameters forkSyncRequestParameters,
                                     String repositoryNameOrId,
                                     Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .POST(forkSyncRequestParameters)
                .serviceEndpoint("repositoryNameOrId", repositoryNameOrId)
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .execute(GitForkSyncRequest.class);
    }

    /**
     * Retrieve all requested fork sync operations on this repository.
     *
     * @param repositoryNameOrId Name of Id of the repository.
     * @return Git fork sync requests object. {@link GitForkSyncRequests}
     * @throws AzDException Default Api exception handler.
     */
    public GitForkSyncRequests get(String repositoryNameOrId) throws AzDException {
        return builder()
                .serviceEndpoint("repositoryNameOrId", repositoryNameOrId)
                .build()
                .execute(GitForkSyncRequests.class);
    }

    /**
     * Retrieve all requested fork sync operations on this repository.
     *
     * @param repositoryNameOrId   Name of Id of the repository.
     * @param requestConfiguration Request configuration that represents the query parameters.
     * @return Git fork sync requests object. {@link GitForkSyncRequests}
     * @throws AzDException Default Api exception handler.
     */
    public GitForkSyncRequests get(String repositoryNameOrId,
                                   Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .serviceEndpoint("repositoryNameOrId", repositoryNameOrId)
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .execute(GitForkSyncRequests.class);
    }

    /**
     * Retrieve all requested fork sync operations on this repository.
     *
     * @param repositoryNameOrId  Name of Id of the repository.
     * @param forkSyncOperationId OperationId of the sync request.
     * @return Git fork sync request object. {@link GitForkSyncRequest}
     * @throws AzDException Default Api exception handler.
     */
    public GitForkSyncRequest get(String repositoryNameOrId, int forkSyncOperationId) throws AzDException {
        return builder()
                .serviceEndpoint("repositoryNameOrId", repositoryNameOrId)
                .serviceEndpoint("forkSyncOperationId", forkSyncOperationId)
                .build()
                .execute(GitForkSyncRequest.class);
    }

    /**
     * Retrieve all requested fork sync operations on this repository.
     *
     * @param repositoryNameOrId   Name of Id of the repository.
     * @param forkSyncOperationId  OperationId of the sync request.
     * @param requestConfiguration Request configuration that represents the query parameters.
     * @return Git fork sync request object. {@link GitForkSyncRequest}
     * @throws AzDException Default Api exception handler.
     */
    public GitForkSyncRequest get(String repositoryNameOrId, int forkSyncOperationId,
                                  Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .serviceEndpoint("repositoryNameOrId", repositoryNameOrId)
                .serviceEndpoint("forkSyncOperationId", forkSyncOperationId)
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .execute(GitForkSyncRequest.class);
    }

    /**
     * Retrieve all requested fork sync operations on this repository.
     *
     * @param repositoryNameOrId Name of Id of the repository.
     * @param collectionId       Team project collection ID.
     * @return Git repository reference object. {@link GitRepositoryRefs}
     * @throws AzDException Default Api exception handler.
     */
    public GitRepositoryRefs list(String repositoryNameOrId, String collectionId) throws AzDException {
        return builder()
                .location("158c0340-bf6f-489c-9625-d572a1480d57")
                .serviceEndpoint("repositoryNameOrId", repositoryNameOrId)
                .serviceEndpoint("collectionId", collectionId)
                .build()
                .execute(GitRepositoryRefs.class);
    }

    /**
     * Retrieve all requested fork sync operations on this repository.
     *
     * @param repositoryNameOrId   Name of Id of the repository.
     * @param collectionId         Team project collection ID.
     * @param requestConfiguration Request configuration that represents the query parameters.
     * @return Git repository reference object. {@link GitRepositoryRefs}
     * @throws AzDException Default Api exception handler.
     */
    public GitRepositoryRefs list(String repositoryNameOrId, String collectionId,
                                  Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .location("158c0340-bf6f-489c-9625-d572a1480d57")
                .serviceEndpoint("repositoryNameOrId", repositoryNameOrId)
                .serviceEndpoint("collectionId", collectionId)
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .execute(GitRepositoryRefs.class);
    }

    /**
     * Represents the query parameters.
     */
    public static class GetQueryParameters {
        /**
         * True to include links.
         */
        @QueryParameter(name = "includeLinks")
        public Boolean includeLinks;
        /**
         * True to include abandoned requests.
         */
        @QueryParameter(name = "includeAbandoned")
        public Boolean includeAbandoned;
    }

    /**
     * Request configuration object for the query parameters.
     */
    public static class RequestConfiguration {
        public GetQueryParameters queryParameters = new GetQueryParameters();
    }
}
