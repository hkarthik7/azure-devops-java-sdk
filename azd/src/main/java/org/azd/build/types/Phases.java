package org.azd.build.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Phases {
    @JsonProperty("steps")
    private List<Steps> steps;

    public List<Steps> getSteps() {
        return steps;
    }

    public void setSteps(List<Steps> steps) {
        this.steps = steps;
    }

    @Override
    public String toString() {
        return "Phases{" +
                "steps=" + steps +
                '}';
    }
}
