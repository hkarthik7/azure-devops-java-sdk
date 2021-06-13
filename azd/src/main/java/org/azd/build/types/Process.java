package org.azd.build.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Process {
    @JsonProperty("phases")
    private List<Phases> phases;

    public List<Phases> getPhases() {
        return phases;
    }

    public void setPhases(List<Phases> phases) {
        this.phases = phases;
    }

    @Override
    public String toString() {
        return "Process{" +
                "phases=" + phases +
                '}';
    }
}
