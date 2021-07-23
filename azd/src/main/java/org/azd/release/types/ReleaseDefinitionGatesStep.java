package org.azd.release.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/***
 * Post deployment gates snapshot data.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReleaseDefinitionGatesStep {
    /***
     * Gets or sets the gates.
     */
    @JsonProperty("gates")
    private List<ReleaseDefinitionGate> gates;
    /***
     * Gets or sets the gate options.
     */
    @JsonProperty("gatesOptions")
    private ReleaseDefinitionGatesOptions gatesOptions;
    /***
     * ID of the ReleaseDefinitionGateStep.
     */
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
