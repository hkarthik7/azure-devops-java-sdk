package org.azd.artifacts.feedmanagement;

import org.azd.feedmanagement.types.FeedView;
import org.azd.common.ApiVersion;
import org.azd.exceptions.AzDException;
import org.azd.feedmanagement.types.FeedViews;
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
    public CompletableFuture<FeedView> createAsync(String feedId, FeedView feedView) throws AzDException {
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
    public CompletableFuture<Void> deleteAsync(String feedId, String feedViewId) throws AzDException {
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
    public CompletableFuture<FeedView> getAsync(String feedId, String viewId) throws AzDException {
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
    public CompletableFuture<FeedViews> listAsync(String feedId) throws AzDException {
        var reqInfo = toGetRequestInformation();
        reqInfo.serviceEndpoint = reqInfo.serviceEndpoint + "/" + feedId + "/views";

        return requestAdapter.sendAsync(reqInfo, FeedViews.class);
    }

    /***
     * Update a view. The project parameter must be supplied if the feed was created in a project.
     * @param feedId Name or Id of the feed.
     * @param viewId Name or Id of the view.
     * @param feedView Feed view object to update the settings for.
     * @throws AzDException Default Api Exception handler.
     * @return the updated feed view {@link FeedView}
     */
    public CompletableFuture<FeedView> updateAsync(String feedId, String viewId, FeedView feedView) throws AzDException {
        var reqInfo = toPatchRequestInformation(feedView);
        reqInfo.serviceEndpoint = reqInfo.serviceEndpoint + "/" + feedId + "/views/" + viewId;

        return requestAdapter.sendAsync(reqInfo, FeedView.class);
    }

    /**
     * Create a new view on the referenced feed. The project parameter must be supplied if the feed was created in a project.
     * @param feedId Id of the feed.
     * @param feedView Feed view object to create the feed view.
     * @throws AzDException Default Api Exception handler.
     * @return Feed view object {@link FeedView}
     */
    public FeedView create(String feedId, FeedView feedView) throws AzDException {
        var reqInfo = toPostRequestInformation(feedView);
        reqInfo.serviceEndpoint = reqInfo.serviceEndpoint + "/" + feedId + "/views";

        return requestAdapter.send(reqInfo, FeedView.class);
    }

    /**
     * Delete a feed view. The project parameter must be supplied if the feed was created in a project.
     * @param feedId Name or Id of the feed
     * @param feedViewId Id of the feed view
     * @throws AzDException Default Api Exception handler.
     */
    public Void delete(String feedId, String feedViewId) throws AzDException {
        var reqInfo = toDeleteRequestInformation();
        reqInfo.serviceEndpoint = reqInfo.serviceEndpoint + "/" + feedId + "/views/"+ feedViewId;

        return requestAdapter.sendPrimitive(reqInfo);
    }

    /**
     * Get a view by Id. The project parameter must be supplied if the feed was created in a project.
     * @param feedId Name or Id of the feed.
     * @param viewId Name or Id of the view.
     * @throws AzDException Default Api Exception handler.
     * @return feed view {@link FeedView}
     */
    public FeedView get(String feedId, String viewId) throws AzDException {
        var reqInfo = toGetRequestInformation();
        reqInfo.serviceEndpoint = reqInfo.serviceEndpoint + "/" + feedId + "/views/"+ viewId;

        return requestAdapter.send(reqInfo, FeedView.class);
    }

    /**
     * Get all views for a feed. The project parameter must be supplied if the feed was created in a project.
     * @param feedId Name or Id of the feed.
     * @throws AzDException Default Api Exception handler.
     * @return feed view {@link FeedView}
     */
    public FeedViews list(String feedId) throws AzDException {
        var reqInfo = toGetRequestInformation();
        reqInfo.serviceEndpoint = reqInfo.serviceEndpoint + "/" + feedId + "/views";

        return requestAdapter.send(reqInfo, FeedViews.class);
    }

    /***
     * Update a view. The project parameter must be supplied if the feed was created in a project.
     * @param feedId Name or Id of the feed.
     * @param viewId Name or Id of the view.
     * @param feedView Feed view object to update the settings for.
     * @throws AzDException Default Api Exception handler.
     * @return the updated feed view {@link FeedView}
     */
    public FeedView update(String feedId, String viewId, FeedView feedView) throws AzDException {
        var reqInfo = toPatchRequestInformation(feedView);
        reqInfo.serviceEndpoint = reqInfo.serviceEndpoint + "/" + feedId + "/views/" + viewId;

        return requestAdapter.send(reqInfo, FeedView.class);
    }
}
