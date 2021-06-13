package org.azd.artifacts.feedmanagement.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Feeds {
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
