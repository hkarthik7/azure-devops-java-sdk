package org.azd.build.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/***
 * List of build definition revisions
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class BuildDefinitionRevisions {
    /***
     * List of build revisions
     */
    @JsonProperty("value")
    private List<BuildDefinitionRevision> buildDefinitionRevisions;

    public List<BuildDefinitionRevision> getBuildDefinitionRevision() {
        return buildDefinitionRevisions;
    }

    public void setBuildDefinitionRevision(List<BuildDefinitionRevision> value) {
        this.buildDefinitionRevisions = value;
    }

    @Override
    public String toString() {
        return "BuildDefinitionRevisions{" +
                "value=" + buildDefinitionRevisions +
                '}';
    }
}
