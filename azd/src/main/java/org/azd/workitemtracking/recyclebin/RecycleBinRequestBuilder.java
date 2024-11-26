package org.azd.workitemtracking.recyclebin;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.authentication.AccessTokenCredential;
import org.azd.common.ApiVersion;
import org.azd.exceptions.AzDException;
import org.azd.helpers.Utils;
import org.azd.workitemtracking.types.WorkItemDelete;
import org.azd.workitemtracking.types.WorkItemDeleteReferences;
import org.azd.workitemtracking.types.WorkItemDeleteShallowReferences;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Provides functionality to work with Work item recycle bin Api.
 */
public class RecycleBinRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public RecycleBinRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential, "wit", "b70d8d39-926c-465e-b927-b1bf0e5ca0e0", ApiVersion.WIT_RECYCLE_BIN);
    }

    /**
     * Destroys the specified work item permanently from the Recycle Bin. This action can not be undone.
     *
     * @param id ID of the work item to be destroyed permanently
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<Void> destroyAsync(int id) throws AzDException {
        return builder()
                .DELETE()
                .serviceEndpoint("id", id)
                .build()
                .executePrimitiveAsync();
    }

    /**
     * Gets a deleted work item from Recycle Bin.
     *
     * @param id ID of the work item to be returned
     * @return Work item delete object {@link WorkItemDelete}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<WorkItemDelete> getAsync(int id) throws AzDException {
        return builder()
                .serviceEndpoint("id", id)
                .build()
                .executeAsync(WorkItemDelete.class);
    }

    /**
     * Gets a list of the IDs and the URLs of the deleted the work items in the Recycle Bin.
     *
     * @return Collection of WorkItemDeleteShallowReference {@link WorkItemDeleteShallowReferences}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<WorkItemDeleteShallowReferences> listAsync() throws AzDException {
        return builder()
                .build()
                .executeAsync(WorkItemDeleteShallowReferences.class);
    }

    /**
     * Gets the work items from the recycle bin, whose IDs have been specified in the parameters
     *
     * @param ids Array of IDs of the deleted work items to be returned
     * @return Collection of WorkItemDeleteReference {@link WorkItemDeleteReferences}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<WorkItemDeleteReferences> listAsync(int... ids) throws AzDException {
        return builder()
                .query("ids", Utils.toString(ids))
                .build()
                .executeAsync(WorkItemDeleteReferences.class);
    }

    /**
     * Restores the deleted work item from Recycle Bin.
     *
     * @param id        ID of the work item to be restored
     * @param isDeleted Sets a value indicating whether this work item is deleted.
     * @return Work item delete object {@link WorkItemDelete}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<WorkItemDelete> restoreAsync(int id, boolean isDeleted) throws AzDException {
        return builder()
                .PATCH(Map.of("isDeleted", isDeleted))
                .serviceEndpoint("id", id)
                .build()
                .executeAsync(WorkItemDelete.class);
    }

    /**
     * Destroys the specified work item permanently from the Recycle Bin. This action can not be undone.
     *
     * @param id ID of the work item to be destroyed permanently
     * @throws AzDException Default Api exception handler.
     */
    public Void destroy(int id) throws AzDException {
        return builder()
                .DELETE()
                .serviceEndpoint("id", id)
                .build()
                .executePrimitive();
    }

    /**
     * Gets a deleted work item from Recycle Bin.
     *
     * @param id ID of the work item to be returned
     * @return Work item delete object {@link WorkItemDelete}
     * @throws AzDException Default Api exception handler.
     */
    public WorkItemDelete get(int id) throws AzDException {
        return builder()
                .serviceEndpoint("id", id)
                .build()
                .execute(WorkItemDelete.class);
    }

    /**
     * Gets a list of the IDs and the URLs of the deleted the work items in the Recycle Bin.
     *
     * @return Collection of WorkItemDeleteShallowReference {@link WorkItemDeleteShallowReferences}
     * @throws AzDException Default Api exception handler.
     */
    public WorkItemDeleteShallowReferences list() throws AzDException {
        return builder()
                .build()
                .execute(WorkItemDeleteShallowReferences.class);
    }

    /**
     * Gets the work items from the recycle bin, whose IDs have been specified in the parameters
     *
     * @param ids Array of IDs of the deleted work items to be returned
     * @return Collection of WorkItemDeleteReference {@link WorkItemDeleteReferences}
     * @throws AzDException Default Api exception handler.
     */
    public WorkItemDeleteReferences list(int... ids) throws AzDException {
        return builder()
                .query("ids", Utils.toString(ids))
                .build()
                .execute(WorkItemDeleteReferences.class);
    }

    /**
     * Restores the deleted work item from Recycle Bin.
     *
     * @param id        ID of the work item to be restored
     * @param isDeleted Sets a value indicating whether this work item is deleted.
     * @return Work item delete object {@link WorkItemDelete}
     * @throws AzDException Default Api exception handler.
     */
    public WorkItemDelete restore(int id, boolean isDeleted) throws AzDException {
        return builder()
                .PATCH(Map.of("isDeleted", isDeleted))
                .serviceEndpoint("id", id)
                .build()
                .execute(WorkItemDelete.class);
    }
}
