package org.azd.workitemtracking.workitemtypes;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.authentication.AccessTokenCredential;
import org.azd.common.ApiVersion;
import org.azd.exceptions.AzDException;
import org.azd.helpers.URLHelper;
import org.azd.workitemtracking.types.WorkItemType;
import org.azd.workitemtracking.types.WorkItemTypes;

import java.util.concurrent.CompletableFuture;

/**
 * Provides functionality to work with Work item types Api.
 */
public class WorkItemTypesRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public WorkItemTypesRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential, "wit", "7c8d7a76-4a09-43e8-b5df-bd792f4ac6aa", ApiVersion.WORK_ITEM_TYPES);
    }

    /**
     * Returns a work item type definition.
     *
     * @param type Work item type name
     * @return Work item type. {@link WorkItemType}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<WorkItemType> getAsync(String type) throws AzDException {
        return builder()
                .serviceEndpoint("type", URLHelper.encodeSpecialWithSpace(type))
                .build()
                .executeAsync(WorkItemType.class);
    }

    /**
     * Returns the list of work item types
     *
     * @return Collection of work item types {@link WorkItemTypes}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<WorkItemTypes> listAsync() throws AzDException {
        return builder()
                .build()
                .executeAsync(WorkItemTypes.class);
    }

    /**
     * Returns a work item type definition.
     *
     * @param type Work item type name
     * @return Work item type. {@link WorkItemType}
     * @throws AzDException Default Api exception handler.
     */
    public WorkItemType get(String type) throws AzDException {
        return builder()
                .serviceEndpoint("type", URLHelper.encodeSpecialWithSpace(type))
                .build()
                .execute(WorkItemType.class);
    }

    /**
     * Returns the list of work item types
     *
     * @return Collection of work item types {@link WorkItemTypes}
     * @throws AzDException Default Api exception handler.
     */
    public WorkItemTypes list() throws AzDException {
        return builder()
                .build()
                .execute(WorkItemTypes.class);
    }
}
