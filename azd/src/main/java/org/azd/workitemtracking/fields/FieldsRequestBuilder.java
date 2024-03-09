package org.azd.workitemtracking.fields;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.authentication.AccessTokenCredential;
import org.azd.common.ApiVersion;
import org.azd.enums.GetFieldsExpand;
import org.azd.exceptions.AzDException;
import org.azd.workitemtracking.types.WorkItemField;
import org.azd.workitemtracking.types.WorkItemFieldUpdate;
import org.azd.workitemtracking.types.WorkItemFields;

import java.util.concurrent.CompletableFuture;

/**
 * Provides functionality to work with Work item fields Api.
 */
public class FieldsRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public FieldsRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential, "wit", "b51fd764-e5c2-4b9b-aaf7-3395cf4bdd94", ApiVersion.WORK_ITEM_TRACKING);
    }

    /**
     * Create a new field.
     *
     * @param workItemField Describes a field on a work item and it's properties specific to that work item type.
     * @return Describes a field on a work item and it's properties specific to that work item type. {@link WorkItemField}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<WorkItemField> createAsync(WorkItemField workItemField) throws AzDException {
        return builder()
                .POST(workItemField)
                .build()
                .executeAsync(WorkItemField.class);
    }

    /**
     * Deletes the field. To undelete a filed, see "Update Field" API.
     *
     * @param fieldNameOrRefName Field simple name or reference name
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<Void> deleteAsync(String fieldNameOrRefName) throws AzDException {
        return builder()
                .DELETE()
                .serviceEndpoint("fieldNameOrRefName", fieldNameOrRefName)
                .build()
                .executePrimitiveAsync();
    }

    /**
     * Gets information on a specific field.
     *
     * @param fieldNameOrRefName Field simple name or reference name
     * @return Describes a field on a work item and it's properties specific to that work item type. {@link WorkItemField}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<WorkItemField> getAsync(String fieldNameOrRefName) throws AzDException {
        return builder()
                .serviceEndpoint("fieldNameOrRefName", fieldNameOrRefName)
                .build()
                .executeAsync(WorkItemField.class);
    }

    /**
     * Returns information for all fields. The project ID/name parameter is optional.
     *
     * @return Collection of work item fields. {@link WorkItemFields}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<WorkItemFields> listAsync() throws AzDException {
        return builder()
                .build()
                .executeAsync(WorkItemFields.class);
    }

    /**
     * Returns information for all fields. The project ID/name parameter is optional.
     *
     * @param expand Use ExtensionFields to include extension fields, otherwise exclude them. Unless the feature
     *               flag for this parameter is enabled, extension fields are always included.
     * @return Collection of work item fields. {@link WorkItemFields}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<WorkItemFields> listAsync(GetFieldsExpand expand) throws AzDException {
        return builder()
                .query("$expand", expand.toString().toLowerCase())
                .build()
                .executeAsync(WorkItemFields.class);
    }

    /**
     * Update a field.
     *
     * @param fieldNameOrRefName  Name/reference name of the field to be updated
     * @param workItemFieldUpdate Describes an update request for a work item field.
     * @return Describes a field on a work item and it's properties specific to that work item type. {@link WorkItemField}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<WorkItemField> updateAsync(String fieldNameOrRefName, WorkItemFieldUpdate workItemFieldUpdate) throws AzDException {
        return builder()
                .PATCH(workItemFieldUpdate)
                .serviceEndpoint("fieldNameOrRefName", fieldNameOrRefName)
                .build()
                .executeAsync(WorkItemField.class);
    }

    /**
     * Create a new field.
     *
     * @param workItemField Describes a field on a work item and it's properties specific to that work item type.
     * @return Describes a field on a work item and it's properties specific to that work item type. {@link WorkItemField}
     * @throws AzDException Default Api exception handler.
     */
    public WorkItemField create(WorkItemField workItemField) throws AzDException {
        return builder()
                .POST(workItemField)
                .build()
                .execute(WorkItemField.class);
    }

    /**
     * Deletes the field. To undelete a filed, see "Update Field" API.
     *
     * @param fieldNameOrRefName Field simple name or reference name
     * @throws AzDException Default Api exception handler.
     */
    public Void delete(String fieldNameOrRefName) throws AzDException {
        return builder()
                .DELETE()
                .serviceEndpoint("fieldNameOrRefName", fieldNameOrRefName)
                .build()
                .executePrimitive();
    }

    /**
     * Gets information on a specific field.
     *
     * @param fieldNameOrRefName Field simple name or reference name
     * @return Describes a field on a work item and it's properties specific to that work item type. {@link WorkItemField}
     * @throws AzDException Default Api exception handler.
     */
    public WorkItemField get(String fieldNameOrRefName) throws AzDException {
        return builder()
                .serviceEndpoint("fieldNameOrRefName", fieldNameOrRefName)
                .build()
                .execute(WorkItemField.class);
    }

    /**
     * Returns information for all fields. The project ID/name parameter is optional.
     *
     * @return Collection of work item fields. {@link WorkItemFields}
     * @throws AzDException Default Api exception handler.
     */
    public WorkItemFields list() throws AzDException {
        return builder()
                .build()
                .execute(WorkItemFields.class);
    }

    /**
     * Returns information for all fields. The project ID/name parameter is optional.
     *
     * @param expand Use ExtensionFields to include extension fields, otherwise exclude them. Unless the feature
     *               flag for this parameter is enabled, extension fields are always included.
     * @return Collection of work item fields. {@link WorkItemFields}
     * @throws AzDException Default Api exception handler.
     */
    public WorkItemFields list(GetFieldsExpand expand) throws AzDException {
        return builder()
                .query("$expand", expand.toString().toLowerCase())
                .build()
                .execute(WorkItemFields.class);
    }

    /**
     * Update a field.
     *
     * @param fieldNameOrRefName  Name/reference name of the field to be updated
     * @param workItemFieldUpdate Describes an update request for a work item field.
     * @return Describes a field on a work item and it's properties specific to that work item type. {@link WorkItemField}
     * @throws AzDException Default Api exception handler.
     */
    public WorkItemField update(String fieldNameOrRefName, WorkItemFieldUpdate workItemFieldUpdate) throws AzDException {
        return builder()
                .PATCH(workItemFieldUpdate)
                .serviceEndpoint("fieldNameOrRefName", fieldNameOrRefName)
                .build()
                .execute(WorkItemField.class);
    }
}
