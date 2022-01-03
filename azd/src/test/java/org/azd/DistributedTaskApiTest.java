package org.azd;

import org.azd.distributedtask.types.VariableGroupDefinition;
import org.azd.enums.VariableGroupType;
import org.azd.exceptions.AzDException;
import org.azd.exceptions.ConnectionException;
import org.azd.helpers.JsonMapper;
import org.azd.interfaces.AzDClient;
import org.azd.interfaces.CoreDetails;
import org.azd.interfaces.DistributedTaskDetails;
import org.azd.release.types.ProjectReference;
import org.azd.utils.AzDClientApi;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.HashMap;

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
    public void shouldReturnListOfEnvironments() throws ConnectionException, AzDException {
        d.getEnvironments();
    }

    @Test
    public void shouldAddANewVariableGroup() throws ConnectionException, AzDException {
        var variableGroupDefinition = new VariableGroupDefinition();
        var projectReference = new ProjectReference();

        var project = c.getProject("azure-devops-java-sdk");

        projectReference.setName(project.getName());
        projectReference.setId(project.getId());

        var variables = new HashMap<String, Object>(){{
                put("userName", new HashMap<String, String>(){{
                put("value", "testUser");
            }});
            put("passCode", new HashMap<String, Integer>(){{
                put("value", 2255);
            }});
            put("details", new HashMap<String, Object>(){{
                put("value", "Test Value");
                put("isSecret", true);
            }});
        }};

        variableGroupDefinition.setName("testGroup");
        variableGroupDefinition.setDescription("This is a test variable group");
        variableGroupDefinition.setType(VariableGroupType.Vsts);
        variableGroupDefinition.setVariables(variables);
        variableGroupDefinition.setProjectReference(projectReference);

        System.out.println(d.addVariableGroup(variableGroupDefinition));
    }

    @Test
    public void shouldAddANewVariableGroupToDefaultProject() throws ConnectionException, AzDException {
        var variables = new HashMap<String, Object>(){{
            put("userName", new HashMap<String, String>(){{
                put("value", "testUser");
            }});
            put("passCode", new HashMap<String, Integer>(){{
                put("value", 2255);
            }});
            put("details", new HashMap<String, Object>(){{
                put("value", "Test Value");
                put("isSecret", true);
            }});
        }};

        System.out.println(d.addVariableGroup("test", "test group", variables));
    }

    @Test
    public void shouldGetVariableGroups() throws ConnectionException, AzDException {
        d.getVariableGroups();
    }

    @Test
    public void shouldDeleteAVariableGroup() throws ConnectionException, AzDException {
        var variables = new HashMap<>(){{
           put("userName", new HashMap<>(){{
               put("value", "testUser");
           }});
        }};

        var projectId = c.getProject("azure-devops-java-sdk").getId();

        var group = d.addVariableGroup("newVariableGroup", "Meant for testing deletion functionality", variables);

        d.deleteVariableGroup(group.getId(), new String[]{projectId});
    }

}
