package org.azd.release.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.Reference;
import org.azd.common.types.ReferenceLink;

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
