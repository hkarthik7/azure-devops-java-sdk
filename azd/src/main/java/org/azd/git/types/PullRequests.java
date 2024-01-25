package org.azd.git.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableCollectionEntity;

import java.util.List;

/**
 * Represents a list of pull request
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PullRequests extends SerializableCollectionEntity {
    /**
     * Represents a list of pull request
     */
    @JsonProperty("value")
    private List<GitPullRequest> value;


    public List<GitPullRequest> getPullRequests() {
        return value;
    }

    public void setPullRequests(List<GitPullRequest> value) {
        this.value = value;
    }

}
