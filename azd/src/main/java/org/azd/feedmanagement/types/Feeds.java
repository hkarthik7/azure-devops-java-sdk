package org.azd.feedmanagement.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/***
 * Array of feed containers
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Feeds {
    /***
     * Array of feed
     */
    @JsonProperty("value")
    private List<Feed> feeds;

    public List<Feed> getFeed() {
        return feeds;
    }

    public void setFeed(List<Feed> feeds) {
        this.feeds = feeds;
    }

    @Override
    public String toString() {
        return "Feeds{" +
                "Feed=" + feeds +
                '}';
    }
}
