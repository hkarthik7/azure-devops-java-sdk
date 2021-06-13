package org.azd.artifacts.feedmanagement.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FeedPermissions {
    @JsonProperty("value")
    private List<FeedPermission> feedPermissions;

    public List<FeedPermission> getFeedPermission() {
        return feedPermissions;
    }

    public void setFeedPermission(List<FeedPermission> feedPermissions) {
        feedPermissions = feedPermissions;
    }

    @Override
    public String toString() {
        return "FeedPermissions{" +
                "FeedPermission=" + feedPermissions +
                '}';
    }
}
