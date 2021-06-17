package org.azd.release.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.Reference;
import org.azd.common.ReferenceLink;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ReleaseReferenceLinks extends ReferenceLink {
    @JsonProperty("web")
    private Reference web;

    public Reference getWeb() {
        return web;
    }

    public void setWeb(Reference web) {
        this.web = web;
    }

    @Override
    public String toString() {
        return "ReleaseReferenceLinks{" +
                "web=" + web +
                '}';
    }
}
