package org.azd.enums;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Source of the test session
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public enum TestSessionSource {
    /**
     * The session was created from feedback client.
     */
    @JsonProperty("feedbackDesktop")
    FEEDBACK_DESKTOP,

    /**
     * The session was created from browser extension.
     */
    @JsonProperty("feedbackWeb")
    FEEDBACK_WEB,

    /**
     * To show sessions from all supported sources.
     */
    @JsonProperty("sessionInsightsForAll")
    SESSION_IN_SIGHTS_FOR_ALL,

    /**
     * Source of test session uncertain as it is stale
     */
    @JsonProperty("unknown")
    UNKNOWN,

    /**
     * The session was created from Microsoft Test Manager exploratory desktop tool.
     */
    @JsonProperty("xtDesktop")
    XT_DESKTOP,

    /**
     * The session was created from web access using Microsoft Test Manager exploratory desktop tool.
     */
    @JsonProperty("xtDesktop2")
    XT_DESKTOP2,

    /**
     * The session was created from browser extension.
     */
    @JsonProperty("xtWeb")
    XT_WEB,
}
