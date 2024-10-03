# ServiceHooks

- [REST API](https://learn.microsoft.com/en-us/rest/api/azure/devops/hooks/?view=azure-devops-rest-7.1)
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

        // create a new subscription
        var publisherInputs = new LinkedHashMap<String, Object>(){{
            put("buildStatus", "Failed");
            put("definitionName", "Demo-CI");
            put("projectId", client.core().projects().get().getId());
        }};

        var consumerInputs = new LinkedHashMap<String, Object>(){{
            put("url", "https://mywebsite/api/users");
        }};

        ServiceHooksSubscription subscription = new ServiceHooksSubscription();
        subscription.setPublisherInputs(publisherInputs);
        subscription.setConsumerInputs(consumerInputs);
        subscription.setPublisherId("tfs");
        subscription.setEventType("build.complete");
        subscription.setResourceVersion("1.0-preview.1");
        subscription.setConsumerId("webHooks");
        subscription.setConsumerActionId("httpRequest");

        client.serviceHooks().subscriptions().create(subscription)

        // delete a subscription
        client.serviceHooks().subscriptions().delete("subscription id");

        // get a list of all subscriptions
        client.serviceHooks().subscriptions().list();

        // get a subscription by id
        client.serviceHooks().subscriptions().get("subscription id");
    }
}
```