package org.azd;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.azd.core.Core;
import org.azd.utils.AzDDefaultParameters;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class CoreTest {
    private static final ObjectMapper MAPPER = new ObjectMapper();
    private static Core c;


    @Before
    public void init() throws IOException {
        String dir = System.getProperty("user.dir");
        File file = new File(dir + "/src/test/java/org/azd/_unitTest.json");
        MockParameters m = MAPPER.readValue(file, MockParameters.class);
        String organization = m.getO();
        String token = m.getT();
        String project = m.getP();
        AzDDefaultParameters defaultParameters = new AzDDefaultParameters(organization, project, token);
        c = new Core(defaultParameters);
    }

    @Test
    public void shouldReturnListOfProcess() {
        System.out.println(c.getProcesses());
    }

    @Test
    public void shouldCreateDefaultProject() {
        c.createProject("my-awesome-project", "This is my new awesome project");
    }

    @Test
    public void shouldCreateProjectWithAdditionalParameters() {
        c.createProject("my-New-awesome-project", "My new awesome project", "Git", "b8a3a935-7e91-48b8-a94c-606d37c3e9f2");
    }

    @Test
    public void shouldGetAProject() {
        c.getProject("my-New-awesome-project");
    }

    @Test
    public void shouldGetAProjectWithOptionalParameters() {
        c.getProject("my-New-awesome-project", true, true);
    }

    @Test
    public void shouldDeleteAProject() {
        c.deleteProject("00000000-0000-0000-0000-000000000000");
    }

    @Test
    public void shouldGetProjectProperties() {
        c.getProjectProperties("00000000-0000-0000-0000-000000000000");
    }

    @Test
    public void shouldReturnAllProjects() {
        c.getProjects();
    }

    @Test
    public void shouldCreateAProjectTeam() {
        c.createTeam("00000000-0000-0000-0000-000000000000", "myTeam");
    }

    @Test
    public void shouldDeleteAProjectTeam() {
        c.deleteTeam("00000000-0000-0000-0000-000000000000", "myTeam");
    }

    @Test
    public void shouldGetAProjectTeam() {
        c.getTeam("00000000-0000-0000-0000-000000000000", "myTeam");
    }

    @Test
    public void shouldGetAProjectTeamWithOptionalParameters() {
        c.getTeam("00000000-0000-0000-0000-000000000000", "myTeam", true);
    }

    @Test
    public void shouldGetAllProjectTeams() {
        c.getTeams();
    }

    @Test
    public void shouldUpdateProjectTeams() {
        c.updateTeams("00000000-0000-0000-0000-000000000000", "myTeam", "Description for my super team");
    }

}
