package org.azd.artifacts.feedmanagement;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.authentication.AccessTokenCredential;
import org.azd.common.ApiVersion;
import org.azd.exceptions.AzDException;
import org.azd.feedmanagement.types.FeedView;
import org.azd.feedmanagement.types.FeedViews;

import java.util.concurrent.CompletableFuture;

/**
 * Feed view request builder to manage feed view Api.
 */
public class FeedViewRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public FeedViewRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential, "packaging", "42a8502a-6785-41bc-8c16-89477d930877", ApiVersion.FEEDS);
    }

    /**
     * Create a new view on the referenced feed. The project parameter must be supplied if the feed was created in a project.
     *
     * @param feedId   Id of the feed.
     * @param feedView Feed view object to create the feed view.
     * @return Feed view object {@link FeedView}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<FeedView> createAsync(String feedId, FeedView feedView) throws AzDException {
        return builder()
                .POST(feedView)
                .serviceEndpoint("feedId", feedId)
                .build()
                .executeAsync(FeedView.class);
    }

    /**
     * Delete a feed view. The project parameter must be supplied if the feed was created in a project.
     *
     * @param feedId Name or Id of the feed
     * @param viewId Id of the feed view
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<Void> deleteAsync(String feedId, String viewId) throws AzDException {
        return builder()
                .DELETE()
                .serviceEndpoint("feedId", feedId)
                .serviceEndpoint("viewId", viewId)
                .build()
                .executePrimitiveAsync();
    }

    /**
     * Get a view by Id. The project parameter must be supplied if the feed was created in a project.
     *
     * @param feedId Name or Id of the feed.
     * @param viewId Name or Id of the view.
     * @return feed view {@link FeedView}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<FeedView> getAsync(String feedId, String viewId) throws AzDException {
        return builder()
                .serviceEndpoint("feedId", feedId)
                .serviceEndpoint("viewId", viewId)
                .build()
                .executeAsync(FeedView.class);
    }

    /**
     * Get all views for a feed. The project parameter must be supplied if the feed was created in a project.
     *
     * @param feedId Name or Id of the feed.
     * @return feed view {@link FeedView}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<FeedViews> listAsync(String feedId) throws AzDException {
        return builder()
                .serviceEndpoint("feedId", feedId)
                .build()
                .executeAsync(FeedViews.class);
    }

    /**
     * Update a view. The project parameter must be supplied if the feed was created in a project.
     *
     * @param feedId   Name or Id of the feed.
     * @param viewId   Name or Id of the view.
     * @param feedView Feed view object to update the settings for.
     * @return the updated feed view {@link FeedView}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<FeedView> updateAsync(String feedId, String viewId, FeedView feedView) throws AzDException {
        return builder()
                .PATCH(feedView)
                .serviceEndpoint("feedId", feedId)
                .serviceEndpoint("viewId", viewId)
                .build()
                .executeAsync(FeedView.class);
    }

    /**
     * Create a new view on the referenced feed. The project parameter must be supplied if the feed was created in a project.
     *
     * @param feedId   Id of the feed.
     * @param feedView Feed view object to create the feed view.
     * @return Feed view object {@link FeedView}
     * @throws AzDException Default Api Exception handler.
     */
    public FeedView create(String feedId, FeedView feedView) throws AzDException {
        return builder()
                .POST(feedView)
                .serviceEndpoint("feedId", feedId)
                .build()
                .execute(FeedView.class);
    }

    /**
     * Delete a feed view. The project parameter must be supplied if the feed was created in a project.
     *
     * @param feedId Name or Id of the feed
     * @param viewId Id of the feed view
     * @throws AzDException Default Api Exception handler.
     */
    public Void delete(String feedId, String viewId) throws AzDException {
        return builder()
                .DELETE()
                .serviceEndpoint("feedId", feedId)
                .serviceEndpoint("viewId", viewId)
                .build()
                .executePrimitive();
    }

    /**
     * Get a view by Id. The project parameter must be supplied if the feed was created in a project.
     *
     * @param feedId Name or Id of the feed.
     * @param viewId Name or Id of the view.
     * @return feed view {@link FeedView}
     * @throws AzDException Default Api Exception handler.
     */
    public FeedView get(String feedId, String viewId) throws AzDException {
        return builder()
                .serviceEndpoint("feedId", feedId)
                .serviceEndpoint("viewId", viewId)
                .build()
                .execute(FeedView.class);
    }

    /**
     * Get all views for a feed. The project parameter must be supplied if the feed was created in a project.
     *
     * @param feedId Name or Id of the feed.
     * @return feed view {@link FeedView}
     * @throws AzDException Default Api Exception handler.
     */
    public FeedViews list(String feedId) throws AzDException {
        return builder()
                .serviceEndpoint("feedId", feedId)
                .build()
                .execute(FeedViews.class);
    }

    /**
     * Update a view. The project parameter must be supplied if the feed was created in a project.
     *
     * @param feedId   Name or Id of the feed.
     * @param viewId   Name or Id of the view.
     * @param feedView Feed view object to update the settings for.
     * @return the updated feed view {@link FeedView}
     * @throws AzDException Default Api Exception handler.
     */
    public FeedView update(String feedId, String viewId, FeedView feedView) throws AzDException {
        return builder()
                .PATCH(feedView)
                .serviceEndpoint("feedId", feedId)
                .serviceEndpoint("viewId", viewId)
                .build()
                .execute(FeedView.class);
    }
}
