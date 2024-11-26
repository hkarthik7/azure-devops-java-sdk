package org.azd.test.runs;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.abstractions.QueryParameter;
import org.azd.authentication.AccessTokenCredential;
import org.azd.common.ApiVersion;
import org.azd.enums.TestRunPublishContext;
import org.azd.enums.TestRunState;
import org.azd.exceptions.AzDException;
import org.azd.test.types.RunCreateModel;
import org.azd.test.types.TestRun;
import org.azd.test.types.TestRunStatistic;
import org.azd.test.types.TestRuns;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

/**
 * Provides functionality to work with Test runs Api.
 */
public class RunsRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public RunsRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential, "test", "cadb3810-d47d-4a3c-a234-fe5f3be50138", ApiVersion.TEST_RUNS);
    }

    /**
     * Create new test run.
     *
     * @param runCreateModel Run create model object to create a test run.
     * @return TestRun Object {@link TestRun}
     * @throws AzDException Default Api Exception handler.
     **/
    public CompletableFuture<TestRun> createAsync(RunCreateModel runCreateModel) throws AzDException {
        return builder()
                .POST(runCreateModel)
                .build()
                .executeAsync(TestRun.class);
    }

    /**
     * Delete a test run by its ID.
     *
     * @param runId ID of the run to delete.
     * @throws AzDException Default Api Exception handler.
     **/
    public CompletableFuture<Void> deleteAsync(int runId) throws AzDException {
        return builder()
                .DELETE()
                .serviceEndpoint("runId", runId)
                .build()
                .executePrimitiveAsync();
    }

    /**
     * Get a test run by its ID.
     *
     * @param runId ID of the run to get.
     * @return TestRun Object {@link TestRun}
     * @throws AzDException Default Api Exception handler.
     **/
    public CompletableFuture<TestRun> getAsync(int runId) throws AzDException {
        return builder()
                .serviceEndpoint("runId", runId)
                .build()
                .executeAsync(TestRun.class);
    }

    /**
     * Get a test run by its ID.
     *
     * @param runId          ID of the run to get.
     * @param includeDetails Default value is true. It includes details like run statistics, release, build,
     *                       test environment, post process state, and more.
     * @return TestRun Object {@link TestRun}
     * @throws AzDException Default Api Exception handler.
     **/
    public CompletableFuture<TestRun> getAsync(int runId, boolean includeDetails) throws AzDException {
        return builder()
                .serviceEndpoint("runId", runId)
                .query("includeDetails", includeDetails)
                .build()
                .executeAsync(TestRun.class);
    }

    /**
     * Get test run statistics , used when we want to get summary of a run by outcome.
     *
     * @param runId ID of the run to get.
     * @return TestRunStatistic Object {@link TestRunStatistic}
     * @throws AzDException Default Api Exception handler.
     **/
    public CompletableFuture<TestRunStatistic> getStatisticsAsync(int runId) throws AzDException {
        return builder()
                .location("0a42c424-d764-4a16-a2d5-5c85f87d0ae8")
                .serviceEndpoint("runId", runId)
                .build()
                .executeAsync(TestRunStatistic.class);
    }

    /**
     * Get a list of test runs.
     *
     * @return Collection of TestRun Object {@link TestRuns}
     * @throws AzDException Default Api Exception handler.
     **/
    public CompletableFuture<TestRuns> listAsync() throws AzDException {
        return builder()
                .build()
                .executeAsync(TestRuns.class);
    }

    /**
     * Get a list of test runs.
     *
     * @param requestConfiguration Represents the query parameters.
     * @return Collection of TestRun Object {@link TestRuns}
     * @throws AzDException Default Api Exception handler.
     **/
    public CompletableFuture<TestRuns> listAsync(Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .executeAsync(TestRuns.class);
    }

    /**
     * Query Test Runs based on filters. Mandatory fields are minLastUpdatedDate and maxLastUpdatedDate.
     *
     * @param requestConfiguration Represents the query parameters.
     * @return Collection of TestRun Object {@link TestRuns}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<TestRuns> queryAsync(Consumer<QueryRequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .query(QueryRequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .executeAsync(TestRuns.class);
    }

    /**
     * Update test run by its ID.
     *
     * @param runId   ID of the run to update.
     * @param testRun Test run object to update.
     * @return Test run objet {@link TestRun}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<TestRun> updateAsync(int runId, TestRun testRun) throws AzDException {
        return builder()
                .PATCH(testRun)
                .serviceEndpoint("runId", runId)
                .build()
                .executeAsync(TestRun.class);
    }

    /**
     * Create new test run.
     *
     * @param runCreateModel Run create model object to create a test run.
     * @return TestRun Object {@link TestRun}
     * @throws AzDException Default Api Exception handler.
     **/
    public TestRun create(RunCreateModel runCreateModel) throws AzDException {
        return builder()
                .POST(runCreateModel)
                .build()
                .execute(TestRun.class);
    }

    /**
     * Delete a test run by its ID.
     *
     * @param runId ID of the run to delete.
     * @throws AzDException Default Api Exception handler.
     **/
    public Void delete(int runId) throws AzDException {
        return builder()
                .DELETE()
                .serviceEndpoint("runId", runId)
                .build()
                .executePrimitive();
    }

    /**
     * Get a test run by its ID.
     *
     * @param runId ID of the run to get.
     * @return TestRun Object {@link TestRun}
     * @throws AzDException Default Api Exception handler.
     **/
    public TestRun get(int runId) throws AzDException {
        return builder()
                .serviceEndpoint("runId", runId)
                .build()
                .execute(TestRun.class);
    }

    /**
     * Get a test run by its ID.
     *
     * @param runId          ID of the run to get.
     * @param includeDetails Default value is true. It includes details like run statistics, release, build,
     *                       test environment, post process state, and more.
     * @return TestRun Object {@link TestRun}
     * @throws AzDException Default Api Exception handler.
     **/
    public TestRun get(int runId, boolean includeDetails) throws AzDException {
        return builder()
                .serviceEndpoint("runId", runId)
                .query("includeDetails", includeDetails)
                .build()
                .execute(TestRun.class);
    }

    /**
     * Get test run statistics , used when we want to get summary of a run by outcome.
     *
     * @param runId ID of the run to get.
     * @return TestRunStatistic Object {@link TestRunStatistic}
     * @throws AzDException Default Api Exception handler.
     **/
    public TestRunStatistic getStatistics(int runId) throws AzDException {
        return builder()
                .location("0a42c424-d764-4a16-a2d5-5c85f87d0ae8")
                .serviceEndpoint("runId", runId)
                .build()
                .execute(TestRunStatistic.class);
    }

    /**
     * Get a list of test runs.
     *
     * @return Collection of TestRun Object {@link TestRuns}
     * @throws AzDException Default Api Exception handler.
     **/
    public TestRuns list() throws AzDException {
        return builder()
                .build()
                .execute(TestRuns.class);
    }

    /**
     * Get a list of test runs.
     *
     * @param requestConfiguration Represents the query parameters.
     * @return Collection of TestRun Object {@link TestRuns}
     * @throws AzDException Default Api Exception handler.
     **/
    public TestRuns list(Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .execute(TestRuns.class);
    }

    /**
     * Query Test Runs based on filters. Mandatory fields are minLastUpdatedDate and maxLastUpdatedDate.
     *
     * @param requestConfiguration Represents the query parameters.
     * @return Collection of TestRun Object {@link TestRuns}
     * @throws AzDException Default Api Exception handler.
     */
    public TestRuns query(Consumer<QueryRequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .query(QueryRequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .execute(TestRuns.class);
    }

    /**
     * Update test run by its ID.
     *
     * @param runId   ID of the run to update.
     * @param testRun Test run object to update.
     * @return Test run objet {@link TestRun}
     * @throws AzDException Default Api Exception handler.
     */
    public TestRun update(int runId, TestRun testRun) throws AzDException {
        return builder()
                .PATCH(testRun)
                .serviceEndpoint("runId", runId)
                .build()
                .execute(TestRun.class);
    }

    /**
     * Represents the query parameters.
     */
    public static class QueryParameters {
        /**
         * Maximum Last Modified Date of run to be queried (Mandatory, difference between min and max date can be atmost 7 days).
         */
        @QueryParameter(name = "maxLastUpdatedDate")
        public String maxLastUpdatedDate;
        /**
         * Minimum Last Modified Date of run to be queried (Mandatory).
         */
        @QueryParameter(name = "minLastUpdatedDate")
        public String minLastUpdatedDate;
        /**
         * Number of runs to be queried. Limit is 100
         */
        @QueryParameter(name = "$top")
        public Integer top;
        /**
         * Source Branch name of the Runs to be queried.
         */
        @QueryParameter(name = "branchName")
        public String branchName;
        /**
         * Build Definition Ids of the Runs to be queried, comma separated list of valid ids (limit no. of ids 10).
         */
        @QueryParameter(name = "buildDefIds")
        public Integer[] buildDefIds;
        /**
         * Build Ids of the Runs to be queried, comma separated list of valid ids (limit no. of ids 10).
         */
        @QueryParameter(name = "buildIds")
        public Integer[] buildIds;
        /**
         * continuationToken received from previous batch or null for first batch. It is not supposed to be created (or altered, if received from last batch) by user.
         */
        @QueryParameter(name = "continuationToken")
        public String continuationToken;
        /**
         * Automation type of the Runs to be queried.
         */
        @QueryParameter(name = "isAutomated")
        public Boolean isAutomated;
        /**
         * Plan Ids of the Runs to be queried, comma separated list of valid ids (limit no. of ids 10).
         */
        @QueryParameter(name = "planIds")
        public Integer[] planIds;
        /**
         * PublishContext of the Runs to be queried.
         */
        @QueryParameter(name = "publishContext")
        public TestRunPublishContext publishContext;
        /**
         * Release Definition Ids of the Runs to be queried, comma separated list of valid ids (limit no. of ids 10).
         */
        @QueryParameter(name = "releaseDefIds")
        public Integer[] releaseDefIds;
        /**
         * Release Environment Definition Ids of the Runs to be queried, comma separated list of valid ids (limit no. of ids 10).
         */
        @QueryParameter(name = "releaseEnvDefIds")
        public Integer[] releaseEnvDefIds;
        /**
         * Release Environment Ids of the Runs to be queried, comma separated list of valid ids (limit no. of ids 10).
         */
        @QueryParameter(name = "releaseEnvIds")
        public Integer[] releaseEnvIds;
        /**
         * Release Ids of the Runs to be queried, comma separated list of valid ids (limit no. of ids 10).
         */
        @QueryParameter(name = "releaseIds")
        public Integer[] releaseIds;
        /**
         * Run Title of the Runs to be queried.
         */
        @QueryParameter(name = "runTitle")
        public String runTitle;
        /**
         * Current state of the Runs to be queried.
         */
        @QueryParameter(name = "state")
        public TestRunState state;
    }

    /**
     * Request configuration object for the query parameters.
     */
    public static class QueryRequestConfiguration {
        public QueryParameters queryParameters = new QueryParameters();
    }

    /**
     * Represents the query parameters.
     */
    public static class GetQueryParameters {
        /**
         * Number of test runs to skip.
         */
        @QueryParameter(name = "$skip")
        public Integer skip;
        /**
         * Number of test runs to return.
         */
        @QueryParameter(name = "$top")
        public Integer top;
        /**
         * If true, only returns automated runs.
         */
        @QueryParameter(name = "automated")
        public Boolean automated;
        /**
         * URI of the build that the runs used.
         */
        @QueryParameter(name = "buildUri")
        public String buildUri;
        /**
         * If true, include all the properties of the runs.
         */
        @QueryParameter(name = "includeRunDetails")
        public Boolean includeRunDetails;
        /**
         * Team foundation ID of the owner of the runs.
         */
        @QueryParameter(name = "owner")
        public String owner;
        /**
         * ID of the test plan that the runs are a part of.
         */
        @QueryParameter(name = "planId")
        public Integer planId;
        /**
         * TMI Run id.
         */
        @QueryParameter(name = "tmiRunId")
        public String tmiRunId;
    }

    /**
     * Request configuration object for the query parameters.
     */
    public static class RequestConfiguration {
        public GetQueryParameters queryParameters = new GetQueryParameters();
    }
}
