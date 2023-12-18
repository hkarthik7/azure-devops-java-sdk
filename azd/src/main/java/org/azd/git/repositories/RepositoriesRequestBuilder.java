package org.azd.git.repositories;

import org.azd.common.ApiVersion;
import org.azd.common.types.QueryParameter;
import org.azd.exceptions.AzDException;
import org.azd.git.types.GitDeletedRepositories;
import org.azd.git.types.GitRepository;
import org.azd.git.types.Repositories;
import org.azd.git.types.RepositoryRequest;
import org.azd.interfaces.AccessTokenCredential;
import org.azd.interfaces.RequestAdapter;
import org.azd.utils.BaseRequestBuilder;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

/**
 * Repositories request builder to manage Git repositories Api.
 */
public class RepositoriesRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new request builder instance and sets the default values.
     * @param accessTokenCredential Authentication provider {@link AccessTokenCredential}.
     * @param requestAdapter The request adapter to execute the requests.
     */
    public RepositoriesRequestBuilder(AccessTokenCredential accessTokenCredential, RequestAdapter requestAdapter) {
        super(accessTokenCredential, requestAdapter, "git/repositories", ApiVersion.GIT);
    }

    /**
     * Request builder to manage recycle bin repositories.
     * @return RecycleBinRepositoriesRequestBuilder {@link RecycleBinRepositoriesRequestBuilder}.
     */
    public RecycleBinRepositoriesRequestBuilder recycleBin() {
        return new RecycleBinRepositoriesRequestBuilder(accessTokenCredential, requestAdapter);
    }

    /***
     * Create a git repository in a team project.
     * @param repositoryRequest New repository request.
     * @throws AzDException Default Api Exception handler.
     * @return git repository object {@link GitRepository}
     */
    public CompletableFuture<GitRepository> createAsync(RepositoryRequest repositoryRequest) throws AzDException {
        return requestAdapter.sendAsync(toPostRequestInformation(repositoryRequest), GitRepository.class);
    }

    /***
     * Delete a git repository
     * @param repositoryId pass the repository id
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<Void> deleteAsync(String repositoryId) throws AzDException {
        var reqInfo = toDeleteRequestInformation();
        reqInfo.serviceEndpoint = service + "/" + repositoryId;
        return requestAdapter.sendPrimitiveAsync(reqInfo);
    }

    /***
     * Retrieve deleted git repositories.
     * @throws AzDException Default Api Exception handler.
     * @return Git deleted repository object {@link GitDeletedRepositories}
     */
    public CompletableFuture<GitDeletedRepositories> listDeletedAsync() throws AzDException {
        var reqInfo = toGetRequestInformation();
        reqInfo.serviceEndpoint = service.replace("repositories", "deletedrepositories");
        return requestAdapter.sendAsync(reqInfo, GitDeletedRepositories.class);
    }

    /***
     * Retrieve a git repository.
     * @param repositoryName pass the repository name
     * @throws AzDException Default Api Exception handler.
     * @return git repository object {@link GitRepository}
     */
    public CompletableFuture<GitRepository> getAsync(String repositoryName) throws AzDException {
        var reqInfo = toGetRequestInformation();
        reqInfo.serviceEndpoint = service + "/" + repositoryName;
        return requestAdapter.sendAsync(reqInfo, GitRepository.class);
    }

    /***
     * Retrieve a git repository with parent.
     * @param repositoryName pass the repository name
     * @param includeParent True to include parent repository.
     * @throws AzDException Default Api Exception handler.
     * @return git repository object {@link GitRepository}
     */
    public CompletableFuture<GitRepository> getAsync(String repositoryName, boolean includeParent) throws AzDException {
        var reqInfo = toGetRequestInformation();
        reqInfo.serviceEndpoint = service + "/" + repositoryName;
        reqInfo.setQueryParameter("includeParent", includeParent);
        return requestAdapter.sendAsync(reqInfo, GitRepository.class);
    }

    /***
     * Retrieve git repositories.
     * @throws AzDException Default Api Exception handler.
     * @return array of git repositories
     */
    public CompletableFuture<Repositories> listAsync() throws AzDException {
        return requestAdapter.sendAsync(toGetRequestInformation(), Repositories.class);
    }

    /***
     * Retrieve git repositories.
     * @param requestConfiguration Consumer of request configuration. This represents the query parameter for the request.
     * @throws AzDException Default Api Exception handler.
     * @return array of git repositories
     */
    public CompletableFuture<Repositories> listAsync(Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        var reqInfo = toGetRequestInformation();

        if (requestConfiguration != null) {
            final var config = new RequestConfiguration();
            requestConfiguration.accept(config);
            reqInfo.setQueryParameters(config.queryParameters);
        }

        return requestAdapter.sendAsync(reqInfo, Repositories.class);
    }

    /***
     * Updates the Git repository with either a new repo name or a new default branch.
     * @param repositoryId provide the repository id
     * @param gitRepository Git repository object to update.
     * @throws AzDException Default Api Exception handler.
     * @return a future repository object {@link GitRepository}
     */
    public CompletableFuture<GitRepository> updateAsync(String repositoryId, GitRepository gitRepository) throws AzDException {
        var reqInfo = toPatchRequestInformation(gitRepository);
        reqInfo.serviceEndpoint = service + "/" + repositoryId;
        return requestAdapter.sendAsync(reqInfo, GitRepository.class);
    }

    /***
     * Create a git repository in a team project.
     * @param repositoryRequest New repository request.
     * @throws AzDException Default Api Exception handler.
     * @return git repository object {@link GitRepository}
     */
    public GitRepository create(RepositoryRequest repositoryRequest) throws AzDException {
        return requestAdapter.send(toPostRequestInformation(repositoryRequest), GitRepository.class);
    }

    /***
     * Delete a git repository
     * @param repositoryId pass the repository id
     * @throws AzDException Default Api Exception handler.
     */
    public Void delete(String repositoryId) throws AzDException {
        var reqInfo = toDeleteRequestInformation();
        reqInfo.serviceEndpoint = service + "/" + repositoryId;
        return requestAdapter.sendPrimitive(reqInfo);
    }

    /***
     * Retrieve deleted git repositories.
     * @throws AzDException Default Api Exception handler.
     * @return Git deleted repository object {@link GitDeletedRepositories}
     */
    public GitDeletedRepositories listDeleted() throws AzDException {
        var reqInfo = toGetRequestInformation();
        reqInfo.serviceEndpoint = service.replace("repositories", "deletedrepositories");
        return requestAdapter.send(reqInfo, GitDeletedRepositories.class);
    }

    /***
     * Retrieve a git repository.
     * @param repositoryName pass the repository name
     * @throws AzDException Default Api Exception handler.
     * @return git repository object {@link GitRepository}
     */
    public GitRepository get(String repositoryName) throws AzDException {
        var reqInfo = toGetRequestInformation();
        reqInfo.serviceEndpoint = service + "/" + repositoryName;
        return requestAdapter.send(reqInfo, GitRepository.class);
    }

    /***
     * Retrieve a git repository with parent.
     * @param repositoryName pass the repository name
     * @param includeParent True to include parent repository.
     * @throws AzDException Default Api Exception handler.
     * @return git repository object {@link GitRepository}
     */
    public GitRepository get(String repositoryName, boolean includeParent) throws AzDException {
        var reqInfo = toGetRequestInformation();
        reqInfo.serviceEndpoint = service + "/" + repositoryName;
        reqInfo.setQueryParameter("includeParent", includeParent);
        return requestAdapter.send(reqInfo, GitRepository.class);
    }

    /***
     * Retrieve git repositories.
     * @throws AzDException Default Api Exception handler.
     * @return array of git repositories
     */
    public Repositories list() throws AzDException {
        return requestAdapter.send(toGetRequestInformation(), Repositories.class);
    }

    /***
     * Retrieve git repositories.
     * @param requestConfiguration Consumer of request configuration. This represents the query parameter for the request.
     * @throws AzDException Default Api Exception handler.
     * @return array of git repositories
     */
    public Repositories list(Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        var reqInfo = toGetRequestInformation();

        if (requestConfiguration != null) {
            final var config = new RequestConfiguration();
            requestConfiguration.accept(config);
            reqInfo.setQueryParameters(config.queryParameters);
        }

        return requestAdapter.send(reqInfo, Repositories.class);
    }

    /***
     * Updates the Git repository with either a new repo name or a new default branch.
     * @param repositoryId provide the repository id
     * @param gitRepository Git repository object to update.
     * @throws AzDException Default Api Exception handler.
     * @return a future repository object {@link GitRepository}
     */
    public GitRepository update(String repositoryId, GitRepository gitRepository) throws AzDException {
        var reqInfo = toPatchRequestInformation(gitRepository);
        reqInfo.serviceEndpoint = service + "/" + repositoryId;
        return requestAdapter.send(reqInfo, GitRepository.class);
    }

    /**
     * Represents the query parameters.
     */
    public static class GetQueryParameters {
        /**
         * True to include all remote URLs. The default value is false.
         */
        @QueryParameter(name = "includeAllUrls")
        public Boolean includeAllUrls;
        /**
         * True to include hidden repositories. The default value is false.
         */
        @QueryParameter(name = "includeHidden")
        public Boolean includeHidden;
        /**
         * True to include reference links. The default value is false.
         */
        @QueryParameter(name = "includeLinks")
        public Boolean includeLinks;
    }

    /**
     * Request configuration object for the query parameters.
     */
    public static class RequestConfiguration {
        public GetQueryParameters queryParameters = new GetQueryParameters();
    }

}
