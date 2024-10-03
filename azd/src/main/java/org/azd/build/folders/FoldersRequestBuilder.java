package org.azd.build.folders;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.authentication.AccessTokenCredential;
import org.azd.build.types.Folder;
import org.azd.build.types.Folders;
import org.azd.enums.FolderQueryOrder;
import org.azd.exceptions.AzDException;
import org.azd.helpers.URLHelper;

import java.util.concurrent.CompletableFuture;

/**
 * Provides methods for working with folders of build definitions.
 */
public class FoldersRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public FoldersRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential, "build", "a906531b-d2da-4f55-bda7-f3e676cc50d9");
    }

    /**
     * Creates a new folder.
     *
     * @param path   The full path of the folder.
     * @param folder Folder object with mandatory details.
     * @return Folder Object {@link Folder}
     * @throws AzDException Default Api Exception handler.
     **/
    public CompletableFuture<Folder> createAsync(String path, Folder folder) throws AzDException {
        return builder()
                .PUT(folder)
                .query("path", URLHelper.encodeSpace(path))
                .build()
                .executeAsync(Folder.class);
    }

    /**
     * Deletes a definition folder. Definitions and their corresponding builds will also be deleted.
     *
     * @param path The full path to the folder.
     * @throws AzDException Default Api Exception handler.
     **/
    public CompletableFuture<Void> deleteAsync(String path) throws AzDException {
        return builder()
                .DELETE()
                .query("path", URLHelper.encodeSpace(path))
                .build()
                .executePrimitiveAsync();
    }

    /**
     * Gets a list of build definition folders.
     *
     * @return List of folder Object {@link Folders}
     * @throws AzDException Default Api Exception handler.
     **/
    public CompletableFuture<Folders> listAsync() throws AzDException {
        return builder()
                .build()
                .executeAsync(Folders.class);
    }

    /**
     * Gets a list of build definition folders.
     *
     * @return List of folder Object {@link Folders}
     * @throws AzDException Default Api Exception handler.
     **/
    public CompletableFuture<Folders> listAsync(String path, FolderQueryOrder queryOrder) throws AzDException {
        return builder()
                .serviceEndpoint("path", URLHelper.encodeSpace(path))
                .query("queryOrder", queryOrder)
                .build()
                .executeAsync(Folders.class);
    }

    /**
     * Updates an existing folder at given  existing path
     *
     * @param path The full path to the folder.
     * @return Folder Object {@link Folder}
     * @throws AzDException Default Api Exception handler.
     **/
    public CompletableFuture<Folder> updateAsync(String path, Folder folder) throws AzDException {
        String finalPath = path;
        if (!finalPath.isEmpty()) if (finalPath.equals("+\\")) finalPath = "\\" + finalPath;

        return builder()
                .POST(folder)
                .query("path", URLHelper.encodeSpace(finalPath))
                .build()
                .executeAsync(Folder.class);
    }

    /**
     * Creates a new folder.
     *
     * @param path   The full path of the folder.
     * @param folder Folder object with mandatory details.
     * @return Folder Object {@link Folder}
     * @throws AzDException Default Api Exception handler.
     **/
    public Folder create(String path, Folder folder) throws AzDException {
        return builder()
                .PUT(folder)
                .query("path", URLHelper.encodeSpace(path))
                .build()
                .execute(Folder.class);
    }

    /**
     * Deletes a definition folder. Definitions and their corresponding builds will also be deleted.
     *
     * @param path The full path to the folder.
     * @throws AzDException Default Api Exception handler.
     **/
    public Void delete(String path) throws AzDException {
        return builder()
                .DELETE()
                .query("path", URLHelper.encodeSpace(path))
                .build()
                .executePrimitive();
    }

    /**
     * Gets a list of build definition folders.
     *
     * @return List of folder Object {@link Folders}
     * @throws AzDException Default Api Exception handler.
     **/
    public Folders list() throws AzDException {
        return builder()
                .build()
                .execute(Folders.class);
    }

    /**
     * Gets a list of build definition folders.
     *
     * @return List of folder Object {@link Folders}
     * @throws AzDException Default Api Exception handler.
     **/
    public Folders list(String path, FolderQueryOrder queryOrder) throws AzDException {
        return builder()
                .serviceEndpoint("path", URLHelper.encodeSpace(path))
                .query("queryOrder", queryOrder)
                .build()
                .execute(Folders.class);
    }

    /**
     * Updates an existing folder at given  existing path
     *
     * @param path The full path to the folder.
     * @return Folder Object {@link Folder}
     * @throws AzDException Default Api Exception handler.
     **/
    public Folder update(String path, Folder folder) throws AzDException {
        String finalPath = path;
        if (!finalPath.isEmpty()) if (finalPath.equals("+\\")) finalPath = "\\" + finalPath;

        return builder()
                .POST(folder)
                .query("path", URLHelper.encodeSpace(finalPath))
                .build()
                .execute(Folder.class);
    }
}
