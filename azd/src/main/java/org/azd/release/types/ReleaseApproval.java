package org.azd.release.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.Author;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ReleaseApproval {
    @JsonProperty("approvalType")
    private String approvalType;
    @JsonProperty("approvedBy")
    private Author approvedBy;
    @JsonProperty("approver")
    private Author approver;
    @JsonProperty("attempt")
    private int attempt;
    @JsonProperty("comments")
    private String comments;
    @JsonProperty("createdOn")
    private String createdOn;
    @JsonProperty("history")
    private List<ReleaseApprovalHistory> history;
    @JsonProperty("id")
    private int id;
    @JsonProperty("isAutomated")
    private boolean isAutomated;
    @JsonProperty("modifiedOn")
    private String modifiedOn;
    @JsonProperty("rank")
    private int rank;
    @JsonProperty("release")
    private ReleaseShallowReference release;
    @JsonProperty("releaseDefinition")
    private ReleaseShallowReference releaseDefinition;
    @JsonProperty("releaseEnvironment")
    private ReleaseShallowReference releaseEnvironment;
    @JsonProperty("revision")
    private int revision;
    @JsonProperty("status")
    private String status;
    @JsonProperty("url")
    private String url;

    public String getApprovalType() {
        return approvalType;
    }

    public void setApprovalType(String approvalType) {
        this.approvalType = approvalType;
    }

    public Author getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(Author approvedBy) {
        this.approvedBy = approvedBy;
    }

    public Author getApprover() {
        return approver;
    }

    public void setApprover(Author approver) {
        this.approver = approver;
    }

    public int getAttempt() {
        return attempt;
    }

    public void setAttempt(int attempt) {
        this.attempt = attempt;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public List<ReleaseApprovalHistory> getHistory() {
        return history;
    }

    public void setHistory(List<ReleaseApprovalHistory> history) {
        this.history = history;
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

    public String getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(String modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public ReleaseShallowReference getRelease() {
        return release;
    }

    public void setRelease(ReleaseShallowReference release) {
        this.release = release;
    }

    public ReleaseShallowReference getReleaseDefinition() {
        return releaseDefinition;
    }

    public void setReleaseDefinition(ReleaseShallowReference releaseDefinition) {
        this.releaseDefinition = releaseDefinition;
    }

    public ReleaseShallowReference getReleaseEnvironment() {
        return releaseEnvironment;
    }

    public void setReleaseEnvironment(ReleaseShallowReference releaseEnvironment) {
        this.releaseEnvironment = releaseEnvironment;
    }

    public int getRevision() {
        return revision;
    }

    public void setRevision(int revision) {
        this.revision = revision;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "ReleaseApproval{" +
                "approvalType='" + approvalType + '\'' +
                ", approvedBy=" + approvedBy +
                ", approver=" + approver +
                ", attempt=" + attempt +
                ", comments='" + comments + '\'' +
                ", createdOn='" + createdOn + '\'' +
                ", history=" + history +
                ", id=" + id +
                ", isAutomated=" + isAutomated +
                ", modifiedOn='" + modifiedOn + '\'' +
                ", rank=" + rank +
                ", release=" + release +
                ", releaseDefinition=" + releaseDefinition +
                ", releaseEnvironment=" + releaseEnvironment +
                ", revision=" + revision +
                ", status='" + status + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
