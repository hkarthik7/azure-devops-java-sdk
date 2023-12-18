package org.azd.feedmanagement;

import org.azd.artifacts.feedmanagement.FeedManagementRequestBuilder;
import org.azd.enums.*;
import org.azd.exceptions.AzDException;
import org.azd.feedmanagement.types.*;
import org.azd.interfaces.FeedManagementDetails;
import org.azd.serviceclient.AzDServiceClient;
import org.azd.utils.AzDAsyncApi;

import static org.azd.utils.RestClient.send;

/***
 * Feed Management class to manage Artifacts API
 */
public class FeedManagementApi extends AzDAsyncApi<FeedManagementApi> implements FeedManagementDetails {

    private final FeedManagementRequestBuilder FEED;
    public FeedManagementApi(AzDServiceClient client) {
        FEED = client.artifacts().feedManagement();
    }

    /***
     * Create a feed, a container for various package types.
     * <p>
     *     Feeds can be created in a project if the project parameter is included when instantiating the class.
     *     This can be done by injecting the instance of AzDDefaultParameters with project name.
     *     If the project parameter is omitted, the feed will not be associated with a project
     *     and will be created at the organization level.
     * </p>
     * @param name Provide the name of the feed
     * @param description Provide the description for the feed
     * @param badgesEnabled Enable or disable the badge in the feed. Default to false.
     * @param hideDeletedPackageVersions Hides the deleted package version. Default to true.
     * @throws AzDException Default Api Exception handler.
     * @return Feed object {@link Feed}
     */
    @Override
    public Feed createFeed(
            String name, String description, boolean badgesEnabled,
            boolean hideDeletedPackageVersions) throws AzDException {

        var feed = new Feed();
        feed.setName(name);
        feed.setDescription(description);
        feed.setBadgesEnabled(badgesEnabled);
        feed.setHideDeletedPackageVersions(hideDeletedPackageVersions);

        return FEED.create(feed);
    }

    /***
     * Create a new view on the referenced feed.
     * <p>
     *     The project parameter must be supplied if the feed was created in a project.
     * </p>
     * @param feedName provide the name or id of the feed
     * @param name name of the feed view
     * @param feedViewType type of the feed view. Allowed values are [implicit and release]
     * @param visibility visibility of the view. Allowed values are [aadTenant, collection, organization, private]
     * @throws AzDException Default Api Exception handler.
     * @return Feed view object {@link FeedView}
     */
    @Override
    public FeedView createFeedView(String feedName, String name,
                                   FeedViewType feedViewType, FeedVisibility visibility) throws AzDException {

        var feedView = new FeedView();
        feedView.setVisibility(visibility);
        feedView.setName(name);
        feedView.setType(feedViewType);

        return FEED.view().create(feedName, feedView);
    }

    /***
     * Remove a feed and all its packages. The feed moves to the recycle bin and is reversible.
     * <p>
     *     The project parameter must be supplied if the feed was created in a project.
     *     If the feed is not associated with any project, omit the project parameter from the request.
     * </p>
     * @param feedId Name or Id of the feed.
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public Void deleteFeed(String feedId) throws AzDException {
        return FEED.delete(feedId);
    }

    /***
     * Delete a feed view.
     * <p>
     *     The project parameter must be supplied if the feed was created in a project.
     * </p>
     * @param feedId Name or Id of the feed
     * @param feedViewId Id of the feed view
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public Void deleteFeedView(String feedId, String feedViewId) throws AzDException {
        return FEED.view().delete(feedId, feedViewId);
    }

    /***
     * Get the settings for a specific feed.
     * <p>
     *     The project parameter must be supplied if the feed was created in a project.
     *     If the feed is not associated with any project, omit the project parameter from the request.
     * </p>
     * @param feedName Name of id of the feed
     * @throws AzDException Default Api Exception handler.
     * @return Feed {@link Feed}
     */
    @Override
    public Feed getFeed(String feedName) throws AzDException {
        return FEED.get(feedName);
    }

    /***
     * Get the settings for a specific feed.
     * <p>
     *     The project parameter must be supplied if the feed was created in a project.
     *     If the feed is not associated with any project, omit the project parameter from the request.
     * </p>
     * @param feedName Name of id of the feed
     * @param includeDeletedUpstreams Include upstreams that have been deleted in the response.
     * @throws AzDException Default Api Exception handler.
     * @return Feed {@link Feed}
     */
    @Override
    public Feed getFeed(String feedName, boolean includeDeletedUpstreams) throws AzDException {
        return FEED.get(feedName, includeDeletedUpstreams);
    }

    /***
     * Get the permissions for a feed.
     * <p>
     *     The project parameter must be supplied if the feed was created in a project.
     *     If the feed is not associated with any project, omit the project parameter from the request.
     * </p>
     * @param feedName Name or Id of the feed.
     * @throws AzDException Default Api Exception handler.
     * @return Feed Permissions {@link FeedPermissions}
     */
    @Override
    public FeedPermissions getFeedPermissions(String feedName) throws AzDException {
        return FEED.permissions().get(feedName);
    }

