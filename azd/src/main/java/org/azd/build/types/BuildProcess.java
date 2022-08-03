package org.azd.build.types;
/**
 * ----------------------------------------------------------
 * GENERATED FILE, should be edited to suit the purpose.
 * ----------------------------------------------------------
 **/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

import java.util.List;

/**
 * Represents a repository used by a build definition. 
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class BuildProcess extends BaseAbstractMethod {
    /**
     * An array of phases which included the steps/tasks of a definition.
     */
    @JsonProperty("phases")
    private List<Phases> phases;
    /**
     * Specified the agent that the definition is configured for.
     */
    @JsonProperty("target")
    private Object target;
    /**
     * The type of the process.
     **/
    @JsonProperty("type")
    private Integer type;

    public List<Phases> getPhases() {
        return phases;
    }

    public void setPhases(List<Phases> phases) {
        this.phases = phases;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

}
