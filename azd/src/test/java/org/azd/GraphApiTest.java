package org.azd;

import org.azd.exceptions.AzDException;
import org.azd.helpers.JsonMapper;
import org.azd.interfaces.AzDClient;
import org.azd.interfaces.GraphDetails;
import org.azd.utils.AzDClientApi;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertEquals;

public class GraphApiTest {
    private static final JsonMapper MAPPER = new JsonMapper();
    private static AzDClient webApi;
    private static GraphDetails g;

    @Before
    public void init() throws AzDException {
        String dir = System.getProperty("user.dir");
        File file = new File(dir + "/src/test/java/org/azd/_unitTest.json");
        MockParameters m = MAPPER.mapJsonFromFile(file, MockParameters.class);
        String organization = m.getO();
        String token = m.getT();
        String project = m.getP();
        webApi = new AzDClientApi(organization, project, token);
        g = webApi.getGraphApi();
    }

    @Test
    public void shouldGetGraphUsers() throws AzDException {
        g.getUsers().getUsers();
    }

    @Test
    public void shouldGetAGraphUser() throws AzDException {
        var user = g.getUsers().getUsers().stream().findFirst().get();
        var descriptor = user.getDescriptor();
        assertEquals(descriptor, g.getUser(descriptor).getDescriptor());
    }

    @Test
    public void shouldCreateAGraphUsers() throws AzDException {
        var user = g.getUsers().getUsers().stream().findFirst().get();
        var descriptor = user.getDescriptor();
        var emailId = "test@gmail.com";
        g.createUser(emailId, descriptor);
    }

    @Test
    public void shouldGetGraphGroups() throws AzDException {
        var group = g.getGroups().getGraphGroups().stream().filter(x -> x.getDisplayName().equals("Contributors")).findFirst().get();
        var expectedValue = "Contributors";
        assertEquals(expectedValue, group.getDisplayName());
    }

    @Test
    public void shouldGetAGraphGroup() throws AzDException {
        var group = g.getGroups().getGraphGroups().stream().filter(x -> x.getDisplayName().equals("Contributors")).findFirst().get();
        g.getGroup(group.getDescriptor());
    }

    @Test
    public void shouldAddAUserToGroup() throws AzDException {
        var group = g.getGroups().getGraphGroups().stream().filter(x -> x.getDisplayName().equals("Contributors")).findFirst().get();
        var emailId = "test@gmail.com";
        g.addUserToGroup(emailId, group.getDescriptor());
    }

    @Test
    public void shouldDeleteAUser() throws AzDException {
        var user = g.getUser("msa.YWE3YWY5MzQtYzcxMi03ODliLWJkMDEtZmRhMWQ4NjEzN2Rh");
        g.deleteUser(user.getDescriptor());
    }
}
