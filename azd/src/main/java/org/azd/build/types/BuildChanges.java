package org.azd.build.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BuildChanges {
    @JsonProperty("value")
    private List<BuildChange> value;

    @Override
    public String toString() {
        return "Changes{" +
                "value=" + value +
                '}';
    }

    public List<BuildChange> getBuildChanges() {
        return value;
    }

    public void setBuildChanges(List<BuildChange> value) {
        this.value = value;
    }
}
