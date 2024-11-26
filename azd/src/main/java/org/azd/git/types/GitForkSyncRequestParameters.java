package org.azd.git.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Represents the request body for Git create fork sync request Api.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GitForkSyncRequestParameters {
    /**
     * Fully-qualified identifier for the source repository.
     */
    @JsonProperty("source")
    public GlobalGitRepositoryKey source;
    /**
     * If supplied, the set of ref mappings to use when performing a "sync" or create. If missing, all refs will be synchronized.
     */
    @JsonProperty("sourceToTargetRefs")
    public List<SourceToTargetRef> sourceToTargetRefs;
}
