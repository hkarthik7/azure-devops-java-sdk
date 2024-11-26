# Git

- [REST API](https://docs.microsoft.com/en-us/rest/api/azure/devops/git/?view=azure-devops-rest-6.1)
- API Version: 6.1

## Example

Before getting started you require personal access token to authenticate to **Azure DevOps** services REST API.
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
            git.updateBranchLock("my-repo", "master", true);
            
            // unlock a branch
            git.updateBranchLock("my-repo", "master", false);
            
            // create a pull request and optionally make it as draft.
            var repoId = git.getRepository("my-repository").getId();
            // pass the repository id, source reference branch, target reference branch, title, description and set the isDraft to true to create
            // the pull request in draft state. If it is set to false the pull request will be published.
            git.createPullRequest(repoId,"develop", "master", "New feature", "Adding new feature", true);
            
            // Create a pull request from pull request object.
            var gitPullRequest = new GitPullRequest();

            var tag = new WebApiTagDefinition();
            tag.setName("Production");

            var wit = webApi.getWorkItemTrackingApi();
            var workItem = wit.getWorkItem(1649);
            var witRefs = new ResourceRef();
            witRefs.setId(String.valueOf(workItem.getId()));
            witRefs.setUrl(workItem.getUrl());

            gitPullRequest.setTitle("This is a test PR created to merge the edited text file.");
            gitPullRequest.setDescription("This is a test PR created to merge the edited text file.");
            gitPullRequest.setIsDraft(true);
            gitPullRequest.setLabels(List.of(tag));
            gitPullRequest.setTargetRefName("develop");
            gitPullRequest.setSourceRefName("test");
            gitPullRequest.setWorkItemRefs(List.of(witRefs));
            gitPullRequest.setRepository(g.getRepository("testRepository"));

            git.createPullRequest(gitPullRequest);
            
            // Add a reviewer to the pull request and optionally make them as required
            git.createPullRequestReviewer("pull-request-id", "repository-name", "reviewer-id", 0, true);
            
            // Update a pull request
            // The editable fields are isFlagged and hasDeclined. This means you can either flag a pull request or decline it.
            // Please note that you cannot decline your own pull request.
            git.updatePullRequestReviewer("pull-request-id", "repository-name", "reviewer-id", true, false);
            
            // get a pull request reviewer by id
            git.getPullRequestReviewer("pull-request-id", "repository-name", "reviewer-id");
            
            // get all reviewers in a pull request
            git.getPullRequestReviewers("pull-request-id", "repository-name");
            
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
            git.deletePullRequestReviewer("pull-request-id", "repository-name", "reviewer-id");
            
            // Get all items from the repository
            git.getItems("repository-name").getItems();
                    
            git.getItems("repository-name", VersionControlRecursionType.FULL).getItems();
            
            // Get all items with optional parameters
            //
            // Include content metadata: true
            // include links: true
            // latest processed change: false
            // Version control recursion type to navigate through the path
            // Path of the files in git repository
            git.getItems("repository-name", true, true, false,
                    VersionControlRecursionType.ONE_LEVEL_PLUS_NESTED_EMPTY_FOLDERS, "/docs").getItems();
            
            // Get a blob with sha1 of the blob object id
            // Get the sha1 of blob object id from getItems() methods. You should only pass the object id of blob type.
            var repoId = git.getRepository("testRepository").getId();
            var items = git.getItems(repoId, VersionControlRecursionType.FULL).getItems();
            var sha1 = items.stream()
                    .filter(x -> x.getGitObjectType() == GitObjectType.BLOB && x.getPath().equals("/Test.txt"))
                    .map(GitItem::getObjectId)
                    .findFirst()
                    .get();

            git.getBlob(repoId, sha1, "test.txt", false);
            
            // Get blob content
            git.getBlobContent(repoId, sha1, true, "test.txt", false);
            
            // Download blob in a zip file
            var res = git.getBlobContentAsZip(repoId, sha1, true, "test.txt", false);
            StreamHelper.download("blob.zip", res);
            
            // Download a list of blobs in as a zip file
            var repoId = g.getRepository("testRepository").getId();
            var items = g.getItems(repoId, VersionControlRecursionType.FULL).getItems();
            var sha1 = items.stream()
                    .filter(x -> x.getGitObjectType() == GitObjectType.BLOB)
                    .map(GitItem::getObjectId)
                    .collect(Collectors.toList());
            
            var res = git.getBlobsZip(repoId, sha1);
            
            StreamHelper.download("blobs.zip", res);

            // Create Fork of a repository
            // 1 Create empty repository with ForkRequest
            var repoId = git.createRepository("testRepository").getId(); // Create empty repository
            GitForkSyncRequest gitforksyncRequest = git.createForkSyncRequest(repoId, "sourceCollectionId", "sourceProjectId", "sourceRepositoryId"); Create Fork SyncRequest
            //Check Fork SyncRequest Status(Optional)
            if(git.getForkSyncRequest(repoId, gitforksyncRequest.getOperationId(), true).getStatus() == GitAsyncOperationStatus.COMPLETED){ 
                return true;
            }

            // 2 Using createForkRepository method
            var repoId = git.createForkRepository("testRepository", "projectId", "parentProjectId", "parentRepositoryId").getId();
            //Check Fork SyncRequest Status(Optional)
            var operationId = git.getForkSyncRequests("testRepository",true,false).getForkSyncRequest().get(0).getOperationId();
            if(git.getForkSyncRequest(repoId, operationId, true).getStatus() == GitAsyncOperationStatus.COMPLETED){ 
                return true;
            }

            // 3 Using createForkRepositoryWithComplete method
            var repoId = git.createForkRepositoryWithComplete("testRepository", "projectId", "parentProjectId", "parentRepositoryId","main", checkTimes);

            // Get All Fork Repositories
            var GitRepositoryRefs = git.getForks("testRepository","collectionId", true);

            
        } catch (AzDException e) {
            e.printStackTrace();
        }
    }
}
```