package org.azd.git.types;

/**
 * ----------------------------------------------------------
 * GENERATED FILE, should be edited to suit the purpose.
 * ----------------------------------------------------------
 **/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableCollectionEntity;

import java.util.List;

/**
 * A list of fork sync requests.
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class GitForkSyncRequests extends SerializableCollectionEntity {
    /***
     * List of fork sync requests
     */
    @JsonProperty("value")
    private List<GitForkSyncRequest> forkSyncRequest;

    public List<GitForkSyncRequest> getForkSyncRequest() {
        return forkSyncRequest;
    }

    public void setForkSyncRequest(List<GitForkSyncRequest> forkSyncRequest) {
        this.forkSyncRequest = forkSyncRequest;
    }

}
