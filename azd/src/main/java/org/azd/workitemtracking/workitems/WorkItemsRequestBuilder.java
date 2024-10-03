package org.azd.workitemtracking.workitems;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.abstractions.QueryParameter;
import org.azd.authentication.AccessTokenCredential;
import org.azd.common.ApiVersion;
import org.azd.common.types.JsonPatchDocument;
import org.azd.enums.CustomHeader;
import org.azd.enums.WorkItemErrorPolicy;
import org.azd.enums.WorkItemExpand;
import org.azd.exceptions.AzDException;
import org.azd.helpers.URLHelper;
import org.azd.helpers.Utils;
import org.azd.workitemtracking.types.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

/**
 * Provides functionality to work with work items Api.
 */
public class WorkItemsRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public WorkItemsRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential, "wit", "72c7ddf8-2cdc-4f60-90cd-ab71c14a399b", ApiVersion.WORK_ITEM_TRACKING);
    }

    /**
     * Creates a single work item.
     *
     * @param type               The work item type of the work item to create.
     * @param jsonPatchDocuments Request body to create the work item.
     * @return Work item object. {@link WorkItem}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<WorkItem> createAsync(String type, List<JsonPatchDocument> jsonPatchDocuments) throws AzDException {
        return builder()
                .location("62d3d110-0047-428c-ad3c-4fe872c91c74")
                .POST(jsonPatchDocuments)
                .serviceEndpoint("type", URLHelper.encodeSpecialWithSpace(type))
                .header(CustomHeader.JSON_PATCH)
                .build()
                .executeAsync(WorkItem.class);
    }

    /**
     * Creates a single work item.
     *
     * @param type                 The work item type of the work item to create.
     * @param jsonPatchDocuments   Request body to create the work item.
     * @param requestConfiguration Represents the query parameters.
     * @return Work item object. {@link WorkItem}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<WorkItem> createAsync(String type, List<JsonPatchDocument> jsonPatchDocuments,
                                                   Consumer<CreateRequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .location("62d3d110-0047-428c-ad3c-4fe872c91c74")
                .POST(jsonPatchDocuments)
                .serviceEndpoint("type", URLHelper.encodeSpecialWithSpace(type))
                .query(CreateRequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .header(CustomHeader.JSON_PATCH)
                .build()
                .executeAsync(WorkItem.class);
    }

    /**
     * Deletes the specified work item and sends it to the Recycle Bin, so that it can be restored back, if required.
     *
     * @param id ID of the work item to be deleted
     * @return Work item delete object. {@link WorkItemDelete}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<WorkItemDelete> deleteAsync(int id) throws AzDException {
        return builder()
                .DELETE()
                .serviceEndpoint("id", id)
                .build()
                .executeAsync(WorkItemDelete.class);
    }

    /**
     * Deletes the specified work item permanently if the destroy parameter has been set to true,
     * WARNING: If the destroy parameter is set to true, work items deleted by this command will
     * NOT go to recycle-bin and there is no way to restore/recover them after deletion.
     * It is recommended NOT to use this parameter. If you do, please use this parameter with extreme caution.
     *
     * @param id      ID of the work item to be deleted
     * @param destroy Optional parameter, if set to true, the work item is deleted permanently.
     *                Please note: the destroy action is PERMANENT and cannot be undone.
     * @return Describes response to delete a set of work items. {@link WorkItemDeleteBatch}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<WorkItemDelete> deleteAsync(int id, boolean destroy) throws AzDException {
        return builder()
                .DELETE()
                .serviceEndpoint("id", id)
                .query("destroy", destroy)
                .build()
                .executeAsync(WorkItemDelete.class);
    }

    /**
     * Deletes specified work items and sends them to the Recycle Bin, so that it can be restored back,
     * if required. Optionally, if the destroy parameter has been set to true, it destroys the work item permanently.
     * WARNING: If the destroy parameter is set to true, work items deleted by this command will NOT go
     * to recycle-bin and there is no way to restore/recover them after deletion.
     *
     * @param workItemDeleteBatchRequest Describes a request to delete a set of work items
     * @return Describes response to delete a set of work items. {@link WorkItemDeleteBatch}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<WorkItemDeleteBatch> deleteAsync(WorkItemDeleteBatchRequest workItemDeleteBatchRequest) throws AzDException {
        return builder()
                .location("8bc57545-27e5-420d-b709-f6e3ebcc1fc1")
                .POST(workItemDeleteBatchRequest)
                .build()
                .executeAsync(WorkItemDeleteBatch.class);
    }

    /**
     * Returns a single work item.
     *
     * @param id The work item id
     * @return WorkItem {@link WorkItem}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<WorkItem> getAsync(int id) throws AzDException {
        return builder()
                .serviceEndpoint("id", id)
                .build()
                .executeAsync(WorkItem.class);
    }

    /**
     * Returns a single work item.
     *
     * @param id                   The work item id
     * @param requestConfiguration Represents the query parameters.
     * @return WorkItem {@link WorkItem}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<WorkItem> getAsync(int id, Consumer<GetRequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .serviceEndpoint("id", id)
                .query(GetRequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .executeAsync(WorkItem.class);
    }

    /**
     * Returns a single work item from a template.
     *
     * @param type The work item type name
     * @return WorkItem object {@link WorkItem}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<WorkItem> getTemplateAsync(String type) throws AzDException {
        return builder()
                .location("62d3d110-0047-428c-ad3c-4fe872c91c74")
                .serviceEndpoint("type", URLHelper.encodeSpecialWithSpace(type))
                .build()
                .executeAsync(WorkItem.class);
    }

    /**
     * Returns a single work item from a template.
     *
     * @param type                 The work item type name
     * @param requestConfiguration Represents the query parameters.
     * @return WorkItem object {@link WorkItem}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<WorkItem> getTemplateAsync(String type, Consumer<GetRequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .location("62d3d110-0047-428c-ad3c-4fe872c91c74")
                .serviceEndpoint("type", URLHelper.encodeSpecialWithSpace(type))
                .query(GetRequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .executeAsync(WorkItem.class);
    }

    /**
     * Gets work items for a list of work item ids (Maximum 200)
     *
     * @param workItemBatchGetRequest Describes a request to get a set of work items
     * @return Array of work item {@link WorkItemList}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<WorkItemList> getBatchAsync(WorkItemBatchGetRequest workItemBatchGetRequest) throws AzDException {
        return builder()
                .location("908509b6-4248-4475-a1cd-829139ba419f")
                .POST(workItemBatchGetRequest)
                .build()
                .executeAsync(WorkItemList.class);
    }

    /**
     * Returns a list of work items (Maximum 200)
     *
     * @param requestConfiguration Represents the query parameters.
     * @return Collection of WorkItem object {@link WorkItemList}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<WorkItemList> listAsync(Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .executeAsync(WorkItemList.class);
    }

    /**
     * Updates a single work item.
     *
     * @param id                 The id of the work item to update
     * @param jsonPatchDocuments Request body to update a work item
     * @return WorkItem object {@link WorkItem}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<WorkItem> updateAsync(int id, List<JsonPatchDocument> jsonPatchDocuments) throws AzDException {
        return builder()
                .PATCH(jsonPatchDocuments)
                .serviceEndpoint("id", id)
                .header(CustomHeader.JSON_PATCH)
                .build()
                .executeAsync(WorkItem.class);
    }

    /**
     * Updates a single work item.
     *
     * @param id                   The id of the work item to update
     * @param jsonPatchDocuments   Request body to update a work item
     * @param requestConfiguration Represents the query parameters.
     * @return WorkItem object {@link WorkItem}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<WorkItem> updateAsync(int id, List<JsonPatchDocument> jsonPatchDocuments,
                                                   Consumer<CreateRequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .PATCH(jsonPatchDocuments)
                .serviceEndpoint("id", id)
                .query(CreateRequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .header(CustomHeader.JSON_PATCH)
                .build()
                .executeAsync(WorkItem.class);
    }

    /**
     * Creates a single work item.
     *
     * @param type               The work item type of the work item to create.
     * @param jsonPatchDocuments Request body to create the work item.
     * @return Work item object. {@link WorkItem}
     * @throws AzDException Default Api exception handler.
     */
    public WorkItem create(String type, List<JsonPatchDocument> jsonPatchDocuments) throws AzDException {
        return builder()
                .location("62d3d110-0047-428c-ad3c-4fe872c91c74")
                .POST(jsonPatchDocuments)
                .serviceEndpoint("type", URLHelper.encodeSpecialWithSpace(type))
                .header(CustomHeader.JSON_PATCH)
                .build()
                .execute(WorkItem.class);
    }

    /**
     * Creates a single work item.
     *
     * @param type                 The work item type of the work item to create.
     * @param jsonPatchDocuments   Request body to create the work item.
     * @param requestConfiguration Represents the query parameters.
     * @return Work item object. {@link WorkItem}
     * @throws AzDException Default Api exception handler.
     */
    public WorkItem create(String type, List<JsonPatchDocument> jsonPatchDocuments,
                           Consumer<CreateRequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .location("62d3d110-0047-428c-ad3c-4fe872c91c74")
                .POST(jsonPatchDocuments)
                .serviceEndpoint("type", URLHelper.encodeSpecialWithSpace(type))
                .query(CreateRequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .header(CustomHeader.JSON_PATCH)
                .build()
                .execute(WorkItem.class);
    }

    /**
     * Deletes the specified work item and sends it to the Recycle Bin, so that it can be restored back, if required.
     *
     * @param id ID of the work item to be deleted
     * @return Work item delete object. {@link WorkItemDelete}
     * @throws AzDException Default Api Exception handler.
     */
    public WorkItemDelete delete(int id) throws AzDException {
        return builder()
                .DELETE()
                .serviceEndpoint("id", id)
                .build()
                .execute(WorkItemDelete.class);
    }

    /**
     * Deletes the specified work item permanently if the destroy parameter has been set to true,
     * WARNING: If the destroy parameter is set to true, work items deleted by this command will
     * NOT go to recycle-bin and there is no way to restore/recover them after deletion.
     * It is recommended NOT to use this parameter. If you do, please use this parameter with extreme caution.
     *
     * @param id      ID of the work item to be deleted
     * @param destroy Optional parameter, if set to true, the work item is deleted permanently.
     *                Please note: the destroy action is PERMANENT and cannot be undone.
     * @return Describes response to delete a set of work items. {@link WorkItemDeleteBatch}
     * @throws AzDException Default Api Exception handler.
     */
    public WorkItemDelete delete(int id, boolean destroy) throws AzDException {
        return builder()
                .DELETE()
                .serviceEndpoint("id", id)
                .query("destroy", destroy)
                .build()
                .execute(WorkItemDelete.class);
    }

    /**
     * Deletes specified work items and sends them to the Recycle Bin, so that it can be restored back,
     * if required. Optionally, if the destroy parameter has been set to true, it destroys the work item permanently.
     * WARNING: If the destroy parameter is set to true, work items deleted by this command will NOT go
     * to recycle-bin and there is no way to restore/recover them after deletion.
     *
     * @param workItemDeleteBatchRequest Describes a request to delete a set of work items
     * @return Describes response to delete a set of work items. {@link WorkItemDeleteBatch}
     * @throws AzDException Default Api Exception handler.
     */
    public WorkItemDeleteBatch delete(WorkItemDeleteBatchRequest workItemDeleteBatchRequest) throws AzDException {
        return builder()
                .location("8bc57545-27e5-420d-b709-f6e3ebcc1fc1")
                .POST(workItemDeleteBatchRequest)
                .build()
                .execute(WorkItemDeleteBatch.class);
    }

    /**
     * Returns a single work item.
     *
     * @param id The work item id
     * @return WorkItem {@link WorkItem}
     * @throws AzDException Default Api Exception handler.
     */
    public WorkItem get(int id) throws AzDException {
        return builder()
                .serviceEndpoint("id", id)
                .build()
                .execute(WorkItem.class);
    }

    /**
     * Returns a single work item.
     *
     * @param id                   The work item id
     * @param requestConfiguration Represents the query parameters.
     * @return WorkItem {@link WorkItem}
     * @throws AzDException Default Api Exception handler.
     */
    public WorkItem get(int id, Consumer<GetRequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .serviceEndpoint("id", id)
                .query(GetRequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .execute(WorkItem.class);
    }

    /**
     * Returns a single work item from a template.
     *
     * @param type The work item type name
     * @return WorkItem object {@link WorkItem}
     * @throws AzDException Default Api Exception handler.
     */
    public WorkItem getTemplate(String type) throws AzDException {
        return builder()
                .location("62d3d110-0047-428c-ad3c-4fe872c91c74")
                .serviceEndpoint("type", URLHelper.encodeSpecialWithSpace(type))
                .build()
                .execute(WorkItem.class);
    }

    /**
     * Returns a single work item from a template.
     *
     * @param type                 The work item type name
     * @param requestConfiguration Represents the query parameters.
     * @return WorkItem object {@link WorkItem}
     * @throws AzDException Default Api Exception handler.
     */
    public WorkItem getTemplate(String type, Consumer<GetRequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .location("62d3d110-0047-428c-ad3c-4fe872c91c74")
                .serviceEndpoint("type", URLHelper.encodeSpecialWithSpace(type))
                .query(GetRequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .execute(WorkItem.class);
    }

    /**
     * Gets work items for a list of work item ids (Maximum 200)
     *
     * @param workItemBatchGetRequest Describes a request to get a set of work items
     * @return Array of work item {@link WorkItemList}
     * @throws AzDException Default Api Exception handler.
     */
    public WorkItemList getBatch(WorkItemBatchGetRequest workItemBatchGetRequest) throws AzDException {
        return builder()
                .location("908509b6-4248-4475-a1cd-829139ba419f")
                .POST(workItemBatchGetRequest)
                .build()
                .execute(WorkItemList.class);
    }

    /**
     * Returns a list of work items (Maximum 200)
     *
     * @param ids Array of work item ids to list.
     * @return Collection of WorkItem object {@link WorkItemList}
     * @throws AzDException Default Api Exception handler.
     */
    public WorkItemList list(int... ids) throws AzDException {
        return builder()
                .query("ids", Utils.toString(ids))
                .build()
                .execute(WorkItemList.class);
    }

    /**
     * Returns a list of work items (Maximum 200)
     *
     * @param requestConfiguration Represents the query parameters.
     * @return Collection of WorkItem object {@link WorkItemList}
     * @throws AzDException Default Api Exception handler.
     */
    public WorkItemList list(Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .execute(WorkItemList.class);
    }

    /**
     * Updates a single work item.
     *
     * @param id                 The id of the work item to update
     * @param jsonPatchDocuments Request body to update a work item
     * @return WorkItem object {@link WorkItem}
     * @throws AzDException Default Api Exception handler.
     */
    public WorkItem update(int id, List<JsonPatchDocument> jsonPatchDocuments) throws AzDException {
        return builder()
                .PATCH(jsonPatchDocuments)
                .serviceEndpoint("id", id)
                .header(CustomHeader.JSON_PATCH)
                .build()
                .execute(WorkItem.class);
    }

    /**
     * Updates a single work item.
     *
     * @param id                   The id of the work item to update
     * @param jsonPatchDocuments   Request body to update a work item
     * @param requestConfiguration Represents the query parameters.
     * @return WorkItem object {@link WorkItem}
     * @throws AzDException Default Api Exception handler.
     */
    public WorkItem update(int id, List<JsonPatchDocument> jsonPatchDocuments,
                           Consumer<CreateRequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .PATCH(jsonPatchDocuments)
                .serviceEndpoint("id", id)
                .query(CreateRequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .header(CustomHeader.JSON_PATCH)
                .build()
                .execute(WorkItem.class);
    }


    /**
     * Represents the query parameters.
     */
    public static class CreateQueryParameters {
        /**
         * The expand parameters for work item attributes. Possible options are { None, Relations, Fields, Links, All }.
         */
        @QueryParameter(name = "$expand")
        public WorkItemExpand expand;
        /**
         * Do not enforce the work item type rules on this update
         */
        @QueryParameter(name = "bypassRules")
        public Boolean bypassRules;
        /**
         * Do not fire any notifications for this change
         */
        @QueryParameter(name = "suppressNotifications")
        public Boolean suppressNotifications;
        /**
         * Indicate if you only want to validate the changes without saving the work item
         */
        @QueryParameter(name = "validateOnly")
        public Boolean validateOnly;
    }

    /**
     * Request configuration object for the query parameters.
     */
    public static class CreateRequestConfiguration {
        public CreateQueryParameters queryParameters = new CreateQueryParameters();
    }

    /**
     * Represents the query parameters.
     */
    public static class GetQueryParameters {
        /**
         * The expand parameters for work item attributes. Possible options are { None, Relations, Fields, Links, All }.
         */
        @QueryParameter(name = "$expand")
        public WorkItemExpand expand;
        /**
         * AsOf UTC date time string
         */
        @QueryParameter(name = "asOf")
        public String asOf;
        /**
         * Comma-separated list of requested fields
         */
        @QueryParameter(name = "fields")
        public String[] fields;
    }

    /**
     * Request configuration object for the query parameters.
     */
    public static class GetRequestConfiguration {
        public GetQueryParameters queryParameters = new GetQueryParameters();
    }

    /**
     * Represents the query parameters.
     */
    public static class ListQueryParameters {
        /**
         * The comma-separated list of requested work item ids. (Maximum 200 ids allowed).
         */
        @QueryParameter(name = "ids")
        public Integer[] ids;
        /**
         * The expand parameters for work item attributes. Possible options are { None, Relations, Fields, Links, All }.
         */
        @QueryParameter(name = "$expand")
        public WorkItemExpand expand;
        /**
         * AsOf UTC date time string
         */
        @QueryParameter(name = "asOf")
        public String asOf;
        /**
         * The flag to control error policy in a bulk get work items request. Possible options are {Fail, Omit}.
         */
        @QueryParameter(name = "errorPolicy")
        public WorkItemErrorPolicy errorPolicy;
        /**
         * Comma-separated list of requested fields
         */
        @QueryParameter(name = "fields")
        public String[] fields;
    }

    /**
     * Request configuration object for the query parameters.
     */
    public static class RequestConfiguration {
        public ListQueryParameters queryParameters = new ListQueryParameters();
    }
}
