package org.azd;

import org.azd.enums.PullRequestStatus;
import org.azd.exceptions.AzDException;
import org.azd.git.types.WebApiTagDefinition;
import org.azd.helpers.JsonMapper;
import org.azd.interfaces.AzDClient;
import org.azd.interfaces.GitDetails;
import org.azd.utils.AzDClientApi;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

public class GitApiTest {
    private static final JsonMapper MAPPER = new JsonMapper();
    private static AzDClient webApi;
    private static GitDetails g;

    @Before
    public void init() throws AzDException {
        String dir = System.getProperty("user.dir");
        File file = new File(dir + "/src/test/java/org/azd/_unitTest.json");
        MockParameters m = MAPPER.mapJsonFromFile(file, MockParameters.class);
        String organization = m.getO();
        String token = m.getT();
        String project = m.getP();
        webApi = new AzDClientApi(organization, project, token);
        g = webApi.getGitApi();
    }

    @Test(expected = AzDException.class)
    public void shouldCreateANewRepository() throws AzDException {
        g.createRepository("testRepository", "00000000-0000-0000-0000-000000000000");
    }

    @Test(expected = AzDException.class)
    public void shouldDeleteRepository() throws AzDException {
        g.deleteRepository("00000000-0000-0000-0000-000000000000");
    }

    @Test(expected = AzDException.class)
    public void shouldDeleteRepositoryFromRecycleBin() throws AzDException {
        g.deleteRepositoryFromRecycleBin("00000000-0000-0000-0000-000000000000");
    }

    @Test
    public void shouldGetDeletedGitRepositories() throws AzDException {
        g.getDeletedRepositories();
    }

    @Test
    public void shouldGetRecycleBinRepositories() throws AzDException {
        g.getRecycleBinRepositories();
    }

    @Test
    public void shouldGetRepository() throws AzDException {
        g.getRepository("testRepository");
    }

    @Test
    public void shouldGetRepositories() throws AzDException {
        g.getRepositories();
    }

    @Test(expected = AzDException.class)
    public void shouldRestoreRepositoryFromRecycleBin() throws AzDException {
        g.restoreRepositoryFromRecycleBin("00000000-0000-0000-0000-000000000000", false);
    }

    @Test(expected = AzDException.class)
    public void shouldUpdateRepository() throws AzDException {
        g.updateRepository(g.getRepository("newName").getId(), "newRepo", "main");
    }

    @Test(expected = AzDException.class)
    public void shouldCreateANewPullRequest() throws AzDException {
        g.createPullRequest(g.getRepositories().getRepositories().stream().findFirst().get().getId(),
                "refs/heads/develop", "refs/heads/master", "New feature", "Adding new feature",
                new String[]{ "d6245f20-2af8-44f4-9451-8107cb2767db" });
    }

    // failing the test intentionally. If not this will create many pull requests on each run.
    // To pass the test remove (expected = AzDException.class) and replace targetRefName: master with main.
    @Test(expected = AzDException.class)
    public void shouldCreateANewPullRequestAsDraft() throws AzDException {
        var repoId = g.getRepository("testRepository").getId();
        g.createPullRequest(repoId,"develop", "master", "New feature", "Adding new feature", true);
    }

    @Test
    public void shouldRetrieveAPullRequest() throws AzDException {
        g.getPullRequest(g.getRepository("testRepository").getName(), 3);
    }

    @Test
    public void shouldRetrieveAPullRequestById() throws AzDException {
        g.getPullRequestById(2);
    }

    @Test
    public void shouldRetrieveAllPullRequestsFromARepository() throws AzDException {
        g.getPullRequests(g.getRepositories().getRepositories().stream().findFirst().get().getName());
    }

    @Test
    public void shouldGetPullRequestsByProject() throws AzDException {
        g.getPullRequestsByProject().getPullRequests();
    }

    @Test
    public void shouldGetTopTenPullRequestsByProject() throws AzDException {
        g.getPullRequestsByProject(10);
    }

    @Test
    public void shouldGetPullRequestsByProjectWithCompletedStatus() throws AzDException {
        g.getPullRequestsByProject(PullRequestStatus.COMPLETED).getPullRequests();
    }

    @Test
    public void shouldLockABranch() throws AzDException {
        g.updateBranchLock("testRepository", "develop", true);
    }

    @Test
    public void shouldUnLockABranch() throws AzDException {
        g.updateBranchLock("testRepository", "develop", false);
    }

    @Test
    public void shouldGetPullRequestWorkItems() throws AzDException {
        var pr = g.getPullRequestById(4);
        g.getPullRequestWorkItems(pr.getPullRequestId(), pr.getRepository().getName());
    }

    @Test
    public void shouldCreateAPullRequestLabel() throws AzDException {
        g.createPullRequestLabel("testRepository", 7, "DevOps");
    }

    @Test
    public void shouldGetAPullRequestLabel() throws AzDException {
        g.getPullRequestLabel("testRepository", 7, "azd");
    }

    @Test
    public void shouldGetPullRequestLabels() throws AzDException {
        g.getPullRequestLabels("testRepository", 7);
    }

    @Test
    public void shouldDeleteAPullRequestLabels() throws AzDException {
        WebApiTagDefinition label = null;

        try {
            label = g.getPullRequestLabel("testRepository", 7, "DevOps");
        } catch (AzDException ignored) { }

        if (label.getUrl().isEmpty()) {
            g.createPullRequestLabel("testRepository", 7, "DevOps");
        }
        g.deletePullRequestLabel("testRepository", 7, "DevOps");
    }

    @Test
    public void shouldCreateAPullRequestReviewer() throws AzDException {
        g.createPullRequestReviewer(8, "testRepository", "0e5f1643-a006-67e7-bdb9-20f45e698f9f", 0, false);
    }

    @Test(expected = AzDException.class)
    public void shouldDeleteAPullRequestReviewer() throws AzDException {
        g.deletePullRequestReviewer(8, "testRepository", "id");
    }

    @Test
    public void shouldGetAPullRequestReviewer() throws AzDException {
        g.getPullRequestReviewer(8, "testRepository", "10bb49f0-c425-6735-b8de-71ecf84728d6");
    }

    @Test
    public void shouldGetPullRequestReviewers() throws AzDException {
        g.getPullRequestReviewers(8, "testRepository");
    }

    @Test
    public void shouldUpdateAPullRequestReviewer() throws AzDException {
        g.updatePullRequestReviewer(8, "testRepository",
                "10bb49f0-c425-6735-b8de-71ecf84728d6", true, false);
    }

    @Test(expected = AzDException.class)
    public void shouldCreateAnAnnotatedTag() throws AzDException {
        g.createAnnotatedTag("testRepository", "annotatedTestTag", "83764e57d4b290766046da65b1c7c4afe8b71a92",
                "Annotated Tag for testing");
    }

    @Test
    public void shouldGetAnAnnotatedTag() throws AzDException {
        g.getAnnotatedTag("testRepository", "d993d67b34ea8365defbee2945755d5a7d3185f4");
    }

    @Test
    public void shouldGetCommitsFromARepository() throws AzDException {
        g.getCommits("testRepository").getCommits();
    }

    @Test
    public void shouldGetACommitsFromTheRepository() throws AzDException {
        var commitId = g.getCommits("testRepository")
                .getCommits()
                .stream()
                .findFirst()
                .get()
                .getCommitId();
        g.getCommit("testRepository", commitId);
    }
}
