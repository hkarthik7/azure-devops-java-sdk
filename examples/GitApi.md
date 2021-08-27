# Git

- [REST API](https://docs.microsoft.com/en-us/rest/api/azure/devops/git/?view=azure-devops-rest-6.1)
- API Version: 6.1

## Example

Before getting started you require personal access token to authenticate with **Azure DevOps** services REST API.
You can grab one by following the [documentation](https://docs.microsoft.com/en-us/azure/devops/organizations/accounts/use-personal-access-tokens-to-authenticate?WT.mc_id=docs-github-dbrown&view=azure-devops&tabs=preview-page).

You are required to create a connection object before calling Git Api.

```java
public class Main {
    public static void main(String[] args) {
        String organisation = "myOrganisationName";
        String project = "myProject";
        String personalAccessToken = "accessToken";

        // Connect Azure DevOps API with organisation name and personal access token.
        var webApi = new AzDClientApi(organisation, project, personalAccessToken);

        // call the respective API with created webApi client connection object;
        var git = webApi.getGitApi();
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
            
            // lock a branch
            g.updateBranchLock("my-repo", "master", true);
            
            // unlock a branch
            g.updateBranchLock("my-repo", "master", false);
            
            // create a pull request and optionally make it as draft.
            var repoId = g.getRepository("my-repository").getId();
            // pass the repository id, source reference branch, target reference branch, title, description and set the isDraft to true to create
            // the pull request in draft state. If it is set to false the pull request will be published.
            g.createPullRequest(repoId,"develop", "master", "New feature", "Adding new feature", true);
        } catch (AzDException | ConnectionException e) {
            e.printStackTrace();
        }
    }
}
```