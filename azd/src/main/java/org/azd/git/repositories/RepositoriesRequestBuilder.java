package org.azd.git.repositories;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.abstractions.QueryParameter;
import org.azd.authentication.AccessTokenCredential;
import org.azd.exceptions.AzDException;
import org.azd.git.types.GitDeletedRepositories;
import org.azd.git.types.GitRepository;
import org.azd.git.types.Repositories;
import org.azd.git.types.RepositoryRequest;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

/**
 * Repositories request builder to manage Git repositories Api.
 */
public class RepositoriesRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public RepositoriesRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential, "git", "225f7195-f9c7-4d14-ab28-a83f7ff77e1f");


    }

    /**
     * Request builder to manage recycle bin repositories.
     *
     * @return RecycleBinRepositoriesRequestBuilder {@link RecycleBinRepositoriesRequestBuilder}.
     */
    public RecycleBinRepositoriesRequestBuilder recycleBin() {
        return new RecycleBinRepositoriesRequestBuilder(organizationUrl, accessTokenCredential);
    }

    /**
     * Create a git repository in a team project.
     *
     * @param repositoryRequest New repository request.
     * @return git repository object {@link GitRepository}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<GitRepository> createAsync(RepositoryRequest repositoryRequest) throws AzDException {
        return builder()
                .POST(repositoryRequest)
                .build()
                .executeAsync(GitRepository.class);
    }

    /**
     * Create a git repository in a team project.
     *
     * @param repositoryRequest New repository request.
     * @param sourceRef         Specify the source refs to use while creating a fork repo
     * @return git repository object {@link GitRepository}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<GitRepository> createAsync(RepositoryRequest repositoryRequest, String sourceRef) throws AzDException {
        return builder()
                .POST(repositoryRequest)
                .query("sourceRef", sourceRef)
                .build()
                .executeAsync(GitRepository.class);
    }

    /**
     * Delete a git repository
     *
     * @param repositoryId pass the repository id
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<Void> deleteAsync(String repositoryId) throws AzDException {
        return builder()
                .DELETE()
                .serviceEndpoint("repositoryId", repositoryId)
                .build()
                .executePrimitiveAsync();
    }

    /**
     * Retrieve deleted git repositories.
     *
     * @return Git deleted repository object {@link GitDeletedRepositories}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<GitDeletedRepositories> listDeletedAsync() throws AzDException {
        return builder()
                .location("2b6869c4-cb25-42b5-b7a3-0d3e6be0a11a")
                .build()
                .executeAsync(GitDeletedRepositories.class);
    }

    /**
     * Retrieve a git repository.
     *
     * @param repositoryName pass the repository name
     * @return git repository object {@link GitRepository}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<GitRepository> getAsync(String repositoryName) throws AzDException {
        return builder()
                .serviceEndpoint("repositoryId", repositoryName)
                .build()
                .executeAsync(GitRepository.class);
    }

    /**
     * Retrieve a git repository with parent.
     *
     * @param repositoryName pass the repository name
     * @param includeParent  True to include parent repository.
     * @return git repository object {@link GitRepository}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<GitRepository> getAsync(String repositoryName, boolean includeParent) throws AzDException {
        return builder()
                .serviceEndpoint("repositoryId", repositoryName)
                .query("includeParent", includeParent)
                .build()
                .executeAsync(GitRepository.class);
    }

    /**
     * Retrieve git repositories.
     *
     * @return array of git repositories
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<Repositories> listAsync() throws AzDException {
        return builder()
                .build()
                .executeAsync(Repositories.class);
    }

    /**
     * Retrieve git repositories.
     *
     * @param requestConfiguration Consumer of request configuration. This represents the query parameter for the request.
     * @return array of git repositories
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<Repositories> listAsync(Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .executeAsync(Repositories.class);
    }

    /**
     * Updates the Git repository with either a new repo name or a new default branch.
     *
     * @param repositoryId  provide the repository id
     * @param gitRepository Git repository object to update.
     * @return a future repository object {@link GitRepository}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<GitRepository> updateAsync(String repositoryId, GitRepository gitRepository) throws AzDException {
        return builder()
                .PATCH(gitRepository)
                .serviceEndpoint("repositoryId", repositoryId)
                .build()
                .executeAsync(GitRepository.class);
    }

    /**
     * Create a git repository in a team project.
     *
     * @param repositoryRequest New repository request.
     * @return git repository object {@link GitRepository}
     * @throws AzDException Default Api Exception handler.
     */
    public GitRepository create(RepositoryRequest repositoryRequest) throws AzDException {
        return builder()
                .POST(repositoryRequest)
                .build()
                .execute(GitRepository.class);
    }

    /**
     * Create a git repository in a team project.
     *
     * @param repositoryRequest New repository request.
     * @param sourceRef         Specify the source refs to use while creating a fork repo
     * @return git repository object {@link GitRepository}
     * @throws AzDException Default Api Exception handler.
     */
    public GitRepository create(RepositoryRequest repositoryRequest, String sourceRef) throws AzDException {
        return builder()
                .POST(repositoryRequest)
                .query("sourceRef", sourceRef)
                .build()
                .execute(GitRepository.class);
    }

    /**
     * Delete a git repository
     *
     * @param repositoryId pass the repository id
     * @throws AzDException Default Api Exception handler.
     */
    public Void delete(String repositoryId) throws AzDException {
        return builder()
                .DELETE()
                .serviceEndpoint("repositoryId", repositoryId)
                .build()
                .executePrimitive();
    }

    /**
     * Retrieve deleted git repositories.
     *
     * @return Git deleted repository object {@link GitDeletedRepositories}
     * @throws AzDException Default Api Exception handler.
     */
    public GitDeletedRepositories listDeleted() throws AzDException {
        return builder()
                .location("2b6869c4-cb25-42b5-b7a3-0d3e6be0a11a")
                .build()
                .execute(GitDeletedRepositories.class);
    }

    /**
     * Retrieve a git repository.
     *
     * @param repositoryName pass the repository name
     * @return git repository object {@link GitRepository}
     * @throws AzDException Default Api Exception handler.
     */
    public GitRepository get(String repositoryName) throws AzDException {
        return builder()
                .serviceEndpoint("repositoryId", repositoryName)
                .build()
                .execute(GitRepository.class);
    }

    /**
     * Retrieve a git repository with parent.
     *
     * @param repositoryName pass the repository name
     * @param includeParent  True to include parent repository.
     * @return git repository object {@link GitRepository}
     * @throws AzDException Default Api Exception handler.
     */
    public GitRepository get(String repositoryName, boolean includeParent) throws AzDException {
        return builder()
                .serviceEndpoint("repositoryId", repositoryName)
                .query("includeParent", includeParent)
                .build()
                .execute(GitRepository.class);
    }

    /**
     * Retrieve git repositories.
     *
     * @return array of git repositories
     * @throws AzDException Default Api Exception handler.
     */
    public Repositories list() throws AzDException {
        return builder()
                .build()
                .execute(Repositories.class);
    }

    /**
     * Retrieve git repositories.
     *
     * @param requestConfiguration Consumer of request configuration. This represents the query parameter for the request.
     * @return array of git repositories
     * @throws AzDException Default Api Exception handler.
     */
    public Repositories list(Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .execute(Repositories.class);
    }

    /**
     * Updates the Git repository with either a new repo name or a new default branch.
     *
     * @param repositoryId  provide the repository id
     * @param gitRepository Git repository object to update.
     * @return a future repository object {@link GitRepository}
     * @throws AzDException Default Api Exception handler.
     */
    public GitRepository update(String repositoryId, GitRepository gitRepository) throws AzDException {
        return builder()
                .PATCH(gitRepository)
                .serviceEndpoint("repositoryId", repositoryId)
                .build()
                .execute(GitRepository.class);
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

