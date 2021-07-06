package org.azd;

import org.azd.enums.IterationsTimeFrame;
import org.azd.exceptions.AzDException;
import org.azd.exceptions.ConnectionException;
import org.azd.helpers.JsonMapper;
import org.azd.connection.Connection;
import org.azd.work.WorkApi;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertEquals;

public class WorkApiTest {
    private static final JsonMapper MAPPER = new JsonMapper();
    private static WorkApi w;

    @Before
    public void init() throws AzDException {
        String dir = System.getProperty("user.dir");
        File file = new File(dir + "/src/test/java/org/azd/_unitTest.json");
        MockParameters m = MAPPER.mapJsonFromFile(file, MockParameters.class);
        String organization = m.getO();
        String token = m.getT();
        String project = m.getP();
        Connection defaultParameters = new Connection(organization, project, token);
        w = new WorkApi(defaultParameters);
    }

    @Test
    public void shouldGetTeamIterations() throws ConnectionException, AzDException {
        w.getTeamSettingsIterations("azure-devops-java-sdk Team");
    }

    @Test
    public void shouldGetTeamIterationsWithTimeFrame() throws ConnectionException, AzDException {
        var res = w.getTeamSettingsIterations("azure-devops-java-sdk Team", IterationsTimeFrame.CURRENT);
        assertEquals("Sprint 1", res.getIterations().stream().findFirst().get().getName());
    }

    @Test
    public void shouldGetTeamIterationWorkItems() throws ConnectionException, AzDException {
        var id = w.getTeamSettingsIterations("azure-devops-java-sdk Team").getIterations().stream().findFirst().get().getId();
        var res = w.getTeamIterationWorkItems("azure-devops-java-sdk Team", id);
        res.get_links();
    }

    @Test
    public void shouldGetATeamIteration() throws ConnectionException, AzDException {
        var id = w.getTeamSettingsIterations("azure-devops-java-sdk Team")
                .getIterations().stream().findFirst().get().getId();
        w.getTeamSettingsIteration("azure-devops-java-sdk Team", id);
    }

    @Test(expected = AzDException.class)
    public void shouldDeleteATeamIteration() throws ConnectionException, AzDException {
        w.deleteTeamSettingsIteration("azure-devops-java-sdk Team", "0000-00000-00000-00000-00000");
    }
}
