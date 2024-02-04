package org.azd.graph.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.InstanceFactory;
import org.azd.exceptions.AzDException;

/**
 * Response object from a subject lookup via descriptor
 * <p>
 * This contains information about the object kind (user or group) and origin source (aad, vsts, etc)
 * Not all fields may be populated in the response.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SubjectLookup extends GraphEntity {
    /**
     * verbose description of the subject
     */
    @JsonProperty("description")
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        String res = null;
        var serializer = InstanceFactory.createSerializerContext();

        try {
            res = serializer.serialize(this);
        } catch (AzDException ignored) {
        }

        return res;
    }
}
