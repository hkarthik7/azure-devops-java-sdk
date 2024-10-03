package org.azd.wiki;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.abstractions.ResponseHandler;
import org.azd.authentication.AccessTokenCredential;
import org.azd.wiki.attachments.WikiAttachmentsRequestBuilder;
import org.azd.wiki.pagemoves.PageMovesRequestBuilder;
import org.azd.wiki.pages.PagesRequestBuilder;
import org.azd.wiki.pagesbatch.PagesBatchRequestBuilder;
import org.azd.wiki.pagestats.PageStatsRequestBuilder;
import org.azd.wiki.wikis.WikisRequestBuilder;

/**
 * Provides functionality to work with Wiki Api.
 */
public class WikiRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public WikiRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential);
    }

    /**
     * Provides functionality to work with Wiki attachments Api.
     *
     * @return WikiAttachmentsRequestBuilder {@link WikiAttachmentsRequestBuilder}
     */
    public WikiAttachmentsRequestBuilder attachments() {
        return new WikiAttachmentsRequestBuilder(organizationUrl, accessTokenCredential);
    }

    /**
     * Provides functionality to work with Wiki page moves Api.
     *
     * @return WikiPageMovesRequestBuilder {@link PageMovesRequestBuilder}
     */
    public PageMovesRequestBuilder pageMoves() {
        return new PageMovesRequestBuilder(organizationUrl, accessTokenCredential);
    }

    /**
     * Provides functionality to work with Wiki page stats Api.
     *
     * @return WikiPageStatsRequestBuilder {@link PageStatsRequestBuilder}
     */
    public PageStatsRequestBuilder pageStats() {
        return new PageStatsRequestBuilder(organizationUrl, accessTokenCredential);
    }

    /**
     * Provides functionality to work with Wiki pages Api.
     *
     * @return PagesRequestBuilder {@link PagesRequestBuilder}
     */
    public PagesRequestBuilder pages() {
        return new PagesRequestBuilder(organizationUrl, accessTokenCredential);
    }

    /**
     * Provides functionality to work with Wiki pages batch Api.
     *
     * @return PagesBatchRequestBuilder {@link PagesBatchRequestBuilder}
     */
    public PagesBatchRequestBuilder pagesBatch() {
        return new PagesBatchRequestBuilder(organizationUrl, accessTokenCredential);
    }

    /**
     * Provides functionality to work with Wiki wikis Api.
     *
     * @return WikisRequestBuilder {@link WikisRequestBuilder}
     */
    public WikisRequestBuilder wikis() {
        return new WikisRequestBuilder(organizationUrl, accessTokenCredential);
    }


    /**
     * Helper method to inject the header value in json response.
     */
    public static String getETag() {
        var response = ResponseHandler.getResponse();
        if (response != null) {
            var headers = response.getResponseHeaders();
            if (headers.firstValue("etag").isPresent())
                return headers.firstValue("etag").get().replaceAll("\"", "");
        }
        return null;
    }
}
