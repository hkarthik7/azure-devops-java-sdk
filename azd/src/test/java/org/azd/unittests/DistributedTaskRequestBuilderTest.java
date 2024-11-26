package org.azd.unittests;

import org.azd.UnitTestConfiguration;
import org.azd.abstractions.InstanceFactory;
import org.azd.abstractions.serializer.SerializerContext;
import org.azd.authentication.PersonalAccessTokenCredential;
import org.azd.distributedtask.deploymentgroups.DeploymentGroupsRequestBuilder;
import org.azd.distributedtask.types.ConfigurableVariableValue;
import org.azd.distributedtask.types.VariableGroupLibrary;
import org.azd.distributedtask.types.VariableGroupProjectReference;
import org.azd.enums.Instance;
import org.azd.enums.VariableGroupType;
import org.azd.exceptions.AzDException;
import org.azd.legacy.MockParameters;
import org.azd.release.types.ConfigurationVariableValue;
import org.azd.release.types.ProjectReference;
import org.azd.serviceclient.AzDService;
import org.azd.serviceclient.AzDServiceClient;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.HashMap;
import java.util.List;

public class DistributedTaskRequestBuilderTest {
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
    public void shouldGetAnAgentInAPool() throws AzDException {
        client.distributedTask().agents()
                .get(testConfiguration.properties.distributedTask.poolId,
                        testConfiguration.properties.distributedTask.agentId);
    }

    @Test
    public void shouldGetAllAgentsInAPool() throws AzDException {
        client.distributedTask().agents().list(testConfiguration.properties.distributedTask.poolId);
    }

    @Test
    public void shouldAddADeploymentGroup() {
        var deploymentGroup = new DeploymentGroupsRequestBuilder.DeploymentGroupRequest();
        deploymentGroup.name = testConfiguration.properties.distributedTask.deploymentGroupName;
        deploymentGroup.description = "Deployments to test VMs";

        try {
            client.distributedTask().deploymentGroups().add(deploymentGroup);
        } catch (AzDException ignored) {
        }
    }

    @Test
    public void shouldGetAllDeploymentGroups() throws AzDException {
        client.distributedTask().deploymentGroups().list();
    }

    @Test
    public void shouldGetADeploymentGroup() throws AzDException {
        var deploymentGroups = client.distributedTask().deploymentGroups().list();
        Assume.assumeNotNull(deploymentGroups);

        Assume.assumeNotNull(deploymentGroups.getDeploymentGroups());

        if (deploymentGroups.getDeploymentGroups().stream().findFirst().isPresent()) {
            var deploymentGroupId = deploymentGroups.getDeploymentGroups().stream().findFirst().get().getId();
            client.distributedTask().deploymentGroups().get(deploymentGroupId);
        }
    }

    @Test
    public void shouldDeleteADeploymentGroup() throws AzDException {
        try {
            var deploymentGroup = new DeploymentGroupsRequestBuilder.DeploymentGroupRequest();
            deploymentGroup.name = "newDeploymentGroup";
            deploymentGroup.description = "New Deployment group";

            // create a new deployment group
            var newDeploymentGroup = client.distributedTask().deploymentGroups().add(deploymentGroup);

            Thread.sleep(2000); // Wait for deployment group to be created.

            if (newDeploymentGroup != null)
                client.distributedTask().deploymentGroups().delete(newDeploymentGroup.getId());
        } catch (AzDException | InterruptedException ignored) {
        }
    }

    @Test
    public void shouldUpdateADeploymentGroup() {
        // create a new deployment group and update it.
        try {
            var depGrpName = testConfiguration.properties.distributedTask.deploymentGroupName;
            var deploymentGroups = client.distributedTask().deploymentGroups().list();
            Assume.assumeNotNull(deploymentGroups.getDeploymentGroups());

            var deploymentGroup = deploymentGroups.getDeploymentGroups()
                    .stream()
                    .filter(x -> x.getName().equalsIgnoreCase(depGrpName))
                    .findFirst()
                    .get();

            Assume.assumeNotNull(deploymentGroup);

            client.distributedTask().deploymentGroups()
                    .update(deploymentGroup.getId(), deploymentGroup.getName(),
                            "Description for new deployment group");

        } catch (AzDException ignored) {
        }
    }

    @Test
    public void shouldAddANewEnvironment() {
        try {
            client.distributedTask().environments().add(testConfiguration.properties.distributedTask.environmentName,
                    "New testing environment");
        } catch (AzDException ignored) {
        }
    }

    @Test
    public void shouldGetAnEnvironment() throws AzDException {
        var environments = client.distributedTask().environments().list();
        Assume.assumeNotNull(environments.getEnvironmentInstances());

        if (environments.getEnvironmentInstances().stream().findFirst().isPresent()) {
            var environmentId = environments.getEnvironmentInstances().stream().findFirst().get().getId();
            client.distributedTask().environments().get(environmentId);
        }
    }

    @Test
    public void shouldReturnListOfEnvironments() throws AzDException {
        client.distributedTask().environments().list();
    }

    @Test
    public void shouldDeleteAnEnvironment() {
        try {
            var env = client.distributedTask().environments().add("EnvironmentToDelete",
                    "Environment created for testing deletion functionality");

            Thread.sleep(2000); // Wait for environment creation.

            client.distributedTask().environments().delete(env.getId());

        } catch (AzDException | InterruptedException ignored) {
        }
    }

