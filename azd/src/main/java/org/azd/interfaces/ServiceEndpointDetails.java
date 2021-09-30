package org.azd.interfaces;

import org.azd.enums.ServiceEndpointActionFilter;
import org.azd.exceptions.AzDException;
import org.azd.exceptions.ConnectionException;
import org.azd.serviceendpoint.types.ServiceEndpoint;
import org.azd.serviceendpoint.types.ServiceEndpoints;

import java.util.Map;

public interface ServiceEndpointDetails {
    ServiceEndpoint createServiceEndpoint(String endpointName, String endpointType, Map requestBody) throws ConnectionException, AzDException;
    ServiceEndpoint createAzureRMServiceEndpoint(String endpointName, String servicePrincipalId,
                                                 String servicePrincipalKey, String tenantId, String subscriptionId,
                                                 String subscriptionName) throws ConnectionException, AzDException;
    ServiceEndpoint getServiceEndpoint(String endpointId) throws ConnectionException, AzDException;
    ServiceEndpoint getServiceEndpoint(String endpointId, ServiceEndpointActionFilter actionFilter) throws ConnectionException, AzDException;
    ServiceEndpoints getServiceEndpoints() throws ConnectionException, AzDException;
    void deleteServiceEndpoint(String endpointId, String[] projectIds) throws ConnectionException, AzDException;
    void deleteServiceEndpoint(String endpointId, String[] projectIds, boolean deep) throws ConnectionException, AzDException;
    ServiceEndpoints getServiceEndpointsByNames(String[] endpointNames) throws ConnectionException, AzDException;
    ServiceEndpoints getServiceEndpointsByNames(String[] endpointNames, String[] authSchemes,
                                                boolean includeDetails, boolean includeFailed,
                                                String owner, String type) throws ConnectionException, AzDException;
    void shareServiceEndpoint(String endpointId, String projectName, String connectionName) throws ConnectionException, AzDException;
    ServiceEndpoint updateServiceEndpoint(String endpointId, Map serviceEndpoint) throws ConnectionException, AzDException;
}
