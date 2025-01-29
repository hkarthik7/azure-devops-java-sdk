package org.azd.artifacts.feedmanagement;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.abstractions.QueryParameter;
import org.azd.authentication.AccessTokenCredential;
import org.azd.common.ApiVersion;
import org.azd.enums.FeedRole;
import org.azd.exceptions.AzDException;
import org.azd.feedmanagement.types.Feed;
import org.azd.feedmanagement.types.Feeds;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

/**
 * Provides functionality to manage Artifacts Feed Management Api.
 */
public class FeedManagementRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public FeedManagementRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential, "packaging", "c65009a7-474a-4ad1-8b42-7d852107ef8c", ApiVersion.FEEDS);

    }

    public FeedViewRequestBuilder view() {
        return new FeedViewRequestBuilder(organizationUrl, accessTokenCredential);
    }

    public FeedPermissionsRequestBuilder permissions() {
        return new FeedPermissionsRequestBuilder(organizationUrl, accessTokenCredential);
    }

    /**
     * Create a feed, a container for various package types.
     * Feeds can be created in a project if the project parameter is included when instantiating the class.
     * This can be done by injecting the instance of AzDDefaultParameters with project name.
     * If the project parameter is omitted, the feed will not be associated with a project and will be created at the organization level.
     *
     * @param feed Provide feed object to create a new feed.
     * @return Feed object {@link Feed}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<Feed> createAsync(Feed feed) throws AzDException {
        return builder()
                .POST(feed)
                .build()
                .executeAsync(Feed.class);
    }

    /**
     * Remove a feed and all its packages. The feed moves to the recycle bin and is reversible.
     * The project parameter must be supplied if the feed was created in a project.
     * If the feed is not associated with any project, omit the project parameter from the request.
     *
     * @param feedId Name or Id of the feed.
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<Void> deleteAsync(String feedId) throws AzDException {
        return builder()
                .DELETE()
                .serviceEndpoint("feedId", feedId)
                .build()
                .executePrimitiveAsync();
    }

    /**
     * Get the settings for a specific feed. The project parameter must be supplied if the feed was created in a project.
     * If the feed is not associated with any project, omit the project parameter from the request.
     *
     * @param feedId Name of id of the feed
     * @return Feed {@link Feed}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<Feed> getAsync(String feedId) throws AzDException {
        return builder()
                .serviceEndpoint("feedId", feedId)
                .build()
                .executeAsync(Feed.class);
    }

    /**
     * Get the settings for a specific feed. The project parameter must be supplied if the feed was created in a project.
     * If the feed is not associated with any project, omit the project parameter from the request.
     *
     * @param feedId                  Name of id of the feed
     * @param includeDeletedUpstreams Include upstreams that have been deleted in the response.
     * @return Feed {@link Feed}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<Feed> getAsync(String feedId, boolean includeDeletedUpstreams) throws AzDException {
        return builder()
                .serviceEndpoint("feedId", feedId)
                .query("includeDeletedUpstreams", includeDeletedUpstreams)
                .build()
                .executeAsync(Feed.class);
    }

    /**
     * Get all feeds in an account where you have the provided role access. If the project parameter is present,
     * gets all feeds in the given project. If omitted, gets all feeds in the organization.
     *
     * @return array of feeds {@link Feeds}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<Feeds> listAsync() throws AzDException {
        return builder()
                .build()
                .executeAsync(Feeds.class);
    }

    /**
     * Get all feeds in an account where you have the provided role access. If the project parameter is present,
     * gets all feeds in the given project. If omitted, gets all feeds in the organization.
     *
     * @return array of feeds {@link Feeds}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<Feeds> listAsync(Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .executeAsync(Feeds.class);
    }

    /**
     * Change the attributes of a feed. The project parameter must be supplied if the feed was created in a project.
     * If the feed is not associated with any project, omit the project parameter from the request.
     *
     * @param feedId Name or Id of the feed.
     * @param feed   Feed object to update the settings for
     * @return feed {@link Feed}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<Feed> updateAsync(String feedId, Feed feed) throws AzDException {
        return builder()
                .PATCH(feed)
                .serviceEndpoint("feedId", feedId)
                .build()
                .executeAsync(Feed.class);
    }

    /**
     * Create a feed, a container for various package types.
     * Feeds can be created in a project if the project parameter is included when instantiating the class.
     * This can be done by injecting the instance of AzDDefaultParameters with project name.
     * If the project parameter is omitted, the feed will not be associated with a project and will be created at the organization level.
     *
     * @param feed Provide feed object to create a new feed.
     * @return Feed object {@link Feed}
     * @throws AzDException Default Api Exception handler.
     */
    public Feed create(Feed feed) throws AzDException {
        return builder()
                .POST(feed)
                .build()
                .execute(Feed.class);
    }

    /**
     * Remove a feed and all its packages. The feed moves to the recycle bin and is reversible.
     * The project parameter must be supplied if the feed was created in a project.
     * If the feed is not associated with any project, omit the project parameter from the request.
     *
     * @param feedId Name or Id of the feed.
     * @throws AzDException Default Api Exception handler.
     */
    public Void delete(String feedId) throws AzDException {
        return builder()
                .DELETE()
                .serviceEndpoint("feedId", feedId)
                .build()
                .executePrimitive();
    }

    /**
     * Get the settings for a specific feed. The project parameter must be supplied if the feed was created in a project.
     * If the feed is not associated with any project, omit the project parameter from the request.
     *
     * @param feedId Name of id of the feed
     * @return Feed {@link Feed}
     * @throws AzDException Default Api Exception handler.
     */
    public Feed get(String feedId) throws AzDException {
        return builder()
                .serviceEndpoint("feedId", feedId)
                .build()
                .execute(Feed.class);
    }

    /**
     * Get the settings for a specific feed. The project parameter must be supplied if the feed was created in a project.
     * If the feed is not associated with any project, omit the project parameter from the request.
     *
     * @param feedId                  Name of id of the feed
     * @param includeDeletedUpstreams Include upstreams that have been deleted in the response.
     * @return Feed {@link Feed}
     * @throws AzDException Default Api Exception handler.
     */
    public Feed get(String feedId, boolean includeDeletedUpstreams) throws AzDException {
        return builder()
                .serviceEndpoint("feedId", feedId)
                .query("includeDeletedUpstreams", includeDeletedUpstreams)
                .build()
                .execute(Feed.class);
    }

    /**
     * Get all feeds in an account where you have the provided role access. If the project parameter is present,
     * gets all feeds in the given project. If omitted, gets all feeds in the organization.
     *
     * @return array of feeds {@link Feeds}
     * @throws AzDException Default Api Exception handler.
     */
    public Feeds list() throws AzDException {
        return builder()
                .baseInstance(organizationUrl)
                .build()
                .execute(Feeds.class);
    }

    /**
     * Get all feeds in an account where you have the provided role access. If the project parameter is present,
     * gets all feeds in the given project. If omitted, gets all feeds in the organization.
     *
     * @return array of feeds {@link Feeds}
     * @throws AzDException Default Api Exception handler.
     */
    public Feeds list(Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .execute(Feeds.class);
    }

    /**
     * Change the attributes of a feed. The project parameter must be supplied if the feed was created in a project.
     * If the feed is not associated with any project, omit the project parameter from the request.
     *
     * @param feedId Name or Id of the feed.
     * @param feed   Feed object to update the settings for
     * @return feed {@link Feed}
     * @throws AzDException Default Api Exception handler.
     */
    public Feed update(String feedId, Feed feed) throws AzDException {
        return builder()
                .PATCH(feed)
                .serviceEndpoint("feedId", feedId)
                .build()
                .execute(Feed.class);
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
        public Boolean includeDeletedUpstreams;
        /**
         * Resolve names if true.
         */
        @QueryParameter(name = "includeUrls")
        public Boolean includeUrls;
    }

    /**
     * Request configuration object for the query parameters.
     */
    public static class RequestConfiguration {
        public GetQueryParameters queryParameters = new GetQueryParameters();
    }
}

