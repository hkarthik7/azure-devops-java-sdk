package org.azd.core.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

import java.util.List;

/***
 * Array of project properties
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProjectProperties extends BaseAbstractMethod {
    /***
     * Array of project properties
     */
    @JsonProperty("value")
    private List<ProjectProperty> value;

    public List<ProjectProperty> getValue() {
        return value;
    }

    public void setValue(List<ProjectProperty> value) {
        this.value = value;
    }

}
