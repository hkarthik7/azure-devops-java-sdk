package org.azd.git.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

import java.util.List;

/**
 * Represents an array of Git commit references.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GitCommitRefs extends BaseAbstractMethod {
    /**
     * Contains an array of git commit references.
     */
    @JsonProperty("value")
    private List<GitCommitRef> gitCommitRefs;

    public List<GitCommitRef> getGitCommitRefs() {
        return gitCommitRefs;
    }

    public void setGitCommitRefs(List<GitCommitRef> gitCommitRefs) {
        this.gitCommitRefs = gitCommitRefs;
    }
}
