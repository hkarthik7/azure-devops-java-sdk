package org.azd.artifacts.feedmanagement.implementation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.azd.artifacts.feedmanagement.types.*;
import org.azd.exceptions.DefaultParametersException;
import org.azd.utils.AzDDefaultParameters;
import org.azd.utils.RequestAPI;
import org.azd.utils.ResourceId;
import org.azd.utils.Url;


import java.io.IOException;
import java.util.ArrayList;
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
    private final AzDDefaultParameters defaultParameters;

    /***
     * Instantiate the class with instance of AzDDefaultParameters
     * @param defaultParameters instance of AzDDefaultParameters
     */
    public FeedManagement(AzDDefaultParameters defaultParameters) { this.defaultParameters = defaultParameters; }

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
     * @throws DefaultParametersException throws default parameter exception {@link DefaultParametersException}
     * @throws IOException throws IO Exception exception {@link IOException}
     * @return For successful operation -> {@link Feed}
     */
    public Feed createFeed(
            String name, String description, boolean badgesEnabled,
            boolean hideDeletedPackageVersions) throws DefaultParametersException, IOException {

        String project = defaultParameters.getProject() != null ? defaultParameters.getProject() : null;

        String feedUrl = new Url(defaultParameters).buildRequestUrl(
                ResourceId.PACKAGING,
                project,
                "packaging/feeds",
                null,
                null,
                FeedVersion.Version,
                null);

        HashMap<String, Object> requestBody = new HashMap<>() {{
            put("name", name);
            put("description", description);
            put("badgesEnabled", badgesEnabled);
            put("hideDeletedPackageVersions", hideDeletedPackageVersions);
        }};

        String response = RequestAPI.post(feedUrl, defaultParameters.getPersonalAccessToken(), requestBody);
        ObjectMapper mapper = new ObjectMapper();
        Feed feed = mapper.readValue(response, new TypeReference<>() {});

        return feed;
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
     * @throws DefaultParametersException throws default parameter exception {@link DefaultParametersException}
     * @throws IOException throws IO Exception exception {@link IOException}
     */
    public FeedView createFeedView(String feedName, String name, String feedViewType, String visibility) throws IOException, DefaultParametersException {

        String project = defaultParameters.getProject() != null ? defaultParameters.getProject() : null;

        String feedUrl = new Url(defaultParameters).buildRequestUrl(
                ResourceId.PACKAGING,
                project,
                "packaging/Feeds",
                feedName,
                "views",
                FeedVersion.Version,
                null);

        HashMap<String, Object> requestBody = new HashMap<>() {{
            put("name", name);
            put("type", feedViewType);
            put("visibility", visibility);
        }};

        String response = RequestAPI.post(feedUrl, defaultParameters.getPersonalAccessToken(), requestBody);
        ObjectMapper mapper = new ObjectMapper();
        FeedView feedView = mapper.readValue(response, new TypeReference<>() {});

        return feedView;
    }

    /***
     * Remove a feed and all its packages. The feed moves to the recycle bin and is reversible.
     * <p>
     *     The project parameter must be supplied if the feed was created in a project.
     *     If the feed is not associated with any project, omit the project parameter from the request.
     * </p>
     * @param feedId Name or Id of the feed.
     * @throws DefaultParametersException throws default parameter exception {@link DefaultParametersException}
     */
    public void deleteFeed(String feedId) throws DefaultParametersException {

        String project = defaultParameters.getProject() != null ? defaultParameters.getProject() : null;

        String feedUrl = new Url(defaultParameters).buildRequestUrl(
                ResourceId.PACKAGING,
                project,
                "packaging/Feeds",
                feedId,
                null,
                FeedVersion.Version,
                null);

        RequestAPI.delete(feedUrl, defaultParameters.getPersonalAccessToken());
    }

    /***
     * Delete a feed view.
     * <p>
     *     The project parameter must be supplied if the feed was created in a project.
     * </p>
     * @param feedId Name or Id of the feed
     * @param feedViewId Id of the feed view
     * @throws DefaultParametersException throws default parameter exception {@link DefaultParametersException}
     */
    public void deleteFeedView(String feedId, String feedViewId) throws DefaultParametersException {

        String project = defaultParameters.getProject() != null ? defaultParameters.getProject() : null;

        String feedUrl = new Url(defaultParameters).buildRequestUrl(
                ResourceId.PACKAGING,
                project,
                "packaging/Feeds",
                feedId,
                "views/" + feedViewId,
                FeedVersion.Version,
                null);

        RequestAPI.delete(feedUrl, defaultParameters.getPersonalAccessToken());
    }

    /***
     * Get the settings for a specific feed.
     * <p>
     *     The project parameter must be supplied if the feed was created in a project.
     *     If the feed is not associated with any project, omit the project parameter from the request.
     * </p>
     * @param feedName Name of id of the feed
     * @return Feed {@link Feed}
     * @throws DefaultParametersException throws default parameter exception {@link DefaultParametersException}
     * @throws JsonProcessingException --> {@link JsonProcessingException}
     */
    public Feed getFeed(String feedName) throws DefaultParametersException, JsonProcessingException {

        String project = defaultParameters.getProject() != null ? defaultParameters.getProject() : null;

        String feedUrl = new Url(defaultParameters).buildRequestUrl(
                ResourceId.PACKAGING,
                project,
                "packaging/Feeds",
                feedName,
                null,
                FeedVersion.Version,
                null);

        String response = RequestAPI.get(feedUrl, defaultParameters.getPersonalAccessToken());
        ObjectMapper mapper = new ObjectMapper();
        Feed feed = mapper.readValue(response, new TypeReference<>() {});

        return feed;
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
     * @throws DefaultParametersException throws default parameter exception {@link DefaultParametersException}
     * @throws JsonProcessingException --> {@link JsonProcessingException}
     */
    public Feed getFeed(String feedName, boolean includeDeletedUpstreams) throws DefaultParametersException, JsonProcessingException {

        String project = defaultParameters.getProject() != null ? defaultParameters.getProject() : null;

        HashMap<String, Object> q = new HashMap<>() {{
            put("includeDeletedUpstreams", includeDeletedUpstreams);
        }};

        String feedUrl = new Url(defaultParameters).buildRequestUrl(
                ResourceId.PACKAGING,
                project,
                "packaging/Feeds",
                feedName,
                null,
                FeedVersion.Version,
                q);

        String response = RequestAPI.get(feedUrl, defaultParameters.getPersonalAccessToken());
        ObjectMapper mapper = new ObjectMapper();
        Feed feed = mapper.readValue(response, new TypeReference<>() {});

        return feed;
    }

    /***
     * Get the permissions for a feed.
     * <p>
     *     The project parameter must be supplied if the feed was created in a project.
     *     If the feed is not associated with any project, omit the project parameter from the request.
     * </p>
     * @param feedName Name or Id of the feed.
     * @return Feed Permissions {@link FeedPermissions}
     * @throws DefaultParametersException throws default parameter exception {@link DefaultParametersException}
     * @throws JsonProcessingException --> {@link JsonProcessingException}
     */
    public FeedPermissions getFeedPermissions(String feedName) throws DefaultParametersException, JsonProcessingException {

        String project = defaultParameters.getProject() != null ? defaultParameters.getProject() : null;

        String feedUrl = new Url(defaultParameters).buildRequestUrl(
                ResourceId.PACKAGING,
                project,
                "packaging/Feeds",
                feedName,
                "permissions",
                FeedVersion.Version,
                null);

        String response = RequestAPI.get(feedUrl, defaultParameters.getPersonalAccessToken());
        ObjectMapper mapper = new ObjectMapper();
        FeedPermissions feedPermissions = mapper.readValue(response, new TypeReference<>() {});

        return feedPermissions;
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
     * @throws DefaultParametersException throws default parameter exception {@link DefaultParametersException}
     * @throws JsonProcessingException --> {@link JsonProcessingException}
     */
    public FeedPermissions getFeedPermissions(
            String feedName, boolean excludeInheritedPermissions, String identityDescriptor,
            boolean includeDeletedFeeds, boolean includeIds) throws DefaultParametersException, JsonProcessingException {

        String project = defaultParameters.getProject() != null ? defaultParameters.getProject() : null;

        HashMap<String, Object> q = new HashMap<>() {{
            put("excludeInheritedPermissions", excludeInheritedPermissions);
            put("identityDescriptor", identityDescriptor);
            put("includeDeletedFeeds", includeDeletedFeeds);
            put("includeIds", includeIds);
        }};

        String feedUrl = new Url(defaultParameters).buildRequestUrl(
                ResourceId.PACKAGING,
                project,
                "packaging/Feeds",
                feedName,
                "permissions",
                FeedVersion.Version,
                q);

        String response = RequestAPI.get(feedUrl, defaultParameters.getPersonalAccessToken());
        ObjectMapper mapper = new ObjectMapper();
        FeedPermissions feedPermissions = mapper.readValue(response, new TypeReference<>() {});

        return feedPermissions;
    }

    /***
     * Get a view by Id.
     * <p>
     *     The project parameter must be supplied if the feed was created in a project.
     * </p>
     * @param feedName Name or Id of the feed.
     * @param feedViewId Name or Id of the view.
     * @return feed view {@link FeedView}
     * @throws DefaultParametersException throws default parameter exception {@link DefaultParametersException}
     * @throws JsonProcessingException --> {@link JsonProcessingException}
     */
    public FeedView getFeedView(String feedName, String feedViewId) throws DefaultParametersException, JsonProcessingException {

        String project = defaultParameters.getProject() != null ? defaultParameters.getProject() : null;

        String feedUrl = new Url(defaultParameters).buildRequestUrl(
                ResourceId.PACKAGING,
                project,
                "packaging/Feeds",
                feedName,
                "views/" + feedViewId,
                FeedVersion.Version,
                null);

        String response = RequestAPI.get(feedUrl, defaultParameters.getPersonalAccessToken());
        ObjectMapper mapper = new ObjectMapper();
        FeedView feedView = mapper.readValue(response, new TypeReference<>() {});

        return feedView;
    }

    /***
     * Get all views for a feed.
     * <p>
     *     The project parameter must be supplied if the feed was created in a project.
     * </p>
     * @param feedName Name or Id of the feed.
     * @return array feed views {@link FeedView}
     * @throws DefaultParametersException throws default parameter exception {@link DefaultParametersException}
     * @throws JsonProcessingException --> {@link JsonProcessingException}
     */
    public FeedViews getFeedViews(String feedName) throws DefaultParametersException, JsonProcessingException {

        String project = defaultParameters.getProject() != null ? defaultParameters.getProject() : null;

        String feedUrl = new Url(defaultParameters).buildRequestUrl(
                ResourceId.PACKAGING,
                project,
                "packaging/Feeds",
                feedName,
                "views",
                FeedVersion.Version,
                null);

        String response = RequestAPI.get(feedUrl, defaultParameters.getPersonalAccessToken());
        ObjectMapper mapper = new ObjectMapper();
        FeedViews feedViews = mapper.readValue(response, new TypeReference<>() {});

        return feedViews;
    }

    /***
     * Get all feeds in an account where you have the provided role access.
     * <p>
     *     If the project parameter is present, gets all feeds in the given project.
     *     If omitted, gets all feeds in the organization.
     * </p>
     * @return array of feeds {@link Feeds}
     * @throws DefaultParametersException throws default parameter exception {@link DefaultParametersException}
     * @throws JsonProcessingException --> {@link JsonProcessingException}
     */
    public Feeds getFeeds() throws DefaultParametersException, JsonProcessingException {

        String project = defaultParameters.getProject() != null ? defaultParameters.getProject() : null;

        String feedUrl = new Url(defaultParameters).buildRequestUrl(
                ResourceId.PACKAGING,
                project,
                "packaging/Feeds",
                null,
                null,
                FeedVersion.Version,
                null);

        String response = RequestAPI.get(feedUrl, defaultParameters.getPersonalAccessToken());
        ObjectMapper mapper = new ObjectMapper();
        Feeds feeds = mapper.readValue(response, new TypeReference<>() {});

        return feeds;
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
     * @throws DefaultParametersException throws default parameter exception {@link DefaultParametersException}
     * @throws JsonProcessingException --> {@link JsonProcessingException}
     */
    public Feeds getFeeds(
            String feedRole, boolean includeDeletedUpstreams,
            boolean includeUrls) throws DefaultParametersException, JsonProcessingException {

        String project = defaultParameters.getProject() != null ? defaultParameters.getProject() : null;

        HashMap<String, Object> q = new HashMap<>() {{
            put("feedRole", feedRole);
            put("includeDeletedUpstreams", includeDeletedUpstreams);
            put("includeUrls", includeUrls);
        }};

        String feedUrl = new Url(defaultParameters).buildRequestUrl(
                ResourceId.PACKAGING,
                project,
                "packaging/Feeds",
                null,
                null,
                FeedVersion.Version,
                q);

        String response = RequestAPI.get(feedUrl, defaultParameters.getPersonalAccessToken());
        ObjectMapper mapper = new ObjectMapper();
        Feeds feeds = mapper.readValue(response, new TypeReference<>() {});

        return feeds;
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
     * @throws DefaultParametersException throws default parameter exception {@link DefaultParametersException}
     * @throws JsonProcessingException --> {@link JsonProcessingException}
     */
    public FeedPermissions setFeedPermissions(
            String feedName, String displayName,
            String identityDescriptor, boolean isInheritedRole, String role) throws DefaultParametersException, IOException {

        String project = defaultParameters.getProject() != null ? defaultParameters.getProject() : null;

        String feedUrl = new Url(defaultParameters).buildRequestUrl(
                ResourceId.PACKAGING,
                project,
                "packaging/Feeds",
                feedName,
                "permissions",
                FeedVersion.Version,
                null);

        HashMap<String, Object> h = new HashMap<>() {{
            put("displayName", displayName);
            put("identityDescriptor", identityDescriptor);
            put("isInheritedRole", isInheritedRole);
            put("role", role);
        }};

        List<Object> o = new ArrayList<>(){};
        o.add(h);

        String response = RequestAPI.patch(feedUrl, defaultParameters.getPersonalAccessToken(), o);
        ObjectMapper mapper = new ObjectMapper();
        FeedPermissions fP = mapper.readValue(response, new TypeReference<>() {});

        return fP;
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
     * @throws DefaultParametersException throws default parameter exception {@link DefaultParametersException}
     * @throws JsonProcessingException --> {@link JsonProcessingException}
     */
    public Feed updateFeed(
            String feedName, boolean badgesEnabled,  String description,
            boolean hideDeletedPackageVersions, boolean upstreamEnabled) throws DefaultParametersException, IOException {

        String project = defaultParameters.getProject() != null ? defaultParameters.getProject() : null;

        String feedUrl = new Url(defaultParameters).buildRequestUrl(
                ResourceId.PACKAGING,
                project,
                "packaging/Feeds",
                feedName,
                null,
                FeedVersion.Version,
                null);

        HashMap<String, Object> h = new HashMap<>() {{
            put("name", feedName);
            put("badgesEnabled", badgesEnabled);
            put("description", description);
            put("hideDeletedPackageVersions", hideDeletedPackageVersions);
            put("upstreamEnabled", upstreamEnabled);
        }};

        List<Object> o = new ArrayList<>(){};
        o.add(h);

        String response = RequestAPI.patch(feedUrl, defaultParameters.getPersonalAccessToken(), o);
        ObjectMapper mapper = new ObjectMapper();
        Feed feed = mapper.readValue(response, new TypeReference<>() {});

        return feed;
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
     * @throws DefaultParametersException throws default parameter exception {@link DefaultParametersException}
     * @throws JsonProcessingException --> {@link JsonProcessingException}
     */
    public FeedView updateFeedView(String feedName, String feedViewName, String feedViewType,  String visibility) throws DefaultParametersException, IOException {

        String project = defaultParameters.getProject() != null ? defaultParameters.getProject() : null;

        String feedUrl = new Url(defaultParameters).buildRequestUrl(
                ResourceId.PACKAGING,
                project,
                "packaging/Feeds",
                feedName,
                "views/" + feedViewName,
                FeedVersion.Version,
                null);

        HashMap<String, Object> h = new HashMap<>() {{
            put("name", feedViewName);
            put("type", feedViewType);
            put("visibility", visibility);
        }};

        String response = RequestAPI.patch(feedUrl, defaultParameters.getPersonalAccessToken(), h);
        ObjectMapper mapper = new ObjectMapper();
        FeedView feedView = mapper.readValue(response, new TypeReference<>() {});

        return feedView;
    }
}
