package org.azd.serviceendpoint;

import org.azd.common.ApiVersion;
import org.azd.connection.Connection;
import org.azd.core.CoreApi;
import org.azd.enums.CustomHeader;
import org.azd.enums.RequestMethod;
import org.azd.enums.ServiceEndpointActionFilter;
import org.azd.exceptions.AzDException;
import org.azd.helpers.JsonMapper;
import org.azd.interfaces.ServiceEndpointDetails;
import org.azd.serviceendpoint.types.ServiceEndpoint;
import org.azd.serviceendpoint.types.ServiceEndpoints;
import org.azd.utils.AzDAsyncApi;

import java.util.*;

import static org.azd.utils.RestClient.send;

/***
 * Service Endpoint Api to manage service endpoint service
 */
public class ServiceEndpointApi extends AzDAsyncApi<ServiceEndpointApi> implements ServiceEndpointDetails {
    /***
     * Connection object
     */
    private final Connection CONNECTION;
    private final JsonMapper MAPPER = new JsonMapper();
    private final String AREA = "serviceendpoint";
    private final String SERVICE_ENDPOINT = "1814ab31-2f4f-4a9f-8761-f4d77dc5a5d7";
    private final CoreApi CORE;


    /***
     * Pass the connection object to work with Service endpoint Api
     * @param connection Connection object
     */
    public ServiceEndpointApi(Connection connection) {
        this.CONNECTION = connection;
        CORE = new CoreApi(CONNECTION);
    }

