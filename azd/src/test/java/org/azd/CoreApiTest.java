package org.azd;

import org.azd.authentication.PersonalAccessTokenCredential;
import org.azd.core.CoreRequestBuilder;
import org.azd.core.types.Project;
import org.azd.core.types.ProjectFeature;
import org.azd.core.types.Team;
import org.azd.enums.FeatureManagement;
import org.azd.exceptions.AzDException;
import org.azd.helpers.JsonMapper;
import org.azd.interfaces.AccessTokenCredential;
import org.azd.interfaces.AzDClient;
import org.azd.interfaces.CoreDetails;
import org.azd.serviceClient.AzDServiceClient;
import org.azd.utils.AzDClientApi;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.Optional;
import java.util.concurrent.CompletionException;

public class CoreApiTest {
    private static final JsonMapper MAPPER = new JsonMapper();
    private static AzDClient webApi;
    private static CoreDetails c;
    private static AzDServiceClient client;
    private static AccessTokenCredential pat;
    private static CoreRequestBuilder cc;


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
        pat = new PersonalAccessTokenCredential(organization, project, token);
        client = new AzDServiceClient(pat);
        cc = client.core();
    }

    @Test
    public void shouldReturnListOfProcess() throws AzDException {
        cc.processes().list().join();
    }

    @Test(expected = CompletionException.class)
    public void shouldCreateDefaultProject() throws AzDException {
        // project already exists error
        cc.projects().create("my-awesome-project", "This is my new awesome project").join();
    }

    @Test
    public void shouldCreateProjectWithAdditionalParameters() throws AzDException {
        try {
            cc.projects().create("my-New-awesome-project", "My new awesome project", "Git",
                    "b8a3a935-7e91-48b8-a94c-606d37c3e9f2");
        } catch (AzDException e) {
            // Ignore project already exists error.
        }
    }

    @Test
    public void shouldGetAProject() throws AzDException {
        cc.projects().get().join();
    }

    @Test
    public void shouldGetAProjectWithOptionalParameters() throws AzDException {
        cc.projects().getProperties().join();
    }

    @Test
    public void shouldDeleteAProject() throws AzDException {
        Project project = null;
        try {
            project = cc.projects().get("my-New-awesome-project").join();
        } catch (AzDException e) {
        }

        if (project != null) {
            cc.projects().delete(project.getId()).join();
        }
    }

    @Test
    public void shouldGetProjectProperties() throws AzDException {
        cc.projects().getProperties().join().getValue();
    }

    @Test
    public void shouldReturnAllProjects() throws AzDException {
        System.out.println(cc.projects().list().join());
    }

    @Test
    public void shouldCreateAProjectTeam() throws AzDException {
        Team team = null;
        try {
            team = c.getTeam("my-awesome-project", "myNewTeam");
        } catch (AzDException e) {
        }

        if (team == null) {
            c.createTeam("my-awesome-project", "myNewTeam");
        }
    }

    @Test
    public void shouldDeleteAProjectTeam() throws AzDException {
        Team team = null;
        try {
            team = c.getTeam("my-awesome-project", "myNewTeam");
        } catch (AzDException e) {
        }

        if (team != null) {
            c.deleteTeam(c.getProject("my-awesome-project").getId(), "myNewTeam");
        }
    }

    @Test
    public void shouldGetAProjectTeam() throws AzDException {
        try {
            c.getTeam("my-awesome-project", "myTeam");
        } catch (AzDException e) {
        }
    }

    @Test
    public void shouldGetAProjectTeamWithOptionalParameters() throws AzDException {
        try {
            c.getTeam(c.getProject("my-awesome-project").getId(), "myTeam", true);
        } catch (AzDException e) {
        }
    }

    @Test
    public void shouldGetAllProjectTeams() throws AzDException {
        c.getTeams();
    }

    @Test
    public void shouldUpdateProjectTeams() throws AzDException {
        c.updateTeams(c.getProject("my-awesome-project").getId(), "myTeam", "Description for my super team");
    }

    @Test
    public void shouldReadProjectFeatures() throws AzDException {
        Project project = c.getProject("my-awesome-project");
        Assume.assumeNotNull(project);
        for (FeatureManagement value : FeatureManagement.values()) {
            Optional<Boolean> featureState = c.getFeatureState(project.getId(), value);
        }
    }

    @Test
    public void shouldToggleFeature() throws AzDException {
        Project project = c.getProject("my-awesome-project");
        Assume.assumeNotNull(project);
        ProjectFeature projectFeature = c.featureToggle(project.getId(), FeatureManagement.TEST_PLANS, false);
//        System.out.println("Feature: " + projectFeature);
    }
}
