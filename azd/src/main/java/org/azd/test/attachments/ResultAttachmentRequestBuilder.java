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
     * Attach a file to a test result.
     *
     * @param runId ID of the test run that contains the result.
     * @param testCaseResultId ID of the test result against which attachment has to be uploaded.
     * @param requestModel Request body to create the result attachment.
     * @return TestAttachmentReference {@link TestAttachmentReference}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<TestAttachmentReference> createAsync(int runId, int testCaseResultId, TestAttachmentRequestModel requestModel)
            throws AzDException {
        return builder()
                .POST(requestModel)
                .serviceEndpoint("runId", runId)
                .serviceEndpoint("testCaseResultId", testCaseResultId)
                .build()
                .executeAsync(TestAttachmentReference.class);
    }

    /**
     * Attach a file to a test result.
     *
     * @param runId ID of the test run that contains the result.
     * @param testCaseResultId ID of the test result against which attachment has to be uploaded.
     * @param requestModel Request body to create the result attachment.
     * @param testSubResultId ID of the test sub results against which attachment has to be uploaded.
     * @return TestAttachmentReference {@link TestAttachmentReference}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<TestAttachmentReference> createAsync(int runId, int testCaseResultId, TestAttachmentRequestModel requestModel,
                                                                  int testSubResultId)
            throws AzDException {
        return builder()
                .POST(requestModel)
                .serviceEndpoint("runId", runId)
                .serviceEndpoint("testCaseResultId", testCaseResultId)
                .query("testSubResultId", testSubResultId)
                .build()
                .executeAsync(TestAttachmentReference.class);
    }

    /**
     * Download a test result attachment by its ID.
     *
     * @param attachmentId ID of the test result attachment to be downloaded.
     * @param runId ID of the test run that contains the result.
     * @param testCaseResultId ID of the test result against which attachment has to be uploaded.
     * @return InputStream of attachment content.
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<InputStream> getContentAsync(int attachmentId, int runId, int testCaseResultId)
            throws AzDException {
        return builder()
                .serviceEndpoint("runId", runId)
                .serviceEndpoint("testCaseResultId", testCaseResultId)
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
     * @param testCaseResultId ID of the test result against which attachment has to be uploaded.
     * @return InputStream of attachment content as zip file.
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<InputStream> getAsZipAsync(int attachmentId, int runId, int testCaseResultId)
            throws AzDException {
        return builder()
                .serviceEndpoint("runId", runId)
                .serviceEndpoint("testCaseResultId", testCaseResultId)
                .serviceEndpoint("attachmentId", attachmentId)
                .header(CustomHeader.STREAM_ZIP_ACCEPT)
                .build()
                .executeStreamAsync();
    }

    /**
     * Download a test sub result attachment by its ID.
     *
     * @param attachmentId ID of the test result attachment to be downloaded.
     * @param runId ID of the test run that contains the result.
     * @param testCaseResultId ID of the test result against which attachment has to be uploaded.
     * @param testSubResultId ID of the test sub result whose attachment has to be downloaded
     * @return InputStream of attachment content.
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<InputStream> getContentAsync(int attachmentId, int runId, int testCaseResultId,
                                                          int testSubResultId)
            throws AzDException {
        return builder()
                .serviceEndpoint("runId", runId)
                .serviceEndpoint("testCaseResultId", testCaseResultId)
                .serviceEndpoint("attachmentId", attachmentId)
                .query("testSubResultId", testSubResultId)
                .header(CustomHeader.STREAM_ACCEPT)
                .build()
                .executeStreamAsync();
    }

    /**
     * Download a test sub result attachment by its ID.
     *
     * @param attachmentId ID of the test result attachment to be downloaded.
     * @param runId ID of the test run that contains the result.
     * @param testCaseResultId ID of the test result against which attachment has to be uploaded.
     * @param testSubResultId ID of the test sub result whose attachment has to be downloaded
     * @return InputStream of attachment content as zip file.
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<InputStream> getAsZipAsync(int attachmentId, int runId, int testCaseResultId,
                                                        int testSubResultId)
            throws AzDException {
        return builder()
                .serviceEndpoint("runId", runId)
                .serviceEndpoint("testCaseResultId", testCaseResultId)
                .serviceEndpoint("attachmentId", attachmentId)
                .query("testSubResultId", testSubResultId)
                .header(CustomHeader.STREAM_ZIP_ACCEPT)
                .build()
                .executeStreamAsync();
    }

    /**
     * Get list of test sub result attachments.
     *
     * @param runId ID of the test run that contains the result.
     * @param testCaseResultId ID of the test result against which attachment has to be uploaded.
     * @param testSubResultId ID of the test sub result whose attachment has to be downloaded
     * @return List of TestAttachment {@link TestAttachments}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<TestAttachments> listAsync(int runId, int testCaseResultId,
                                                            int testSubResultId)
            throws AzDException {
        return builder()
                .serviceEndpoint("runId", runId)
                .serviceEndpoint("testCaseResultId", testCaseResultId)
                .query("testSubResultId", testSubResultId)
                .build()
                .executeAsync(TestAttachments.class);
    }

    /**
     * Attach a file to a test result.
     *
     * @param runId ID of the test run that contains the result.
     * @param testCaseResultId ID of the test result against which attachment has to be uploaded.
     * @param requestModel Request body to create the result attachment.
     * @return TestAttachmentReference {@link TestAttachmentReference}
     * @throws AzDException Default Api exception handler.
     */
    public TestAttachmentReference create(int runId, int testCaseResultId, TestAttachmentRequestModel requestModel)
            throws AzDException {
        return builder()
                .POST(requestModel)
                .serviceEndpoint("runId", runId)
                .serviceEndpoint("testCaseResultId", testCaseResultId)
                .build()
                .execute(TestAttachmentReference.class);
    }

    /**
     * Attach a file to a test result.
     *
     * @param runId ID of the test run that contains the result.
     * @param testCaseResultId ID of the test result against which attachment has to be uploaded.
     * @param requestModel Request body to create the result attachment.
     * @param testSubResultId ID of the test sub results against which attachment has to be uploaded.
     * @return TestAttachmentReference {@link TestAttachmentReference}
     * @throws AzDException Default Api exception handler.
     */
    public TestAttachmentReference create(int runId, int testCaseResultId, TestAttachmentRequestModel requestModel,
                                          int testSubResultId)
            throws AzDException {
        return builder()
                .POST(requestModel)
                .serviceEndpoint("runId", runId)
                .serviceEndpoint("testCaseResultId", testCaseResultId)
                .query("testSubResultId", testSubResultId)
                .build()
                .execute(TestAttachmentReference.class);
    }

    /**
     * Download a test result attachment by its ID.
     *
     * @param attachmentId ID of the test result attachment to be downloaded.
     * @param runId ID of the test run that contains the result.
     * @param testCaseResultId ID of the test result against which attachment has to be uploaded.
     * @return InputStream of attachment content.
     * @throws AzDException Default Api exception handler.
     */
    public InputStream getContent(int attachmentId, int runId, int testCaseResultId)
            throws AzDException {
        return builder()
                .serviceEndpoint("runId", runId)
                .serviceEndpoint("testCaseResultId", testCaseResultId)
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
     * @param testCaseResultId ID of the test result against which attachment has to be uploaded.
     * @return InputStream of attachment content as zip file.
     * @throws AzDException Default Api exception handler.
     */
    public InputStream getAsZip(int attachmentId, int runId, int testCaseResultId)
            throws AzDException {
        return builder()
                .serviceEndpoint("runId", runId)
                .serviceEndpoint("testCaseResultId", testCaseResultId)
                .serviceEndpoint("attachmentId", attachmentId)
                .header(CustomHeader.STREAM_ZIP_ACCEPT)
                .build()
                .executeStream();
    }

    /**
     * Download a test sub result attachment by its ID.
     *
     * @param attachmentId ID of the test result attachment to be downloaded.
     * @param runId ID of the test run that contains the result.
     * @param testCaseResultId ID of the test result against which attachment has to be uploaded.
     * @param testSubResultId ID of the test sub result whose attachment has to be downloaded
     * @return InputStream of attachment content.
     * @throws AzDException Default Api exception handler.
     */
    public InputStream getContent(int attachmentId, int runId, int testCaseResultId,
                                  int testSubResultId)
            throws AzDException {
        return builder()
                .serviceEndpoint("runId", runId)
                .serviceEndpoint("testCaseResultId", testCaseResultId)
                .serviceEndpoint("attachmentId", attachmentId)
                .query("testSubResultId", testSubResultId)
                .header(CustomHeader.STREAM_ACCEPT)
                .build()
                .executeStream();
    }

    /**
     * Download a test sub result attachment by its ID.
     *
     * @param attachmentId ID of the test result attachment to be downloaded.
     * @param runId ID of the test run that contains the result.
     * @param testCaseResultId ID of the test result against which attachment has to be uploaded.
     * @param testSubResultId ID of the test sub result whose attachment has to be downloaded
     * @return InputStream of attachment content as zip file.
     * @throws AzDException Default Api exception handler.
     */
    public InputStream getAsZip(int attachmentId, int runId, int testCaseResultId,
                                int testSubResultId)
            throws AzDException {
        return builder()
                .serviceEndpoint("runId", runId)
                .serviceEndpoint("testCaseResultId", testCaseResultId)
                .serviceEndpoint("attachmentId", attachmentId)
                .query("testSubResultId", testSubResultId)
                .header(CustomHeader.STREAM_ZIP_ACCEPT)
                .build()
                .executeStream();
    }

    /**
     * Get list of test sub result attachments.
     *
     * @param runId ID of the test run that contains the result.
     * @param testCaseResultId ID of the test result against which attachment has to be uploaded.
     * @param testSubResultId ID of the test sub result whose attachment has to be downloaded
     * @return List of TestAttachment {@link TestAttachments}
     * @throws AzDException Default Api exception handler.
     */
    public TestAttachments list(int runId, int testCaseResultId,
                                int testSubResultId)
            throws AzDException {
        return builder()
                .serviceEndpoint("runId", runId)
                .serviceEndpoint("testCaseResultId", testCaseResultId)
                .query("testSubResultId", testSubResultId)
                .build()
                .execute(TestAttachments.class);
    }

}
