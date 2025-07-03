package org.azd.git.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;

import java.util.List;

public class GitPullRequestIterations extends SerializableEntity {

    @JsonProperty("value")
    private List<GitPullRequestIteration> iterations;

    public List<GitPullRequestIteration> getIterations() {
        return iterations;
    }

    public void setIterations(List<GitPullRequestIteration> iterations) {
        this.iterations = iterations;
    }
}
