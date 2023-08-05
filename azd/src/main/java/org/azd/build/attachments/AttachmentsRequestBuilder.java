package org.azd.build.attachments;

import org.azd.build.types.Attachments;
import org.azd.common.ApiVersion;
import org.azd.enums.CustomHeader;
import org.azd.exceptions.AzDException;
import org.azd.http.RequestInformation;
import org.azd.interfaces.AccessTokenCredential;
import org.azd.interfaces.RequestAdapter;
import org.azd.utils.BaseRequestBuilder;

import java.io.InputStream;
import java.text.MessageFormat;
import java.util.concurrent.CompletableFuture;

/**
 * Provides the functionality to manage Build Attachments Api.
 */
public class AttachmentsRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new request builder instance and sets the default values.
     * @param accessTokenCredential Authentication provider {@link AccessTokenCredential}.
     * @param requestAdapter The request adapter to execute the requests.
     */
    public AttachmentsRequestBuilder(AccessTokenCredential accessTokenCredential, RequestAdapter requestAdapter) {
        super(accessTokenCredential, requestAdapter, "build/builds", ApiVersion.BUILD_ATTACHMENTS);
    }

    /**
     * Gets the attachment of a specific type that are associated with a build.
     * @param buildId The ID of the build.
     * @param timelineId The ID of the timeline.
     * @param recordId The ID of the timeline record.
     * @param type The type of the attachment.
     * @param attachmentName The name of the attachment.
     * @return Returns a future of response stream
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<InputStream> get(int buildId, String timelineId, String recordId,
                                                         String type, String attachmentName) throws AzDException {
        var reqInfo = toGetInformation(buildId, type);
        reqInfo.serviceEndpoint = MessageFormat.format("{0}/{1}/{2}/{3}/attachments/{4}/{5}",
                service, Integer.toString(buildId), timelineId, recordId, type, attachmentName);
        reqInfo.requestHeaders.add(CustomHeader.STREAM_ACCEPT);
        return requestAdapter.sendStreamAsync(reqInfo);
    }

    /**
     * Gets the list of attachments of a specific type that are associated with a build.
     *
     * @param buildId The ID of the build.
     * @param type The type of attachment.
     * @return Attachments future Object {@link Attachments}
     * @throws AzDException Default Api Exception handler.
     **/
    public CompletableFuture<Attachments> list(int buildId, String type) throws AzDException {
        var reqInfo = toGetInformation(buildId, type);
        return requestAdapter.sendAsync(reqInfo, Attachments.class);
    }

    /**
     * Constructs the request information for Build Attachments Api.
     * @param buildId ID of the build.
     * @param type The type of attachment.
     * @return Request information object {@link RequestInformation}
     */
    private RequestInformation toGetInformation(int buildId, String type) {
        var reqInfo = new RequestInformation();
        reqInfo.project = project;
        reqInfo.serviceEndpoint = MessageFormat.format("{0}/{1}/attachments/{2}", service, Integer.toString(buildId), type);
        reqInfo.apiVersion = apiVersion;
        return reqInfo;
    }
}
