package org.azd.release.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.Author;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ReleaseDefinitionApprovalStep {
    @JsonProperty("approver")
    private Author approver;
    @JsonProperty("id")
    private int id;
    @JsonProperty("isAutomated")
    private boolean isAutomated;
    @JsonProperty("isNotificationOn")
    private boolean isNotificationOn;
    @JsonProperty("rank")
    private boolean rank;

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

    public boolean isRank() {
        return rank;
    }

    public void setRank(boolean rank) {
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
