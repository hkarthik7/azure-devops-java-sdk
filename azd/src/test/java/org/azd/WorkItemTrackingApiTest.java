package org.azd;

import org.azd.connection.Connection;
import org.azd.enums.WorkItemExpand;
import org.azd.enums.WorkItemOperation;
import org.azd.exceptions.AzDException;
import org.azd.exceptions.ConnectionException;
import org.azd.helpers.JsonMapper;
import org.azd.workitemtracking.WorkItemTrackingApi;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.HashMap;

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
        var connection = new Connection(organization, project, token);
        w = new WorkItemTrackingApi(connection);
    }

    @Test
    public void shouldGetWorkItem() throws ConnectionException, AzDException {
        var expectedValue = "azure-devops-java-sdk";
        var result = w.getWorkItem(2).getFields().getSystemTeamProject();
        assertEquals(expectedValue, result);
    }

    @Test
    public void shouldGetWorkItemWithOptionalParameters() throws ConnectionException, AzDException {
        var expectedValue = "azure-devops-java-sdk";
        var result = w.getWorkItem(2, WorkItemExpand.ALL).getFields().getSystemTeamProject();
        assertEquals(expectedValue, result);
    }

    @Test
    public void shouldCreateAWorkItem() throws ConnectionException, AzDException {
        w.createWorkItem("user story", WorkItemOperation.ADD, "Sample User story",
                "Description for the user story", new String[]{"DevOps", "Java", "SDK"});
    }

    @Test
    public void shouldCreateAWorkItemWithAdditionalFields() throws ConnectionException, AzDException {
        var additionalFields = new HashMap<String, Object>(){{
            put("System.Tags", String.join(",", "DevOps", "Java", "SDK"));
        }};

        w.createWorkItem("user story", "Sample User story",
                "Description for the user story", additionalFields);
    }

    @Test(expected = AzDException.class)
    public void shouldDeleteAWorkItem() throws ConnectionException, AzDException {
        w.deleteWorkItem(6);
    }

    @Test
    public void shouldGetWorkItems() throws ConnectionException, AzDException {
        w.getWorkItems(new int[]{1,2,3});
    }

    @Test
    public void shouldGetWorkItemRevisions() throws ConnectionException, AzDException {
        var r = w.getWorkItemRevisions(3, WorkItemExpand.ALL)
                .getWorkItems().stream().findFirst().get()
                .getFields().getSystemAreaId();
        assertEquals(12, r);
    }

    @Test
    public void shouldGetWorkItemRevision() throws ConnectionException, AzDException {
        w.getWorkItemRevision(3, 1);
    }

    @Test
    public void shouldQueryWorkItems() throws ConnectionException, AzDException {
        var query = "Select * From WorkItems Where [System.WorkItemType] = 'User Story'";
        var team = "azure-devops-java-sdk Team";
        w.queryByWiql(team, query, 10, true).getWorkItems();
    }

    @Test
    public void shouldQueryWorkItemsAndGetExactlyOneResult() throws ConnectionException, AzDException {
        var query = "Select * From WorkItems Where [System.WorkItemType] = 'User Story'";
        var team = "azure-devops-java-sdk Team";
        var res = (long) w.queryByWiql(team, query, 1, true).getWorkItems().size();
        assertEquals(1, res);
    }

    @Test(expected = AzDException.class)
    public void shouldRemoveWorkItemFromRecycleBin() throws ConnectionException, AzDException {
        w.removeWorkItemFromRecycleBin(93);
    }

    @Test
    public void shouldGetWorkItemFromRecycleBin() throws ConnectionException, AzDException {
        w.getWorkItemFromRecycleBin(74);
    }

    @Test
    public void shouldGetDeletedWorkItemFromRecycleBin() throws ConnectionException, AzDException {
        w.getDeletedWorkItemsFromRecycleBin();
    }

    @Test(expected = AzDException.class)
    public void shouldGetDeletedWorkItemsFromRecycleBin() throws ConnectionException, AzDException {
        w.getDeletedWorkItemsFromRecycleBin(new int[]{71,72,73,74});
    }

    @Test(expected = AzDException.class)
    public void shouldRestoreWorkItemFromRecycleBin() throws ConnectionException, AzDException {
        w.restoreWorkItemFromRecycleBin(70);
    }

    @Test
    public void shouldUpdateAWorkItem() throws ConnectionException, AzDException {
        var fieldsToUpdate = new HashMap<String, Object>(){{
            put("System.AssignedTo", "test@xmail.com");
        }};

        w.updateWorkItem(161, fieldsToUpdate);
    }
}
