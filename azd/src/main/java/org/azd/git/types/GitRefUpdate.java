package org.azd.git.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/***
 * Describes a set of Git Ref operations
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GitRefUpdate {
    /***
     * If the branch is locked or not
     */
    @JsonProperty("isLocked")
    private boolean isLocked;
    /***
     * Name of the ref
     */
    @JsonProperty("name")
    private String name;
    /***
     * new Object Id
     */
    @JsonProperty("newObjectId")
    private String newObjectId;
    /***
     * old Object Id
     */
    @JsonProperty("oldObjectId")
    private String oldObjectId;
    /***
     * repository id
     */
    @JsonProperty("repositoryId")
    private String repositoryId;

    public boolean isLocked() {
        return isLocked;
    }


    public void setLocked(boolean isLocked) {
        this.isLocked = isLocked;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getNewObjectId() {
        return newObjectId;
    }


    public void setNewObjectId(String newObjectId) {
        this.newObjectId = newObjectId;
    }


    public String getOldObjectId() {
        return oldObjectId;
    }


    public void setOldObjectId(String oldObjectId) {
        this.oldObjectId = oldObjectId;
    }


    public String getRepositoryId() {
        return repositoryId;
    }


    public void setRepositoryId(String repositoryId) {
        this.repositoryId = repositoryId;
    }

    @Override
    public String toString() {
        return "GitRefUpdate{" +
                "isLocked=" + isLocked +
                ", name='" + name + '\'' +
                ", newObjectId='" + newObjectId + '\'' +
                ", oldObjectId='" + oldObjectId + '\'' +
                ", repositoryId='" + repositoryId + '\'' +
                '}';
    }

}
