package org.azd.test;

import org.azd.common.ApiVersion;
import org.azd.connection.Connection;
import org.azd.enums.CustomHeader;
import org.azd.enums.RequestMethod;
import org.azd.exceptions.AzDException;
import org.azd.helpers.JsonMapper;
import org.azd.interfaces.TestDetails;
import org.azd.test.types.RunCreateModel;
import org.azd.test.types.TestRun;
import org.azd.test.types.TestRunStatistic;
import org.azd.test.types.TestRuns;

import java.util.HashMap;
import java.util.Map;

import static org.azd.common.ResourceId.TEST;
import static org.azd.utils.RestClient.send;

public class TestApi implements TestDetails {
    /**
     * Connection object
     */
    private final Connection CONNECTION;
    private final JsonMapper MAPPER = new JsonMapper();
    private final String AREA = "test";


    /***
     * Pass the connection object to work with Service hooks Api
     * @param connection Connection object
     */
    public TestApi(Connection connection) {
        this.CONNECTION = connection;
    }

    /**
     * Create new test run.
     *
     * @return TestRun Object {@link TestRun}
     * @throws AzDException Default Api Exception handler.
     **/
    @Override
    public TestRun createTestRun(RunCreateModel runCreateModel) throws AzDException {
        String r = send(RequestMethod.POST, CONNECTION, TEST, CONNECTION.getProject(),
                AREA + "/runs", null, null, ApiVersion.TEST_RUNS, null, runCreateModel, CustomHeader.JSON_CONTENT_TYPE);

        return MAPPER.mapJsonResponse(r, TestRun.class);
    }

    /**
     * Get a test run by its ID.
     *
     * @param runId ID of the run to get.
     * @return TestRun Object {@link TestRun}
     * @throws AzDException Default Api Exception handler.
     **/
    @Override
    public TestRun getTestRunById(int runId) throws AzDException {
        String r = send(RequestMethod.GET, CONNECTION, TEST, CONNECTION.getProject(),
                AREA + "/runs", String.valueOf(runId), null, ApiVersion.TEST_RUNS, null, null, null);

        return MAPPER.mapJsonResponse(r, TestRun.class);
    }

    /**
     * Get a list of test runs.
     *
     * @return TestRun Object {@link TestRun}
     * @throws AzDException Default Api Exception handler.
     **/
    @Override
    public TestRuns getTestRuns() throws AzDException {
        String r = send(RequestMethod.GET, CONNECTION, TEST, CONNECTION.getProject(),
                AREA + "/runs", null, null, ApiVersion.TEST_RUNS, null, null, null);

        return MAPPER.mapJsonResponse(r, TestRuns.class);
    }

    /**
     * Get a list of test runs.
     *
     * @param top Number of test runs to return.
     * @return TestRun Object {@link TestRun}
     * @throws AzDException Default Api Exception handler.
     **/
    @Override
    public TestRuns getTestRuns(int top) throws AzDException {
        String r = send(RequestMethod.GET, CONNECTION, TEST, CONNECTION.getProject(),
                AREA + "/runs", null, null, ApiVersion.TEST_RUNS, Map.of("$top", top), null, null);

        return MAPPER.mapJsonResponse(r, TestRuns.class);
    }

    /**
     * Get a list of test runs.
     *
     * @param buildUri URI of the build that the runs used.
     * @return TestRun Object {@link TestRun}
     * @throws AzDException Default Api Exception handler.
     **/
    @Override
    public TestRuns getTestRuns(String buildUri) throws AzDException {
        String r = send(RequestMethod.GET, CONNECTION, TEST, CONNECTION.getProject(),
                AREA + "/runs", null, null, ApiVersion.TEST_RUNS, Map.of("buildUri", buildUri), null, null);

        return MAPPER.mapJsonResponse(r, TestRuns.class);
    }

    /**
     * Get a list of test runs.
     *
     * @param skip Number of test runs to skip.
     * @param top Number of test runs to return.
     * @param automated If true, only returns automated runs.
     * @param buildUri URI of the build that the runs used.
     * @param includeRunDetails If true, include all the properties of the runs.
     * @param owner Team foundation ID of the owner of the runs.
     * @param planId ID of the test plan that the runs are a part of.
     * @param tmiRunId None
     * @return TestRun Object {@link TestRun}
     * @throws AzDException Default Api Exception handler.
     **/
    @Override
    public TestRuns getTestRuns(int skip, int top, boolean automated, String buildUri, boolean includeRunDetails,
                                String owner, int planId, String tmiRunId) throws AzDException {
        var q = new HashMap<String, Object>(){{
            put("$skip", skip);
            put("$top", top);
            put("automated", automated);
            put("buildUri", buildUri);
            put("includeRunDetails", includeRunDetails);
            put("owner", owner);
            put("planId", planId);
            put("tmiRunId", tmiRunId);
        }};

        String r = send(RequestMethod.GET, CONNECTION, TEST, CONNECTION.getProject(),
                AREA + "/runs", null, null, ApiVersion.TEST_RUNS, q, null, null);

        return MAPPER.mapJsonResponse(r, TestRuns.class);
    }

    /**
     * Get test run statistics , used when we want to get summary of a run by outcome.
     *
     * @param runId ID of the run to get.
     * @return TestRunStatistic Object {@link TestRunStatistic}
     * @throws AzDException Default Api Exception handler.
     **/
    @Override
    public TestRunStatistic getTestRunStatistics(int runId) throws AzDException {
        String r = send(RequestMethod.GET, CONNECTION, TEST, CONNECTION.getProject(),
                AREA + "/runs", Integer.toString(runId), "Statistics", ApiVersion.TEST_RUNS, null, null, null);

        return MAPPER.mapJsonResponse(r, TestRunStatistic.class);
    }

    /**
     * Delete a test run by its ID.
     *
     * @param runId ID of the run to delete.
     * @throws AzDException Default Api Exception handler.
     **/
    @Override
    public Void deleteTestRun(int runId) throws AzDException {
        try {
            String r = send(RequestMethod.DELETE, CONNECTION, TEST, CONNECTION.getProject(),
                    AREA + "/runs", Integer.toString(runId), null, ApiVersion.TEST_RUNS, null, null, null);
            if (!r.isEmpty()) MAPPER.mapJsonResponse(r, Map.class);
        } catch (AzDException e) {
            throw e;
        }
        return null;
    }
}
