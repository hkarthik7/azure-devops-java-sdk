package org.azd.build.folders;

import org.azd.build.types.Folder;
import org.azd.build.types.Folders;
import org.azd.common.ApiVersion;
import org.azd.enums.FolderQueryOrder;
import org.azd.exceptions.AzDException;
import org.azd.helpers.URLHelper;
import org.azd.interfaces.AccessTokenCredential;
import org.azd.interfaces.RequestAdapter;
import org.azd.utils.BaseRequestBuilder;

import java.util.concurrent.CompletableFuture;

/**
 * Provides methods for working with folders of build definitions.
 */
public class FoldersRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new request builder instance and sets the default values.
     * @param accessTokenCredential Authentication provider {@link AccessTokenCredential}.
     * @param requestAdapter The request adapter to execute the requests.
     */
    public FoldersRequestBuilder(AccessTokenCredential accessTokenCredential, RequestAdapter requestAdapter) {
        super(accessTokenCredential, requestAdapter, "build/folders", ApiVersion.BUILD_FOLDER);
    }

    /**
     * Creates a new folder.
     *
     * @param path The full path of the folder.
     * @param folder Folder object with mandatory details.
     * @return Folder Object {@link Folder}
     * @throws AzDException Default Api Exception handler.
     **/
    public CompletableFuture<Folder> create(String path, Folder folder) throws AzDException {
        var reqInfo = toPutRequestInformation(folder);
        reqInfo.setQueryParameter("path", URLHelper.encodeSpecialWithSpace(path));

        return requestAdapter.sendAsync(reqInfo, Folder.class);
    }

    /**
     * Deletes a definition folder. Definitions and their corresponding builds will also be deleted.
     *
     * @param path The full path to the folder.
     * @throws AzDException Default Api Exception handler.
     **/
    public CompletableFuture<Void> delete(String path) throws AzDException {
        var reqInfo = toDeleteRequestInformation();
        reqInfo.setQueryParameter("path", URLHelper.encodeSpecialWithSpace(path));

        return requestAdapter.sendPrimitiveAsync(reqInfo);
    }

    /**
     * Gets a list of build definition folders.
     *
     * @return List of folder Object {@link Folders}
     * @throws AzDException Default Api Exception handler.
     **/
    public CompletableFuture<Folders> list() throws AzDException {
        var reqInfo = toGetRequestInformation();

        return requestAdapter.sendAsync(reqInfo, Folders.class);
    }

    /**
     * Gets a list of build definition folders.
     *
     * @return List of folder Object {@link Folders}
     * @throws AzDException Default Api Exception handler.
     **/
    public CompletableFuture<Folders> list(String path, FolderQueryOrder queryOrder) throws AzDException {
        var reqInfo = toGetRequestInformation();
        reqInfo.setQueryParameter("path", path);
        reqInfo.setQueryParameter("queryOrder", queryOrder);

        return requestAdapter.sendAsync(reqInfo, Folders.class);
    }

    /**
     * Updates an existing folder at given  existing path
     *
     * @param path The full path to the folder.
     * @return Folder Object {@link Folder}
     * @throws AzDException Default Api Exception handler.
     **/
    public CompletableFuture<Folder> update(String path, Folder folder) throws AzDException {
        var reqInfo = toPostRequestInformation(folder);
        reqInfo.setQueryParameter("path", path);

        return requestAdapter.sendAsync(reqInfo, Folder.class);
    }
}
