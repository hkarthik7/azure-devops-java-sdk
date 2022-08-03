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
 * Represents a reference to a build option definition. 
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class BuildMetric extends BaseAbstractMethod {
    /**
     * The date for the scope.
     **/
    @JsonProperty("date")
    private String date;
    /**
     * The value.
     **/
    @JsonProperty("intValue")
    private Integer intValue;
    /**
     * The name of the metric.
     **/
    @JsonProperty("name")
    private String name;
    /**
     * The scope.
     **/
    @JsonProperty("scope")
    private String scope;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getIntValue() {
        return intValue;
    }

    public void setIntValue(Integer intValue) {
        this.intValue = intValue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

}
