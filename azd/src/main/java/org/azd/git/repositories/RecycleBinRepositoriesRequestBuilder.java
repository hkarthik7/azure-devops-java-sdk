package org.azd.git.repositories;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.authentication.AccessTokenCredential;
import org.azd.exceptions.AzDException;
import org.azd.git.types.GitDeletedRepositories;
import org.azd.git.types.GitRepository;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Recycle bin repositories request builder to manage Git recycle bin repositories Api.
 */
public class RecycleBinRepositoriesRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public RecycleBinRepositoriesRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential, "git", "a663da97-81db-4eb3-8b83-287670f63073");
    }

    /**
     * Destroy (hard delete) a soft-deleted Git repository.
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
     * Retrieve soft-deleted git repositories from the recycle bin.
     *
     * @return array of git deleted recycle bin repositories
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<GitDeletedRepositories> listAsync() throws AzDException {
        return builder()
                .build()
                .executeAsync(GitDeletedRepositories.class);
    }

    /**
     * Recover a soft-deleted Git repository. Recently deleted repositories go
     * into a soft-delete state for a period of time before they are hard
     * deleted and become unrecoverable.
     *
     * @param repositoryId pass the repository id
     * @param deleted      Setting to false will undo earlier deletion and restore the repository.
     * @return object of git repository {@link GitRepository}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<GitRepository> restoreAsync(String repositoryId, boolean deleted) throws AzDException {
        return builder()
                .PATCH(Map.of("deleted", deleted))
                .serviceEndpoint("repositoryId", repositoryId)
                .build()
                .executeAsync(GitRepository.class);
    }

    /**
     * Destroy (hard delete) a soft-deleted Git repository.
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
     * Retrieve soft-deleted git repositories from the recycle bin.
     *
     * @return array of git deleted recycle bin repositories
     * @throws AzDException Default Api Exception handler.
     */
    public GitDeletedRepositories list() throws AzDException {
        return builder()
                .build()
                .execute(GitDeletedRepositories.class);
    }

    /**
     * Recover a soft-deleted Git repository. Recently deleted repositories go
     * into a soft-delete state for a period of time before they are hard
     * deleted and become unrecoverable.
     *
     * @param repositoryId pass the repository id
     * @param deleted      Setting to false will undo earlier deletion and restore the repository.
     * @return object of git repository {@link GitRepository}
     * @throws AzDException Default Api Exception handler.
     */
    public GitRepository restore(String repositoryId, boolean deleted) throws AzDException {
        return builder()
                .PATCH(Map.of("deleted", deleted))
                .serviceEndpoint("repositoryId", repositoryId)
                .build()
                .execute(GitRepository.class);
    }
}
