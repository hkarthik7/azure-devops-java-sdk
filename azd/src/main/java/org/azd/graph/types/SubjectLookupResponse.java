package org.azd.graph.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;

import java.util.Map;

/**
 * wrapper container for subjectLookup response
 * <p>
 * Subject descriptor is in both the value-field map-key and descriptor field of the {@link SubjectLookup}
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SubjectLookupResponse extends SerializableEntity {
    @JsonProperty("value")
    Map<String, SubjectLookup> value;

    public Map<String, SubjectLookup> getValue() {
        return value;
    }

    public void setValue(Map<String, SubjectLookup> value) {
        this.value = value;
    }

}
