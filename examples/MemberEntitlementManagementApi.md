# Member Entitlement Management

- [REST API](https://docs.microsoft.com/en-us/rest/api/azure/devops/memberentitlementmanagement/?view=azure-devops-rest-6.1)
- API Version: 6.1

## Example

Before getting started you require personal access token to authenticate with **Azure DevOps** services REST API.
You can grab one by following the [documentation](https://docs.microsoft.com/en-us/azure/devops/organizations/accounts/use-personal-access-tokens-to-authenticate?WT.mc_id=docs-github-dbrown&view=azure-devops&tabs=preview-page).

You are required to create a connection object before calling Member Entitlement Management Api.

```java
public class Main {
    public static void main(String[] args) {
        String organisation = "myOrganisationName";
        String project = "myProject";
        String personalAccessToken = "accessToken";

        // Connect Azure DevOps API with organisation name and personal access token.
        var webApi = new AzDClientApi(organisation, project, personalAccessToken);

        // call the respective API with created webApi client connection object;
        var mem = webApi.memberEntitlementManagementApi();
        var graph = webApi.graphApi();
        var core = webApi.coreApi();
        
        try {
            // Add a new user and assign license
            mem.addUserEntitlement(AccountLicenseType.EXPRESS, "test@hotmail.com", GroupType.PROJECTREADER, core.getProject(project).getId());

            // delete an user entitlement
            String userId = mem.getUserEntitlements()
                    .getMembers()
                    .stream()
                    .findFirst()
                    .get()
                    .getId();

            mem.deleteUserEntitlement(userId);

            // get a user with user id
            mem.getUserEntitlement(userId);

            // list the groups
            mem.getGroupEntitlements();

            // get members of a group
            var groups = graph.getGroups();

            String groupId = groups
                    .getGraphGroups()
                    .stream()
                    .filter(x -> x.getDisplayName().equals("Readers"))
                    .findFirst()
                    .get()
                    .getOriginId();

            mem.getMembers(groupId);

            // get user entitlement summary
            mem.getUserEntitlementSummary();            
        } catch (AzDException | ConnectionException e) {
            e.printStackTrace();
        }
    }
}
```