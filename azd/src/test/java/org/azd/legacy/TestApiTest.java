package org.azd.legacy;

import org.azd.exceptions.AzDException;
import org.azd.helpers.JsonMapper;
import org.azd.interfaces.AzDClient;
import org.azd.interfaces.TestDetails;
import org.azd.test.TestApi;
import org.azd.test.types.TestCaseResults;
import org.azd.utils.AzDClientApi;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

public class TestApiTest {
    private static final JsonMapper MAPPER = new JsonMapper();
    private static AzDClient webApi;
    private static TestDetails t;

    @Before
    public void init() throws AzDException {
        String dir = System.getProperty("user.dir");
        File file = new File(dir + "/src/test/java/org/azd/_unitTest.json");
        MockParameters m = MAPPER.mapJsonFromFile(file, MockParameters.class);
        String organization = m.getO();
        String token = m.getT();
        String project = m.getP();
        webApi = new AzDClientApi(organization, project, token);
        t = webApi.getTestApi();
    }

    @Test
    public void shouldGetATestRun() throws AzDException {
        t.getTestRunById(424);
    }

    @Test
    public void shouldListAllTestRuns() throws AzDException {
        t.getTestRuns().getTestRuns().stream().filter(id -> id.getId().equals(424)).findFirst().get();
    }

    @Test
    public void shouldGetATestRunStatistics() throws AzDException {
        t.getTestRunStatistics(424);
    }

    @Test(expected = AzDException.class)
    public void shouldDeleteATestRun() throws AzDException {
        t.deleteTestRun(222334);
    }

    @Test
    public void shouldUpdateATestResults() throws AzDException {
        t.updateTestResults(424, new TestCaseResults());
    }
}
