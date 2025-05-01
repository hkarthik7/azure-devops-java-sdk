# MemberEntitlementManagement

- [REST API](https://learn.microsoft.com/en-us/rest/api/azure/devops/memberentitlementmanagement/?view=azure-devops-rest-7.1)
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

        // Add a new user and assign license
        Group group = new Group();
        group.setGroupType(GroupType.PROJECT_READER);

        ProjectRef projectRef = new ProjectRef();
        projectRef.setId(client.core().projects().get().getId());

        ProjectEntitlement projectEntitlement = new ProjectEntitlement();
        projectEntitlement.setGroup(group);
        projectEntitlement.setProjectRef(projectRef);

        AccessLevel accessLevel = new AccessLevel();
        accessLevel.setAccountLicenseType(AccountLicenseType.EXPRESS.name());

        GraphUser graphUser = new GraphUser();
        graphUser.setSubjectKind("user");
        graphUser.setPrincipalName("test@hotmail.com");

        UserEntitlement userEntitlement = new UserEntitlement();
        userEntitlement.setProjectEntitlements(List.of(projectEntitlement));
        userEntitlement.setAccessLevel(accessLevel);
        userEntitlement.setUser(graphUser);

        client.memberEntitlementManagement().userEntitlements().add(userEntitlement);

        // delete an user entitlement
        String userId = client
                .memberEntitlementManagement()
                .userEntitlements()
                .search()
                .getUsers()
                .stream()
                .findFirst()
                .get()
                .getId();

        client.memberEntitlementManagement().userEntitlements().delete(userId);

        // get a user with user id
        client.memberEntitlementManagement().userEntitlements().get(userId);

        // list the groups
        client.memberEntitlementManagement().groupEntitlements().list();

        // get members of a group
        var groups = client.graph().groups().list();

        String groupId = groups
                .getGraphGroups()
                .stream()
                .filter(x -> x.getDisplayName().equals("Readers"))
                .findFirst()
                .get()
                .getOriginId();

        client.memberEntitlementManagement().groupEntitlements().get(groupId);

        // get user entitlement summary
        client.memberEntitlementManagement().userEntitlementSummary().get("AccessLevels", "Projects", "Licenses", "Groups");
    }
}
```