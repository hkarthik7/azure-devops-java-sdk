package org.azd.release.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableCollectionEntity;

import java.util.List;

/**
 * List of manual interventions
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ManualInterventions extends SerializableCollectionEntity {
    @JsonProperty("value")
    private List<ManualIntervention> manualInterventions;


    public List<ManualIntervention> getManualInterventions() {
        return manualInterventions;
    }

    public void setManualInterventions(List<ManualIntervention> manualInterventions) {
        this.manualInterventions = manualInterventions;
    }
}
