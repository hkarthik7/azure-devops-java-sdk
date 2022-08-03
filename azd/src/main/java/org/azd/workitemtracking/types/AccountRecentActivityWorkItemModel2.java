package org.azd.workitemtracking.types;
/**
 * ----------------------------------------------------------
 * GENERATED FILE, should be edited to suit the purpose.
 * ----------------------------------------------------------
 **/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.Author;
import org.azd.common.types.BaseAbstractMethod;

/**
 * Represents Work Item Recent Activity 
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class AccountRecentActivityWorkItemModel2 extends BaseAbstractMethod {
    /**
     * Date of the last Activity by the user
     **/
    @JsonProperty("activityDate")
    private String activityDate;
    /**
     * Type of the activity
     **/
    @JsonProperty("activityType")
    private String activityType;
    /**
     * Assigned To
     **/
    @JsonProperty("assignedTo")
    private Author assignedTo;
    /**
     * Last changed date of the work item
     **/
    @JsonProperty("changedDate")
    private String changedDate;
    /**
     * Work Item Id
     **/
    @JsonProperty("id")
    private Integer id;
    /**
     * TeamFoundationId of the user this activity belongs to
     **/
    @JsonProperty("identityId")
    private String identityId;
    /**
     * State of the work item
     **/
    @JsonProperty("state")
    private String state;
    /**
     * Team project the work item belongs to
     **/
    @JsonProperty("teamProject")
    private String teamProject;
    /**
     * Title of the work item
     **/
    @JsonProperty("title")
    private String title;
    /**
     * Type of Work Item
     **/
    @JsonProperty("workItemType")
    private String workItemType;

    public String getActivityDate() {
        return activityDate;
    }

    public void setActivityDate(String activityDate) {
        this.activityDate = activityDate;
    }

    public String getActivityType() {
        return activityType;
    }

    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }

    public Author getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(Author assignedTo) {
        this.assignedTo = assignedTo;
    }

    public String getChangedDate() {
        return changedDate;
    }

    public void setChangedDate(String changedDate) {
        this.changedDate = changedDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdentityId() {
        return identityId;
    }

    public void setIdentityId(String identityId) {
        this.identityId = identityId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getTeamProject() {
        return teamProject;
    }

    public void setTeamProject(String teamProject) {
        this.teamProject = teamProject;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWorkItemType() {
        return workItemType;
    }

    public void setWorkItemType(String workItemType) {
        this.workItemType = workItemType;
    }

}
