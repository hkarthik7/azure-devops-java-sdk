package org.azd.test.attachments;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.authentication.AccessTokenCredential;

/**
 * Provides functionality to work with Test attachments Api.
 */
public class AttachmentsRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public AttachmentsRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential);
    }

    /**
     * Provides functionality to work with Test result attachments Api.
     *
     * @return TestResultAttachmentRequestBuilder {@link ResultAttachmentRequestBuilder}
     */
    public ResultAttachmentRequestBuilder result() {
        return new ResultAttachmentRequestBuilder(organizationUrl, accessTokenCredential);
    }

    /**
     * Provides functionality to work with Test run attachments Api.
     *
     * @return TestRunAttachmentRequestBuilder {@link RunAttachmentRequestBuilder}
     */
    public RunAttachmentRequestBuilder run() {
        return new RunAttachmentRequestBuilder(organizationUrl, accessTokenCredential);
    }

}
