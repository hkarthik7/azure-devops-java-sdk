package org.azd.work.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

import java.util.List;

/***
 * List of team settings iterations
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TeamSettingsIterations extends BaseAbstractMethod {
    /***
     * List of team settings iterations
     */
    @JsonProperty("value")
    private List<TeamSettingsIteration> iterations;

    public List<TeamSettingsIteration> getIterations() {
        return iterations;
    }

    public void setIterations(List<TeamSettingsIteration> iterations) {
        this.iterations = iterations;
    }

}
