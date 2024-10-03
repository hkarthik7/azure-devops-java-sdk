package org.azd.build.attachments;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.authentication.AccessTokenCredential;
import org.azd.build.types.Attachments;
import org.azd.enums.CustomHeader;
import org.azd.exceptions.AzDException;

import java.io.InputStream;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

/**
 * Provides the functionality to manage Build Attachments Api.
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
     * Gets the attachment of a specific type that are associated with a build.
     *
     * @param attachmentParameters Consumer of Attachment parameters to get the attachment.
     * @return Returns a future of response stream
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<InputStream> getAsync(Consumer<AttachmentParameters> attachmentParameters) throws AzDException {
        Objects.requireNonNull(attachmentParameters);

        final var params = new AttachmentParameters();
        attachmentParameters.accept(params);

        return builder()
                .area("build")
                .location("af5122d3-3438-485e-a25a-2dbbfde84ee6")
                .serviceEndpoint("buildId", params.buildId)
                .serviceEndpoint("timelineId", params.timelineId)
                .serviceEndpoint("recordId", params.recordId)
                .serviceEndpoint("type", params.type)
                .serviceEndpoint("name", params.attachmentName)
                .header(CustomHeader.STREAM_ACCEPT)
                .build()
                .executeStreamAsync();
    }

    /**
     * Gets the list of attachments of a specific type that are associated with a build.
     *
     * @param buildId The ID of the build.
     * @param type    The type of attachment.
     * @return Attachments future Object {@link Attachments}
     * @throws AzDException Default Api Exception handler.
     **/
    public CompletableFuture<Attachments> listAsync(int buildId, String type) throws AzDException {
        return builder()
                .area("build")
                .location("f2192269-89fa-4f94-baf6-8fb128c55159")
                .serviceEndpoint("buildId", buildId)
                .serviceEndpoint("type", type)
                .build()
                .executeAsync(Attachments.class);
    }

    /**
     * Gets the attachment of a specific type that are associated with a build.
     *
     * @param attachmentParameters Consumer of Attachment parameters to get the attachment.
     * @return Returns a future of response stream
     * @throws AzDException Default Api Exception handler.
     */
    public InputStream get(Consumer<AttachmentParameters> attachmentParameters) throws AzDException {
        Objects.requireNonNull(attachmentParameters);

        final var params = new AttachmentParameters();
        attachmentParameters.accept(params);

        return builder()
                .area("build")
                .location("af5122d3-3438-485e-a25a-2dbbfde84ee6")
                .serviceEndpoint("buildId", params.buildId)
                .serviceEndpoint("timelineId", params.timelineId)
                .serviceEndpoint("recordId", params.recordId)
                .serviceEndpoint("type", params.type)
                .serviceEndpoint("name", params.attachmentName)
                .header(CustomHeader.STREAM_ACCEPT)
                .build()
                .executeStream();
    }

    /**
     * Gets the list of attachments of a specific type that are associated with a build.
     *
     * @param buildId The ID of the build.
     * @param type    The type of attachment.
     * @return Attachments future Object {@link Attachments}
     * @throws AzDException Default Api Exception handler.
     **/
    public Attachments list(int buildId, String type) throws AzDException {
        return builder()
                .area("build")
                .location("f2192269-89fa-4f94-baf6-8fb128c55159")
                .serviceEndpoint("buildId", buildId)
                .serviceEndpoint("type", type)
                .build()
                .execute(Attachments.class);
    }

    /**
     * Represents the Attachment parameters.
     */
    public static class AttachmentParameters {
        /**
         * ID of the build.
         */
        public int buildId;
        /**
         * ID of timeline.
         */
        public String timelineId;
        /**
         * ID of the record.
         */
        public String recordId;
        /**
         * Type of attachment.
         */
        public String type;
        /**
         * Name of the attachment.
         */
        public String attachmentName;
    }
}
