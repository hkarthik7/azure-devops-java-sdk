# ServiceEndpoint

- [REST API](https://docs.microsoft.com/en-us/rest/api/azure/devops/serviceendpoint/endpoints?view=azure-devops-rest-6.1)
- API Version: 6.1-preview

## Example

Before getting started you require personal access token to authenticate with **Azure DevOps** services REST API.
You can grab one by following the [documentation](https://docs.microsoft.com/en-us/azure/devops/organizations/accounts/use-personal-access-tokens-to-authenticate?WT.mc_id=docs-github-dbrown&view=azure-devops&tabs=preview-page).

You are required to create a connection object before calling Wiki Api.

```java
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        String organisation = "myOrganisationName";
        String project = "myProject";
        String personalAccessToken = "accessToken";

        // Connect Azure DevOps API with organisation name and personal access token.
        var webApi = new AzDClientApi(organisation, project, personalAccessToken);

        // call the respective API with created webApi client connection object;
        var sEndpoint = webApi.getServiceEndpointApi();

        try {
            // Create Azure RM service endpoint
            sEndpoint.createAzureRMServiceEndpoint(
                    "myEndpoint",
                    "servicePrincipalId",
                    "servicePrincipalKey",
                    "tenantId",
                    "subscriptionId",
                    "subscriptionName");

            // Get all Service endpoints
            sEndpoint.getServiceEndpoints();

            // Get a service endpoint by endpoint Id
            sEndpoint.getServiceEndpoint("endpoint id");

            // Delete a service endpoint
            sEndpoint.deleteServiceEndpoint("endpoint-id", new String[]{"projectid"});

            // Get all service endpoints by names
            sEndpoint.getServiceEndpointsByNames(new String[]{"myEndpoint"});

            // Share the endpoint connection between the project
            sEndpoint.shareServiceEndpoint("endpoint-id", "project-name-to-share-the-connection", "connection name");

            // Update a service endpoint
            sEndpoint.updateServiceEndpoint("endpoint", "Specify the request body with all details to update a service endpoint");
        } catch (AzDException e) {
            e.printStackTrace();
        }
    }
}
```