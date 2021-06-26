package org.azd.build.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.Reference;
import org.azd.common.ReferenceLink;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BuildDefinitionReferenceLinks extends ReferenceLink {
    @JsonProperty("web")
    private Reference web;
    @JsonProperty("editor")
    private Reference editor;
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
