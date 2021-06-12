package org.azd.core.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProjectProperties {
    @JsonProperty("value")
    private List<ProjectProperty> value;

    public List<ProjectProperty> getValue() {
        return value;
    }

    public void setValue(List<ProjectProperty> value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "ProjectProperties{" +
                "value=" + value +
                '}';
    }
}
