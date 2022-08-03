package org.azd.build.types;
/**
 * ----------------------------------------------------------
 * GENERATED FILE, should be edited to suit the purpose.
 * ----------------------------------------------------------
 **/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

/**
 * None 
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class TaskOrchestrationPlanReference extends BaseAbstractMethod {
    /**
     * The type of the plan.
     **/
    @JsonProperty("orchestrationType")
    private Integer orchestrationType;
    /**
     * The ID of the plan.
     **/
    @JsonProperty("planId")
    private String planId;

    public Integer getOrchestrationType() {
        return orchestrationType;
    }

    public void setOrchestrationType(Integer orchestrationType) {
        this.orchestrationType = orchestrationType;
    }

    public String getPlanId() {
        return planId;
    }

    public void setPlanId(String planId) {
        this.planId = planId;
    }

}
