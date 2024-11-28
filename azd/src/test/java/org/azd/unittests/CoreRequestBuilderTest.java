package org.azd.unittests;

import org.azd.UnitTestConfiguration;
import org.azd.abstractions.InstanceFactory;
import org.azd.abstractions.serializer.SerializerContext;
import org.azd.authentication.PersonalAccessTokenCredential;
import org.azd.core.types.ProjectCreationParameters;
import org.azd.enums.FeatureManagement;
import org.azd.enums.Instance;
import org.azd.exceptions.AzDException;
import org.azd.legacy.MockParameters;
import org.azd.serviceclient.AzDService;
import org.azd.serviceclient.AzDServiceClient;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.Optional;

public class CoreRequestBuilderTest {
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

    @Test
    public void shouldReturnListOfProcess() throws AzDException {
        client.core().processes().list();
    }

    @Test
    public void shouldCreateDefaultProject() {
        var projectParams = new ProjectCreationParameters();
        projectParams.name = testConfiguration.properties.core.projectName;
        projectParams.description = "This is my new awesome project";
        projectParams.templateTypeId = "6b724908-ef14-45cf-84f8-768b5384da45";
        projectParams.sourceControlType = "Git";

        try {
            client.core().projects().create(projectParams);
        } catch (AzDException ignored) {
        }
    }

    @Test
    public void shouldGetAProject() throws AzDException {
        // This gets the current project if set when creating the AzDServiceClient object.
        client.core().projects().get();
    }

    @Test
    public void shouldGetAProjectWithOptionalParameters() throws AzDException {
        var projectId = client.core().projects().get().getId();
        client.core().projects().get(projectId, r -> {
            r.queryParameters.includeCapabilities = true;
            r.queryParameters.includeHistory = true;
        });
    }

    @Test
    public void shouldDeleteAProject() {

        try {
            var project = client.core().projects().get("my-New-awesome-project");

            if (project == null) {
                var projectParams = new ProjectCreationParameters();
                projectParams.name = testConfiguration.properties.core.projectName;
                projectParams.description = "This is my new awesome project";
                projectParams.templateTypeId = "6b724908-ef14-45cf-84f8-768b5384da45";
                projectParams.sourceControlType = "Git";

                var newProject = client.core().projects().create(projectParams);

                Thread.sleep(2000); // Wait for the project to create.

                project = client.core().projects().get(newProject.getId());
            }

            if (project != null) client.core().projects().delete(project.getId());

        } catch (AzDException | InterruptedException ignored) {
        }

    }

    @Test
    public void shouldGetProjectProperties() throws AzDException {
        var projectId = client.core().projects().get().getId();
        assert client.core().projects().properties().get(projectId).getValue() != null;
    }

    @Test
    public void shouldReturnAllProjects() throws AzDException {
        client.core().projects().list();
    }

    @Test
    public void shouldCreateAProjectTeam() {
        try {
            var team = client.core().teams().get(testConfiguration.properties.core.projectName,
                    testConfiguration.properties.core.teamName);

            if (team == null)
                client.core().teams().create(testConfiguration.properties.core.projectName,
                        testConfiguration.properties.core.teamName);
        } catch (AzDException ignored) {
        }

    }

    @Test
    public void shouldDeleteAProjectTeam() {
        try {
            var team = client.core().teams().get(testConfiguration.properties.core.projectName,
                    testConfiguration.properties.core.teamName);

            if (team != null) {
                var project = client.core().projects().get(testConfiguration.properties.core.projectName);
                assert project != null;

                client.core().teams().delete(project.getId(), testConfiguration.properties.core.teamName);
            }
        } catch (AzDException ignored) {
        }

    }

    @Test
    public void shouldGetAProjectTeam() throws AzDException {
        try {
            client.core().teams().get(testConfiguration.properties.core.projectName,
                    testConfiguration.properties.core.teamName);
        } catch (AzDException ignored) {
        }
    }

    @Test
    public void shouldGetAProjectTeamWithOptionalParameters() throws AzDException {
        try {
            client.core().teams().get(testConfiguration.properties.core.projectName,
                    testConfiguration.properties.core.teamName, true);
        } catch (AzDException ignored) {
        }
    }

    @Test
    public void shouldGetAllProjectTeams() throws AzDException {
        client.core().teams().list();
    }

    @Test
    public void shouldUpdateProjectTeams() throws AzDException {
        try {
            var team = client.core().teams().get(testConfiguration.properties.core.projectName,
                    testConfiguration.properties.core.teamName);

            if (team != null) {
                team.setDescription("Description for my super team");
                var project = client.core().projects().get(testConfiguration.properties.core.projectName);
                assert project != null;

                client.core().teams().update(project.getId(), team.getName(), team);
            }
        } catch (AzDException ignored) {
        }
    }

    @Test
    public void shouldReadProjectFeatures() throws AzDException {
        var project = client.core().projects().get(testConfiguration.properties.core.projectName);
        Assume.assumeNotNull(project);
        for (FeatureManagement value : FeatureManagement.values()) {
            try {
                Optional<Boolean> featureState = client.helpers().featureManagement()
                        .getFeatureState(project.getId(), value);
            } catch (Exception ignored) {
            }
        }
    }

    @Test
    public void shouldToggleFeature() throws AzDException {
        var project = client.core().projects().get(testConfiguration.properties.core.projectName);
        Assume.assumeNotNull(project);
        var resp = client.helpers().featureManagement()
                .featureToggle(project.getId(), FeatureManagement.TEST_PLANS, false);
        assert !resp.getStateAsBoolean().get();
    }
}
