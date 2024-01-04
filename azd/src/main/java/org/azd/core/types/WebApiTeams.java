package org.azd.core.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableCollectionEntity;

import java.util.List;

/***
 * Represents list of team
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WebApiTeams extends SerializableCollectionEntity {
    /***
     * List of team
     */
    @JsonProperty("value")
    private List<WebApiTeam> value;

    public List<WebApiTeam> getTeams() {
        return value;
    }

    public void setTeams(List<WebApiTeam> value) {
        this.value = value;
    }
}
