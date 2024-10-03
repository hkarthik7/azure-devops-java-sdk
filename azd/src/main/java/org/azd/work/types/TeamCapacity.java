package org.azd.work.types;
/*
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
*/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;

import java.util.List;

/**
 * None
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class TeamCapacity extends SerializableEntity {
    /**
     * Represents capacity for a specific team member
     **/
    @JsonProperty("teamMembers")
    private List<TeamMemberCapacityIdentityRef> teamMembers;

    @JsonProperty("totalCapacityPerDay")
    private int totalCapacityPerDay;

    @JsonProperty("totalDaysOff")
    private int totalDaysOff;

    public List<TeamMemberCapacityIdentityRef> getTeamMembers() {
        return teamMembers;
    }

    public void setTeamMembers(List<TeamMemberCapacityIdentityRef> teamMembers) {
        this.teamMembers = teamMembers;
    }

    public int getTotalCapacityPerDay() {
        return totalCapacityPerDay;
    }

    public void setTotalCapacityPerDay(int totalCapacityPerDay) {
        this.totalCapacityPerDay = totalCapacityPerDay;
    }

    public int getTotalDaysOff() {
        return totalDaysOff;
    }

    public void setTotalDaysOff(int totalDaysOff) {
        this.totalDaysOff = totalDaysOff;
    }

}