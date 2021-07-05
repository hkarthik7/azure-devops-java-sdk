# ServiceHooks

- [REST API](https://docs.microsoft.com/en-us/rest/api/azure/devops/hooks/?view=azure-devops-rest-6.1)
- API Version: 6.1

## Example

Before getting started you require personal access token to authenticate with **Azure DevOps** services REST API.
You can grab one by following the [documentation](https://docs.microsoft.com/en-us/azure/devops/organizations/accounts/use-personal-access-tokens-to-authenticate?WT.mc_id=docs-github-dbrown&view=azure-devops&tabs=preview-page).

You are required to set the default parameters before calling Core class in the library.

```java
public class Main {
    public static void main(String[] args) {
        String organisation = "myOrganisationName";
        String project = "myProject";
        String personalAccessToken = "accessToken";

        // Create a connection object with organisation name, project and personal access token.
        var connection = new Connection(organisation, project, personalAccessToken);

        // call API with default connection object;
        var core = new CoreApi(defaultParameters);
        var hooks = new ServiceHooksApi(defaultParameters);
        try {
            // create a new subscription
            var projectId = c.getProject(defaultParameters.getProject());

            var publisherInputs = new LinkedHashMap<String, Object>(){{
                put("buildStatus", "Failed");
                put("definitionName", "Demo-CI");
                put("projectId", projectId.getId());
            }};
            
            var consumerInputs = new LinkedHashMap<String, Object>(){{
                put("url", "https://mywebsite/api/users");
            }};
            
            var res = hooks.createSubscription("tfs", "build.complete", "1.0-preview.1", "webHooks",
                    "httpRequest", publisherInputs, consumerInputs);

            // delete a subscription
            hooks.deleteSubscription("subscription id");

            // get a list of all subscriptions
            git.getSubscriptions();

            // get a subscription by id
            hooks.getSubscription("subscription id");
            
        } catch (AzDException | DefaultParametersException e) {
            e.printStackTrace();
        }
    }
}
```