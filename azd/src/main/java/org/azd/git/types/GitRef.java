package org.azd.git.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.Author;

/***
 * Represents a git branch reference
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GitRef {
    /***
     * Creator of the branch
     */
    @JsonProperty("creator")
    private Author creator;
    /***
     * If the branch is locked or not
     */
    @JsonProperty("isLocked")
    private boolean isLocked;
    /***
     * Branch is locked by (user reference)
     */
    @JsonProperty("isLockedBy")
    private Author isLockedBy;
    /***
     * Name of the branch
     */
    @JsonProperty("name")
    private String name;
    /***
     * Object id
     */
    @JsonProperty("objectId")
    private String objectId;
    /***
     * Branch url
     */
    @JsonProperty("url")
    private String url;

    public Author getCreator() {
        return creator;
    }

    public void setCreator(Author creator) {
        this.creator = creator;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public void setLocked(boolean locked) {
        isLocked = locked;
    }

    public Author getIsLockedBy() {
        return isLockedBy;
    }

    public void setIsLockedBy(Author isLockedBy) {
        this.isLockedBy = isLockedBy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "GitRef{" +
                "creator=" + creator +
                ", isLocked=" + isLocked +
                ", isLockedBy=" + isLockedBy +
                ", name='" + name + '\'' +
                ", objectId='" + objectId + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
