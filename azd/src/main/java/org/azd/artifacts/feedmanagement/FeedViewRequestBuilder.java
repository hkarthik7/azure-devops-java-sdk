package org.azd.artifacts.feedmanagement;

import org.azd.artifacts.feedmanagement.types.FeedView;
import org.azd.common.ApiVersion;
import org.azd.exceptions.AzDException;
import org.azd.interfaces.AccessTokenCredential;
import org.azd.interfaces.RequestAdapter;
import org.azd.utils.BaseRequestBuilder;

import java.util.concurrent.CompletableFuture;

public class FeedViewRequestBuilder extends BaseRequestBuilder {
    public FeedViewRequestBuilder(AccessTokenCredential accessTokenCredential, RequestAdapter requestAdapter) {
        super(accessTokenCredential, requestAdapter, "feeds", "packaging/feeds", ApiVersion.FEEDS);
    }

    /**
     * Create a new view on the referenced feed. The project parameter must be supplied if the feed was created in a project.
     * @param feedId Id of the feed.
     * @param feedView Feed view object to create the feed view.
     * @throws AzDException Default Api Exception handler.
     * @return Feed view object {@link FeedView}
     */
    public CompletableFuture<FeedView> create(String feedId, FeedView feedView) throws AzDException {
        var reqInfo = toPostRequestInformation(feedView);
        reqInfo.serviceEndpoint = reqInfo.serviceEndpoint + "/" + feedId + "/views";

        return requestAdapter.sendAsync(reqInfo, FeedView.class);
    }

    /**
     * Delete a feed view. The project parameter must be supplied if the feed was created in a project.
     * @param feedId Name or Id of the feed
     * @param feedViewId Id of the feed view
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<Void> delete(String feedId, String feedViewId) throws AzDException {
        var reqInfo = toDeleteRequestInformation();
        reqInfo.serviceEndpoint = reqInfo.serviceEndpoint + "/" + feedId + "/views/"+ feedViewId;

        return requestAdapter.sendPrimitiveAsync(reqInfo);
    }

    /**
     * Get a view by Id. The project parameter must be supplied if the feed was created in a project.
     * @param feedId Name or Id of the feed.
     * @param viewId Name or Id of the view.
     * @throws AzDException Default Api Exception handler.
     * @return feed view {@link FeedView}
     */
    public CompletableFuture<FeedView> get(String feedId, String viewId) throws AzDException {
        var reqInfo = toGetRequestInformation();
        reqInfo.serviceEndpoint = reqInfo.serviceEndpoint + "/" + feedId + "/views/"+ viewId;

        return requestAdapter.sendAsync(reqInfo, FeedView.class);
    }

    /**
     * Get all views for a feed. The project parameter must be supplied if the feed was created in a project.
     * @param feedId Name or Id of the feed.
     * @throws AzDException Default Api Exception handler.
     * @return feed view {@link FeedView}
     */
    public CompletableFuture<FeedView> list(String feedId) throws AzDException {
        var reqInfo = toGetRequestInformation();
        reqInfo.serviceEndpoint = reqInfo.serviceEndpoint + "/" + feedId + "/views";

        return requestAdapter.sendAsync(reqInfo, FeedView.class);
    }

    /***
     * Update a view. The project parameter must be supplied if the feed was created in a project.
     * @param feedId Name or Id of the feed.
     * @param viewId Name or Id of the view.
     * @param feedView Feed view object to update the settings for.
     * @throws AzDException Default Api Exception handler.
     * @return the updated feed view {@link FeedView}
     */
    public CompletableFuture<FeedView> update(String feedId, String viewId, FeedView feedView) throws AzDException {
        var reqInfo = toPatchRequestInformation(feedView);
        reqInfo.serviceEndpoint = reqInfo.serviceEndpoint + "/" + feedId + "/views/" + viewId;

        return requestAdapter.sendAsync(reqInfo, FeedView.class);
    }
}
