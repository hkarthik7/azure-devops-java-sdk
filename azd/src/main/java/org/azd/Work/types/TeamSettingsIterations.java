package org.azd.Work.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TeamSettingsIterations {
    @JsonProperty("value")
    private List<TeamSettingsIteration> iterations;

    public List<TeamSettingsIteration> getIterations() {
        return iterations;
    }

    public void setIterations(List<TeamSettingsIteration> iterations) {
        this.iterations = iterations;
    }

    @Override
    public String toString() {
        return "TeamSettingsIterations{" +
                "iterations=" + iterations +
                '}';
    }
}
