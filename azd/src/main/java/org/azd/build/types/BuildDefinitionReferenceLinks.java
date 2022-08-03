package org.azd.build.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;
import org.azd.common.types.Reference;

/***
 * The class to represent a collection of REST reference links.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class BuildDefinitionReferenceLinks extends BaseAbstractMethod {
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
