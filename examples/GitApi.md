# Git

- [REST API](https://docs.microsoft.com/en-us/rest/api/azure/devops/git/?view=azure-devops-rest-6.1)
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

        // Create a connection object with organisation name, project and personal access token.
        var connection = new Connection(organisation, project, personalAccessToken);

        // call API with default connection object;
        GitApi git = new GitApi(defaultParameters);
        try {
            // create a new repository
            git.createRepository("repositoryName", "projectId");

            // delete a repository
            git.deleteRepository("repositoryId");

            // permanently delete a repository from recycle bin
            git.deleteRepositoryFromRecycleBin("repositoryId");

            // get a list of all repositories
            git.getRepositories();

            // get a repository by name
            git.getRepository("repositoryName");

            // restore the repository
            git.restoreRepositoryFromRecycleBin("repositoryId", false);

            // update a repository; rename a repository by branch. Just pass the branch name as main/develop;
            git.updateRepository("repositoryId", "repositoryName", "defaultBranchName");
        } catch (AzDException | DefaultParametersException e) {
            e.printStackTrace();
        }
    }
}
```