package org.azd.build.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.Author;
import org.azd.common.types.BaseAbstractMethod;

/***
 * Represents a revision of a build definition.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class BuildDefinitionRevision extends BaseAbstractMethod {
    /***
     * The revision number.
     */
    @JsonProperty("revision")
    private int revision;
    /***
     * The name of the definition.
     */
    @JsonProperty("name")
    private String name;
    /***
     * The date and time that the definition was changed.
     */
    @JsonProperty("changedDate")
    private String changedDate;
    /***
     * The change type (add, edit, delete).
     */
    @JsonProperty("changeType")
    private String changeType;
    /***
     * A link to the definition at this revision.
     */
    @JsonProperty("definitionUrl")
    private String definitionUrl;
    /***
     * The identity of the person or process that changed the definition.
     */
    @JsonProperty("changedBy")
    private Author changedBy;

    public int getRevision() {
        return revision;
    }

    public void setRevision(int revision) {
        this.revision = revision;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getChangedDate() {
        return changedDate;
    }

    public void setChangedDate(String changedDate) {
        this.changedDate = changedDate;
    }

    public String getChangeType() {
        return changeType;
    }

    public void setChangeType(String changeType) {
        this.changeType = changeType;
    }

    public String getDefinitionUrl() {
        return definitionUrl;
    }

    public void setDefinitionUrl(String definitionUrl) {
        this.definitionUrl = definitionUrl;
    }

    public Author getChangedBy() {
        return changedBy;
    }

    public void setChangedBy(Author changedBy) {
        this.changedBy = changedBy;
    }

}
