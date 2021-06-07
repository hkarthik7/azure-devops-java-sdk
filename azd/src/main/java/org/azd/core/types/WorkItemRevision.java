package org.azd.core.types;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WorkItemRevision {

    @JsonProperty("id")
    private String id;
    @JsonProperty("revision")
    private int revision;

}
