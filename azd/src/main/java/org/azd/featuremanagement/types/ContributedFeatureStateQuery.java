package org.azd.featuremanagement.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;
import org.azd.enums.FeatureManagement;

import java.util.List;
import java.util.Map;

/**
 * A query for the effective contributed feature states for a list of feature ids
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ContributedFeatureStateQuery extends SerializableEntity {
    /**
     * The list of feature ids to query
     */
    @JsonProperty("featureIds")
    private List<FeatureManagement> featureIds;
    /**
     * The query result containing the current feature states for each of the queried feature ids
     */
    @JsonProperty("featureStates")
    private Map<String, ContributedFeatureState> featureStates;
    /**
     * A dictionary of scope values (project name, etc.) to use in the query (if querying across scopes)
     */
    @JsonProperty("scopeValues")
    private Map<String, String> scopeValues;

    public List<FeatureManagement> getFeatureIds() {
        return featureIds;
    }

    public void setFeatureIds(List<FeatureManagement> featureIds) {
        this.featureIds = featureIds;
    }

    public Map<String, ContributedFeatureState> getFeatureStates() {
        return featureStates;
    }

    public void setFeatureStates(Map<String, ContributedFeatureState> featureStates) {
        this.featureStates = featureStates;
    }

    public Map<String, String> getScopeValues() {
        return scopeValues;
    }

    public void setScopeValues(Map<String, String> scopeValues) {
        this.scopeValues = scopeValues;
    }
}
