package org.azd.release.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.Author;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DeploymentAttempt {
    @JsonProperty("attempt")
    private int attempt;
    @JsonProperty("deploymentId")
    private int deploymentId;
    @JsonProperty("hasStarted")
    private boolean hasStarted;
    @JsonProperty("id")
    private int id;
    @JsonProperty("issues")
    private List<Issues> issues;
    @JsonProperty("lastModifiedBy")
    private Author lastModifiedBy;
    @JsonProperty("lastModifiedOn")
    private String lastModifiedOn;
    @JsonProperty("operationStatus")
    private String operationStatus;
    @JsonProperty("postDeploymentGates")
    private ReleaseGates postDeploymentGates;
    @JsonProperty("preDeploymentGates")
    private ReleaseGates preDeploymentGates;
    @JsonProperty("queuedOn")
    private String queuedOn;
    @JsonProperty("reason")
    private String reason;
    @JsonProperty("releaseDeployPhases")
    private List<ReleaseDeployPhase> releaseDeployPhases;
    @JsonProperty("requestedBy")
    private Author requestedBy;
    @JsonProperty("requestedFor")
    private Author requestedFor;
    @JsonProperty("status")
    private String status;

    public int getAttempt() {
        return attempt;
    }

    public void setAttempt(int attempt) {
        this.attempt = attempt;
    }

    public int getDeploymentId() {
        return deploymentId;
    }

    public void setDeploymentId(int deploymentId) {
        this.deploymentId = deploymentId;
    }

    public boolean isHasStarted() {
        return hasStarted;
    }

    public void setHasStarted(boolean hasStarted) {
        this.hasStarted = hasStarted;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Issues> getIssues() {
        return issues;
    }

    public void setIssues(List<Issues> issues) {
        this.issues = issues;
    }

    public Author getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(Author lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public String getLastModifiedOn() {
        return lastModifiedOn;
    }

    public void setLastModifiedOn(String lastModifiedOn) {
        this.lastModifiedOn = lastModifiedOn;
    }

    public String getOperationStatus() {
        return operationStatus;
    }

    public void setOperationStatus(String operationStatus) {
        this.operationStatus = operationStatus;
    }

    public ReleaseGates getPostDeploymentGates() {
        return postDeploymentGates;
    }

    public void setPostDeploymentGates(ReleaseGates postDeploymentGates) {
        this.postDeploymentGates = postDeploymentGates;
    }

    public ReleaseGates getPreDeploymentGates() {
        return preDeploymentGates;
    }

    public void setPreDeploymentGates(ReleaseGates preDeploymentGates) {
        this.preDeploymentGates = preDeploymentGates;
    }

    public String getQueuedOn() {
        return queuedOn;
    }

    public void setQueuedOn(String queuedOn) {
        this.queuedOn = queuedOn;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public List<ReleaseDeployPhase> getReleaseDeployPhases() {
        return releaseDeployPhases;
    }

    public void setReleaseDeployPhases(List<ReleaseDeployPhase> releaseDeployPhases) {
        this.releaseDeployPhases = releaseDeployPhases;
    }

    public Author getRequestedBy() {
        return requestedBy;
    }

    public void setRequestedBy(Author requestedBy) {
        this.requestedBy = requestedBy;
    }

    public Author getRequestedFor() {
        return requestedFor;
    }

    public void setRequestedFor(Author requestedFor) {
        this.requestedFor = requestedFor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "DeploymentAttempt{" +
                "attempt=" + attempt +
                ", deploymentId=" + deploymentId +
                ", hasStarted=" + hasStarted +
                ", id=" + id +
                ", issues=" + issues +
                ", lastModifiedBy=" + lastModifiedBy +
                ", lastModifiedOn='" + lastModifiedOn + '\'' +
                ", operationStatus='" + operationStatus + '\'' +
                ", postDeploymentGates=" + postDeploymentGates +
                ", preDeploymentGates=" + preDeploymentGates +
                ", queuedOn='" + queuedOn + '\'' +
                ", reason='" + reason + '\'' +
                ", releaseDeployPhases=" + releaseDeployPhases +
                ", requestedBy=" + requestedBy +
                ", requestedFor=" + requestedFor +
                ", status='" + status + '\'' +
                '}';
    }
}
