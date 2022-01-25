package org.azd.interfaces;

import org.azd.enums.FeedViewType;
import org.azd.enums.FeedVisibility;
import org.azd.exceptions.AzDException;
import org.azd.feedmanagement.types.*;

public interface FeedManagementDetails {
    Feed createFeed(
            String name, String description, boolean badgesEnabled,
            boolean hideDeletedPackageVersions) throws AzDException;

    FeedView createFeedView(String feedName, String name, FeedViewType feedViewType, FeedVisibility visibility) throws AzDException;

    Void deleteFeed(String feedId) throws AzDException;

    Void deleteFeedView(String feedId, String feedViewId) throws AzDException;

    Feed getFeed(String feedName) throws AzDException;

    Feed getFeed(String feedName, boolean includeDeletedUpstreams) throws AzDException;

    FeedPermissions getFeedPermissions(String feedName) throws AzDException;

    FeedPermissions getFeedPermissions(
            String feedName, boolean excludeInheritedPermissions, String identityDescriptor,
            boolean includeDeletedFeeds, boolean includeIds) throws AzDException;

    FeedView getFeedView(String feedName, String feedViewId) throws AzDException;

    FeedViews getFeedViews(String feedName) throws AzDException;

    Feeds getFeeds() throws AzDException;

    Feeds getFeeds(
            String feedRole, boolean includeDeletedUpstreams,
            boolean includeUrls) throws AzDException;

    FeedPermissions setFeedPermissions(
            String feedName, String displayName,
            String identityDescriptor, boolean isInheritedRole, String role) throws AzDException;

    Feed updateFeed(
            String feedName, boolean badgesEnabled, String description,
            boolean hideDeletedPackageVersions, boolean upstreamEnabled) throws AzDException;

    FeedView updateFeedView(String feedName, String feedViewName, FeedViewType feedViewType, FeedVisibility visibility) throws AzDException;
}
