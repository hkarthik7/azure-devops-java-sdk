package org.azd.release.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/***
 * Gets list of conditions.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReleaseCondition {
    /***
     * Gets or sets the condition type.
     */
    @JsonProperty("conditionType")
    private String conditionType;
    /***
     * Gets or sets the name of the condition. e.g. 'ReleaseStarted'.
     */
    @JsonProperty("name")
    private String name;
    /***
     * The release condition result.
     */
    @JsonProperty("result")
    private String result;
    /***
     * Gets or set value of the condition.
     */
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
