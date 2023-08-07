package org.azd.artifacts.feedmanagement;

import org.azd.artifacts.feedmanagement.types.Feed;
import org.azd.artifacts.feedmanagement.types.Feeds;
import org.azd.common.ApiVersion;
import org.azd.common.types.QueryParameter;
import org.azd.enums.CustomHeader;
import org.azd.enums.FeedRole;
import org.azd.exceptions.AzDException;
import org.azd.http.RequestInformation;
import org.azd.interfaces.AccessTokenCredential;
import org.azd.interfaces.RequestAdapter;
import org.azd.utils.BaseRequestBuilder;

import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

/**
 * Provides functionality to manage Artifacts Feed Management Api.
 */
public class FeedManagementRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new AccountsRequestBuilder instance and sets the default values.
     * @param accessTokenCredential Authentication provider {@link AccessTokenCredential}.
     * @param requestAdapter The request adapter to execute the requests.
     */
    public FeedManagementRequestBuilder(AccessTokenCredential accessTokenCredential, RequestAdapter requestAdapter) {
        super(accessTokenCredential, requestAdapter, "feeds", "packaging/feeds", ApiVersion.FEEDS);
    }
    public FeedViewRequestBuilder view() {
        return new FeedViewRequestBuilder(accessTokenCredential, requestAdapter);
    }

    public FeedPermissionsRequestBuilder permissions() {
        return new FeedPermissionsRequestBuilder(accessTokenCredential, requestAdapter);
    }

    /**
     * Create a feed, a container for various package types.
     * Feeds can be created in a project if the project parameter is included when instantiating the class.
     * This can be done by injecting the instance of AzDDefaultParameters with project name.
     * If the project parameter is omitted, the feed will not be associated with a project and will be created at the organization level.
     * @param feed Provide feed object to create a new feed.
     * @throws AzDException Default Api Exception handler.
     * @return Feed object {@link Feed}
     */
    public CompletableFuture<Feed> create(Feed feed) throws AzDException {
        var reqInfo = toPostRequestInformation(feed);

        return requestAdapter.sendAsync(reqInfo, Feed.class);
    }

    /**
     * Remove a feed and all its packages. The feed moves to the recycle bin and is reversible.
     * The project parameter must be supplied if the feed was created in a project.
     * If the feed is not associated with any project, omit the project parameter from the request.
     * @param feedId Name or Id of the feed.
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<Void> delete(String feedId) throws AzDException {
        var reqInfo = toDeleteRequestInformation();
        reqInfo.serviceEndpoint = reqInfo.serviceEndpoint + "/" + feedId;

        return requestAdapter.sendStringAsync(reqInfo)
                .thenApplyAsync(r -> {
                    try {
                        if (!r.isEmpty()) serializer.deserialize(r, Map.class);
                    } catch (AzDException e) {
                        throw new RuntimeException(e);
                    }
                    return null;
                });
    }

    /**
     * Get the settings for a specific feed. The project parameter must be supplied if the feed was created in a project.
     * If the feed is not associated with any project, omit the project parameter from the request.
     * @param feedId Name of id of the feed
     * @throws AzDException Default Api Exception handler.
     * @return Feed {@link Feed}
     */
    public CompletableFuture<Feed> get(String feedId) throws AzDException {
        var reqInfo = toGetInformation(null);
        reqInfo.serviceEndpoint = reqInfo.serviceEndpoint + "/" + feedId;

        return requestAdapter.sendAsync(reqInfo, Feed.class);
    }

    /**
     * Get the settings for a specific feed. The project parameter must be supplied if the feed was created in a project.
     * If the feed is not associated with any project, omit the project parameter from the request.
     * @param feedId Name of id of the feed
     * @param includeDeletedUpstreams Include upstreams that have been deleted in the response.
     * @throws AzDException Default Api Exception handler.
     * @return Feed {@link Feed}
     */
    public CompletableFuture<Feed> get(String feedId, boolean includeDeletedUpstreams) throws AzDException {
        var reqInfo = toGetInformation(null);
        reqInfo.serviceEndpoint = reqInfo.serviceEndpoint + "/" + feedId;
        reqInfo.setQueryParameter("includeDeletedUpstreams", includeDeletedUpstreams);

        return requestAdapter.sendAsync(reqInfo, Feed.class);
    }

    /**
     * Get all feeds in an account where you have the provided role access. If the project parameter is present,
     * gets all feeds in the given project. If omitted, gets all feeds in the organization.
     * @throws AzDException Default Api Exception handler.
     * @return array of feeds {@link Feeds}
     */
    public CompletableFuture<Feeds> list() throws AzDException {
        var reqInfo = toGetInformation(null);

        return requestAdapter.sendAsync(reqInfo, Feeds.class);
    }

    /**
     * Get all feeds in an account where you have the provided role access. If the project parameter is present,
     * gets all feeds in the given project. If omitted, gets all feeds in the organization.
     * @throws AzDException Default Api Exception handler.
     * @return array of feeds {@link Feeds}
     */
    public CompletableFuture<Feeds> list(Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        var reqInfo = toGetInformation(requestConfiguration);

        return requestAdapter.sendAsync(reqInfo, Feeds.class);
    }

    /***
     * Change the attributes of a feed. The project parameter must be supplied if the feed was created in a project.
     * If the feed is not associated with any project, omit the project parameter from the request.
     * @param feedId Name or Id of the feed.
     * @param feed Feed object to update the settings for
     * @throws AzDException Default Api Exception handler.
     * @return feed {@link Feed}
     */
    public CompletableFuture<Feed> update(String feedId, Feed feed) throws AzDException {
        var reqInfo = toPatchRequestInformation(feed);
        reqInfo.serviceEndpoint = reqInfo.serviceEndpoint + "/" + feedId;
        reqInfo.requestHeaders.clear();
        reqInfo.requestHeaders.add(CustomHeader.JSON_CONTENT_TYPE);

        return requestAdapter.sendAsync(reqInfo, Feed.class);
    }


    /**
     * Represents the query parameters.
     */
    public static class GetQueryParameters {
        /**
         * Filter by this role, either Administrator(4), Contributor(3), or Reader(2) level permissions.
         */
        @QueryParameter(name = "feedRole")
        public FeedRole feedRole;
        /**
         * Include upstreams that have been deleted in the response.
         */
        @QueryParameter(name = "includeDeletedUpstreams")
        public boolean includeDeletedUpstreams;
        /**
         * Resolve names if true.
         */
        @QueryParameter(name = "includeUrls")
        public boolean includeUrls;
    }

    /**
     * Request configuration object for the query parameters.
     */
    public static class RequestConfiguration {
        public GetQueryParameters queryParameters = new GetQueryParameters();
    }

    /**
     * Constructs the request information for Build Api.
     * @param requestConfig Consumer of query parameters.
     * @return RequestInformation object {@link RequestInformation}
     */
    private RequestInformation toGetInformation(Consumer<RequestConfiguration> requestConfig) {
        var reqInfo = toGetRequestInformation();
        if (requestConfig != null) {
            final var config = new RequestConfiguration();
            requestConfig.accept(config);
            reqInfo.setQueryParameters(config.queryParameters);
        }
        return reqInfo;
    }
}
