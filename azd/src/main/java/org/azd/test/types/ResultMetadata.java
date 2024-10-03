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
 * ResultMetadata for the given outcome/count.
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResultMetadata extends SerializableEntity {
    /**
     * Flaky metadata
     **/
    @JsonProperty("flaky")
    private String flaky;
    /**
     * Rerun metadata
     **/
    @JsonProperty("rerun")
    private String rerun;

    public String getFlaky() {
        return flaky;
    }

    public void setFlaky(String flaky) {
        this.flaky = flaky;
    }

    public String getRerun() {
        return rerun;
    }

    public void setRerun(String rerun) {
        this.rerun = rerun;
    }

}