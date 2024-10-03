package org.azd.workitemtracking.queries;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.abstractions.QueryParameter;
import org.azd.authentication.AccessTokenCredential;
import org.azd.enums.QueryExpand;
import org.azd.exceptions.AzDException;
import org.azd.helpers.URLHelper;
import org.azd.workitemtracking.types.QueryBatchGetRequest;
import org.azd.workitemtracking.types.QueryHierarchyItem;
import org.azd.workitemtracking.types.QueryHierarchyItems;
import org.azd.workitemtracking.types.QueryHierarchyItemsResult;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

/**
 * Provides functionality to work with Work item queries Api.
 */
public class QueriesRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public QueriesRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential, "wit", "a67d190c-c41f-424b-814d-0e906f659301");
    }

    /**
     * Creates a query, or moves a query.
     *
     * @param query              The parent id or path under which the query is to be created.
     * @param queryHierarchyItem Query Hierarchy item object.
     * @return QueryHierarchyItem Object {@link QueryHierarchyItem}
     * @throws AzDException Default Api Exception handler.
     **/
    public CompletableFuture<QueryHierarchyItem> createAsync(String query, QueryHierarchyItem queryHierarchyItem) throws AzDException {
        return builder()
                .POST(queryHierarchyItem)
                .serviceEndpoint("query", URLHelper.encodeSpecialWithSpace(query))
                .build()
                .executeAsync(QueryHierarchyItem.class);
    }

    /**
     * Creates a query, or moves a query.
     *
     * @param query              The parent id or path under which the query is to be created.
     * @param validateWiqlOnly   If you only want to validate your WIQL query without actually creating one,
     *                           set it to true. Default is false.
     * @param queryHierarchyItem Query Hierarchy item object.
     * @return QueryHierarchyItem Object {@link QueryHierarchyItem}
     * @throws AzDException Default Api Exception handler.
     **/
    public CompletableFuture<QueryHierarchyItem> createAsync(String query, boolean validateWiqlOnly,
                                                             QueryHierarchyItem queryHierarchyItem) throws AzDException {
        return builder()
                .POST(queryHierarchyItem)
                .serviceEndpoint("query", URLHelper.encodeSpecialWithSpace(query))
                .build()
                .executeAsync(QueryHierarchyItem.class);
    }

    /**
     * Delete a query or a folder. This deletes any permission change on the deleted query or folder and any of
     * its descendants if it is a folder. It is important to note that the deleted permission
     * changes cannot be recovered upon undeleting the query or folder.
     *
     * @param query The parent id or path under which the query is to be created.
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<Void> deleteAsync(String query) throws AzDException {
        return builder()
                .DELETE()
                .serviceEndpoint("query", URLHelper.encodeSpecialWithSpace(query))
                .build()
                .executePrimitiveAsync();
    }

    /**
     * Retrieves an individual query and its children
     *
     * @param query The parent id or path under which the query is to be created.
     * @return QueryHierarchyItem Object {@link QueryHierarchyItem}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<QueryHierarchyItem> getAsync(String query) throws AzDException {
        return builder()
                .serviceEndpoint("query", URLHelper.encodeSpecialWithSpace(query))
                .build()
                .executeAsync(QueryHierarchyItem.class);
    }

    /**
     * Retrieves an individual query and its children
     *
     * @param query                The parent id or path under which the query is to be created.
     * @param requestConfiguration Represents the query parameters.
     * @return QueryHierarchyItem Object {@link QueryHierarchyItem}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<QueryHierarchyItem> getAsync(String query, Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .serviceEndpoint("query", URLHelper.encodeSpecialWithSpace(query))
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .executeAsync(QueryHierarchyItem.class);
    }

    /**
     * Gets a list of queries by ids (Maximum 1000)
     *
     * @param queryBatchGetRequest Describes a request to get a list of queries {@link QueryBatchGetRequest}
     * @return Collection of query hierarchy item {@link QueryHierarchyItems}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<QueryHierarchyItems> getBatchAsync(QueryBatchGetRequest queryBatchGetRequest) throws AzDException {
        return builder()
                .location("549816f9-09b0-4e75-9e81-01fbfcd07426")
                .POST(queryBatchGetRequest)
                .build()
                .executeAsync(QueryHierarchyItems.class);
    }

    /**
     * Gets the root queries and their children
     *
     * @return Collection of query hierarchy item {@link QueryHierarchyItems}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<QueryHierarchyItems> listAsync() throws AzDException {
        return builder()
                .build()
                .executeAsync(QueryHierarchyItems.class);
    }

    /**
     * Gets the root queries and their children
     *
     * @param requestConfiguration Represents the query parameters.
     * @return Collection of query hierarchy item {@link QueryHierarchyItems}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<QueryHierarchyItems> listAsync(Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .executeAsync(QueryHierarchyItems.class);
    }

    /**
     * Searches all queries the user has access to in the current project
     *
     * @param requestConfiguration Represents the query parameters.
     * @return Collection of query hierarchy item {@link QueryHierarchyItemsResult}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<QueryHierarchyItemsResult> searchAsync(Consumer<SearchRequestConfiguration> requestConfiguration)
            throws AzDException {
        return builder()
                .query(SearchRequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .executeAsync(QueryHierarchyItemsResult.class);
    }

    /**
     * Update a query or a folder. This allows you to update, rename and move queries and folders.
     *
     * @param query              The ID or path for the query to update.
     * @param queryHierarchyItem Represents an item in the work item query hierarchy. This can be either a query or a folder.
     * @return QueryHierarchyItem Object {@link QueryHierarchyItem}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<QueryHierarchyItem> updateAsync(String query, QueryHierarchyItem queryHierarchyItem)
            throws AzDException {
        return builder()
                .PATCH(queryHierarchyItem)
                .serviceEndpoint("query", URLHelper.encodeSpecialWithSpace(query))
                .build()
                .executeAsync(QueryHierarchyItem.class);
    }

    /**
     * Update a query or a folder. This allows you to update, rename and move queries and folders.
     *
     * @param query               The ID or path for the query to update.
     * @param undeleteDescendants Undelete the children of this folder. It is important to note that this will not
     *                            bring back the permission changes that were previously applied to the descendants.
     * @param queryHierarchyItem  Represents an item in the work item query hierarchy. This can be either a query or a folder.
     * @return QueryHierarchyItem Object {@link QueryHierarchyItem}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<QueryHierarchyItem> updateAsync(String query, boolean undeleteDescendants,
                                                             QueryHierarchyItem queryHierarchyItem)
            throws AzDException {
        return builder()
                .PATCH(queryHierarchyItem)
                .serviceEndpoint("query", URLHelper.encodeSpecialWithSpace(query))
                .query("$undeleteDescendants", undeleteDescendants)
                .build()
                .executeAsync(QueryHierarchyItem.class);
    }

    /**
     * Creates a query, or moves a query.
     *
     * @param query              The parent id or path under which the query is to be created.
     * @param queryHierarchyItem Query Hierarchy item object.
     * @return QueryHierarchyItem Object {@link QueryHierarchyItem}
     * @throws AzDException Default Api Exception handler.
     **/
    public QueryHierarchyItem create(String query, QueryHierarchyItem queryHierarchyItem) throws AzDException {
        return builder()
                .POST(queryHierarchyItem)
                .serviceEndpoint("query", URLHelper.encodeSpecialWithSpace(query))
                .build()
                .execute(QueryHierarchyItem.class);
    }

    /**
     * Creates a query, or moves a query.
     *
     * @param query              The parent id or path under which the query is to be created.
     * @param validateWiqlOnly   If you only want to validate your WIQL query without actually creating one,
     *                           set it to true. Default is false.
     * @param queryHierarchyItem Query Hierarchy item object.
     * @return QueryHierarchyItem Object {@link QueryHierarchyItem}
     * @throws AzDException Default Api Exception handler.
     **/
    public QueryHierarchyItem create(String query, boolean validateWiqlOnly,
                                     QueryHierarchyItem queryHierarchyItem) throws AzDException {
        return builder()
                .POST(queryHierarchyItem)
                .serviceEndpoint("query", URLHelper.encodeSpecialWithSpace(query))
                .build()
                .execute(QueryHierarchyItem.class);
    }

    /**
     * Delete a query or a folder. This deletes any permission change on the deleted query or folder and any of
     * its descendants if it is a folder. It is important to note that the deleted permission
     * changes cannot be recovered upon undeleting the query or folder.
     *
     * @param query The parent id or path under which the query is to be created.
     * @throws AzDException Default Api Exception handler.
     */
    public Void delete(String query) throws AzDException {
        return builder()
                .DELETE()
                .serviceEndpoint("query", URLHelper.encodeSpecialWithSpace(query))
                .build()
                .executePrimitive();
    }

    /**
     * Retrieves an individual query and its children
     *
     * @param query The parent id or path under which the query is to be created.
     * @return QueryHierarchyItem Object {@link QueryHierarchyItem}
     * @throws AzDException Default Api Exception handler.
     */
    public QueryHierarchyItem get(String query) throws AzDException {
        return builder()
                .serviceEndpoint("query", URLHelper.encodeSpecialWithSpace(query))
                .build()
                .execute(QueryHierarchyItem.class);
    }

    /**
     * Retrieves an individual query and its children
     *
     * @param query                The parent id or path under which the query is to be created.
     * @param requestConfiguration Represents the query parameters.
     * @return QueryHierarchyItem Object {@link QueryHierarchyItem}
     * @throws AzDException Default Api Exception handler.
     */
    public QueryHierarchyItem get(String query, Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .serviceEndpoint("query", URLHelper.encodeSpecialWithSpace(query))
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .execute(QueryHierarchyItem.class);
    }

    /**
     * Gets a list of queries by ids (Maximum 1000)
     *
     * @param queryBatchGetRequest Describes a request to get a list of queries {@link QueryBatchGetRequest}
     * @return Collection of query hierarchy item {@link QueryHierarchyItems}
     * @throws AzDException Default Api Exception handler.
     */
    public QueryHierarchyItems getBatch(QueryBatchGetRequest queryBatchGetRequest) throws AzDException {
        return builder()
                .location("549816f9-09b0-4e75-9e81-01fbfcd07426")
                .POST(queryBatchGetRequest)
                .build()
                .execute(QueryHierarchyItems.class);
    }

    /**
     * Gets the root queries and their children
     *
     * @return Collection of query hierarchy item {@link QueryHierarchyItems}
     * @throws AzDException Default Api Exception handler.
     */
    public QueryHierarchyItems list() throws AzDException {
        return builder()
                .build()
                .execute(QueryHierarchyItems.class);
    }

    /**
     * Gets the root queries and their children
     *
     * @param requestConfiguration Represents the query parameters.
     * @return Collection of query hierarchy item {@link QueryHierarchyItems}
     * @throws AzDException Default Api Exception handler.
     */
    public QueryHierarchyItems list(Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .execute(QueryHierarchyItems.class);
    }

    /**
     * Searches all queries the user has access to in the current project
     *
     * @param requestConfiguration Represents the query parameters.
     * @return Collection of query hierarchy item {@link QueryHierarchyItemsResult}
     * @throws AzDException Default Api Exception handler.
     */
    public QueryHierarchyItemsResult search(Consumer<SearchRequestConfiguration> requestConfiguration)
            throws AzDException {
        return builder()
                .query(SearchRequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .execute(QueryHierarchyItemsResult.class);
    }

    /**
     * Update a query or a folder. This allows you to update, rename and move queries and folders.
     *
     * @param query              The ID or path for the query to update.
     * @param queryHierarchyItem Represents an item in the work item query hierarchy. This can be either a query or a folder.
     * @return QueryHierarchyItem Object {@link QueryHierarchyItem}
     * @throws AzDException Default Api Exception handler.
     */
    public QueryHierarchyItem update(String query, QueryHierarchyItem queryHierarchyItem)
            throws AzDException {
        return builder()
                .PATCH(queryHierarchyItem)
                .serviceEndpoint("query", URLHelper.encodeSpecialWithSpace(query))
                .build()
                .execute(QueryHierarchyItem.class);
    }

    /**
     * Update a query or a folder. This allows you to update, rename and move queries and folders.
     *
     * @param query               The ID or path for the query to update.
     * @param undeleteDescendants Undelete the children of this folder. It is important to note that this will not
     *                            bring back the permission changes that were previously applied to the descendants.
     * @param queryHierarchyItem  Represents an item in the work item query hierarchy. This can be either a query or a folder.
     * @return QueryHierarchyItem Object {@link QueryHierarchyItem}
     * @throws AzDException Default Api Exception handler.
     */
    public QueryHierarchyItem update(String query, boolean undeleteDescendants,
                                     QueryHierarchyItem queryHierarchyItem)
            throws AzDException {
        return builder()
                .PATCH(queryHierarchyItem)
                .serviceEndpoint("query", URLHelper.encodeSpecialWithSpace(query))
                .query("$undeleteDescendants", undeleteDescendants)
                .build()
                .execute(QueryHierarchyItem.class);
    }

    /**
     * Represents the query parameters.
     */
    public static class GetQueryParameters {
        /**
         * In the folder of queries, return child queries and folders to this depth.
         */
        @QueryParameter(name = "$depth")
        public Integer depth;
        /**
         * Include the query string (wiql), clauses, query result columns, and sort options in the results.
         */
        @QueryParameter(name = "$expand")
        public QueryExpand expand;
        /**
         * Include deleted queries and folders
         */
        @QueryParameter(name = "$includeDeleted")
        public Boolean includeDeleted;
        /**
         * DateTime query clauses will be formatted using a ISO 8601 compliant format
         */
        @QueryParameter(name = "$useIsoDateFormat")
        public Boolean useIsoDateFormat;
    }

    /**
     * Request configuration object for the query parameters.
     */
    public static class RequestConfiguration {
        public GetQueryParameters queryParameters = new GetQueryParameters();
    }

    /**
     * Represents the query parameters.
     */
    public static class SearchQueryParameters {
        /**
         * The text to filter the queries with.
         */
        @QueryParameter(name = "$filter")
        public String filter;
        /**
         * Include the query string (wiql), clauses, query result columns, and sort options in the results.
         */
        @QueryParameter(name = "$expand")
        public QueryExpand expand;
        /**
         * Include deleted queries and folders
         */
        @QueryParameter(name = "$includeDeleted")
        public Boolean includeDeleted;
        /**
         * The number of queries to return (Default is 50 and maximum is 200).
         */
        @QueryParameter(name = "$top")
        public Integer top;
    }

    /**
     * Request configuration object for the query parameters.
     */
    public static class SearchRequestConfiguration {
        public SearchQueryParameters queryParameters = new SearchQueryParameters();
    }

}
