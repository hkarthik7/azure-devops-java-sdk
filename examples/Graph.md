# Graph

- [REST API](https://learn.microsoft.com/en-us/rest/api/azure/devops/graph/?view=azure-devops-rest-7.1)
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
        
        // List users
        List<GraphUser> users = client.graph().users().list().getUsers();
        
        // Get user descriptor
        String userDescriptor = users
                .stream()
                .filter(x -> x.getDisplayName().equals("test@xmail.com"))
                .findFirst()
                .get()
                .getDescriptor();

        // OR
        String userDescriptor = client.locations().getConnectionData().getAuthenticatedUser().getDescriptor();

        // create a new user by UPN
        GraphUserPrincipalNameCreationContext user = new GraphUserPrincipalNameCreationContext();
        user.principalName = "newUser@hotmail.com";

        client.graph().users().create(user);

        // add user to the group
        List<GraphGroup> groups = client.graph().groups().list();
        String groupDescriptor = groups
                .stream()
                .filter(x -> x.getDisplayName().equals("Readers"))
                .findFirst()
                .get()
                .getDescriptor();

        client.graph().users().create(user, r ->
        {
            r.queryParameters.groupDescriptors = new String[]{groupDescriptor};
        });

        // get a list of groups
        client.graph().groups().list();

        // get a list of other users in the group
        GraphMemberships groupMembers = client.graph().memberships().list(groupDescriptor, 
                r -> r.queryParameters.direction = GraphTraversalDirection.DOWN);

        // get a list of other groups the user is a member of
        GraphMemberships groups = client.graph().memberships().list(userDescriptor,
                r -> r.queryParameters.direction = GraphTraversalDirection.UP);

        // create a new group
        GraphGroupVstsCreationContext group = new GraphGroupVstsCreationContext();
        group.description = "A group containing both readers and additional privileges";
        group.displayName = "ReadersPlus";

        client.graph().groups().create(group);

        // delete a user by user descriptor
        client.graph().users().delete(userDescriptor);
    }
}
```