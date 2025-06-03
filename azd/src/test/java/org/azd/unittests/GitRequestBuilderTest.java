package org.azd.unittests;

import org.azd.UnitTestConfiguration;
import org.azd.abstractions.InstanceFactory;
import org.azd.abstractions.serializer.SerializerContext;
import org.azd.authentication.PersonalAccessTokenCredential;
import org.azd.common.types.JsonPatchDocument;
import org.azd.enums.*;
import org.azd.exceptions.AzDException;
import org.azd.git.types.*;
import org.azd.helpers.StreamHelper;
import org.azd.helpers.Utils;
import org.azd.legacy.MockParameters;
import org.azd.pipelines.types.PipelinePermission;
import org.azd.pipelines.types.Resource;
import org.azd.pipelines.types.ResourcePipelinePermission;
import org.azd.serviceclient.AzDService;
import org.azd.serviceclient.AzDServiceClient;
import org.azd.wiki.types.GitVersionDescriptor;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class GitRequestBuilderTest {
    private static final SerializerContext serializer = InstanceFactory.createSerializerContext();
    private static AzDServiceClient client;
    private static UnitTestConfiguration testConfiguration;

    @Before
    public void init() throws AzDException {
        String dir = System.getProperty("user.dir");
        var file = new File(dir + "/src/test/java/org/azd/_unitTest.json");
        var configFile = new File(dir + "/src/test/java/org/azd/config.json");
        var m = serializer.deserialize(file, MockParameters.class);
        testConfiguration = serializer.deserialize(configFile, UnitTestConfiguration.class);
        String organization = m.getO();
        String token = m.getT();
        String project = m.getP();
        var pat = new PersonalAccessTokenCredential(Instance.BASE_INSTANCE.append(organization), project, token);
        client = AzDService.builder()
                .authentication(pat)
                .buildClient();
    }

    @Test(expected = AzDException.class)
    public void shouldCreateANewRepository() throws AzDException {
        var repoRequest = new RepositoryRequest();
        var project = new TeamProjectReference();
        project.setId("00000000-0000-0000-0000-000000000000");

        repoRequest.name = testConfiguration.properties.git.repositoryName;
        repoRequest.project = project;

        client.git().repositories().create(repoRequest);
    }

    @Test(expected = AzDException.class)
    public void shouldDeleteRepository() throws AzDException {
        client.git().repositories().delete("00000000-0000-0000-0000-000000000000");
    }

    @Test(expected = AzDException.class)
    public void shouldDeleteRepositoryFromRecycleBin() throws AzDException {
        client.git().repositories().recycleBin().delete("00000000-0000-0000-0000-000000000000");
    }

    @Test
    public void shouldGetDeletedGitRepositories() throws AzDException {
        client.git().repositories().listDeleted();
    }

    @Test
    public void shouldGetRecycleBinRepositories() throws AzDException {
        client.git().repositories().recycleBin().list();
    }

    @Test
    public void shouldGetRepository() throws AzDException {
        client.git().repositories().get(testConfiguration.properties.git.repositoryName);
    }

    @Test
    public void shouldGetGitPolicyConfigurations() throws AzDException {
        var repo = client.git().repositories().get(testConfiguration.properties.git.repositoryName);
        client.git().policyConfigurations().get(repo.getId(), r -> {
            r.queryParameters.top = 10;
        });
    }

    @Test
    public void shouldGetRepositories() throws AzDException {
        client.git().repositories().list();
    }

    @Test
    public void shouldGetHiddenRepositories() throws AzDException {
        client.git().repositories().list(r -> r.queryParameters.includeHidden = true);
    }

    @Test
    public void shouldGetRepositoriesWithLinksAndUrls() throws AzDException {
        client.git().repositories().list(r -> {
            r.queryParameters.includeAllUrls = true;
            r.queryParameters.includeLinks = true;
        });
    }

    @Test
    public void shouldGetRepositoriesForGivenQueryParameters() throws AzDException {
        client.git().repositories().list(r -> {
            r.queryParameters.includeAllUrls = true;
            r.queryParameters.includeLinks = true;
            r.queryParameters.includeHidden = true;
        }).getRepositories().get(0).getValidRemoteUrls();
    }

    @Test(expected = AzDException.class)
    public void shouldRestoreRepositoryFromRecycleBin() throws AzDException {
        client.git().repositories().recycleBin().restore("00000000-0000-0000-0000-000000000000", false);
    }

    @Test
    public void shouldUpdateRepository() throws AzDException {
        var repo = client.git().repositories().get("newRepo");
        repo.setDefaultBranch("refs/heads/main");

        client.git().repositories().update(repo.getId(), repo);
    }

    @Test(expected = AzDException.class)
    public void shouldCreateANewPullRequest() throws AzDException {
        var repoId = client.git().repositories().list().getRepositories().stream().findFirst().get().getId();
        var reviewer = new IdentityRefWithVote();
        reviewer.setId(client.locations().getConnectionData().getAuthenticatedUser().getId());

        var gitPullRequest = new GitPullRequest();
        gitPullRequest.setSourceRefName("refs/heads/develop");
        gitPullRequest.setTargetRefName("refs/heads/master");
        gitPullRequest.setTitle("New feature");
        gitPullRequest.setDescription("Adding new feature");
        gitPullRequest.setReviewers(List.of(reviewer));

        client.git().pullRequests().create(repoId, gitPullRequest, false);
    }

    // failing the test intentionally. If not this will create many pull
    // requests on each run.
    // To pass the test remove (expected = AzDException.class) and replace
    // targetRefName: master with main.
    @Test(expected = AzDException.class)
    public void shouldCreateANewPullRequestAsDraft() throws AzDException {
        var repoId = client.git().repositories().get(testConfiguration.properties.git.repositoryName).getId();

        var gitPullRequest = new GitPullRequest();
        gitPullRequest.setSourceRefName("refs/heads/develop");
        gitPullRequest.setTargetRefName("refs/heads/master");
        gitPullRequest.setTitle("New feature");
        gitPullRequest.setDescription("Adding new feature");
        gitPullRequest.setIsDraft(true);

        client.git().pullRequests().create(repoId, gitPullRequest, false);
    }

    @Test
    public void shouldRetrieveAPullRequest() throws AzDException {
        var pr = client.git().pullRequests().list(testConfiguration.properties.git.repositoryName)
                .getPullRequests()
                .get(0)
                .getPullRequestId();

        client.git().pullRequests().get(testConfiguration.properties.git.repositoryName, pr);
    }

    @Test
    public void shouldRetrieveAPullRequestById() throws AzDException {
        var pr = client.git().pullRequests().list(testConfiguration.properties.git.repositoryName)
                .getPullRequests()
                .get(0)
                .getPullRequestId();
        client.git().pullRequests().getById(pr);
    }

    @Test
    public void shouldRetrieveAllPullRequestsFromARepository() throws AzDException {
        client.git().pullRequests().list(testConfiguration.properties.git.repositoryName);
    }

    @Test
    public void shouldGetPullRequestsByProject() throws AzDException {
        client.git().pullRequests().list().getPullRequests();
    }

    @Test
    public void shouldGetTopTenPullRequestsByProject() throws AzDException {
        client.git().pullRequests().list(r -> r.queryParameters.top = 10);
    }

    @Test
    public void shouldGetPullRequestsByProjectWithCompletedStatus() throws AzDException {
        client.git().pullRequests().list(r -> r.queryParameters.status = PullRequestStatus.COMPLETED);
    }

    @Test
    public void shouldGetBranch() throws AzDException {
        var branch = client.git().refs().list(testConfiguration.properties.git.repositoryName)
                .getRefs()
                .get(0)
                .getName();
        client.git().refs().list(testConfiguration.properties.git.repositoryName, r -> {
            r.queryParameters.filter = branch;
        });
    }

    @Test
    public void shouldGetBranches() throws AzDException {
        client.git().refs().list(testConfiguration.properties.git.repositoryName);
    }

    @Test
    public void shouldLockABranch() throws AzDException {
        client.git().refs().update(testConfiguration.properties.git.repositoryName,
                testConfiguration.properties.git.branchName, true);
    }

    @Test
    public void shouldUnLockABranch() throws AzDException {
        client.git().refs().update(testConfiguration.properties.git.repositoryName,
                testConfiguration.properties.git.branchName, false);
    }

    @Test
    public void shouldGetPullRequestWorkItems() throws AzDException {
        var pr = client.git().pullRequests().list(testConfiguration.properties.git.repositoryName)
                .getPullRequests()
                .get(0);

        client.git().pullRequest().workItems().list(pr.getPullRequestId(), pr.getRepository().getName());
    }

    @Test
    public void shouldCreateAPullRequestLabel() throws AzDException {
        var pr = client.git().pullRequests().list(testConfiguration.properties.git.repositoryName)
                .getPullRequests()
                .get(0);

        client.git().pullRequest().labels().create(pr.getRepository().getName(),
                pr.getPullRequestId(), "DevOps");
    }

    @Test
    public void shouldGetAPullRequestLabel() throws AzDException {
        var pr = client.git().pullRequests().list(testConfiguration.properties.git.repositoryName)
                .getPullRequests()
                .get(0);

        var prLabel = client.git().pullRequest().labels().list(pr.getRepository().getName(),
                        pr.getPullRequestId())
                .getValue()
                .get(0)
                .getName();

        client.git().pullRequest().labels().get(pr.getRepository().getName(), pr.getPullRequestId(), prLabel);
    }

    @Test
    public void shouldGetPullRequestLabels() throws AzDException {
        var pr = client.git().pullRequests().list(testConfiguration.properties.git.repositoryName)
                .getPullRequests()
                .get(0);

        client.git().pullRequest().labels().list(pr.getRepository().getName(), pr.getPullRequestId());
    }

    @Test
    public void shouldDeleteAPullRequestLabels() {
        try {
            var pr = client.git().pullRequests().list(testConfiguration.properties.git.repositoryName)
                    .getPullRequests()
                    .get(0);

            var label = client.git().pullRequest().labels().list(pr.getRepository().getName(),
                            pr.getPullRequestId())
                    .getValue()
                    .get(0);

            if (Utils.isNullOrEmpty(label.getUrl()))
                client.git().pullRequest().labels().create(pr.getRepository().getName(), pr.getPullRequestId(), "DevOps");

            client.git().pullRequest().labels().delete(pr.getRepository().getName(), pr.getPullRequestId(), "DevOps");
        } catch (AzDException ignored) {
        }
    }

    @Test
    public void shouldCreateAPullRequestReviewer() throws AzDException {
        var pr = client.git().pullRequests().list(testConfiguration.properties.git.repositoryName)
                .getPullRequests()
                .get(0);

        var reviewer = new IdentityRefWithVote();
        reviewer.setId(client.locations().getConnectionData().getAuthenticatedUser().getId());

        client.git().pullRequest().reviewers().create(pr.getPullRequestId(),
                pr.getRepository().getId(), reviewer);
    }

    @Test(expected = AzDException.class)
    public void shouldDeleteAPullRequestReviewer() throws AzDException {
        client.git().pullRequest().reviewers().delete(1, testConfiguration.properties.git.repositoryName, "id");
    }

    @Test
    public void shouldGetAPullRequestReviewer() {
        try {
            var pr = client.git().pullRequests().list(testConfiguration.properties.git.repositoryName)
                    .getPullRequests()
                    .get(0);

            var reviewerId = pr.getReviewers().get(0).getId();

            client.git().pullRequest().reviewers().get(pr.getPullRequestId(), pr.getRepository().getId(), reviewerId);
        } catch (AzDException ignored) {
        }
    }

    @Test
    public void shouldGetPullRequestReviewers() throws AzDException {
        var pr = client.git().pullRequests().list(testConfiguration.properties.git.repositoryName)
                .getPullRequests()
                .get(0);

        client.git().pullRequest().reviewers().list(pr.getPullRequestId(), pr.getRepository().getId());
    }

    @Test
    public void shouldUpdateAPullRequestReviewer() throws AzDException {
        var pr = client.git().pullRequests().list(testConfiguration.properties.git.repositoryName)
                .getPullRequests()
                .get(0);

        var reviewerToUpdate = new IdentityRefWithVote();
        reviewerToUpdate.setVote(0);
        reviewerToUpdate.setId(pr.getReviewers().get(0).getId());

        client.git().pullRequest().reviewers().update(pr.getPullRequestId(), pr.getRepository().getId(), List.of(reviewerToUpdate));
    }

    @Test(expected = AzDException.class)
    public void shouldCreateAnAnnotatedTag() throws AzDException {
        var repoId = client.git().repositories().get(testConfiguration.properties.git.repositoryName).getId();
        var tags = new GitAnnotatedTag();
        var obj = new GitObject();
        obj.setObjectId("83764e57d4b290766046da65b1c7c4afe8b71a92");

        tags.setName("annotatedTestTag");
        tags.setTaggedObject(obj);
        tags.setMessage("Annotated Tag for testing");

        client.git().annotatedTags().create(repoId, tags);
    }

    @Test
    public void shouldGetAnAnnotatedTag() {
        try {
            client.git().annotatedTags().get(testConfiguration.properties.git.repositoryName, "d993d67b34ea8365defbee2945755d5a7d3185f4");
        } catch (AzDException ignored) {
        }
    }

    @Test
    public void shouldGetCommitsFromARepository() throws AzDException {
        client.git().commits().list(testConfiguration.properties.git.repositoryName).getCommits();
    }

    @Test
    public void shouldGetACommitsFromTheRepository() throws AzDException {
        var commitId = client.git().commits().list(testConfiguration.properties.git.repositoryName).getCommits()
                .stream().findFirst().get().getCommitId();
        client.git().commits().get(testConfiguration.properties.git.repositoryName, commitId);
    }

    @Test
    public void shouldGetCommitsBatch() throws AzDException {

        var repoId = client.git().repositories().get(testConfiguration.properties.git.repositoryName).getId();

        var itemVersion = new GitVersionDescriptor();
        itemVersion.version = "test";
        itemVersion.versionOptions = GitVersionOptions.NONE;
        itemVersion.versionType = GitVersionType.BRANCH;

        var compareVersion = new GitVersionDescriptor();
        compareVersion.version = "main";
        compareVersion.versionOptions = GitVersionOptions.NONE;
        compareVersion.versionType = GitVersionType.BRANCH;

        var gitCommitsBatch = new GitCommitsBatch();
        gitCommitsBatch.itemVersion = itemVersion;
        gitCommitsBatch.compareVersion = compareVersion;
        gitCommitsBatch.includeWorkItems = true;

        client.git().commits().listBatch(repoId, gitCommitsBatch);
    }

    @Test
    public void shouldGetRefs() throws AzDException {
        client.git().refs().list(testConfiguration.properties.git.repositoryName);
    }

    @Test
    public void shouldGetRefsWithQueryParameters() throws AzDException {
        client.git().refs().list(testConfiguration.properties.git.repositoryName,
                r -> r.queryParameters.filter = "heads/");
    }

    @Test
    public void shouldUpdateRefs() throws AzDException {
        var ref = new GitRefUpdate();
        ref.setName("refs/heads/test2");
        ref.setOldObjectId("0000000000000000000000000000000000000000");
        ref.setNewObjectId("0000000000000000000000000000000000000000");

        client.git().refs().update(testConfiguration.properties.git.repositoryName, List.of(ref));
    }

    @Test
    public void shouldGetABlob() throws AzDException {
        var repoId = client.git().repositories().get(testConfiguration.properties.git.repositoryName).getId();
        var items = client.git().items().list(repoId, r -> r.queryParameters.recursionLevel = VersionControlRecursionType.FULL).getItems();
        var sha1 = items.stream()
                .filter(x -> x.getGitObjectType() == GitObjectType.BLOB && x.getPath().equals("/Test.txt"))
                .map(GitItem::getObjectId)
                .findFirst()
                .get();

        client.git().blobs().get(repoId, sha1, r -> {
            r.queryParameters.fileName = "test.txt";
            r.queryParameters.resolveLfs = false;
        });
    }

    @Test
    public void shouldGetABlobContentAsZip() throws AzDException {
        var repoId = client.git().repositories().get(testConfiguration.properties.git.repositoryName).getId();
        var items = client.git().items().list(repoId, r -> r.queryParameters.recursionLevel = VersionControlRecursionType.FULL).getItems();
        var sha1 = items.stream()
                .filter(x -> x.getGitObjectType() == GitObjectType.BLOB && x.getPath().equals("/Test.txt"))
                .map(GitItem::getObjectId)
                .findFirst()
                .get();

        var res = client.git().blobs().getAsZip(repoId, List.of(sha1));
        StreamHelper.download("blob.zip", res);
    }

    @Test
    public void shouldGetABlobContentAsStream() throws AzDException {
        var repoId = client.git().repositories().get(testConfiguration.properties.git.repositoryName).getId();
        var items = client.git().items().list(repoId, r -> r.queryParameters.recursionLevel = VersionControlRecursionType.FULL).getItems();
        var sha1 = items.stream()
                .filter(x -> x.getGitObjectType() == GitObjectType.BLOB && x.getPath().equals("/Test.txt"))
                .map(GitItem::getObjectId)
                .findFirst()
                .get();

        var res = client.git().blobs().get(repoId, sha1, r -> {
            r.queryParameters.fileName = "test.txt";
            r.queryParameters.resolveLfs = false;
        });

        StreamHelper.convertToString(res);
    }

    @Test
    public void shouldGetAllItems() throws AzDException {
        var repoId = client.git().repositories().get(testConfiguration.properties.git.repositoryName).getId();
        client.git().items().list(repoId, r -> r.queryParameters.recursionLevel = VersionControlRecursionType.FULL).getItems();
    }

    @Test
    public void shouldGetAllItemsWithQueryParameters() throws AzDException {
        var repoId = client.git().repositories().get(testConfiguration.properties.git.repositoryName).getId();
        client.git().items().list(repoId, r -> {
            r.queryParameters.recursionLevel = VersionControlRecursionType.ONE_LEVEL_PLUS_NESTED_EMPTY_FOLDERS;
            r.queryParameters.resolveLfs = false;
            r.queryParameters.sanitize = true;
            r.queryParameters.scopePath = "/docs";
            r.queryParameters.latestProcessedChange = true;
        }).getItems();
    }

    @Test(expected = AzDException.class)
    public void shouldCreateForkRepository() throws AzDException {
        client.helpers().git().createForkRepository(
                testConfiguration.properties.git.repositoryName,
                "00000000-0000-0000-0000-000000000000",
                "00000000-0000-0000-0000-000000000000",
                "00000000-0000-0000-0000-000000000000");
    }

    @Test(expected = AzDException.class)
    public void shouldCreateForkRepositoryWithComplete() throws AzDException {
        client.helpers().git().createForkRepositoryWithComplete(testConfiguration.properties.git.repositoryName,
                "00000000-0000-0000-0000-000000000000",
                "00000000-0000-0000-0000-000000000000",
                "00000000-0000-0000-0000-000000000000",
                "main", 5);
    }

    @Test
    public void shouldGetForks() throws AzDException {
        client.git().forks().list(testConfiguration.properties.git.repositoryName,
                "00000000-0000-0000-0000-000000000000",
                r -> r.queryParameters.includeLinks = true);
    }

    @Test
    public void shouldGetGitPushes() throws AzDException {
        var repo = client.git().repositories().get(testConfiguration.properties.git.repositoryName);
        client.git().pushes().list(repo.getId());
    }

    @Test
    public void shouldGetGitPullRequestStatuses() throws AzDException {
        var pr = client.git().pullRequests().list(testConfiguration.properties.git.repositoryName)
                .getPullRequests()
                .get(0);

        client.git().pullRequest().statuses().list(testConfiguration.properties.git.repositoryName, pr.getPullRequestId());
    }

    @Test(expected = AzDException.class)
    public void shouldCreateAGitPullRequestStatus() throws AzDException {
        var repo = client.git().repositories().get(testConfiguration.properties.git.repositoryName);
        var pullRequestId = 0;
        var gitPullRequestStatus = new GitStatus();
        gitPullRequestStatus.setContext(new GitStatusContext() {{
            setName("testStatus");
        }});

        client.git().pullRequest().statuses().create(repo.getId(), pullRequestId, gitPullRequestStatus);
    }

    @Test
    public void shouldGetGitPullRequestStatus() throws AzDException {
        var repo = client.git().repositories().get(testConfiguration.properties.git.repositoryName);
        var pr = client.git().pullRequests().list(testConfiguration.properties.git.repositoryName)
                .getPullRequests()
                .get(1)
                .getPullRequestId();
        var status = client.git().pullRequest().statuses().list(testConfiguration.properties.git.repositoryName,
                pr).getStatuses().get(0);

        client.git().pullRequest().statuses().get(repo.getId(), pr, status.getId());
    }

    @Test
    public void shouldDeleteGitPullRequestStatus() throws AzDException {
        var repo = client.git().repositories().get(testConfiguration.properties.git.repositoryName);
        var pullRequestId = client.git().pullRequests().list(testConfiguration.properties.git.repositoryName)
                .getPullRequests()
                .get(0)
                .getPullRequestId();
        // Create a new status
        var gitPullRequestStatus = new GitStatus();
        gitPullRequestStatus.setContext(new GitStatusContext() {{
            setName("testStatus");
        }});
        var newStatus = client.git().pullRequest().statuses().create(repo.getId(), pullRequestId, gitPullRequestStatus);

        // remove
        client.git().pullRequest().statuses().delete(repo.getId(), pullRequestId, newStatus.getId());
    }

    @Test
    public void shouldUpdateGitPullRequestStatus() throws AzDException {
        var repo = client.git().repositories().get(testConfiguration.properties.git.repositoryName);
        var pullRequestId = client.git().pullRequests().list(testConfiguration.properties.git.repositoryName)
                .getPullRequests()
                .get(0)
                .getPullRequestId();
        // Create a new status
        var gitPullRequestStatus = new GitStatus();
        gitPullRequestStatus.setContext(new GitStatusContext() {{
            setName("testStatus");
        }});
        var newStatus = client.git().pullRequest().statuses().create(repo.getId(), pullRequestId, gitPullRequestStatus);

        // update (Update operation only supports removal of the pull request statuses)
        var propertiesToUpdate = new JsonPatchDocument() {{
            setFrom(null);
            setValue(null);
            setOperation(PatchOperation.REMOVE);
            setPath("/" + newStatus.getId());
        }};

        client.git().pullRequest().statuses().update(repo.getId(), pullRequestId, List.of(propertiesToUpdate));
    }
}
