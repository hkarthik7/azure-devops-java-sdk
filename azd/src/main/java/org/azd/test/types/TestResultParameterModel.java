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
 * Test parameter information in a test iteration.
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class TestResultParameterModel extends SerializableEntity {

    /**
     * Test step path where the parameter is referenced.
     **/
    @JsonProperty("actionPath")
    private String actionPath;

    /**
     * Iteration ID associated with the parameter.
     **/
    @JsonProperty("iterationId")
    private Integer iterationId;

    /**
     * Name of the parameter.
     **/
    @JsonProperty("parameterName")
    private String parameterName;

    /**
     * Step ID of the test case.
     * For shared steps, it is the shared step ID in the test case workitem.
     **/
    @JsonProperty("stepIdentifier")
    private String stepIdentifier;

    /**
     * URL of the test parameter.
     * Deprecated in hosted environment.
     **/
    @JsonProperty("url")
    private String url;

    /**
     * Value of the parameter.
     **/
    @JsonProperty("value")
    private String value;

    public String getActionPath() {
        return actionPath;
    }

    public void setActionPath(String actionPath) {
        this.actionPath = actionPath;
    }

    public Integer getIterationId() {
        return iterationId;
    }

    public void setIterationId(Integer iterationId) {
        this.iterationId = iterationId;
    }

    public String getParameterName() {
        return parameterName;
    }

    public void setParameterName(String parameterName) {
        this.parameterName = parameterName;
    }

    public String getStepIdentifier() {
        return stepIdentifier;
    }

    public void setStepIdentifier(String stepIdentifier) {
        this.stepIdentifier = stepIdentifier;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
