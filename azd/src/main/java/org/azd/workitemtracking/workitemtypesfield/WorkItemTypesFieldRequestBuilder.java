package org.azd.workitemtracking.workitemtypesfield;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.authentication.AccessTokenCredential;
import org.azd.common.ApiVersion;
import org.azd.enums.WorkItemTypeFieldsExpandLevel;
import org.azd.exceptions.AzDException;
import org.azd.helpers.URLHelper;
import org.azd.workitemtracking.types.WorkItemTypeFieldWithReference;
import org.azd.workitemtracking.types.WorkItemTypeFieldWithReferences;

import java.util.concurrent.CompletableFuture;

/**
 * Provides functionality to work with Work item tracking Api.
 */
public class WorkItemTypesFieldRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public WorkItemTypesFieldRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential, "wit", "bd293ce5-3d25-4192-8e67-e8092e879efb", ApiVersion.WORK_ITEM_TYPES_FIELD);
    }

    /**
     * Get a field for a work item type with detailed references.
     *
     * @param type  Work item type. E.g, Bug, User Story etc.
     * @param field Internal name of the field. E.g, System.Tags, System.Title etc.
     * @return Work item type field with reference {@link WorkItemTypeFieldWithReference}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<WorkItemTypeFieldWithReference> getAsync(String type, String field) throws AzDException {
        return builder()
                .serviceEndpoint("field", URLHelper.encodeSpecialWithSpace(field))
                .serviceEndpoint("type", URLHelper.encodeSpecialWithSpace(type))
                .build()
                .executeAsync(WorkItemTypeFieldWithReference.class);

    }

    /**
     * Get a field for a work item type with detailed references.
     *
     * @param type   Work item type. E.g, Bug, User Story etc.
     * @param field  Internal name of the field. E.g, System.Tags, System.Title etc.
     * @param expand Expand level for the API response. Properties: to include allowedvalues, default value,
     *               isRequired etc. as a part of response; None: to skip these properties.
     * @return Work item type field with reference {@link WorkItemTypeFieldWithReference}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<WorkItemTypeFieldWithReference> getAsync(String type, String field,
                                                                      WorkItemTypeFieldsExpandLevel expand) throws AzDException {
        return builder()
                .serviceEndpoint("field", URLHelper.encodeSpecialWithSpace(field))
                .serviceEndpoint("type", URLHelper.encodeSpecialWithSpace(type))
                .query("$expand", expand.toString().toLowerCase())
                .build()
                .executeAsync(WorkItemTypeFieldWithReference.class);
    }

    /**
     * Get a list of fields for a work item type with detailed references.
     *
     * @param type Work item type.
     * @return Collection of work item type field with reference {@link WorkItemTypeFieldWithReferences}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<WorkItemTypeFieldWithReferences> listAsync(String type) throws AzDException {
        return builder()
                .serviceEndpoint("type", URLHelper.encodeSpecialWithSpace(type))
                .build()
                .executeAsync(WorkItemTypeFieldWithReferences.class);
    }

    /**
     * Get a list of fields for a work item type with detailed references.
     *
     * @param type   Work item type.
     * @param expand Expand level for the API response. Properties: to include allowedvalues, default value,
     *               isRequired etc. as a part of response; None: to skip these properties.
     * @return Collection of work item type field with reference {@link WorkItemTypeFieldWithReferences}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<WorkItemTypeFieldWithReferences> listAsync(String type, WorkItemTypeFieldsExpandLevel expand)
            throws AzDException {
        return builder()
                .serviceEndpoint("type", URLHelper.encodeSpecialWithSpace(type))
                .query("$expand", expand.toString().toLowerCase())
                .build()
                .executeAsync(WorkItemTypeFieldWithReferences.class);
    }

    /**
     * Get a field for a work item type with detailed references.
     *
     * @param type  Work item type. E.g, Bug, User Story etc.
     * @param field Internal name of the field. E.g, System.Tags, System.Title etc.
     * @return Work item type field with reference {@link WorkItemTypeFieldWithReference}
     * @throws AzDException Default Api exception handler.
     */
    public WorkItemTypeFieldWithReference get(String type, String field) throws AzDException {
        return builder()
                .serviceEndpoint("field", URLHelper.encodeSpecialWithSpace(field))
                .serviceEndpoint("type", URLHelper.encodeSpecialWithSpace(type))
                .build()
                .execute(WorkItemTypeFieldWithReference.class);

    }

    /**
     * Get a field for a work item type with detailed references.
     *
     * @param type   Work item type. E.g, Bug, User Story etc.
     * @param field  Internal name of the field. E.g, System.Tags, System.Title etc.
     * @param expand Expand level for the API response. Properties: to include allowedvalues, default value,
     *               isRequired etc. as a part of response; None: to skip these properties.
     * @return Work item type field with reference {@link WorkItemTypeFieldWithReference}
     * @throws AzDException Default Api exception handler.
     */
    public WorkItemTypeFieldWithReference get(String type, String field,
                                              WorkItemTypeFieldsExpandLevel expand) throws AzDException {
        return builder()
                .serviceEndpoint("field", URLHelper.encodeSpecialWithSpace(field))
                .serviceEndpoint("type", URLHelper.encodeSpecialWithSpace(type))
                .query("$expand", expand.toString().toLowerCase())
                .build()
                .execute(WorkItemTypeFieldWithReference.class);
    }

    /**
     * Get a list of fields for a work item type with detailed references.
     *
     * @param type Work item type.
     * @return Collection of work item type field with reference {@link WorkItemTypeFieldWithReferences}
     * @throws AzDException Default Api exception handler.
     */
    public WorkItemTypeFieldWithReferences list(String type) throws AzDException {
        return builder()
                .serviceEndpoint("type", URLHelper.encodeSpecialWithSpace(type))
                .build()
                .execute(WorkItemTypeFieldWithReferences.class);
    }

    /**
     * Get a list of fields for a work item type with detailed references.
     *
     * @param type   Work item type.
     * @param expand Expand level for the API response. Properties: to include allowedvalues, default value,
     *               isRequired etc. as a part of response; None: to skip these properties.
     * @return Collection of work item type field with reference {@link WorkItemTypeFieldWithReferences}
     * @throws AzDException Default Api exception handler.
     */
    public WorkItemTypeFieldWithReferences list(String type, WorkItemTypeFieldsExpandLevel expand)
            throws AzDException {
        return builder()
                .serviceEndpoint("type", URLHelper.encodeSpecialWithSpace(type))
                .query("$expand", expand.toString().toLowerCase())
                .build()
                .execute(WorkItemTypeFieldWithReferences.class);
    }
}
