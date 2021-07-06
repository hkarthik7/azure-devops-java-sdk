package org.azd;

import org.azd.core.CoreApi;
import org.azd.exceptions.AzDException;
import org.azd.exceptions.ConnectionException;
import org.azd.helpers.JsonMapper;
import org.azd.interfaces.CoreDetails;
import org.azd.connection.Connection;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

public class CoreApiTest {
    private static final JsonMapper MAPPER = new JsonMapper();
    private static CoreDetails c;


    @Before
    public void init() throws AzDException {
        String dir = System.getProperty("user.dir");
        File file = new File(dir + "/src/test/java/org/azd/_unitTest.json");
        MockParameters m = MAPPER.mapJsonFromFile(file, MockParameters.class);
        String organization = m.getO();
        String token = m.getT();
        String project = m.getP();
        Connection defaultParameters = new Connection(organization, project, token);
        c = new CoreApi(defaultParameters);
    }

    @Test
    public void shouldReturnListOfProcess() throws ConnectionException, AzDException {
        c.getProcesses();
    }

    @Test(expected = AzDException.class)
    public void shouldCreateDefaultProject() throws ConnectionException, AzDException {
        // project already exists error
        System.out.println(c.createProject("my-awesome-project", "This is my new awesome project"));
    }

    @Test
    public void shouldCreateProjectWithAdditionalParameters() throws ConnectionException, AzDException {
        c.createProject("my-New-awesome-project", "My new awesome project", "Git", "b8a3a935-7e91-48b8-a94c-606d37c3e9f2");
    }

    @Test
    public void shouldGetAProject() throws ConnectionException, AzDException {
        c.getProject("my-New-awesome-project");
    }

    @Test
    public void shouldGetAProjectWithOptionalParameters() throws ConnectionException, AzDException {
        c.getProject("my-New-awesome-project", true, true);
    }

    @Test
    public void shouldDeleteAProject() throws ConnectionException, AzDException {
        c.deleteProject(c.getProject("my-New-awesome-project").getId());
    }

    @Test
    public void shouldGetProjectProperties() throws ConnectionException, AzDException {
        var projectId = c.getProject("azure-devops-java-sdk").getId();
        c.getProjectProperties(projectId).getValue();
    }

    @Test
    public void shouldReturnAllProjects() throws ConnectionException, AzDException {
        c.getProjects();
    }

    @Test
    public void shouldCreateAProjectTeam() throws ConnectionException, AzDException {
        c.createTeam(c.getProject("my-awesome-project").getId(), "myNewTeam");
    }

    @Test
    public void shouldDeleteAProjectTeam() throws ConnectionException, AzDException {
        c.deleteTeam(c.getProject("my-awesome-project").getId(), "myNewTeam");
    }

    @Test
    public void shouldGetAProjectTeam() throws ConnectionException, AzDException {
        c.getTeam(c.getProject("my-awesome-project").getId(), "myTeam");
    }

    @Test
    public void shouldGetAProjectTeamWithOptionalParameters() throws ConnectionException, AzDException {
        c.getTeam(c.getProject("my-awesome-project").getId(), "myTeam", true);
    }

    @Test
    public void shouldGetAllProjectTeams() throws ConnectionException, AzDException {
        c.getTeams();
    }

    @Test
    public void shouldUpdateProjectTeams() throws ConnectionException, AzDException {
        c.updateTeams(c.getProject("my-awesome-project").getId(), "myTeam", "Description for my super team");
    }

}
