package org.azd.build.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.Reference;
import org.azd.common.types.ReferenceLink;

/***
 * The class to represent a collection of REST reference links.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class BuildDefinitionReferenceLinks extends ReferenceLink {
    /***
     *
     * web url
     */
    @JsonProperty("web")
    private Reference web;
    /***
     * REST editor url
     */
    @JsonProperty("editor")
    private Reference editor;
    /***
     * REST badge url
     */
    @JsonProperty("badge")
    private Reference badge;

    @Override
    public String toString() {
        return "BuildDefinitionReferenceLinks{" +
                "web=" + web +
                ", editor=" + editor +
                ", badge=" + badge +
                '}';
    }

    public Reference getWeb() {
        return web;
    }

    public void setWeb(Reference web) {
        this.web = web;
    }

    public Reference getEditor() {
        return editor;
    }

    public void setEditor(Reference editor) {
        this.editor = editor;
    }

    public Reference getBadge() {
        return badge;
    }

    public void setBadge(Reference badge) {
        this.badge = badge;
    }
}
