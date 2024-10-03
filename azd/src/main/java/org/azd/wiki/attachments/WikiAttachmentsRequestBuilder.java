package org.azd.wiki.attachments;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.abstractions.QueryParameter;
import org.azd.authentication.AccessTokenCredential;
import org.azd.common.ApiVersion;
import org.azd.enums.CustomHeader;
import org.azd.enums.GitVersionOptions;
import org.azd.enums.GitVersionType;
import org.azd.exceptions.AzDException;
import org.azd.helpers.StreamHelper;
import org.azd.wiki.WikiRequestBuilder;
import org.azd.wiki.types.WikiAttachment;

import java.io.InputStream;
import java.net.http.HttpRequest;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

/**
 * Provides functionality to work with Wiki attachments Api.
 */
public class WikiAttachmentsRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public WikiAttachmentsRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential, "wiki", "c4382d8d-fefc-40e0-92c5-49852e9e17c0", ApiVersion.WIKI_ATTACHMENTS);
    }

    /**
     * Creates an attachment in the wiki.
     *
     * @param wikiIdentifier       Wiki ID or wiki name.
     * @param requestConfiguration Represents the query parameters.
     * @param streamToUpload       Input stream contents to upload.
     * @return WikiAttachment Object {@link WikiAttachment}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<WikiAttachment> createAsync(String wikiIdentifier,
                                                         Consumer<RequestConfiguration> requestConfiguration,
                                                         InputStream streamToUpload) throws AzDException {
        return builder()
                .PUT(HttpRequest.BodyPublishers.ofString(StreamHelper.convertStreamToBase64(streamToUpload)))
                .serviceEndpoint("wikiIdentifier", wikiIdentifier)
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .header(CustomHeader.STREAM)
                .build()
                .executeAsync(WikiAttachment.class)
                .thenApplyAsync(x -> {
                    x.seteTag(WikiRequestBuilder.getETag());
                    return x;
                });
    }

    /**
     * Creates an attachment in the wiki.
     *
     * @param wikiIdentifier       Wiki ID or wiki name.
     * @param requestConfiguration Represents the query parameters.
     * @param streamToUpload       Input stream contents to upload.
     * @return WikiAttachment Object {@link WikiAttachment}
     * @throws AzDException Default Api Exception handler.
     */
    public WikiAttachment create(String wikiIdentifier, Consumer<RequestConfiguration> requestConfiguration,
                                 InputStream streamToUpload) throws AzDException {
        var resp = builder()
                .PUT(HttpRequest.BodyPublishers.ofString(StreamHelper.convertStreamToBase64(streamToUpload)))
                .serviceEndpoint("wikiIdentifier", wikiIdentifier)
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .header(CustomHeader.STREAM)
                .build()
                .execute(WikiAttachment.class);

        resp.seteTag(WikiRequestBuilder.getETag());

        return resp;
    }

    /**
     * Represents the query parameters.
     */
    public static class GetQueryParameters {
        /**
         * Wiki attachment name.
         */
        @QueryParameter(name = "name")
        public String name;
        /**
         * Version string identifier (name of tag/branch, SHA1 of commit)
         */
        @QueryParameter(name = "versionDescriptor.version")
        public String version;
        /**
         * Version options - Specify additional modifiers to version (e.g Previous)
         */
        @QueryParameter(name = "versionDescriptor.versionOptions")
        public GitVersionOptions versionOptions;
        /**
         * Version type (branch, tag, or commit). Determines how Id is interpreted
         */
        @QueryParameter(name = "versionDescriptor.versionType")
        public GitVersionType versionType;
    }

    /**
     * Request configuration object for the query parameters.
     */
    public static class RequestConfiguration {
        public GetQueryParameters queryParameters = new GetQueryParameters();
    }
}
