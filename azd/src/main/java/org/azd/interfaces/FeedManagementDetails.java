package org.azd.interfaces;

import org.azd.enums.FeedViewType;
import org.azd.enums.FeedVisibility;
import org.azd.exceptions.AzDException;
import org.azd.exceptions.ConnectionException;
import org.azd.feedmanagement.types.*;

public interface FeedManagementDetails {
    Feed createFeed(
            String name, String description, boolean badgesEnabled,
            boolean hideDeletedPackageVersions) throws ConnectionException, AzDException;

    FeedView createFeedView(String feedName, String name, FeedViewType feedViewType, FeedVisibility visibility) throws ConnectionException, AzDException;

    void deleteFeed(String feedId) throws ConnectionException, AzDException;

    void deleteFeedView(String feedId, String feedViewId) throws ConnectionException, AzDException;

    Feed getFeed(String feedName) throws ConnectionException, AzDException;

    Feed getFeed(String feedName, boolean includeDeletedUpstreams) throws ConnectionException, AzDException;

    FeedPermissions getFeedPermissions(String feedName) throws ConnectionException, AzDException;

    FeedPermissions getFeedPermissions(
            String feedName, boolean excludeInheritedPermissions, String identityDescriptor,
            boolean includeDeletedFeeds, boolean includeIds) throws ConnectionException, AzDException;

    FeedView getFeedView(String feedName, String feedViewId) throws ConnectionException, AzDException;

    FeedViews getFeedViews(String feedName) throws ConnectionException, AzDException;

    Feeds getFeeds() throws ConnectionException, AzDException;

    Feeds getFeeds(
            String feedRole, boolean includeDeletedUpstreams,
            boolean includeUrls) throws ConnectionException, AzDException;

    FeedPermissions setFeedPermissions(
            String feedName, String displayName,
            String identityDescriptor, boolean isInheritedRole, String role) throws ConnectionException, AzDException;

    Feed updateFeed(
            String feedName, boolean badgesEnabled, String description,
            boolean hideDeletedPackageVersions, boolean upstreamEnabled) throws ConnectionException, AzDException;

    FeedView updateFeedView(String feedName, String feedViewName, String feedViewType, String visibility) throws ConnectionException, AzDException;
}
