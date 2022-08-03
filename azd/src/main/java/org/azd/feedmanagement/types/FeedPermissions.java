package org.azd.feedmanagement.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

import java.util.List;

/***
 * Permissions for a feed.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class FeedPermissions extends BaseAbstractMethod {
    /***
     * Array of feed permissions.
     */
    @JsonProperty("value")
    private List<FeedPermission> feedPermissions;

    public List<FeedPermission> getFeedPermission() {
        return feedPermissions;
    }

    public void setFeedPermission(List<FeedPermission> feedPermissions) {
        feedPermissions = feedPermissions;
    }

}
