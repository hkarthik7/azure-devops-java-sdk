package org.azd.unittests;

import org.azd.UnitTestConfiguration;
import org.azd.abstractions.InstanceFactory;
import org.azd.abstractions.serializer.SerializerContext;
import org.azd.authentication.PersonalAccessTokenCredential;
import org.azd.enums.Instance;
import org.azd.exceptions.AzDException;
import org.azd.legacy.MockParameters;
import org.azd.serviceclient.AzDService;
import org.azd.serviceclient.AzDServiceClient;
import org.azd.test.TestRequestBuilder;
import org.azd.test.types.TestCaseResult;
import org.azd.test.types.TestCaseResults;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;

public class TestRequestBuilderTest {
    private static final SerializerContext serializer = InstanceFactory.createSerializerContext();
    private static AzDServiceClient client;
    private static UnitTestConfiguration testConfiguration;
    private static TestRequestBuilder t;

    @Before
    public void init() throws AzDException {
        String dir = System.getProperty("user.dir");
        var file = new File(dir + "/src/test/java/org/azd/_unitTest.json");
        var configFile = new File(dir + "/src/test/java/org/azd/config.json");
        var m = serializer.deserialize(file, MockParameters.class);
        testConfiguration = serializer.deserialize(configFile, UnitTestConfiguration.class);
        String organization = m.getO();
        String token = m.getT();
        String project = m.getP();
        var pat = new PersonalAccessTokenCredential(Instance.BASE_INSTANCE.append(organization), project, token);
        client = AzDService.builder()
                .authentication(pat)
                .buildClient();
        t = client.test();
    }

    @Test
    public void shouldGetATestRun() throws AzDException {
        t.runs().get(424);
    }

    @Test
    public void shouldListAllTestRuns() throws AzDException {
        t.runs().list()
                .getTestRuns()
                .stream()
                .filter(id -> id.getId().equals(424))
                .findFirst()
                .get();
    }

    @Test
    public void shouldGetATestRunStatistics() throws AzDException {
        t.runs().getStatistics(424);
    }

    @Test(expected = AzDException.class)
    public void shouldDeleteATestRun() throws AzDException {
        t.runs().delete(222334);
    }

    @Test
    public void shouldUpdateATestResults() throws AzDException {
        var testCaseResults = new TestCaseResults();
        testCaseResults.setResults(new ArrayList<>());
        var testCaseResult = new TestCaseResult();
        testCaseResult.setId(100000);
        testCaseResult.setOutcome("Passed");
        testCaseResults.getResults().add(testCaseResult);
        t.results().update(4206, testCaseResults);
    }

    @Test
    public void shouldGetListOfTestResults() throws AzDException {
        var results = t.results().list(4206);
        Assert.assertNotNull(results);
    }

    @Test
    public void shouldGetTestResult() throws AzDException {
        var result = t.results().get(4206, 100000);
        Assert.assertNotNull(result);
    }

    @Test
    public void shouldCreateTestResult() throws AzDException {
        var testCaseResults = new TestCaseResults();
        testCaseResults.setResults(new ArrayList<>());
        var testCaseResult = new TestCaseResult();
        testCaseResult.setId(100001);
        testCaseResult.setOutcome("Passed");
        testCaseResults.getResults().add(testCaseResult);
        var result = t.results().create(4206, testCaseResults);
        Assert.assertNotNull(result);
    }
}
