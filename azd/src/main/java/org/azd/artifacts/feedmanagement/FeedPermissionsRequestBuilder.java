package org.azd.artifacts.feedmanagement;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.abstractions.QueryParameter;
import org.azd.authentication.AccessTokenCredential;
import org.azd.exceptions.AzDException;
import org.azd.feedmanagement.types.FeedPermissions;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

/**
 * Feed permissions request builder to manage Feed permissions Api.
 */
public class FeedPermissionsRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public FeedPermissionsRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential, "packaging", "be8c1476-86a7-44ed-b19d-aec0e9275cd8");
    }

    /**
     * Get the permissions for a feed. The project parameter must be supplied if the feed was created in a project.
     * If the feed is not associated with any project, omit the project parameter from the request.
     *
     * @param feedId Id or name of the feed.
     * @return Feed Permissions {@link FeedPermissions}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<FeedPermissions> getAsync(String feedId) throws AzDException {
        return builder()
                .serviceEndpoint("feedId", feedId)
                .build()
                .executeAsync(FeedPermissions.class);
    }

    /**
     * Get the permissions for a feed. The project parameter must be supplied if the feed was created in a project.
     * If the feed is not associated with any project, omit the project parameter from the request.
     *
     * @param feedId Id or name of the feed.
     * @return Feed Permissions {@link FeedPermissions}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<FeedPermissions> getAsync(String feedId, Consumer<RequestConfiguration> requestConfiguration)
            throws AzDException {
        return builder()
                .serviceEndpoint("feedId", feedId)
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .executeAsync(FeedPermissions.class);
    }

    /***
     * Update the permissions on a feed. The project parameter must be supplied if the feed was created in a project.
     * If the feed is not associated with any project, omit the project parameter from the request.
     * @param feedPermissions List of feed permissions to update the permissions for.
     * @throws AzDException Default Api Exception handler.
     * @return array of feed permissions {@link FeedPermissions}
     */
    public CompletableFuture<FeedPermissions> setAsync(String feedId, FeedPermissions feedPermissions)
            throws AzDException {
        return builder()
                .PATCH(feedPermissions)
                .serviceEndpoint("feedId", feedId)
                .build()
                .executeAsync(FeedPermissions.class);
    }

    /**
     * Get the permissions for a feed. The project parameter must be supplied if the feed was created in a project.
     * If the feed is not associated with any project, omit the project parameter from the request.
     *
     * @param feedId Id or name of the feed.
     * @return Feed Permissions {@link FeedPermissions}
     * @throws AzDException Default Api Exception handler.
     */
    public FeedPermissions get(String feedId) throws AzDException {
        return builder()
                .serviceEndpoint("feedId", feedId)
                .build()
                .execute(FeedPermissions.class);
    }

    /**
     * Get the permissions for a feed. The project parameter must be supplied if the feed was created in a project.
     * If the feed is not associated with any project, omit the project parameter from the request.
     *
     * @param feedId Id or name of the feed.
     * @return Feed Permissions {@link FeedPermissions}
     * @throws AzDException Default Api Exception handler.
     */
    public FeedPermissions get(String feedId, Consumer<RequestConfiguration> requestConfiguration)
            throws AzDException {
        return builder()
                .serviceEndpoint("feedId", feedId)
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .execute(FeedPermissions.class);
    }

    /***
     * Update the permissions on a feed. The project parameter must be supplied if the feed was created in a project.
     * If the feed is not associated with any project, omit the project parameter from the request.
     * @param feedPermissions List of feed permissions to update the permissions for.
     * @throws AzDException Default Api Exception handler.
     * @return array of feed permissions {@link FeedPermissions}
     */
    public FeedPermissions set(String feedId, FeedPermissions feedPermissions)
            throws AzDException {
        return builder()
                .PATCH(feedPermissions)
                .serviceEndpoint("feedId", feedId)
                .build()
                .execute(FeedPermissions.class);
    }


    /**
     * Represents the query parameters.
     */
    public static class GetQueryParameters {
        /**
         * True to include user Ids in the response. Default is false.
         */
        @QueryParameter(name = "includeIds")
        public Boolean includeIds;
        /**
         * True to only return explicitly set permissions on the feed. Default is false.
         */
        @QueryParameter(name = "excludeInheritedPermissions")
        public Boolean excludeInheritedPermissions;
        /**
         * Filter permissions to the provided identity.
         */
        @QueryParameter(name = "identityDescriptor")
        public String identityDescriptor;
        /**
         * If includeDeletedFeeds is true, then feedId must be specified by name and not by Guid.
         */
        @QueryParameter(name = "includeDeletedFeeds")
        public Boolean includeDeletedFeeds;
    }

    /**
     * Request configuration object for the query parameters.
     */
    public static class RequestConfiguration {
        public GetQueryParameters queryParameters = new GetQueryParameters();
    }

}
