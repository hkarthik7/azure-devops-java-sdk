package org.azd.graph.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SubjectLookupResponse {
    @JsonProperty("value")
    Map<String, SubjectLookup> value;

    public Map<String, SubjectLookup> getValue() {
        return value;
    }

    public void setValue(Map<String, SubjectLookup> value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "SubjectLookupResponse{" +
                "value=" + value +
                '}';
    }
}
