package org.azd.maven.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;

/**
 * Describes upstreaming behavior for a given feed/protocol/package
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpstreamingBehavior extends SerializableEntity {

    /**
     * Indicates whether external upstream versions should be considered for this
     * package
     */
    @JsonProperty("versionsFromExternalUpstreams")
    private String versionsFromExternalUpstreams;

    public String getVersionsFromExternalUpstreams() {
        return versionsFromExternalUpstreams;
    }

    public void setVersionsFromExternalUpstreams(String versionsFromExternalUpstreams) {
        this.versionsFromExternalUpstreams = versionsFromExternalUpstreams;
    }

}
