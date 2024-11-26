package org.azd.release.folders;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.authentication.AccessTokenCredential;
import org.azd.build.types.Folders;
import org.azd.common.ApiVersion;
import org.azd.enums.FolderPathQueryOrder;
import org.azd.exceptions.AzDException;
import org.azd.helpers.URLHelper;
import org.azd.release.types.Folder;

import java.util.concurrent.CompletableFuture;

/**
 * Provides functionality to work with Release folders Api.
 */
public class ReleaseFoldersRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public ReleaseFoldersRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential, "release", "f7ddf76d-ce0c-4d68-94ff-becaec5d9dea", ApiVersion.RELEASE_FOLDERS);
    }

    /**
     * Deletes a definition folder for given folder name and path and all it's existing definitions.
     *
     * @param path Path of the folder to delete.
     * @throws AzDException Default Api exception handler
     */
    public CompletableFuture<Void> deleteAsync(String path) throws AzDException {
        return builder()
                .DELETE()
                .serviceEndpoint("path", URLHelper.encodeSpecialWithSpace(path))
                .build()
                .executePrimitiveAsync();
    }

    /**
     * Gets folders.
     *
     * @param path Path of the folder.
     * @return Collection of folder object {@link Folders}
     * @throws AzDException Default Api exception handler
     */
    public CompletableFuture<Folders> listAsync(String path) throws AzDException {
        return builder()
                .serviceEndpoint("path", URLHelper.encodeSpecialWithSpace(path))
                .build()
                .executeAsync(Folders.class);
    }

    /**
     * Gets folders.
     *
     * @param path Path of the folder.
     * @return Collection of folder object {@link Folders}
     * @throws AzDException Default Api exception handler
     */
    public CompletableFuture<Folders> listAsync(String path, FolderPathQueryOrder queryOrder) throws AzDException {
        return builder()
                .serviceEndpoint("path", URLHelper.encodeSpecialWithSpace(path))
                .query("queryOrder", queryOrder.name())
                .build()
                .executeAsync(Folders.class);
    }

    /**
     * Updates an existing folder at given existing path.
     *
     * @param path Path of the folder.
     * @param folder Folder object to update.
     * @return A folder object {@link Folder}
     * @throws AzDException Default Api exception handler
     */
    public CompletableFuture<Folder> updateAsync(String path, Folder folder) throws AzDException {
        return builder()
                .PATCH(folder)
                .serviceEndpoint("path", URLHelper.encodeSpecialWithSpace(path))
                .build()
                .executeAsync(Folder.class);
    }

    /**
     * Deletes a definition folder for given folder name and path and all it's existing definitions.
     *
     * @param path Path of the folder to delete.
     * @throws AzDException Default Api exception handler
     */
    public Void delete(String path) throws AzDException {
        return builder()
                .DELETE()
                .serviceEndpoint("path", URLHelper.encodeSpecialWithSpace(path))
                .build()
                .executePrimitive();
    }

    /**
     * Gets folders.
     *
     * @param path Path of the folder.
     * @return Collection of folder object {@link Folders}
     * @throws AzDException Default Api exception handler
     */
    public Folders list(String path) throws AzDException {
        return builder()
                .serviceEndpoint("path", URLHelper.encodeSpecialWithSpace(path))
                .build()
                .execute(Folders.class);
    }

    /**
     * Gets folders.
     *
     * @param path Path of the folder.
     * @return Collection of folder object {@link Folders}
     * @throws AzDException Default Api exception handler
     */
    public Folders list(String path, FolderPathQueryOrder queryOrder) throws AzDException {
        return builder()
                .serviceEndpoint("path", URLHelper.encodeSpecialWithSpace(path))
                .query("queryOrder", queryOrder.name())
                .build()
                .execute(Folders.class);
    }

    /**
     * Updates an existing folder at given existing path.
     *
     * @param path Path of the folder.
     * @param folder Folder object to update.
     * @return A folder object {@link Folder}
     * @throws AzDException Default Api exception handler
     */
    public Folder update(String path, Folder folder) throws AzDException {
        return builder()
                .PATCH(folder)
                .serviceEndpoint("path", URLHelper.encodeSpecialWithSpace(path))
                .build()
                .execute(Folder.class);
    }

}
