package org.azd;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.azd.core.Core;
import org.azd.exceptions.DefaultParametersException;
import org.azd.utils.AzDDefaultParameters;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class CoreTest {
    private static ObjectMapper mapper = new ObjectMapper();
    private static String dir;
    private static File file;
    private static MockParameters m;
    private static String organization;
    private static String token;
    private static String project;
    private static AzDDefaultParameters defaultParameters;
    private static Core c;


    @Before
    public void init() throws IOException {
        dir = System.getProperty("user.dir");
        file = new File(dir + "/src/test/java/org/azd/_unitTest.json");
        m = mapper.readValue(file, MockParameters.class);
        organization = m.getO();
        token = m.getT();
        project = m.getP();
        defaultParameters = new AzDDefaultParameters(organization, project, token);
        c = new Core(defaultParameters);
    }

    @Test
    public void shouldReturnListOfProcess() throws DefaultParametersException, IOException {
        c.getProcesses();
    }

    @Test
    public void shouldCreateDefaultProject() throws DefaultParametersException, IOException {
        c.createProject("my-awesome-project", "This is my new awesome project");
    }

    @Test
    public void shouldCreateProjectWithAdditionalParameters() throws DefaultParametersException, IOException {
        c.createProject("my-New-awesome-project", "My new awesome project", "Git", "b8a3a935-7e91-48b8-a94c-606d37c3e9f2");
    }

    @Test
    public void shouldGetAProject() throws DefaultParametersException, IOException {
        c.getProject("my-New-awesome-project");
    }

    @Test
    public void shouldGetAProjectWithOptionalParameters() throws DefaultParametersException, IOException {
        c.getProject("my-New-awesome-project", true, true);
    }

    @Test
    public void shouldDeleteAProject() throws DefaultParametersException, IOException {
        c.deleteProject("00000000-0000-0000-0000-000000000000");
    }

    @Test
    public void shouldGetProjectProperties() throws DefaultParametersException, IOException {
        c.getProjectProperties("00000000-0000-0000-0000-000000000000");
    }

    @Test
    public void shouldReturnAllProjects() throws DefaultParametersException, IOException {
        c.getProjects();
    }

    @Test
    public void shouldCreateAProjectTeam() throws DefaultParametersException, IOException {
        c.createTeam("00000000-0000-0000-0000-000000000000", "myTeam");
    }

    @Test
    public void shouldDeleteAProjectTeam() throws DefaultParametersException, IOException {
        c.deleteTeam("00000000-0000-0000-0000-000000000000", "myTeam");
    }

    @Test
    public void shouldGetAProjectTeam() throws DefaultParametersException, IOException {
        c.getTeam("00000000-0000-0000-0000-000000000000", "myTeam");
    }

    @Test
    public void shouldGetAProjectTeamWithOptionalParameters() throws DefaultParametersException, IOException {
        c.getTeam("00000000-0000-0000-0000-000000000000", "myTeam", true);
    }

    @Test
    public void shouldGetAllProjectTeams() throws DefaultParametersException, IOException {
        c.getTeams();
    }

    @Test
    public void shouldUpdateProjectTeams() throws DefaultParametersException, IOException {
        c.updateTeams("00000000-0000-0000-0000-000000000000", "myTeam", "Description for my super team");
    }

}
