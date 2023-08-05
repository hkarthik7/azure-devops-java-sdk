package org.azd.feedmanagement.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.serializer.SerializableEntity;

import java.util.List;

/***
 * Array of feed containers
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Feeds extends SerializableEntity {
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

}
