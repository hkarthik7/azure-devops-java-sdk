package org.azd.policy.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableCollectionEntity;

import java.util.List;

/**
 * Collection of PolicyEvaluationRecord
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PolicyEvaluationRecords extends SerializableCollectionEntity {
    /**
     * Collection of PolicyEvaluationRecord
     */
    @JsonProperty("value")
    private List<PolicyEvaluationRecord> records;

    public List<PolicyEvaluationRecord> getRecords() {
        return records;
    }

    public void setRecords(List<PolicyEvaluationRecord> records) {
        this.records = records;
    }
}
