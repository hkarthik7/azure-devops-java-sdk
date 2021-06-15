package org.azd.build.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Builds {
    @JsonProperty("value")
    private List<Build> builds;

    public List<Build> getBuildResults() {
        return builds;
    }

    public void setBuildResults(List<Build> value) {
        this.builds = value;
    }

    @Override
    public String toString() {
        return "Builds{" +
                "value=" + builds +
                '}';
    }
}
