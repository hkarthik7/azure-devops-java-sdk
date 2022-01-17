package org.azd;

import org.azd.exceptions.AzDException;
import org.azd.helpers.JsonMapper;
import org.azd.interfaces.AzDClient;
import org.azd.interfaces.CoreDetails;
import org.azd.utils.AzDClientApi;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

public class CoreApiTest {
    private static final JsonMapper MAPPER = new JsonMapper();
    private static AzDClient webApi;
    private static CoreDetails c;


    @Before
    public void init() throws AzDException {
        String dir = System.getProperty("user.dir");
        File file = new File(dir + "/src/test/java/org/azd/_unitTest.json");
        MockParameters m = MAPPER.mapJsonFromFile(file, MockParameters.class);
        String organization = m.getO();
        String token = m.getT();
        String project = m.getP();
        webApi = new AzDClientApi(organization, project, token);
        c = webApi.getCoreApi();
    }

    @Test
    public void shouldReturnListOfProcess() throws AzDException {
        c.getProcesses();
    }

    @Test(expected = AzDException.class)
    public void shouldCreateDefaultProject() throws AzDException {
        // project already exists error
        c.createProject("my-awesome-project", "This is my new awesome project");
    }

    @Test
    public void shouldCreateProjectWithAdditionalParameters() throws AzDException {
        c.createProject("my-New-awesome-project", "My new awesome project", "Git", "b8a3a935-7e91-48b8-a94c-606d37c3e9f2");
    }

    @Test
    public void shouldGetAProject() throws AzDException {
        c.getProject("my-New-awesome-project");
    }

    @Test
    public void shouldGetAProjectWithOptionalParameters() throws AzDException {
        c.getProject("my-New-awesome-project", true, true);
    }

    @Test
    public void shouldDeleteAProject() throws AzDException {
        c.deleteProject(c.getProject("my-New-awesome-project").getId());
    }

    @Test
    public void shouldGetProjectProperties() throws AzDException {
        var projectId = c.getProject("azure-devops-java-sdk").getId();
        c.getProjectProperties(projectId).getValue();
    }

    @Test
    public void shouldReturnAllProjects() throws AzDException {
        c.getProjects();
    }

    @Test
    public void shouldCreateAProjectTeam() throws AzDException {
        c.createTeam(c.getProject("my-awesome-project").getId(), "myNewTeam");
    }

    @Test
    public void shouldDeleteAProjectTeam() throws AzDException {
        c.deleteTeam(c.getProject("my-awesome-project").getId(), "myNewTeam");
    }

    @Test
    public void shouldGetAProjectTeam() throws AzDException {
        c.getTeam(c.getProject("my-awesome-project").getId(), "myTeam");
    }

    @Test
    public void shouldGetAProjectTeamWithOptionalParameters() throws AzDException {
        c.getTeam(c.getProject("my-awesome-project").getId(), "myTeam", true);
    }

    @Test
    public void shouldGetAllProjectTeams() throws AzDException {
        c.getTeams();
    }

    @Test
    public void shouldUpdateProjectTeams() throws AzDException {
        c.updateTeams(c.getProject("my-awesome-project").getId(), "myTeam", "Description for my super team");
    }

}
