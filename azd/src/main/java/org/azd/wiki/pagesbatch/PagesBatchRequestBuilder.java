package org.azd.wiki.pagesbatch;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.abstractions.QueryParameter;
import org.azd.authentication.AccessTokenCredential;
import org.azd.enums.GitVersionOptions;
import org.azd.enums.GitVersionType;
import org.azd.exceptions.AzDException;
import org.azd.wiki.types.WikiPageDetails;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

/**
 * Provides functionality to work with Wiki pages batch Api.
 */
public class PagesBatchRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public PagesBatchRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential, "wiki", "71323c46-2592-4398-8771-ced73dd87207");
    }

    /**
     * Returns pageable list of Wiki Pages
     *
     * @param wikiIdentifier        Wiki ID or wiki name.
     * @param wikiPagesBatchRequest Contract encapsulating parameters for the pages batch.
     * @return Collection of Wiki page detail. {@link WikiPageDetails}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<WikiPageDetails> getAsync(String wikiIdentifier, Consumer<WikiPagesBatchRequest> wikiPagesBatchRequest)
            throws AzDException {
        var batchRequest = new WikiPagesBatchRequest();
        wikiPagesBatchRequest.accept(batchRequest);

        return builder()
                .POST(batchRequest)
                .serviceEndpoint("wikiIdentifier", wikiIdentifier)
                .build()
                .executeAsync(WikiPageDetails.class);
    }

    /**
     * Returns pageable list of Wiki Pages
     *
     * @param wikiIdentifier        Wiki ID or wiki name.
     * @param wikiPagesBatchRequest Contract encapsulating parameters for the pages batch.
     * @param requestConfiguration  Represents the query parameters.
     * @return Collection of Wiki page detail. {@link WikiPageDetails}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<WikiPageDetails> getAsync(String wikiIdentifier,
                                                       Consumer<WikiPagesBatchRequest> wikiPagesBatchRequest,
                                                       Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        var batchRequest = new WikiPagesBatchRequest();
        wikiPagesBatchRequest.accept(batchRequest);

        return builder()
                .POST(batchRequest)
                .serviceEndpoint("wikiIdentifier", wikiIdentifier)
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .executeAsync(WikiPageDetails.class);
    }

    /**
     * Returns pageable list of Wiki Pages
     *
     * @param wikiIdentifier        Wiki ID or wiki name.
     * @param wikiPagesBatchRequest Contract encapsulating parameters for the pages batch.
     * @return Collection of Wiki page detail. {@link WikiPageDetails}
     * @throws AzDException Default Api exception handler.
     */
    public WikiPageDetails get(String wikiIdentifier, Consumer<WikiPagesBatchRequest> wikiPagesBatchRequest)
            throws AzDException {
        var batchRequest = new WikiPagesBatchRequest();
        wikiPagesBatchRequest.accept(batchRequest);

        return builder()
                .POST(batchRequest)
                .serviceEndpoint("wikiIdentifier", wikiIdentifier)
                .build()
                .execute(WikiPageDetails.class);
    }

    /**
     * Returns pageable list of Wiki Pages
     *
     * @param wikiIdentifier        Wiki ID or wiki name.
     * @param wikiPagesBatchRequest Contract encapsulating parameters for the pages batch.
     * @param requestConfiguration  Represents the query parameters.
     * @return Collection of Wiki page detail. {@link WikiPageDetails}
     * @throws AzDException Default Api exception handler.
     */
    public WikiPageDetails get(String wikiIdentifier,
                               Consumer<WikiPagesBatchRequest> wikiPagesBatchRequest,
                               Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        var batchRequest = new WikiPagesBatchRequest();
        wikiPagesBatchRequest.accept(batchRequest);

        return builder()
                .POST(batchRequest)
                .serviceEndpoint("wikiIdentifier", wikiIdentifier)
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .execute(WikiPageDetails.class);
    }

    /**
     * Represents the query parameters.
     */
    public static class WikiPagesBatchRequest {
        /**
         * If the list of page data returned is not complete, a continuation token to query next batch of pages is
         * included in the response header as "x-ms-continuationtoken".
         * Omit this parameter to get the first batch of Wiki Page Data.
         */
        public String continuationToken;
        /**
         * last N days from the current day for which page views is to be returned. It's inclusive of current day.
         */
        public Integer pageViewsForDays;
        /**
         * Total count of pages on a wiki to return.
         */
        public Integer top;
    }


    /**
     * Represents the query parameters.
     */
    public static class GetQueryParameters {
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
