package org.azd.git.types;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum IterationReason {
    @JsonProperty("create")
    CREATE,

    @JsonProperty("forcePush")
    FORCE_PUSH,

    @JsonProperty("push")
    PUSH,

    @JsonProperty("rebase")
    REBASE,

    @JsonProperty("resolveConflicts")
    RESOLVE_CONFLICTS,

    @JsonProperty("retarget")
    RETARGET,

    @JsonProperty("unkown")
    UNKNOWN;
}
