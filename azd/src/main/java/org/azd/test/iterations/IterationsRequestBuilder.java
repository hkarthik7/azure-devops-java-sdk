package org.azd.test.iterations;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.authentication.AccessTokenCredential;
import org.azd.common.ApiVersion;
import org.azd.exceptions.AzDException;
import org.azd.test.types.TestIterationDetailsModel;
import org.azd.test.types.TestIterationDetailsModels;

import java.util.concurrent.CompletableFuture;

/**
 * Provides functionality to work with Test iterations Api.
 */
public class IterationsRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public IterationsRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential, "test", "73eb9074-3446-4c44-8296-2f811950ff8d", ApiVersion.TEST_ITERATIONS);
    }

    /**
     * Get iteration for a result
     *
     * @param iterationId Id of the test results Iteration.
     * @param runId ID of the test run that contains the result.
     * @param testCaseResultId ID of the test result that contains the iterations.
     * @return TestIterationDetailsModel object {@link TestIterationDetailsModel}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<TestIterationDetailsModel> getAsync(int iterationId, int runId, int testCaseResultId) throws AzDException {
        return builder()
                .serviceEndpoint("iterationId", iterationId)
                .serviceEndpoint("runId", runId)
                .serviceEndpoint("testCaseResultId", testCaseResultId)
                .build()
                .executeAsync(TestIterationDetailsModel.class);
    }

    /**
     * Get iteration for a result
     *
     * @param iterationId Id of the test results Iteration.
     * @param runId ID of the test run that contains the result.
     * @param testCaseResultId ID of the test result that contains the iterations.
     * @param includeActionResults Include result details for each action performed in the test iteration.
     *                             ActionResults refer to outcome (pass/fail) of test steps that are executed as part of
     *                             a running a manual test. Including the ActionResults flag gets the outcome of test
     *                             steps in the actionResults section and test parameters in the parameters section
     *                             for each test iteration.
     * @return TestIterationDetailsModel object {@link TestIterationDetailsModel}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<TestIterationDetailsModel> getAsync(int iterationId, int runId, int testCaseResultId,
                                                                 boolean includeActionResults) throws AzDException {
        return builder()
                .serviceEndpoint("iterationId", iterationId)
                .serviceEndpoint("runId", runId)
                .serviceEndpoint("testCaseResultId", testCaseResultId)
                .query("includeActionResults", includeActionResults)
                .build()
                .executeAsync(TestIterationDetailsModel.class);
    }

    /**
     * Get a list of iteration for a result
     *
     * @param runId ID of the test run that contains the result.
     * @param testCaseResultId ID of the test result that contains the iterations.
     * @return List of TestIterationDetailsModel object {@link TestIterationDetailsModels}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<TestIterationDetailsModels> listAsync(int runId, int testCaseResultId) throws AzDException {
        return builder()
                .serviceEndpoint("runId", runId)
                .serviceEndpoint("testCaseResultId", testCaseResultId)
                .build()
                .executeAsync(TestIterationDetailsModels.class);
    }

    /**
     * Get a list of iteration for a result
     *
     * @param runId ID of the test run that contains the result.
     * @param testCaseResultId ID of the test result that contains the iterations.
     * @param includeActionResults Include result details for each action performed in the test iteration.
     *                             ActionResults refer to outcome (pass/fail) of test steps that are executed as part of
     *                             a running a manual test. Including the ActionResults flag gets the outcome of test
     *                             steps in the actionResults section and test parameters in the parameters section
     *                             for each test iteration.
     * @return List of TestIterationDetailsModel object {@link TestIterationDetailsModels}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<TestIterationDetailsModels> listAsync(int runId, int testCaseResultId,
                                                                   boolean includeActionResults) throws AzDException {
        return builder()
                .serviceEndpoint("runId", runId)
                .serviceEndpoint("testCaseResultId", testCaseResultId)
                .query("includeActionResults", includeActionResults)
                .build()
                .executeAsync(TestIterationDetailsModels.class);
    }

    /**
     * Get iteration for a result
     *
     * @param iterationId Id of the test results Iteration.
     * @param runId ID of the test run that contains the result.
     * @param testCaseResultId ID of the test result that contains the iterations.
     * @return TestIterationDetailsModel object {@link TestIterationDetailsModel}
     * @throws AzDException Default Api exception handler.
     */
    public TestIterationDetailsModel get(int iterationId, int runId, int testCaseResultId) throws AzDException {
        return builder()
                .serviceEndpoint("iterationId", iterationId)
                .serviceEndpoint("runId", runId)
                .serviceEndpoint("testCaseResultId", testCaseResultId)
                .build()
                .execute(TestIterationDetailsModel.class);
    }

    /**
     * Get iteration for a result
     *
     * @param iterationId Id of the test results Iteration.
     * @param runId ID of the test run that contains the result.
     * @param testCaseResultId ID of the test result that contains the iterations.
     * @param includeActionResults Include result details for each action performed in the test iteration.
     *                             ActionResults refer to outcome (pass/fail) of test steps that are executed as part of
     *                             a running a manual test. Including the ActionResults flag gets the outcome of test
     *                             steps in the actionResults section and test parameters in the parameters section
     *                             for each test iteration.
     * @return TestIterationDetailsModel object {@link TestIterationDetailsModel}
     * @throws AzDException Default Api exception handler.
     */
    public TestIterationDetailsModel get(int iterationId, int runId, int testCaseResultId,
                                         boolean includeActionResults) throws AzDException {
        return builder()
                .serviceEndpoint("iterationId", iterationId)
                .serviceEndpoint("runId", runId)
                .serviceEndpoint("testCaseResultId", testCaseResultId)
                .query("includeActionResults", includeActionResults)
                .build()
                .execute(TestIterationDetailsModel.class);
    }

    /**
     * Get a list of iteration for a result
     *
     * @param runId ID of the test run that contains the result.
     * @param testCaseResultId ID of the test result that contains the iterations.
     * @return List of TestIterationDetailsModel object {@link TestIterationDetailsModels}
     * @throws AzDException Default Api exception handler.
     */
    public TestIterationDetailsModels list(int runId, int testCaseResultId) throws AzDException {
        return builder()
                .serviceEndpoint("runId", runId)
                .serviceEndpoint("testCaseResultId", testCaseResultId)
                .build()
                .execute(TestIterationDetailsModels.class);
    }

    /**
     * Get a list of iteration for a result
     *
     * @param runId ID of the test run that contains the result.
     * @param testCaseResultId ID of the test result that contains the iterations.
     * @param includeActionResults Include result details for each action performed in the test iteration.
     *                             ActionResults refer to outcome (pass/fail) of test steps that are executed as part of
     *                             a running a manual test. Including the ActionResults flag gets the outcome of test
     *                             steps in the actionResults section and test parameters in the parameters section
     *                             for each test iteration.
     * @return List of TestIterationDetailsModel object {@link TestIterationDetailsModels}
     * @throws AzDException Default Api exception handler.
     */
    public TestIterationDetailsModels list(int runId, int testCaseResultId,
                                           boolean includeActionResults) throws AzDException {
        return builder()
                .serviceEndpoint("runId", runId)
                .serviceEndpoint("testCaseResultId", testCaseResultId)
                .query("includeActionResults", includeActionResults)
                .build()
                .execute(TestIterationDetailsModels.class);
    }
}
