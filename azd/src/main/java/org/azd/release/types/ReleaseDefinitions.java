package org.azd.release.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

import java.util.List;

/***
 * List of release definition
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReleaseDefinitions extends BaseAbstractMethod {
    /***
     * List of release definition
     */
    @JsonProperty("value")
    private List<ReleaseDefinition> ReleaseDefinitions;

    public List<ReleaseDefinition> getReleaseDefinitions() {
        return ReleaseDefinitions;
    }

    public void setReleaseDefinitions(List<ReleaseDefinition> releaseDefinitions) {
        ReleaseDefinitions = releaseDefinitions;
    }

}
