package org.azd;

import org.azd.build.BuildApi;
import org.azd.connection.Connection;
import org.azd.enums.SingleReleaseExpands;
import org.azd.exceptions.AzDException;
import org.azd.exceptions.ConnectionException;
import org.azd.helpers.JsonMapper;
import org.azd.interfaces.BuildDetails;
import org.azd.interfaces.ReleaseDetails;
import org.azd.release.ReleaseApi;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

public class ReleaseApiTest {
    private static final JsonMapper MAPPER = new JsonMapper();
    private static ReleaseDetails r;
    private static BuildDetails b;

    @Before
    public void init() throws AzDException {
        String dir = System.getProperty("user.dir");
        File file = new File(dir + "/src/test/java/org/azd/_unitTest.json");
        MockParameters m = MAPPER.mapJsonFromFile(file, MockParameters.class);
        String organization = m.getO();
        String token = m.getT();
        String project = m.getP();
        Connection defaultParameters = new Connection(organization, project, token);
        r = new ReleaseApi(defaultParameters);
        b = new BuildApi(defaultParameters);
    }

    @Test
    public void shouldCreateARelease() throws ConnectionException, AzDException {
        var build = b.getBuild(176);
        r.createRelease(2, "Sample Release", "_Demo-CI", build.getBuildNumber(),
                "Demo-CI", false);
    }

    @Test
    public void shouldGetAllReleases() throws ConnectionException, AzDException {
        r.getReleases();
    }

    @Test
    public void shouldGetARelease() throws ConnectionException, AzDException {
        r.getRelease(4);
    }

    @Test
    public void shouldGetReleaseEnvironmentDetails() throws ConnectionException, AzDException {
        var res = r.getRelease(4, SingleReleaseExpands.TASKS);
        r.getReleaseEnvironment(res.getId(), res.getEnvironments().stream().findFirst().get().getId());
    }

    @Test
    public void shouldGetAllReleaseDefinitions() throws ConnectionException, AzDException {
        r.getReleaseDefinitions();
    }

    @Test
    public void shouldGetAReleaseDefinition() throws ConnectionException, AzDException {
        r.getReleaseDefinition(2);
    }

    @Test
    public void shouldGetReleaseDefinitionHistory() throws ConnectionException, AzDException {
        r.getReleaseDefinitionHistory(2);
    }
}
