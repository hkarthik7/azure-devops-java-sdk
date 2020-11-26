package org.azd.artifacts.feedmanagement.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FeedPermissions {
    @JsonProperty("value")
    private List<FeedPermission> value;

    public List<FeedPermission> getFeedPermission() {
        return value;
    }

    public void setFeedPermission(List<FeedPermission> feedPermission) {
        value = feedPermission;
    }

    @Override
    public String toString() {
        return "FeedPermissions{" +
                "FeedPermission=" + value +
                '}';
    }
}
