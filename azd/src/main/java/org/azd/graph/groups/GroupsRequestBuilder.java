package org.azd.graph.groups;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.abstractions.QueryParameter;
import org.azd.authentication.AccessTokenCredential;
import org.azd.common.ApiVersion;
import org.azd.common.types.JsonPatchDocument;
import org.azd.enums.CustomHeader;
import org.azd.exceptions.AzDException;
import org.azd.graph.types.*;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

/**
 * Provides functionality to work with Graph Groups Api.
 */
public class GroupsRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public GroupsRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential, "graph", "ebbe6af8-0b91-4c13-8cf1-777c14858188",
                ApiVersion.GRAPH);
    }

    /**
     * Create a new Azure DevOps group or materialize an existing AAD group.
     *
     * The body of the request must be a derived type of GraphGroupCreationContext:
     *
     * {@link GraphGroupVstsCreationContext} Create a new Azure DevOps group that is not backed by
     * an external provider.
     *
     * {@link GraphGroupMailAddressCreationContext} Create a new group using the mail address as a
     * reference to an existing group from an external AD or AAD backed provider.
     *
     * {@link GraphGroupOriginIdCreationContext} Create a new group using the OriginID as a reference
     * to a group from an external AD or AAD backed provider.
     *
     * Optionally, you can add the newly created group as a member of an existing Azure DevOps group and/or specify
     * a custom storage key for the group.
     *
     * @param groupCreationContext Request body to create a new group.
     * @return Graph group object {@link GraphGroup}
     * @throws AzDException Default Api exception hanlder.
     */
    public CompletableFuture<GraphGroup> createAsync(GraphGroupCreationContext groupCreationContext) throws AzDException {
        return builder()
                .POST(groupCreationContext)
                .build()
                .executeAsync(GraphGroup.class);
    }

    /**
     * Create a new Azure DevOps group or materialize an existing AAD group.
     *
     * The body of the request must be a derived type of GraphGroupCreationContext:
     *
     * {@link GraphGroupVstsCreationContext} Create a new Azure DevOps group that is not backed by
     * an external provider.
     *
     * {@link GraphGroupMailAddressCreationContext} Create a new group using the mail address as a
     * reference to an existing group from an external AD or AAD backed provider.
     *
     * {@link GraphGroupOriginIdCreationContext} Create a new group using the OriginID as a reference
     * to a group from an external AD or AAD backed provider.
     *
     * Optionally, you can add the newly created group as a member of an existing Azure DevOps group and/or specify
     * a custom storage key for the group.
     *
     * @param groupCreationContext Request body to create a new group.
     * @param requestConfiguration Consumer of request configuration. This represents the query parameter for the request.
     * @return Graph group object {@link GraphGroup}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<GraphGroup> createAsync(GraphGroupCreationContext groupCreationContext,
                                                     Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .POST(groupCreationContext)
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .executeAsync(GraphGroup.class);
    }

    /**
     * Removes an Azure DevOps group from all of its parent groups.
     * The group will still be visible, but membership checks for the group, and all descendants which derive membership through it, will return false.”
     *
     * @param groupDescriptor The descriptor of the group to delete.
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<Void> deleteAsync(String groupDescriptor) throws AzDException {
        return builder()
                .DELETE()
                .serviceEndpoint("groupDescriptor", groupDescriptor)
                .build()
                .executePrimitiveAsync();
    }

    /**
     * Get a group by its descriptor.
     * The group will be returned even if it has been deleted from the account or has had all its memberships deleted.
     *
     * @param groupDescriptor The descriptor of the desired graph group.
     * @return Graph group object {@link GraphGroup}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<GraphGroup> getAsync(String groupDescriptor) throws AzDException {
        return builder()
                .serviceEndpoint("groupDescriptor", groupDescriptor)
                .build()
                .executeAsync(GraphGroup.class);
    }

    /**
     * Gets a list of all groups in the current scope (usually organization or account).
     * The optional parameters are used to filter down the returned results. Returned results are in no guaranteed order.
     * Since the list of groups may be large, results are returned in pages of groups.
     * If there are more results than can be returned in a single page, the result set will contain a
     * continuation token for retrieval of the next set of results.
     *
     * @return Collection of Graph Group {@link GraphGroups}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<GraphGroups> listAsync() throws AzDException {
        return builder().build().executeAsync(GraphGroups.class);
    }

    /**
     * Gets a list of all groups in the current scope (usually organization or account).
     * The optional parameters are used to filter down the returned results. Returned results are in no guaranteed order.
     * Since the list of groups may be large, results are returned in pages of groups.
     * If there are more results than can be returned in a single page, the result set will contain a
     * continuation token for retrieval of the next set of results.
     *
     * @return Collection of Graph Group {@link GraphGroups}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<GraphGroups> listAsync(Consumer<ListRequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .query(ListRequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .executeAsync(GraphGroups.class);
    }

    /**
     * Update the properties of an Azure DevOps group.
     * Currently limited to only changing the description and account name.
     * <p>
     * Example:
     * <pre>{@code
     * [
     *  {
     *    "op": "replace",
     *    "path": "/description",
     *    "from": null,
     *    "value": "Updated description"
     *  }
     * ]
     * }</pre>
     *
     * @param patchDocument   Request body to change the description or account name.
     * @param groupDescriptor The descriptor of the group to modify.
     * @return Collection of Graph Group {@link GraphGroups}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<GraphGroup> updateAsync(JsonPatchDocument patchDocument, String groupDescriptor) throws AzDException {
        return builder()
                .PATCH(patchDocument)
                .serviceEndpoint("groupDescriptor", groupDescriptor)
                .header(CustomHeader.JSON_PATCH)
                .build()
                .executeAsync(GraphGroup.class);
    }

    /**
     * Create a new Azure DevOps group or materialize an existing AAD group.
     *
     * The body of the request must be a derived type of GraphGroupCreationContext:
     *
     * {@link GraphGroupVstsCreationContext} Create a new Azure DevOps group that is not backed by
     * an external provider.
     *
     * {@link GraphGroupMailAddressCreationContext} Create a new group using the mail address as a
     * reference to an existing group from an external AD or AAD backed provider.
     *
     * {@link GraphGroupOriginIdCreationContext} Create a new group using the OriginID as a reference
     * to a group from an external AD or AAD backed provider.
     *
     * Optionally, you can add the newly created group as a member of an existing Azure DevOps group and/or specify
     * a custom storage key for the group.
     *
     * @param groupCreationContext Request body to create a new group.
     * @return Graph group object {@link GraphGroup}
     * @throws AzDException Default Api exception hanlder.
     */
    public GraphGroup create(GraphGroupCreationContext groupCreationContext) throws AzDException {
        return builder()
                .POST(groupCreationContext)
                .build()
                .execute(GraphGroup.class);
    }

    /**
     * Create a new Azure DevOps group or materialize an existing AAD group.
     *
     * The body of the request must be a derived type of GraphGroupCreationContext:
     *
     * {@link GraphGroupVstsCreationContext} Create a new Azure DevOps group that is not backed by
     * an external provider.
     *
     * {@link GraphGroupMailAddressCreationContext} Create a new group using the mail address as a
     * reference to an existing group from an external AD or AAD backed provider.
     *
     * {@link GraphGroupOriginIdCreationContext} Create a new group using the OriginID as a reference
     * to a group from an external AD or AAD backed provider.
     *
     * Optionally, you can add the newly created group as a member of an existing Azure DevOps group and/or specify
     * a custom storage key for the group.
     *
     * @param groupCreationContext Request body to create a new group.
     * @param requestConfiguration Consumer of request configuration. This represents the query parameter for the request.
     * @return Graph group object {@link GraphGroup}
     * @throws AzDException Default Api exception handler.
     */
    public GraphGroup create(GraphGroupCreationContext groupCreationContext,
                             Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .POST(groupCreationContext)
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .execute(GraphGroup.class);
    }

    /**
     * Removes an Azure DevOps group from all of its parent groups.
     * The group will still be visible, but membership checks for the group, and all descendants which derive membership through it, will return false.”
     *
     * @param groupDescriptor The descriptor of the group to delete.
     * @throws AzDException Default Api exception handler.
     */
    public Void delete(String groupDescriptor) throws AzDException {
        return builder()
                .DELETE()
                .serviceEndpoint("groupDescriptor", groupDescriptor)
                .build()
                .executePrimitive();
    }

    /**
     * Get a group by its descriptor.
     * The group will be returned even if it has been deleted from the account or has had all its memberships deleted.
     *
     * @param groupDescriptor The descriptor of the desired graph group.
     * @return Graph group object {@link GraphGroup}
     * @throws AzDException Default Api exception handler.
     */
    public GraphGroup get(String groupDescriptor) throws AzDException {
        return builder()
                .serviceEndpoint("groupDescriptor", groupDescriptor)
                .build()
                .execute(GraphGroup.class);
    }

    /**
     * Gets a list of all groups in the current scope (usually organization or account).
     * The optional parameters are used to filter down the returned results. Returned results are in no guaranteed order.
     * Since the list of groups may be large, results are returned in pages of groups.
     * If there are more results than can be returned in a single page, the result set will contain a
     * continuation token for retrieval of the next set of results.
     *
     * @return Collection of Graph Group {@link GraphGroups}
     * @throws AzDException Default Api exception handler.
     */
    public GraphGroups list() throws AzDException {
        return builder().build().execute(GraphGroups.class);
    }

    /**
     * Gets a list of all groups in the current scope (usually organization or account).
     * The optional parameters are used to filter down the returned results. Returned results are in no guaranteed order.
     * Since the list of groups may be large, results are returned in pages of groups.
     * If there are more results than can be returned in a single page, the result set will contain a
     * continuation token for retrieval of the next set of results.
     *
     * @param requestConfiguration Consumer of request configuration. This represents the query parameter for the request.
     * @return Collection of Graph Group {@link GraphGroups}
     * @throws AzDException Default Api exception handler.
     */
    public GraphGroups list(Consumer<ListRequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .query(ListRequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .execute(GraphGroups.class);
    }

    /**
     * Update the properties of an Azure DevOps group.
     * Currently limited to only changing the description and account name.
     * <p>
     * Example:
     * <pre>{@code
     * [
     *  {
     *    "op": "replace",
     *    "path": "/description",
     *    "from": null,
     *    "value": "Updated description"
     *  }
     * ]
     * }</pre>
     *
     * @param patchDocument   Request body to change the description or account name.
     * @param groupDescriptor The descriptor of the group to modify.
     * @return Collection of Graph Group {@link GraphGroups}
     * @throws AzDException Default Api exception handler.
     */
    public GraphGroup update(JsonPatchDocument patchDocument, String groupDescriptor) throws AzDException {
        return builder()
                .PATCH(patchDocument)
                .serviceEndpoint("groupDescriptor", groupDescriptor)
                .header(CustomHeader.JSON_PATCH)
                .build()
                .execute(GraphGroup.class);
    }

    /**
     * Represents the query parameters.
     */
    public static class GetQueryParameters {
        /**
         * A comma separated list of descriptors referencing groups you want the graph group to join
         */
        @QueryParameter(name = "groupDescriptors")
        public String[] groupDescriptors;
        /**
         * A descriptor referencing the scope (collection, project) in which the group should be created.
         * If omitted, will be created in the scope of the enclosing account or organization. Valid only for VSTS groups.
         */
        @QueryParameter(name = "scopeDescriptor")
        public String scopeDescriptor;
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
    public static class ListQueryParameters {
        /**
         * An opaque data blob that allows the next page of data to resume immediately after where
         * the previous page ended. The only reliable way to know if there is more data left is the presence of a continuation token.
         */
        @QueryParameter(name = "continuationToken")
        public String continuationToken;
        /**
         * Specify a non-default scope (collection, project) to search for groups.
         */
        @QueryParameter(name = "scopeDescriptor")
        public String scopeDescriptor;
        /**
         * A comma separated list of user subject subtypes to reduce the retrieved results,
         * e.g. Microsoft.IdentityModel.Claims.ClaimsIdentity
         */
        @QueryParameter(name = "subjectTypes")
        public String[] subjectTypes;
    }

    /**
     * Request configuration object for the query parameters.
     */
    public static class ListRequestConfiguration {
        public ListQueryParameters queryParameters = new ListQueryParameters();
    }
}
