package org.azd.build.types;
/**
 * ----------------------------------------------------------
 * GENERATED FILE, should be edited to suit the purpose.
 * ----------------------------------------------------------
 **/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Project visibility. 
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class Demand {
    /**
     * The name of the capability referenced by the demand.
     **/
    @JsonProperty("name")
    private String name;
    /**
     * The demanded value.
     **/
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