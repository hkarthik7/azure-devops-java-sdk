package org.azd.git.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GitCommitChanges {
    @JsonProperty("changeCounts")
    private JsonNode changeCounts;
    @JsonProperty("changes")
    private List<GitChange> changes;

    public JsonNode getChangeCounts() {
        return changeCounts;
    }

    public void setChangeCounts(JsonNode changeCounts) {
        this.changeCounts = changeCounts;
    }

    public List<GitChange> getChanges() {
        return changes;
    }

    public void setChanges(List<GitChange> changes) {
        this.changes = changes;
    }

    @Override
    public String toString() {
        return "GitCommitChanges{" +
                "changeCounts=" + changeCounts +
                ", changes=" + changes +
                '}';
    }
}
