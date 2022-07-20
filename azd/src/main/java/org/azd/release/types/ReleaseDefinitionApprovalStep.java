package org.azd.release.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.Author;

/***
 * Gets or sets the approvals.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReleaseDefinitionApprovalStep {
    /***
     * Gets and sets the approver.
     */
    @JsonProperty("approver")
    private Author approver;
    /***
     * ID of the approval or deploy step.
     */
    @JsonProperty("id")
    private int id;
    /***
     * Indicates whether the approval automated.
     */
    @JsonProperty("isAutomated")
    private boolean isAutomated;
    /***
     * Indicates whether the approval notification set.
     */
    @JsonProperty("isNotificationOn")
    private boolean isNotificationOn;
    /***
     * Gets or sets the rank of approval step.
     */
    @JsonProperty("rank")
    private int rank;

    public Author getApprover() {
        return approver;
    }

    public void setApprover(Author approver) {
        this.approver = approver;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isAutomated() {
        return isAutomated;
    }

    public void setAutomated(boolean automated) {
        isAutomated = automated;
    }

    public boolean isNotificationOn() {
        return isNotificationOn;
    }

    public void setNotificationOn(boolean notificationOn) {
        isNotificationOn = notificationOn;
    }

    public int isRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "ReleaseDefinitionApprovalStep{" +
                "approver=" + approver +
                ", id=" + id +
                ", isAutomated=" + isAutomated +
                ", isNotificationOn=" + isNotificationOn +
                ", rank=" + rank +
                '}';
    }
}
