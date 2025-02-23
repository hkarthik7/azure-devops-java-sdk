package org.azd.test.testcases;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.authentication.AccessTokenCredential;
import org.azd.common.ApiVersion;
import org.azd.exceptions.AzDException;

import java.util.concurrent.CompletableFuture;

/**
 * Provides functionality to work with Test cases Api.
 */
public class TestCasesRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public TestCasesRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential, "test", "4d472e0f-e32c-4ef8-adf4-a4078772889c", ApiVersion.TEST_CASES);
    }

    /**
     * Delete a test case.
     *
     * @param testCaseId Id of test case to delete.
     * @return Success response
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<Void> deleteAsync(int testCaseId) throws AzDException {
        return builder()
                .serviceEndpoint("testCaseId", testCaseId)
                .DELETE()
                .build()
                .executePrimitiveAsync();
    }

    /**
     * Delete a test case.
     *
     * @param testCaseId Id of test case to delete.
     * @return Success response
     * @throws AzDException Default Api Exception handler.
     */
    public Void delete(int testCaseId) throws AzDException {
        return builder()
                .serviceEndpoint("testCaseId", testCaseId)
                .DELETE()
                .build()
                .executePrimitive();
    }
}
