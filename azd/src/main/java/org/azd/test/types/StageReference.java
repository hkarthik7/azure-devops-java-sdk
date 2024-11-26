package org.azd.test.types;
/*
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
*/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;

/**
 * Test environment Detail.
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class StageReference extends SerializableEntity {
    /**
     * Attempt number of stage
     **/
    @JsonProperty("attempt")
    private Integer attempt;
    /**
     * Name of the stage. Maximum supported length for name is 256 character.
     **/
    @JsonProperty("stageName")
    private String stageName;

    public Integer getAttempt() {
        return attempt;
    }

    public void setAttempt(Integer attempt) {
        this.attempt = attempt;
    }

    public String getStageName() {
        return stageName;
    }

    public void setStageName(String stageName) {
        this.stageName = stageName;
    }

}