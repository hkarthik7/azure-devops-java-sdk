package org.azd.build.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

import java.util.List;

/***
 * Represents a phase
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Phases extends BaseAbstractMethod {
    /***
     * List of steps
     */
    @JsonProperty("steps")
    private List<Steps> steps;
    /***
     * Name of the task
     */
    @JsonProperty("name")
    private String name;
    /***
     * Task reference name
     */
    @JsonProperty("refName")
    private String refName;
    /***
     * Job authorization scope
     */
    @JsonProperty("jobAuthorizationScope")
    private String jobAuthorizationScope;
    /***
     * Steps condition
     */
    @JsonProperty("condition")
    private String condition;
    /**
     * Specifies the execution object and task details
     */
    @JsonProperty("target")
    private Object target;

    public List<Steps> getSteps() {
        return steps;
    }

    public void setSteps(List<Steps> steps) {
        this.steps = steps;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRefName() {
        return refName;
    }

    public void setRefName(String refName) {
        this.refName = refName;
    }

    public String getJobAuthorizationScope() {
        return jobAuthorizationScope;
    }

    public void setJobAuthorizationScope(String jobAuthorizationScope) {
        this.jobAuthorizationScope = jobAuthorizationScope;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

}
