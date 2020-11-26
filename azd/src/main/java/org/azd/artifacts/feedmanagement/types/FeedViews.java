package org.azd.artifacts.feedmanagement.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FeedViews {
    @JsonProperty("value")
    private List<FeedView> value;

    public List<FeedView> getFeedView() {
        return value;
    }

    public void setFeedView(List<FeedView> feedView) {
        this.value = feedView;
    }

    @Override
    public String toString() {
        return "FeedViews{" +
                "FeedView=" + value +
                '}';
    }
}
