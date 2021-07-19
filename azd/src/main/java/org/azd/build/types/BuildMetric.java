package org.azd.build.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/***
 * Represents metadata about builds in the system.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class BuildMetric {
    /***
     * The date for the scope.
     */
    @JsonProperty("date")
    private String date;
    /***
     * The value.
     */
    @JsonProperty("intValue")
    private int intValue;
    /***
     * The name of the metric.
     */
    @JsonProperty("name")
    private String name;
    /***
     * The scope.
     */
    @JsonProperty("scope")
    private String scope;

    @Override
    public String toString() {
        return "BuildMetric{" +
                "date='" + date + '\'' +
                ", intValue=" + intValue +
                ", name='" + name + '\'' +
                ", scope='" + scope + '\'' +
                '}';
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getIntValue() {
        return intValue;
    }

    public void setIntValue(int intValue) {
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
