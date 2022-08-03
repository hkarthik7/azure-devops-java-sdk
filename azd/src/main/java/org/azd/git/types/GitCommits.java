package org.azd.git.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GitCommits extends BaseAbstractMethod {
    @JsonProperty("value")
    private List<GitCommit> commits;

    public List<GitCommit> getCommits() {
        return commits;
    }

    public void setCommits(List<GitCommit> value) {
        this.commits = value;
    }

}
