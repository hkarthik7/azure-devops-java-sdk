package org.azd.build.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

import java.util.List;

/***
 * An array of Build changes
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class BuildChanges extends BaseAbstractMethod {
    /***
     * Represents an array of build changes
     */
    @JsonProperty("value")
    private List<BuildChange> value;


    public List<BuildChange> getBuildChanges() {
        return value;
    }

    public void setBuildChanges(List<BuildChange> value) {
        this.value = value;
    }
}
