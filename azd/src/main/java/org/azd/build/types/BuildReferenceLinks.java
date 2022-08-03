package org.azd.build.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;
import org.azd.common.types.Reference;

/***
 * The class to represent a collection of REST reference links.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class BuildReferenceLinks extends BaseAbstractMethod {
    /***
     * REST url of web service
     */
    @JsonProperty("web")
    private Reference web;
    /***
     * REST url pf source version
     */
    @JsonProperty("sourceVersionDisplayUri")
    private Reference sourceVersionDisplayUri;
    /***
     * REST url of build timeline
     */
    @JsonProperty("timeline")
    private Reference timeline;
    /***
     * REST url of build badge
     */
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

}
