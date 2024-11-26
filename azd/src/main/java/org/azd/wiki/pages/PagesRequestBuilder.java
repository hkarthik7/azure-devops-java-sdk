package org.azd.wiki.pages;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.abstractions.QueryParameter;
import org.azd.authentication.AccessTokenCredential;
import org.azd.common.ApiVersion;
import org.azd.enums.CustomHeader;
import org.azd.enums.GitVersionOptions;
import org.azd.enums.GitVersionType;
import org.azd.enums.VersionControlRecursionType;
import org.azd.exceptions.AzDException;
import org.azd.wiki.WikiRequestBuilder;
import org.azd.wiki.types.WikiCreateOrUpdateParameters;
import org.azd.wiki.types.WikiPage;
import org.azd.wiki.types.WikiUpdateParameters;

import java.io.InputStream;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

import static org.azd.helpers.Utils.isNullOrEmpty;

/**
 * Provides functionality to work with Wiki pages Api.
 */
public class PagesRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public PagesRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential, "wiki", "25d3fbc7-fe3d-46cb-b5a5-0b6f79caf27b", ApiVersion.WIKI_PAGES);
    }

    /**
     * Creates or edits a wiki page.
     *
     * @param wikiCreateOrUpdateParameters Create or update parameters. eTag is mandatory for <strong>Edit</strong> scenario.
     * @param requestConfiguration         Represents the query parameters. Parameter <strong>path</strong> is mandatory.
     * @return WikiPage Object {@link WikiPage}
     * @throws AzDException Default Api Exception handler.
     **/
    public CompletableFuture<WikiPage> createOrUpdateAsync(WikiCreateOrUpdateParameters wikiCreateOrUpdateParameters,
                                                           Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        Objects.requireNonNull(wikiCreateOrUpdateParameters, "Parameters cannot be null.");
        var builder = builder()
                .PUT(Map.of("content", wikiCreateOrUpdateParameters.content))
                .serviceEndpoint("wikiIdentifier", wikiCreateOrUpdateParameters.wikiIdentifier)
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters);

        // For Edit scenario
        if (!isNullOrEmpty(wikiCreateOrUpdateParameters.eTagVersion)) {
            CustomHeader.CUSTOM_HEADER.setCustomHeaders("If-Match", wikiCreateOrUpdateParameters.eTagVersion);
            builder.header(CustomHeader.CUSTOM_HEADER);
        }

        return builder
                .build()
                .executeAsync(WikiPage.class)
                .thenApplyAsync(x -> {
                    x.seteTag(WikiRequestBuilder.getETag());
                    return x;
                });
    }

    /**
     * Deletes a wiki page.
     *
     * @param wikiIdentifier       Wiki ID or wiki name.
     * @param requestConfiguration Represents the query parameters. Parameter <strong>path</strong> is mandatory.
     * @return WikiPage Object {@link WikiPage}
     * @throws AzDException Default Api Exception handler.
     **/
    public CompletableFuture<WikiPage> deleteAsync(String wikiIdentifier, Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .DELETE()
                .serviceEndpoint("wikiIdentifier", wikiIdentifier)
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .executeAsync(WikiPage.class)
                .thenApplyAsync(x -> {
                    x.seteTag(WikiRequestBuilder.getETag());
                    return x;
                });
    }

    /**
     * Deletes a wiki page.
     *
     * @param id                   Wiki page ID.
     * @param wikiIdentifier       Wiki ID or wiki name.
     * @param requestConfiguration Represents the query parameters.
     * @return WikiPage Object {@link WikiPage}
     * @throws AzDException Default Api Exception handler.
     **/
    public CompletableFuture<WikiPage> deleteByIdAsync(String wikiIdentifier, int id, Consumer<DeleteRequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .DELETE()
                .location("ceddcf75-1068-452d-8b13-2d4d76e1f970")
                .serviceEndpoint("wikiIdentifier", wikiIdentifier)
                .serviceEndpoint("id", id)
                .query(DeleteRequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .executeAsync(WikiPage.class)
                .thenApplyAsync(x -> {
                    x.seteTag(WikiRequestBuilder.getETag());
                    return x;
                });
    }

    /**
     * Gets metadata of the wiki page for the provided path.
     *
     * @param wikiIdentifier Wiki ID or wiki name.
     * @return WikiPage Object {@link WikiPage}
     * @throws AzDException Default Api Exception handler.
     **/
    public CompletableFuture<WikiPage> getAsync(String wikiIdentifier) throws AzDException {
        return builder()
                .serviceEndpoint("wikiIdentifier", wikiIdentifier)
                .build()
                .executeAsync(WikiPage.class)
                .thenApplyAsync(x -> {
                    x.seteTag(WikiRequestBuilder.getETag());
                    return x;
                });
    }

    /**
     * Gets metadata of the wiki page for the provided path.
     *
     * @param wikiIdentifier       Wiki ID or wiki name.
     * @param requestConfiguration Represents the query parameters.
     * @return WikiPage Object {@link WikiPage}
     * @throws AzDException Default Api Exception handler.
     **/
    public CompletableFuture<WikiPage> getAsync(String wikiIdentifier, Consumer<GetRequestConfiguration> requestConfiguration)
            throws AzDException {
        return builder()
                .serviceEndpoint("wikiIdentifier", wikiIdentifier)
                .query(GetRequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .executeAsync(WikiPage.class)
                .thenApplyAsync(x -> {
                    x.seteTag(WikiRequestBuilder.getETag());
                    return x;
                });
    }

    /**
     * Gets metadata of the wiki page for the provided path.
     *
     * @param wikiIdentifier       Wiki ID or wiki name.
     * @param requestConfiguration Represents the query parameters.
     * @return The wiki page content.
     * @throws AzDException Default Api Exception handler.
     **/
    public CompletableFuture<String> getAsTextAsync(String wikiIdentifier, Consumer<GetRequestConfiguration> requestConfiguration)
            throws AzDException {
        return builder()
                .serviceEndpoint("wikiIdentifier", wikiIdentifier)
                .query(GetRequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .header(CustomHeader.TEXT_CONTENT)
                .build()
                .executeStringAsync();
    }

    /**
     * Gets metadata of the wiki page for the provided path.
     *
     * @param wikiIdentifier       Wiki ID or wiki name.
     * @param requestConfiguration Represents the query parameters.
     * @return The wiki page contents as input stream. Use {@link org.azd.helpers.StreamHelper} to download the contents as zip.
     * @throws AzDException Default Api Exception handler.
     **/
    public CompletableFuture<InputStream> getAsZipAsync(String wikiIdentifier, Consumer<GetRequestConfiguration> requestConfiguration)
            throws AzDException {
        return builder()
                .serviceEndpoint("wikiIdentifier", wikiIdentifier)
                .query(GetRequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .header(CustomHeader.STREAM_ZIP_ACCEPT)
                .build()
                .executeStreamAsync();
    }

    /**
     * Gets metadata or content of the wiki page for the provided page id.
     *
     * @param wikiIdentifier Wiki ID or wiki name.
     * @param id             Wiki page ID.
     * @return WikiPage Object {@link WikiPage}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<WikiPage> getByIdAsync(String wikiIdentifier, int id) throws AzDException {
        return builder()
                .location("ceddcf75-1068-452d-8b13-2d4d76e1f970")
                .serviceEndpoint("wikiIdentifier", wikiIdentifier)
                .serviceEndpoint("id", id)
                .build()
                .executeAsync(WikiPage.class)
                .thenApplyAsync(x -> {
                    x.seteTag(WikiRequestBuilder.getETag());
                    return x;
                });
    }

    /**
     * Gets metadata or content of the wiki page for the provided page id.
     *
     * @param wikiIdentifier       Wiki ID or wiki name.
     * @param requestConfiguration Represents the query parameters.
     * @param id                   Wiki page ID.
     * @return WikiPage Object {@link WikiPage}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<WikiPage> getByIdAsync(String wikiIdentifier, int id,
                                                    Consumer<GetByIdRequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .location("ceddcf75-1068-452d-8b13-2d4d76e1f970")
                .serviceEndpoint("wikiIdentifier", wikiIdentifier)
                .serviceEndpoint("id", id)
                .query(GetByIdRequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .executeAsync(WikiPage.class)
                .thenApplyAsync(x -> {
                    x.seteTag(WikiRequestBuilder.getETag());
                    return x;
                });
    }

    /**
     * Gets metadata or content of the wiki page for the provided page id.
     *
     * @param wikiIdentifier       Wiki ID or wiki name.
     * @param requestConfiguration Represents the query parameters.
     * @param id                   Wiki page ID.
     * @return Wiki page context.
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<String> getByIdAsTextAsync(String wikiIdentifier, int id,
                                                        Consumer<GetByIdRequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .location("ceddcf75-1068-452d-8b13-2d4d76e1f970")
                .serviceEndpoint("wikiIdentifier", wikiIdentifier)
                .serviceEndpoint("id", id)
                .query(GetByIdRequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .header(CustomHeader.TEXT_CONTENT)
                .build()
                .executeStringAsync();
    }

    /**
     * Gets metadata or content of the wiki page for the provided page id.
     *
     * @param wikiIdentifier       Wiki ID or wiki name.
     * @param requestConfiguration Represents the query parameters.
     * @param id                   Wiki page ID.
     * @return Wiki page(s) as zip content. Use {@link org.azd.helpers.StreamHelper} to download the contents as zip.
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<InputStream> getByIdAsZipAsync(String wikiIdentifier, int id,
                                                            Consumer<GetByIdRequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .location("ceddcf75-1068-452d-8b13-2d4d76e1f970")
                .serviceEndpoint("wikiIdentifier", wikiIdentifier)
                .serviceEndpoint("id", id)
                .query(GetByIdRequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .header(CustomHeader.STREAM_ZIP_ACCEPT)
                .build()
                .executeStreamAsync();
    }

    /**
     * Edits a wiki page.
     *
     * @param wikiUpdateParameters Wiki update parameters to edit the page.
     * @return Wiki page object {@link WikiPage}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<WikiPage> updateAsync(WikiUpdateParameters wikiUpdateParameters) throws AzDException {
        Objects.requireNonNull(wikiUpdateParameters, "Parameters cannot be null.");
        CustomHeader.CUSTOM_HEADER.setCustomHeaders("If-Match", wikiUpdateParameters.eTagVersion);

        return builder()
                .location("ceddcf75-1068-452d-8b13-2d4d76e1f970")
                .PATCH(Map.of("content", wikiUpdateParameters.content))
                .serviceEndpoint("id", wikiUpdateParameters.id)
                .serviceEndpoint("wikiIdentifier", wikiUpdateParameters.wikiIdentifier)
                .query("comment", wikiUpdateParameters.comment)
                .header(CustomHeader.CUSTOM_HEADER)
                .build()
                .executeAsync(WikiPage.class)
                .thenApplyAsync(x -> {
                    x.seteTag(WikiRequestBuilder.getETag());
                    return x;
                });
    }

    /**
     * Creates or edits a wiki page.
     *
     * @param wikiCreateOrUpdateParameters Create or update parameters. eTag is mandatory for <strong>Edit</strong> scenario.
     * @param requestConfiguration         Represents the query parameters. Parameter <strong>path</strong> is mandatory.
     * @return WikiPage Object {@link WikiPage}
     * @throws AzDException Default Api Exception handler.
     **/
    public WikiPage createOrUpdate(WikiCreateOrUpdateParameters wikiCreateOrUpdateParameters,
                                   Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        Objects.requireNonNull(wikiCreateOrUpdateParameters, "Parameters cannot be null.");
        var builder = builder()
                .PUT(Map.of("content", wikiCreateOrUpdateParameters.content))
                .serviceEndpoint("wikiIdentifier", wikiCreateOrUpdateParameters.wikiIdentifier)
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters);

        // For Edit scenario
        if (!isNullOrEmpty(wikiCreateOrUpdateParameters.eTagVersion)) {
            CustomHeader.CUSTOM_HEADER.setCustomHeaders("If-Match", wikiCreateOrUpdateParameters.eTagVersion);
            builder.header(CustomHeader.CUSTOM_HEADER);
        }

        var res = builder
                .build()
                .execute(WikiPage.class);

        res.seteTag(WikiRequestBuilder.getETag());

        return res;
    }

    /**
     * Deletes a wiki page.
     *
     * @param wikiIdentifier       Wiki ID or wiki name.
     * @param requestConfiguration Represents the query parameters. Parameter <strong>path</strong> is mandatory.
     * @return WikiPage Object {@link WikiPage}
     * @throws AzDException Default Api Exception handler.
     **/
    public WikiPage delete(String wikiIdentifier, Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        var res = builder()
                .DELETE()
                .serviceEndpoint("wikiIdentifier", wikiIdentifier)
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .execute(WikiPage.class);

        res.seteTag(WikiRequestBuilder.getETag());

        return res;
    }

    /**
     * Deletes a wiki page.
     *
     * @param id                   Wiki page ID.
     * @param wikiIdentifier       Wiki ID or wiki name.
     * @param requestConfiguration Represents the query parameters.
     * @return WikiPage Object {@link WikiPage}
     * @throws AzDException Default Api Exception handler.
     **/
    public WikiPage deleteById(String wikiIdentifier, int id, Consumer<DeleteRequestConfiguration> requestConfiguration) throws AzDException {
        var res = builder()
                .DELETE()
                .location("ceddcf75-1068-452d-8b13-2d4d76e1f970")
                .serviceEndpoint("wikiIdentifier", wikiIdentifier)
                .serviceEndpoint("id", id)
                .query(DeleteRequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .execute(WikiPage.class);

        res.seteTag(WikiRequestBuilder.getETag());

        return res;
    }

    /**
     * Gets metadata of the wiki page for the provided path.
     *
     * @param wikiIdentifier Wiki ID or wiki name.
     * @return WikiPage Object {@link WikiPage}
     * @throws AzDException Default Api Exception handler.
     **/
    public WikiPage get(String wikiIdentifier) throws AzDException {
        var res = builder()
                .serviceEndpoint("wikiIdentifier", wikiIdentifier)
                .build()
                .execute(WikiPage.class);

        res.seteTag(WikiRequestBuilder.getETag());

        return res;
    }

    /**
     * Gets metadata of the wiki page for the provided path.
     *
     * @param wikiIdentifier       Wiki ID or wiki name.
     * @param requestConfiguration Represents the query parameters.
     * @return WikiPage Object {@link WikiPage}
     * @throws AzDException Default Api Exception handler.
     **/
    public WikiPage get(String wikiIdentifier, Consumer<GetRequestConfiguration> requestConfiguration)
            throws AzDException {
        var res = builder()
                .serviceEndpoint("wikiIdentifier", wikiIdentifier)
                .query(GetRequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .execute(WikiPage.class);

        res.seteTag(WikiRequestBuilder.getETag());

        return res;
    }

    /**
     * Gets metadata of the wiki page for the provided path.
     *
     * @param wikiIdentifier       Wiki ID or wiki name.
     * @param requestConfiguration Represents the query parameters.
     * @return The wiki page content.
     * @throws AzDException Default Api Exception handler.
     **/
    public String getAsText(String wikiIdentifier, Consumer<GetRequestConfiguration> requestConfiguration)
            throws AzDException {
        return builder()
                .serviceEndpoint("wikiIdentifier", wikiIdentifier)
                .query(GetRequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .header(CustomHeader.TEXT_CONTENT)
                .build()
                .executeString();
    }

    /**
     * Gets metadata of the wiki page for the provided path.
     *
     * @param wikiIdentifier       Wiki ID or wiki name.
     * @param requestConfiguration Represents the query parameters.
     * @return The wiki page contents as input stream. Use {@link org.azd.helpers.StreamHelper} to download the contents as zip.
     * @throws AzDException Default Api Exception handler.
     **/
    public InputStream getAsZip(String wikiIdentifier, Consumer<GetRequestConfiguration> requestConfiguration)
            throws AzDException {
        return builder()
                .serviceEndpoint("wikiIdentifier", wikiIdentifier)
                .query(GetRequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .header(CustomHeader.STREAM_ZIP_ACCEPT)
                .build()
                .executeStream();
    }

    /**
     * Gets metadata or content of the wiki page for the provided page id.
     *
     * @param wikiIdentifier Wiki ID or wiki name.
     * @param id             Wiki page ID.
     * @return WikiPage Object {@link WikiPage}
     * @throws AzDException Default Api Exception handler.
     */
    public WikiPage getById(String wikiIdentifier, int id) throws AzDException {
        var res = builder()
                .location("ceddcf75-1068-452d-8b13-2d4d76e1f970")
                .serviceEndpoint("wikiIdentifier", wikiIdentifier)
                .serviceEndpoint("id", id)
                .build()
                .execute(WikiPage.class);

        res.seteTag(WikiRequestBuilder.getETag());

        return res;
    }

    /**
     * Gets metadata or content of the wiki page for the provided page id.
     *
     * @param wikiIdentifier       Wiki ID or wiki name.
     * @param requestConfiguration Represents the query parameters.
     * @param id                   Wiki page ID.
     * @return WikiPage Object {@link WikiPage}
     * @throws AzDException Default Api Exception handler.
     */
    public WikiPage getById(String wikiIdentifier, int id,
                            Consumer<GetByIdRequestConfiguration> requestConfiguration) throws AzDException {
        var res = builder()
                .location("ceddcf75-1068-452d-8b13-2d4d76e1f970")
                .serviceEndpoint("wikiIdentifier", wikiIdentifier)
                .serviceEndpoint("id", id)
                .query(GetByIdRequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .execute(WikiPage.class);

        res.seteTag(WikiRequestBuilder.getETag());

        return res;
    }

    /**
     * Gets metadata or content of the wiki page for the provided page id.
     *
     * @param wikiIdentifier       Wiki ID or wiki name.
     * @param requestConfiguration Represents the query parameters.
     * @param id                   Wiki page ID.
     * @return Wiki page context.
     * @throws AzDException Default Api Exception handler.
     */
    public String getByIdAsText(String wikiIdentifier, int id,
                                Consumer<GetByIdRequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .location("ceddcf75-1068-452d-8b13-2d4d76e1f970")
                .serviceEndpoint("wikiIdentifier", wikiIdentifier)
                .serviceEndpoint("id", id)
                .query(GetByIdRequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .header(CustomHeader.TEXT_CONTENT)
                .build()
                .executeString();
    }

    /**
     * Gets metadata or content of the wiki page for the provided page id.
     *
     * @param wikiIdentifier       Wiki ID or wiki name.
     * @param requestConfiguration Represents the query parameters.
     * @param id                   Wiki page ID.
     * @return Wiki page(s) as zip content. Use {@link org.azd.helpers.StreamHelper} to download the contents as zip.
     * @throws AzDException Default Api Exception handler.
     */
    public InputStream getByIdAsZip(String wikiIdentifier, int id,
                                    Consumer<GetByIdRequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .location("ceddcf75-1068-452d-8b13-2d4d76e1f970")
                .serviceEndpoint("wikiIdentifier", wikiIdentifier)
                .serviceEndpoint("id", id)
                .query(GetByIdRequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .header(CustomHeader.STREAM_ZIP_ACCEPT)
                .build()
                .executeStream();
    }

    /**
     * Edits a wiki page.
     *
     * @param wikiUpdateParameters Wiki update parameters to edit the page.
     * @return Wiki page object {@link WikiPage}
     * @throws AzDException Default Api Exception handler.
     */
    public WikiPage update(WikiUpdateParameters wikiUpdateParameters) throws AzDException {
        Objects.requireNonNull(wikiUpdateParameters, "Parameters cannot be null.");
        CustomHeader.CUSTOM_HEADER.setCustomHeaders("If-Match", wikiUpdateParameters.eTagVersion);

        var res = builder()
                .location("ceddcf75-1068-452d-8b13-2d4d76e1f970")
                .PATCH(Map.of("content", wikiUpdateParameters.content))
                .serviceEndpoint("id", wikiUpdateParameters.id)
                .serviceEndpoint("wikiIdentifier", wikiUpdateParameters.wikiIdentifier)
                .query("comment", wikiUpdateParameters.comment)
                .header(CustomHeader.CUSTOM_HEADER)
                .build()
                .execute(WikiPage.class);

        res.seteTag(WikiRequestBuilder.getETag());

        return res;
    }

    /**
     * Represents the query parameters.
     */
    public static class QueryParameters {
        /**
         * Wiki page path.
         */
        @QueryParameter(name = "path")
        public String path;
        /**
         * Comment to be associated with the page operation.
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
        public QueryParameters queryParameters = new QueryParameters();
    }

    /**
     * Represents the query parameters.
     */
    public static class DeleteQueryParameters {
        /**
         * Comment to be associated with the page operation.
         */
        @QueryParameter(name = "comment")
        public String comment;
    }

    /**
     * Request configuration object for the query parameters.
     */
    public static class DeleteRequestConfiguration {
        public DeleteQueryParameters queryParameters = new DeleteQueryParameters();
    }

    /**
     * Represents the query parameters.
     */
    public static class GetQueryParameters {
        /**
         * True to include the content of the page in the response for Json content type. Defaults to false (Optional)
         */
        @QueryParameter(name = "includeContent")
        public Boolean includeContent;
        /**
         * Wiki page path.
         */
        @QueryParameter(name = "path")
        public String path;
        /**
         * Recursion level for subpages retrieval. Defaults to None (Optional).
         */
        @QueryParameter(name = "recursionLevel")
        public VersionControlRecursionType recursionLevel;
        /**
         * Comment to be associated with the page operation.
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
    public static class GetRequestConfiguration {
        public GetQueryParameters queryParameters = new GetQueryParameters();
    }

    /**
     * Represents the query parameters.
     */
    public static class GetByIdQueryParameters {
        /**
         * True to include the content of the page in the response for Json content type. Defaults to false (Optional)
         */
        @QueryParameter(name = "includeContent")
        public Boolean includeContent;
        /**
         * Recursion level for subpages retrieval. Defaults to None (Optional).
         */
        @QueryParameter(name = "recursionLevel")
        public VersionControlRecursionType recursionLevel;
    }

    /**
     * Request configuration object for the query parameters.
     */
    public static class GetByIdRequestConfiguration {
        public GetByIdQueryParameters queryParameters = new GetByIdQueryParameters();
    }
}
