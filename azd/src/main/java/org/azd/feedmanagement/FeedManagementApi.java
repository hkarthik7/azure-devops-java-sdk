package org.azd.feedmanagement;

import org.azd.common.ApiVersion;
import org.azd.connection.Connection;
import org.azd.enums.FeedViewType;
import org.azd.enums.FeedVisibility;
import org.azd.enums.RequestMethod;
import org.azd.exceptions.AzDException;
import org.azd.feedmanagement.types.*;
import org.azd.helpers.JsonMapper;
import org.azd.interfaces.FeedManagementDetails;
import org.azd.utils.AzDAsyncApi;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.azd.utils.Client.send;

/***
 * Feed Management class to manage Artifacts API
 */
public class FeedManagementApi extends AzDAsyncApi<FeedManagementApi> implements FeedManagementDetails {
    /***
     * Connection object
     */
    private final Connection CONNECTION;
    private final JsonMapper MAPPER = new JsonMapper();
    private final String AREA = "packaging";
    private final String PACKAGING = "7ab4e64e-c4d8-4f50-ae73-5ef2e21642a5";

    /***
     * Pass the connection object to work with Feed Management Api
     * @param connection Connection object
     */
    public FeedManagementApi(Connection connection) {
        this.CONNECTION = connection;
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

        HashMap<String, Object> requestBody = new HashMap<>() {{
            put("name", name);
            put("description", description);
            put("badgesEnabled", badgesEnabled);
            put("hideDeletedPackageVersions", hideDeletedPackageVersions);
        }};

        String r = send(RequestMethod.POST, CONNECTION, PACKAGING,
                CONNECTION.getProject() != null ? CONNECTION.getProject() : null,
                AREA, null, "feeds", ApiVersion.FEEDS, null, requestBody);

        return MAPPER.mapJsonResponse(r, Feed.class);
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

        HashMap<String, Object> requestBody = new HashMap<>() {{
            put("name", name);
            put("type", feedViewType.toString().toLowerCase());
            put("visibility", visibility.toString().toLowerCase());
        }};

        String r = send(RequestMethod.POST, CONNECTION, PACKAGING,
                CONNECTION.getProject() != null ? CONNECTION.getProject() : null,
                AREA + "/feeds", feedName, "views", ApiVersion.FEEDS, null, requestBody);

        return MAPPER.mapJsonResponse(r, FeedView.class);
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
        try {
            String r = send(RequestMethod.DELETE, CONNECTION, PACKAGING,
                    CONNECTION.getProject() != null ? CONNECTION.getProject() : null,
                    AREA + "/feeds", feedId, null, ApiVersion.FEEDS, null, null);
            if (!r.isEmpty()) MAPPER.mapJsonResponse(r, Map.class);
        } catch (AzDException e) {
            throw e;
        }
        return null;
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
        try {
            String r = send(RequestMethod.DELETE, CONNECTION, PACKAGING,
                    CONNECTION.getProject() != null ? CONNECTION.getProject() : null,
                    AREA + "/feeds", feedId, "views/" + feedViewId, ApiVersion.FEEDS, null, null);
            if (!r.isEmpty()) MAPPER.mapJsonResponse(r, Map.class);
        } catch (AzDException e) {
            throw e;
        }
        return null;
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

        String r = send(RequestMethod.GET, CONNECTION, PACKAGING,
                CONNECTION.getProject() != null ? CONNECTION.getProject() : null,
                AREA + "/Feeds", feedName, null, ApiVersion.FEEDS, null, null);

        return MAPPER.mapJsonResponse(r, Feed.class);
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

        HashMap<String, Object> q = new HashMap<>() {{
            put("includeDeletedUpstreams", includeDeletedUpstreams);
        }};

        String r = send(RequestMethod.GET, CONNECTION, PACKAGING,
                CONNECTION.getProject() != null ? CONNECTION.getProject() : null,
                AREA + "/Feeds", feedName, null, ApiVersion.FEEDS, q, null);

        return MAPPER.mapJsonResponse(r, Feed.class);
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

        String r = send(RequestMethod.GET, CONNECTION, PACKAGING,
                CONNECTION.getProject() != null ? CONNECTION.getProject() : null,
                AREA + "/Feeds", feedName, "permissions", ApiVersion.FEEDS, null, null);

        return MAPPER.mapJsonResponse(r, FeedPermissions.class);
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

        HashMap<String, Object> q = new HashMap<>() {{
            put("excludeInheritedPermissions", excludeInheritedPermissions);
            put("identityDescriptor", identityDescriptor);
            put("includeDeletedFeeds", includeDeletedFeeds);
            put("includeIds", includeIds);
        }};

        String r = send(RequestMethod.GET, CONNECTION, PACKAGING,
                CONNECTION.getProject() != null ? CONNECTION.getProject() : null,
                AREA + "/Feeds", feedName, "permissions", ApiVersion.FEEDS, q, null);

        return MAPPER.mapJsonResponse(r, FeedPermissions.class);
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

        String r = send(RequestMethod.GET, CONNECTION, PACKAGING,
                CONNECTION.getProject() != null ? CONNECTION.getProject() : null,
                AREA + "/Feeds", feedName, "views/" + feedViewId, ApiVersion.FEEDS, null, null);

        return MAPPER.mapJsonResponse(r, FeedView.class);
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

        String r = send(RequestMethod.GET, CONNECTION, PACKAGING,
                CONNECTION.getProject() != null ? CONNECTION.getProject() : null,
                AREA + "/Feeds", feedName, "views", ApiVersion.FEEDS, null, null);

        return MAPPER.mapJsonResponse(r, FeedViews.class);
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

        String r = send(RequestMethod.GET, CONNECTION, PACKAGING,
                CONNECTION.getProject() != null ? CONNECTION.getProject() : null,
                AREA, null, "Feeds", ApiVersion.FEEDS, null, null);

        return MAPPER.mapJsonResponse(r, Feeds.class);
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
            String feedRole, boolean includeDeletedUpstreams,
            boolean includeUrls) throws AzDException {

        HashMap<String, Object> q = new HashMap<>() {{
            put("feedRole", feedRole);
            put("includeDeletedUpstreams", includeDeletedUpstreams);
            put("includeUrls", includeUrls);
        }};

        String r = send(RequestMethod.GET, CONNECTION, PACKAGING,
                CONNECTION.getProject() != null ? CONNECTION.getProject() : null,
                AREA, null, "Feeds", ApiVersion.FEEDS, q, null);

        return MAPPER.mapJsonResponse(r, Feeds.class);
    }

