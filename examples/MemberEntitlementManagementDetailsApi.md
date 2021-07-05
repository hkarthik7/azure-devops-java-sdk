# Member Entitlement Management

- [REST API](https://docs.microsoft.com/en-us/rest/api/azure/devops/memberentitlementmanagement/?view=azure-devops-rest-6.1)
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
        
        // instantiate AzDDefaultParameters with organisation name, project and personal access token.
        AzDDefaultParameters defaultParameters = new AzDDefaultParameters(organisation, project, personalAccessToken);
    
        // call API with the default parameters;
        var mem = new MemberEntitlementManagementApi(defaultParameters);
        var graph = new GraphApi(defaultParams);
        var core = new CoreApi(defaultParams);
        
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
        } catch (AzDException | DefaultParametersException e) {
            e.printStackTrace();
        }
    }
}
```