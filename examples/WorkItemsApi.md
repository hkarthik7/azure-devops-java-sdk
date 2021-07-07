# Workitems

- [REST API](https://docs.microsoft.com/en-us/rest/api/azure/devops/wit/work%20items/create?view=azure-devops-rest-6.1)
- API Version: 6.1-preview.3

## Example

Before getting started you require personal access token to authenticate with **Azure DevOps** services REST API.
You can grab one by following the [documentation](https://docs.microsoft.com/en-us/azure/devops/organizations/accounts/use-personal-access-tokens-to-authenticate?WT.mc_id=docs-github-dbrown&view=azure-devops&tabs=preview-page).

You are required to create a connection object before calling Workitem tracking Api.

```java
public class Main {
    public static void main(String[] args) {
        String organisation = "myOrganisationName";
        String project = "myProject";
        String personalAccessToken = "accessToken";

        // Create a connection object with organisation name, project and personal access token.
        var connection = new Connection(organisation, project, personalAccessToken);

        // call API with default connection object;
        WorkitemsApi wit = new WorkitemsApi(connection);
        try {
            // create a new workitem
            wit.createWorkItem("user story", WorkItemOperation.ADD, "Sample user story");

            // delete a workitem
            wit.deleteWorkItem(21);

            // permanently delete a workitem
            wit.deleteWorkItem(11, true);

            // get a workitem with all fields expanded
            wit.getWorkItem(21, WorkItemExpand.ALL);

            // get a list of workitem
            wit.getWorkItems(new int[]{1,2,3});

            // get a workitem revisions
            wit.getWorkItemRevisions(23);

            // get a revision of workitem with revision number;
            wit.getWorkItemRevision(21, 1);
        } catch (AzDException | ConnectionException e) {
            e.printStackTrace();
        }
    }
}
```