    /***
     * Update the permissions on a feed.
     * <p>
     *     The project parameter must be supplied if the feed was created in a project.
     *     If the feed is not associated with any project, omit the project parameter from the request.
     * </p>
     * @param feedName Name or Id of the feed.
     * @param displayName Display name for the identity. This can be an empty string or null
     * @param identityDescriptor Identity associated with this role. You can run getFeedPermissions to get the Identity descriptor
     * @param isInheritedRole Boolean indicating whether the role is inherited or set directly.
     * @param role The role for this identity on a feed.
     * @throws AzDException Default Api Exception handler.
     * @return array of feed permissions {@link FeedPermissions}
     */
    @Override
    public FeedPermissions setFeedPermissions(
            String feedName, String displayName,
            String identityDescriptor, boolean isInheritedRole, String role) throws AzDException {

        HashMap<String, Object> h = new HashMap<>() {{
            put("displayName", displayName);
            put("identityDescriptor", identityDescriptor);
            put("isInheritedRole", isInheritedRole);
            put("role", role);
        }};

        List<Object> o = List.of(h);

        String r = send(RequestMethod.PATCH, CONNECTION, PACKAGING,
                CONNECTION.getProject() != null ? CONNECTION.getProject() : null,
                AREA + "/Feeds", feedName, "permissions", ApiVersion.FEEDS, null, null, o, null);

        return MAPPER.mapJsonResponse(r, FeedPermissions.class);
    }

    /***
     * Change the attributes of a feed.
     * <p>
     *     The project parameter must be supplied if the feed was created in a project.
     *     If the feed is not associated with any project, omit the project parameter from the request.
     * </p>
     * @param feedName Name or Id of the feed.
     * @param badgesEnabled If set, this feed supports generation of package badges.
     * @param description A description for the feed.
     * @param hideDeletedPackageVersions If set, feed will hide all deleted/unpublished versions
     * @param upstreamEnabled If set, the feed can proxy packages from an upstream feed
     * @throws AzDException Default Api Exception handler.
     * @return feed {@link Feed}
     */
    @Override
    public Feed updateFeed(
            String id, String feedName, boolean badgesEnabled, String description,
            boolean hideDeletedPackageVersions, boolean upstreamEnabled) throws AzDException {

        HashMap<String, Object> h = new HashMap<>() {{
            put("name", feedName);
            put("badgesEnabled", badgesEnabled);
            put("description", description);
            put("hideDeletedPackageVersions", hideDeletedPackageVersions);
            put("upstreamEnabled", upstreamEnabled);
        }};

        String r = send(RequestMethod.PATCH, CONNECTION, PACKAGING,
                CONNECTION.getProject() != null ? CONNECTION.getProject() : null,
                AREA + "/Feeds", id, null, ApiVersion.FEEDS, null, h);

        return MAPPER.mapJsonResponse(r, Feed.class);
    }

    /***
     * Update a view.
     * <p>
     *     The project parameter must be supplied if the feed was created in a project.
     * </p>
     * @param feedName Name or Id of the feed.
     * @param feedViewName Name or Id of the view.
     * @param feedViewType type of the feed view. Allowed are [implicit and release]
     * @param visibility visibility of the feed
     * @throws AzDException Default Api Exception handler.
     * @return the updated feed view {@link FeedView}
     */
    @Override
    public FeedView updateFeedView(String feedName, String feedViewName, FeedViewType feedViewType, FeedVisibility visibility)
            throws AzDException {

        HashMap<String, Object> h = new HashMap<>() {{
            put("name", feedViewName);
            put("type", feedViewType.toString().toLowerCase());
            put("visibility", visibility.toString().toLowerCase());
        }};

        String r = send(RequestMethod.PATCH, CONNECTION, PACKAGING,
                CONNECTION.getProject() != null ? CONNECTION.getProject() : null,
                AREA + "/Feeds", feedName, "views/" + feedViewName, ApiVersion.FEEDS, null, h);

        return MAPPER.mapJsonResponse(r, FeedView.class);
    }
}
