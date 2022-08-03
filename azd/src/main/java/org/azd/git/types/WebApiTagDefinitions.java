package org.azd.git.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

import java.util.List;

/***
 * List of tag definitions
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WebApiTagDefinitions extends BaseAbstractMethod {
    /***
     * List of tag definitions
     */
    @JsonProperty("value")
    private List<WebApiTagDefinition> value;


    public List<WebApiTagDefinition> getValue() {
        return value;
    }

    public void setValue(List<WebApiTagDefinition> value) {
        this.value = value;
    }
}
