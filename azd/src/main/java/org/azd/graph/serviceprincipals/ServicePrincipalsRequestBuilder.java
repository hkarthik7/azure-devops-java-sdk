package org.azd.graph.serviceprincipals;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.abstractions.QueryParameter;
import org.azd.authentication.AccessTokenCredential;
import org.azd.common.ApiVersion;
import org.azd.exceptions.AzDException;
import org.azd.graph.types.GraphServicePrincipalCreationContext;
import org.azd.graph.types.GraphServicePrincipal;
import org.azd.graph.types.GraphServicePrincipalOriginIdCreationContext;
import org.azd.graph.types.GraphServicePrincipals;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

/**
 * Provides functionality to work with Graph Service Principals Api.
 */
public class ServicePrincipalsRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public ServicePrincipalsRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential, "graph", "e1dbb0ae-49cb-4532-95a1-86cd89cfcab4", ApiVersion.GRAPH);
    }

    /**
     * Materialize an existing AAD service principal into the ADO account.
     *
     * <br><br/><strong>NOTE:</strong> Created service principals are not active in an account.
     *
     * <br><br/>Adding a service principal to an account is required before the service principal can be added to ADO groups or
     * assigned an asset.
     *
     * <br><br/>The body of the request must be a derived type of {@link GraphServicePrincipalCreationContext}:
     *
     * <br><br/>{@link GraphServicePrincipalOriginIdCreationContext} - Create a new service principal using the OriginID as a reference
     * to an existing service principal from AAD backed provider.
     *
     *  <br><br/>If the service principal to be added corresponds to a
     * service principal that was previously deleted, then that service principal will be restored.
     *
     * <br><br/>Optionally, you can add the newly created service principal as a member of an existing ADO group and/or specify
     * a custom storage key for the service principal.
     *
     * @param creationContext Graph origin id creation context. Pass the origin id to create service principal.
     * @return Graph Service Principal object {@link GraphServicePrincipal}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<GraphServicePrincipal> createAsync(GraphServicePrincipalCreationContext creationContext) throws AzDException {
        return builder()
                .POST(creationContext)
                .build()
                .executeAsync(GraphServicePrincipal.class);
    }

    /**
     * Materialize an existing AAD service principal into the ADO account.
     *
     * <br><br/><strong>NOTE:</strong> Created service principals are not active in an account.
     *
     * <br><br/>Adding a service principal to an account is required before the service principal can be added to ADO groups or
     * assigned an asset.
     *
     * <br><br/>The body of the request must be a derived type of {@link GraphServicePrincipalCreationContext}:
     *
     * <br><br/>{@link GraphServicePrincipalOriginIdCreationContext} - Create a new service principal using the OriginID as a reference
     * to an existing service principal from AAD backed provider.
     *
     * <br><br/>If the service principal to be added corresponds to a service principal that was previously deleted,
     * then that service principal will be restored.
     *
     * <br><br/>Optionally, you can add the newly created service principal as a member of an existing ADO group and/or specify
     * a custom storage key for the service principal.
     *
     * @param creationContext      Graph origin id creation context. Pass the origin id to create service principal.
     * @param requestConfiguration Consumer of request configuration. This represents the query parameter for the request.
     * @return Graph Service Principal object {@link GraphServicePrincipal}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<GraphServicePrincipal> createAsync(GraphServicePrincipalCreationContext creationContext,
                                                                Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .POST(creationContext)
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .executeAsync(GraphServicePrincipal.class);
    }

    /**
     * Disables a service principal.
     * The service principal will still be visible, but membership checks for the service principal will return false.
     *
     * @param servicePrincipalDescriptor The descriptor of the service principal to delete.
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<Void> deleteAsync(String servicePrincipalDescriptor) throws AzDException {
        return builder()
                .DELETE()
                .serviceEndpoint("servicePrincipalDescriptor", servicePrincipalDescriptor)
                .build()
                .executePrimitiveAsync();
    }

    /**
     * Get a service principal by its descriptor.
     *
     * @param servicePrincipalDescriptor The descriptor of the service principal to delete.
     * @return Graph Service Principal object {@link GraphServicePrincipal}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<GraphServicePrincipal> getAsync(String servicePrincipalDescriptor) throws AzDException {
        return builder()
                .serviceEndpoint("servicePrincipalDescriptor", servicePrincipalDescriptor)
                .build()
                .executeAsync(GraphServicePrincipal.class);
    }

    /**
     * Get a list of all service principals in a given scope.
     * Since the list of service principals may be large, results are returned in pages of service principals.
     * If there are more results than can be returned in a single page, the result set will contain a continuation
     * token for retrieval of the next set of results. The only reliable way to know if there is no more service
     * principals left is the lack of a continuation token.
     *
     * @return Collection of graph service principals.
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<GraphServicePrincipals> listAsync() throws AzDException {
        return builder()
                .build()
                .executeAsync(GraphServicePrincipals.class);
    }

    /**
     * Get a list of all service principals in a given scope.
     * Since the list of service principals may be large, results are returned in pages of service principals.
     * If there are more results than can be returned in a single page, the result set will contain a continuation
     * token for retrieval of the next set of results. The only reliable way to know if there is no more service
     * principals left is the lack of a continuation token.
     *
     * @param requestConfiguration Consumer of request configuration. This represents the query parameter for the request.
     * @return Collection of graph service principals.
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<GraphServicePrincipals> listAsync(Consumer<ListRequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .query(ListRequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .executeAsync(GraphServicePrincipals.class);
    }

    /**
     * Materialize an existing AAD service principal into the ADO account.
     *
     * <br><br/><strong>NOTE:</strong> Created service principals are not active in an account.
     *
     * <br><br/>Adding a service principal to an account is required before the service principal can be added to ADO groups or
     * assigned an asset.
     *
     * <br><br/>The body of the request must be a derived type of GraphServicePrincipalCreationContext:
     *
     * <br><br/>{@link GraphServicePrincipalOriginIdCreationContext} - Create a new service principal using the OriginID as a reference
     * to an existing service principal from AAD backed provider.
     *
     * <br><br/>If the service principal to be added corresponds to a service principal that was previously deleted,
     * then that service principal will be restored.
     *
     * <br><br/>Optionally, you can add the newly created service principal as a member of an existing ADO group and/or specify
     * a custom storage key for the service principal.
     *
     * @param creationContext Graph origin id creation context. Pass the origin id to create service principal.
     * @return Graph Service Principal object {@link GraphServicePrincipal}
     * @throws AzDException Default Api exception handler.
     */
    public GraphServicePrincipal create(GraphServicePrincipalOriginIdCreationContext creationContext) throws AzDException {
        return builder()
                .POST(creationContext)
                .build()
                .execute(GraphServicePrincipal.class);
    }

    /**
     * Materialize an existing AAD service principal into the ADO account.
     *
     * <br><br/><strong>NOTE:</strong> Created service principals are not active in an account.
     *
     * <br><br/>Adding a service principal to an account is required before the service principal can be added to ADO groups or
     * assigned an asset.
     *
     * <br><br/>The body of the request must be a derived type of GraphServicePrincipalCreationContext:
     *
     * <br><br/>{@link GraphServicePrincipalOriginIdCreationContext} - Create a new service principal using the OriginID as a reference
     * to an existing service principal from AAD backed provider.
     *
     * <br><br/>If the service principal to be added corresponds to a service principal that was previously deleted,
     * then that service principal will be restored.
     *
     * <br><br/>Optionally, you can add the newly created service principal as a member of an existing ADO group and/or specify
     * a custom storage key for the service principal.
     *
     * @param creationContext      Graph origin id creation context. Pass the origin id to create service principal.
     * @param requestConfiguration Consumer of request configuration. This represents the query parameter for the request.
     * @return Graph Service Principal object {@link GraphServicePrincipal}
     * @throws AzDException Default Api exception handler.
     */
    public GraphServicePrincipal create(GraphServicePrincipalOriginIdCreationContext creationContext,
                                        Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .POST(creationContext)
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .execute(GraphServicePrincipal.class);
    }

    /**
     * Disables a service principal.
     * The service principal will still be visible, but membership checks for the service principal will return false.
     *
     * @param servicePrincipalDescriptor The descriptor of the service principal to delete.
     * @throws AzDException Default Api exception handler.
     */
    public Void delete(String servicePrincipalDescriptor) throws AzDException {
        return builder()
                .DELETE()
                .serviceEndpoint("servicePrincipalDescriptor", servicePrincipalDescriptor)
                .build()
                .executePrimitive();
    }

    /**
     * Get a service principal by its descriptor.
     *
     * @param servicePrincipalDescriptor The descriptor of the service principal to delete.
     * @return Graph Service Principal object {@link GraphServicePrincipal}
     * @throws AzDException Default Api exception handler.
     */
    public GraphServicePrincipal get(String servicePrincipalDescriptor) throws AzDException {
        return builder()
                .serviceEndpoint("servicePrincipalDescriptor", servicePrincipalDescriptor)
                .build()
                .execute(GraphServicePrincipal.class);
    }

    /**
     * Get a list of all service principals in a given scope.
     * Since the list of service principals may be large, results are returned in pages of service principals.
     * If there are more results than can be returned in a single page, the result set will contain a continuation
     * token for retrieval of the next set of results. The only reliable way to know if there is no more service
     * principals left is the lack of a continuation token.
     *
     * @return Collection of graph service principals.
     * @throws AzDException Default Api exception handler.
     */
    public GraphServicePrincipals list() throws AzDException {
        return builder()
                .build()
                .execute(GraphServicePrincipals.class);
    }

    /**
     * Get a list of all service principals in a given scope.
     * Since the list of service principals may be large, results are returned in pages of service principals.
     * If there are more results than can be returned in a single page, the result set will contain a continuation
     * token for retrieval of the next set of results. The only reliable way to know if there is no more service
     * principals left is the lack of a continuation token.
     *
     * @param requestConfiguration Consumer of request configuration. This represents the query parameter for the request.
     * @return Collection of graph service principals.
     * @throws AzDException Default Api exception handler.
     */
    public GraphServicePrincipals list(Consumer<ListRequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .query(ListRequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .execute(GraphServicePrincipals.class);
    }

    /**
     * Represents the query parameters.
     */
    public static class GetQueryParameters {
        /**
         * A comma separated list of descriptors of groups you want the graph service principal to join
         */
        @QueryParameter(name = "groupDescriptors")
        public String[] groupDescriptors;
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
         * An opaque data blob that allows the next page of data to resume immediately after where the previous page
         * ended. The only reliable way to know if there is more data left is the presence of a continuation token.
         */
        @QueryParameter(name = "continuationToken")
        public String continuationToken;
        /**
         * Specify a non-default scope (collection, project) to search for service principals.
         */
        @QueryParameter(name = "scopeDescriptor")
        public String scopeDescriptor;
    }

    /**
     * Request configuration object for the query parameters.
     */
    public static class ListRequestConfiguration {
        public ListQueryParameters queryParameters = new ListQueryParameters();
    }
}
