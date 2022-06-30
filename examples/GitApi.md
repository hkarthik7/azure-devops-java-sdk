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
            
            // Add a reviewer to the pull request and optionally make them as required
            g.createPullRequestReviewer("pull-request-id", "repository-name", "reviewer-id", 0, true);
            
            // Update a pull request
            // The editable fields are isFlagged and hasDeclined. This means you can either flag a pull request or decline it.
            // Please note that you cannot decline your own pull request.
            g.updatePullRequestReviewer("pull-request-id", "repository-name", "reviewer-id", true, false);
            
            // get a pull request reviewer by id
            g.getPullRequestReviewer("pull-request-id", "repository-name", "reviewer-id");
            
            // get all reviewers in a pull request
            g.getPullRequestReviewers("pull-request-id", "repository-name");
            
            // delete a pull request reviewer
            g.deletePullRequestReviewer("pull-request-id", "repository-name", "reviewer-id");

            // get refs in a repository
            g.getRefs("testRepository");

            // get a ref with filter
            g.getRef("testRepository", "heads/main");

            // create test2 branch in testRepository based on oldObjectID(SHA1) 
            g.updateRefs("testRepository","refs/heads/test2", "oldObjectID", "newObjectID");

            // create Tag in testRepository based on main branch
            g.createTag("testRepository", "createTestTag", "main");
            
            // create Tag in testRepository based on Commit SHA1
            g.createTag("testRepository", "createTestTag", "86e74e806a3d4b35580563782292e6ab87edee1a");

            // delete a tag
            g.deleteTag("testRepository", "createTestTag");
        } catch (AzDException e) {
            e.printStackTrace();
        }
    }
}
```