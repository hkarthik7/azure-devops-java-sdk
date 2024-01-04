package org.azd.test.types;
/*
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
*/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;
import org.azd.enums.ResultMetadata;

/**
 * An abstracted reference to some other resource. This class is used to provide the build data contracts with a uniform way to reference other resources in a way that provides easy traversal through links.
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class RunStatistic extends SerializableEntity {
    /**
     * Test result count fo the given outcome.
     **/
    @JsonProperty("count")
    private Integer count;
    /**
     * Test result outcome
     **/
    @JsonProperty("outcome")
    private String outcome;
    /**
     * Test run Resolution State.
     **/
    @JsonProperty("resolutionState")
    private TestResolutionState resolutionState;
    /**
     * ResultMetadata for the given outcome/count.
     **/
    @JsonProperty("resultMetadata")
    private ResultMetadata resultMetadata;
    /**
     * State of the test run
     **/
    @JsonProperty("state")
    private String state;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getOutcome() {
        return outcome;
    }

    public void setOutcome(String outcome) {
        this.outcome = outcome;
    }

    public TestResolutionState getResolutionState() {
        return resolutionState;
    }

    public void setResolutionState(TestResolutionState resolutionState) {
        this.resolutionState = resolutionState;
    }

    public ResultMetadata getResultMetadata() {
        return resultMetadata;
    }

    public void setResultMetadata(ResultMetadata resultMetadata) {
        this.resultMetadata = resultMetadata;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

}