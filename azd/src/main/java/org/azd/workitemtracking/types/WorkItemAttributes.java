package org.azd.workitemtracking.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

/***
 * Collection of link attributes.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WorkItemAttributes extends BaseAbstractMethod {
    /***
     * Is locked
     */
    @JsonProperty("isLocked")
    private boolean isLocked;
    /***
     * Comment
     */
    @JsonProperty("comment")
    private String comment;
    /***
     * Name
     */
    @JsonProperty("name")
    private String name;
    /***
     * Authorized date
     */
    @JsonProperty("authorizedDate")
    private String authorizedDate;
    /***
     * Id
     */
    @JsonProperty("id")
    private int id;
    /***
     * Creation date of the resource
     */
    @JsonProperty("resourceCreatedDate")
    private String resourceCreatedDate;
    /***
     * Revised date
     */
    @JsonProperty("revisedDate")
    private String revisedDate;
    @JsonProperty("resourceModifiedDate")
    private String resourceModifiedDate;


    public boolean isLocked() {
        return isLocked;
    }

    public void setLocked(boolean locked) {
        isLocked = locked;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthorizedDate() {
        return authorizedDate;
    }

    public void setAuthorizedDate(String authorizedDate) {
        this.authorizedDate = authorizedDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getResourceCreatedDate() {
        return resourceCreatedDate;
    }

    public void setResourceCreatedDate(String resourceCreatedDate) {
        this.resourceCreatedDate = resourceCreatedDate;
    }

    public String getResourceModifiedDate() {
        return resourceModifiedDate;
    }

    public void setResourceModifiedDate(String resourceModifiedDate) {
        this.resourceModifiedDate = resourceModifiedDate;
    }

    public String getRevisedDate() {
        return revisedDate;
    }

    public void setRevisedDate(String revisedDate) {
        this.revisedDate = revisedDate;
    }
}
