package org.azd.build.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

import java.util.List;

/***
 * Represents a build process.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Process extends BaseAbstractMethod {
    /***
     * List of build phase
     */
    @JsonProperty("phases")
    private List<Phases> phases;

    public List<Phases> getPhases() {
        return phases;
    }

    public void setPhases(List<Phases> phases) {
        this.phases = phases;
    }

}
