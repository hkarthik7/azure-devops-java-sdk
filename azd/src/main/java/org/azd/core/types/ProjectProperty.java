package org.azd.core.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

/***
 * A named value associated with a project.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProjectProperty extends BaseAbstractMethod {
    /***
     * The name of the property.
     */
    @JsonProperty("name")
    private String name;
    /***
     * The value of the property.
     */
    @JsonProperty("value")
    private Object value;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
