package org.azd.release.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.Author;
import org.azd.common.types.BaseAbstractMethod;

/***
 * Release definition revision
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReleaseDefinitionRevision extends BaseAbstractMethod {
    /***
     * Gets api-version for revision object.
     */
    @JsonProperty("apiVersion")
    private String apiVersion;
    /***
     * Gets type of change.
     */
    @JsonProperty("changeType")
    private String changeType;
    /***
     * Gets the identity who did change.
     */
    @JsonProperty("changedBy")
    private Author changedBy;
    /***
     * Gets date on which ReleaseDefinition changed.
     */
    @JsonProperty("changedDate")
    private String changedDate;
    /***
     * Gets comments for revision.
     */
    @JsonProperty("comment")
    private String comment;
    /***
     * Get id of the definition.
     */
    @JsonProperty("definitionId")
    private int definitionId;
    /***
     * Gets definition URL.
     */
    @JsonProperty("definitionUrl")
    private String definitionUrl;
    /***
     * Get revision number of the definition.
     */
    @JsonProperty("revision")
    private int revision;

    public String getApiVersion() {
        return apiVersion;
    }

    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    public String getChangeType() {
        return changeType;
    }

    public void setChangeType(String changeType) {
        this.changeType = changeType;
    }

    public Author getChangedBy() {
        return changedBy;
    }

    public void setChangedBy(Author changedBy) {
        this.changedBy = changedBy;
    }

    public String getChangedDate() {
        return changedDate;
    }

    public void setChangedDate(String changedDate) {
        this.changedDate = changedDate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getDefinitionId() {
        return definitionId;
    }

    public void setDefinitionId(int definitionId) {
        this.definitionId = definitionId;
    }

    public String getDefinitionUrl() {
        return definitionUrl;
    }

    public void setDefinitionUrl(String definitionUrl) {
        this.definitionUrl = definitionUrl;
    }

    public int getRevision() {
        return revision;
    }

    public void setRevision(int revision) {
        this.revision = revision;
    }

}
