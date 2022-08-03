package org.azd.core.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

import java.util.List;

/***
 * Represents list of team
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Teams extends BaseAbstractMethod {
    /***
     * List of team
     */
    @JsonProperty("value")
    private List<Team> value;

    public List<Team> getTeams() {
        return value;
    }

    public void setTeams(List<Team> value) {
        this.value = value;
    }

}
