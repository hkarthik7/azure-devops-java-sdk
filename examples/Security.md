# Security

- [SECURITY - REST API](https://docs.microsoft.com/en-us/rest/api/azure/devops/security/?view=azure-devops-rest-7.1)
- [IDENTITY - REST API](https://docs.microsoft.com/en-us/rest/api/azure/devops/ims/?view=azure-devops-rest-7.1)
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

        // list namespaces
        client.security().securityNamespaces().query(null, false);

        // get a specific security namespace
        SecurityNamespace namespace = client.security()
                .securityNamespaces()
                .query(SecurityToken.Scope.ReleaseManagement.getNamespace(), false)
                .getSecurityNamespaces()
                .get(0);

        // print permissionable actions associated with a namespace and the associated bit
        for (SecurityNamespaceAction action : namespace.getActions()) {
            System.out.println("Action: " + action.getDisplayName() + " = " + action.getBit());
        }

        // get the descriptor for a user
        GraphUser user = client.graph().users().get(client.locations().getConnectionData().getAuthenticatedUser().getDescriptor());

        client.security().identities().read(r ->
                r.queryParameters.subjectDescriptors = new String[]{user.getDescriptor()});
        var securityDescriptor = identities.getIdentities().get(0).getDescriptor();

        // generate a resource security identifier token
        var resourceToken = SecurityToken.generate(SecurityToken.Scope.GIT,
                Map.of("PROJECT_ID", "05d37331-f4e4-4c55-9830-37c64e50346d",
                        "REPO_ID", "da9108b8-4ed4-41db-a44f-8a428a355772"
                ));

        // get access control lists for above user and resource
        client.security().accessControlLists().query(SecurityToken.Scope.GIT.getNamespace(), r ->
        {
            r.queryParameters.descriptors = new String[]{securityDescriptor};
            r.queryParameters.token = resourceToken;
            r.queryParameters.includeExtendedInfo = false;
            r.queryParameters.recurse = false;
        });

        // remove access control entries found above
        client.security().accessControlEntries().remove(SecurityToken.Scope.GIT.getNamespace(), r ->
        {
            r.queryParameters.descriptors = new String[]{securityDescriptor};
            r.queryParameters.token = resourceToken;
        });

        // set access control entries
        // create access control entry objects with bitmask allow/deny permission (not included implies inherited)
        var entry = new ACE();
        entry.setDescriptor(securityDescriptor);
        entry.setAllow(133); // bitmask corresponding to namespace actions identified above. i.e. 133=128+4+1
        entry.setDeny(10);

        ACEs entries = new ACEs();
        entries.setToken(resourceToken);
        entries.setMerge(false); // replace or merge with existing in scope entries
        entries.setAccessControlEntries(List.of(entry));


        // apply ACEs
        client.security().accessControlEntries().set(SecurityToken.Scope.Build.getNamespace(), entries);        
    }
}
```