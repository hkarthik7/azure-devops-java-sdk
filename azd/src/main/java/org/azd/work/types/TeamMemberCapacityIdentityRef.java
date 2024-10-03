package org.azd.work.types;
/*
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
*/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;
import org.azd.common.types.Author;

import java.util.List;

/**
 * None
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class TeamMemberCapacityIdentityRef extends SerializableEntity {
    /**
     * Collection of links relevant to resource
     **/
    @JsonProperty("_links")
    private Object _links;
    /**
     * Collection of capacities associated with the team member
     **/
    @JsonProperty("activities")
    private List<Activity> activities;
    /**
     * The days off associated with the team member
     **/
    @JsonProperty("daysOff")
    private List<DateRange> daysOff;
    /**
     * Identity ref of the associated team member
     **/
    @JsonProperty("teamMember")
    private Author teamMember;
    /**
     * Full http link to the resource
     **/
    @JsonProperty("url")
    private String url;

    public Object get_links() {
        return _links;
    }

    public void set_links(Object _links) {
        this._links = _links;
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }

    public List<DateRange> getDaysOff() {
        return daysOff;
    }

    public void setDaysOff(List<DateRange> daysOff) {
        this.daysOff = daysOff;
    }

    public Author getTeamMember() {
        return teamMember;
    }

    public void setTeamMember(Author teamMember) {
        this.teamMember = teamMember;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}