package org.azd.release.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.serializer.SerializableEntity;

import java.util.List;

/***
 * Release definition revisions
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReleaseDefinitionRevisions extends SerializableEntity {
    /***
     * List of release definition revision
     */
    @JsonProperty("value")
    private List<ReleaseDefinitionRevision> ReleaseDefinitionRevisions;

    public List<ReleaseDefinitionRevision> getReleaseDefinitionRevisions() {
        return ReleaseDefinitionRevisions;
    }

    public void setReleaseDefinitionRevisions(List<ReleaseDefinitionRevision> releaseDefinitionRevisions) {
        ReleaseDefinitionRevisions = releaseDefinitionRevisions;
    }

}
