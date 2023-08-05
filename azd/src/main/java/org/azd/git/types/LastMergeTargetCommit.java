package org.azd.git.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.serializer.SerializableEntity;

/***
 * Provides properties that describe a Git commit and associated metadata.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class LastMergeTargetCommit extends SerializableEntity {
    /***
     * ID (SHA-1) of the commit.
     */
    @JsonProperty("commitId")
    private String commitId;
    /***
     * REST URL for this resource.
     */
    @JsonProperty("url")
    private String url;

    public String getCommitId() {
        return commitId;
    }

    public void setCommitId(String commitId) {
        this.commitId = commitId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
