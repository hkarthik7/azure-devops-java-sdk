package org.azd.wiki.pagestats;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.authentication.AccessTokenCredential;
import org.azd.exceptions.AzDException;
import org.azd.wiki.types.WikiPageDetail;

import java.util.concurrent.CompletableFuture;

/**
 * Provides functionality to work with Wiki page stats Api.
 */
public class PageStatsRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public PageStatsRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential, "wiki", "81c4e0fe-7663-4d62-ad46-6ab78459f274");
    }

    /**
     * Returns page detail corresponding to Page ID.
     *
     * @param pageId         Wiki page ID.
     * @param wikiIdentifier Wiki ID or wiki name.
     * @return Wiki page detail object {@link WikiPageDetail}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<WikiPageDetail> getAsync(int pageId, String wikiIdentifier) throws AzDException {
        return builder()
                .serviceEndpoint("pageId", pageId)
                .serviceEndpoint("wikiIdentifier", wikiIdentifier)
                .build()
                .executeAsync(WikiPageDetail.class);
    }

    /**
     * Returns page detail corresponding to Page ID.
     *
     * @param pageId           Wiki page ID.
     * @param wikiIdentifier   Wiki ID or wiki name.
     * @param pageViewsForDays last N days from the current day for which page views is to be returned.
     *                         It's inclusive of current day.
     * @return Wiki page detail object {@link WikiPageDetail}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<WikiPageDetail> getAsync(int pageId, String wikiIdentifier, int pageViewsForDays) throws AzDException {
        return builder()
                .serviceEndpoint("pageId", pageId)
                .serviceEndpoint("wikiIdentifier", wikiIdentifier)
                .query("pageViewsForDays", pageViewsForDays)
                .build()
                .executeAsync(WikiPageDetail.class);
    }

    /**
     * Returns page detail corresponding to Page ID.
     *
     * @param pageId         Wiki page ID.
     * @param wikiIdentifier Wiki ID or wiki name.
     * @return Wiki page detail object {@link WikiPageDetail}
     * @throws AzDException Default Api Exception handler.
     */
    public WikiPageDetail get(int pageId, String wikiIdentifier) throws AzDException {
        return builder()
                .serviceEndpoint("pageId", pageId)
                .serviceEndpoint("wikiIdentifier", wikiIdentifier)
                .build()
                .execute(WikiPageDetail.class);
    }

    /**
     * Returns page detail corresponding to Page ID.
     *
     * @param pageId           Wiki page ID.
     * @param wikiIdentifier   Wiki ID or wiki name.
     * @param pageViewsForDays last N days from the current day for which page views is to be returned.
     *                         It's inclusive of current day.
     * @return Wiki page detail object {@link WikiPageDetail}
     * @throws AzDException Default Api Exception handler.
     */
    public WikiPageDetail get(int pageId, String wikiIdentifier, int pageViewsForDays) throws AzDException {
        return builder()
                .serviceEndpoint("pageId", pageId)
                .serviceEndpoint("wikiIdentifier", wikiIdentifier)
                .query("pageViewsForDays", pageViewsForDays)
                .build()
                .execute(WikiPageDetail.class);
    }
}
