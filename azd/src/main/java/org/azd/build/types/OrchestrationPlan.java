package org.azd.build.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/***
 * Represents a reference to an orchestration plan.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrchestrationPlan {
    /***
     * The ID of the plan.
     */
    @JsonProperty("planId")
    private String planId;

    public String getPlanId() {
        return planId;
    }

    public void setPlanId(String planId) {
        this.planId = planId;
    }

    @Override
    public String toString() {
        return "OrchestrationPlan{" +
                "planId='" + planId + '\'' +
                '}';
    }
}
