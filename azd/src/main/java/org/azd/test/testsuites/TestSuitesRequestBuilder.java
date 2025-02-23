package org.azd.test.testsuites;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.authentication.AccessTokenCredential;
import org.azd.common.ApiVersion;
import org.azd.exceptions.AzDException;
import org.azd.helpers.Utils;
import org.azd.test.types.ShallowReference;
import org.azd.test.types.SuiteTestCase;
import org.azd.test.types.SuiteTestCases;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Provides functionality to work with Test suites Api.
 */
public class TestSuitesRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public TestSuitesRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential, "test", "a4a1ec1c-b03f-41ca-8857-704594ecf58e", ApiVersion.TEST_SUITES);
    }

    /**
     * Add test cases to suite.
     *
     * @param planId ID of the test plan that contains the suite.
     * @param suiteId ID of the test suite to which the test cases must be added.
     * @param testCaseIds IDs of the test cases to add to the suite.
     * @return Collection of test case suites. {@link SuiteTestCases}
     * @throws AzDException Default Api Exception handler.
     **/
    public CompletableFuture<SuiteTestCases> createAsync(int planId, int suiteId, String... testCaseIds) throws AzDException {
        return builder()
                .serviceEndpoint("action", "testcases")
                .serviceEndpoint("planId", planId)
                .serviceEndpoint("suiteId", suiteId)
                .serviceEndpoint("testCaseIds", Utils.toString(testCaseIds))
                .POST(null)
                .build()
                .executeAsync(SuiteTestCases.class);
    }

    /**
     * Get a specific test case in a test suite with test case id.
     *
     * @param planId ID of the test plan that contains the suite.
     * @param suiteId ID of the test suite to which the test cases must be added.
     * @param testCaseIds ID of the test cases to add to the suite.
     * @return Test case suite object. {@link SuiteTestCase}
     * @throws AzDException Default Api Exception handler.
     **/
    public CompletableFuture<SuiteTestCase> getAsync(int planId, int suiteId, int testCaseIds) throws AzDException {
        return builder()
                .serviceEndpoint("action", "testcases")
                .serviceEndpoint("planId", planId)
                .serviceEndpoint("suiteId", suiteId)
                .serviceEndpoint("testCaseIds", testCaseIds)
                .build()
                .executeAsync(SuiteTestCase.class);
    }

    /**
     * Get all test cases in a suite.
     *
     * @param planId ID of the test plan that contains the suite.
     * @param suiteId ID of the test suite to which the test cases must be added.
     * @return Collection of test case suites. {@link SuiteTestCases}
     * @throws AzDException Default Api Exception handler.
     **/
    public CompletableFuture<SuiteTestCases> listAsync(int planId, int suiteId) throws AzDException {
        return builder()
                .serviceEndpoint("action", "testcases")
                .serviceEndpoint("planId", planId)
                .serviceEndpoint("suiteId", suiteId)
                .build()
                .executeAsync(SuiteTestCases.class);
    }

    /**
     * The test points associated with the test cases are removed from the test suite.
     * The test case work item is not deleted from the system. See test cases resource to delete a test case permanently.
     *
     * @param planId ID of the test plan that contains the suite.
     * @param suiteId ID of the test suite to which the test cases must be added.
     * @param testCaseIds IDs of the test cases to add to the suite.
     * @return Success response.
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<Void> removeTestCasesFromSiteUrlAsync(int planId, int suiteId, String... testCaseIds)
        throws AzDException {
        return builder()
                .serviceEndpoint("action", "testcases")
                .serviceEndpoint("planId", planId)
                .serviceEndpoint("suiteId", suiteId)
                .serviceEndpoint("testCaseIds", Utils.toString(testCaseIds))
                .DELETE()
                .build()
                .executePrimitiveAsync();
    }

    /**
     * Add test cases to suite.
     *
     * @param planId ID of the test plan that contains the suite.
     * @param suiteId ID of the test suite to which the test cases must be added.
     * @param testCaseIds IDs of the test cases to add to the suite.
     * @return Collection of test case suites. {@link SuiteTestCases}
     * @throws AzDException Default Api Exception handler.
     **/
    public CompletableFuture<SuiteTestCases> updateAsync(List<ShallowReference> configurations,
                                                         int planId, int suiteId, String... testCaseIds)
            throws AzDException {
        return builder()
                .serviceEndpoint("action", "testcases")
                .serviceEndpoint("planId", planId)
                .serviceEndpoint("suiteId", suiteId)
                .serviceEndpoint("testCaseIds", Utils.toString(testCaseIds))
                .PATCH(configurations)
                .build()
                .executeAsync(SuiteTestCases.class);
    }

    /**
     * Add test cases to suite.
     *
     * @param planId ID of the test plan that contains the suite.
     * @param suiteId ID of the test suite to which the test cases must be added.
     * @param testCaseIds IDs of the test cases to add to the suite.
     * @return Collection of test case suites. {@link SuiteTestCases}
     * @throws AzDException Default Api Exception handler.
     **/
    public SuiteTestCases create(int planId, int suiteId, String... testCaseIds) throws AzDException {
        return builder()
                .serviceEndpoint("action", "testcases")
                .serviceEndpoint("planId", planId)
                .serviceEndpoint("suiteId", suiteId)
                .serviceEndpoint("testCaseIds", Utils.toString(testCaseIds))
                .POST(null)
                .build()
                .execute(SuiteTestCases.class);
    }

    /**
     * Get a specific test case in a test suite with test case id.
     *
     * @param planId ID of the test plan that contains the suite.
     * @param suiteId ID of the test suite to which the test cases must be added.
     * @param testCaseIds ID of the test cases to add to the suite.
     * @return Test case suite object. {@link SuiteTestCase}
     * @throws AzDException Default Api Exception handler.
     **/
    public SuiteTestCase get(int planId, int suiteId, int testCaseIds) throws AzDException {
        return builder()
                .serviceEndpoint("action", "testcases")
                .serviceEndpoint("planId", planId)
                .serviceEndpoint("suiteId", suiteId)
                .serviceEndpoint("testCaseIds", testCaseIds)
                .build()
                .execute(SuiteTestCase.class);
    }

    /**
     * Get all test cases in a suite.
     *
     * @param planId ID of the test plan that contains the suite.
     * @param suiteId ID of the test suite to which the test cases must be added.
     * @return Collection of test case suites. {@link SuiteTestCases}
     * @throws AzDException Default Api Exception handler.
     **/
    public SuiteTestCases list(int planId, int suiteId) throws AzDException {
        return builder()
                .serviceEndpoint("action", "testcases")
                .serviceEndpoint("planId", planId)
                .serviceEndpoint("suiteId", suiteId)
                .build()
                .execute(SuiteTestCases.class);
    }

    /**
     * The test points associated with the test cases are removed from the test suite.
     * The test case work item is not deleted from the system. See test cases resource to delete a test case permanently.
     *
     * @param planId ID of the test plan that contains the suite.
     * @param suiteId ID of the test suite to which the test cases must be added.
     * @param testCaseIds IDs of the test cases to add to the suite.
     * @return Success response.
     * @throws AzDException Default Api Exception handler.
     */
    public Void removeTestCasesFromSiteUrl(int planId, int suiteId, String... testCaseIds)
            throws AzDException {
        return builder()
                .serviceEndpoint("action", "testcases")
                .serviceEndpoint("planId", planId)
                .serviceEndpoint("suiteId", suiteId)
                .serviceEndpoint("testCaseIds", Utils.toString(testCaseIds))
                .DELETE()
                .build()
                .executePrimitive();
    }

    /**
     * Add test cases to suite.
     *
     * @param planId ID of the test plan that contains the suite.
     * @param suiteId ID of the test suite to which the test cases must be added.
     * @param testCaseIds IDs of the test cases to add to the suite.
     * @return Collection of test case suites. {@link SuiteTestCases}
     * @throws AzDException Default Api Exception handler.
     **/
    public SuiteTestCases update(List<ShallowReference> configurations,
                                 int planId, int suiteId, String... testCaseIds)
            throws AzDException {
        return builder()
                .serviceEndpoint("action", "testcases")
                .serviceEndpoint("planId", planId)
                .serviceEndpoint("suiteId", suiteId)
                .serviceEndpoint("testCaseIds", Utils.toString(testCaseIds))
                .PATCH(configurations)
                .build()
                .execute(SuiteTestCases.class);
    }
}
