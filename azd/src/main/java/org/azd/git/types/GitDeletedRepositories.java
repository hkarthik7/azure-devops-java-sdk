package org.azd.git.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableCollectionEntity;

import java.util.List;

/**
 * List of deleted repositories
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GitDeletedRepositories extends SerializableCollectionEntity {
    /**
     * List of deleted repositories
     */
    @JsonProperty("value")
    private List<GitDeletedRepository> gitDeletedRepositories;

    public List<GitDeletedRepository> getGitDeletedRepositories() {
        return gitDeletedRepositories;
    }

    public void setGitDeletedRepositories(List<GitDeletedRepository> gitDeletedRepositories) {
        this.gitDeletedRepositories = gitDeletedRepositories;
    }

}
