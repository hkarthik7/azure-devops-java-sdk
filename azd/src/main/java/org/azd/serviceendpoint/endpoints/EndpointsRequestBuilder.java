package org.azd.serviceendpoint.endpoints;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.abstractions.QueryParameter;
import org.azd.authentication.AccessTokenCredential;
import org.azd.common.ApiVersion;
import org.azd.enums.ServiceEndpointActionFilter;
import org.azd.exceptions.AzDException;
import org.azd.helpers.Utils;
import org.azd.serviceendpoint.types.RefreshAuthenticationParameters;
import org.azd.serviceendpoint.types.ServiceEndpoint;
import org.azd.serviceendpoint.types.ServiceEndpointProjectReference;
import org.azd.serviceendpoint.types.ServiceEndpoints;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

/**
 * Provides functionality to work with Service endpoint Api.
 */
public class EndpointsRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public EndpointsRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential, "serviceEndpoint", "14e48fdc-2c8b-41ce-a0c3-e26f6cc55bd0", ApiVersion.SERVICE_ENDPOINTS);
    }

    /**
     * Creates a new service endpoint
     *
     * @param serviceEndpoint Service endpoint object to create.
     * @return ServiceEndpoint {@link ServiceEndpoint}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<ServiceEndpoint> createAsync(ServiceEndpoint serviceEndpoint) throws AzDException {
        return builder()
                .POST(serviceEndpoint)
                .build()
                .executeAsync(ServiceEndpoint.class);
    }

    /**
     * Delete a service endpoint.
     *
     * @param endpointId           Endpoint Id of endpoint to delete.
     * @param requestConfiguration Consumer of delete request configuration.
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<Void> deleteAsync(String endpointId, Consumer<DeleteRequestConfiguration> requestConfiguration)
            throws AzDException {
        return builder()
                .DELETE()
                .serviceEndpoint("endpointId", endpointId)
                .query(DeleteRequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .executePrimitiveAsync();
    }

    /**
     * Get the service endpoint details.
     *
     * @param endpointId Id of the service endpoint.
     * @return Service endpoint {@link ServiceEndpoint}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<ServiceEndpoint> getAsync(String endpointId) throws AzDException {
        return builder()
                .location("e85f1c62-adfc-4b74-b618-11a150fb195e")
                .serviceEndpoint("endpointId", endpointId)
                .build()
                .executeAsync(ServiceEndpoint.class);
    }

    /**
     * Get the service endpoint details.
     *
     * @param endpointId   Id of the service endpoint.
     * @param actionFilter Action filter for the service connection. It specifies the action which can
     *                     be performed on the service connection.
     * @return Service endpoint {@link ServiceEndpoint}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<ServiceEndpoint> getAsync(String endpointId, ServiceEndpointActionFilter actionFilter) throws AzDException {
        return builder()
                .location("e85f1c62-adfc-4b74-b618-11a150fb195e")
                .serviceEndpoint("endpointId", endpointId)
                .query("actionFilter", actionFilter.name())
                .build()
                .executeAsync(ServiceEndpoint.class);
    }

    /**
     * Get the service endpoints.
     *
     * @return ServiceEndpoints {@link ServiceEndpoints}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<ServiceEndpoints> listAsync() throws AzDException {
        return builder()
                .location("e85f1c62-adfc-4b74-b618-11a150fb195e")
                .build()
                .executeAsync(ServiceEndpoints.class);
    }

    /**
     * Get the service endpoints.
     *
     * @param requestConfiguration Represents the query parameters
     * @return ServiceEndpoints {@link ServiceEndpoints}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<ServiceEndpoints> listAsync(Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .location("e85f1c62-adfc-4b74-b618-11a150fb195e")
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .executeAsync(ServiceEndpoints.class);
    }

    /**
     * Get the service endpoints by name.
     *
     * @param endpointNames Names of the service endpoints.
     * @return ServiceEndpoints {@link ServiceEndpoints}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<ServiceEndpoints> getByNamesAsync(String... endpointNames) throws AzDException {
        return builder()
                .location("e85f1c62-adfc-4b74-b618-11a150fb195e")
                .query("endpointNames", Utils.toString(endpointNames))
                .build()
                .executeAsync(ServiceEndpoints.class);
    }

    /**
     * Get the service endpoints by name.
     *
     * @param requestConfiguration Represents the query parameters
     * @return ServiceEndpoints {@link ServiceEndpoints}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<ServiceEndpoints> getByNamesAsync(Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .location("e85f1c62-adfc-4b74-b618-11a150fb195e")
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .executeAsync(ServiceEndpoints.class);
    }

    /**
     * Gets the service endpoints and patch new authorization parameters
     *
     * @param endpointIds                     Ids of the service endpoints.
     * @param refreshAuthenticationParameters Scope, Validity of Token requested.
     * @return ServiceEndpoints {@link ServiceEndpoints}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<ServiceEndpoints> getWithRefreshedAuthenticationAsync(String[] endpointIds,
                                                                                   List<RefreshAuthenticationParameters> refreshAuthenticationParameters)
            throws AzDException {
        return builder()
                .POST(refreshAuthenticationParameters)
                .location("e85f1c62-adfc-4b74-b618-11a150fb195e")
                .query("endpointIds", Utils.toString(endpointIds))
                .build()
                .executeAsync(ServiceEndpoints.class);
    }

    /**
     * Share service endpoint across projects
     *
     * @param endpointId                       Endpoint Id of the endpoint to share
     * @param serviceEndpointProjectReferences Project reference details of the target project
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<Void> shareAsync(String endpointId,
                                              List<ServiceEndpointProjectReference> serviceEndpointProjectReferences)
            throws AzDException {
        return builder()
                .PATCH(serviceEndpointProjectReferences)
                .serviceEndpoint("endpointId", endpointId)
                .build()
                .executePrimitiveAsync();
    }

    /**
     * Update the service endpoint
     *
     * @param endpointId      Endpoint Id of the endpoint to update
     * @param serviceEndpoint Service endpoint object to update.
     * @return ServiceEndpoint {@link ServiceEndpoint}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<ServiceEndpoint> updateAsync(String endpointId, ServiceEndpoint serviceEndpoint) throws AzDException {
        return builder()
                .PUT(serviceEndpoint)
                .serviceEndpoint("endpointId", endpointId)
                .build()
                .executeAsync(ServiceEndpoint.class);
    }

    /**
     * Update the service endpoint
     *
     * @param endpointId      Endpoint Id of the endpoint to update
     * @param serviceEndpoint Service endpoint object to update.
     * @return ServiceEndpoint {@link ServiceEndpoint}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<ServiceEndpoint> updateAsync(String endpointId, ServiceEndpoint serviceEndpoint, String operation) throws AzDException {
        return builder()
                .PUT(serviceEndpoint)
                .serviceEndpoint("endpointId", endpointId)
                .query("operation", operation)
                .build()
                .executeAsync(ServiceEndpoint.class);
    }

    /**
     * Update the service endpoints.
     *
     * @param serviceEndpoints service endpoints object to update
     * @return ServiceEndpoints {@link ServiceEndpoints}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<ServiceEndpoints> updateAsync(ServiceEndpoints serviceEndpoints) throws AzDException {
        return builder()
                .PUT(serviceEndpoints)
                .build()
                .executeAsync(ServiceEndpoints.class);
    }

    /**
     * Creates a new service endpoint
     *
     * @param serviceEndpoint Service endpoint object to create.
     * @return ServiceEndpoint {@link ServiceEndpoint}
     * @throws AzDException Default Api Exception handler.
     */
    public ServiceEndpoint create(ServiceEndpoint serviceEndpoint) throws AzDException {
        return builder()
                .POST(serviceEndpoint)
                .build()
                .execute(ServiceEndpoint.class);
    }

    /**
     * Delete a service endpoint.
     *
     * @param endpointId           Endpoint Id of endpoint to delete.
     * @param requestConfiguration Consumer of delete request configuration that represents the query parameters.
     * @throws AzDException Default Api Exception handler.
     */
    public Void delete(String endpointId, Consumer<DeleteRequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .DELETE()
                .serviceEndpoint("endpointId", endpointId)
                .query(DeleteRequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .executePrimitive();
    }

    /**
     * Get the service endpoint details.
     *
     * @param endpointId Id of the service endpoint.
     * @return Service endpoint {@link ServiceEndpoint}
     * @throws AzDException Default Api Exception handler.
     */
    public ServiceEndpoint get(String endpointId) throws AzDException {
        return builder()
                .location("e85f1c62-adfc-4b74-b618-11a150fb195e")
                .serviceEndpoint("endpointId", endpointId)
                .build()
                .execute(ServiceEndpoint.class);
    }

    /**
     * Get the service endpoint details.
     *
     * @param endpointId   Id of the service endpoint.
     * @param actionFilter Action filter for the service connection. It specifies the action which can
     *                     be performed on the service connection.
     * @return Service endpoint {@link ServiceEndpoint}
     * @throws AzDException Default Api Exception handler.
     */
    public ServiceEndpoint get(String endpointId, ServiceEndpointActionFilter actionFilter) throws AzDException {
        return builder()
                .location("e85f1c62-adfc-4b74-b618-11a150fb195e")
                .serviceEndpoint("endpointId", endpointId)
                .query("actionFilter", actionFilter.name())
                .build()
                .execute(ServiceEndpoint.class);
    }

    /**
     * Get the service endpoints.
     *
     * @return ServiceEndpoints {@link ServiceEndpoints}
     * @throws AzDException Default Api Exception handler.
     */
    public ServiceEndpoints list() throws AzDException {
        return builder()
                .location("e85f1c62-adfc-4b74-b618-11a150fb195e")
                .build()
                .execute(ServiceEndpoints.class);
    }

    /**
     * Get the service endpoints.
     *
     * @param requestConfiguration Represents the query parameters
     * @return ServiceEndpoints {@link ServiceEndpoints}
     * @throws AzDException Default Api Exception handler.
     */
    public ServiceEndpoints list(Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .location("e85f1c62-adfc-4b74-b618-11a150fb195e")
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .execute(ServiceEndpoints.class);
    }

    /**
     * Get the service endpoints by name.
     *
     * @param endpointNames Names of the service endpoints.
     * @return ServiceEndpoints {@link ServiceEndpoints}
     * @throws AzDException Default Api Exception handler.
     */
    public ServiceEndpoints getByNames(String... endpointNames) throws AzDException {
        return builder()
                .location("e85f1c62-adfc-4b74-b618-11a150fb195e")
                .query("endpointNames", Utils.toString(endpointNames))
                .build()
                .execute(ServiceEndpoints.class);
    }

    /**
     * Get the service endpoints by name.
     *
     * @param requestConfiguration Represents the query parameters
     * @return ServiceEndpoints {@link ServiceEndpoints}
     * @throws AzDException Default Api Exception handler.
     */
    public ServiceEndpoints getByNames(Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .location("e85f1c62-adfc-4b74-b618-11a150fb195e")
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .execute(ServiceEndpoints.class);
    }

    /**
     * Gets the service endpoints and patch new authorization parameters
     *
     * @param endpointIds                     Ids of the service endpoints.
     * @param refreshAuthenticationParameters Scope, Validity of Token requested.
     * @return ServiceEndpoints {@link ServiceEndpoints}
     * @throws AzDException Default Api Exception handler.
     */
    public ServiceEndpoints getWithRefreshedAuthentication(String[] endpointIds,
                                                           List<RefreshAuthenticationParameters> refreshAuthenticationParameters)
            throws AzDException {
        return builder()
                .POST(refreshAuthenticationParameters)
                .location("e85f1c62-adfc-4b74-b618-11a150fb195e")
                .query("endpointIds", Utils.toString(endpointIds))
                .build()
                .execute(ServiceEndpoints.class);
    }

    /**
     * Share service endpoint across projects
     *
     * @param endpointId                       Endpoint Id of the endpoint to share
     * @param serviceEndpointProjectReferences Project reference details of the target project
     * @throws AzDException Default Api Exception handler.
     */
    public Void share(String endpointId,
                      List<ServiceEndpointProjectReference> serviceEndpointProjectReferences)
            throws AzDException {
        return builder()
                .PATCH(serviceEndpointProjectReferences)
                .serviceEndpoint("endpointId", endpointId)
                .build()
                .executePrimitive();
    }

    /**
     * Update the service endpoint
     *
     * @param endpointId      Endpoint Id of the endpoint to update
     * @param serviceEndpoint Service endpoint object to update.
     * @return ServiceEndpoint {@link ServiceEndpoint}
     * @throws AzDException Default Api Exception handler.
     */
    public ServiceEndpoint update(String endpointId, ServiceEndpoint serviceEndpoint) throws AzDException {
        return builder()
                .PUT(serviceEndpoint)
                .serviceEndpoint("endpointId", endpointId)
                .build()
                .execute(ServiceEndpoint.class);
    }

    /**
     * Update the service endpoint
     *
     * @param endpointId      Endpoint Id of the endpoint to update
     * @param serviceEndpoint Service endpoint object to update.
     * @return ServiceEndpoint {@link ServiceEndpoint}
     * @throws AzDException Default Api Exception handler.
     */
    public ServiceEndpoint update(String endpointId, ServiceEndpoint serviceEndpoint, String operation) throws AzDException {
        return builder()
                .PUT(serviceEndpoint)
                .serviceEndpoint("endpointId", endpointId)
                .query("operation", operation)
                .build()
                .execute(ServiceEndpoint.class);
    }

    /**
     * Update the service endpoints.
     *
     * @param serviceEndpoints service endpoints object to update
     * @return ServiceEndpoints {@link ServiceEndpoints}
     * @throws AzDException Default Api Exception handler.
     */
    public ServiceEndpoints update(ServiceEndpoints serviceEndpoints) throws AzDException {
        return builder()
                .PUT(serviceEndpoints)
                .build()
                .execute(ServiceEndpoints.class);
    }


    /**
     * Represents the query parameters.
     */
    public static class GetQueryParameters {
        /**
         * Authorization schemes used for service endpoints.
         */
        @QueryParameter(name = "authSchemes")
        public String authSchemes;
        /**
         * Ids of the service endpoints.
         */
        @QueryParameter(name = "endpointIds")
        public String[] endpointIds;
        /**
         * Names of the service endpoints.
         */
        @QueryParameter(name = "endpointNames")
        public String[] endpointNames;
        /**
         * Flag to include more details for service endpoints. This is for internal use only and the flag will be
         * treated as false for all other requests
         */
        @QueryParameter(name = "includeDetails")
        public Boolean includeDetails;
        /**
         * Failed flag for service endpoints.
         */
        @QueryParameter(name = "includeFailed")
        public Boolean includeFailed;
        /**
         * Owner for service endpoints.
         */
        @QueryParameter(name = "owner")
        public String owner;
        /**
         * Type of the service endpoints.
         */
        @QueryParameter(name = "type")
        public String type;
    }

    /**
     * Request configuration object for the query parameters.
     */
    public static class RequestConfiguration {
        public GetQueryParameters queryParameters = new GetQueryParameters();
    }

    /**
     * Represents the delete query parameters.
     */
    public static class DeleteQueryParameters {
        /**
         * Project Ids from which endpoint needs to be deleted
         */
        @QueryParameter(name = "projectIds")
        public String[] projectIds;
        /**
         * Delete the spn created by endpoint
         */
        @QueryParameter(name = "deep")
        public Boolean deep;
    }

    /**
     * Request configuration object for the query parameters.
     */
    public static class DeleteRequestConfiguration {
        public DeleteQueryParameters queryParameters = new DeleteQueryParameters();
    }
}
