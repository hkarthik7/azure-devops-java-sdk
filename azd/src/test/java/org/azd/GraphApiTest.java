package org.azd;

import org.azd.exceptions.AzDException;
import org.azd.exceptions.ConnectionException;
import org.azd.graph.GraphApi;
import org.azd.helpers.JsonMapper;
import org.azd.interfaces.GraphDetails;
import org.azd.connection.Connection;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertEquals;

public class GraphApiTest {
    private static final JsonMapper MAPPER = new JsonMapper();
    private static GraphDetails g;

    @Before
    public void init() throws AzDException {
        String dir = System.getProperty("user.dir");
        File file = new File(dir + "/src/test/java/org/azd/_unitTest.json");
        MockParameters m = MAPPER.mapJsonFromFile(file, MockParameters.class);
        String organization = m.getO();
        String token = m.getT();
        String project = m.getP();
        Connection defaultParameters = new Connection(organization, project, token);
        g = new GraphApi(defaultParameters);
    }

    @Test
    public void shouldGetGraphUsers() throws ConnectionException, AzDException {
        g.getUsers().getUsers();
    }

    @Test
    public void shouldGetAGraphUser() throws ConnectionException, AzDException {
        var user = g.getUsers().getUsers().stream().findFirst().get();
        var descriptor = user.getDescriptor();
        assertEquals(descriptor, g.getUser(descriptor).getDescriptor());
    }

    @Test
    public void shouldCreateAGraphUsers() throws ConnectionException, AzDException {
        var user = g.getUsers().getUsers().stream().findFirst().get();
        var descriptor = user.getDescriptor();
        var emailId = "test@gmail.com";
        g.createUser(emailId, descriptor);
    }

    @Test
    public void shouldGetGraphGroups() throws ConnectionException, AzDException {
        var group = g.getGroups().getGraphGroups().stream().filter(x -> x.getDisplayName().equals("Contributors")).findFirst().get();
        var expectedValue = "Contributors";
        assertEquals(expectedValue, group.getDisplayName());
    }

    @Test
    public void shouldGetAGraphGroup() throws ConnectionException, AzDException {
        var group = g.getGroups().getGraphGroups().stream().filter(x -> x.getDisplayName().equals("Contributors")).findFirst().get();
        g.getGroup(group.getDescriptor());
    }

    @Test
    public void shouldAddAUserToGroup() throws ConnectionException, AzDException {
        var group = g.getGroups().getGraphGroups().stream().filter(x -> x.getDisplayName().equals("Contributors")).findFirst().get();
        var emailId = "test@gmail.com";
        g.addUserToGroup(emailId, group.getDescriptor());
    }

    @Test
    public void shouldDeleteAUser() throws ConnectionException, AzDException {
        var user = g.getUser("msa.YWE3YWY5MzQtYzcxMi03ODliLWJkMDEtZmRhMWQ4NjEzN2Rh");
        g.deleteUser(user.getDescriptor());
    }
}
