package org.azd.wiki.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableCollectionEntity;

import java.util.List;

/**
 * Collection of WikiPageDetail.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WikiPageDetails extends SerializableCollectionEntity {
    /**
     * Collection of WikiPageDetail.
     */
    @JsonProperty("value")
    private List<WikiPageDetail> wikiPageDetails;

    public List<WikiPageDetail> getWikiPageDetails() {
        return wikiPageDetails;
    }

    public void setWikiPageDetails(List<WikiPageDetail> wikiPageDetails) {
        this.wikiPageDetails = wikiPageDetails;
    }
}
