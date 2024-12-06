package org.azd.test;

import org.azd.common.ApiVersion;
import org.azd.connection.Connection;
import org.azd.enums.CustomHeader;
import org.azd.enums.RequestMethod;
import org.azd.enums.TestRunPublishContext;
import org.azd.enums.TestRunState;
import org.azd.exceptions.AzDException;
import org.azd.helpers.JsonMapper;
import org.azd.interfaces.TestDetails;
import org.azd.test.types.*;

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


    /**
     * Pass the connection object to work with Service hooks Api
     *
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
     * @param skip              Number of test runs to skip.
     * @param top               Number of test runs to return.
     * @param automated         If true, only returns automated runs.
     * @param buildUri          URI of the build that the runs used.
     * @param includeRunDetails If true, include all the properties of the runs.
     * @param owner             Team foundation ID of the owner of the runs.
     * @param planId            ID of the test plan that the runs are a part of.
     * @param tmiRunId          None
     * @return TestRun Object {@link TestRun}
     * @throws AzDException Default Api Exception handler.
     **/
    @Override
    public TestRuns getTestRuns(int skip, int top, boolean automated, String buildUri, boolean includeRunDetails,
                                String owner, int planId, String tmiRunId) throws AzDException {
        var q = new HashMap<String, Object>() {{
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

    /**
     * Query Test Runs based on filters. Mandatory fields are minLastUpdatedDate and maxLastUpdatedDate.
     *
     * @param maxLastUpdatedDate Maximum Last Modified Date of run to be queried (Mandatory, difference between min and max date can be atmost 7 days).
     * @param minLastUpdatedDate Minimum Last Modified Date of run to be queried (Mandatory).
     * @return TestRuns Object {@link TestRuns}
     * @throws AzDException Default Api Exception handler.
     **/
    @Override
    public TestRuns queryTestRuns(String maxLastUpdatedDate, String minLastUpdatedDate) throws AzDException {
        var q = new HashMap<String, Object>() {{
            put("maxLastUpdatedDate", maxLastUpdatedDate);
            put("minLastUpdatedDate", minLastUpdatedDate);
        }};

        String r = send(RequestMethod.GET, CONNECTION, TEST, CONNECTION.getProject(),
                AREA + "/runs", null, null, ApiVersion.TEST_RUNS, q, null, null);

        return MAPPER.mapJsonResponse(r, TestRuns.class);
    }

    /**
     * Query Test Runs based on filters. Mandatory fields are minLastUpdatedDate and maxLastUpdatedDate.
     *
     * @param maxLastUpdatedDate Maximum Last Modified Date of run to be queried (Mandatory, difference between min and max date can be atmost 7 days).
     * @param minLastUpdatedDate Minimum Last Modified Date of run to be queried (Mandatory).
     * @param top                Number of runs to be queried. Limit is 100.
     * @return TestRuns Object {@link TestRuns}
     * @throws AzDException Default Api Exception handler.
     **/
    @Override
    public TestRuns queryTestRuns(String maxLastUpdatedDate, String minLastUpdatedDate, int top) throws AzDException {
        var q = new HashMap<String, Object>() {{
            put("maxLastUpdatedDate", maxLastUpdatedDate);
            put("minLastUpdatedDate", minLastUpdatedDate);
            put("$top", top);
        }};

        String r = send(RequestMethod.GET, CONNECTION, TEST, CONNECTION.getProject(),
                AREA + "/runs", null, null, ApiVersion.TEST_RUNS, q, null, null);

        return MAPPER.mapJsonResponse(r, TestRuns.class);
    }

    /**
     * Query Test Runs based on filters. Mandatory fields are minLastUpdatedDate and maxLastUpdatedDate.
     *
     * @param maxLastUpdatedDate Maximum Last Modified Date of run to be queried (Mandatory, difference between min and max date can be atmost 7 days).
     * @param minLastUpdatedDate Minimum Last Modified Date of run to be queried (Mandatory).
     * @param buildIds           Build Ids of the Runs to be queried, comma separated list of valid ids (limit no. of ids 10).
     * @return TestRuns Object {@link TestRuns}
     * @throws AzDException Default Api Exception handler.
     **/
    @Override
    public TestRuns queryTestRuns(String maxLastUpdatedDate, String minLastUpdatedDate, String[] buildIds) throws AzDException {
        var q = new HashMap<String, Object>() {{
            put("maxLastUpdatedDate", maxLastUpdatedDate);
            put("minLastUpdatedDate", minLastUpdatedDate);
        }};

        if (buildIds.length > 0) q.put("buildIds", String.join(",", buildIds));

        String r = send(RequestMethod.GET, CONNECTION, TEST, CONNECTION.getProject(),
                AREA + "/runs", null, null, ApiVersion.TEST_RUNS, q, null, null);

        return MAPPER.mapJsonResponse(r, TestRuns.class);
    }

    /**
     * Query Test Runs based on filters. Mandatory fields are minLastUpdatedDate and maxLastUpdatedDate.
     *
     * @param maxLastUpdatedDate Maximum Last Modified Date of run to be queried (Mandatory, difference between min and max date can be atmost 7 days).
     * @param minLastUpdatedDate Minimum Last Modified Date of run to be queried (Mandatory).
     * @param testRunState       Current state of the Runs to be queried.
     * @return TestRuns Object {@link TestRuns}
     * @throws AzDException Default Api Exception handler.
     **/
    @Override
    public TestRuns queryTestRuns(String maxLastUpdatedDate, String minLastUpdatedDate, TestRunState testRunState) throws AzDException {
        var q = new HashMap<String, Object>() {{
            put("maxLastUpdatedDate", maxLastUpdatedDate);
            put("minLastUpdatedDate", minLastUpdatedDate);
            put("state", testRunState);
        }};

        String r = send(RequestMethod.GET, CONNECTION, TEST, CONNECTION.getProject(),
                AREA + "/runs", null, null, ApiVersion.TEST_RUNS, q, null, null);

        return MAPPER.mapJsonResponse(r, TestRuns.class);
    }

    /**
     * Query Test Runs based on filters. Mandatory fields are minLastUpdatedDate and maxLastUpdatedDate.
     *
     * @param maxLastUpdatedDate Maximum Last Modified Date of run to be queried (Mandatory, difference between min and max date can be atmost 7 days).
     * @param minLastUpdatedDate Minimum Last Modified Date of run to be queried (Mandatory).
     * @param branchName         Source Branch name of the Runs to be queried.
     * @param buildDefIds        Build Definition Ids of the Runs to be queried, comma separated list of valid ids (limit no. of ids 10).
     * @param continuationToken  continuationToken received from previous batch or null for first batch.
     *                           It is not supposed to be created (or altered, if received from last batch) by user.
     * @param isAutomated        Automation type of the Runs to be queried.
     * @param planIds            Plan Ids of the Runs to be queried, comma separated list of valid ids (limit no. of ids 10).
     * @param publishContext     PublishContext of the Runs to be queried.
     * @param releaseDefIds      Release Definition Ids of the Runs to be queried, comma separated list of valid ids (limit no. of ids 10).
     * @param releaseEnvDefIds   Release Environment Definition Ids of the Runs to be queried, comma separated list of valid ids (limit no. of ids 10).
     * @param releaseEnvIds      Release Environment Ids of the Runs to be queried, comma separated list of valid ids (limit no. of ids 10).
     * @param releaseIds         Release Ids of the Runs to be queried, comma separated list of valid ids (limit no. of ids 10).
     * @param runTitle           Run Title of the Runs to be queried.
     * @return TestRuns Object {@link TestRuns}
     * @throws AzDException Default Api Exception handler.
     **/
    @Override
    public TestRuns queryTestRuns(String maxLastUpdatedDate, String minLastUpdatedDate, String branchName,
                                  String[] buildDefIds, String continuationToken, boolean isAutomated,
                                  String[] planIds, TestRunPublishContext publishContext, String[] releaseDefIds,
                                  String[] releaseEnvDefIds, String[] releaseEnvIds, String[] releaseIds,
                                  String runTitle) throws AzDException {
        var q = new HashMap<String, Object>() {{
            put("maxLastUpdatedDate", maxLastUpdatedDate);
            put("minLastUpdatedDate", minLastUpdatedDate);
            put("isAutomated", isAutomated);
            put("publishContext", publishContext);
        }};

        if (branchName != null) q.put("branchName", branchName);
        if (buildDefIds.length > 0) q.put("buildDefIds", buildDefIds);
        if (continuationToken != null) q.put("continuationToken", continuationToken);
        if (planIds.length > 0) q.put("branchName", branchName);
        if (releaseEnvDefIds.length > 0) q.put("releaseEnvDefIds", String.join(",", releaseEnvDefIds));
        if (releaseEnvIds.length > 0) q.put("releaseEnvIds", String.join(",", releaseEnvIds));
        if (releaseDefIds.length > 0) q.put("releaseDefIds", releaseDefIds);
        if (releaseIds.length > 0) q.put("releaseIds", releaseIds);
        if (runTitle != null) q.put("runTitle", runTitle);


        String r = send(RequestMethod.GET, CONNECTION, TEST, CONNECTION.getProject(),
                AREA + "/runs", null, null, ApiVersion.TEST_RUNS, q, null, null);

        return MAPPER.mapJsonResponse(r, TestRuns.class);
    }

    /**
     * Update test run by its ID.
     *
     * @param runId   ID of the run to update.
     * @param testRun {@link TestRun} object.
     * @return TestRun Object {@link TestRun}
     * @throws AzDException Default Api exception handler.
     */
    @Override
    public TestRun updateTestRun(int runId, TestRun testRun) throws AzDException {
        String r = send(RequestMethod.GET, CONNECTION, TEST, CONNECTION.getProject(),
                AREA + "/runs", String.valueOf(runId), null, ApiVersion.TEST_RUNS, null, testRun,
                CustomHeader.JSON_CONTENT_TYPE);

        return MAPPER.mapJsonResponse(r, TestRun.class);
    }

    /**
     * Update test case results by run ID.
     *
     * @param runId             ID of the run to update.
     * @param testCaseResults   {@link TestCaseResults} object.
     * @return TestCaseResults Object {@link TestCaseResults}
     * @throws AzDException Default Api exception handler.
     */
    @Override
    public TestCaseResults updateTestResults(int runId, TestCaseResults testCaseResults) throws AzDException {
        String r = send(RequestMethod.PATCH, CONNECTION, TEST, CONNECTION.getProject(),
                AREA + "/runs", String.valueOf(runId), "results", ApiVersion.TEST_RUNS, null, testCaseResults.getResults(),
                CustomHeader.JSON_CONTENT_TYPE);

        return MAPPER.mapJsonResponse(r, TestCaseResults.class);
    }
}
