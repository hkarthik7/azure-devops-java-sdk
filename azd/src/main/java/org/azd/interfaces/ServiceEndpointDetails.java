package org.azd.interfaces;

import org.azd.enums.ServiceEndpointActionFilter;
import org.azd.exceptions.AzDException;
import org.azd.serviceendpoint.types.ServiceEndpoint;
import org.azd.serviceendpoint.types.ServiceEndpoints;

import java.util.Map;

public interface ServiceEndpointDetails {
    ServiceEndpoint createServiceEndpoint(String endpointName, String endpointType, Map requestBody) throws AzDException;

    ServiceEndpoint createAzureRMServiceEndpoint(String endpointName, String servicePrincipalId,
                                                 String servicePrincipalKey, String tenantId, String subscriptionId,
                                                 String subscriptionName) throws AzDException;

    ServiceEndpoint getServiceEndpoint(String endpointId) throws AzDException;

    ServiceEndpoint getServiceEndpoint(String endpointId, ServiceEndpointActionFilter actionFilter) throws AzDException;

    ServiceEndpoints getServiceEndpoints() throws AzDException;

    Void deleteServiceEndpoint(String endpointId, String[] projectIds) throws AzDException;

    Void deleteServiceEndpoint(String endpointId, String[] projectIds, boolean deep) throws AzDException;

    ServiceEndpoints getServiceEndpointsByNames(String[] endpointNames) throws AzDException;

    ServiceEndpoints getServiceEndpointsByNames(String[] endpointNames, String[] authSchemes,
                                                boolean includeDetails, boolean includeFailed,
                                                String owner, String type) throws AzDException;

    Void shareServiceEndpoint(String endpointId, String projectName, String connectionName) throws AzDException;

    ServiceEndpoint updateServiceEndpoint(String endpointId, Map serviceEndpoint) throws AzDException;
}
