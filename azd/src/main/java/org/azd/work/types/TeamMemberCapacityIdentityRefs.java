package org.azd.work.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableCollectionEntity;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TeamMemberCapacityIdentityRefs extends SerializableCollectionEntity {
    /**
     * Represents a collection of team member capacity identity references.
     */
    @JsonProperty("value")
    private List<TeamMemberCapacityIdentityRef> teamMemberCapacityIdentityRefs;

    public List<TeamMemberCapacityIdentityRef> getTeamMemberCapacityIdentityRefs() {
        return teamMemberCapacityIdentityRefs;
    }

    public void setTeamMemberCapacityIdentityRefs(List<TeamMemberCapacityIdentityRef> teamMemberCapacityIdentityRefs) {
        this.teamMemberCapacityIdentityRefs = teamMemberCapacityIdentityRefs;
    }
}
