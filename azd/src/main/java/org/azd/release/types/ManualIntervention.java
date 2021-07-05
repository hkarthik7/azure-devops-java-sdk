package org.azd.release.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.Author;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ManualIntervention {
    @JsonProperty("approver")
    private Author approver;
    @JsonProperty("comments")
    private String comments;
    @JsonProperty("createdOn")
    private String createdOn;
    @JsonProperty("id")
    private int id;
    @JsonProperty("instructions")
    private String instructions;
    @JsonProperty("modifiedOn")
    private String modifiedOn;
    @JsonProperty("name")
    private String name;
    @JsonProperty("release")
    private ReleaseShallowReference release;
    @JsonProperty("releaseDefinition")
    private ReleaseShallowReference releaseDefinition;
    @JsonProperty("releaseEnvironment")
    private ReleaseShallowReference releaseEnvironment;
    @JsonProperty("status")
    private String status;
    @JsonProperty("taskInstanceId")
    private String taskInstanceId;
    @JsonProperty("url")
    private String url;

    public Author getApprover() {
        return approver;
    }

    public void setApprover(Author approver) {
        this.approver = approver;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(String modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTaskInstanceId() {
        return taskInstanceId;
    }

    public void setTaskInstanceId(String taskInstanceId) {
        this.taskInstanceId = taskInstanceId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "ManualIntervention{" +
                "approver=" + approver +
                ", comments='" + comments + '\'' +
                ", createdOn='" + createdOn + '\'' +
                ", id=" + id +
                ", instructions='" + instructions + '\'' +
                ", modifiedOn='" + modifiedOn + '\'' +
                ", name='" + name + '\'' +
                ", release=" + release +
                ", releaseDefinition=" + releaseDefinition +
                ", releaseEnvironment=" + releaseEnvironment +
                ", status='" + status + '\'' +
                ", taskInstanceId='" + taskInstanceId + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
