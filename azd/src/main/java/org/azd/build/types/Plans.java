package org.azd.build.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;

/***
 * Represents a plan
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Plans extends SerializableEntity {
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

}
