package org.azd.distributedtask.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EnvironmentInstances {
    @JsonProperty("value")
    private List<EnvironmentInstance> environmentInstances;

    public List<EnvironmentInstance> getEnvironmentInstances() {
        return environmentInstances;
    }

    public void setEnvironmentInstances(List<EnvironmentInstance> environmentInstances) {
        this.environmentInstances = environmentInstances;
    }

    @Override
    public String toString() {
        return "EnvironmentInstances{" +
                "environmentInstances=" + environmentInstances +
                '}';
    }
}
