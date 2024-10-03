package org.azd.workitemtracking.revisions;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.abstractions.QueryParameter;
import org.azd.authentication.AccessTokenCredential;
import org.azd.common.ApiVersion;
import org.azd.enums.WorkItemExpand;
import org.azd.exceptions.AzDException;
import org.azd.workitemtracking.types.WorkItem;
import org.azd.workitemtracking.types.WorkItemList;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

/**
 * Provides functionality to work with Work item revisions Api.
 */
public class WorkItemRevisionsRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public WorkItemRevisionsRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential, "wit", "a00c85a5-80fa-4565-99c3-bcd2181434bb", ApiVersion.WORK_ITEM_TRACKING);
    }

    /**
     * Returns a fully hydrated work item for the requested revision
     *
     * @param id             ID of the work item.
     * @param revisionNumber Revision number of work item to retrieve.
     * @return WorkItem object {@link WorkItem}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<WorkItem> getAsync(int id, int revisionNumber) throws AzDException {
        return builder()
                .serviceEndpoint("id", id)
                .serviceEndpoint("revisionNumber", revisionNumber)
                .build()
                .executeAsync(WorkItem.class);
    }

    /**
     * Returns a fully hydrated work item for the requested revision
     *
     * @param id             ID of the work item.
     * @param revisionNumber Revision number of work item to retrieve.
     * @param expand         Expands the work item fields.
     * @return WorkItem object {@link WorkItem}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<WorkItem> getAsync(int id, int revisionNumber, WorkItemExpand expand) throws AzDException {
        return builder()
                .serviceEndpoint("id", id)
                .serviceEndpoint("revisionNumber", revisionNumber)
                .query("$expand", expand.toString().toLowerCase())
                .build()
                .executeAsync(WorkItem.class);
    }

    /**
     * Returns the list of fully hydrated work item revisions, paged.
     *
     * @param id ID of the work item.
     * @return Collection of work item {@link WorkItemList}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<WorkItemList> listAsync(int id) throws AzDException {
        return builder()
                .serviceEndpoint("id", id)
                .build()
                .executeAsync(WorkItemList.class);
    }

    /**
     * Returns the list of fully hydrated work item revisions, paged.
     *
     * @param id                   ID of the work item.
     * @param requestConfiguration Represents the query parameters.
     * @return Collection of work item {@link WorkItemList}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<WorkItemList> listAsync(int id, Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .serviceEndpoint("id", id)
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .executeAsync(WorkItemList.class);
    }

    /**
     * Returns a fully hydrated work item for the requested revision
     *
     * @param id             ID of the work item.
     * @param revisionNumber Revision number of work item to retrieve.
     * @return WorkItem object {@link WorkItem}
     * @throws AzDException Default Api exception handler.
     */
    public WorkItem get(int id, int revisionNumber) throws AzDException {
        return builder()
                .serviceEndpoint("id", id)
                .serviceEndpoint("revisionNumber", revisionNumber)
                .build()
                .execute(WorkItem.class);
    }

    /**
     * Returns a fully hydrated work item for the requested revision
     *
     * @param id             ID of the work item.
     * @param revisionNumber Revision number of work item to retrieve.
     * @param expand         Expands the work item fields.
     * @return WorkItem object {@link WorkItem}
     * @throws AzDException Default Api exception handler.
     */
    public WorkItem get(int id, int revisionNumber, WorkItemExpand expand) throws AzDException {
        return builder()
                .serviceEndpoint("id", id)
                .serviceEndpoint("revisionNumber", revisionNumber)
                .query("$expand", expand.toString().toLowerCase())
                .build()
                .execute(WorkItem.class);
    }

    /**
     * Returns the list of fully hydrated work item revisions, paged.
     *
     * @param id ID of the work item.
     * @return Collection of work item {@link WorkItemList}
     * @throws AzDException Default Api exception handler.
     */
    public WorkItemList list(int id) throws AzDException {
        return builder()
                .serviceEndpoint("id", id)
                .build()
                .execute(WorkItemList.class);
    }

    /**
     * Returns the list of fully hydrated work item revisions, paged.
     *
     * @param id                   ID of the work item.
     * @param requestConfiguration Represents the query parameters.
     * @return Collection of work item {@link WorkItemList}
     * @throws AzDException Default Api exception handler.
     */
    public WorkItemList list(int id, Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .serviceEndpoint("id", id)
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .execute(WorkItemList.class);
    }


    /**
     * Represents the query parameters.
     */
    public static class GetQueryParameters {
        /**
         * Get the top x work items.
         */
        @QueryParameter(name = "$top")
        public Integer top;
        /**
         * Expands the specific field in the work item.
         */
        @QueryParameter(name = "$expand")
        public WorkItemExpand expand;
        /**
         * Work item to skip
         */
        @QueryParameter(name = "$skip")
        public Integer skip;
    }

    /**
     * Request configuration object for the query parameters.
     */
    public static class RequestConfiguration {
        public GetQueryParameters queryParameters = new GetQueryParameters();
    }

}
