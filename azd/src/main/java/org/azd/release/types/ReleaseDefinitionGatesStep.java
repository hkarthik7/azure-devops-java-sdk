package org.azd.release.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ReleaseDefinitionGatesStep {
    @JsonProperty("gates")
    private List<ReleaseDefinitionGate> gates;
    @JsonProperty("gatesOptions")
    private ReleaseDefinitionGatesOptions gatesOptions;
    @JsonProperty("id")
    private int id;

    public List<ReleaseDefinitionGate> getGates() {
        return gates;
    }

    public void setGates(List<ReleaseDefinitionGate> gates) {
        this.gates = gates;
    }

    public ReleaseDefinitionGatesOptions getGatesOptions() {
        return gatesOptions;
    }

    public void setGatesOptions(ReleaseDefinitionGatesOptions gatesOptions) {
        this.gatesOptions = gatesOptions;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ReleaseDefinitionGatesStep{" +
                "gates=" + gates +
                ", gatesOptions=" + gatesOptions +
                ", id=" + id +
                '}';
    }
}