    /***
     * Creates a new service endpoint
     * @param endpointName Friendly name of the endpoint
     * @param endpointType Type of the endpoint
     * @param requestBody Request body to create a service endpoint.
     * Reference https://docs.microsoft.com/en-us/rest/api/azure/devops/serviceendpoint/endpoints/create?view=azure-devops-rest-6.1#create-service-endpoint
     * @return ServiceEndpoint {@link ServiceEndpoint}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public ServiceEndpoint createServiceEndpoint(String endpointName, String endpointType, Map requestBody) throws AzDException {
        requestBody.put("name", endpointName);
        requestBody.put("type", endpointType);

        String r = send(RequestMethod.POST, CONNECTION, SERVICE_ENDPOINT, null,
                AREA + "/endpoints", null, null, ApiVersion.SERVICE_ENDPOINTS, null, requestBody, CustomHeader.JSON_CONTENT_TYPE);
        return MAPPER.mapJsonResponse(r, ServiceEndpoint.class);
    }

    /***
     * A helper method to create Azure RM service endpoint
     * @param endpointName Friendly name of the endpoint
     * @param servicePrincipalId service principal Id
     * @param servicePrincipalKey service principal key
     * @param tenantId Tenant Id
     * @param subscriptionId subscription Id
     * @param subscriptionName subscription name
     * @return ServiceEndpoint {@link ServiceEndpoint}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public ServiceEndpoint createAzureRMServiceEndpoint(String endpointName, String servicePrincipalId, String servicePrincipalKey,
                                                        String tenantId, String subscriptionId,
                                                        String subscriptionName) throws AzDException {
        var project = CORE.getProject(CONNECTION.getProject());

        var ref = new LinkedHashMap<String, Object>() {{
            put("projectReference", new LinkedHashMap<String, Object>() {{
                put("id", project.getId());
                put("name", project.getName());
            }});
            put("name", endpointName);
        }};

        var lRef = List.of(ref);

        var body = new LinkedHashMap<String, Object>() {{
            put("authorization", new LinkedHashMap<String, Object>() {{
                put("parameters", new LinkedHashMap<String, Object>() {{
                    put("tenantid", tenantId);
                    put("serviceprincipalid", servicePrincipalId);
                    put("authenticationType", "spnKey");
                    put("serviceprincipalkey", servicePrincipalKey);
                }});
                put("scheme", "ServicePrincipal");
            }});
            put("data", new LinkedHashMap<String, Object>() {{
                put("subscriptionId", subscriptionId);
                put("subscriptionName", subscriptionName);
                put("environment", "AzureCloud");
                put("scopeLevel", "Subscription");
                put("creationMode", "Manual");
            }});
            put("url", "https://management.azure.com/");
            put("isShared", false);
            put("isReady", true);
            put("serviceEndpointProjectReferences", lRef);
        }};

        return createServiceEndpoint(endpointName, "azurerm", body);
    }

    /***
     * Get the service endpoint details.
     * @param endpointId Id of the service endpoint.
     * @return ServiceEndpoint {@link ServiceEndpoint}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public ServiceEndpoint getServiceEndpoint(String endpointId) throws AzDException {
        String r = send(RequestMethod.GET, CONNECTION, SERVICE_ENDPOINT, CONNECTION.getProject(),
                AREA + "/endpoints", endpointId, null, ApiVersion.SERVICE_ENDPOINTS, null, null, null);
        return MAPPER.mapJsonResponse(r, ServiceEndpoint.class);
    }

    /***
     * Get the service endpoint details.
     * @param endpointId Id of the service endpoint.
     * @param actionFilter Action filter for the service connection. It specifies the action which can be performed on the service connection.
     * @return ServiceEndpoint {@link ServiceEndpoint}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public ServiceEndpoint getServiceEndpoint(String endpointId, ServiceEndpointActionFilter actionFilter) throws AzDException {
        var q = new HashMap<String, Object>() {{
            put("actionFilter", actionFilter.toString().toLowerCase());
        }};

        String r = send(RequestMethod.GET, CONNECTION, SERVICE_ENDPOINT, CONNECTION.getProject(),
                AREA + "/endpoints", endpointId, null, ApiVersion.SERVICE_ENDPOINTS, q, null, null);
        return MAPPER.mapJsonResponse(r, ServiceEndpoint.class);
    }

    /***
     * Get the service endpoints.
     * @return ServiceEndpoints {@link ServiceEndpoints}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public ServiceEndpoints getServiceEndpoints() throws AzDException {
        String r = send(RequestMethod.GET, CONNECTION, SERVICE_ENDPOINT, CONNECTION.getProject(),
                AREA + "/endpoints", null, null, ApiVersion.SERVICE_ENDPOINTS, null, null, null);
        return MAPPER.mapJsonResponse(r, ServiceEndpoints.class);
    }

    /***
     * Delete a service endpoint
     * @param endpointId Endpoint Id of endpoint to delete
     * @param projectIds project Ids from which endpoint needs to be deleted
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public Void deleteServiceEndpoint(String endpointId, String[] projectIds) throws AzDException {
        try {
            var q = new HashMap<String, Object>() {{
                put("projectIds", String.join(",", projectIds));
            }};

            String r = send(RequestMethod.DELETE, CONNECTION, SERVICE_ENDPOINT, CONNECTION.getProject(),
                    AREA + "/endpoints", endpointId, null, ApiVersion.SERVICE_ENDPOINTS, q, null, null);

            if (!r.isEmpty()) MAPPER.mapJsonResponse(r, Map.class);
        } catch (AzDException e) {
            throw e;
        }
        return null;
    }

    /***
     * Delete a service endpoint
     * @param endpointId Endpoint Id of endpoint to delete
     * @param projectIds project Ids from which endpoint needs to be deleted
     * @param deep delete the spn created by endpoint
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public Void deleteServiceEndpoint(String endpointId, String[] projectIds, boolean deep) throws AzDException {
        try {
            var q = new HashMap<String, Object>() {{
                put("projectIds", String.join(",", projectIds));
                put("deep", deep);
            }};

            String r = send(RequestMethod.DELETE, CONNECTION, SERVICE_ENDPOINT, CONNECTION.getProject(),
                    AREA + "/endpoints", endpointId, null, ApiVersion.SERVICE_ENDPOINTS, q, null, null);

            if (!r.isEmpty()) MAPPER.mapJsonResponse(r, Map.class);
        } catch (AzDException e) {
            throw e;
        }
        return null;
    }

    /***
     * Get the service endpoints by name.
     * @param endpointNames Names of the service endpoints.
     * @return ServiceEndpoint {@link ServiceEndpoint}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public ServiceEndpoints getServiceEndpointsByNames(String[] endpointNames) throws AzDException {
        var q = new HashMap<String, Object>() {{
            put("endpointNames", String.join(",", endpointNames));
        }};

        String r = send(RequestMethod.GET, CONNECTION, SERVICE_ENDPOINT, CONNECTION.getProject(),
                AREA + "/endpoints", null, null, ApiVersion.SERVICE_ENDPOINTS, q, null, null);
        return MAPPER.mapJsonResponse(r, ServiceEndpoints.class);
    }

    /***
     * Get the service endpoints by name.
     * @param endpointNames Names of the service endpoints.
     * @param authSchemes Authorization schemes used for service endpoints.
     * @param includeDetails Flag to include more details for service endpoints.
     * This is for internal use only and the flag will be treated as false for all other requests
     * @param includeFailed Failed flag for service endpoints.
     * @param owner Owner for service endpoints.
     * @param type Type of the service endpoints.
     * @return ServiceEndpoint {@link ServiceEndpoint}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public ServiceEndpoints getServiceEndpointsByNames(String[] endpointNames, String[] authSchemes, boolean includeDetails,
                                                       boolean includeFailed, String owner, String type) throws AzDException {
        var q = new HashMap<String, Object>() {{
            put("endpointNames", String.join(",", endpointNames));
            put("type", type);
            put("authSchemes", String.join(",", authSchemes));
            put("owner", owner);
            put("includeFailed", includeFailed);
            put("includeDetails", includeDetails);
        }};

        String r = send(RequestMethod.GET, CONNECTION, SERVICE_ENDPOINT, CONNECTION.getProject(),
                AREA + "/endpoints", null, null, ApiVersion.SERVICE_ENDPOINTS, q, null, null);
        return MAPPER.mapJsonResponse(r, ServiceEndpoints.class);
    }

    /***
     * Share service endpoint across projects
     * @param endpointId Endpoint Id of the endpoint to share
     * @param projectName Provide the project name to which the service endpoint connection to be shared
     * @param connectionName Name of the connection
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public Void shareServiceEndpoint(String endpointId, String projectName, String connectionName) throws AzDException {
        try {
            var project = CORE.getProject(projectName);

            var body = new LinkedHashMap<String, Object>() {{
                put("projectReference", new LinkedHashMap<String, Object>() {{
                    put("id", project.getId());
                    put("name", project.getName());
                }});
                put("name", connectionName);
            }};

            var ref = new ArrayList<>();
            ref.add(body);

            String r = send(RequestMethod.PATCH, CONNECTION, SERVICE_ENDPOINT, CONNECTION.getProject(),
                    AREA + "/endpoints", endpointId, null, ApiVersion.SERVICE_ENDPOINTS, null, ref, CustomHeader.JSON_CONTENT_TYPE);
            if (!r.isEmpty()) MAPPER.mapJsonResponse(r, Map.class);
        } catch (AzDException e) {
            throw e;
        }
        return null;
    }

    /***
     * Update the service endpoint
     * @param endpointId Endpoint Id of the endpoint to update
     * @param requestBody Request body to update the service endpoint
     * Reference: https://docs.microsoft.com/en-us/rest/api/azure/devops/serviceendpoint/endpoints/update-service-endpoint?view=azure-devops-rest-6.1#update-service-endpoint
     * @return ServiceEndpoint {@link ServiceEndpoint}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public ServiceEndpoint updateServiceEndpoint(String endpointId, Map requestBody) throws AzDException {
        String r = send(RequestMethod.PUT, CONNECTION, SERVICE_ENDPOINT, CONNECTION.getProject(),
                AREA + "/endpoints", endpointId, null, ApiVersion.SERVICE_ENDPOINTS, null, requestBody, CustomHeader.JSON_CONTENT_TYPE);
        return MAPPER.mapJsonResponse(r, ServiceEndpoint.class);
    }
}
