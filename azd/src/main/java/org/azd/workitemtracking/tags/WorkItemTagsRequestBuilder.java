package org.azd.workitemtracking.tags;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.authentication.AccessTokenCredential;
import org.azd.common.ApiVersion;
import org.azd.exceptions.AzDException;
import org.azd.workitemtracking.types.WorkItemTagDefinition;
import org.azd.workitemtracking.types.WorkItemTagDefinitions;

import java.util.concurrent.CompletableFuture;

/**
 * Provides functionality to work with Work item tags Api.
 */
public class WorkItemTagsRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public WorkItemTagsRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential, "wit", "bc15bc60-e7a8-43cb-ab01-2106be3983a1", ApiVersion.WORK_ITEM_TAGS);
    }

    /**
     * Delete the tag for the project. Please note, that the deleted tag will be removed from all Work Items as well as Pull Requests.
     *
     * @param tagIdOrName Tag ID or tag name.
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<Void> deleteAsync(String tagIdOrName) throws AzDException {
        return builder()
                .DELETE()
                .serviceEndpoint("tagIdOrName", tagIdOrName)
                .build()
                .executePrimitiveAsync();
    }

    /**
     * Get the tag for the project.
     *
     * @param tagIdOrName Tag ID or tag name.
     * @return Work item tag definition. {@link WorkItemTagDefinition}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<WorkItemTagDefinition> getAsync(String tagIdOrName) throws AzDException {
        return builder()
                .serviceEndpoint("tagIdOrName", tagIdOrName)
                .build()
                .executeAsync(WorkItemTagDefinition.class);
    }

    /**
     * Get all the tags for the project.
     *
     * @return Collection of Work item tag definition object {@link WorkItemTagDefinitions}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<WorkItemTagDefinitions> listAsync() throws AzDException {
        return builder()
                .build()
                .executeAsync(WorkItemTagDefinitions.class);
    }

    /**
     * Update the tag for the project.
     *
     * @param tagIdOrName           Tag ID or tag name.
     * @param workItemTagDefinition Work item tag object to update.
     * @return Work item tag definition. {@link WorkItemTagDefinition}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<WorkItemTagDefinition> updateAsync(String tagIdOrName, WorkItemTagDefinition workItemTagDefinition)
            throws AzDException {
        return builder()
                .PATCH(workItemTagDefinition)
                .serviceEndpoint("tagIdOrName", tagIdOrName)
                .build()
                .executeAsync(WorkItemTagDefinition.class);
    }

    /**
     * Delete the tag for the project. Please note, that the deleted tag will be removed from all Work Items as well as Pull Requests.
     *
     * @param tagIdOrName Tag ID or tag name.
     * @throws AzDException Default Api exception handler.
     */
    public Void delete(String tagIdOrName) throws AzDException {
        return builder()
                .DELETE()
                .serviceEndpoint("tagIdOrName", tagIdOrName)
                .build()
                .executePrimitive();
    }

    /**
     * Get the tag for the project.
     *
     * @param tagIdOrName Tag ID or tag name.
     * @return Work item tag definition. {@link WorkItemTagDefinition}
     * @throws AzDException Default Api exception handler.
     */
    public WorkItemTagDefinition get(String tagIdOrName) throws AzDException {
        return builder()
                .serviceEndpoint("tagIdOrName", tagIdOrName)
                .build()
                .execute(WorkItemTagDefinition.class);
    }

    /**
     * Get all the tags for the project.
     *
     * @return Collection of Work item tag definition object {@link WorkItemTagDefinitions}
     * @throws AzDException Default Api exception handler.
     */
    public WorkItemTagDefinitions list() throws AzDException {
        return builder()
                .build()
                .execute(WorkItemTagDefinitions.class);
    }

    /**
     * Update the tag for the project.
     *
     * @param tagIdOrName           Tag ID or tag name.
     * @param workItemTagDefinition Work item tag object to update.
     * @return Work item tag definition. {@link WorkItemTagDefinition}
     * @throws AzDException Default Api exception handler.
     */
    public WorkItemTagDefinition update(String tagIdOrName, WorkItemTagDefinition workItemTagDefinition)
            throws AzDException {
        return builder()
                .PATCH(workItemTagDefinition)
                .serviceEndpoint("tagIdOrName", tagIdOrName)
                .build()
                .execute(WorkItemTagDefinition.class);
    }
}
