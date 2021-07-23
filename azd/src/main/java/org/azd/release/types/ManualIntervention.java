package org.azd.release.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.Author;

/***
 * Represents Manual intervention
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ManualIntervention {
    /***
     * Gets or sets the identity who should approve.
     */
    @JsonProperty("approver")
    private Author approver;
    /***
     * Gets or sets comments for approval.
     */
    @JsonProperty("comments")
    private String comments;
    /***
     * Gets date on which it got created.
     */
    @JsonProperty("createdOn")
    private String createdOn;
    /***
     * Gets the unique identifier for manual intervention.
     */
    @JsonProperty("id")
    private int id;
    /***
     * Gets or sets instructions for approval.
     */
    @JsonProperty("instructions")
    private String instructions;
    /***
     * Gets date on which it got modified.
     */
    @JsonProperty("modifiedOn")
    private String modifiedOn;
    /***
     * Gets or sets the name.
     */
    @JsonProperty("name")
    private String name;
    /***
     * Gets releaseReference for manual intervention.
     */
    @JsonProperty("release")
    private ReleaseShallowReference release;
    /***
     * Gets releaseDefinitionReference for manual intervention.
     */
    @JsonProperty("releaseDefinition")
    private ReleaseShallowReference releaseDefinition;
    /***
     * Gets releaseEnvironmentReference for manual intervention.
     */
    @JsonProperty("releaseEnvironment")
    private ReleaseShallowReference releaseEnvironment;
    /***
     * Gets or sets the status of the manual intervention.
     */
    @JsonProperty("status")
    private String status;
    /***
     * Get task instance identifier.
     */
    @JsonProperty("taskInstanceId")
    private String taskInstanceId;
    /***
     * Gets url to access the manual intervention.
     */
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
