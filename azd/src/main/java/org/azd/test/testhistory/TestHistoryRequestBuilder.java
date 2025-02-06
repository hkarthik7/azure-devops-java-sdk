package org.azd.test.testhistory;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.authentication.AccessTokenCredential;
import org.azd.common.ApiVersion;
import org.azd.exceptions.AzDException;
import org.azd.test.types.TestHistoryQuery;

import java.util.concurrent.CompletableFuture;

/**
 * Provides functionality to work with Test history Api.
 */
public class TestHistoryRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public TestHistoryRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential, "test", "929fd86c-3e38-4d8c-b4b6-90df256e5971", ApiVersion.TEST_HISTORY);
    }

    /**
     * Get history of a test method using TestHistoryQuery
     *
     * @param query Query to get history
     * @return Test history query object {@link TestHistoryQuery}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<TestHistoryQuery> queryAsync(TestHistoryQuery query) throws AzDException {
        return builder()
                .POST(query)
                .build()
                .executeAsync(TestHistoryQuery.class);
    }

    /**
     * Get history of a test method using TestHistoryQuery
     *
     * @param query Query to get history
     * @return Test history query object {@link TestHistoryQuery}
     * @throws AzDException Default Api Exception handler.
     */
    public TestHistoryQuery query(TestHistoryQuery query) throws AzDException {
        return builder()
                .POST(query)
                .build()
                .execute(TestHistoryQuery.class);
    }

}
