package org.azd.test.results;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.abstractions.QueryParameter;
import org.azd.authentication.AccessTokenCredential;
import org.azd.common.ApiVersion;
import org.azd.enums.TestRunPublishContext;
import org.azd.enums.TestRunState;
import org.azd.exceptions.AzDException;
import org.azd.test.types.*;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

/**
 * Provides functionality to work with Test results Api.
 */
public class ResultsRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public ResultsRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential, "test", "4637d869-3a76-4468-8057-0bb02aa385cf", ApiVersion.TEST_RESULTS);
    }


    /**
     * Get a test case results for a test run.
     *
     * @param runId ID of the run to get.
     * @param testCaseResultId ID of the test case result to get.
     * @return TestCaseResult Object {@link TestCaseResult}
     * @throws AzDException Default Api Exception handler.
     **/
    public TestCaseResult get(int runId, int testCaseResultId) throws AzDException {
        return builder()
                .serviceEndpoint("runId", runId)
                .serviceEndpoint("testCaseResultId", testCaseResultId)
                .build()
                .execute(TestCaseResult.class);
    }

    /**
     * Get a list of test results by run ID.
     *
     * @param runId ID of the run.
     * @return Collection of TestCaseResults Object {@link TestRuns}
     * @throws AzDException Default Api Exception handler.
     **/
    public TestCaseResults list(int runId) throws AzDException {
        return builder()
                .serviceEndpoint("runId", runId)
                .build()
                .execute(TestCaseResults.class);
    }

    /**
     * Create test results by run ID.
     *
     * @param runId   ID of the run to update.
     * @param testCaseResults Test case results object to update.
     * @return Test case results object {@link TestCaseResults}
     * @throws AzDException Default Api Exception handler.
     */
    public TestCaseResults create(int runId, TestCaseResults testCaseResults) throws AzDException {
        return builder()
                .POST(testCaseResults.getResults())
                .serviceEndpoint("runId", runId)
                .build()
                .execute(TestCaseResults.class);
    }

    /**
     * Update test results by run ID.
     *
     * @param runId   ID of the run to update.
     * @param testCaseResults Test case results object to update.
     * @return Test case results object {@link TestCaseResults}
     * @throws AzDException Default Api Exception handler.
     */
    public TestCaseResults update(int runId, TestCaseResults testCaseResults) throws AzDException {
        return builder()
                .PATCH(testCaseResults.getResults())
                .serviceEndpoint("runId", runId)
                .build()
                .execute(TestCaseResults.class);
    }

}
