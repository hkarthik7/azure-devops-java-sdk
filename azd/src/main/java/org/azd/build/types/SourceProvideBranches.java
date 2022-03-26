package org.azd.build.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SourceProvideBranches {
    @JsonProperty("value")
    private List<String> branches;

    public List<String> getBranches() {
        return branches;
    }

    public void setBranches(List<String> branches) {
        this.branches = branches;
    }

    @Override
    public String toString() {
        return "SourceProvideBranches{" +
                "branches=" + branches +
                '}';
    }
}
