package org.azd.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * PublishContext of the Runs to be queried.
 */
public enum TestRunPublishContext {
    /**
     * Run is published for any Context.
     */
    @JsonProperty("all")
    ALL,

    /**
     * Run is published for Build Context.
     */
    @JsonProperty("build")
    BUILD,

    /**
     * Run is published for Release Context.
     */
    @JsonProperty("release")
    RELEASE

}
