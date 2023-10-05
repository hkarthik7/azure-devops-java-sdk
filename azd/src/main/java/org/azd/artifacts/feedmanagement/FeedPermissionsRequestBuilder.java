package org.azd.artifacts.feedmanagement;

import org.azd.feedmanagement.types.FeedPermissions;
import org.azd.common.ApiVersion;
import org.azd.common.types.QueryParameter;
import org.azd.exceptions.AzDException;
import org.azd.http.RequestInformation;
import org.azd.interfaces.AccessTokenCredential;
import org.azd.interfaces.RequestAdapter;
import org.azd.utils.BaseRequestBuilder;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class FeedPermissionsRequestBuilder extends BaseRequestBuilder {
    public FeedPermissionsRequestBuilder(AccessTokenCredential accessTokenCredential, RequestAdapter requestAdapter) {
        super(accessTokenCredential, requestAdapter, "feeds", "packaging/feeds", ApiVersion.FEEDS);
    }

    /**
     * Get the permissions for a feed. The project parameter must be supplied if the feed was created in a project.
     * If the feed is not associated with any project, omit the project parameter from the request.
     * @param feedId Id or name of the feed.
     * @throws AzDException Default Api Exception handler.
     * @return Feed Permissions {@link FeedPermissions}
     */
    public CompletableFuture<FeedPermissions> getAsync(String feedId) throws AzDException {
        var reqInfo = toGetInformation(feedId, null);
        return requestAdapter.sendAsync(reqInfo, FeedPermissions.class);
    }

    /**
     * Get the permissions for a feed. The project parameter must be supplied if the feed was created in a project.
     * If the feed is not associated with any project, omit the project parameter from the request.
     * @param feedId Id or name of the feed.
     * @throws AzDException Default Api Exception handler.
     * @return Feed Permissions {@link FeedPermissions}
     */
    public CompletableFuture<FeedPermissions> getAsync(String feedId, Consumer<RequestConfiguration> requestConfiguration)
            throws AzDException {
        var reqInfo = toGetInformation(feedId, requestConfiguration);

        return requestAdapter.sendAsync(reqInfo, FeedPermissions.class);
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
        var reqInfo = toPatchRequestInformation(feedPermissions);
        reqInfo.serviceEndpoint = reqInfo.serviceEndpoint + "/" + feedId + "/permissions";

        return requestAdapter.sendAsync(reqInfo, FeedPermissions.class);
    }

    /**
     * Get the permissions for a feed. The project parameter must be supplied if the feed was created in a project.
     * If the feed is not associated with any project, omit the project parameter from the request.
     * @param feedId Id or name of the feed.
     * @throws AzDException Default Api Exception handler.
     * @return Feed Permissions {@link FeedPermissions}
     */
    public FeedPermissions get(String feedId) throws AzDException {
        var reqInfo = toGetInformation(feedId, null);
        return requestAdapter.send(reqInfo, FeedPermissions.class);
    }

    /**
     * Get the permissions for a feed. The project parameter must be supplied if the feed was created in a project.
     * If the feed is not associated with any project, omit the project parameter from the request.
     * @param feedId Id or name of the feed.
     * @throws AzDException Default Api Exception handler.
     * @return Feed Permissions {@link FeedPermissions}
     */
    public FeedPermissions get(String feedId, Consumer<RequestConfiguration> requestConfiguration)
            throws AzDException {
        var reqInfo = toGetInformation(feedId, requestConfiguration);

        return requestAdapter.send(reqInfo, FeedPermissions.class);
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
        var reqInfo = toPatchRequestInformation(feedPermissions.getFeedPermission());
        reqInfo.serviceEndpoint = reqInfo.serviceEndpoint + "/" + feedId + "/permissions";

        return requestAdapter.send(reqInfo, FeedPermissions.class);
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

    /**
     * Constructs the request information for Build Api.
     * @param feedId ID or name of the feed.
     * @param requestConfig Consumer of query parameters.
     * @return RequestInformation object {@link RequestInformation}
     */
    private RequestInformation toGetInformation(String feedId, Consumer<RequestConfiguration> requestConfig) {
        var reqInfo = toGetRequestInformation();
        reqInfo.serviceEndpoint = reqInfo.serviceEndpoint + "/" + feedId + "/permissions";
        if (requestConfig != null) {
            final var config = new RequestConfiguration();
            requestConfig.accept(config);
            reqInfo.setQueryParameters(config.queryParameters);
        }
        return reqInfo;
    }

}
