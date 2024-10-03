package org.azd.featuremanagement.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableCollectionEntity;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ContributedFeatures extends SerializableCollectionEntity {
    @JsonProperty("value")
    private List<ContributedFeature> features;

    public List<ContributedFeature> getFeatures() {
        return features;
    }

    public void setFeatures(List<ContributedFeature> features) {
        this.features = features;
    }
}
