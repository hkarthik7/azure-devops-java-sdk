package org.azd.git.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LastMergeTargetCommit {
    @JsonProperty("commitId")
    private String commitId;
    @JsonProperty("url")
    private String url;

    public String getCommitId() {
        return commitId;
    }

    public void setCommitId(String commitId) {
        this.commitId = commitId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "LastMergeSourceCommit{" +
                "commitId='" + commitId + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
