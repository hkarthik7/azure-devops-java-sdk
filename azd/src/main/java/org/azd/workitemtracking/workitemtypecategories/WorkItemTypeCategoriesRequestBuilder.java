package org.azd.workitemtracking.workitemtypecategories;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.authentication.AccessTokenCredential;
import org.azd.common.ApiVersion;
import org.azd.exceptions.AzDException;
import org.azd.helpers.URLHelper;
import org.azd.workitemtracking.types.WorkItemTypeCategories;
import org.azd.workitemtracking.types.WorkItemTypeCategory;

import java.util.concurrent.CompletableFuture;

/**
 * Provides functionality to work with Work item type categories Api.
 */
public class WorkItemTypeCategoriesRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public WorkItemTypeCategoriesRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential, "wit", "9b9f5734-36c8-415e-ba67-f83b45c31408", ApiVersion.WORK_ITEM_TYPE_CATEGORIES);
    }

    /**
     * Get specific work item type category by name.
     *
     * @param category The category name
     * @return WorkItemTypeCategory Object {@link WorkItemTypeCategory}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<WorkItemTypeCategory> getAsync(String category) throws AzDException {
        return builder()
                .serviceEndpoint("category", URLHelper.encodeSpecialWithSpace(category))
                .build()
                .executeAsync(WorkItemTypeCategory.class);
    }

    /**
     * Get all work item type categories.
     *
     * @return Collection of work item type category {@link WorkItemTypeCategories}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<WorkItemTypeCategories> listAsync() throws AzDException {
        return builder()
                .build()
                .executeAsync(WorkItemTypeCategories.class);
    }

    /**
     * Get specific work item type category by name.
     *
     * @param category The category name
     * @return WorkItemTypeCategory Object {@link WorkItemTypeCategory}
     * @throws AzDException Default Api exception handler.
     */
    public WorkItemTypeCategory get(String category) throws AzDException {
        return builder()
                .serviceEndpoint("category", URLHelper.encodeSpecialWithSpace(category))
                .build()
                .execute(WorkItemTypeCategory.class);
    }

    /**
     * Get all work item type categories.
     *
     * @return Collection of work item type category {@link WorkItemTypeCategories}
     * @throws AzDException Default Api exception handler.
     */
    public WorkItemTypeCategories list() throws AzDException {
        return builder()
                .build()
                .execute(WorkItemTypeCategories.class);
    }

}
