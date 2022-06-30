package org.azd.git.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GitRefs {
    @JsonProperty("value")
    private List<GitRef> refs;

    public List<GitRef> getRefs() {
        return refs;
    }

    public void setRefs(List<GitRef> value) {
        this.refs = value;
    }

    @Override
    public String toString() {
        return "GitRefs{" +
                "refs=" + refs +
                '}';
    }
}
