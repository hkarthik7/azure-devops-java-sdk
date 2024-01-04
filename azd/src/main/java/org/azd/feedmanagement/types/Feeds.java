package org.azd.feedmanagement.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableCollectionEntity;

import java.util.List;

/***
 * Array of feed containers
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Feeds extends SerializableCollectionEntity {
    /***
     * Array of feed
     */
    @JsonProperty("value")
    private List<Feed> feeds;

    public List<Feed> getFeeds() {
        return feeds;
    }

    public void setFeeds(List<Feed> feeds) {
        this.feeds = feeds;
    }

}
