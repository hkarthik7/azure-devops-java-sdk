package org.azd.git.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Git object identifier and type information.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GitObject {
    /**
     * Object Id (Sha1Id).
     */
    @JsonProperty("objectId")
    private String objectId;
    /**
     * Type of object (Commit, Tree, Blob, Tag)
     */
    @JsonProperty("objectType")
    private String objectType;

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getObjectType() {
        return objectType;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    @Override
    public String toString() {
        return "GitObject{" +
                "objectId='" + objectId + '\'' +
                ", objectType='" + objectType + '\'' +
                '}';
    }
}
