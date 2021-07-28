# Accounts

- [REST API](https://docs.microsoft.com/en-us/rest/api/azure/devops/account/accounts/list?view=azure-devops-rest-6.1)
- API Version: 6.1

## Example

Before getting started you require personal access token to authenticate with **Azure DevOps** services REST API.
You can grab one by following the [documentation](https://docs.microsoft.com/en-us/azure/devops/organizations/accounts/use-personal-access-tokens-to-authenticate?WT.mc_id=docs-github-dbrown&view=azure-devops&tabs=preview-page).

You are required to create a connection object before calling Accounts Api.

```java
public class Main {
    public static void main(String[] args) {
        String organisation = "myOrganisationName";
        String personalAccessToken = "accessToken";
        
        // Create a connection object with organisation name and personal access token.
        var connection = new Connection(organisation, personalAccessToken);
    
        // call API with default connection object;
        var accounts = new AccountsApi(connection);
        var mem = new MemberEntitlementManagementApi(connection);

        try {
            // get the list of accounts that the user has access to.
            var memberId = mem
                    .getUserEntitlements()
                    .getMembers()
                    .stream()
                    .filter(x -> x.getUser().getDisplayName().contains("my-name"))
                    .findFirst()
                    .get()
                    .getId();
            
            accounts.getAccounts(memberId);
            
            // optionally get the list of all organizations
            // this functionality is not the part of Accounts api, it can be considered as a helper method to list the organizations
            // when we don't have access to Graph Api.
            accounts.getOrganizations();
            
            // get a user profile
            accounts.getProfile();
            
            // get a user profile with id
            accounts.getProfile("user-id");

        } catch (ConnectionException | AzDException e) {
            e.printStackTrace();
        }
    }
}
```

