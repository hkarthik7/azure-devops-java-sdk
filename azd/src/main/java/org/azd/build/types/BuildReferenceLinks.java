package org.azd.build.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.Reference;
import org.azd.common.types.ReferenceLink;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BuildReferenceLinks extends ReferenceLink {
    @JsonProperty("web")
    private Reference web;
    @JsonProperty("sourceVersionDisplayUri")
    private Reference sourceVersionDisplayUri;
    @JsonProperty("timeline")
    private Reference timeline;
    @JsonProperty("badge")
    private Reference badge;

    public Reference getWeb() {
        return web;
    }

    public void setWeb(Reference web) {
        this.web = web;
    }

    public Reference getSourceVersionDisplayUri() {
        return sourceVersionDisplayUri;
    }

    public void setSourceVersionDisplayUri(Reference sourceVersionDisplayUri) {
        this.sourceVersionDisplayUri = sourceVersionDisplayUri;
    }

    public Reference getTimeline() {
        return timeline;
    }

    public void setTimeline(Reference timeline) {
        this.timeline = timeline;
    }

    public Reference getBadge() {
        return badge;
    }

    public void setBadge(Reference badge) {
        this.badge = badge;
    }

    @Override
    public String toString() {
        return "BuildReferenceLinks{" +
                "web=" + web +
                ", sourceVersionDisplayUri=" + sourceVersionDisplayUri +
                ", timeline=" + timeline +
                ", badge=" + badge +
                '}';
    }
}