    /***
     * Get the permissions for a feed.
     * <p>
     *      The project parameter must be supplied if the feed was created in a project.
     *      If the feed is not associated with any project, omit the project parameter from the request.
     * </p>
     * @param feedName Name or Id of the feed.
     * @param excludeInheritedPermissions True to only return explicitly set permissions on the feed. Default is false.
     * @param identityDescriptor Filter permissions to the provided identity.
     * @param includeDeletedFeeds If includeDeletedFeeds is true, then feedId must be specified by name and not by Guid.
     * @param includeIds True to include user Ids in the response. Default is false.
     * @throws AzDException Default Api Exception handler.
     * @return Feed Permissions {@link FeedPermissions}
     */
    @Override
    public FeedPermissions getFeedPermissions(
            String feedName, boolean excludeInheritedPermissions, String identityDescriptor,
            boolean includeDeletedFeeds, boolean includeIds) throws AzDException {

        return FEED.permissions().get(feedName, r -> {
            r.queryParameters.includeIds = includeIds;
            r.queryParameters.excludeInheritedPermissions = excludeInheritedPermissions;
            r.queryParameters.identityDescriptor = identityDescriptor;
            r.queryParameters.includeDeletedFeeds = includeDeletedFeeds;
        });
    }

    /***
     * Get a view by Id.
     * <p>
     *     The project parameter must be supplied if the feed was created in a project.
     * </p>
     * @param feedName Name or Id of the feed.
     * @param feedViewId Name or Id of the view.
     * @throws AzDException Default Api Exception handler.
     * @return feed view {@link FeedView}
     */
    @Override
    public FeedView getFeedView(String feedName, String feedViewId) throws AzDException {
        return FEED.view().get(feedName, feedViewId);
    }

    /***
     * Get all views for a feed.
     * <p>
     *     The project parameter must be supplied if the feed was created in a project.
     * </p>
     * @param feedName Name or Id of the feed.
     * @throws AzDException Default Api Exception handler.
     * @return array feed views {@link FeedView}
     */
    @Override
    public FeedViews getFeedViews(String feedName) throws AzDException {
        return FEED.view().list(feedName);
    }

    /***
     * Get all feeds in an account where you have the provided role access.
     * <p>
     *     If the project parameter is present, gets all feeds in the given project.
     *     If omitted, gets all feeds in the organization.
     * </p>
     * @throws AzDException Default Api Exception handler.
     * @return array of feeds {@link Feeds}
     */
    @Override
    public Feeds getFeeds() throws AzDException {
        return FEED.list();
    }

    /***
     * Get all feeds in an account where you have the provided role access.
     * <p>
     *     If the project parameter is present, gets all feeds in the given project.
     *     If omitted, gets all feeds in the organization.
     * </p>
     * @param feedRole Filter by this role, either Administrator(4), Contributor(3), or Reader(2) level permissions.
     * @param includeDeletedUpstreams Include upstreams that have been deleted in the response.
     * @param includeUrls Resolve names if true
     * @throws AzDException Default Api Exception handler.
     * @return array of feeds {@link Feeds}
     */
    @Override
    public Feeds getFeeds(
            FeedRole feedRole, boolean includeDeletedUpstreams,
            boolean includeUrls) throws AzDException {

        return FEED.list(r -> {
            r.queryParameters.includeUrls = includeUrls;
            r.queryParameters.feedRole = feedRole;
            r.queryParameters.includeDeletedUpstreams = includeDeletedUpstreams;
        });
    }

    /***
     * Update the permissions on a feed.
     * <p>
     *     The project parameter must be supplied if the feed was created in a project.
     *     If the feed is not associated with any project, omit the project parameter from the request.
     * </p>
     * @param feedPermissions List of feed permissions to update the permissions for.
     * @throws AzDException Default Api Exception handler.
     * @return array of feed permissions {@link FeedPermissions}
     */
    @Override
    public FeedPermissions setFeedPermissions(String feedId, FeedPermissions feedPermissions) throws AzDException {
        return FEED.permissions().set(feedId, feedPermissions);
    }

    /***
     * Change the attributes of a feed.
     * <p>
     *     The project parameter must be supplied if the feed was created in a project.
     *     If the feed is not associated with any project, omit the project parameter from the request.
     * </p>
     * @param feedId Name or Id of the feed.
     * @param feed Feed object to update the settings for
     * @throws AzDException Default Api Exception handler.
     * @return feed {@link Feed}
     */
    @Override
    public Feed updateFeed(String feedId, Feed feed) throws AzDException {
        return FEED.update(feedId, feed);
    }

    /***
     * Update a view.
     * <p>
     *     The project parameter must be supplied if the feed was created in a project.
     * </p>
     * @param feedName Name or Id of the feed.
     * @param feedViewName Name or Id of the view.
     * @param feedView Feed view object to update the settings for.
     * @throws AzDException Default Api Exception handler.
     * @return the updated feed view {@link FeedView}
     */
    @Override
    public FeedView updateFeedView(String feedName, String feedViewName, FeedView feedView)
            throws AzDException {
        return FEED.view().update(feedName, feedViewName, feedView);
    }
}
