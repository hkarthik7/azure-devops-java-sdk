package org.azd.git.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.serializer.SerializableEntity;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GitCommits extends SerializableEntity {
    @JsonProperty("value")
    private List<GitCommit> commits;

    public List<GitCommit> getCommits() {
        return commits;
    }

    public void setCommits(List<GitCommit> value) {
        this.commits = value;
    }

}
