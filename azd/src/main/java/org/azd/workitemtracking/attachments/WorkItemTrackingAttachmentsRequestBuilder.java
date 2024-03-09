package org.azd.workitemtracking.attachments;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.abstractions.QueryParameter;
import org.azd.authentication.AccessTokenCredential;
import org.azd.common.ApiVersion;
import org.azd.enums.CustomHeader;
import org.azd.exceptions.AzDException;
import org.azd.helpers.StreamHelper;
import org.azd.workitemtracking.types.AttachmentReference;

import java.io.InputStream;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

/**
 * Provides functionality to work with work item attachments Api.
 */
public class WorkItemTrackingAttachmentsRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public WorkItemTrackingAttachmentsRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential, "wit", "e07b5fa4-1499-494d-a496-64b860fd64ff", ApiVersion.WORK_ITEM_ATTACHMENT);
    }

    /**
     * Uploads an attachment. On accounts with higher attachment upload limits (>130MB), you will need to use chunked upload.
     *
     * @param contents             Stream to upload. Payload to create the attachment.
     * @param requestConfiguration Represents the query parameters.
     * @return AttachmentReference {@link AttachmentReference}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<AttachmentReference> createAsync(InputStream contents,
                                                              Consumer<CreateRequestConfiguration> requestConfiguration)
            throws AzDException {
        return builder()
                .POST(contents)
                .query(CreateRequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .header(CustomHeader.STREAM)
                .build()
                .executeAsync(AttachmentReference.class);
    }

    /**
     * Downloads an attachment.
     *
     * @param id                   Attachment ID
     * @param requestConfiguration Represents the query parameters.
     * @return Stream of the attachment content. Use {@link StreamHelper} to download the attachment contents to a file.
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<InputStream> getAsync(String id, Consumer<GetRequestConfiguration> requestConfiguration)
            throws AzDException {
        return builder()
                .serviceEndpoint("id", id)
                .query(GetRequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .header(CustomHeader.STREAM_ACCEPT)
                .build()
                .executeStreamAsync();
    }

    /**
     * Downloads an attachment.
     *
     * @param id                   Attachment ID
     * @param requestConfiguration Represents the query parameters.
     * @return Stream of the attachment content. Use {@link StreamHelper} to download the attachment contents to a file.
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<InputStream> getAsZipAsync(String id, Consumer<GetRequestConfiguration> requestConfiguration)
            throws AzDException {
        return builder()
                .serviceEndpoint("id", id)
                .query(GetRequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .header(CustomHeader.STREAM_ZIP_ACCEPT)
                .build()
                .executeStreamAsync();
    }

    /**
     * Uploads an attachment. On accounts with higher attachment upload limits (>130MB), you will need to use chunked upload.
     *
     * @param contents             Stream to upload. Payload to create the attachment.
     * @param requestConfiguration Represents the query parameters.
     * @return AttachmentReference {@link AttachmentReference}
     * @throws AzDException Default Api exception handler.
     */
    public AttachmentReference create(InputStream contents,
                                      Consumer<CreateRequestConfiguration> requestConfiguration)
            throws AzDException {
        return builder()
                .POST(contents)
                .query(CreateRequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .header(CustomHeader.STREAM)
                .build()
                .execute(AttachmentReference.class);
    }

    /**
     * Downloads an attachment.
     *
     * @param id                   Attachment ID
     * @param requestConfiguration Represents the query parameters.
     * @return Stream of the attachment content. Use {@link StreamHelper} to download the attachment contents to a file.
     * @throws AzDException Default Api exception handler.
     */
    public InputStream get(String id, Consumer<GetRequestConfiguration> requestConfiguration)
            throws AzDException {
        return builder()
                .serviceEndpoint("id", id)
                .query(GetRequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .header(CustomHeader.STREAM_ACCEPT)
                .build()
                .executeStream();
    }

    /**
     * Downloads an attachment.
     *
     * @param id                   Attachment ID
     * @param requestConfiguration Represents the query parameters.
     * @return Stream of the attachment content. Use {@link StreamHelper} to download the attachment contents to a file.
     * @throws AzDException Default Api exception handler.
     */
    public InputStream getAsZip(String id, Consumer<GetRequestConfiguration> requestConfiguration)
            throws AzDException {
        return builder()
                .serviceEndpoint("id", id)
                .query(GetRequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .header(CustomHeader.STREAM_ZIP_ACCEPT)
                .build()
                .executeStream();
    }


    /**
     * Represents the query parameters.
     */
    public static class CreateQueryParameters {
        /**
         * Target project Area Path
         */
        @QueryParameter(name = "areaPath")
        public String areaPath;
        /**
         * The name of the file
         */
        @QueryParameter(name = "fileName")
        public String fileName;
        /**
         * Attachment upload type: Simple or Chunked
         */
        @QueryParameter(name = "uploadType")
        public String uploadType;
    }

    /**
     * Request configuration object for the query parameters.
     */
    public static class CreateRequestConfiguration {
        public CreateQueryParameters queryParameters = new CreateQueryParameters();
    }

    /**
     * Represents the query parameters.
     */
    public static class GetQueryParameters {
        /**
         * The name of the file
         */
        @QueryParameter(name = "fileName")
        public String fileName;
        /**
         * If set to true always download attachment
         */
        @QueryParameter(name = "download")
        public Boolean download;
    }

    /**
     * Request configuration object for the query parameters.
     */
    public static class GetRequestConfiguration {
        public GetQueryParameters queryParameters = new GetQueryParameters();
    }
}
