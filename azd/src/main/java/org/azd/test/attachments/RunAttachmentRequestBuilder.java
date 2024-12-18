package org.azd.test.attachments;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.authentication.AccessTokenCredential;
import org.azd.common.ApiVersion;
import org.azd.enums.CustomHeader;
import org.azd.exceptions.AzDException;
import org.azd.test.types.TestAttachmentReference;
import org.azd.test.types.TestAttachmentRequestModel;
import org.azd.test.types.TestAttachments;

import java.io.InputStream;
import java.util.concurrent.CompletableFuture;

/**
 * Provides functionality to work with Test run attachments Api.
 */
public class RunAttachmentRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public RunAttachmentRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential, "test", "4f004af4-a507-489c-9b13-cb62060beb11", ApiVersion.TEST_RUNS);
    }

    /**
     * Attach a file to a test run.
     *
     * @param runId ID of the test run against which attachment has to be uploaded.
     * @param requestModel Request body to create the result attachment.
     * @return TestAttachmentReference {@link TestAttachmentReference}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<TestAttachmentReference> createAsync(int runId, TestAttachmentRequestModel requestModel)
            throws AzDException {
        return builder()
                .POST(requestModel)
                .serviceEndpoint("runId", runId)
                .build()
                .executeAsync(TestAttachmentReference.class);
    }

    /**
     * Download a test run attachment by its ID.
     *
     * @param attachmentId ID of the test result attachment to be downloaded.
     * @param runId ID of the test run that contains the result.
     * @return InputStream of attachment content.
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<InputStream> getContentAsync(int attachmentId, int runId)
            throws AzDException {
        return builder()
                .serviceEndpoint("runId", runId)
                .serviceEndpoint("attachmentId", attachmentId)
                .header(CustomHeader.STREAM_ACCEPT)
                .build()
                .executeStreamAsync();
    }

    /**
     * Download a test result attachment by its ID.
     *
     * @param attachmentId ID of the test result attachment to be downloaded.
     * @param runId ID of the test run that contains the result.
     * @return InputStream of attachment content as zip file.
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<InputStream> getAsZipAsync(int attachmentId, int runId)
            throws AzDException {
        return builder()
                .serviceEndpoint("runId", runId)
                .serviceEndpoint("attachmentId", attachmentId)
                .header(CustomHeader.STREAM_ZIP_ACCEPT)
                .build()
                .executeStreamAsync();
    }

    /**
     * Get list of test run attachments reference.
     *
     * @param runId ID of the test run that contains the result.
     * @return List of TestAttachment {@link TestAttachments}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<TestAttachments> listAsync(int runId)
            throws AzDException {
        return builder()
                .serviceEndpoint("runId", runId)
                .build()
                .executeAsync(TestAttachments.class);
    }

    /**
     * Attach a file to a test run.
     *
     * @param runId ID of the test run against which attachment has to be uploaded.
     * @param requestModel Request body to create the result attachment.
     * @return TestAttachmentReference {@link TestAttachmentReference}
     * @throws AzDException Default Api exception handler.
     */
    public TestAttachmentReference create(int runId, TestAttachmentRequestModel requestModel)
            throws AzDException {
        return builder()
                .POST(requestModel)
                .serviceEndpoint("runId", runId)
                .build()
                .execute(TestAttachmentReference.class);
    }

    /**
     * Download a test run attachment by its ID.
     *
     * @param attachmentId ID of the test result attachment to be downloaded.
     * @param runId ID of the test run that contains the result.
     * @return InputStream of attachment content.
     * @throws AzDException Default Api exception handler.
     */
    public InputStream getContent(int attachmentId, int runId)
            throws AzDException {
        return builder()
                .serviceEndpoint("runId", runId)
                .serviceEndpoint("attachmentId", attachmentId)
                .header(CustomHeader.STREAM_ACCEPT)
                .build()
                .executeStream();
    }

    /**
     * Download a test result attachment by its ID.
     *
     * @param attachmentId ID of the test result attachment to be downloaded.
     * @param runId ID of the test run that contains the result.
     * @return InputStream of attachment content as zip file.
     * @throws AzDException Default Api exception handler.
     */
    public InputStream getAsZip(int attachmentId, int runId)
            throws AzDException {
        return builder()
                .serviceEndpoint("runId", runId)
                .serviceEndpoint("attachmentId", attachmentId)
                .header(CustomHeader.STREAM_ZIP_ACCEPT)
                .build()
                .executeStream();
    }

    /**
     * Get list of test run attachments reference.
     *
     * @param runId ID of the test run that contains the result.
     * @return List of TestAttachment {@link TestAttachments}
     * @throws AzDException Default Api exception handler.
     */
    public TestAttachments list(int runId)
            throws AzDException {
        return builder()
                .serviceEndpoint("runId", runId)
                .build()
                .execute(TestAttachments.class);
    }
}
