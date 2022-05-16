package org.azd.maven.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/***
 * Describes upstreaming behavior for a given feed/protocol/package
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpstreamingBehavior {

    /***
     * Indicates whether external upstream versions should be considered for this
     * package
     */
    @JsonProperty("versionsFromExternalUpstreams")
    private UpstreamVersionVisibility versionsFromExternalUpstreams;

    @Override
    public String toString() {
        return "UpstreamingBehavior{" +
                "UpstreamVersionVisibility='" + versionsFromExternalUpstreams +
                '}';
    }
}
