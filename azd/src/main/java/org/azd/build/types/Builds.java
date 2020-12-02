package org.azd.build.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Builds {
    @JsonProperty("value")
    private List<BuildT> value;

    public List<BuildT> getBuildResults() {
        return value;
    }

    public void setBuildResults(List<BuildT> value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Builds{" +
                "value=" + value +
                '}';
    }
}
