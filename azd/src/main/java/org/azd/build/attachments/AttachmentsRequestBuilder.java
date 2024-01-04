package org.azd.build.attachments;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.authentication.AccessTokenCredential;
import org.azd.build.types.Attachments;
import org.azd.enums.CustomHeader;
import org.azd.exceptions.AzDException;

import java.io.InputStream;
import java.util.concurrent.CompletableFuture;

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
     * @param buildId        The ID of the build.
     * @param timelineId     The ID of the timeline.
     * @param recordId       The ID of the timeline record.
     * @param type           The type of the attachment.
     * @param attachmentName The name of the attachment.
     * @return Returns a future of response stream
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<InputStream> getAsync(int buildId, String timelineId, String recordId,
                                                   String type, String attachmentName) throws AzDException {
        return builder()
                .area("build")
                .location("af5122d3-3438-485e-a25a-2dbbfde84ee6")
                .serviceEndpoint("buildId", buildId)
                .serviceEndpoint("timelineId", timelineId)
                .serviceEndpoint("recordId", recordId)
                .serviceEndpoint("type", type)
                .serviceEndpoint("name", attachmentName)
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
     * @param buildId        The ID of the build.
     * @param timelineId     The ID of the timeline.
     * @param recordId       The ID of the timeline record.
     * @param type           The type of the attachment.
     * @param attachmentName The name of the attachment.
     * @return Returns a future of response stream
     * @throws AzDException Default Api Exception handler.
     */
    public InputStream get(int buildId, String timelineId, String recordId,
                           String type, String attachmentName) throws AzDException {
        return builder()
                .area("build")
                .location("af5122d3-3438-485e-a25a-2dbbfde84ee6")
                .serviceEndpoint("buildId", buildId)
                .serviceEndpoint("timelineId", timelineId)
                .serviceEndpoint("recordId", recordId)
                .serviceEndpoint("type", type)
                .serviceEndpoint("name", attachmentName)
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
}
