package org.azd.test.attachments;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.authentication.AccessTokenCredential;
import org.azd.common.ApiVersion;
import org.azd.exceptions.AzDException;
import org.azd.test.types.TestRun;

/**
 * Provides functionality to work with Test result attachments Api.
 */
public class ResultAttachmentRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public ResultAttachmentRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential, "test", "2bffebe9-2f0f-4639-9af8-56129e9fed2d", ApiVersion.TEST_ATTACHMENTS);
    }

    /**
     * Create new test run.
     *
     * @param runCreateModel Run create model object to create a test run.
     * @return TestRun Object {@link TestRun}
     * @throws AzDException Default Api Exception handler.
     **/
//    public CompletableFuture<TestAttachmentReference> createAsync(RunCreateModel runCreateModel) throws AzDException {
//        return builder()
//                .POST(runCreateModel)
//                .build()
//                .executeAsync(TestRun.class);
//    }
}
