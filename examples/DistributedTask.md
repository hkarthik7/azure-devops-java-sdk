# Distributed Task

- [REST API](https://learn.microsoft.com/en-us/rest/api/azure/devops/distributedtask/?view=azure-devops-rest-7.1)
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
        // Please get the agent Id and pool Id from the URL.
        // Go to Organization Settings --> Pipelines --> Agent Pools --> Select any agent
        // For the agent pool Azure Pipelines which is used for default tasks please click on agents tab
        // and get the pool Id & agent Id from the URL.
        
        // https://dev.azure.com/<organization name>/<project name>/_settings/agentpools?agentId=8&poolId=9&view=jobs
        
        // Delete a task agent
        client.distributedTask().agents().delete("poolId", "agentId");

        // Get a task agent
        client.distributedTask().agents().get("poolId", "agentId");
        
        // or 

        client.distributedTask().agents().getAsync("poolId", "agentId");

        // get a list of task agents
        client.distributedTask().agents().list("poolId");

        // Add a new deployment group
        DeploymentGroupsRequestBuilder.DeploymentGroupRequest deploymentGroupRequest = new DeploymentGroupsRequestBuilder.DeploymentGroupRequest();
        deploymentGroupRequest.description = "New deployment group.";
        deploymentGroupRequest.name = "myDeploymentGroup";

        client.distributedTask().deploymentGroups().add(deploymentGroupRequest);

        // delete a deployment group with id
        client.distributedTask().deploymentGroups().delete("deploymentGroupId");

        // Add a variable group
        ProjectReference projectReference = new ProjectReference();
        projectReference.setName("myProject");
        projectReference.setId("projectId");

        VariableGroupProjectReference variableGroupProjectReference = new VariableGroupProjectReference();
        variableGroupProjectReference.setName("myVariableGroup");
        variableGroupProjectReference.setDescription("My new Variable group");
        variableGroupProjectReference.setProjectReference(projectReference);

        VariableGroupLibrary variableGroupLibrary = new VariableGroupLibrary();
        variableGroupLibrary.variableGroupProjectReferences = List.of(variableGroupProjectReference);

        ConfigurableVariableValue userValue = new ConfigurableVariableValue();
        userValue.setValue("testUser");

        ConfigurableVariableValue passwordValue = new ConfigurableVariableValue();
        passwordValue.setValue("testUserPassword");
        passwordValue.setSecret(true);

        variableGroupLibrary.variables = Map.of("userName", userValue, "password", passwordValue);

        client.distributedTask().variableGroups().add(variableGroupLibrary);

        // Update a variable group
        client.distributedTask().variableGroups().update(1, variableGroupLibrary);
    }
}
```