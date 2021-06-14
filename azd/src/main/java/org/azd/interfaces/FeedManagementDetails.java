package org.azd.interfaces;

import org.azd.artifacts.feedmanagement.types.*;
import org.azd.enums.FeedViewType;
import org.azd.enums.FeedVisibility;
import org.azd.exceptions.AzDException;
import org.azd.exceptions.DefaultParametersException;

public interface FeedManagementDetails {
    Feed createFeed(
            String name, String description, boolean badgesEnabled,
            boolean hideDeletedPackageVersions) throws DefaultParametersException, AzDException;

    FeedView createFeedView(String feedName, String name, FeedViewType feedViewType, FeedVisibility visibility) throws DefaultParametersException, AzDException;

    void deleteFeed(String feedId) throws DefaultParametersException, AzDException;

    void deleteFeedView(String feedId, String feedViewId) throws DefaultParametersException, AzDException;

    Feed getFeed(String feedName) throws DefaultParametersException, AzDException;

    Feed getFeed(String feedName, boolean includeDeletedUpstreams) throws DefaultParametersException, AzDException;

    FeedPermissions getFeedPermissions(String feedName) throws DefaultParametersException, AzDException;

    FeedPermissions getFeedPermissions(
            String feedName, boolean excludeInheritedPermissions, String identityDescriptor,
            boolean includeDeletedFeeds, boolean includeIds) throws DefaultParametersException, AzDException;

    FeedView getFeedView(String feedName, String feedViewId) throws DefaultParametersException, AzDException;

    FeedViews getFeedViews(String feedName) throws DefaultParametersException, AzDException;

    Feeds getFeeds() throws DefaultParametersException, AzDException;

    Feeds getFeeds(
            String feedRole, boolean includeDeletedUpstreams,
            boolean includeUrls) throws DefaultParametersException, AzDException;

    FeedPermissions setFeedPermissions(
            String feedName, String displayName,
            String identityDescriptor, boolean isInheritedRole, String role) throws DefaultParametersException, AzDException;

    Feed updateFeed(
            String feedName, boolean badgesEnabled, String description,
            boolean hideDeletedPackageVersions, boolean upstreamEnabled) throws DefaultParametersException, AzDException;

    FeedView updateFeedView(String feedName, String feedViewName, String feedViewType, String visibility) throws DefaultParametersException, AzDException;
}
