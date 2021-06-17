package org.azd.release.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ReleaseCondition {
    @JsonProperty("conditionType")
    private String conditionType;
    @JsonProperty("name")
    private String name;
    @JsonProperty("result")
    private String result;
    @JsonProperty("value")
    private String value;

    public String getConditionType() {
        return conditionType;
    }

    public void setConditionType(String conditionType) {
        this.conditionType = conditionType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "ReleaseCondition{" +
                "conditionType='" + conditionType + '\'' +
                ", name='" + name + '\'' +
                ", result='" + result + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
