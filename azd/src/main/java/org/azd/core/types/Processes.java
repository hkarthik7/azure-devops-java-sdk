package org.azd.core.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Processes {
    @JsonProperty("value")
    private List<Process> value;

    @Override
    public String toString() {
        return "Processes{" +
                "value=" + value +
                '}';
    }

    public List<Process> getProcesses() {
        return value;
    }

    public void setProcesses(List<Process> value) {
        this.value = value;
    }
}
