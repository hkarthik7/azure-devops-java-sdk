package org.azd.wiki.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WikiV2Pages {
    @JsonProperty("value")
    private List<WikiV2> wikiPages;

    public List<WikiV2> getValue() {
        return wikiPages;
    }

    public void setValue(List<WikiV2> wikiPages) {
        this.wikiPages = wikiPages;
    }

    @Override
    public String toString() {
        return "WikiV2s{" +
                "wikiPages=" + wikiPages +
                '}';
    }
}
