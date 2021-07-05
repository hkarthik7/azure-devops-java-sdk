package org.azd;

import org.azd.exceptions.AzDException;
import org.azd.exceptions.DefaultParametersException;
import org.azd.git.GitApi;
import org.azd.helpers.JsonMapper;
import org.azd.interfaces.GitDetails;
import org.azd.connection.Connection;
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
    public void shouldCreateANewRepository() throws DefaultParametersException, AzDException {
        g.createRepository("testRepository", "00000000-0000-0000-0000-000000000000");
    }

    @Test(expected = AzDException.class)
    public void shouldDeleteRepository() throws DefaultParametersException, AzDException {
        g.deleteRepository("00000000-0000-0000-0000-000000000000");
    }

    @Test(expected = AzDException.class)
    public void shouldDeleteRepositoryFromRecycleBin() throws DefaultParametersException, AzDException {
        g.deleteRepositoryFromRecycleBin("00000000-0000-0000-0000-000000000000");
    }

    @Test
    public void shouldGetDeletedGitRepositories() throws DefaultParametersException, AzDException {
        g.getDeletedRepositories();
    }

    @Test
    public void shouldGetRecycleBinRepositories() throws DefaultParametersException, AzDException {
        g.getRecycleBinRepositories();
    }

    @Test
    public void shouldGetRepository() throws DefaultParametersException, AzDException {
        g.getRepository("testRepository");
    }

    @Test
    public void shouldGetRepositories() throws DefaultParametersException, AzDException {
        g.getRepositories();
    }

    @Test(expected = AzDException.class)
    public void shouldRestoreRepositoryFromRecycleBin() throws DefaultParametersException, AzDException {
        g.restoreRepositoryFromRecycleBin("00000000-0000-0000-0000-000000000000", false);
    }

    @Test(expected = AzDException.class)
    public void shouldUpdateRepository() throws DefaultParametersException, AzDException {
        g.updateRepository(g.getRepository("newName").getId(), "newRepo", "main");
    }

    @Test(expected = AzDException.class)
    public void shouldCreateANewPullRequest() throws DefaultParametersException, AzDException {
        g.createPullRequest(g.getRepositories().getRepositories().stream().findFirst().get().getId(),
                "refs/heads/develop", "refs/heads/master", "New feature", "Adding new feature",
                new String[]{ "d6245f20-2af8-44f4-9451-8107cb2767db" });
    }

    @Test
    public void shouldRetrieveAPullRequest() throws DefaultParametersException, AzDException {
        g.getPullRequest(g.getRepository("testRepository").getName(), 3);
    }

    @Test
    public void shouldRetrieveAPullRequestById() throws DefaultParametersException, AzDException {
        g.getPullRequestById(2);
    }

    @Test
    public void shouldRetrieveAllPullRequestsFromARepository() throws DefaultParametersException, AzDException {
        g.getPullRequests(g.getRepositories().getRepositories().stream().findFirst().get().getName());
    }

    @Test
    public void shouldGetPullRequestsByProject() throws DefaultParametersException, AzDException {
        g.getPullRequestsByProject().getPullRequests();
    }
}
