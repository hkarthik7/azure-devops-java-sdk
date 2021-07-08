package org.azd;

import org.azd.connection.Connection;
import org.azd.enums.PullRequestStatus;
import org.azd.exceptions.AzDException;
import org.azd.exceptions.ConnectionException;
import org.azd.git.GitApi;
import org.azd.helpers.JsonMapper;
import org.azd.interfaces.GitDetails;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

public class GitApiTest {
    private static final JsonMapper MAPPER = new JsonMapper();
    private static GitDetails g;

    @Before
    public void init() throws AzDException {
        String dir = System.getProperty("user.dir");
        File file = new File(dir + "/src/test/java/org/azd/_unitTest.json");
        MockParameters m = MAPPER.mapJsonFromFile(file, MockParameters.class);
        String organization = m.getO();
        String token = m.getT();
        String project = m.getP();
        Connection defaultParameters = new Connection(organization, project, token);
        g = new GitApi(defaultParameters);
    }

    @Test(expected = AzDException.class)
    public void shouldCreateANewRepository() throws ConnectionException, AzDException {
        g.createRepository("testRepository", "00000000-0000-0000-0000-000000000000");
    }

    @Test(expected = AzDException.class)
    public void shouldDeleteRepository() throws ConnectionException, AzDException {
        g.deleteRepository("00000000-0000-0000-0000-000000000000");
    }

    @Test(expected = AzDException.class)
    public void shouldDeleteRepositoryFromRecycleBin() throws ConnectionException, AzDException {
        g.deleteRepositoryFromRecycleBin("00000000-0000-0000-0000-000000000000");
    }

    @Test
    public void shouldGetDeletedGitRepositories() throws ConnectionException, AzDException {
        g.getDeletedRepositories();
    }

    @Test
    public void shouldGetRecycleBinRepositories() throws ConnectionException, AzDException {
        g.getRecycleBinRepositories();
    }

    @Test
    public void shouldGetRepository() throws ConnectionException, AzDException {
        g.getRepository("testRepository");
    }

    @Test
    public void shouldGetRepositories() throws ConnectionException, AzDException {
        g.getRepositories();
    }

    @Test(expected = AzDException.class)
    public void shouldRestoreRepositoryFromRecycleBin() throws ConnectionException, AzDException {
        g.restoreRepositoryFromRecycleBin("00000000-0000-0000-0000-000000000000", false);
    }

    @Test(expected = AzDException.class)
    public void shouldUpdateRepository() throws ConnectionException, AzDException {
        g.updateRepository(g.getRepository("newName").getId(), "newRepo", "main");
    }

    @Test(expected = AzDException.class)
    public void shouldCreateANewPullRequest() throws ConnectionException, AzDException {
        g.createPullRequest(g.getRepositories().getRepositories().stream().findFirst().get().getId(),
                "refs/heads/develop", "refs/heads/master", "New feature", "Adding new feature",
                new String[]{ "d6245f20-2af8-44f4-9451-8107cb2767db" });
    }

    // failing the test intentionally. If not this will create many pull requests on each run.
    // To pass the test remove (expected = AzDException.class) and replace targetRefName: master with main.
    @Test(expected = AzDException.class)
    public void shouldCreateANewPullRequestAsDraft() throws ConnectionException, AzDException {
        var repoId = g.getRepository("testRepository").getId();
        g.createPullRequest(repoId,"develop", "master", "New feature", "Adding new feature", true);
    }

    @Test
    public void shouldRetrieveAPullRequest() throws ConnectionException, AzDException {
        g.getPullRequest(g.getRepository("testRepository").getName(), 3);
    }

    @Test
    public void shouldRetrieveAPullRequestById() throws ConnectionException, AzDException {
        g.getPullRequestById(2);
    }

    @Test
    public void shouldRetrieveAllPullRequestsFromARepository() throws ConnectionException, AzDException {
        g.getPullRequests(g.getRepositories().getRepositories().stream().findFirst().get().getName());
    }

    @Test
    public void shouldGetPullRequestsByProject() throws ConnectionException, AzDException {
        g.getPullRequestsByProject().getPullRequests();
    }

    @Test
    public void shouldGetTopTenPullRequestsByProject() throws ConnectionException, AzDException {
        g.getPullRequestsByProject(10);
    }

    @Test
    public void shouldGetPullRequestsByProjectWithCompletedStatus() throws ConnectionException, AzDException {
        g.getPullRequestsByProject(PullRequestStatus.COMPLETED).getPullRequests();
    }

    @Test
    public void shouldLockABranch() throws ConnectionException, AzDException {
        g.updateBranchLock("testRepository", "develop", true);
    }

    @Test
    public void shouldUnLockABranch() throws ConnectionException, AzDException {
        g.updateBranchLock("testRepository", "develop", false);
    }

    @Test
    public void shouldGetPullRequestWorkItems() throws ConnectionException, AzDException {
        var pr = g.getPullRequestById(4);
        g.getPullRequestWorkItems(pr.getPullRequestId(), pr.getRepository().getName());
    }
}
