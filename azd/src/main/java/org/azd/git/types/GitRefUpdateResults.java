package org.azd.git.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.serializer.SerializableEntity;

import java.util.List;

/***
 * Result of a git reference update list.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GitRefUpdateResults extends SerializableEntity {
    @JsonProperty("value")
    private List<GitRefUpdateResult> gitRefUpdateResults;

    public List<GitRefUpdateResult> getGitRefUpdateResults() {
        return gitRefUpdateResults;
    }

    public void setSubscriptions(List<GitRefUpdateResult> gitRefUpdateResults) {
        this.gitRefUpdateResults = gitRefUpdateResults;
    }

    @Override
    public String toString() {
        return "GitRefUpdateResults{" +
                "gitRefUpdateResults=" + gitRefUpdateResults +
                '}';
    }
}
