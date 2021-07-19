package org.azd.build.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/***
 * Represents a demand used by a definition or build.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Demand {
    /***
     * The name of the capability referenced by the demand.
     */
    @JsonProperty("name")
    private String name;
    /***
     * The demanded value.
     */
    @JsonProperty("value")
    private String value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Demand{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
