# Security

- [SECURITY - REST API](https://docs.microsoft.com/en-us/rest/api/azure/devops/security/?view=azure-devops-rest-7.1)
- [IDENTITY - REST API](https://docs.microsoft.com/en-us/rest/api/azure/devops/ims/?view=azure-devops-rest-7.1)
- API Version: 7.1

## Example

Before getting started you require personal access token to authenticate with **Azure DevOps** services REST API.
You can grab one by following the [documentation](https://docs.microsoft.com/en-us/azure/devops/organizations/accounts/use-personal-access-tokens-to-authenticate?WT.mc_id=docs-github-dbrown&view=azure-devops&tabs=preview-page).

You are required to create a connection object before calling Security Api.

```java
public class Main {
    public static void main(String[] args) {
        String organisation = "myOrganisationName";
        String project = "myProject";
        String personalAccessToken = "accessToken";

        // Connect Azure DevOps API with organisation name and personal access token.
        var webApi = new AzDClientApi(organisation, project, personalAccessToken);

        // call the respective API with created webApi client connection object;
        var security = webApi.getSecurityApi();
        try {
            // list namespaces
            security.getNamespaces();

            // get a specific security namespace
            var ns = security.getNamespace(SecurityToken.Scope.ReleaseManagement.getNamespace());

            // print permissionable actions associated with a namespace and the associated bit
            for (SecurityNamespaceAction action : ns.getActions()) {
                System.out.println("Action: " + action.getDisplayName() + " = " + action.getBit());
            }

            // get the descriptor for a user
            //   see GraphApi.md to get user
            //   GraphUser user = graphApi.getUser(...)
            var identities = security.getIdentitiesFromSubjectDescriptors(user.getDescriptor());
            var securityDescriptor = identities.getIdentities().get(0).getDescriptor();

            // generate a resource security identifier token
            var resourceToken = SecurityToken.generate(SecurityToken.Scope.GIT,
                    Map.of("PROJECT_ID", "05d37331-f4e4-4c55-9830-37c64e50346d",
                            "REPO_ID", "da9108b8-4ed4-41db-a44f-8a428a355772"
                    ));

            // get access control lists for above user and resource
            // boolean fields are 'includeExtendedInfo' and 'recurse'
            security.getAccessControlLists(SecurityToken.Scope.GIT.getNamespace(),
                    new String[]{securityDescriptor},
                    resourceToken,
                    false,
                    false
            );

            // remove access control entries found above
            security.removeAccessControlEntries(SecurityToken.Scope.GIT.getNamespace(),
                    new String[]{securityDescriptor},
                    new String[]{resourceToken}
            );

            // set access control entries
            // create access control entry objects with bitmask allow/deny permissioning (not included implies inherited)
            var entries = new ACEs();
            entries.setToken(resourceToken);
            entries.setMerge(false); // replace or merge with existing in scope entries
            var entry = new ACE();
            entry.setDescriptor(securityDescriptor);
            entry.setAllow(133); // bitmask corresponding to namespace actions identified above. i.e. 133=128+4+1
            entry.setDeny(10);
            entries.setAccessControlEntries(List.of(entry));

            // apply ACEs
            security.setAccessControlEntries(SecurityToken.Scope.Build.getNamespace(), entries);
            
        } catch (AzDException e) {
            e.printStackTrace();
        }
    }
}
```