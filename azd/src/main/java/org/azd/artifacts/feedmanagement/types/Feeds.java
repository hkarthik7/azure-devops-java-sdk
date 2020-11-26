package org.azd.artifacts.feedmanagement.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Feeds {
    @JsonProperty("value")
    private List<Feed> value;

    public List<Feed> getFeed() {
        return value;
    }

    public void setFeed(List<Feed> feed) {
        this.value = feed;
    }

    @Override
    public String toString() {
        return "Feeds{" +
                "Feed=" + value +
                '}';
    }
}
