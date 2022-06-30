package org.azd.git.types;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/***
 * //Describes a set of Git Ref operations
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GitRefUpdateResults {

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
