package org.azd.wiki.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableCollectionEntity;

import java.util.List;

/**
 * List of wiki pages
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WikiV2Pages extends SerializableCollectionEntity {
    /**
     * List of wiki pages
     */
    @JsonProperty("value")
    private List<WikiV2> wikiPages;

    public List<WikiV2> getWikiPages() {
        return wikiPages;
    }

    public void setWikiPages(List<WikiV2> wikiPages) {
        this.wikiPages = wikiPages;
    }

}
