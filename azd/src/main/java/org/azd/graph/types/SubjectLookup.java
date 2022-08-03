package org.azd.graph.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.exceptions.AzDException;
import org.azd.helpers.JsonMapper;

/***
 * Response object from a subject lookup via descriptor
 *
 * This contains information about the object kind (user or group) and origin source (aad, vsts, etc)
 * Not all fields may be populated in the response.
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SubjectLookup extends GraphEntity {
    /***
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
        var mapper = new JsonMapper();

        try {
            res = mapper.convertToString(this);
        } catch (AzDException ignored) { }

        return res;
    }
}
