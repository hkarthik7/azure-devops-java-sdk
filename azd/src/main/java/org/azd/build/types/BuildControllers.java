package org.azd.build.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/***
 * Array of build controller
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class BuildControllers {
    /***
     * Array of build controller
     */
    @JsonProperty("value")
    private List<BuildController> value;

    @Override
    public String toString() {
        return "BuildControllers{" +
                "value=" + value +
                '}';
    }

    public List<BuildController> getValue() {
        return value;
    }

    public void setValue(List<BuildController> value) {
        this.value = value;
    }
}
