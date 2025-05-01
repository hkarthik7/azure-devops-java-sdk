package org.azd.wiki.pagemoves;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.abstractions.QueryParameter;
import org.azd.authentication.AccessTokenCredential;
import org.azd.common.ApiVersion;
import org.azd.enums.GitVersionOptions;
import org.azd.enums.GitVersionType;
import org.azd.exceptions.AzDException;
import org.azd.wiki.WikiRequestBuilder;
import org.azd.wiki.types.WikiPageMove;
import org.azd.wiki.types.WikiPageMoveParameters;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

/**
 * Provides functionality to work with Wiki Page moves Api.
 */
public class PageMovesRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public PageMovesRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential, "wiki", "e37bbe71-cbae-49e5-9a4e-949143b9d910", ApiVersion.WIKI_PAGES);
    }

    /**
     * Creates a page move operation that updates the path and order of the page as provided in the parameters.
     *
     * @param wikiIdentifier         Wiki ID or wiki name.
     * @param wikiPageMoveParameters Request body to create page move.
     * @return Wiki page move object {@link WikiPageMove}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<WikiPageMove> createAsync(String wikiIdentifier,
                                                       WikiPageMoveParameters wikiPageMoveParameters) throws AzDException {
        return builder()
                .POST(wikiPageMoveParameters)
                .serviceEndpoint("wikiIdentifier", wikiIdentifier)
                .build()
                .executeAsync(WikiPageMove.class)
                .thenApplyAsync(x -> {
                    x.seteTag(WikiRequestBuilder.getETag());
                    return x;
                });
    }

    /**
     * Creates a page move operation that updates the path and order of the page as provided in the parameters.
     *
     * @param wikiIdentifier         Wiki ID or wiki name.
     * @param requestConfiguration   Represents query parameters.
     * @param wikiPageMoveParameters Request body to create page move.
     * @return Wiki page move object {@link WikiPageMove}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<WikiPageMove> createAsync(String wikiIdentifier,
                                                       Consumer<RequestConfiguration> requestConfiguration,
                                                       WikiPageMoveParameters wikiPageMoveParameters) throws AzDException {
        return builder()
                .POST(wikiPageMoveParameters)
                .serviceEndpoint("wikiIdentifier", wikiIdentifier)
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .executeAsync(WikiPageMove.class)
                .thenApplyAsync(x -> {
                    x.seteTag(WikiRequestBuilder.getETag());
                    return x;
                });
    }

    /**
     * Creates a page move operation that updates the path and order of the page as provided in the parameters.
     *
     * @param wikiIdentifier         Wiki ID or wiki name.
     * @param wikiPageMoveParameters Request body to create page move.
     * @return Wiki page move object {@link WikiPageMove}
     * @throws AzDException Default Api Exception handler.
     */
    public WikiPageMove create(String wikiIdentifier,
                               WikiPageMoveParameters wikiPageMoveParameters) throws AzDException {
        var resp = builder()
                .POST(wikiPageMoveParameters)
                .serviceEndpoint("wikiIdentifier", wikiIdentifier)
                .build()
                .execute(WikiPageMove.class);

        resp.seteTag(WikiRequestBuilder.getETag());

        return resp;
    }

    /**
     * Creates a page move operation that updates the path and order of the page as provided in the parameters.
     *
     * @param wikiIdentifier         Wiki ID or wiki name.
     * @param requestConfiguration   Represents query parameters.
     * @param wikiPageMoveParameters Request body to create page move.
     * @return Wiki page move object {@link WikiPageMove}
     * @throws AzDException Default Api Exception handler.
     */
    public WikiPageMove create(String wikiIdentifier,
                               Consumer<RequestConfiguration> requestConfiguration,
                               WikiPageMoveParameters wikiPageMoveParameters) throws AzDException {
        var resp = builder()
                .POST(wikiPageMoveParameters)
                .serviceEndpoint("wikiIdentifier", wikiIdentifier)
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .execute(WikiPageMove.class);

        resp.seteTag(WikiRequestBuilder.getETag());

        return resp;
    }


    /**
     * Represents the query parameters.
     */
    public static class GetQueryParameters {
        /**
         * Comment that is to be associated with this page move.
         */
        @QueryParameter(name = "comment")
        public String comment;
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
