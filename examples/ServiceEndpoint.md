# ServiceEndpoint

- [REST API](https://learn.microsoft.com/en-us/rest/api/azure/devops/serviceendpoint/endpoints?view=azure-devops-rest-7.1)
- API Version: 7.1

## Example

Before getting started you require personal access token to authenticate to **Azure DevOps** services REST API.
You can grab one by following the [documentation](https://docs.microsoft.com/en-us/azure/devops/organizations/accounts/use-personal-access-tokens-to-authenticate?WT.mc_id=docs-github-dbrown&view=azure-devops&tabs=preview-page).

Or if you are using OAuth token, follow
- [Authorize access to REST APIs with OAuth 2.0](https://learn.microsoft.com/en-us/azure/devops/integrate/get-started/authentication/oauth?view=azure-devops)
- [Use Azure DevOps OAuth 2.0 to create a web app](https://learn.microsoft.com/en-us/azure/devops/integrate/get-started/authentication/azure-devops-oauth?toc=%2Fazure%2Fdevops%2Fmarketplace-extensibility%2Ftoc.json&view=azure-devops)

Use [VsoScope](https://github.com/hkarthik7/azure-devops-java-sdk/blob/feature/v6.0/azd/src/main/java/org/azd/enums/VsoScope.java) to easily access
the API scope values.


```java
public class Main {
    public static void main(String[] args) throws AzDException {
        // Organisation Url -> https://dev.azure.com/{organisation} for Azure DevOps services
        // and http://{server:port}/tfs/{collection} for TFS server.
        // Running Instance.BASE_INSTANCE.getInstance() will return -> https://dev.azure.com/
        // or run Instance.BASE_INSTANCE.append("organisationName") which returns
        // https://dev.azure.com/organisationName

        String organisationUrl = Instance.BASE_INSTANCE.append("myOrganisation");
        String projectName = "myProject";
        String personalAccessToken = "myPersonalAccessToken";
        // 1) Choose authentication provider
        AccessTokenCredential pat = new PersonalAccessTokenCredential(organisationUrl, projectName, 
                personalAccessToken);
        // or
        AccessTokenCredential oauth = new OAuthAccessTokenCredential(organisationUrl, projectName,
                "appSecret", "authCode", "callbackUrl");

        // 2) Build client using the authentication provider. 
        AzDServiceClient client = AzDService.builder().authentication(pat).buildClient();
        // or
        AzDServiceClient client = AzDService.builder().authentication(oauth).buildClient();

        // Use client object to call the APIs.

        // Create Azure RM service endpoint
        Project project = client.core().projects().get();

        ProjectReference projectReference = new ProjectReference();
        projectReference.setName(project.getName());
        projectReference.setId(project.getId());

        ServiceEndpointProjectReference ref = new ServiceEndpointProjectReference();
        ref.setName(endpointName);
        ref.setProjectReference(projectReference);

        ServiceEndpoint serviceEndpoint = new ServiceEndpoint();

        serviceEndpoint.setServiceEndpointProjectReferences(List.of(ref));

        EndpointAuthorization authorization = new EndpointAuthorization();
        LinkedHashMap<String, Object> authorizationParams = new LinkedHashMap<>() {{
            put("tenantid", tenantId);
            put("serviceprincipalid", servicePrincipalId);
            put("authenticationType", "spnKey");
            put("serviceprincipalkey", servicePrincipalKey);
        }};

        authorization.setParameters(authorizationParams);
        authorization.setScheme("ServicePrincipal");

        serviceEndpoint.setAuthorization(authorization);
        LinkedHashMap<String, Object> data = new LinkedHashMap<>() {{
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

        client.serviceEndpoint().endpoints().create(serviceEndpoint);
        
        // OR USE HELPERS

        client.helpers().serviceEndpoint().createAzureRMServiceEndpoint(
                "myEndpoint",
                "servicePrincipalId",
                "servicePrincipalKey",
                "tenantId",
                "subscriptionId",
                "subscriptionName");

        // Get all Service endpoints
        client.serviceEndpoint().endpoints().list();

        // Get a service endpoint by endpoint Id
        client.serviceEndpoint().endpoints().get("endpointId");

        // Delete a service endpoint
        String projectId = client.core().projects().get().getId();
        client.serviceEndpoint().endpoints().delete("endpointId", r -> r.queryParameters.projectIds = new String[]{projectId});

        // Get all service endpoints by names
        client.serviceEndpoint().endpoints().getByNames("myEndpoint", "...");

        // Share the endpoint connection between the project
        Project project = client.core().projects().get("myProject");

        ProjectReference projectReference = new ProjectReference();
        projectReference.setId(project.getId());
        projectReference.setName(project.getName());

        ServiceEndpointProjectReference serviceEndpointProjectReference = new ServiceEndpointProjectReference();
        serviceEndpointProjectReference.setProjectReference(projectReference);
        serviceEndpointProjectReference.setName("myServiceConnection");

        client.serviceEndpoint().endpoints().share("endpointId", List.of(serviceEndpointProjectReference))

        // Update a service endpoint
        ServiceEndpoints serviceEndpoints = client.serviceEndpoint().endpoints().list();
        serviceEndpoints.getServiceEndpoints().get(0).setDescription("Modified service endpoint");

        client.serviceEndpoint().endpoints().update(serviceEndpoints);
    }
}
```