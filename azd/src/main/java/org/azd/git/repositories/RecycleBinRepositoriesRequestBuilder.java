package org.azd.git.repositories;

import org.azd.common.ApiVersion;
import org.azd.exceptions.AzDException;
import org.azd.git.types.GitDeletedRepositories;
import org.azd.git.types.GitRepository;
import org.azd.interfaces.AccessTokenCredential;
import org.azd.interfaces.RequestAdapter;
import org.azd.utils.BaseRequestBuilder;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Recycle bin repositories request builder to manage Git recycle bin repositories Api.
 */
public class RecycleBinRepositoriesRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new request builder instance and sets the default values.
     * @param accessTokenCredential Authentication provider {@link AccessTokenCredential}.
     * @param requestAdapter The request adapter to execute the requests.
     */
    public RecycleBinRepositoriesRequestBuilder(AccessTokenCredential accessTokenCredential, RequestAdapter requestAdapter) {
        super(accessTokenCredential, requestAdapter, "git/recycleBin/repositories", ApiVersion.GIT);
    }

    /***
     * Destroy (hard delete) a soft-deleted Git repository.
     * @param repositoryId pass the repository id
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<Void> deleteAsync(String repositoryId) throws AzDException {
        var reqInfo = toDeleteRequestInformation();
        reqInfo.serviceEndpoint = service + "/" + repositoryId;
        return requestAdapter.sendPrimitiveAsync(reqInfo);
    }

    /***
     * Retrieve soft-deleted git repositories from the recycle bin.
     * @throws AzDException Default Api Exception handler.
     * @return array of git deleted recycle bin repositories
     */
    public CompletableFuture<GitDeletedRepositories> listAsync() throws AzDException {
        return requestAdapter.sendAsync(toGetRequestInformation(), GitDeletedRepositories.class);
    }

    /***
     * Recover a soft-deleted Git repository. Recently deleted repositories go
     * into a soft-delete state for a period of time before they are hard
     * deleted and become unrecoverable.
     * @param repositoryId pass the repository id
     * @param deleted Setting to false will undo earlier deletion and restore the repository.
     * @throws AzDException Default Api Exception handler.
     * @return object of git repository {@link GitRepository}
     */
    public CompletableFuture<GitRepository> restoreAsync(String repositoryId, boolean deleted) throws AzDException {
        var reqInfo = toPatchRequestInformation(Map.of("deleted", deleted));
        reqInfo.serviceEndpoint = service + "/" + repositoryId;
        return requestAdapter.sendAsync(reqInfo, GitRepository.class);
    }

    /***
     * Destroy (hard delete) a soft-deleted Git repository.
     * @param repositoryId pass the repository id
     * @throws AzDException Default Api Exception handler.
     */
    public Void delete(String repositoryId) throws AzDException {
        var reqInfo = toDeleteRequestInformation();
        reqInfo.serviceEndpoint = service + "/" + repositoryId;
        return requestAdapter.sendPrimitive(reqInfo);
    }

    /***
     * Retrieve soft-deleted git repositories from the recycle bin.
     * @throws AzDException Default Api Exception handler.
     * @return array of git deleted recycle bin repositories
     */
    public GitDeletedRepositories list() throws AzDException {
        return requestAdapter.send(toGetRequestInformation(), GitDeletedRepositories.class);
    }

    /***
     * Recover a soft-deleted Git repository. Recently deleted repositories go
     * into a soft-delete state for a period of time before they are hard
     * deleted and become unrecoverable.
     * @param repositoryId pass the repository id
     * @param deleted Setting to false will undo earlier deletion and restore the repository.
     * @throws AzDException Default Api Exception handler.
     * @return object of git repository {@link GitRepository}
     */
    public GitRepository restore(String repositoryId, boolean deleted) throws AzDException {
        var reqInfo = toPatchRequestInformation(Map.of("deleted", deleted));
        reqInfo.serviceEndpoint = service + "/" + repositoryId;
        return requestAdapter.send(reqInfo, GitRepository.class);
    }
}
