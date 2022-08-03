package org.azd.build.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

import java.util.List;

/***
 * Array of build controller
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class BuildControllers extends BaseAbstractMethod {
    /***
     * Array of build controller
     */
    @JsonProperty("value")
    private List<BuildController> value;


    public List<BuildController> getValue() {
        return value;
    }

    public void setValue(List<BuildController> value) {
        this.value = value;
    }
}
