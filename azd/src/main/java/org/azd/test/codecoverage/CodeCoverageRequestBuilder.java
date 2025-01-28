package org.azd.test.codecoverage;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.authentication.AccessTokenCredential;
import org.azd.common.ApiVersion;
import org.azd.exceptions.AzDException;
import org.azd.test.types.BuildCoverages;
import org.azd.test.types.TestRunCoverages;

import java.util.concurrent.CompletableFuture;

public class CodeCoverageRequestBuilder extends BaseRequestBuilder {
    public CodeCoverageRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential, "test", "77560e8a-4e8c-4d59-894e-a5f264c24444", ApiVersion.TEST_CODE_COVERAGE);
    }

    /**
     * Get code coverage data for a test run.
     *
     * @param buildId ID of the build for which code coverage data needs to be fetched.
     * @param flags Value of flags determine the level of code coverage details to be fetched.
     *              Flags are additive. Expected Values are 1 for Modules, 2 for Functions, 4 for BlockData.
     * @return List of BuildCoverage {@link BuildCoverages}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<BuildCoverages> getBuildCodeCoverageAsync(int buildId, int flags) throws AzDException {
        return builder()
                .query("buildId", buildId)
                .query("flags", flags)
                .build()
                .executeAsync(BuildCoverages.class);
    }

    /**
     * Get code coverage data for a test run
     *
     * @param runId ID of the test run for which code coverage data needs to be fetched.
     * @param flags Value of flags determine the level of code coverage details to be fetched.
     *              Flags are additive. Expected Values are 1 for Modules, 2 for Functions, 4 for BlockData.
     * @return List of TestRunCoverage {@link TestRunCoverages}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<TestRunCoverages> getTestRunCodeCoverageAsync(int runId, int flags) throws AzDException {
        return builder()
                .location("9629116f-3b89-4ed8-b358-d4694efda160")
                .query("runId", runId)
                .query("flags", flags)
                .build()
                .executeAsync(TestRunCoverages.class);
    }

    /**
     * Get code coverage data for a test run.
     *
     * @param buildId ID of the build for which code coverage data needs to be fetched.
     * @param flags Value of flags determine the level of code coverage details to be fetched.
     *              Flags are additive. Expected Values are 1 for Modules, 2 for Functions, 4 for BlockData.
     * @return List of BuildCoverage {@link BuildCoverages}
     * @throws AzDException Default Api exception handler.
     */
    public BuildCoverages getBuildCodeCoverage(int buildId, int flags) throws AzDException {
        return builder()
                .query("buildId", buildId)
                .query("flags", flags)
                .build()
                .execute(BuildCoverages.class);
    }

    /**
     * Get code coverage data for a test run
     *
     * @param runId ID of the test run for which code coverage data needs to be fetched.
     * @param flags Value of flags determine the level of code coverage details to be fetched.
     *              Flags are additive. Expected Values are 1 for Modules, 2 for Functions, 4 for BlockData.
     * @return List of TestRunCoverage {@link TestRunCoverages}
     * @throws AzDException Default Api exception handler.
     */
    public TestRunCoverages getTestRunCodeCoverage(int runId, int flags) throws AzDException {
        return builder()
                .location("9629116f-3b89-4ed8-b358-d4694efda160")
                .query("runId", runId)
                .query("flags", flags)
                .build()
                .execute(TestRunCoverages.class);
    }
}
