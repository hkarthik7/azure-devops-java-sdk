package org.azd.helpers.serviceendpoint;

import org.azd.authentication.AccessTokenCredential;
import org.azd.common.ResourceId;
import org.azd.core.CoreRequestBuilder;
import org.azd.exceptions.AzDException;
import org.azd.locations.LocationsBaseRequestBuilder;
import org.azd.release.types.ProjectReference;
import org.azd.serviceendpoint.ServiceEndpointRequestBuilder;
import org.azd.serviceendpoint.types.EndpointAuthorization;
import org.azd.serviceendpoint.types.ServiceEndpoint;
import org.azd.serviceendpoint.types.ServiceEndpointProjectReference;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * Helper request builder that combines multiple Apis to create logical helper methods for ease of use.
 */
public class ServiceEndpointHelpersRequestBuilder extends ServiceEndpointRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public ServiceEndpointHelpersRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential);
    }

    /**
     * A helper method to create Azure RM service endpoint
     *
     * @param endpointName        Friendly name of the endpoint
     * @param servicePrincipalId  service principal Id
     * @param servicePrincipalKey service principal key
     * @param tenantId            Tenant Id
     * @param subscriptionId      subscription Id
     * @param subscriptionName    subscription name
     * @return ServiceEndpoint {@link ServiceEndpoint}
     * @throws AzDException Default Api Exception handler.
     */
    public ServiceEndpoint createAzureRMServiceEndpoint(String endpointName, String servicePrincipalId, String servicePrincipalKey,
                                               String tenantId, String subscriptionId,
                                               String subscriptionName) throws AzDException {
        var locationBuilder = new LocationsBaseRequestBuilder(organizationUrl, accessTokenCredential);
        var coreBuilder = new CoreRequestBuilder(locationBuilder.getUrl(ResourceId.CORE), accessTokenCredential);
        var project = coreBuilder.projects().get();

        var projectReference = new ProjectReference();
        projectReference.setName(project.getName());
        projectReference.setId(project.getId());

        var ref = new ServiceEndpointProjectReference();
        ref.setName(endpointName);
        ref.setProjectReference(projectReference);

        var serviceEndpoint = new ServiceEndpoint();

        serviceEndpoint.setServiceEndpointProjectReferences(List.of(ref));

        var authorization = new EndpointAuthorization();
        var authorizationParams = new LinkedHashMap<String, Object>() {{
            put("tenantid", tenantId);
            put("serviceprincipalid", servicePrincipalId);
            put("authenticationType", "spnKey");
            put("serviceprincipalkey", servicePrincipalKey);
        }};

        authorization.setParameters(authorizationParams);
        authorization.setScheme("ServicePrincipal");

        serviceEndpoint.setAuthorization(authorization);
        var data = new LinkedHashMap<String, Object>() {{
            put("subscriptionId", subscriptionId);
            put("subscriptionName", subscriptionName);
            put("environment", "AzureCloud");
            put("scopeLevel", "Subscription");
            put("creationMode", "Manual");
        }};

        serviceEndpoint.setData(data);
        serviceEndpoint.setUrl("https://management.azure.com/");
        serviceEndpoint.setIsShared(false);
        serviceEndpoint.setIsReady(true);

        return endpoints().create(serviceEndpoint);
    }
}
