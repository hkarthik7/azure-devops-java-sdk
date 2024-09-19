# ServiceHooks

- [REST API](https://docs.microsoft.com/en-us/rest/api/azure/devops/hooks/?view=azure-devops-rest-6.1)
- API Version: 6.1

## Example

Before getting started you require personal access token to authenticate with **Azure DevOps** services REST API.
You can grab one by following the [documentation](https://docs.microsoft.com/en-us/azure/devops/organizations/accounts/use-personal-access-tokens-to-authenticate?WT.mc_id=docs-github-dbrown&view=azure-devops&tabs=preview-page).

You are required to create a connection object before calling Service hooks Api.

```java
public class Main {
    public static void main(String[] args) {
        String organisation = "myOrganisationName";
        String project = "myProject";
        String personalAccessToken = "accessToken";

        // Connect Azure DevOps API with organisation name and personal access token.
        var webApi = new AzDClientApi(organisation, project, personalAccessToken);

        // call the respective API with created webApi client connection object;
        var core = webApi.getCoreApi(connection);
        var hooks = webApi.getServiceHooksApi(connection);
        try {
            // create a new subscription
            var projectId = c.getProject(connection.getProject());

            var publisherInputs = new LinkedHashMap<String, Object>(){{
                put("buildStatus", "Failed");
                put("definitionName", "Demo-CI");
                put("projectId", projectId.getId());
            }};
            
            var consumerInputs = new LinkedHashMap<String, Object>(){{
                put("url", "https://mywebsite/api/users");
            }};

            serviceHooks.setPublisherId("tfs");
            serviceHooks.setEventType("build.complete");
            serviceHooks.setResourceVersion("1.0-preview.1");
            serviceHooks.setConsumerId("webHooks");
            serviceHooks.setConsumerActionId("httpRequest");
            serviceHooks.setPublisherInputs(publisherInputs);
            serviceHooks.setConsumerInputs(consumerInputs);

            var res = s.createSubscription(serviceHooks);

            // delete a subscription
            hooks.deleteSubscription("subscription id");

            // get a list of all subscriptions
            git.getSubscriptions();

            // get a subscription by id
            hooks.getSubscription("subscription id");
            
        } catch (AzDException e) {
            e.printStackTrace();
        }
    }
}
```