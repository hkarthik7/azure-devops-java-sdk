# Graph

- [REST API](https://docs.microsoft.com/en-us/rest/api/azure/devops/graph/?view=azure-devops-rest-6.1)
- API Version: 6.1

## Example

Before getting started you require personal access token to authenticate with **Azure DevOps** services REST API.
You can grab one by following the [documentation](https://docs.microsoft.com/en-us/azure/devops/organizations/accounts/use-personal-access-tokens-to-authenticate?WT.mc_id=docs-github-dbrown&view=azure-devops&tabs=preview-page).

You are required to create a connection object before calling Graph Api.

```java
public class Main {
    public static void main(String[] args) {
        String organisation = "myOrganisationName";
        String project = "myProject";
        String personalAccessToken = "accessToken";

        // Connect Azure DevOps API with organisation name and personal access token.
        var webApi = new AzDClientApi(organisation, project, personalAccessToken);

        // call the respective API with created webApi client connection object;
        var graph = webApi.getGraphApi();
        try {
            // create a new user with the reference of another existing user
            var users = graph.getUsers().getUsers();
            var userDescriptor = users
                    .stream()
                    .filter(x -> x.getDisplayName().equals("test@xmail.com"))
                    .findFirst()
                    .get()
                    .getDescriptor();

            graph.createUser("newUser@hotmail.com", userDescriptor);

            // add user to the group
            var groups = graph.getGroups().getGraphGroups();
            var groupDescriptor = groups
                    .stream()
                    .filter(x -> x.getDisplayName().equals("Readers"))
                    .findFirst()
                    .get()
                    .getDescriptor();

            graph.addUserToGroup("newUser@hotmail.com", groupDescriptor);

            // get a list of users
            graph.getUsers();

            // get a list of groups
            graph.getGroups();

            // get a list of other users in the group
            var groupMembers = graph.getGroupMembersOf(groupDescriptor);
            
            // get a list of other groups the user is a member of
            var groups = graph.getMemberOfGroups(userDescriptor);
            
            // create a new group
            graph.createGroup("ReadersPlus", "A group containing both readers and additional privileges");
            
            // delete a user by user descriptor
            graph.deleteUser(userDescriptor);
        } catch (AzDException e) {
            e.printStackTrace();
        }
    }
}
```