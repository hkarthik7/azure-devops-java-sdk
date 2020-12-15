package org.azd.artifacts.feedmanagement.implementation;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.azd.artifacts.feedmanagement.types.*;
import org.azd.exceptions.AzDException;
import org.azd.utils.AzDDefaultParameters;
import org.azd.utils.Request;
import org.azd.utils.RequestMethod;
import org.azd.utils.ResourceId;

import java.util.HashMap;
import java.util.List;

/***
 * Feed Management class to manage Artifacts API
 * @author Harish karthic
 */
public class FeedManagement {
    /***
     * Instance of AzDDefaultParameters
     */
    private final AzDDefaultParameters DEFAULT_PARAMETERS;
    private final ObjectMapper MAPPER = new ObjectMapper();
    private final String AREA = "packaging";

    /***
     * Instantiate the class with instance of AzDDefaultParameters
     * @param defaultParameters instance of AzDDefaultParameters
     */
    public FeedManagement(AzDDefaultParameters defaultParameters) { this.DEFAULT_PARAMETERS = defaultParameters; }

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
     * @return Feed object {@link Feed}
     */
    public Feed createFeed(
            String name, String description, boolean badgesEnabled,
            boolean hideDeletedPackageVersions) {

        try {
            HashMap<String, Object> requestBody = new HashMap<>() {{
                put("name", name);
                put("description", description);
                put("badgesEnabled", badgesEnabled);
                put("hideDeletedPackageVersions", hideDeletedPackageVersions);
            }};

            String r = Request.request(RequestMethod.POST, DEFAULT_PARAMETERS, ResourceId.PACKAGING,
                            DEFAULT_PARAMETERS.getProject() != null ? DEFAULT_PARAMETERS.getProject() : null,
                            AREA, null, "feeds", FeedVersion.VERSION, null, requestBody);

            return MAPPER.readValue(r, Feed.class);

        } catch (Exception e) {
            AzDException.handleException(e);
        }

        return null;
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
     * @return Feed view object {@link FeedView}
     */
    public FeedView createFeedView(String feedName, String name, String feedViewType, String visibility) {

        try {
            HashMap<String, Object> requestBody = new HashMap<>() {{
                put("name", name);
                put("type", feedViewType);
                put("visibility", visibility);
            }};
            String r = Request.request(RequestMethod.POST, DEFAULT_PARAMETERS, ResourceId.PACKAGING,
                            DEFAULT_PARAMETERS.getProject() != null ? DEFAULT_PARAMETERS.getProject() : null,
                            AREA + "/feeds", feedName, "views", FeedVersion.VERSION, null, requestBody);
            return MAPPER.readValue(r, FeedView.class);
        } catch (Exception e) {
            AzDException.handleException(e);
        }

        return null;
    }

    /***
     * Remove a feed and all its packages. The feed moves to the recycle bin and is reversible.
     * <p>
     *     The project parameter must be supplied if the feed was created in a project.
     *     If the feed is not associated with any project, omit the project parameter from the request.
     * </p>
     * @param feedId Name or Id of the feed.
     */
    public void deleteFeed(String feedId) {

        try {
            Request.request(RequestMethod.DELETE, DEFAULT_PARAMETERS, ResourceId.PACKAGING,
                    DEFAULT_PARAMETERS.getProject() != null ? DEFAULT_PARAMETERS.getProject() : null,
                    AREA + "/feeds", feedId, null, FeedVersion.VERSION, null, null);

        } catch (Exception e) {
            AzDException.handleException(e);
        }
    }

    /***
     * Delete a feed view.
     * <p>
     *     The project parameter must be supplied if the feed was created in a project.
     * </p>
     * @param feedId Name or Id of the feed
     * @param feedViewId Id of the feed view
     */
    public void deleteFeedView(String feedId, String feedViewId) {

        try {
            Request.request(RequestMethod.DELETE, DEFAULT_PARAMETERS, ResourceId.PACKAGING,
                    DEFAULT_PARAMETERS.getProject() != null ? DEFAULT_PARAMETERS.getProject() : null,
                    AREA + "/feeds", feedId, "views/" + feedViewId, FeedVersion.VERSION, null, null);

        } catch (Exception e) {
            AzDException.handleException(e);
        }
    }

    /***
     * Get the settings for a specific feed.
     * <p>
     *     The project parameter must be supplied if the feed was created in a project.
     *     If the feed is not associated with any project, omit the project parameter from the request.
     * </p>
     * @param feedName Name of id of the feed
     * @return Feed {@link Feed}
     */
    public Feed getFeed(String feedName) {

        try {
            String r = Request.request(RequestMethod.GET, DEFAULT_PARAMETERS, ResourceId.PACKAGING,
                            DEFAULT_PARAMETERS.getProject() != null ? DEFAULT_PARAMETERS.getProject() : null,
                            AREA + "/Feeds", feedName, null, FeedVersion.VERSION,null, null);

            return MAPPER.readValue(r, Feed.class);

        } catch (Exception e) {
            AzDException.handleException(e);
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
     * @param includeDeletedUpstreams Include upstreams that have been deleted in the response.
     * @return Feed {@link Feed}
     */
    public Feed getFeed(String feedName, boolean includeDeletedUpstreams) {

        HashMap<String, Object> q = new HashMap<>() {{
            put("includeDeletedUpstreams", includeDeletedUpstreams);
        }};

        try {
            String r = Request.request(RequestMethod.GET, DEFAULT_PARAMETERS, ResourceId.PACKAGING,
                    DEFAULT_PARAMETERS.getProject() != null ? DEFAULT_PARAMETERS.getProject() : null,
                    AREA + "/Feeds", feedName, null, FeedVersion.VERSION, q, null);

            return MAPPER.readValue(r, Feed.class);

        } catch (Exception e) {
            AzDException.handleException(e);

        }

        return null;
    }

    /***
     * Get the permissions for a feed.
     * <p>
     *     The project parameter must be supplied if the feed was created in a project.
     *     If the feed is not associated with any project, omit the project parameter from the request.
     * </p>
     * @param feedName Name or Id of the feed.
     * @return Feed Permissions {@link FeedPermissions}
     */
    public FeedPermissions getFeedPermissions(String feedName) {

        try {
            String r = Request.request(RequestMethod.GET, DEFAULT_PARAMETERS, ResourceId.PACKAGING,
                            DEFAULT_PARAMETERS.getProject() != null ? DEFAULT_PARAMETERS.getProject() : null,
                            AREA + "/Feeds", feedName, "permissions", FeedVersion.VERSION, null, null);

            return MAPPER.readValue(r, FeedPermissions.class);

        } catch (Exception e) {
            AzDException.handleException(e);
        }

        return null;
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
     * @return Feed Permissions {@link FeedPermissions}
     */
    public FeedPermissions getFeedPermissions(
            String feedName, boolean excludeInheritedPermissions, String identityDescriptor,
            boolean includeDeletedFeeds, boolean includeIds) {

        try {
            HashMap<String, Object> q = new HashMap<>() {{
                put("excludeInheritedPermissions", excludeInheritedPermissions);
                put("identityDescriptor", identityDescriptor);
                put("includeDeletedFeeds", includeDeletedFeeds);
                put("includeIds", includeIds);
            }};

            String r = Request.request(RequestMethod.GET, DEFAULT_PARAMETERS, ResourceId.PACKAGING,
                    DEFAULT_PARAMETERS.getProject() != null ? DEFAULT_PARAMETERS.getProject() : null,
                    AREA + "/Feeds", feedName, "permissions", FeedVersion.VERSION, q, null);

            return MAPPER.readValue(r, FeedPermissions.class);

        } catch (Exception e) {
            AzDException.handleException(e);
        }

        return null;
    }

    /***
     * Get a view by Id.
     * <p>
     *     The project parameter must be supplied if the feed was created in a project.
     * </p>
     * @param feedName Name or Id of the feed.
     * @param feedViewId Name or Id of the view.
     * @return feed view {@link FeedView}
     */
    public FeedView getFeedView(String feedName, String feedViewId) {

        try {
            String r = Request.request(RequestMethod.GET, DEFAULT_PARAMETERS, ResourceId.PACKAGING,
                    DEFAULT_PARAMETERS.getProject() != null ? DEFAULT_PARAMETERS.getProject() : null,
                    AREA + "/Feeds", feedName, "views/" + feedViewId, FeedVersion.VERSION, null, null);

            return MAPPER.readValue(r, FeedView.class);

        } catch (Exception e) {
            AzDException.handleException(e);
        }

        return null;
    }

    /***
     * Get all views for a feed.
     * <p>
     *     The project parameter must be supplied if the feed was created in a project.
     * </p>
     * @param feedName Name or Id of the feed.
     * @return array feed views {@link FeedView}
     */
    public FeedViews getFeedViews(String feedName) {

        try {
            String r = Request.request(RequestMethod.GET, DEFAULT_PARAMETERS, ResourceId.PACKAGING,
                    DEFAULT_PARAMETERS.getProject() != null ? DEFAULT_PARAMETERS.getProject() : null,
                    AREA + "/Feeds", feedName, "views", FeedVersion.VERSION, null, null);

            return MAPPER.readValue(r, FeedViews.class);

        } catch (Exception e) {
            AzDException.handleException(e);
        }

        return null;
    }

    /***
     * Get all feeds in an account where you have the provided role access.
     * <p>
     *     If the project parameter is present, gets all feeds in the given project.
     *     If omitted, gets all feeds in the organization.
     * </p>
     * @return array of feeds {@link Feeds}
     */
    public Feeds getFeeds() {

        try {
            String r = Request.request(RequestMethod.GET, DEFAULT_PARAMETERS, ResourceId.PACKAGING,
                    DEFAULT_PARAMETERS.getProject() != null ? DEFAULT_PARAMETERS.getProject() : null,
                    AREA, null, "Feeds", FeedVersion.VERSION, null, null);

            return MAPPER.readValue(r, Feeds.class);

        } catch (Exception e) {
            AzDException.handleException(e);
        }

        return null;
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
     * @return array of feeds {@link Feeds}
     */
    public Feeds getFeeds(
            String feedRole, boolean includeDeletedUpstreams,
            boolean includeUrls) {


        try {
            HashMap<String, Object> q = new HashMap<>() {{
                put("feedRole", feedRole);
                put("includeDeletedUpstreams", includeDeletedUpstreams);
                put("includeUrls", includeUrls);
            }};

            String r = Request.request(RequestMethod.GET, DEFAULT_PARAMETERS, ResourceId.PACKAGING,
                    DEFAULT_PARAMETERS.getProject() != null ? DEFAULT_PARAMETERS.getProject() : null,
                    AREA, null, "Feeds", FeedVersion.VERSION, q, null);

            return MAPPER.readValue(r, Feeds.class);

        } catch (Exception e) {
            AzDException.handleException(e);
        }

        return null;
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
     * @return array of feed permissions {@link FeedPermissions}
     */
    public FeedPermissions setFeedPermissions(
            String feedName, String displayName,
            String identityDescriptor, boolean isInheritedRole, String role) {

        try {
            HashMap<String, Object> h = new HashMap<>() {{
                put("displayName", displayName);
                put("identityDescriptor", identityDescriptor);
                put("isInheritedRole", isInheritedRole);
                put("role", role);
            }};

            List<Object> o = List.of(h);

            String r = Request.request(RequestMethod.PATCH, DEFAULT_PARAMETERS, ResourceId.PACKAGING,
                            DEFAULT_PARAMETERS.getProject() != null ? DEFAULT_PARAMETERS.getProject() : null,
                            AREA + "/Feeds", feedName, "permissions", FeedVersion.VERSION, null, null, o, null);

            return MAPPER.readValue(r, FeedPermissions.class);

        } catch (Exception e) {
            AzDException.handleException(e);
        }

        return null;
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
     * @return feed {@link Feed}
     */
    public Feed updateFeed(
            String feedName, boolean badgesEnabled,  String description,
            boolean hideDeletedPackageVersions, boolean upstreamEnabled) {


        try {
            HashMap<String, Object> h = new HashMap<>() {{
                put("name", feedName);
                put("badgesEnabled", badgesEnabled);
                put("description", description);
                put("hideDeletedPackageVersions", hideDeletedPackageVersions);
                put("upstreamEnabled", upstreamEnabled);
            }};

            List<Object> o = List.of(h);

            String r = Request.request(RequestMethod.PATCH, DEFAULT_PARAMETERS, ResourceId.PACKAGING,
                            DEFAULT_PARAMETERS.getProject() != null ? DEFAULT_PARAMETERS.getProject() : null,
                            AREA + "/Feeds", feedName, null, FeedVersion.VERSION, null, null, o, null);

            return MAPPER.readValue(r, Feed.class);

        } catch (Exception e) {
            AzDException.handleException(e);
        }

        return null;
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
     * @return the updated feed view {@link FeedView}
     */
    public FeedView updateFeedView(String feedName, String feedViewName, String feedViewType,  String visibility) {

        try {
            HashMap<String, Object> h = new HashMap<>() {{
                put("name", feedViewName);
                put("type", feedViewType);
                put("visibility", visibility);
            }};

            String r = Request.request(RequestMethod.PATCH, DEFAULT_PARAMETERS, ResourceId.PACKAGING,
                    DEFAULT_PARAMETERS.getProject() != null ? DEFAULT_PARAMETERS.getProject() : null,
                    AREA + "/Feeds", feedName, "views/" + feedViewName, FeedVersion.VERSION, null, h);

            return MAPPER.readValue(r, FeedView.class);

        } catch (Exception e) {
            AzDException.handleException(e);
        }

        return null;
    }
}