    @Test
    public void shouldUpdateAnEnvironment() {
        try {
            var env = client.distributedTask().environments().add("EnvironmentToUpdate",
                    "Environment created for testing update functionality");

            Thread.sleep(2000); // Wait for environment creation.

            env.setDescription("This is an updated description");

            client.distributedTask().environments().update(env.getId(), env.getName(), env.getDescription());

            client.distributedTask().environments().delete(env.getId());

        } catch (AzDException | InterruptedException ignored) {
        }
    }

    @Test
    public void shouldAddANewVariableGroup() throws AzDException {
        try {
            var project = client.core().projects().get();

            var variableGroupLibrary = new VariableGroupLibrary();
            variableGroupLibrary.name = testConfiguration.properties.distributedTask.variableGroupName;
            variableGroupLibrary.description = "This is a test variable group";
            variableGroupLibrary.type = VariableGroupType.Vsts.name();

            var variableGroupProjectReference = new VariableGroupProjectReference();
            variableGroupProjectReference.setName(variableGroupLibrary.name);
            variableGroupProjectReference.setDescription(variableGroupLibrary.description);
            var projectReference = new ProjectReference();
            projectReference.setName(project.getName());
            projectReference.setId(project.getId());
            variableGroupProjectReference.setProjectReference(projectReference);

            variableGroupLibrary.variableGroupProjectReferences = List.of(variableGroupProjectReference);

            var testUserValue = new ConfigurableVariableValue();
            testUserValue.setValue("testUser");

            var passCodeValue = new ConfigurableVariableValue();
            passCodeValue.setValue("2255");
            passCodeValue.setSecret(true);

            var detailsValue = new ConfigurableVariableValue();
            detailsValue.setValue("Test Value");
            detailsValue.setReadOnly(true);
            variableGroupLibrary.variables = new HashMap<>() {{
                put("userName", testUserValue);
                put("passCode", passCodeValue);
                put("details", detailsValue);
            }};

            client.distributedTask().variableGroups().add(variableGroupLibrary);
        } catch (AzDException ignored) {
        }
    }

    @Test
    public void shouldGetVariableGroups() throws AzDException {
        client.distributedTask().variableGroups().list();
    }

    @Test
    public void shouldDeleteAVariableGroup() {
        try {
            var project = client.core().projects().get();
            var variableGroupLibrary = new VariableGroupLibrary();
            variableGroupLibrary.name = "newVariableGroup";
            variableGroupLibrary.description = "Meant for testing deletion functionality";
            variableGroupLibrary.type = VariableGroupType.Vsts.name();

            var variableGroupProjectReference = new VariableGroupProjectReference();
            variableGroupProjectReference.setName(variableGroupLibrary.name);
            variableGroupProjectReference.setDescription(variableGroupLibrary.description);
            var projectReference = new ProjectReference();
            projectReference.setName(project.getName());
            projectReference.setId(project.getId());
            variableGroupProjectReference.setProjectReference(projectReference);

            variableGroupLibrary.variableGroupProjectReferences = List.of(variableGroupProjectReference);

            var testUserValue = new ConfigurableVariableValue();
            testUserValue.setValue("testUser");

            var passCodeValue = new ConfigurableVariableValue();
            passCodeValue.setValue("2255");
            passCodeValue.setSecret(true);

            var detailsValue = new ConfigurableVariableValue();
            detailsValue.setValue("Test Value");
            detailsValue.setReadOnly(true);
            variableGroupLibrary.variables = new HashMap<>() {{
                put("userName", testUserValue);
                put("passCode", passCodeValue);
                put("details", detailsValue);
            }};

            var newVariableGroup = client.distributedTask().variableGroups().add(variableGroupLibrary);

            Assume.assumeNotNull(newVariableGroup);
            Thread.sleep(2000);

            client.distributedTask().variableGroups().delete(newVariableGroup.getId(), new String[]{project.getId()});
        } catch (AzDException | InterruptedException ignored) {
        }
    }

    @Test
    public void shouldUpdateAVariableGroup() throws AzDException {
        var group = client.distributedTask().variableGroups()
                .list(r ->
                        r.queryParameters.groupName = testConfiguration.properties.distributedTask.variableGroupName
                )
                .getVariableGroups()
                .stream()
                .findFirst();

        if (group.isPresent()) {
            var variableGrp = group.get();
            var project = client.core().projects().get();

            var variableGroupLibrary = new VariableGroupLibrary();
            variableGroupLibrary.name = variableGrp.getName();
            variableGroupLibrary.description = variableGrp.getDescription();
            variableGroupLibrary.type = variableGrp.getType();

            var variableGroupProjectReference = new VariableGroupProjectReference();
            variableGroupProjectReference.setName(variableGroupLibrary.name);
            variableGroupProjectReference.setDescription(variableGroupLibrary.description);
            var projectReference = new ProjectReference();
            projectReference.setName(project.getName());
            projectReference.setId(project.getId());
            variableGroupProjectReference.setProjectReference(projectReference);

            variableGroupLibrary.variableGroupProjectReferences = List.of(variableGroupProjectReference);

            var testUserValue = new ConfigurableVariableValue();
            testUserValue.setValue("testUser");

            var passCodeValue = new ConfigurableVariableValue();
            passCodeValue.setValue("2255");
            passCodeValue.setSecret(true);

            var detailsValue = new ConfigurableVariableValue();
            detailsValue.setValue("Test Value");
            detailsValue.setReadOnly(false);

            variableGroupLibrary.variables = new HashMap<>() {{
                put("userName", testUserValue);
                put("passCode", passCodeValue);
                put("details", detailsValue);
            }};

            client.distributedTask().variableGroups().update(group.get().getId(), variableGroupLibrary);
        }
    }
}
