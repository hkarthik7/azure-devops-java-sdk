package org.azd;

import org.azd.distributedtask.types.VariableGroupDefinition;
import org.azd.distributedtask.types.VariableGroupMap;
import org.azd.enums.VariableGroupType;
import org.azd.enums.VariableValue;
import org.azd.exceptions.AzDException;
import org.azd.helpers.JsonMapper;
import org.azd.interfaces.AzDClient;
import org.azd.interfaces.CoreDetails;
import org.azd.interfaces.DistributedTaskDetails;
import org.azd.release.types.ProjectReference;
import org.azd.utils.AzDClientApi;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

public class DistributedTaskApiTest {
    private static final JsonMapper MAPPER = new JsonMapper();
    private static AzDClient webApi;
    private static DistributedTaskDetails d;
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
        d = webApi.getDistributedTaskApi();
        c = webApi.getCoreApi();
    }

    @Test
    public void shouldGetAnAgentInAPool() throws AzDException {
        d.getAgent(9, 8);
    }

    @Test
    public void shouldGetAllAgentsInAPool() throws AzDException {
        d.getAgents(9);
    }

    @Test(expected = AzDException.class)
    public void shouldAddADeploymentGroup() throws AzDException {
        d.addDeploymentGroup("myDeploymentGroup", "Deployments to test VMs");
    }

    @Test
    public void shouldGetAllDeploymentGroups() throws AzDException {
        d.getDeploymentGroups();
    }

    @Test
    public void shouldGetADeploymentGroup() throws AzDException {
        d.getDeploymentGroup(2944);
    }

    @Test
    public void shouldDeleteADeploymentGroup() throws AzDException {
        // create a new deployment group
        try {
            var deploymentGroup = d.addDeploymentGroup("newDeploymentGroup", "New Deployment group");
            d.deleteDeploymentGroup(deploymentGroup.getId());
        } catch (AzDException e) { }
    }

    @Test
    public void shouldUpdateADeploymentGroup() throws AzDException {
        // create a new deployment group, update it and delete it.
        var deploymentGroup = d.getDeploymentGroup(2947);
        d.updateDeploymentGroup(deploymentGroup.getId(), deploymentGroup.getName(), "Description for new deployment group");
    }

    @Test(expected = AzDException.class)
    public void shouldAddANewEnvironment() throws AzDException {
        d.addEnvironment("newEnvironment", "New testing environment");
    }

    @Test
    public void shouldGetAnEnvironment() throws AzDException {
        d.getEnvironment(1);
    }

    @Test
    public void shouldReturnListOfEnvironments() throws AzDException {
        d.getEnvironments();
    }

    @Test
    public void shouldDeleteAnEnvironment() throws AzDException {
        var env = d.addEnvironment("EnvironmentToDelete", "Environment created for testing deletion functionality");
        d.deleteEnvironment(env.getId());
    }

    @Test
    public void shouldUpdateAnEnvironment() throws AzDException {
        d.updateEnvironment(4, "EnvironmentToUpdate", "Environment created for testing update functionality");
    }

    @Test
    public void shouldAddANewVariableGroup() throws AzDException {
        try {
            var variableGroupDefinition = new VariableGroupDefinition();
            var projectReference = new ProjectReference();

            var project = c.getProject("azure-devops-java-sdk");

            projectReference.setName(project.getName());
            projectReference.setId(project.getId());

            var variables = new VariableGroupMap(){{
                put("userName", "testUser");
                put("passCode", "2255");
                put("details", "Test Value", VariableValue.IS_SECRET);
            }};

            variableGroupDefinition.setName("testGroup");
            variableGroupDefinition.setDescription("This is a test variable group");
            variableGroupDefinition.setType(VariableGroupType.Vsts);
            variableGroupDefinition.setVariables(variables.get());
            variableGroupDefinition.setProjectReference(projectReference);

            d.addVariableGroup(variableGroupDefinition);
        } catch (AzDException e) { }
    }

    @Test
    public void shouldAddANewVariableGroupToDefaultProject() throws AzDException {
        try {
            var vMap = new VariableGroupMap(){{
                put("userName", "testUser");
                put("passCode", "2255");
                put("details", "Test Value", VariableValue.IS_SECRET);
            }};

            d.addVariableGroup("test", "test group", vMap);
        } catch (AzDException e) { }
    }

    @Test
    public void shouldGetVariableGroups() throws AzDException {
        d.getVariableGroups();
    }

    @Test
    public void shouldDeleteAVariableGroup() throws AzDException {
        var variables = new VariableGroupMap(){{
            put("userName", "testUser");
        }};

        var projectId = c.getProject("azure-devops-java-sdk").getId();

        var group = d.addVariableGroup("newVariableGroup", "Meant for testing deletion functionality", variables);

        d.deleteVariableGroup(group.getId(), new String[]{projectId});
    }

    @Test
    public void shouldUpdateAVariableGroup() throws AzDException {
        var variablesToUpdate = new VariableGroupMap() {{
            put("userName", "testUser");
            put("password", "testUser", VariableValue.IS_SECRET);
            put("details", "Test Value", VariableValue.IS_READONLY);
        }};

        var group = d.getVariableGroups("testGroupNew")
                .getVariableGroups()
                .stream()
                .findFirst()
                .get();

        d.updateVariableGroup(group.getId(), group.getName(), group.getDescription(), variablesToUpdate);
    }
}
