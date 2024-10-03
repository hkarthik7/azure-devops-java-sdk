package org.azd.feedmanagement.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableCollectionEntity;

import java.util.List;

/**
 * Array of feed views
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class FeedViews extends SerializableCollectionEntity {
    /**
     * Array of feed views
     */
    @JsonProperty("value")
    private List<FeedView> value;

    public List<FeedView> getFeedView() {
        return value;
    }

    public void setFeedView(List<FeedView> feedView) {
        this.value = feedView;
    }

}
