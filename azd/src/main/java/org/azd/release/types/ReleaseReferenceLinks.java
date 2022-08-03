package org.azd.release.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.Reference;
import org.azd.common.types.ReferenceLink;

/***
 * Gets links to access the release.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReleaseReferenceLinks extends ReferenceLink {
    /***
     * Release web reference link
     */
    @JsonProperty("web")
    private Reference web;

    public Reference getWeb() {
        return web;
    }

    public void setWeb(Reference web) {
        this.web = web;
    }

}
