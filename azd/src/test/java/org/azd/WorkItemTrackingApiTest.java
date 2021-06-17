package org.azd;

import org.azd.workitemtracking.WorkItemTrackingApi;
import org.azd.enums.WorkItemExpand;
import org.azd.enums.WorkItemOperation;
import org.azd.exceptions.AzDException;
import org.azd.exceptions.DefaultParametersException;
import org.azd.helpers.JsonMapper;
import org.azd.utils.AzDDefaultParameters;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertEquals;

public class WorkItemTrackingApiTest {
    private static final JsonMapper MAPPER = new JsonMapper();
    private static WorkItemTrackingApi w;

    @Before
    public void init() throws AzDException {
        String dir = System.getProperty("user.dir");
        File file = new File(dir + "/src/test/java/org/azd/_unitTest.json");
        MockParameters m = MAPPER.mapJsonFromFile(file, MockParameters.class);
        String organization = m.getO();
        String token = m.getT();
        String project = m.getP();
        AzDDefaultParameters defaultParameters = new AzDDefaultParameters(organization, project, token);
        w = new WorkItemTrackingApi(defaultParameters);
    }

    @Test
    public void shouldGetWorkItem() throws DefaultParametersException, AzDException {
        var expectedValue = "azure-devops-java-sdk";
        var result = w.getWorkItem(2).getFields().getSystemTeamProject();
        assertEquals(expectedValue, result);
    }

    @Test
    public void shouldGetWorkItemWithOptionalParameters() throws DefaultParametersException, AzDException {
        var expectedValue = "azure-devops-java-sdk";
        var result = w.getWorkItem(2, WorkItemExpand.ALL).getFields().getSystemTeamProject();
        assertEquals(expectedValue, result);
    }

    @Test
    public void shouldCreateAWorkItem() throws DefaultParametersException, AzDException {
        w.createWorkItem("user story", WorkItemOperation.ADD, "Sample User story",
                "Description for the user story", new String[]{"DevOps", "Java", "SDK"});
    }

    @Test(expected = AzDException.class)
    public void shouldDeleteAWorkItem() throws DefaultParametersException, AzDException {
        w.deleteWorkItem(6);
    }

    @Test
    public void shouldGetWorkItems() throws DefaultParametersException, AzDException {
        w.getWorkItems(new int[]{1,2,3});
    }

    @Test
    public void shouldGetWorkItemRevisions() throws DefaultParametersException, AzDException {
        var r = w.getWorkItemRevisions(3, WorkItemExpand.ALL)
                .getWorkItems().stream().findFirst().get()
                .getFields().getSystemAreaId();
        assertEquals(12, r);
    }

    @Test
    public void shouldGetWorkItemRevision() throws DefaultParametersException, AzDException {
        w.getWorkItemRevision(3, 1);
    }

    @Test
    public void shouldQueryWorkItems() throws DefaultParametersException, AzDException {
        var query = "Select * From WorkItems Where [System.WorkItemType] = 'User Story'";
        var team = "azure-devops-java-sdk Team";
        w.queryByWiql(team, query, 10, true).getWorkItems();
    }

    @Test
    public void shouldQueryWorkItemsAndGetExactlyOneResult() throws DefaultParametersException, AzDException {
        var query = "Select * From WorkItems Where [System.WorkItemType] = 'User Story'";
        var team = "azure-devops-java-sdk Team";
        var res = (long) w.queryByWiql(team, query, 1, true).getWorkItems().size();
        assertEquals(1, res);
    }
}
