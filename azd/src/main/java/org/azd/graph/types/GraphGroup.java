package org.azd.graph.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.exceptions.AzDException;
import org.azd.helpers.JsonMapper;

/***
 * Graph group entity
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GraphGroup extends GraphEntity {
    /***A short phrase to help human readers disambiguate groups with similar names
     *
     */
    @JsonProperty("description")
    private String description;
    /***
     * The legacy descriptor is here in case you need to access old version IMS using identity descriptor.
     */
    @JsonProperty("legacyDescriptor")
    private String legacyDescriptor;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLegacyDescriptor() {
        return legacyDescriptor;
    }

    public void setLegacyDescriptor(String legacyDescriptor) {
        this.legacyDescriptor = legacyDescriptor;
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
