# Git

- [REST API](https://learn.microsoft.com/en-us/rest/api/azure/devops/git/?view=azure-devops-rest-7.1)
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

        // create a new repository
        TeamProjectReference projectReference = new TeamProjectReference();
        projectReference.setId("projectId");

        RepositoryRequest repositoryRequest = new RepositoryRequest();
        repositoryRequest.name = "repositoryName";
        repositoryRequest.project = projectReference;

        client.git().repositories().create(repositoryRequest);

        // delete a repository
        client.git().repositories().delete("repositoryId");

        // permanently delete a repository from recycle bin
        client.git().repositories().recycleBin().delete("repositoryId");

        // get a list of all repositories
        client.git().repositories().list();

        // get a repository by name
        client.git().repositories().get("repositoryName");

        // restore the repository
        client.git().repositories().recycleBin().restore("repositoryId", false);

        // update a repository; rename a repository by branch. Just pass the branch name as main/develop;
        GitRepository gitRepository = client.git().repositories().get("repositoryName");
        gitRepository.setDefaultBranch("branchName");
        
        client.git().repositories().update("repositoryId", gitRepository);

        // lock a branch
        client.git().refs().update("my-repo", "master", true);

        // unlock a branch
        client.git().refs().update("my-repo", "master", false);

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
        gitPullRequest.setRepository(client.git().repositories().get("testRepository"));

        client.git().pullRequests().create("repositoryId", gitPullRequest, false);

        // Add a reviewer to the pull request and optionally make them as required
        IdentityRefWithVote identityRefWithVote = new IdentityRefWithVote();
        identityRefWithVote.setIsRequired(true);
        identityRefWithVote.setVote(0);

        client.git().pullRequest().reviewers().create(1772, "repositoryId", "reviewerId", identityRefWithVote);

        // Update a pull request
        // The editable fields are isFlagged and hasDeclined. This means we can either flag a pull request or decline it.
        // Please note that the creator cannot decline their own pull request.
        IdentityRefWithVote identityRefWithVote = new IdentityRefWithVote();
        identityRefWithVote.setHasDeclined(true);

        int pullRequestId = 1772;
        client.git().pullRequest().reviewers().update(pullRequestId, "repositoryId", "reviewerId", identityRefWithVote);

        // get a pull request reviewer by id
        client.git().pullRequest().reviewers().get(pullRequestId, "repositoryId", "reviewerId");

        // get all reviewers in a pull request
        client.git().pullRequest().reviewers().list(pullRequestId, "repositoryId");

        // delete a pull request reviewer
        client.git().pullRequest().reviewers().delete(pullRequestId, "repositoryId", "reviewerId");

        // get refs in a repository
        client.git().refs().list("testRepository");

        // get a ref with filter
        client.git().refs().list("testRepository", r -> r.queryParameters.filter = "heads/main");

        // create test2 branch in testRepository based on oldObjectID(SHA1) 
        GitRefUpdate gitRefUpdate = new GitRefUpdate();
        gitRefUpdate.setNewObjectId("newObjectId");
        gitRefUpdate.setOldObjectId("oldObjectId");
        gitRefUpdate.setName("refs/heads/test2");

        client.git().refs().update("repositoryName", List.of(gitRefUpdate));

        // Get all items from the repository
        client.git().items().list("repository-name").getItems();

        client.git().items()
                .list("repositoryName", r -> r.queryParameters.recursionLevel = VersionControlRecursionType.FULL)
                .getItems();

        // Get all items with optional parameters
        client.git().items().list("repositoryName", r ->
        {
            r.queryParameters.recursionLevel = VersionControlRecursionType.FULL;
            r.queryParameters.sanitize = false;
            r.queryParameters.includeContent = true;
            r.queryParameters.includeContentMetadata = true;
            r.queryParameters.scopePath = "/docs";
        });

        // Get a blob with sha1 of the blob object id
        // Get the sha1 of blob object id from getItems() methods. You should only pass the object id of blob type.
        var repoId = client.git().repositories().get("testRepository").getId();
        var items = client.git().items().list(repoId, r -> r.queryParameters.recursionLevel = VersionControlRecursionType.FULL).getItems();
        var sha1 = items.stream()
                .filter(x -> x.getGitObjectType() == GitObjectType.BLOB && x.getPath().equals("/Test.txt"))
                .map(GitItem::getObjectId)
                .findFirst()
                .get();

        client.git().blobs().get(repoId, sha1, r ->
        {
            r.queryParameters.fileName = "test.txt";
            r.queryParameters.resolveLfs = false;
        });

        // Get blob content
        client.git().blobs().get(repoId, sha1, r ->
        {
            r.queryParameters.fileName = "test.txt";
            r.queryParameters.resolveLfs = false;
            r.queryParameters.download = true;
        });

        // Download blob in a zip file
        var res = client.git().blobs().get(repoId, sha1, r ->
        {
            r.queryParameters.fileName = "test.txt";
            r.queryParameters.resolveLfs = false;
            r.queryParameters.download = true;
            r.queryParameters.format = GitBlobRefFormat.ZIP;
        });
        StreamHelper.download("blob.zip", res);

        // Download a list of blobs in as a zip file
        var repoId = client.git().repositories().get("testRepository").getId();
        var items = client.git().items().list(repoId, r -> r.queryParameters.recursionLevel = VersionControlRecursionType.FULL).getItems();
        var sha1 = items.stream()
                .filter(x -> x.getGitObjectType() == GitObjectType.BLOB)
                .map(GitItem::getObjectId)
                .collect(Collectors.toList());

        var res = client.git().blobs().getAsZip(repoId, sha1);

        StreamHelper.download("blobs.zip", res);

        // Create Fork of a repository
        // 1 Create empty repository with ForkRequest
        TeamProjectReference projectReference = new TeamProjectReference();
        projectReference.setId("projectId");

        RepositoryRequest repositoryRequest = new RepositoryRequest();
        repositoryRequest.name = "repositoryName";
        repositoryRequest.project = projectReference;
        
        var repoId = client.git().repositories().create(repositoryRequest).getId(); // Create empty repository
        GitForkSyncRequest gitforksyncRequest = client.helpers().git()
                .createForkSyncRequest(repoId, "sourceCollectionId", "sourceProjectId", "sourceRepositoryId"); // Create Fork SyncRequest
        //Check Fork SyncRequest Status(Optional)
        if(client.helpers().git().getForkSyncRequest(repoId, gitforksyncRequest.getOperationId(), true).getStatus() == GitAsyncOperationStatus.COMPLETED){
            return true;
        }

        // 2 Using createForkRepository method
        var repoId = git.createForkRepository("testRepository", "projectId", "parentProjectId", "parentRepositoryId").getId();
        //Check Fork SyncRequest Status(Optional)
        var operationId = git.getForkSyncRequests("testRepository",true,false).getForkSyncRequest().get(0).getOperationId();
        if(client.helpers().git().getForkSyncRequest(repoId, operationId, true).getStatus() == GitAsyncOperationStatus.COMPLETED){
            return true;
        }

        // 3 Using createForkRepositoryWithComplete method
        var repoId = client.helpers().git()
                .createForkRepositoryWithComplete("testRepository", "projectId", "parentProjectId", "parentRepositoryId","main", checkTimes);

        // Get All Fork Repositories
        client.git().forks().list("testRepository","collectionId", r -> r.queryParameters.includeLinks = true);        
    }
}
```