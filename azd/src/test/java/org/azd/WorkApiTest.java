package org.azd;

import org.azd.enums.IterationsTimeFrame;
import org.azd.exceptions.AzDException;
import org.azd.helpers.JsonMapper;
import org.azd.interfaces.AzDClient;
import org.azd.utils.AzDClientApi;
import org.azd.work.WorkApi;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertEquals;

public class WorkApiTest {
    private static final JsonMapper MAPPER = new JsonMapper();
    private static AzDClient webApi;
    private static WorkApi w;

    @Before
    public void init() throws AzDException {
        String dir = System.getProperty("user.dir");
        File file = new File(dir + "/src/test/java/org/azd/_unitTest.json");
        MockParameters m = MAPPER.mapJsonFromFile(file, MockParameters.class);
        String organization = m.getO();
        String token = m.getT();
        String project = m.getP();
        webApi = new AzDClientApi(organization, project, token);
        w = webApi.getWorkApi();
    }

    @Test
    public void shouldGetTeamIterations() throws AzDException {
        w.getTeamSettingsIterations("azure-devops-java-sdk Team");
    }

    @Test
    public void shouldGetTeamIterationsWithTimeFrame() throws AzDException {
        var res = w.getTeamSettingsIterations("azure-devops-java-sdk Team", IterationsTimeFrame.CURRENT);
        assertEquals("Sprint 1", res.getIterations().stream().findFirst().get().getName());
    }

    @Test
    public void shouldGetTeamIterationWorkItems() throws AzDException {
        var id = w.getTeamSettingsIterations("azure-devops-java-sdk Team").getIterations().stream().findFirst().get().getId();
        var res = w.getTeamIterationWorkItems("azure-devops-java-sdk Team", id);
        res.get_links();
    }

    @Test
    public void shouldGetATeamIteration() throws AzDException {
        var id = w.getTeamSettingsIterations("azure-devops-java-sdk Team")
                .getIterations().stream().findFirst().get().getId();
        w.getTeamSettingsIteration("azure-devops-java-sdk Team", id);
    }

    @Test(expected = AzDException.class)
    public void shouldDeleteATeamIteration() throws AzDException {
        w.deleteTeamSettingsIteration("azure-devops-java-sdk Team", "0000-00000-00000-00000-00000");
    }
}
