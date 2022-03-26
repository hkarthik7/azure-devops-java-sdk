package org.azd;

import org.azd.enums.ReleaseApprovalStatus;
import org.azd.enums.SingleReleaseExpands;
import org.azd.exceptions.AzDException;
import org.azd.helpers.JsonMapper;
import org.azd.interfaces.AzDClient;
import org.azd.interfaces.BuildDetails;
import org.azd.interfaces.ReleaseDetails;
import org.azd.utils.AzDClientApi;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

public class ReleaseApiTest {
    private static final JsonMapper MAPPER = new JsonMapper();
    private static AzDClient webApi;
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
        webApi = new AzDClientApi(organization, project, token);
        r = webApi.getReleaseApi();
        b = webApi.getBuildApi();
    }

    @Test
    public void shouldCreateARelease() throws AzDException {
        var build = b.getBuild(176);
        r.createRelease(2, "Sample Release", "_Demo-CI", build.getBuildNumber(),
                "Demo-CI", false);
    }

    @Test
    public void shouldGetAllReleases() throws AzDException {
        r.getReleases();
    }

    @Test
    public void shouldGetARelease() throws AzDException {
        var rId = r.getReleases().getReleases().stream().findFirst().get().getId();
        r.getRelease(rId);
    }

    @Test
    public void shouldGetReleaseEnvironmentDetails() throws AzDException {
        var rId = r.getReleases().getReleases().stream().findFirst().get().getId();
        var res = r.getRelease(rId, SingleReleaseExpands.TASKS);
        r.getReleaseEnvironment(res.getId(), res.getEnvironments().stream().findFirst().get().getId());
    }

    @Test
    public void shouldGetAllReleaseDefinitions() throws AzDException {
        r.getReleaseDefinitions();
    }

    @Test
    public void shouldGetAReleaseDefinition() throws AzDException {
        r.getReleaseDefinition(2);
    }

    @Test
    public void shouldGetReleaseDefinitionHistory() throws AzDException {
        r.getReleaseDefinitionHistory(2);
    }

    @Test
    public void shouldDeleteARelease() throws AzDException {
        var build = b.getBuild(176);
        var release = r.createRelease(2, "Sample Release", "_Demo-CI", build.getBuildNumber(),
                "Demo-CI", false);
        r.deleteRelease(release.getId());
    }

    @Test(expected = AzDException.class)
    public void shouldQueueAReleaseWithEnvironmentName() throws AzDException {
        r.queueRelease(354, "D");
    }

    @Test(expected = AzDException.class)
    public void shouldAbandonARelease() throws AzDException {
        // Expected :- InvalidRequestException: VS402966: Transitioning of release from state 'Abandoned' to state 'Abandoned' is not allowed.
        r.abandonRelease(355);
    }

    @Test
    public void shouldGetReleaseApprovals() throws AzDException {
        r.getReleaseApprovals();
    }

    @Test(expected = AzDException.class)
    public void shouldUpdateReleaseApprovals() throws AzDException {
        r.updateApproval(2, ReleaseApprovalStatus.APPROVED, "Good to go");
    }

    @Test
    public void shouldGetManualInterventions() throws AzDException {
        r.getManualInterventions(490);
    }
}
