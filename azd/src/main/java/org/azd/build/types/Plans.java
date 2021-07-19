package org.azd.build.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/***
 * Represents a plan
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Plans {
    /***
     * Plan id
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
        return "Plans{" +
                "planId='" + planId + '\'' +
                '}';
    }
}
