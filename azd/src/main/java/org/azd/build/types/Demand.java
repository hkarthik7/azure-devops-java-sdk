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
 * Project visibility. 
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class Demand extends BaseAbstractMethod {
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

}
