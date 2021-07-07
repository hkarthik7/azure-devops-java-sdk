package org.azd.git.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GitDeletedRepositories {
    @JsonProperty("value")
    private List<GitDeletedRepository> gitDeletedRepositories;

    public List<GitDeletedRepository> getGitDeletedRepositories() {
        return gitDeletedRepositories;
    }

    public void setGitDeletedRepositories(List<GitDeletedRepository> gitDeletedRepositories) {
        this.gitDeletedRepositories = gitDeletedRepositories;
    }

    @Override
    public String toString() {
        return "GitDeletedRepositories{" +
                "gitDeletedRepositories=" + gitDeletedRepositories +
                '}';
    }
}
