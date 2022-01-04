# Distributed Task

- [REST API](https://docs.microsoft.com/en-us/rest/api/azure/devops/distributedtask/?view=azure-devops-rest-6.1)
- API Version: 6.1

## Example

Before getting started you require personal access token to authenticate with **Azure DevOps** services REST API.
You can grab one by following the [documentation](https://docs.microsoft.com/en-us/azure/devops/organizations/accounts/use-personal-access-tokens-to-authenticate?WT.mc_id=docs-github-dbrown&view=azure-devops&tabs=preview-page).

You are required to create a connection object before calling Distributed task Api.

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
        var distributedTask = webApi.getDistributedTaskApi();
        try {
            // You can get the agent Id and pool Id from the URL when you navigate to the agent pools
            // Go to Organization Settings --> Pipelines --> Agent Pools --> Select any agent
            // For the agent pool Azure Pipelines which is used for default tasks if you click on agents tab
            // You can get the pool Id and agent Id from the URL
            // https://dev.azure.com/<organization name>/<project name>/_settings/agentpools?agentId=8&poolId=9&view=jobs
            // Delete a task agent
            distributedTask.deleteAgent("poolId", "agentId");

            // Get a task agent
            distributedTask.getAgent("poolId", "agentId");

            // get a list of task agents
            distributedTask.getAgents("poolId");

            // Add a new deployment group
            distributedTask.addDeploymentGroup("name", "description");

            // delete a deployment group with id
            distributedTask.deleteDeploymentGroup("deploymentGroupId");

            // Add a variable group
            var variables = new HashMap<>(){{
               put("userName", new HashMap<>(){{
                   put("value", "testUser");
               }});
                put("password", new HashMap<>(){{
                    put("value", "testUser");
                    put("isSecret", true);
                }});
            }};
            
            distributedTask.addVariableGroup("myVariableGroup", "My new Variable group", variables);
            
            // Update a variable group
            // You should specify all the existing variables in the variable group if you're updating one variable.
            // If you didn't specify any existing variables and specified only the variables that needs to be updated,
            // the existing ones will be deleted.
            // Remember that this method does a PUT request to the API.
            distributedTask.updateVariableGroup("groupId", "name", "description", variables);

        } catch (AzDException | ConnectionException e) {
            e.printStackTrace();
        }
    }
}
```