# Accounts

- [REST API](https://learn.microsoft.com/en-us/rest/api/azure/devops/account/accounts/list?view=azure-devops-rest-7.1&tabs=HTTP)
- API Version: 7.1

## Example

Before getting started you require personal access token to authenticate with **Azure DevOps** services REST API.
You can grab one by following the [documentation](https://docs.microsoft.com/en-us/azure/devops/organizations/accounts/use-personal-access-tokens-to-authenticate?WT.mc_id=docs-github-dbrown&view=azure-devops&tabs=preview-page).

You are required to create a client object before calling Accounts Api.

```java
public class Main {
    public static void main(String[] args) {
        // Organisation Url -> https://dev.azure.com/{organisation} for Azure DevOps services
        // and http://{server:port}/tfs/{collection} for TFS server.
        // Running Instance.BASE_INSTANCE.getInstance() will return -> https://dev.azure.com/
        // or run Instance.BASE_INSTANCE.append("organisationName") which returns
        // https://dev.azure.com/organisationName

        // Declare variables
        String organisationUrl = Instance.BASE_INSTANCE.append("myOrganisation");
        String projectName = "myProject";
        String personalAccessToken = "myPersonalAccessToken";
        
        // 1) Choose authentication provider
        AccessTokenCredential pat = new PersonalAccessTokenCredential(organisationUrl, projectName, personalAccessToken);
        // or
        AccessTokenCredential oauth = new OAuthAccessTokenCredential(organisationUrl, projectName,
                "appSecret", "authCode", "callbackUrl");

        // 2) Build client using the authentication provider.
        AzDServiceClient client = AzDService.builder().authentication(pat).buildClient();
        // or
        AzDServiceClient client = AzDService.builder().authentication(oauth).buildClient();
        
        try {
            // Use client object to call the APIs.
            // Get the member id from Profile API or Locations API.
            String id = client.locations().getConnectionData().getAuthenticatedUser().getId();
            String profileId = client.accounts().profile().get().getId();
            Accounts accounts = client.accounts().list(id);

            // Returns a future object.
            client.accounts().listAsync(profileId);

            for (var account : accounts.getAccounts())
                System.out.println(account.getAccountName() + " : " + account.getAccountOwner());

            // Organisations
            client.accounts().organization().getAsync().join().getDataProviders();

            // Note that all the result objects has getResponse() which returns ApiResponse object.
            // This contains the request information, request url, raw response, response headers.
            client.accounts().profile().get().getResponse();
            
        } catch (AzDException e) {
            e.printStackTrace();
        }
    }
}
```

